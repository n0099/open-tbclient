package com.baidu.tieba.pb.pb.main.emotion;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tieba.d;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private com.baidu.tieba.pb.pb.main.emotion.a eJR;
    private List<EmotionImageData> mList;
    private final Runnable etm = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.etl != null) {
                for (String str : b.this.etl) {
                    if (!TextUtils.isEmpty(str)) {
                        c.Ex().gn(str);
                    }
                }
            }
        }
    };
    private Context mContext = BdBaseApplication.getInst().getApp();
    private Set<String> etl = new HashSet();
    private int afN = k.g(this.mContext, d.f.ds116);
    private int dEe = (int) (((k.ag(this.mContext) - k.g(this.mContext, d.f.ds88)) - (this.afN * 4)) * 0.333d);

    public b(List<EmotionImageData> list) {
        this.mList = list;
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a aVar) {
        this.eJR = aVar;
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
            aVar.eTm = (EmotionView) view.findViewById(d.h.emotion_view1);
            aVar.eTn = (EmotionView) view.findViewById(d.h.emotion_view2);
            aVar.eTo = (EmotionView) view.findViewById(d.h.emotion_view3);
            aVar.eTp = (EmotionView) view.findViewById(d.h.emotion_view4);
            aVar.initView();
            A(aVar.eTn, this.dEe);
            A(aVar.eTo, this.dEe);
            A(aVar.eTp, this.dEe);
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
                        a(aVar.eTm, emotionImageData);
                        continue;
                    case 1:
                        a(aVar.eTn, emotionImageData);
                        continue;
                    case 2:
                        a(aVar.eTo, emotionImageData);
                        continue;
                    case 3:
                        a(aVar.eTp, emotionImageData);
                        continue;
                }
            }
        }
        return view;
    }

    public void removeListener() {
        this.eJR = null;
    }

    private void a(EmotionView emotionView, EmotionImageData emotionImageData) {
        if (emotionView != null && emotionImageData != null) {
            emotionView.setTag(emotionView.getId(), emotionImageData);
            emotionView.acT();
            emotionView.a(emotionImageData);
            if (this.etl != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                this.etl.add(emotionImageData.getThumbUrl() + emotionView.getLoadProcType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(EmotionView emotionView) {
        if (emotionView != null) {
            emotionView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Object tag = view.getTag(view.getId());
                    if (tag != null && (tag instanceof EmotionImageData)) {
                        if (b.this.eJR != null && (view instanceof EmotionView)) {
                            b.this.eJR.a((EmotionImageData) tag, ((EmotionView) view).getIsGif());
                        }
                        TiebaStatic.log("c12180");
                    }
                }
            });
        }
    }

    public void aMi() {
        new Thread(this.etm).start();
    }

    private void A(View view, int i) {
        if (view != null && view.getLayoutParams() != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.leftMargin = i;
            view.setLayoutParams(marginLayoutParams);
        }
    }

    /* loaded from: classes.dex */
    class a {
        public EmotionView eTm;
        public EmotionView eTn;
        public EmotionView eTo;
        public EmotionView eTp;

        a() {
        }

        public void initView() {
            b.this.k(this.eTm);
            b.this.k(this.eTn);
            b.this.k(this.eTo);
            b.this.k(this.eTp);
        }
    }
}
