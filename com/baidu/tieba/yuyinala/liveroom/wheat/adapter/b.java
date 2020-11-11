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
    private a oaX;

    /* loaded from: classes4.dex */
    public interface a {
        void Mm(int i);

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
        final C0920b c0920b;
        final int i2;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(a.g.yuyin_item_connection_wheat_apply, (ViewGroup) null);
            C0920b c0920b2 = new C0920b();
            c0920b2.oaL = (TextView) view.findViewById(a.f.tv_rank_num);
            c0920b2.oaM = view.findViewById(a.f.margin_top_height);
            c0920b2.oaN = (HeadImageView) view.findViewById(a.f.user_avatar);
            c0920b2.oaO = (TextView) view.findViewById(a.f.tv_nickname);
            c0920b2.oaP = (TextView) view.findViewById(a.f.tv_temp_nickname);
            c0920b2.oaQ = (ImageView) view.findViewById(a.f.iv_sex);
            c0920b2.oaR = (TextView) view.findViewById(a.f.tv_level);
            c0920b2.oaT = (TbImageView) view.findViewById(a.f.iv_level);
            c0920b2.oaS = (FrameLayout) view.findViewById(a.f.level_container);
            c0920b2.oaU = (TbImageView) view.findViewById(a.f.iv_badge);
            c0920b2.obb = (AlaAcceptAndInviteBtn) view.findViewById(a.f.tv_accept_invite);
            c0920b2.oaV = (LinearLayout) view.findViewById(a.f.content_container);
            c0920b2.oaW = (LinearLayout) view.findViewById(a.f.icon_container);
            view.setTag(c0920b2);
            c0920b = c0920b2;
        } else {
            c0920b = (C0920b) view.getTag();
        }
        final e eVar = (e) ListUtils.getItem(this.mList, i);
        int c = com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(14.0f, view.getContext()) + (com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(4.0f, view.getContext()) * 2);
        if (eVar != null) {
            c0920b.obb.setBtnEnabled(eVar.aHP);
            c0920b.oaL.setText(Integer.toString(eVar.mPos));
            c0920b.oaN.setIsRound(true);
            c0920b.oaN.setAutoChangeStyle(false);
            c0920b.oaN.setDefaultResource(a.e.yuyin_sdk_default_avatar);
            if (eVar != null && !TextUtils.isEmpty(eVar.mPortrait)) {
                c0920b.oaN.setScaleType(ImageView.ScaleType.FIT_XY);
                c0920b.oaN.setUrl(eVar.mPortrait);
                c0920b.oaN.startLoad(eVar.mPortrait, 12, false);
            }
            c0920b.oaO.setText(eVar.mUserName);
            c0920b.oaP.setText(eVar.mUserName);
            if (eVar.mSex == 0) {
                c0920b.oaQ.setVisibility(8);
            } else {
                c0920b.oaQ.setVisibility(0);
                c0920b.oaQ.setImageResource(eVar.mSex == 1 ? a.e.yuyin_sdk_icon_mine_boy : a.e.yuyin_sdk_icon_mine_girl);
            }
            int i3 = eVar.mSex == 0 ? 3 : 2;
            c0920b.oaS.setVisibility(8);
            c0920b.oaU.setVisibility(8);
            if (eVar.mLiveMarkInfo != null) {
                i2 = c;
                for (int i4 = 0; i4 < eVar.mLiveMarkInfo.size() && i4 < i3; i4++) {
                    switch (eVar.mLiveMarkInfo.get(i4).type) {
                        case 1:
                            c0920b.oaS.setVisibility(0);
                            c0920b.oaT.startLoad(eVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            c0920b.oaR.setText(Integer.toString(eVar.level));
                            i2 += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(13.0f, view.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(4.0f, view.getContext());
                            break;
                        case 105:
                            c0920b.oaU.setVisibility(0);
                            c0920b.oaU.startLoad(eVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            i2 += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(42.0f, c0920b.oaU.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(4.0f, view.getContext());
                            break;
                    }
                }
                c0920b.oaN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.oaX != null && view2.getTag() != null && (view2.getTag() instanceof e)) {
                            b.this.oaX.a((e) view2.getTag());
                        }
                    }
                });
                c0920b.oaO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.oaX != null && view2.getTag() != null && (view2.getTag() instanceof e)) {
                            b.this.oaX.a((e) view2.getTag());
                        }
                    }
                });
                c0920b.oaN.setTag(eVar);
                c0920b.oaO.setTag(eVar);
                c0920b.obb.setTag(eVar);
                c0920b.obb.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
                c0920b.obb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (eVar.aHP || b.this.context == null) {
                            if (b.this.oaX != null) {
                                if (view2.getTag() == null || !(view2.getTag() instanceof e)) {
                                    b.this.oaX.b(null);
                                    return;
                                } else {
                                    b.this.oaX.b((e) view2.getTag());
                                    return;
                                }
                            }
                            return;
                        }
                        BdToast.makeText(b.this.context, b.this.context.getText(a.h.yuyin_ala_apply_unable_text)).show();
                    }
                });
                c0920b.oaO.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c0920b.oaP.getMeasuredWidth() + i2 > c0920b.oaV.getMeasuredWidth()) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0920b.oaO.getLayoutParams();
                            layoutParams.weight = 1.0f;
                            c0920b.oaO.setLayoutParams(layoutParams);
                            return;
                        }
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0920b.oaO.getLayoutParams();
                        layoutParams2.weight = 0.0f;
                        layoutParams2.width = -2;
                        c0920b.oaO.setLayoutParams(layoutParams2);
                    }
                });
                c0920b.oaM.setVisibility(i != 0 ? 8 : 0);
                return view;
            }
        }
        i2 = c;
        c0920b.oaN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.oaX != null && view2.getTag() != null && (view2.getTag() instanceof e)) {
                    b.this.oaX.a((e) view2.getTag());
                }
            }
        });
        c0920b.oaO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.oaX != null && view2.getTag() != null && (view2.getTag() instanceof e)) {
                    b.this.oaX.a((e) view2.getTag());
                }
            }
        });
        c0920b.oaN.setTag(eVar);
        c0920b.oaO.setTag(eVar);
        c0920b.obb.setTag(eVar);
        c0920b.obb.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        c0920b.obb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (eVar.aHP || b.this.context == null) {
                    if (b.this.oaX != null) {
                        if (view2.getTag() == null || !(view2.getTag() instanceof e)) {
                            b.this.oaX.b(null);
                            return;
                        } else {
                            b.this.oaX.b((e) view2.getTag());
                            return;
                        }
                    }
                    return;
                }
                BdToast.makeText(b.this.context, b.this.context.getText(a.h.yuyin_ala_apply_unable_text)).show();
            }
        });
        c0920b.oaO.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.4
            @Override // java.lang.Runnable
            public void run() {
                if (c0920b.oaP.getMeasuredWidth() + i2 > c0920b.oaV.getMeasuredWidth()) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0920b.oaO.getLayoutParams();
                    layoutParams.weight = 1.0f;
                    c0920b.oaO.setLayoutParams(layoutParams);
                    return;
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0920b.oaO.getLayoutParams();
                layoutParams2.weight = 0.0f;
                layoutParams2.width = -2;
                c0920b.oaO.setLayoutParams(layoutParams2);
            }
        });
        c0920b.oaM.setVisibility(i != 0 ? 8 : 0);
        return view;
    }

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0920b {
        private TextView oaL;
        private View oaM;
        private HeadImageView oaN;
        private TextView oaO;
        private TextView oaP;
        private ImageView oaQ;
        private TextView oaR;
        private FrameLayout oaS;
        private TbImageView oaT;
        private TbImageView oaU;
        private LinearLayout oaV;
        private LinearLayout oaW;
        private AlaAcceptAndInviteBtn obb;

        private C0920b() {
        }
    }

    public void setOnItemClickLister(a aVar) {
        this.oaX = aVar;
    }

    public void Vt(String str) {
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
