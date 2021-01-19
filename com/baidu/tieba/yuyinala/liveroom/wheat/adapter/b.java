package com.baidu.tieba.yuyinala.liveroom.wheat.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.AlaAcceptAndInviteBtn;
import java.util.List;
/* loaded from: classes10.dex */
public class b extends BaseAdapter {
    private Context context;
    private List<com.baidu.live.data.e> mList;
    private int osT = -1;
    private a otl;

    /* loaded from: classes10.dex */
    public interface a {
        void LQ(int i);

        void a(com.baidu.live.data.e eVar);

        void b(com.baidu.live.data.e eVar);
    }

    public b(Context context) {
        this.context = context;
    }

    public void setData(List<com.baidu.live.data.e> list, int i) {
        this.mList = list;
        this.osT = i;
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

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final C0937b c0937b;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(a.g.yuyin_item_connection_wheat_apply, (ViewGroup) null);
            C0937b c0937b2 = new C0937b();
            c0937b2.osX = (TextView) view.findViewById(a.f.tv_rank_num);
            c0937b2.osY = (LinearLayout) view.findViewById(a.f.item_selected_bg);
            c0937b2.osZ = view.findViewById(a.f.margin_top_height);
            c0937b2.ota = (HeadImageView) view.findViewById(a.f.user_avatar);
            c0937b2.otc = (ImageView) view.findViewById(a.f.team_fright_flag);
            c0937b2.otb = (TextView) view.findViewById(a.f.tv_nickname);
            c0937b2.otd = (TextView) view.findViewById(a.f.tv_temp_nickname);
            c0937b2.ote = (ImageView) view.findViewById(a.f.iv_sex);
            c0937b2.otf = (TextView) view.findViewById(a.f.tv_level);
            c0937b2.oth = (TbImageView) view.findViewById(a.f.iv_level);
            c0937b2.otg = (FrameLayout) view.findViewById(a.f.level_container);
            c0937b2.oti = (TbImageView) view.findViewById(a.f.iv_badge);
            c0937b2.otp = (AlaAcceptAndInviteBtn) view.findViewById(a.f.tv_accept_invite);
            c0937b2.otj = (LinearLayout) view.findViewById(a.f.content_container);
            c0937b2.otk = (LinearLayout) view.findViewById(a.f.icon_container);
            view.setTag(c0937b2);
            c0937b = c0937b2;
        } else {
            c0937b = (C0937b) view.getTag();
        }
        final com.baidu.live.data.e eVar = (com.baidu.live.data.e) ListUtils.getItem(this.mList, i);
        final int d = com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(14.0f, view.getContext()) + (com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext()) * 2);
        if (eVar != null) {
            if (!o.ebo().ebE()) {
                c0937b.osX.setTextColor(c0937b.osX.getResources().getColor(a.c.sdk_color_B8B8B8));
                c0937b.otc.setVisibility(8);
                c0937b.osX.setTextSize(18.0f);
            } else {
                c0937b.otc.setVisibility(0);
                c0937b.osX.setTextColor(c0937b.osX.getResources().getColor(a.c.sdk_white_alpha100));
                c0937b.osX.setTextSize(13.0f);
                if (eVar.isApplyRedTeam()) {
                    c0937b.otc.setImageResource(a.e.yuyin_audio_wheat_red_flag);
                } else {
                    c0937b.otc.setImageResource(a.e.yuyin_audio_wheat_blue_flag);
                }
            }
            c0937b.osY.setBackgroundColor(this.osT == i ? Color.parseColor("#F5F5F5") : Color.parseColor("#FFFFFF"));
            c0937b.otp.setSelectedState(eVar.aEw ? 1 : 0);
            c0937b.osX.setText(Integer.toString(eVar.mPos));
            c0937b.ota.setIsRound(true);
            c0937b.ota.setAutoChangeStyle(false);
            c0937b.ota.setDefaultResource(a.e.yuyin_sdk_default_avatar);
            if (eVar != null && !TextUtils.isEmpty(eVar.mPortrait)) {
                c0937b.ota.setScaleType(ImageView.ScaleType.FIT_XY);
                c0937b.ota.setUrl(eVar.mPortrait);
                c0937b.ota.startLoad(eVar.mPortrait, 12, false);
            }
            c0937b.otb.setText(eVar.mUserName);
            c0937b.otd.setText(eVar.mUserName);
            if (eVar.mSex == 0) {
                c0937b.ote.setVisibility(8);
            } else {
                c0937b.ote.setVisibility(0);
                c0937b.ote.setImageResource(eVar.mSex == 1 ? a.e.yuyin_sdk_icon_mine_boy : a.e.yuyin_sdk_icon_mine_girl);
            }
            int i2 = eVar.mSex == 0 ? 3 : 2;
            c0937b.otg.setVisibility(8);
            c0937b.oti.setVisibility(8);
            if (eVar.mLiveMarkInfo != null) {
                for (int i3 = 0; i3 < eVar.mLiveMarkInfo.size() && i3 < i2; i3++) {
                    switch (eVar.mLiveMarkInfo.get(i3).type) {
                        case 1:
                            c0937b.otg.setVisibility(0);
                            c0937b.oth.startLoad(eVar.mLiveMarkInfo.get(i3).mark_pic, 10, false);
                            c0937b.otf.setText(Integer.toString(eVar.level));
                            d += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(13.0f, view.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext());
                            break;
                        case 105:
                            c0937b.oti.setVisibility(0);
                            c0937b.oti.startLoad(eVar.mLiveMarkInfo.get(i3).mark_pic, 10, false);
                            d += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(42.0f, c0937b.oti.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext());
                            break;
                    }
                }
            }
        }
        c0937b.ota.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.otl != null && view2.getTag() != null && (view2.getTag() instanceof com.baidu.live.data.e)) {
                    b.this.otl.a((com.baidu.live.data.e) view2.getTag());
                }
            }
        });
        c0937b.otb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.otl != null && view2.getTag() != null && (view2.getTag() instanceof com.baidu.live.data.e)) {
                    b.this.otl.a((com.baidu.live.data.e) view2.getTag());
                }
            }
        });
        c0937b.ota.setTag(eVar);
        c0937b.otb.setTag(eVar);
        c0937b.otp.setTag(eVar);
        c0937b.otp.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        c0937b.otp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (eVar.aEw || b.this.context == null) {
                    if (b.this.otl != null) {
                        if (view2.getTag() == null || !(view2.getTag() instanceof com.baidu.live.data.e)) {
                            b.this.otl.b(null);
                            return;
                        } else {
                            b.this.otl.b((com.baidu.live.data.e) view2.getTag());
                            return;
                        }
                    }
                    return;
                }
                BdToast.makeText(b.this.context, b.this.context.getText(a.h.yuyin_ala_apply_unable_text)).show();
            }
        });
        c0937b.otb.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.4
            @Override // java.lang.Runnable
            public void run() {
                if (c0937b.otd.getMeasuredWidth() + d > c0937b.otj.getMeasuredWidth()) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0937b.otb.getLayoutParams();
                    layoutParams.weight = 1.0f;
                    c0937b.otb.setLayoutParams(layoutParams);
                    return;
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0937b.otb.getLayoutParams();
                layoutParams2.weight = 0.0f;
                layoutParams2.width = -2;
                c0937b.otb.setLayoutParams(layoutParams2);
            }
        });
        c0937b.osZ.setVisibility(i != 0 ? 8 : 0);
        return view;
    }

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private class C0937b {
        private TextView osX;
        private LinearLayout osY;
        private View osZ;
        private HeadImageView ota;
        private TextView otb;
        private ImageView otc;
        private TextView otd;
        private ImageView ote;
        private TextView otf;
        private FrameLayout otg;
        private TbImageView oth;
        private TbImageView oti;
        private LinearLayout otj;
        private LinearLayout otk;
        private AlaAcceptAndInviteBtn otp;

        private C0937b() {
        }
    }

    public void setOnItemClickLister(a aVar) {
        this.otl = aVar;
    }

    public void UU(String str) {
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
