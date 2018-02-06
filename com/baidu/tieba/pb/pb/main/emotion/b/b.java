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
    private List<EmotionImageData> drN;
    private Set<String> fBU = new HashSet();
    private EmotionView.a fWO;
    private int fXR;
    private a.InterfaceC0210a fXS;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.E(this.drN)) {
            return 0;
        }
        return this.drN.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.drN = list;
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
            aVar.fCc = (EmotionView) view.findViewById(d.g.iv_emotion);
            aVar.fCc.arl();
            aVar.fCc.setController(this.fWO);
            aVar.fCc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fXS != null && (view2 instanceof EmotionView)) {
                        b.this.fXS.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            aVar.dNz = (TextView) view.findViewById(d.g.tv_more);
            aj.r(aVar.dNz, d.C0140d.cp_cont_d);
            aVar.dNz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fXS != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.E(b.this.drN)) {
                            for (EmotionImageData emotionImageData : b.this.drN) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        b.this.fXS.a(null, null, arrayList);
                    }
                }
            });
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.drN.size()) {
                aVar.fCc.getLayoutParams().width = this.fXR;
                aVar.fCc.getLayoutParams().height = this.fXR;
                aVar.fCc.reset();
                aVar.fCc.setTag(d.g.iv_emotion, null);
                EmotionImageData emotionImageData = this.drN.get(i);
                if (emotionImageData != null) {
                    aVar.fCc.a(emotionImageData);
                    if (this.fBU != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.fBU.add(emotionImageData.getThumbUrl() + aVar.fCc.getLoadProcType());
                    }
                }
                aVar.fCc.setVisibility(0);
                aVar.dNz.setVisibility(8);
            } else if (i == this.drN.size()) {
                aVar.dNz.getLayoutParams().width = this.fXR;
                aVar.dNz.getLayoutParams().height = this.fXR;
                aVar.fCc.setVisibility(8);
                aVar.dNz.setVisibility(0);
            }
        }
        return view;
    }

    public void tf(int i) {
        if (this.fXR != i) {
            this.fXR = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.fWO = aVar;
    }

    public void a(a.InterfaceC0210a interfaceC0210a) {
        this.fXS = interfaceC0210a;
    }

    /* loaded from: classes2.dex */
    class a {
        TextView dNz;
        EmotionView fCc;

        a() {
        }
    }

    public void aYS() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.b.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (b.this.fBU != null) {
                    for (String str : b.this.fBU) {
                        if (!TextUtils.isEmpty(str)) {
                            com.baidu.tbadk.imageManager.c.Mx().gN(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
