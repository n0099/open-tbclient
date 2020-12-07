package com.baidu.tieba.yuyinala.liveroom.wheat.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.data.e;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.AlaAcceptAndInviteBtn;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {
    private Context context;
    private List<e> mList;
    private a orC;

    /* loaded from: classes4.dex */
    public interface a {
        void NH(int i);

        void a(e eVar);

        void b(e eVar);
    }

    public b(Context context) {
        this.context = context;
    }

    public void setData(List<e> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mList != null) {
            return this.mList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mList != null) {
            return this.mList.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0260  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i, View view, ViewGroup viewGroup) {
        final C0940b c0940b;
        final int i2;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(a.g.yuyin_item_connection_wheat_apply, (ViewGroup) null);
            C0940b c0940b2 = new C0940b();
            c0940b2.orq = (TextView) view.findViewById(a.f.tv_rank_num);
            c0940b2.orr = view.findViewById(a.f.margin_top_height);
            c0940b2.ors = (HeadImageView) view.findViewById(a.f.user_avatar);
            c0940b2.ort = (TextView) view.findViewById(a.f.tv_nickname);
            c0940b2.oru = (TextView) view.findViewById(a.f.tv_temp_nickname);
            c0940b2.orv = (ImageView) view.findViewById(a.f.iv_sex);
            c0940b2.orw = (TextView) view.findViewById(a.f.tv_level);
            c0940b2.ory = (TbImageView) view.findViewById(a.f.iv_level);
            c0940b2.orx = (FrameLayout) view.findViewById(a.f.level_container);
            c0940b2.orz = (TbImageView) view.findViewById(a.f.iv_badge);
            c0940b2.orG = (AlaAcceptAndInviteBtn) view.findViewById(a.f.tv_accept_invite);
            c0940b2.orA = (LinearLayout) view.findViewById(a.f.content_container);
            c0940b2.orB = (LinearLayout) view.findViewById(a.f.icon_container);
            view.setTag(c0940b2);
            c0940b = c0940b2;
        } else {
            c0940b = (C0940b) view.getTag();
        }
        final e eVar = (e) ListUtils.getItem(this.mList, i);
        int c = com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(14.0f, view.getContext()) + (com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(4.0f, view.getContext()) * 2);
        if (eVar != null) {
            c0940b.orG.setBtnEnabled(eVar.aIN);
            c0940b.orq.setText(Integer.toString(eVar.mPos));
            c0940b.ors.setIsRound(true);
            c0940b.ors.setAutoChangeStyle(false);
            c0940b.ors.setDefaultResource(a.e.yuyin_sdk_default_avatar);
            if (eVar != null && !TextUtils.isEmpty(eVar.mPortrait)) {
                c0940b.ors.setScaleType(ImageView.ScaleType.FIT_XY);
                c0940b.ors.setUrl(eVar.mPortrait);
                c0940b.ors.startLoad(eVar.mPortrait, 12, false);
            }
            c0940b.ort.setText(eVar.mUserName);
            c0940b.oru.setText(eVar.mUserName);
            if (eVar.mSex == 0) {
                c0940b.orv.setVisibility(8);
            } else {
                c0940b.orv.setVisibility(0);
                c0940b.orv.setImageResource(eVar.mSex == 1 ? a.e.yuyin_sdk_icon_mine_boy : a.e.yuyin_sdk_icon_mine_girl);
            }
            int i3 = eVar.mSex == 0 ? 3 : 2;
            c0940b.orx.setVisibility(8);
            c0940b.orz.setVisibility(8);
            if (eVar.mLiveMarkInfo != null) {
                i2 = c;
                for (int i4 = 0; i4 < eVar.mLiveMarkInfo.size() && i4 < i3; i4++) {
                    switch (eVar.mLiveMarkInfo.get(i4).type) {
                        case 1:
                            c0940b.orx.setVisibility(0);
                            c0940b.ory.startLoad(eVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            c0940b.orw.setText(Integer.toString(eVar.level));
                            i2 += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(13.0f, view.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(4.0f, view.getContext());
                            break;
                        case 105:
                            c0940b.orz.setVisibility(0);
                            c0940b.orz.startLoad(eVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            i2 += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(42.0f, c0940b.orz.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(4.0f, view.getContext());
                            break;
                    }
                }
                c0940b.ors.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.orC != null && view2.getTag() != null && (view2.getTag() instanceof e)) {
                            b.this.orC.a((e) view2.getTag());
                        }
                    }
                });
                c0940b.ort.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.orC != null && view2.getTag() != null && (view2.getTag() instanceof e)) {
                            b.this.orC.a((e) view2.getTag());
                        }
                    }
                });
                c0940b.ors.setTag(eVar);
                c0940b.ort.setTag(eVar);
                c0940b.orG.setTag(eVar);
                c0940b.orG.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
                c0940b.orG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (eVar.aIN || b.this.context == null) {
                            if (b.this.orC != null) {
                                if (view2.getTag() == null || !(view2.getTag() instanceof e)) {
                                    b.this.orC.b(null);
                                    return;
                                } else {
                                    b.this.orC.b((e) view2.getTag());
                                    return;
                                }
                            }
                            return;
                        }
                        BdToast.makeText(b.this.context, b.this.context.getText(a.h.yuyin_ala_apply_unable_text)).show();
                    }
                });
                c0940b.ort.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c0940b.oru.getMeasuredWidth() + i2 > c0940b.orA.getMeasuredWidth()) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0940b.ort.getLayoutParams();
                            layoutParams.weight = 1.0f;
                            c0940b.ort.setLayoutParams(layoutParams);
                            return;
                        }
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0940b.ort.getLayoutParams();
                        layoutParams2.weight = 0.0f;
                        layoutParams2.width = -2;
                        c0940b.ort.setLayoutParams(layoutParams2);
                    }
                });
                c0940b.orr.setVisibility(i != 0 ? 8 : 0);
                return view;
            }
        }
        i2 = c;
        c0940b.ors.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.orC != null && view2.getTag() != null && (view2.getTag() instanceof e)) {
                    b.this.orC.a((e) view2.getTag());
                }
            }
        });
        c0940b.ort.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.orC != null && view2.getTag() != null && (view2.getTag() instanceof e)) {
                    b.this.orC.a((e) view2.getTag());
                }
            }
        });
        c0940b.ors.setTag(eVar);
        c0940b.ort.setTag(eVar);
        c0940b.orG.setTag(eVar);
        c0940b.orG.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        c0940b.orG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (eVar.aIN || b.this.context == null) {
                    if (b.this.orC != null) {
                        if (view2.getTag() == null || !(view2.getTag() instanceof e)) {
                            b.this.orC.b(null);
                            return;
                        } else {
                            b.this.orC.b((e) view2.getTag());
                            return;
                        }
                    }
                    return;
                }
                BdToast.makeText(b.this.context, b.this.context.getText(a.h.yuyin_ala_apply_unable_text)).show();
            }
        });
        c0940b.ort.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.4
            @Override // java.lang.Runnable
            public void run() {
                if (c0940b.oru.getMeasuredWidth() + i2 > c0940b.orA.getMeasuredWidth()) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0940b.ort.getLayoutParams();
                    layoutParams.weight = 1.0f;
                    c0940b.ort.setLayoutParams(layoutParams);
                    return;
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0940b.ort.getLayoutParams();
                layoutParams2.weight = 0.0f;
                layoutParams2.width = -2;
                c0940b.ort.setLayoutParams(layoutParams2);
            }
        });
        c0940b.orr.setVisibility(i != 0 ? 8 : 0);
        return view;
    }

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0940b {
        private LinearLayout orA;
        private LinearLayout orB;
        private AlaAcceptAndInviteBtn orG;
        private TextView orq;
        private View orr;
        private HeadImageView ors;
        private TextView ort;
        private TextView oru;
        private ImageView orv;
        private TextView orw;
        private FrameLayout orx;
        private TbImageView ory;
        private TbImageView orz;

        private C0940b() {
        }
    }

    public void setOnItemClickLister(a aVar) {
        this.orC = aVar;
    }

    public void Wt(String str) {
        if (!ListUtils.isEmpty(this.mList)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mList.size()) {
                    break;
                } else if (!TextUtils.equals(str, this.mList.get(i2).uk)) {
                    i = i2 + 1;
                } else {
                    this.mList.remove(i2);
                    break;
                }
            }
            notifyDataSetChanged();
        }
    }
}
