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
    private List<EmotionImageData> eHy;
    private Set<String> hei = new HashSet();
    private EmotionView.a hyG;
    private int hzJ;
    private PbEmotionBar.a hzK;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.T(this.eHy)) {
            return 0;
        }
        return this.eHy.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.eHy = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0360a c0360a;
        if (view == null) {
            c0360a = new C0360a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.list_item_pb_emotion_bar, (ViewGroup) null);
            c0360a.heq = (EmotionView) view.findViewById(d.g.iv_emotion);
            c0360a.heq.aXI();
            c0360a.heq.setController(this.hyG);
            c0360a.heq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.hzK != null && (view2 instanceof EmotionView)) {
                        a.this.hzK.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0360a.fjo = (TextView) view.findViewById(d.g.tv_more);
            al.j(c0360a.fjo, d.C0277d.cp_cont_d);
            c0360a.fjo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.hzK != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.T(a.this.eHy)) {
                            for (EmotionImageData emotionImageData : a.this.eHy) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.hzK.b(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0360a);
        } else {
            c0360a = (C0360a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.eHy.size()) {
                c0360a.heq.getLayoutParams().width = this.hzJ;
                c0360a.heq.getLayoutParams().height = this.hzJ;
                c0360a.heq.reset();
                c0360a.heq.setTag(d.g.iv_emotion, null);
                EmotionImageData emotionImageData = this.eHy.get(i);
                if (emotionImageData != null) {
                    c0360a.heq.a(emotionImageData);
                    if (this.hei != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.hei.add(emotionImageData.getThumbUrl() + c0360a.heq.getLoadProcType());
                    }
                }
                c0360a.heq.setVisibility(0);
                c0360a.fjo.setVisibility(8);
            } else if (i == this.eHy.size()) {
                c0360a.fjo.getLayoutParams().width = this.hzJ;
                c0360a.fjo.getLayoutParams().height = this.hzJ;
                c0360a.heq.setVisibility(8);
                c0360a.fjo.setVisibility(0);
            }
        }
        return view;
    }

    public void wz(int i) {
        if (this.hzJ != i) {
            this.hzJ = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.hyG = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.hzK = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static class C0360a {
        TextView fjo;
        EmotionView heq;

        C0360a() {
        }
    }

    public void bGi() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.hei != null) {
                    for (String str : a.this.hei) {
                        if (!TextUtils.isEmpty(str)) {
                            c.anm().ph(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
