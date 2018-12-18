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
import com.baidu.tieba.e;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    private List<EmotionImageData> dra;
    private Set<String> fKw = new HashSet();
    private EmotionView.a gfa;
    private int ggd;
    private PbEmotionBar.a gge;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.I(this.dra)) {
            return 0;
        }
        return this.dra.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.dra = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0289a c0289a;
        if (view == null) {
            c0289a = new C0289a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(e.h.list_item_pb_emotion_bar, (ViewGroup) null);
            c0289a.fKE = (EmotionView) view.findViewById(e.g.iv_emotion);
            c0289a.fKE.avW();
            c0289a.fKE.setController(this.gfa);
            c0289a.fKE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.gge != null && (view2 instanceof EmotionView)) {
                        a.this.gge.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0289a.dSC = (TextView) view.findViewById(e.g.tv_more);
            al.h(c0289a.dSC, e.d.cp_cont_d);
            c0289a.dSC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.gge != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.I(a.this.dra)) {
                            for (EmotionImageData emotionImageData : a.this.dra) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.gge.a(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0289a);
        } else {
            c0289a = (C0289a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.dra.size()) {
                c0289a.fKE.getLayoutParams().width = this.ggd;
                c0289a.fKE.getLayoutParams().height = this.ggd;
                c0289a.fKE.reset();
                c0289a.fKE.setTag(e.g.iv_emotion, null);
                EmotionImageData emotionImageData = this.dra.get(i);
                if (emotionImageData != null) {
                    c0289a.fKE.a(emotionImageData);
                    if (this.fKw != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.fKw.add(emotionImageData.getThumbUrl() + c0289a.fKE.getLoadProcType());
                    }
                }
                c0289a.fKE.setVisibility(0);
                c0289a.dSC.setVisibility(8);
            } else if (i == this.dra.size()) {
                c0289a.dSC.getLayoutParams().width = this.ggd;
                c0289a.dSC.getLayoutParams().height = this.ggd;
                c0289a.fKE.setVisibility(8);
                c0289a.dSC.setVisibility(0);
            }
        }
        return view;
    }

    public void sC(int i) {
        if (this.ggd != i) {
            this.ggd = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.gfa = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.gge = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static class C0289a {
        TextView dSC;
        EmotionView fKE;

        C0289a() {
        }
    }

    public void bew() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.fKw != null) {
                    for (String str : a.this.fKw) {
                        if (!TextUtils.isEmpty(str)) {
                            c.Nu().m17if(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
