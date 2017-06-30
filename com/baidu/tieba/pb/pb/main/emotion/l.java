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
    private com.baidu.tieba.pb.pb.main.emotion.a evB;
    private List<EmotionImageData> mList;
    private final Runnable eEX = new m(this);
    private Context mContext = BdBaseApplication.getInst().getApp();
    private Set<String> eEW = new HashSet();
    private int adU = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds116);
    private int dso = (int) (((com.baidu.adp.lib.util.k.af(this.mContext) - com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds88)) - (this.adU * 4)) * 0.333d);

    public l(List<EmotionImageData> list) {
        this.mList = list;
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a aVar) {
        this.evB = aVar;
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
            aVar.eEZ = (PbEmotionView) view.findViewById(w.h.emotion_view1);
            aVar.eFa = (PbEmotionView) view.findViewById(w.h.emotion_view2);
            aVar.eFb = (PbEmotionView) view.findViewById(w.h.emotion_view3);
            aVar.eFc = (PbEmotionView) view.findViewById(w.h.emotion_view4);
            aVar.initView();
            z(aVar.eFa, this.dso);
            z(aVar.eFb, this.dso);
            z(aVar.eFc, this.dso);
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
                        a(aVar.eEZ, emotionImageData);
                        continue;
                    case 1:
                        a(aVar.eFa, emotionImageData);
                        continue;
                    case 2:
                        a(aVar.eFb, emotionImageData);
                        continue;
                    case 3:
                        a(aVar.eFc, emotionImageData);
                        continue;
                }
            }
        }
        return view;
    }

    public void removeListener() {
        this.evB = null;
    }

    private void a(PbEmotionView pbEmotionView, EmotionImageData emotionImageData) {
        if (pbEmotionView != null && emotionImageData != null) {
            pbEmotionView.setTag(pbEmotionView.getId(), emotionImageData);
            pbEmotionView.aRp();
            pbEmotionView.e(emotionImageData);
            if (this.eEW != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                this.eEW.add(String.valueOf(emotionImageData.getThumbUrl()) + pbEmotionView.getLoadProcType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PbEmotionView pbEmotionView) {
        if (pbEmotionView != null) {
            pbEmotionView.setOnClickListener(new n(this));
        }
    }

    public void aRl() {
        new Thread(this.eEX).start();
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
        public PbEmotionView eEZ;
        public PbEmotionView eFa;
        public PbEmotionView eFb;
        public PbEmotionView eFc;

        a() {
        }

        public void initView() {
            l.this.a(this.eEZ);
            l.this.a(this.eFa);
            l.this.a(this.eFb);
            l.this.a(this.eFc);
        }
    }
}
