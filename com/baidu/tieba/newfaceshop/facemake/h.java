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
    private int fWL;
    private f lxb;
    private List<EmotionImageData> mList;
    private final Runnable lyH = new Runnable() { // from class: com.baidu.tieba.newfaceshop.facemake.h.2
        @Override // java.lang.Runnable
        public void run() {
            if (h.this.lyG != null) {
                HashSet hashSet = new HashSet();
                Iterator it = h.this.lyx.entrySet().iterator();
                while (it.hasNext()) {
                    hashSet.add(((EmotionImageData) ((Map.Entry) it.next()).getValue()).getThumbUrl() + h.this.fWL);
                }
                for (String str : h.this.lyG) {
                    if (!TextUtils.isEmpty(str) && !hashSet.contains(str)) {
                        com.baidu.tbadk.imageManager.c.bGq().deletePic(str);
                    }
                }
            }
        }
    };
    private Context mContext = BdBaseApplication.getInst().getApp();
    private Set<String> lyG = new HashSet();
    private LinkedHashMap<String, EmotionImageData> lyx = new LinkedHashMap<>();
    private int mItemWidth = l.getDimens(this.mContext, R.dimen.ds116);
    private int kLs = (int) (((l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds60)) - (this.mItemWidth * 4)) * 0.333d);

    public h(List<EmotionImageData> list, int i) {
        this.mList = list;
        this.fWL = i;
    }

    public void b(f fVar) {
        this.lxb = fVar;
    }

    public void G(Map<String, EmotionImageData> map) {
        this.lyx.putAll(map);
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
            aVar.lyK = (PickEmotionView) view.findViewById(R.id.emotion_view1);
            aVar.lyL = (PickEmotionView) view.findViewById(R.id.emotion_view2);
            aVar.lyM = (PickEmotionView) view.findViewById(R.id.emotion_view3);
            aVar.lyN = (PickEmotionView) view.findViewById(R.id.emotion_view4);
            aVar.initView();
            C(aVar.lyL, this.kLs);
            C(aVar.lyM, this.kLs);
            C(aVar.lyN, this.kLs);
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
                    a(aVar.lyK, emotionImageData);
                    break;
                case 1:
                    a(aVar.lyL, emotionImageData);
                    break;
                case 2:
                    a(aVar.lyM, emotionImageData);
                    break;
                case 3:
                    a(aVar.lyN, emotionImageData);
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
            pickEmotionView.setData(emotionImageData, this.fWL);
            b(pickEmotionView, emotionImageData);
            if (this.lyG != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                this.lyG.add(emotionImageData.getThumbUrl() + pickEmotionView.getLoadType());
            }
        }
    }

    private void b(PickEmotionView pickEmotionView, EmotionImageData emotionImageData) {
        if (this.lyx.containsKey(emotionImageData.getPicUrl())) {
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
                        if (h.this.lyx.containsKey(((EmotionImageData) tag).getPicUrl())) {
                            h.this.lyx.remove(((EmotionImageData) tag).getPicUrl());
                            pickEmotionView.setChoosed(false);
                            if (h.this.lxb != null) {
                                h.this.lxb.cCk();
                            }
                        } else if (h.this.lxb != null) {
                            if (h.this.lxb.cCl()) {
                                h.this.lyx.put(((EmotionImageData) tag).getPicUrl(), (EmotionImageData) tag);
                                pickEmotionView.setChoosed(true);
                                h.this.lxb.cCj();
                                return;
                            }
                            BdToast.b(h.this.mContext, h.this.mContext.getText(R.string.face_group_add_pic_max)).bue();
                        }
                    }
                }
            });
        }
    }

    public void dkE() {
        new Thread(this.lyH).start();
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
        public PickEmotionView lyK;
        public PickEmotionView lyL;
        public PickEmotionView lyM;
        public PickEmotionView lyN;

        a() {
        }

        public void initView() {
            h.this.a(this.lyK);
            h.this.a(this.lyL);
            h.this.a(this.lyM);
            h.this.a(this.lyN);
        }
    }

    public LinkedHashMap<String, EmotionImageData> dkm() {
        return this.lyx;
    }
}
