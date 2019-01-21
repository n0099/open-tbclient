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
    private List<EmotionImageData> duy;
    private Set<String> fOj = new HashSet();
    private EmotionView.a giX;
    private int gka;
    private PbEmotionBar.a gkb;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.I(this.duy)) {
            return 0;
        }
        return this.duy.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.duy = list;
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
            c0289a.fOr = (EmotionView) view.findViewById(e.g.iv_emotion);
            c0289a.fOr.axi();
            c0289a.fOr.setController(this.giX);
            c0289a.fOr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.gkb != null && (view2 instanceof EmotionView)) {
                        a.this.gkb.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0289a.dWa = (TextView) view.findViewById(e.g.tv_more);
            al.h(c0289a.dWa, e.d.cp_cont_d);
            c0289a.dWa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.gkb != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.I(a.this.duy)) {
                            for (EmotionImageData emotionImageData : a.this.duy) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.gkb.a(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0289a);
        } else {
            c0289a = (C0289a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.duy.size()) {
                c0289a.fOr.getLayoutParams().width = this.gka;
                c0289a.fOr.getLayoutParams().height = this.gka;
                c0289a.fOr.reset();
                c0289a.fOr.setTag(e.g.iv_emotion, null);
                EmotionImageData emotionImageData = this.duy.get(i);
                if (emotionImageData != null) {
                    c0289a.fOr.a(emotionImageData);
                    if (this.fOj != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.fOj.add(emotionImageData.getThumbUrl() + c0289a.fOr.getLoadProcType());
                    }
                }
                c0289a.fOr.setVisibility(0);
                c0289a.dWa.setVisibility(8);
            } else if (i == this.duy.size()) {
                c0289a.dWa.getLayoutParams().width = this.gka;
                c0289a.dWa.getLayoutParams().height = this.gka;
                c0289a.fOr.setVisibility(8);
                c0289a.dWa.setVisibility(0);
            }
        }
        return view;
    }

    public void sT(int i) {
        if (this.gka != i) {
            this.gka = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.giX = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.gkb = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static class C0289a {
        TextView dWa;
        EmotionView fOr;

        C0289a() {
        }
    }

    public void bfI() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.fOj != null) {
                    for (String str : a.this.fOj) {
                        if (!TextUtils.isEmpty(str)) {
                            c.NM().iu(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }
}
