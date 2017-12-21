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
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private List<EmotionImageData> cvC;
    private Set<String> eKd = new HashSet();
    private EmotionView.a feO;
    private int ffP;
    private a.InterfaceC0130a ffQ;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.w(this.cvC)) {
            return 0;
        }
        return this.cvC.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.cvC = list;
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
            aVar.eKl = (EmotionView) view.findViewById(d.g.iv_emotion);
            aVar.eKl.ahN();
            aVar.eKl.setController(this.feO);
            aVar.eKl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.ffQ != null && (view2 instanceof EmotionView)) {
                        b.this.ffQ.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            aVar.cQN = (TextView) view.findViewById(d.g.tv_more);
            aj.i(aVar.cQN, d.C0095d.cp_cont_d);
            aVar.cQN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.ffQ != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.w(b.this.cvC)) {
                            for (EmotionImageData emotionImageData : b.this.cvC) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        b.this.ffQ.a(null, null, arrayList);
                    }
                }
            });
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.cvC.size()) {
                aVar.eKl.getLayoutParams().width = this.ffP;
                aVar.eKl.getLayoutParams().height = this.ffP;
                aVar.eKl.reset();
                aVar.eKl.setTag(d.g.iv_emotion, null);
                EmotionImageData emotionImageData = this.cvC.get(i);
                if (emotionImageData != null) {
                    aVar.eKl.a(emotionImageData);
                    if (this.eKd != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.eKd.add(emotionImageData.getThumbUrl() + aVar.eKl.getLoadProcType());
                    }
                }
                aVar.eKl.setVisibility(0);
                aVar.cQN.setVisibility(8);
            } else if (i == this.cvC.size()) {
                aVar.cQN.getLayoutParams().width = this.ffP;
                aVar.cQN.getLayoutParams().height = this.ffP;
                aVar.eKl.setVisibility(8);
                aVar.cQN.setVisibility(0);
            }
        }
        return view;
    }

    public void qp(int i) {
        if (this.ffP != i) {
            this.ffP = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.feO = aVar;
    }

    public void a(a.InterfaceC0130a interfaceC0130a) {
        this.ffQ = interfaceC0130a;
    }

    /* loaded from: classes.dex */
    class a {
        TextView cQN;
        EmotionView eKl;

        a() {
        }
    }

    public void aPP() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.b.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (b.this.eKd != null) {
                    for (String str : b.this.eKd) {
                        if (!TextUtils.isEmpty(str)) {
                            com.baidu.tbadk.imageManager.c.EA().gp(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
