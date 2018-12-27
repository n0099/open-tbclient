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
    private com.baidu.tieba.pb.pb.main.emotion.a fWE;
    private List<String> gig;
    private List<EmotionImageData> mList;
    private Context mContext = BdBaseApplication.getInst().getApp();
    private Set<String> fNo = new HashSet();
    private int azM = l.h(this.mContext, e.C0210e.ds116);
    private int feS = (int) (((l.aO(this.mContext) - l.h(this.mContext, e.C0210e.ds88)) - (this.azM * 4)) * 0.333d);

    public d(List<EmotionImageData> list) {
        this.mList = list;
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a aVar) {
        this.fWE = aVar;
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
            aVar.gik = (EmotionView) view.findViewById(e.g.emotion_view1);
            aVar.gil = (EmotionView) view.findViewById(e.g.emotion_view2);
            aVar.gim = (EmotionView) view.findViewById(e.g.emotion_view3);
            aVar.gin = (EmotionView) view.findViewById(e.g.emotion_view4);
            aVar.initView();
            y(aVar.gil, this.feS);
            y(aVar.gim, this.feS);
            y(aVar.gin, this.feS);
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
                        a(aVar.gik, emotionImageData);
                        continue;
                    case 1:
                        a(aVar.gil, emotionImageData);
                        continue;
                    case 2:
                        a(aVar.gim, emotionImageData);
                        continue;
                    case 3:
                        a(aVar.gin, emotionImageData);
                        continue;
                }
            }
        }
        return view;
    }

    public void removeListener() {
        this.fWE = null;
    }

    private void a(EmotionView emotionView, EmotionImageData emotionImageData) {
        if (emotionView != null && emotionImageData != null) {
            emotionView.setTag(emotionView.getId(), emotionImageData);
            emotionView.awL();
            emotionView.a(emotionImageData);
            if (this.fNo != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                if (v.I(this.gig) || !this.gig.contains(emotionImageData.getThumbUrl())) {
                    this.fNo.add(emotionImageData.getThumbUrl() + emotionView.getLoadProcType());
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
                        if (d.this.fWE != null && (view instanceof EmotionView)) {
                            d.this.fWE.a((EmotionImageData) tag, ((EmotionView) view).getIsGif());
                        }
                        TiebaStatic.log("c12180");
                    }
                }
            });
        }
    }

    public void bfi() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.d.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (d.this.fNo != null) {
                    for (String str : d.this.fNo) {
                        if (!TextUtils.isEmpty(str)) {
                            com.baidu.tbadk.imageManager.c.Nv().ig(str);
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

    public void dp(List<String> list) {
        this.gig = list;
    }

    /* loaded from: classes6.dex */
    class a {
        public EmotionView gik;
        public EmotionView gil;
        public EmotionView gim;
        public EmotionView gin;

        a() {
        }

        public void initView() {
            d.this.l(this.gik);
            d.this.l(this.gil);
            d.this.l(this.gim);
            d.this.l(this.gin);
        }
    }
}
