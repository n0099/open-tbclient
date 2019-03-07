package com.baidu.tieba.pb.pb.main.emotion.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tieba.d;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private List<EmotionImageData> eHP;
    private int hAb;
    private PbEmotionBar.a hAc;
    private Set<String> heu = new HashSet();
    private EmotionView.a hyY;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.T(this.eHP)) {
            return 0;
        }
        return this.eHP.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.eHP = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0287a c0287a;
        if (view == null) {
            c0287a = new C0287a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.list_item_pb_emotion_bar, (ViewGroup) null);
            c0287a.heC = (EmotionView) view.findViewById(d.g.iv_emotion);
            c0287a.heC.aXL();
            c0287a.heC.setController(this.hyY);
            c0287a.heC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.hAc != null && (view2 instanceof EmotionView)) {
                        a.this.hAc.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0287a.fjD = (TextView) view.findViewById(d.g.tv_more);
            al.j(c0287a.fjD, d.C0236d.cp_cont_d);
            c0287a.fjD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.hAc != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.T(a.this.eHP)) {
                            for (EmotionImageData emotionImageData : a.this.eHP) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.hAc.b(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0287a);
        } else {
            c0287a = (C0287a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.eHP.size()) {
                c0287a.heC.getLayoutParams().width = this.hAb;
                c0287a.heC.getLayoutParams().height = this.hAb;
                c0287a.heC.reset();
                c0287a.heC.setTag(d.g.iv_emotion, null);
                EmotionImageData emotionImageData = this.eHP.get(i);
                if (emotionImageData != null) {
                    c0287a.heC.a(emotionImageData);
                    if (this.heu != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.heu.add(emotionImageData.getThumbUrl() + c0287a.heC.getLoadProcType());
                    }
                }
                c0287a.heC.setVisibility(0);
                c0287a.fjD.setVisibility(8);
            } else if (i == this.eHP.size()) {
                c0287a.fjD.getLayoutParams().width = this.hAb;
                c0287a.fjD.getLayoutParams().height = this.hAb;
                c0287a.heC.setVisibility(8);
                c0287a.fjD.setVisibility(0);
            }
        }
        return view;
    }

    public void wD(int i) {
        if (this.hAb != i) {
            this.hAb = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.hyY = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.hAc = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static class C0287a {
        TextView fjD;
        EmotionView heC;

        C0287a() {
        }
    }

    public void bGl() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.heu != null) {
                    for (String str : a.this.heu) {
                        if (!TextUtils.isEmpty(str)) {
                            c.anq().pg(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
