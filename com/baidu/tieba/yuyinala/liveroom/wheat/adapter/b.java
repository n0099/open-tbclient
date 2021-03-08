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
import com.baidu.tieba.yuyinala.liveroom.wheat.c.q;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.AlaAcceptAndInviteBtn;
import java.util.List;
/* loaded from: classes10.dex */
public class b extends BaseAdapter {
    private Context context;
    private List<com.baidu.live.data.e> mList;
    private a oFB;
    private int oFj = -1;

    /* loaded from: classes10.dex */
    public interface a {
        void Mq(int i);

        void a(com.baidu.live.data.e eVar);

        void b(com.baidu.live.data.e eVar);
    }

    public b(Context context) {
        this.context = context;
    }

    public void setData(List<com.baidu.live.data.e> list, int i) {
        this.mList = list;
        this.oFj = i;
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
        final C0949b c0949b;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(a.g.yuyin_item_connection_wheat_apply, (ViewGroup) null);
            C0949b c0949b2 = new C0949b();
            c0949b2.oFn = (TextView) view.findViewById(a.f.tv_rank_num);
            c0949b2.oFo = (LinearLayout) view.findViewById(a.f.item_selected_bg);
            c0949b2.oFp = view.findViewById(a.f.margin_top_height);
            c0949b2.oFq = (HeadImageView) view.findViewById(a.f.user_avatar);
            c0949b2.oFs = (ImageView) view.findViewById(a.f.team_fright_flag);
            c0949b2.oFr = (TextView) view.findViewById(a.f.tv_nickname);
            c0949b2.oFt = (TextView) view.findViewById(a.f.tv_temp_nickname);
            c0949b2.oFu = (ImageView) view.findViewById(a.f.iv_sex);
            c0949b2.oFv = (TextView) view.findViewById(a.f.tv_level);
            c0949b2.oFx = (TbImageView) view.findViewById(a.f.iv_level);
            c0949b2.oFw = (FrameLayout) view.findViewById(a.f.level_container);
            c0949b2.oFy = (TbImageView) view.findViewById(a.f.iv_badge);
            c0949b2.oFF = (AlaAcceptAndInviteBtn) view.findViewById(a.f.tv_accept_invite);
            c0949b2.oFz = (LinearLayout) view.findViewById(a.f.content_container);
            c0949b2.oFA = (LinearLayout) view.findViewById(a.f.icon_container);
            view.setTag(c0949b2);
            c0949b = c0949b2;
        } else {
            c0949b = (C0949b) view.getTag();
        }
        final com.baidu.live.data.e eVar = (com.baidu.live.data.e) ListUtils.getItem(this.mList, i);
        final int d = com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(14.0f, view.getContext()) + (com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext()) * 2);
        if (eVar != null) {
            if (!q.edU().eeh()) {
                c0949b.oFn.setTextColor(c0949b.oFn.getResources().getColor(a.c.sdk_color_B8B8B8));
                c0949b.oFs.setVisibility(8);
                c0949b.oFn.setTextSize(18.0f);
            } else {
                c0949b.oFs.setVisibility(0);
                c0949b.oFn.setTextColor(c0949b.oFn.getResources().getColor(a.c.sdk_white_alpha100));
                c0949b.oFn.setTextSize(13.0f);
                if (eVar.isApplyRedTeam()) {
                    c0949b.oFs.setImageResource(a.e.yuyin_audio_wheat_red_flag);
                } else {
                    c0949b.oFs.setImageResource(a.e.yuyin_audio_wheat_blue_flag);
                }
            }
            c0949b.oFo.setBackgroundColor(this.oFj == i ? Color.parseColor("#F5F5F5") : Color.parseColor("#FFFFFF"));
            c0949b.oFF.setSelectedState(eVar.aHJ ? 1 : 0);
            c0949b.oFn.setText(Integer.toString(eVar.mPos));
            c0949b.oFq.setIsRound(true);
            c0949b.oFq.setAutoChangeStyle(false);
            c0949b.oFq.setDefaultResource(a.e.yuyin_sdk_default_avatar);
            if (eVar != null && !TextUtils.isEmpty(eVar.mPortrait)) {
                c0949b.oFq.setScaleType(ImageView.ScaleType.FIT_XY);
                c0949b.oFq.setUrl(eVar.mPortrait);
                c0949b.oFq.startLoad(eVar.mPortrait, 12, false);
            }
            c0949b.oFr.setText(eVar.mUserName);
            c0949b.oFt.setText(eVar.mUserName);
            if (eVar.mSex == 0) {
                c0949b.oFu.setVisibility(8);
            } else {
                c0949b.oFu.setVisibility(0);
                c0949b.oFu.setImageResource(eVar.mSex == 1 ? a.e.yuyin_sdk_icon_mine_boy : a.e.yuyin_sdk_icon_mine_girl);
            }
            int i2 = eVar.mSex == 0 ? 3 : 2;
            c0949b.oFw.setVisibility(8);
            c0949b.oFy.setVisibility(8);
            if (eVar.mLiveMarkInfo != null) {
                for (int i3 = 0; i3 < eVar.mLiveMarkInfo.size() && i3 < i2; i3++) {
                    switch (eVar.mLiveMarkInfo.get(i3).type) {
                        case 1:
                            c0949b.oFw.setVisibility(0);
                            c0949b.oFx.startLoad(eVar.mLiveMarkInfo.get(i3).mark_pic, 10, false);
                            c0949b.oFv.setText(Integer.toString(eVar.level));
                            d += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(13.0f, view.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext());
                            break;
                        case 105:
                            c0949b.oFy.setVisibility(0);
                            c0949b.oFy.startLoad(eVar.mLiveMarkInfo.get(i3).mark_pic, 10, false);
                            d += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(42.0f, c0949b.oFy.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext());
                            break;
                    }
                }
            }
        }
        c0949b.oFq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.oFB != null && view2.getTag() != null && (view2.getTag() instanceof com.baidu.live.data.e)) {
                    b.this.oFB.a((com.baidu.live.data.e) view2.getTag());
                }
            }
        });
        c0949b.oFr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.oFB != null && view2.getTag() != null && (view2.getTag() instanceof com.baidu.live.data.e)) {
                    b.this.oFB.a((com.baidu.live.data.e) view2.getTag());
                }
            }
        });
        c0949b.oFq.setTag(eVar);
        c0949b.oFr.setTag(eVar);
        c0949b.oFF.setTag(eVar);
        c0949b.oFF.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        c0949b.oFF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (eVar.aHJ || b.this.context == null) {
                    if (b.this.oFB != null) {
                        if (view2.getTag() == null || !(view2.getTag() instanceof com.baidu.live.data.e)) {
                            b.this.oFB.b(null);
                            return;
                        } else {
                            b.this.oFB.b((com.baidu.live.data.e) view2.getTag());
                            return;
                        }
                    }
                    return;
                }
                BdToast.makeText(b.this.context, b.this.context.getText(a.h.yuyin_ala_apply_unable_text)).show();
            }
        });
        c0949b.oFr.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.4
            @Override // java.lang.Runnable
            public void run() {
                if (c0949b.oFt.getMeasuredWidth() + d > c0949b.oFz.getMeasuredWidth()) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0949b.oFr.getLayoutParams();
                    layoutParams.weight = 1.0f;
                    c0949b.oFr.setLayoutParams(layoutParams);
                    return;
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0949b.oFr.getLayoutParams();
                layoutParams2.weight = 0.0f;
                layoutParams2.width = -2;
                c0949b.oFr.setLayoutParams(layoutParams2);
            }
        });
        c0949b.oFp.setVisibility(i != 0 ? 8 : 0);
        return view;
    }

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private class C0949b {
        private LinearLayout oFA;
        private AlaAcceptAndInviteBtn oFF;
        private TextView oFn;
        private LinearLayout oFo;
        private View oFp;
        private HeadImageView oFq;
        private TextView oFr;
        private ImageView oFs;
        private TextView oFt;
        private ImageView oFu;
        private TextView oFv;
        private FrameLayout oFw;
        private TbImageView oFx;
        private TbImageView oFy;
        private LinearLayout oFz;

        private C0949b() {
        }
    }

    public void setOnItemClickLister(a aVar) {
        this.oFB = aVar;
    }

    public void Wl(String str) {
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
