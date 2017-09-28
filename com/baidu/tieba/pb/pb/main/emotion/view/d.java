package com.baidu.tieba.pb.pb.main.emotion.view;

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
import com.baidu.tieba.pb.pb.main.emotion.view.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class d extends BaseAdapter {
    private List<EmotionImageData> cfa;
    private EmotionView.a eMn;
    private int eOV;
    private c.a eOW;
    private Set<String> eus = new HashSet();

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.u(this.cfa)) {
            return 0;
        }
        return this.cfa.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.cfa = list;
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.j.list_item_pb_emotion_bar, (ViewGroup) null);
            aVar.euA = (EmotionView) view.findViewById(d.h.iv_emotion);
            aVar.euA.adE();
            aVar.euA.setController(this.eMn);
            aVar.euA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.eOW != null && (view2 instanceof EmotionView)) {
                        d.this.eOW.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            aVar.czs = (TextView) view.findViewById(d.h.tv_more);
            aj.i(aVar.czs, d.e.cp_cont_d);
            aVar.czs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.eOW != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.u(d.this.cfa)) {
                            for (EmotionImageData emotionImageData : d.this.cfa) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        d.this.eOW.a(null, null, arrayList);
                    }
                }
            });
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.cfa.size()) {
                aVar.euA.getLayoutParams().width = this.eOV;
                aVar.euA.getLayoutParams().height = this.eOV;
                aVar.euA.reset();
                aVar.euA.setTag(d.h.iv_emotion, null);
                EmotionImageData emotionImageData = this.cfa.get(i);
                if (emotionImageData != null) {
                    aVar.euA.a(emotionImageData);
                    if (this.eus != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.eus.add(emotionImageData.getThumbUrl() + aVar.euA.getLoadProcType());
                    }
                }
                aVar.euA.setVisibility(0);
                aVar.czs.setVisibility(8);
            } else if (i == this.cfa.size()) {
                aVar.czs.getLayoutParams().width = this.eOV;
                aVar.czs.getLayoutParams().height = this.eOV;
                aVar.euA.setVisibility(8);
                aVar.czs.setVisibility(0);
            }
        }
        return view;
    }

    public void pD(int i) {
        if (this.eOV != i) {
            this.eOV = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.eMn = aVar;
    }

    public void a(c.a aVar) {
        this.eOW = aVar;
    }

    /* loaded from: classes.dex */
    class a {
        TextView czs;
        EmotionView euA;

        a() {
        }
    }

    public void aLV() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.d.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: a */
            public Boolean doInBackground(Void... voidArr) {
                if (d.this.eus != null) {
                    for (String str : d.this.eus) {
                        if (!TextUtils.isEmpty(str)) {
                            com.baidu.tbadk.imageManager.c.DZ().gg(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
