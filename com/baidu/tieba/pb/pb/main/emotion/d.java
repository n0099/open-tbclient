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
    private com.baidu.tieba.pb.pb.main.emotion.a fXB;
    private List<String> gjj;
    private List<EmotionImageData> mList;
    private Context mContext = BdBaseApplication.getInst().getApp();
    private Set<String> fOi = new HashSet();
    private int aAo = l.h(this.mContext, e.C0210e.ds116);
    private int ffF = (int) (((l.aO(this.mContext) - l.h(this.mContext, e.C0210e.ds88)) - (this.aAo * 4)) * 0.333d);

    public d(List<EmotionImageData> list) {
        this.mList = list;
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a aVar) {
        this.fXB = aVar;
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
            aVar.gjn = (EmotionView) view.findViewById(e.g.emotion_view1);
            aVar.gjo = (EmotionView) view.findViewById(e.g.emotion_view2);
            aVar.gjp = (EmotionView) view.findViewById(e.g.emotion_view3);
            aVar.gjq = (EmotionView) view.findViewById(e.g.emotion_view4);
            aVar.initView();
            y(aVar.gjo, this.ffF);
            y(aVar.gjp, this.ffF);
            y(aVar.gjq, this.ffF);
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
                        a(aVar.gjn, emotionImageData);
                        continue;
                    case 1:
                        a(aVar.gjo, emotionImageData);
                        continue;
                    case 2:
                        a(aVar.gjp, emotionImageData);
                        continue;
                    case 3:
                        a(aVar.gjq, emotionImageData);
                        continue;
                }
            }
        }
        return view;
    }

    public void removeListener() {
        this.fXB = null;
    }

    private void a(EmotionView emotionView, EmotionImageData emotionImageData) {
        if (emotionView != null && emotionImageData != null) {
            emotionView.setTag(emotionView.getId(), emotionImageData);
            emotionView.axi();
            emotionView.a(emotionImageData);
            if (this.fOi != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                if (v.I(this.gjj) || !this.gjj.contains(emotionImageData.getThumbUrl())) {
                    this.fOi.add(emotionImageData.getThumbUrl() + emotionView.getLoadProcType());
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
                        if (d.this.fXB != null && (view instanceof EmotionView)) {
                            d.this.fXB.a((EmotionImageData) tag, ((EmotionView) view).getIsGif());
                        }
                        TiebaStatic.log("c12180");
                    }
                }
            });
        }
    }

    public void bfI() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.d.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (d.this.fOi != null) {
                    for (String str : d.this.fOi) {
                        if (!TextUtils.isEmpty(str)) {
                            com.baidu.tbadk.imageManager.c.NM().iu(str);
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

    public void dq(List<String> list) {
        this.gjj = list;
    }

    /* loaded from: classes6.dex */
    class a {
        public EmotionView gjn;
        public EmotionView gjo;
        public EmotionView gjp;
        public EmotionView gjq;

        a() {
        }

        public void initView() {
            d.this.l(this.gjn);
            d.this.l(this.gjo);
            d.this.l(this.gjp);
            d.this.l(this.gjq);
        }
    }
}
