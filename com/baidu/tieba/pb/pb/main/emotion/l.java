package com.baidu.tieba.pb.pb.main.emotion;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tieba.pb.pb.main.emotion.data.EmotionImageData;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionView;
import com.baidu.tieba.w;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private com.baidu.tieba.pb.pb.main.emotion.a emx;
    private List<EmotionImageData> mList;
    private final Runnable evH = new m(this);
    private Context mContext = BdBaseApplication.getInst().getApp();
    private Set<String> evG = new HashSet();
    private int adl = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds116);
    private int dks = (int) (((com.baidu.adp.lib.util.k.af(this.mContext) - com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds88)) - (this.adl * 4)) * 0.333d);

    public l(List<EmotionImageData> list) {
        this.mList = list;
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a aVar) {
        this.emx = aVar;
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(w.j.list_search_emotion_item, (ViewGroup) null);
            aVar.evJ = (PbEmotionView) view.findViewById(w.h.emotion_view1);
            aVar.evK = (PbEmotionView) view.findViewById(w.h.emotion_view2);
            aVar.evL = (PbEmotionView) view.findViewById(w.h.emotion_view3);
            aVar.evM = (PbEmotionView) view.findViewById(w.h.emotion_view4);
            aVar.initView();
            z(aVar.evK, this.dks);
            z(aVar.evL, this.dks);
            z(aVar.evM, this.dks);
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
                        a(aVar.evJ, emotionImageData);
                        continue;
                    case 1:
                        a(aVar.evK, emotionImageData);
                        continue;
                    case 2:
                        a(aVar.evL, emotionImageData);
                        continue;
                    case 3:
                        a(aVar.evM, emotionImageData);
                        continue;
                }
            }
        }
        return view;
    }

    public void removeListener() {
        this.emx = null;
    }

    private void a(PbEmotionView pbEmotionView, EmotionImageData emotionImageData) {
        if (pbEmotionView != null && emotionImageData != null) {
            pbEmotionView.setTag(pbEmotionView.getId(), emotionImageData);
            pbEmotionView.aNp();
            pbEmotionView.e(emotionImageData);
            if (this.evG != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                this.evG.add(String.valueOf(emotionImageData.getThumbUrl()) + pbEmotionView.getLoadProcType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PbEmotionView pbEmotionView) {
        if (pbEmotionView != null) {
            pbEmotionView.setOnClickListener(new n(this));
        }
    }

    public void aNm() {
        new Thread(this.evH).start();
    }

    private void z(View view, int i) {
        if (view != null && view.getLayoutParams() != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.leftMargin = i;
            view.setLayoutParams(marginLayoutParams);
        }
    }

    /* loaded from: classes.dex */
    class a {
        public PbEmotionView evJ;
        public PbEmotionView evK;
        public PbEmotionView evL;
        public PbEmotionView evM;

        a() {
        }

        public void initView() {
            l.this.a(this.evJ);
            l.this.a(this.evK);
            l.this.a(this.evL);
            l.this.a(this.evM);
        }
    }
}
