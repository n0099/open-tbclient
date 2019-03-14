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
    private List<EmotionImageData> eHL;
    private Set<String> heu = new HashSet();
    private EmotionView.a hyT;
    private int hzW;
    private PbEmotionBar.a hzX;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.T(this.eHL)) {
            return 0;
        }
        return this.eHL.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.eHL = list;
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
            c0360a.heC = (EmotionView) view.findViewById(d.g.iv_emotion);
            c0360a.heC.aXL();
            c0360a.heC.setController(this.hyT);
            c0360a.heC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.hzX != null && (view2 instanceof EmotionView)) {
                        a.this.hzX.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0360a.fjC = (TextView) view.findViewById(d.g.tv_more);
            al.j(c0360a.fjC, d.C0277d.cp_cont_d);
            c0360a.fjC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.hzX != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.T(a.this.eHL)) {
                            for (EmotionImageData emotionImageData : a.this.eHL) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.hzX.b(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0360a);
        } else {
            c0360a = (C0360a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.eHL.size()) {
                c0360a.heC.getLayoutParams().width = this.hzW;
                c0360a.heC.getLayoutParams().height = this.hzW;
                c0360a.heC.reset();
                c0360a.heC.setTag(d.g.iv_emotion, null);
                EmotionImageData emotionImageData = this.eHL.get(i);
                if (emotionImageData != null) {
                    c0360a.heC.a(emotionImageData);
                    if (this.heu != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.heu.add(emotionImageData.getThumbUrl() + c0360a.heC.getLoadProcType());
                    }
                }
                c0360a.heC.setVisibility(0);
                c0360a.fjC.setVisibility(8);
            } else if (i == this.eHL.size()) {
                c0360a.fjC.getLayoutParams().width = this.hzW;
                c0360a.fjC.getLayoutParams().height = this.hzW;
                c0360a.heC.setVisibility(8);
                c0360a.fjC.setVisibility(0);
            }
        }
        return view;
    }

    public void wD(int i) {
        if (this.hzW != i) {
            this.hzW = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.hyT = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.hzX = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static class C0360a {
        TextView fjC;
        EmotionView heC;

        C0360a() {
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
                            c.anp().pg(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
