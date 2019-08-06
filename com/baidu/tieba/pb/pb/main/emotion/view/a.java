package com.baidu.tieba.pb.pb.main.emotion.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private List<EmotionImageData> fdj;
    private Set<String> hCI = new HashSet();
    private EmotionView.a hXD;
    private int hYG;
    private PbEmotionBar.a hYH;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.aa(this.fdj)) {
            return 0;
        }
        return this.fdj.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.fdj = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0384a c0384a;
        if (view == null) {
            c0384a = new C0384a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pb_emotion_bar, (ViewGroup) null);
            c0384a.hCQ = (EmotionView) view.findViewById(R.id.iv_emotion);
            c0384a.hCQ.bhp();
            c0384a.hCQ.setController(this.hXD);
            c0384a.hCQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.hYH != null && (view2 instanceof EmotionView)) {
                        a.this.hYH.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0384a.fFw = (TextView) view.findViewById(R.id.tv_more);
            am.j(c0384a.fFw, R.color.cp_cont_d);
            c0384a.fFw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.hYH != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.aa(a.this.fdj)) {
                            for (EmotionImageData emotionImageData : a.this.fdj) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.hYH.b(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0384a);
        } else {
            c0384a = (C0384a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.fdj.size()) {
                c0384a.hCQ.getLayoutParams().width = this.hYG;
                c0384a.hCQ.getLayoutParams().height = this.hYG;
                c0384a.hCQ.reset();
                c0384a.hCQ.setTag(R.id.iv_emotion, null);
                EmotionImageData emotionImageData = this.fdj.get(i);
                if (emotionImageData != null) {
                    c0384a.hCQ.a(emotionImageData);
                    if (this.hCI != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.hCI.add(emotionImageData.getThumbUrl() + c0384a.hCQ.getLoadProcType());
                    }
                }
                c0384a.hCQ.setVisibility(0);
                c0384a.fFw.setVisibility(8);
            } else if (i == this.fdj.size()) {
                c0384a.fFw.getLayoutParams().width = this.hYG;
                c0384a.fFw.getLayoutParams().height = this.hYG;
                c0384a.hCQ.setVisibility(8);
                c0384a.fFw.setVisibility(0);
            }
        }
        return view;
    }

    public void yl(int i) {
        if (this.hYG != i) {
            this.hYG = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.hXD = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.hYH = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static class C0384a {
        TextView fFw;
        EmotionView hCQ;

        C0384a() {
        }
    }

    public void bQT() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.hCI != null) {
                    for (String str : a.this.hCI) {
                        if (!TextUtils.isEmpty(str)) {
                            c.aty().qF(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
