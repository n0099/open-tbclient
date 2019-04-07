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
    private List<EmotionImageData> eHx;
    private Set<String> heh = new HashSet();
    private EmotionView.a hyF;
    private int hzI;
    private PbEmotionBar.a hzJ;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.T(this.eHx)) {
            return 0;
        }
        return this.eHx.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.eHx = list;
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
            c0360a.hep = (EmotionView) view.findViewById(d.g.iv_emotion);
            c0360a.hep.aXI();
            c0360a.hep.setController(this.hyF);
            c0360a.hep.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.hzJ != null && (view2 instanceof EmotionView)) {
                        a.this.hzJ.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0360a.fjo = (TextView) view.findViewById(d.g.tv_more);
            al.j(c0360a.fjo, d.C0277d.cp_cont_d);
            c0360a.fjo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.hzJ != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.T(a.this.eHx)) {
                            for (EmotionImageData emotionImageData : a.this.eHx) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.hzJ.b(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0360a);
        } else {
            c0360a = (C0360a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.eHx.size()) {
                c0360a.hep.getLayoutParams().width = this.hzI;
                c0360a.hep.getLayoutParams().height = this.hzI;
                c0360a.hep.reset();
                c0360a.hep.setTag(d.g.iv_emotion, null);
                EmotionImageData emotionImageData = this.eHx.get(i);
                if (emotionImageData != null) {
                    c0360a.hep.a(emotionImageData);
                    if (this.heh != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.heh.add(emotionImageData.getThumbUrl() + c0360a.hep.getLoadProcType());
                    }
                }
                c0360a.hep.setVisibility(0);
                c0360a.fjo.setVisibility(8);
            } else if (i == this.eHx.size()) {
                c0360a.fjo.getLayoutParams().width = this.hzI;
                c0360a.fjo.getLayoutParams().height = this.hzI;
                c0360a.hep.setVisibility(8);
                c0360a.fjo.setVisibility(0);
            }
        }
        return view;
    }

    public void wz(int i) {
        if (this.hzI != i) {
            this.hzI = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.hyF = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.hzJ = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static class C0360a {
        TextView fjo;
        EmotionView hep;

        C0360a() {
        }
    }

    public void bGi() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.heh != null) {
                    for (String str : a.this.heh) {
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
