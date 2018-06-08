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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tieba.d;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private List<EmotionImageData> cUF;
    private EmotionView.a fDu;
    private int fEx;
    private PbEmotionBar.a fEy;
    private Set<String> fjh = new HashSet();

    @Override // android.widget.Adapter
    public int getCount() {
        if (w.z(this.cUF)) {
            return 0;
        }
        return this.cUF.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.cUF = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0211a c0211a;
        if (view == null) {
            c0211a = new C0211a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.list_item_pb_emotion_bar, (ViewGroup) null);
            c0211a.fjp = (EmotionView) view.findViewById(d.g.iv_emotion);
            c0211a.fjp.apH();
            c0211a.fjp.setController(this.fDu);
            c0211a.fjp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.fEy != null && (view2 instanceof EmotionView)) {
                        a.this.fEy.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0211a.dqs = (TextView) view.findViewById(d.g.tv_more);
            al.h(c0211a.dqs, d.C0141d.cp_cont_d);
            c0211a.dqs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.fEy != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!w.z(a.this.cUF)) {
                            for (EmotionImageData emotionImageData : a.this.cUF) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.fEy.a(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0211a);
        } else {
            c0211a = (C0211a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.cUF.size()) {
                c0211a.fjp.getLayoutParams().width = this.fEx;
                c0211a.fjp.getLayoutParams().height = this.fEx;
                c0211a.fjp.reset();
                c0211a.fjp.setTag(d.g.iv_emotion, null);
                EmotionImageData emotionImageData = this.cUF.get(i);
                if (emotionImageData != null) {
                    c0211a.fjp.a(emotionImageData);
                    if (this.fjh != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.fjh.add(emotionImageData.getThumbUrl() + c0211a.fjp.getLoadProcType());
                    }
                }
                c0211a.fjp.setVisibility(0);
                c0211a.dqs.setVisibility(8);
            } else if (i == this.cUF.size()) {
                c0211a.dqs.getLayoutParams().width = this.fEx;
                c0211a.dqs.getLayoutParams().height = this.fEx;
                c0211a.fjp.setVisibility(8);
                c0211a.dqs.setVisibility(0);
            }
        }
        return view;
    }

    public void qM(int i) {
        if (this.fEx != i) {
            this.fEx = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.fDu = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.fEy = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0211a {
        TextView dqs;
        EmotionView fjp;

        C0211a() {
        }
    }

    public void aYJ() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.fjh != null) {
                    for (String str : a.this.fjh) {
                        if (!TextUtils.isEmpty(str)) {
                            c.ID().hc(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
