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
    private List<EmotionImageData> doU;
    private EmotionView.a fTC;
    private int fUF;
    private a.InterfaceC0142a fUG;
    private Set<String> fyu = new HashSet();

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.E(this.doU)) {
            return 0;
        }
        return this.doU.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.doU = list;
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
            aVar.fyC = (EmotionView) view.findViewById(d.g.iv_emotion);
            aVar.fyC.aqv();
            aVar.fyC.setController(this.fTC);
            aVar.fyC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fUG != null && (view2 instanceof EmotionView)) {
                        b.this.fUG.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            aVar.dKA = (TextView) view.findViewById(d.g.tv_more);
            aj.r(aVar.dKA, d.C0108d.cp_cont_d);
            aVar.dKA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fUG != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.E(b.this.doU)) {
                            for (EmotionImageData emotionImageData : b.this.doU) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        b.this.fUG.a(null, null, arrayList);
                    }
                }
            });
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.doU.size()) {
                aVar.fyC.getLayoutParams().width = this.fUF;
                aVar.fyC.getLayoutParams().height = this.fUF;
                aVar.fyC.reset();
                aVar.fyC.setTag(d.g.iv_emotion, null);
                EmotionImageData emotionImageData = this.doU.get(i);
                if (emotionImageData != null) {
                    aVar.fyC.a(emotionImageData);
                    if (this.fyu != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.fyu.add(emotionImageData.getThumbUrl() + aVar.fyC.getLoadProcType());
                    }
                }
                aVar.fyC.setVisibility(0);
                aVar.dKA.setVisibility(8);
            } else if (i == this.doU.size()) {
                aVar.dKA.getLayoutParams().width = this.fUF;
                aVar.dKA.getLayoutParams().height = this.fUF;
                aVar.fyC.setVisibility(8);
                aVar.dKA.setVisibility(0);
            }
        }
        return view;
    }

    public void tb(int i) {
        if (this.fUF != i) {
            this.fUF = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.fTC = aVar;
    }

    public void a(a.InterfaceC0142a interfaceC0142a) {
        this.fUG = interfaceC0142a;
    }

    /* loaded from: classes2.dex */
    class a {
        TextView dKA;
        EmotionView fyC;

        a() {
        }
    }

    public void aXj() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.b.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (b.this.fyu != null) {
                    for (String str : b.this.fyu) {
                        if (!TextUtils.isEmpty(str)) {
                            com.baidu.tbadk.imageManager.c.LR().gE(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
