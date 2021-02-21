package com.baidu.tieba.newfaceshop.facemake;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes9.dex */
public class h extends BaseAdapter {
    private int fUt;
    private f lAO;
    private List<EmotionImageData> mList;
    private final Runnable lCt = new Runnable() { // from class: com.baidu.tieba.newfaceshop.facemake.h.2
        @Override // java.lang.Runnable
        public void run() {
            if (h.this.lCs != null) {
                HashSet hashSet = new HashSet();
                Iterator it = h.this.lCj.entrySet().iterator();
                while (it.hasNext()) {
                    hashSet.add(((EmotionImageData) ((Map.Entry) it.next()).getValue()).getThumbUrl() + h.this.fUt);
                }
                for (String str : h.this.lCs) {
                    if (!TextUtils.isEmpty(str) && !hashSet.contains(str)) {
                        com.baidu.tbadk.imageManager.c.bCP().deletePic(str);
                    }
                }
            }
        }
    };
    private Context mContext = BdBaseApplication.getInst().getApp();
    private Set<String> lCs = new HashSet();
    private LinkedHashMap<String, EmotionImageData> lCj = new LinkedHashMap<>();
    private int mItemWidth = l.getDimens(this.mContext, R.dimen.ds116);
    private int kPf = (int) (((l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds60)) - (this.mItemWidth * 4)) * 0.333d);

    public h(List<EmotionImageData> list, int i) {
        this.mList = list;
        this.fUt = i;
    }

    public void b(f fVar) {
        this.lAO = fVar;
    }

    public void I(Map<String, EmotionImageData> map) {
        this.lCj.putAll(map);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mList != null) {
            if (this.mList.size() % 4 == 0) {
                return this.mList.size() / 4;
            }
            return (this.mList.size() / 4) + 1;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mList == null || i > this.mList.size() - 1) {
            return null;
        }
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_emotion, (ViewGroup) null);
            aVar.lCw = (PickEmotionView) view.findViewById(R.id.emotion_view1);
            aVar.lCx = (PickEmotionView) view.findViewById(R.id.emotion_view2);
            aVar.lCy = (PickEmotionView) view.findViewById(R.id.emotion_view3);
            aVar.lCz = (PickEmotionView) view.findViewById(R.id.emotion_view4);
            aVar.initView();
            C(aVar.lCx, this.kPf);
            C(aVar.lCy, this.kPf);
            C(aVar.lCz, this.kPf);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        int i2 = i * 4;
        int min = Math.min(i2 + 4, this.mList.size() - 1);
        int i3 = i2;
        while (i3 < i2 + 4) {
            EmotionImageData emotionImageData = i3 <= min ? this.mList.get(i3) : null;
            switch (i3 - i2) {
                case 0:
                    a(aVar.lCw, emotionImageData);
                    break;
                case 1:
                    a(aVar.lCx, emotionImageData);
                    break;
                case 2:
                    a(aVar.lCy, emotionImageData);
                    break;
                case 3:
                    a(aVar.lCz, emotionImageData);
                    break;
            }
            i3++;
        }
        return view;
    }

    private void a(PickEmotionView pickEmotionView, EmotionImageData emotionImageData) {
        if (pickEmotionView != null) {
            if (emotionImageData == null) {
                pickEmotionView.setVisibility(4);
                return;
            }
            pickEmotionView.getEmotionView().setTag(pickEmotionView.getEmotionView().getId(), emotionImageData);
            pickEmotionView.setData(emotionImageData, this.fUt);
            b(pickEmotionView, emotionImageData);
            if (this.lCs != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                this.lCs.add(emotionImageData.getThumbUrl() + pickEmotionView.getLoadType());
            }
        }
    }

    private void b(PickEmotionView pickEmotionView, EmotionImageData emotionImageData) {
        if (this.lCj.containsKey(emotionImageData.getPicUrl())) {
            pickEmotionView.setChoosed(true);
        } else {
            pickEmotionView.setChoosed(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final PickEmotionView pickEmotionView) {
        if (pickEmotionView != null) {
            pickEmotionView.getEmotionView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newfaceshop.facemake.h.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Object tag = view.getTag(view.getId());
                    if (tag != null && (tag instanceof EmotionImageData)) {
                        if (h.this.lCj.containsKey(((EmotionImageData) tag).getPicUrl())) {
                            h.this.lCj.remove(((EmotionImageData) tag).getPicUrl());
                            pickEmotionView.setChoosed(false);
                            if (h.this.lAO != null) {
                                h.this.lAO.czK();
                            }
                        } else if (h.this.lAO != null) {
                            if (h.this.lAO.czL()) {
                                h.this.lCj.put(((EmotionImageData) tag).getPicUrl(), (EmotionImageData) tag);
                                pickEmotionView.setChoosed(true);
                                h.this.lAO.czJ();
                                return;
                            }
                            BdToast.b(h.this.mContext, h.this.mContext.getText(R.string.face_group_add_pic_max)).bqD();
                        }
                    }
                }
            });
        }
    }

    public void diU() {
        new Thread(this.lCt).start();
    }

    private void C(View view, int i) {
        if (view != null && view.getLayoutParams() != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.leftMargin = i;
            view.setLayoutParams(marginLayoutParams);
        }
    }

    /* loaded from: classes9.dex */
    class a {
        public PickEmotionView lCw;
        public PickEmotionView lCx;
        public PickEmotionView lCy;
        public PickEmotionView lCz;

        a() {
        }

        public void initView() {
            h.this.a(this.lCw);
            h.this.a(this.lCx);
            h.this.a(this.lCy);
            h.this.a(this.lCz);
        }
    }

    public LinkedHashMap<String, EmotionImageData> diC() {
        return this.lCj;
    }
}
