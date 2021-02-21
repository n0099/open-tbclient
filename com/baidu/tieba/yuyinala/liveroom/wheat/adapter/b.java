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
/* loaded from: classes11.dex */
public class b extends BaseAdapter {
    private Context context;
    private List<com.baidu.live.data.e> mList;
    private int oDe = -1;
    private a oDw;

    /* loaded from: classes11.dex */
    public interface a {
        void Mm(int i);

        void a(com.baidu.live.data.e eVar);

        void b(com.baidu.live.data.e eVar);
    }

    public b(Context context) {
        this.context = context;
    }

    public void setData(List<com.baidu.live.data.e> list, int i) {
        this.mList = list;
        this.oDe = i;
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
        final C0943b c0943b;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(a.g.yuyin_item_connection_wheat_apply, (ViewGroup) null);
            C0943b c0943b2 = new C0943b();
            c0943b2.oDi = (TextView) view.findViewById(a.f.tv_rank_num);
            c0943b2.oDj = (LinearLayout) view.findViewById(a.f.item_selected_bg);
            c0943b2.oDk = view.findViewById(a.f.margin_top_height);
            c0943b2.oDl = (HeadImageView) view.findViewById(a.f.user_avatar);
            c0943b2.oDn = (ImageView) view.findViewById(a.f.team_fright_flag);
            c0943b2.oDm = (TextView) view.findViewById(a.f.tv_nickname);
            c0943b2.oDo = (TextView) view.findViewById(a.f.tv_temp_nickname);
            c0943b2.oDp = (ImageView) view.findViewById(a.f.iv_sex);
            c0943b2.oDq = (TextView) view.findViewById(a.f.tv_level);
            c0943b2.oDs = (TbImageView) view.findViewById(a.f.iv_level);
            c0943b2.oDr = (FrameLayout) view.findViewById(a.f.level_container);
            c0943b2.oDt = (TbImageView) view.findViewById(a.f.iv_badge);
            c0943b2.oDA = (AlaAcceptAndInviteBtn) view.findViewById(a.f.tv_accept_invite);
            c0943b2.oDu = (LinearLayout) view.findViewById(a.f.content_container);
            c0943b2.oDv = (LinearLayout) view.findViewById(a.f.icon_container);
            view.setTag(c0943b2);
            c0943b = c0943b2;
        } else {
            c0943b = (C0943b) view.getTag();
        }
        final com.baidu.live.data.e eVar = (com.baidu.live.data.e) ListUtils.getItem(this.mList, i);
        final int d = com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(14.0f, view.getContext()) + (com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext()) * 2);
        if (eVar != null) {
            if (!q.edM().edZ()) {
                c0943b.oDi.setTextColor(c0943b.oDi.getResources().getColor(a.c.sdk_color_B8B8B8));
                c0943b.oDn.setVisibility(8);
                c0943b.oDi.setTextSize(18.0f);
            } else {
                c0943b.oDn.setVisibility(0);
                c0943b.oDi.setTextColor(c0943b.oDi.getResources().getColor(a.c.sdk_white_alpha100));
                c0943b.oDi.setTextSize(13.0f);
                if (eVar.isApplyRedTeam()) {
                    c0943b.oDn.setImageResource(a.e.yuyin_audio_wheat_red_flag);
                } else {
                    c0943b.oDn.setImageResource(a.e.yuyin_audio_wheat_blue_flag);
                }
            }
            c0943b.oDj.setBackgroundColor(this.oDe == i ? Color.parseColor("#F5F5F5") : Color.parseColor("#FFFFFF"));
            c0943b.oDA.setSelectedState(eVar.aGj ? 1 : 0);
            c0943b.oDi.setText(Integer.toString(eVar.mPos));
            c0943b.oDl.setIsRound(true);
            c0943b.oDl.setAutoChangeStyle(false);
            c0943b.oDl.setDefaultResource(a.e.yuyin_sdk_default_avatar);
            if (eVar != null && !TextUtils.isEmpty(eVar.mPortrait)) {
                c0943b.oDl.setScaleType(ImageView.ScaleType.FIT_XY);
                c0943b.oDl.setUrl(eVar.mPortrait);
                c0943b.oDl.startLoad(eVar.mPortrait, 12, false);
            }
            c0943b.oDm.setText(eVar.mUserName);
            c0943b.oDo.setText(eVar.mUserName);
            if (eVar.mSex == 0) {
                c0943b.oDp.setVisibility(8);
            } else {
                c0943b.oDp.setVisibility(0);
                c0943b.oDp.setImageResource(eVar.mSex == 1 ? a.e.yuyin_sdk_icon_mine_boy : a.e.yuyin_sdk_icon_mine_girl);
            }
            int i2 = eVar.mSex == 0 ? 3 : 2;
            c0943b.oDr.setVisibility(8);
            c0943b.oDt.setVisibility(8);
            if (eVar.mLiveMarkInfo != null) {
                for (int i3 = 0; i3 < eVar.mLiveMarkInfo.size() && i3 < i2; i3++) {
                    switch (eVar.mLiveMarkInfo.get(i3).type) {
                        case 1:
                            c0943b.oDr.setVisibility(0);
                            c0943b.oDs.startLoad(eVar.mLiveMarkInfo.get(i3).mark_pic, 10, false);
                            c0943b.oDq.setText(Integer.toString(eVar.level));
                            d += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(13.0f, view.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext());
                            break;
                        case 105:
                            c0943b.oDt.setVisibility(0);
                            c0943b.oDt.startLoad(eVar.mLiveMarkInfo.get(i3).mark_pic, 10, false);
                            d += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(42.0f, c0943b.oDt.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext());
                            break;
                    }
                }
            }
        }
        c0943b.oDl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.oDw != null && view2.getTag() != null && (view2.getTag() instanceof com.baidu.live.data.e)) {
                    b.this.oDw.a((com.baidu.live.data.e) view2.getTag());
                }
            }
        });
        c0943b.oDm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.oDw != null && view2.getTag() != null && (view2.getTag() instanceof com.baidu.live.data.e)) {
                    b.this.oDw.a((com.baidu.live.data.e) view2.getTag());
                }
            }
        });
        c0943b.oDl.setTag(eVar);
        c0943b.oDm.setTag(eVar);
        c0943b.oDA.setTag(eVar);
        c0943b.oDA.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        c0943b.oDA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (eVar.aGj || b.this.context == null) {
                    if (b.this.oDw != null) {
                        if (view2.getTag() == null || !(view2.getTag() instanceof com.baidu.live.data.e)) {
                            b.this.oDw.b(null);
                            return;
                        } else {
                            b.this.oDw.b((com.baidu.live.data.e) view2.getTag());
                            return;
                        }
                    }
                    return;
                }
                BdToast.makeText(b.this.context, b.this.context.getText(a.h.yuyin_ala_apply_unable_text)).show();
            }
        });
        c0943b.oDm.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.4
            @Override // java.lang.Runnable
            public void run() {
                if (c0943b.oDo.getMeasuredWidth() + d > c0943b.oDu.getMeasuredWidth()) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0943b.oDm.getLayoutParams();
                    layoutParams.weight = 1.0f;
                    c0943b.oDm.setLayoutParams(layoutParams);
                    return;
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0943b.oDm.getLayoutParams();
                layoutParams2.weight = 0.0f;
                layoutParams2.width = -2;
                c0943b.oDm.setLayoutParams(layoutParams2);
            }
        });
        c0943b.oDk.setVisibility(i != 0 ? 8 : 0);
        return view;
    }

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0943b {
        private AlaAcceptAndInviteBtn oDA;
        private TextView oDi;
        private LinearLayout oDj;
        private View oDk;
        private HeadImageView oDl;
        private TextView oDm;
        private ImageView oDn;
        private TextView oDo;
        private ImageView oDp;
        private TextView oDq;
        private FrameLayout oDr;
        private TbImageView oDs;
        private TbImageView oDt;
        private LinearLayout oDu;
        private LinearLayout oDv;

        private C0943b() {
        }
    }

    public void setOnItemClickLister(a aVar) {
        this.oDw = aVar;
    }

    public void We(String str) {
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
