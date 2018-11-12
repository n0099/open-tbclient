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
import com.baidu.tieba.e;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes6.dex */
public class d extends BaseAdapter {
    private com.baidu.tieba.pb.pb.main.emotion.a fMW;
    private List<String> fYw;
    private List<EmotionImageData> mList;
    private Context mContext = BdBaseApplication.getInst().getApp();
    private Set<String> fDG = new HashSet();
    private int awm = l.h(this.mContext, e.C0200e.ds116);
    private int eVm = (int) (((l.aO(this.mContext) - l.h(this.mContext, e.C0200e.ds88)) - (this.awm * 4)) * 0.333d);

    public d(List<EmotionImageData> list) {
        this.mList = list;
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a aVar) {
        this.fMW = aVar;
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(e.h.list_search_emotion_item, (ViewGroup) null);
            aVar.fYA = (EmotionView) view.findViewById(e.g.emotion_view1);
            aVar.fYB = (EmotionView) view.findViewById(e.g.emotion_view2);
            aVar.fYC = (EmotionView) view.findViewById(e.g.emotion_view3);
            aVar.fYD = (EmotionView) view.findViewById(e.g.emotion_view4);
            aVar.initView();
            y(aVar.fYB, this.eVm);
            y(aVar.fYC, this.eVm);
            y(aVar.fYD, this.eVm);
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
                        a(aVar.fYA, emotionImageData);
                        continue;
                    case 1:
                        a(aVar.fYB, emotionImageData);
                        continue;
                    case 2:
                        a(aVar.fYC, emotionImageData);
                        continue;
                    case 3:
                        a(aVar.fYD, emotionImageData);
                        continue;
                }
            }
        }
        return view;
    }

    public void removeListener() {
        this.fMW = null;
    }

    private void a(EmotionView emotionView, EmotionImageData emotionImageData) {
        if (emotionView != null && emotionImageData != null) {
            emotionView.setTag(emotionView.getId(), emotionImageData);
            emotionView.aul();
            emotionView.a(emotionImageData);
            if (this.fDG != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                if (v.I(this.fYw) || !this.fYw.contains(emotionImageData.getThumbUrl())) {
                    this.fDG.add(emotionImageData.getThumbUrl() + emotionView.getLoadProcType());
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
                        if (d.this.fMW != null && (view instanceof EmotionView)) {
                            d.this.fMW.a((EmotionImageData) tag, ((EmotionView) view).getIsGif());
                        }
                        TiebaStatic.log("c12180");
                    }
                }
            });
        }
    }

    public void bcG() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.d.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (d.this.fDG != null) {
                    for (String str : d.this.fDG) {
                        if (!TextUtils.isEmpty(str)) {
                            com.baidu.tbadk.imageManager.c.Mq().hN(str);
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

    public void dk(List<String> list) {
        this.fYw = list;
    }

    /* loaded from: classes6.dex */
    class a {
        public EmotionView fYA;
        public EmotionView fYB;
        public EmotionView fYC;
        public EmotionView fYD;

        a() {
        }

        public void initView() {
            d.this.l(this.fYA);
            d.this.l(this.fYB);
            d.this.l(this.fYC);
            d.this.l(this.fYD);
        }
    }
}
