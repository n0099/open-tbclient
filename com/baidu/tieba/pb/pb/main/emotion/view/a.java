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
    private List<EmotionImageData> cSH;
    private EmotionView.a fHv;
    private int fIy;
    private PbEmotionBar.a fIz;
    private Set<String> fnd = new HashSet();

    @Override // android.widget.Adapter
    public int getCount() {
        if (w.A(this.cSH)) {
            return 0;
        }
        return this.cSH.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.cSH = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0213a c0213a;
        if (view == null) {
            c0213a = new C0213a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.list_item_pb_emotion_bar, (ViewGroup) null);
            c0213a.fnl = (EmotionView) view.findViewById(d.g.iv_emotion);
            c0213a.fnl.apb();
            c0213a.fnl.setController(this.fHv);
            c0213a.fnl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.fIz != null && (view2 instanceof EmotionView)) {
                        a.this.fIz.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0213a.dtB = (TextView) view.findViewById(d.g.tv_more);
            am.h(c0213a.dtB, d.C0142d.cp_cont_d);
            c0213a.dtB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.fIz != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!w.A(a.this.cSH)) {
                            for (EmotionImageData emotionImageData : a.this.cSH) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.fIz.a(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0213a);
        } else {
            c0213a = (C0213a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.cSH.size()) {
                c0213a.fnl.getLayoutParams().width = this.fIy;
                c0213a.fnl.getLayoutParams().height = this.fIy;
                c0213a.fnl.reset();
                c0213a.fnl.setTag(d.g.iv_emotion, null);
                EmotionImageData emotionImageData = this.cSH.get(i);
                if (emotionImageData != null) {
                    c0213a.fnl.a(emotionImageData);
                    if (this.fnd != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.fnd.add(emotionImageData.getThumbUrl() + c0213a.fnl.getLoadProcType());
                    }
                }
                c0213a.fnl.setVisibility(0);
                c0213a.dtB.setVisibility(8);
            } else if (i == this.cSH.size()) {
                c0213a.dtB.getLayoutParams().width = this.fIy;
                c0213a.dtB.getLayoutParams().height = this.fIy;
                c0213a.fnl.setVisibility(8);
                c0213a.dtB.setVisibility(0);
            }
        }
        return view;
    }

    public void qU(int i) {
        if (this.fIy != i) {
            this.fIy = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.fHv = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.fIz = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0213a {
        TextView dtB;
        EmotionView fnl;

        C0213a() {
        }
    }

    public void aZq() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.fnd != null) {
                    for (String str : a.this.fnd) {
                        if (!TextUtils.isEmpty(str)) {
                            c.IV().hg(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
