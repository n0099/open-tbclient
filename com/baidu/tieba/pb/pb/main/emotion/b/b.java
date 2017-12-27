package com.baidu.tieba.pb.pb.main.emotion.b;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.pb.pb.main.emotion.b.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    private List<EmotionImageData> djY;
    private EmotionView.a fRH;
    private int fSK;
    private a.InterfaceC0142a fSL;
    private Set<String> fwz = new HashSet();

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.G(this.djY)) {
            return 0;
        }
        return this.djY.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.djY = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.list_item_pb_emotion_bar, (ViewGroup) null);
            aVar.fwH = (EmotionView) view.findViewById(d.g.iv_emotion);
            aVar.fwH.apn();
            aVar.fwH.setController(this.fRH);
            aVar.fwH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fSL != null && (view2 instanceof EmotionView)) {
                        b.this.fSL.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            aVar.dFE = (TextView) view.findViewById(d.g.tv_more);
            aj.r(aVar.dFE, d.C0108d.cp_cont_d);
            aVar.dFE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fSL != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.G(b.this.djY)) {
                            for (EmotionImageData emotionImageData : b.this.djY) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        b.this.fSL.a(null, null, arrayList);
                    }
                }
            });
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.djY.size()) {
                aVar.fwH.getLayoutParams().width = this.fSK;
                aVar.fwH.getLayoutParams().height = this.fSK;
                aVar.fwH.reset();
                aVar.fwH.setTag(d.g.iv_emotion, null);
                EmotionImageData emotionImageData = this.djY.get(i);
                if (emotionImageData != null) {
                    aVar.fwH.a(emotionImageData);
                    if (this.fwz != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.fwz.add(emotionImageData.getThumbUrl() + aVar.fwH.getLoadProcType());
                    }
                }
                aVar.fwH.setVisibility(0);
                aVar.dFE.setVisibility(8);
            } else if (i == this.djY.size()) {
                aVar.dFE.getLayoutParams().width = this.fSK;
                aVar.dFE.getLayoutParams().height = this.fSK;
                aVar.fwH.setVisibility(8);
                aVar.dFE.setVisibility(0);
            }
        }
        return view;
    }

    public void tj(int i) {
        if (this.fSK != i) {
            this.fSK = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.fRH = aVar;
    }

    public void a(a.InterfaceC0142a interfaceC0142a) {
        this.fSL = interfaceC0142a;
    }

    /* loaded from: classes2.dex */
    class a {
        TextView dFE;
        EmotionView fwH;

        a() {
        }
    }

    public void aWZ() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.b.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (b.this.fwz != null) {
                    for (String str : b.this.fwz) {
                        if (!TextUtils.isEmpty(str)) {
                            com.baidu.tbadk.imageManager.c.Mb().gv(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
