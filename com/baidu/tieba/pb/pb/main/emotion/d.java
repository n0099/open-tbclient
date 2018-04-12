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
/* loaded from: classes2.dex */
public class d extends BaseAdapter {
    private com.baidu.tieba.pb.pb.main.emotion.a ffD;
    private List<String> frl;
    private List<EmotionImageData> mList;
    private Context mContext = BdBaseApplication.getInst().getApp();
    private Set<String> eWI = new HashSet();
    private int mItemWidth = l.e(this.mContext, d.e.ds116);
    private int ekU = (int) (((l.af(this.mContext) - l.e(this.mContext, d.e.ds88)) - (this.mItemWidth * 4)) * 0.333d);

    public d(List<EmotionImageData> list) {
        this.mList = list;
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a aVar) {
        this.ffD = aVar;
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
    public View getView(int i, View view2, ViewGroup viewGroup) {
        a aVar;
        if (view2 == null) {
            aVar = new a();
            view2 = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.list_search_emotion_item, (ViewGroup) null);
            aVar.frp = (EmotionView) view2.findViewById(d.g.emotion_view1);
            aVar.frq = (EmotionView) view2.findViewById(d.g.emotion_view2);
            aVar.frr = (EmotionView) view2.findViewById(d.g.emotion_view3);
            aVar.frt = (EmotionView) view2.findViewById(d.g.emotion_view4);
            aVar.initView();
            u(aVar.frq, this.ekU);
            u(aVar.frr, this.ekU);
            u(aVar.frt, this.ekU);
            view2.setTag(aVar);
        } else {
            aVar = (a) view2.getTag();
        }
        int i2 = i * 4;
        int min = Math.min(i2 + 4, this.mList.size() - 1);
        for (int i3 = i2; i3 < i2 + 4; i3++) {
            if (i3 <= min) {
                EmotionImageData emotionImageData = this.mList.get(i3);
                switch (i3 - i2) {
                    case 0:
                        a(aVar.frp, emotionImageData);
                        continue;
                    case 1:
                        a(aVar.frq, emotionImageData);
                        continue;
                    case 2:
                        a(aVar.frr, emotionImageData);
                        continue;
                    case 3:
                        a(aVar.frt, emotionImageData);
                        continue;
                }
            }
        }
        return view2;
    }

    public void removeListener() {
        this.ffD = null;
    }

    private void a(EmotionView emotionView, EmotionImageData emotionImageData) {
        if (emotionView != null && emotionImageData != null) {
            emotionView.setTag(emotionView.getId(), emotionImageData);
            emotionView.alB();
            emotionView.a(emotionImageData);
            if (this.eWI != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                if (v.w(this.frl) || !this.frl.contains(emotionImageData.getThumbUrl())) {
                    this.eWI.add(emotionImageData.getThumbUrl() + emotionView.getLoadProcType());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(EmotionView emotionView) {
        if (emotionView != null) {
            emotionView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Object tag = view2.getTag(view2.getId());
                    if (tag != null && (tag instanceof EmotionImageData)) {
                        if (d.this.ffD != null && (view2 instanceof EmotionView)) {
                            d.this.ffD.a((EmotionImageData) tag, ((EmotionView) view2).getIsGif());
                        }
                        TiebaStatic.log("c12180");
                    }
                }
            });
        }
    }

    public void aTN() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.d.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (d.this.eWI != null) {
                    for (String str : d.this.eWI) {
                        if (!TextUtils.isEmpty(str)) {
                            com.baidu.tbadk.imageManager.c.Fa().gE(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }

    private void u(View view2, int i) {
        if (view2 != null && view2.getLayoutParams() != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
            marginLayoutParams.leftMargin = i;
            view2.setLayoutParams(marginLayoutParams);
        }
    }

    public void cP(List<String> list) {
        this.frl = list;
    }

    /* loaded from: classes2.dex */
    class a {
        public EmotionView frp;
        public EmotionView frq;
        public EmotionView frr;
        public EmotionView frt;

        a() {
        }

        public void initView() {
            d.this.l(this.frp);
            d.this.l(this.frq);
            d.this.l(this.frr);
            d.this.l(this.frt);
        }
    }
}
