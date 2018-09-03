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
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.f;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes2.dex */
public class d extends BaseAdapter {
    private List<String> fHQ;
    private com.baidu.tieba.pb.pb.main.emotion.a fwd;
    private List<EmotionImageData> mList;
    private Context mContext = BdBaseApplication.getInst().getApp();
    private Set<String> fni = new HashSet();
    private int aoc = l.f(this.mContext, f.e.ds116);
    private int eEV = (int) (((l.ah(this.mContext) - l.f(this.mContext, f.e.ds88)) - (this.aoc * 4)) * 0.333d);

    public d(List<EmotionImageData> list) {
        this.mList = list;
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a aVar) {
        this.fwd = aVar;
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(f.h.list_search_emotion_item, (ViewGroup) null);
            aVar.fHU = (EmotionView) view.findViewById(f.g.emotion_view1);
            aVar.fHV = (EmotionView) view.findViewById(f.g.emotion_view2);
            aVar.fHW = (EmotionView) view.findViewById(f.g.emotion_view3);
            aVar.fHX = (EmotionView) view.findViewById(f.g.emotion_view4);
            aVar.initView();
            x(aVar.fHV, this.eEV);
            x(aVar.fHW, this.eEV);
            x(aVar.fHX, this.eEV);
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
                        a(aVar.fHU, emotionImageData);
                        continue;
                    case 1:
                        a(aVar.fHV, emotionImageData);
                        continue;
                    case 2:
                        a(aVar.fHW, emotionImageData);
                        continue;
                    case 3:
                        a(aVar.fHX, emotionImageData);
                        continue;
                }
            }
        }
        return view;
    }

    public void removeListener() {
        this.fwd = null;
    }

    private void a(EmotionView emotionView, EmotionImageData emotionImageData) {
        if (emotionView != null && emotionImageData != null) {
            emotionView.setTag(emotionView.getId(), emotionImageData);
            emotionView.apC();
            emotionView.a(emotionImageData);
            if (this.fni != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                if (w.z(this.fHQ) || !this.fHQ.contains(emotionImageData.getThumbUrl())) {
                    this.fni.add(emotionImageData.getThumbUrl() + emotionView.getLoadProcType());
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
                        if (d.this.fwd != null && (view instanceof EmotionView)) {
                            d.this.fwd.a((EmotionImageData) tag, ((EmotionView) view).getIsGif());
                        }
                        TiebaStatic.log("c12180");
                    }
                }
            });
        }
    }

    public void aXI() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.d.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... voidArr) {
                if (d.this.fni != null) {
                    for (String str : d.this.fni) {
                        if (!TextUtils.isEmpty(str)) {
                            com.baidu.tbadk.imageManager.c.IQ().hc(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }

    private void x(View view, int i) {
        if (view != null && view.getLayoutParams() != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.leftMargin = i;
            view.setLayoutParams(marginLayoutParams);
        }
    }

    public void cX(List<String> list) {
        this.fHQ = list;
    }

    /* loaded from: classes2.dex */
    class a {
        public EmotionView fHU;
        public EmotionView fHV;
        public EmotionView fHW;
        public EmotionView fHX;

        a() {
        }

        public void initView() {
            d.this.l(this.fHU);
            d.this.l(this.fHV);
            d.this.l(this.fHW);
            d.this.l(this.fHX);
        }
    }
}
