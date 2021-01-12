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
/* loaded from: classes8.dex */
public class h extends BaseAdapter {
    private int fSe;
    private f lsv;
    private List<EmotionImageData> mList;
    private final Runnable lub = new Runnable() { // from class: com.baidu.tieba.newfaceshop.facemake.h.2
        @Override // java.lang.Runnable
        public void run() {
            if (h.this.lua != null) {
                HashSet hashSet = new HashSet();
                Iterator it = h.this.ltR.entrySet().iterator();
                while (it.hasNext()) {
                    hashSet.add(((EmotionImageData) ((Map.Entry) it.next()).getValue()).getThumbUrl() + h.this.fSe);
                }
                for (String str : h.this.lua) {
                    if (!TextUtils.isEmpty(str) && !hashSet.contains(str)) {
                        com.baidu.tbadk.imageManager.c.bCx().deletePic(str);
                    }
                }
            }
        }
    };
    private Context mContext = BdBaseApplication.getInst().getApp();
    private Set<String> lua = new HashSet();
    private LinkedHashMap<String, EmotionImageData> ltR = new LinkedHashMap<>();
    private int mItemWidth = l.getDimens(this.mContext, R.dimen.ds116);
    private int kGN = (int) (((l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds60)) - (this.mItemWidth * 4)) * 0.333d);

    public h(List<EmotionImageData> list, int i) {
        this.mList = list;
        this.fSe = i;
    }

    public void b(f fVar) {
        this.lsv = fVar;
    }

    public void G(Map<String, EmotionImageData> map) {
        this.ltR.putAll(map);
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
            aVar.lue = (PickEmotionView) view.findViewById(R.id.emotion_view1);
            aVar.luf = (PickEmotionView) view.findViewById(R.id.emotion_view2);
            aVar.lug = (PickEmotionView) view.findViewById(R.id.emotion_view3);
            aVar.luh = (PickEmotionView) view.findViewById(R.id.emotion_view4);
            aVar.initView();
            C(aVar.luf, this.kGN);
            C(aVar.lug, this.kGN);
            C(aVar.luh, this.kGN);
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
                    a(aVar.lue, emotionImageData);
                    break;
                case 1:
                    a(aVar.luf, emotionImageData);
                    break;
                case 2:
                    a(aVar.lug, emotionImageData);
                    break;
                case 3:
                    a(aVar.luh, emotionImageData);
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
            pickEmotionView.setData(emotionImageData, this.fSe);
            b(pickEmotionView, emotionImageData);
            if (this.lua != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                this.lua.add(emotionImageData.getThumbUrl() + pickEmotionView.getLoadType());
            }
        }
    }

    private void b(PickEmotionView pickEmotionView, EmotionImageData emotionImageData) {
        if (this.ltR.containsKey(emotionImageData.getPicUrl())) {
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
                        if (h.this.ltR.containsKey(((EmotionImageData) tag).getPicUrl())) {
                            h.this.ltR.remove(((EmotionImageData) tag).getPicUrl());
                            pickEmotionView.setChoosed(false);
                            if (h.this.lsv != null) {
                                h.this.lsv.cys();
                            }
                        } else if (h.this.lsv != null) {
                            if (h.this.lsv.cyt()) {
                                h.this.ltR.put(((EmotionImageData) tag).getPicUrl(), (EmotionImageData) tag);
                                pickEmotionView.setChoosed(true);
                                h.this.lsv.cyr();
                                return;
                            }
                            BdToast.b(h.this.mContext, h.this.mContext.getText(R.string.face_group_add_pic_max)).bqk();
                        }
                    }
                }
            });
        }
    }

    public void dgM() {
        new Thread(this.lub).start();
    }

    private void C(View view, int i) {
        if (view != null && view.getLayoutParams() != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.leftMargin = i;
            view.setLayoutParams(marginLayoutParams);
        }
    }

    /* loaded from: classes8.dex */
    class a {
        public PickEmotionView lue;
        public PickEmotionView luf;
        public PickEmotionView lug;
        public PickEmotionView luh;

        a() {
        }

        public void initView() {
            h.this.a(this.lue);
            h.this.a(this.luf);
            h.this.a(this.lug);
            h.this.a(this.luh);
        }
    }

    public LinkedHashMap<String, EmotionImageData> dgu() {
        return this.ltR;
    }
}
