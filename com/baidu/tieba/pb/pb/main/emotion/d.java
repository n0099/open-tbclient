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
    private com.baidu.tieba.pb.pb.main.emotion.a eLc;
    private List<String> eVg;
    private List<EmotionImageData> mList;
    private Context mContext = BdBaseApplication.getInst().getApp();
    private Set<String> eCn = new HashSet();
    private int aeC = l.f(this.mContext, d.e.ds116);
    private int dPs = (int) (((l.ac(this.mContext) - l.f(this.mContext, d.e.ds88)) - (this.aeC * 4)) * 0.333d);

    public d(List<EmotionImageData> list) {
        this.mList = list;
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a aVar) {
        this.eLc = aVar;
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.list_search_emotion_item, (ViewGroup) null);
            aVar.eVk = (EmotionView) view.findViewById(d.g.emotion_view1);
            aVar.eVl = (EmotionView) view.findViewById(d.g.emotion_view2);
            aVar.eVm = (EmotionView) view.findViewById(d.g.emotion_view3);
            aVar.eVn = (EmotionView) view.findViewById(d.g.emotion_view4);
            aVar.initView();
            z(aVar.eVl, this.dPs);
            z(aVar.eVm, this.dPs);
            z(aVar.eVn, this.dPs);
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
                        a(aVar.eVk, emotionImageData);
                        continue;
                    case 1:
                        a(aVar.eVl, emotionImageData);
                        continue;
                    case 2:
                        a(aVar.eVm, emotionImageData);
                        continue;
                    case 3:
                        a(aVar.eVn, emotionImageData);
                        continue;
                }
            }
        }
        return view;
    }

    public void removeListener() {
        this.eLc = null;
    }

    private void a(EmotionView emotionView, EmotionImageData emotionImageData) {
        if (emotionView != null && emotionImageData != null) {
            emotionView.setTag(emotionView.getId(), emotionImageData);
            emotionView.afH();
            emotionView.a(emotionImageData);
            if (this.eCn != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                if (v.v(this.eVg) || !this.eVg.contains(emotionImageData.getThumbUrl())) {
                    this.eCn.add(emotionImageData.getThumbUrl() + emotionView.getLoadProcType());
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
                        if (d.this.eLc != null && (view instanceof EmotionView)) {
                            d.this.eLc.a((EmotionImageData) tag, ((EmotionView) view).getIsGif());
                        }
                        TiebaStatic.log("c12180");
                    }
                }
            });
        }
    }

    public void aOI() {
        new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.pb.pb.main.emotion.d.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: b */
            public Boolean doInBackground(Void... voidArr) {
                if (d.this.eCn != null) {
                    for (String str : d.this.eCn) {
                        if (!TextUtils.isEmpty(str)) {
                            com.baidu.tbadk.imageManager.c.Eg().gm(str);
                        }
                    }
                    return true;
                }
                return true;
            }
        }.execute(new Void[0]);
    }

    private void z(View view, int i) {
        if (view != null && view.getLayoutParams() != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.leftMargin = i;
            view.setLayoutParams(marginLayoutParams);
        }
    }

    public void cx(List<String> list) {
        this.eVg = list;
    }

    /* loaded from: classes.dex */
    class a {
        public EmotionView eVk;
        public EmotionView eVl;
        public EmotionView eVm;
        public EmotionView eVn;

        a() {
        }

        public void initView() {
            d.this.l(this.eVk);
            d.this.l(this.eVl);
            d.this.l(this.eVm);
            d.this.l(this.eVn);
        }
    }
}
