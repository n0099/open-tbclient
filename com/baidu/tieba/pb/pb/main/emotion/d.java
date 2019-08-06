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
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes4.dex */
public class d extends BaseAdapter {
    private com.baidu.tieba.pb.pb.main.emotion.a hMn;
    private List<String> hXQ;
    private List<EmotionImageData> mList;
    private Context mContext = BdBaseApplication.getInst().getApp();
    private Set<String> hCI = new HashSet();
    private int bRd = l.g(this.mContext, R.dimen.ds116);
    private int gTS = (int) (((l.af(this.mContext) - l.g(this.mContext, R.dimen.ds88)) - (this.bRd * 4)) * 0.333d);

    public d(List<EmotionImageData> list) {
        this.mList = list;
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a aVar) {
        this.hMn = aVar;
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_search_emotion_item, (ViewGroup) null);
            aVar.hXU = (EmotionView) view.findViewById(R.id.emotion_view1);
            aVar.hXV = (EmotionView) view.findViewById(R.id.emotion_view2);
            aVar.hXW = (EmotionView) view.findViewById(R.id.emotion_view3);
            aVar.hXX = (EmotionView) view.findViewById(R.id.emotion_view4);
            aVar.initView();
            F(aVar.hXV, this.gTS);
            F(aVar.hXW, this.gTS);
            F(aVar.hXX, this.gTS);
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
                        a(aVar.hXU, emotionImageData);
                        continue;
                    case 1:
                        a(aVar.hXV, emotionImageData);
                        continue;
                    case 2:
                        a(aVar.hXW, emotionImageData);
                        continue;
                    case 3:
                        a(aVar.hXX, emotionImageData);
                        continue;
                }
            }
        }
        return view;
    }

    public void removeListener() {
        this.hMn = null;
    }

    private void a(EmotionView emotionView, EmotionImageData emotionImageData) {
        if (emotionView != null && emotionImageData != null) {
            emotionView.setTag(emotionView.getId(), emotionImageData);
            emotionView.bhp();
            emotionView.a(emotionImageData);
            if (this.hCI != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                if (v.aa(this.hXQ) || !this.hXQ.contains(emotionImageData.getThumbUrl())) {
                    this.hCI.add(emotionImageData.getThumbUrl() + emotionView.getLoadProcType());
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
                        if (d.this.hMn != null && (view instanceof EmotionView)) {
                            d.this.hMn.a((EmotionImageData) tag, ((EmotionView) view).getIsGif());
                        }
                        TiebaStatic.log("c12180");
                    }
                }
            });
        }
    }

    public void bQT() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.d.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (d.this.hCI != null) {
                    for (String str : d.this.hCI) {
                        if (!TextUtils.isEmpty(str)) {
                            com.baidu.tbadk.imageManager.c.aty().qF(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }

    private void F(View view, int i) {
        if (view != null && view.getLayoutParams() != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.leftMargin = i;
            view.setLayoutParams(marginLayoutParams);
        }
    }

    public void dK(List<String> list) {
        this.hXQ = list;
    }

    /* loaded from: classes4.dex */
    class a {
        public EmotionView hXU;
        public EmotionView hXV;
        public EmotionView hXW;
        public EmotionView hXX;

        a() {
        }

        public void initView() {
            d.this.l(this.hXU);
            d.this.l(this.hXV);
            d.this.l(this.hXW);
            d.this.l(this.hXX);
        }
    }
}
