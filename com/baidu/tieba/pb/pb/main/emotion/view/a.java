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
    private List<EmotionImageData> dux;
    private Set<String> fOi = new HashSet();
    private EmotionView.a giW;
    private int gjZ;
    private PbEmotionBar.a gka;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.I(this.dux)) {
            return 0;
        }
        return this.dux.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.dux = list;
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
            c0289a.fOq = (EmotionView) view.findViewById(e.g.iv_emotion);
            c0289a.fOq.axi();
            c0289a.fOq.setController(this.giW);
            c0289a.fOq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.gka != null && (view2 instanceof EmotionView)) {
                        a.this.gka.b(((EmotionView) view2).getData(), ((EmotionView) view2).getIsGif());
                        TiebaStatic.log("c12176");
                    }
                }
            });
            c0289a.dVZ = (TextView) view.findViewById(e.g.tv_more);
            al.h(c0289a.dVZ, e.d.cp_cont_d);
            c0289a.dVZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.gka != null) {
                        ArrayList arrayList = new ArrayList();
                        if (!v.I(a.this.dux)) {
                            for (EmotionImageData emotionImageData : a.this.dux) {
                                if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                                    arrayList.add(emotionImageData.getThumbUrl());
                                }
                            }
                        }
                        a.this.gka.a(null, null, arrayList);
                    }
                }
            });
            view.setTag(c0289a);
        } else {
            c0289a = (C0289a) view.getTag();
        }
        if (i >= 0) {
            if (i < this.dux.size()) {
                c0289a.fOq.getLayoutParams().width = this.gjZ;
                c0289a.fOq.getLayoutParams().height = this.gjZ;
                c0289a.fOq.reset();
                c0289a.fOq.setTag(e.g.iv_emotion, null);
                EmotionImageData emotionImageData = this.dux.get(i);
                if (emotionImageData != null) {
                    c0289a.fOq.a(emotionImageData);
                    if (this.fOi != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        this.fOi.add(emotionImageData.getThumbUrl() + c0289a.fOq.getLoadProcType());
                    }
                }
                c0289a.fOq.setVisibility(0);
                c0289a.dVZ.setVisibility(8);
            } else if (i == this.dux.size()) {
                c0289a.dVZ.getLayoutParams().width = this.gjZ;
                c0289a.dVZ.getLayoutParams().height = this.gjZ;
                c0289a.fOq.setVisibility(8);
                c0289a.dVZ.setVisibility(0);
            }
        }
        return view;
    }

    public void sT(int i) {
        if (this.gjZ != i) {
            this.gjZ = i;
            notifyDataSetChanged();
        }
    }

    public void a(EmotionView.a aVar) {
        this.giW = aVar;
    }

    public void a(PbEmotionBar.a aVar) {
        this.gka = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static class C0289a {
        TextView dVZ;
        EmotionView fOq;

        C0289a() {
        }
    }

    public void bfI() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (a.this.fOi != null) {
                    for (String str : a.this.fOi) {
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
