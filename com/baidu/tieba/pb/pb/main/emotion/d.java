package com.baidu.tieba.pb.pb.main.emotion;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class d extends BaseAdapter {
    private com.baidu.tieba.pb.pb.main.emotion.a eCl;
    private List<String> eMm;
    private List<EmotionImageData> mList;
    private Context mContext = BdBaseApplication.getInst().getApp();
    private Set<String> eue = new HashSet();
    private int aeh = l.f(this.mContext, d.f.ds116);
    private int dHE = (int) (((l.ad(this.mContext) - l.f(this.mContext, d.f.ds88)) - (this.aeh * 4)) * 0.333d);

    public d(List<EmotionImageData> list) {
        this.mList = list;
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a aVar) {
        this.eCl = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mList.size() % 4 == 0 ? this.mList.size() / 4 : (this.mList.size() / 4) + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.mList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.j.list_search_emotion_item, (ViewGroup) null);
            aVar.eMq = (EmotionView) view.findViewById(d.h.emotion_view1);
            aVar.eMr = (EmotionView) view.findViewById(d.h.emotion_view2);
            aVar.eMs = (EmotionView) view.findViewById(d.h.emotion_view3);
            aVar.eMt = (EmotionView) view.findViewById(d.h.emotion_view4);
            aVar.initView();
            y(aVar.eMr, this.dHE);
            y(aVar.eMs, this.dHE);
            y(aVar.eMt, this.dHE);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        int i2 = i * 4;
        int min = Math.min(i2 + 4, this.mList.size() - 1);
        for (int i3 = i2; i3 < i2 + 4; i3++) {
            if (i3 <= min) {
                EmotionImageData emotionImageData = this.mList.get(i3);
                switch (i3 - i2) {
                    case 0:
                        a(aVar.eMq, emotionImageData);
                        continue;
                    case 1:
                        a(aVar.eMr, emotionImageData);
                        continue;
                    case 2:
                        a(aVar.eMs, emotionImageData);
                        continue;
                    case 3:
                        a(aVar.eMt, emotionImageData);
                        continue;
                }
            }
        }
        return view;
    }

    public void removeListener() {
        this.eCl = null;
    }

    private void a(EmotionView emotionView, EmotionImageData emotionImageData) {
        if (emotionView != null && emotionImageData != null) {
            emotionView.setTag(emotionView.getId(), emotionImageData);
            emotionView.adA();
            emotionView.a(emotionImageData);
            if (this.eue != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                if (v.u(this.eMm) || !this.eMm.contains(emotionImageData.getThumbUrl())) {
                    this.eue.add(emotionImageData.getThumbUrl() + emotionView.getLoadProcType());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(EmotionView emotionView) {
        if (emotionView != null) {
            emotionView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Object tag = view.getTag(view.getId());
                    if (tag != null && (tag instanceof EmotionImageData)) {
                        if (d.this.eCl != null && (view instanceof EmotionView)) {
                            d.this.eCl.a((EmotionImageData) tag, ((EmotionView) view).getIsGif());
                        }
                        TiebaStatic.log("c12180");
                    }
                }
            });
        }
    }

    public void aLQ() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.d.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: b */
            public Boolean doInBackground(Void... voidArr) {
                if (d.this.eue != null) {
                    for (String str : d.this.eue) {
                        if (!TextUtils.isEmpty(str)) {
                            com.baidu.tbadk.imageManager.c.DT().gf(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }

    private void y(View view, int i) {
        if (view != null && view.getLayoutParams() != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.leftMargin = i;
            view.setLayoutParams(marginLayoutParams);
        }
    }

    public void cw(List<String> list) {
        this.eMm = list;
    }

    /* loaded from: classes.dex */
    class a {
        public EmotionView eMq;
        public EmotionView eMr;
        public EmotionView eMs;
        public EmotionView eMt;

        a() {
        }

        public void initView() {
            d.this.l(this.eMq);
            d.this.l(this.eMr);
            d.this.l(this.eMs);
            d.this.l(this.eMt);
        }
    }
}
