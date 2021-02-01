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
    private int oCE = -1;
    private a oCW;

    /* loaded from: classes11.dex */
    public interface a {
        void Ml(int i);

        void a(com.baidu.live.data.e eVar);

        void b(com.baidu.live.data.e eVar);
    }

    public b(Context context) {
        this.context = context;
    }

    public void setData(List<com.baidu.live.data.e> list, int i) {
        this.mList = list;
        this.oCE = i;
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
        final C0941b c0941b;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(a.g.yuyin_item_connection_wheat_apply, (ViewGroup) null);
            C0941b c0941b2 = new C0941b();
            c0941b2.oCI = (TextView) view.findViewById(a.f.tv_rank_num);
            c0941b2.oCJ = (LinearLayout) view.findViewById(a.f.item_selected_bg);
            c0941b2.oCK = view.findViewById(a.f.margin_top_height);
            c0941b2.oCL = (HeadImageView) view.findViewById(a.f.user_avatar);
            c0941b2.oCN = (ImageView) view.findViewById(a.f.team_fright_flag);
            c0941b2.oCM = (TextView) view.findViewById(a.f.tv_nickname);
            c0941b2.oCO = (TextView) view.findViewById(a.f.tv_temp_nickname);
            c0941b2.oCP = (ImageView) view.findViewById(a.f.iv_sex);
            c0941b2.oCQ = (TextView) view.findViewById(a.f.tv_level);
            c0941b2.oCS = (TbImageView) view.findViewById(a.f.iv_level);
            c0941b2.oCR = (FrameLayout) view.findViewById(a.f.level_container);
            c0941b2.oCT = (TbImageView) view.findViewById(a.f.iv_badge);
            c0941b2.oDa = (AlaAcceptAndInviteBtn) view.findViewById(a.f.tv_accept_invite);
            c0941b2.oCU = (LinearLayout) view.findViewById(a.f.content_container);
            c0941b2.oCV = (LinearLayout) view.findViewById(a.f.icon_container);
            view.setTag(c0941b2);
            c0941b = c0941b2;
        } else {
            c0941b = (C0941b) view.getTag();
        }
        final com.baidu.live.data.e eVar = (com.baidu.live.data.e) ListUtils.getItem(this.mList, i);
        final int d = com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(14.0f, view.getContext()) + (com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext()) * 2);
        if (eVar != null) {
            if (!q.edE().edR()) {
                c0941b.oCI.setTextColor(c0941b.oCI.getResources().getColor(a.c.sdk_color_B8B8B8));
                c0941b.oCN.setVisibility(8);
                c0941b.oCI.setTextSize(18.0f);
            } else {
                c0941b.oCN.setVisibility(0);
                c0941b.oCI.setTextColor(c0941b.oCI.getResources().getColor(a.c.sdk_white_alpha100));
                c0941b.oCI.setTextSize(13.0f);
                if (eVar.isApplyRedTeam()) {
                    c0941b.oCN.setImageResource(a.e.yuyin_audio_wheat_red_flag);
                } else {
                    c0941b.oCN.setImageResource(a.e.yuyin_audio_wheat_blue_flag);
                }
            }
            c0941b.oCJ.setBackgroundColor(this.oCE == i ? Color.parseColor("#F5F5F5") : Color.parseColor("#FFFFFF"));
            c0941b.oDa.setSelectedState(eVar.aGj ? 1 : 0);
            c0941b.oCI.setText(Integer.toString(eVar.mPos));
            c0941b.oCL.setIsRound(true);
            c0941b.oCL.setAutoChangeStyle(false);
            c0941b.oCL.setDefaultResource(a.e.yuyin_sdk_default_avatar);
            if (eVar != null && !TextUtils.isEmpty(eVar.mPortrait)) {
                c0941b.oCL.setScaleType(ImageView.ScaleType.FIT_XY);
                c0941b.oCL.setUrl(eVar.mPortrait);
                c0941b.oCL.startLoad(eVar.mPortrait, 12, false);
            }
            c0941b.oCM.setText(eVar.mUserName);
            c0941b.oCO.setText(eVar.mUserName);
            if (eVar.mSex == 0) {
                c0941b.oCP.setVisibility(8);
            } else {
                c0941b.oCP.setVisibility(0);
                c0941b.oCP.setImageResource(eVar.mSex == 1 ? a.e.yuyin_sdk_icon_mine_boy : a.e.yuyin_sdk_icon_mine_girl);
            }
            int i2 = eVar.mSex == 0 ? 3 : 2;
            c0941b.oCR.setVisibility(8);
            c0941b.oCT.setVisibility(8);
            if (eVar.mLiveMarkInfo != null) {
                for (int i3 = 0; i3 < eVar.mLiveMarkInfo.size() && i3 < i2; i3++) {
                    switch (eVar.mLiveMarkInfo.get(i3).type) {
                        case 1:
                            c0941b.oCR.setVisibility(0);
                            c0941b.oCS.startLoad(eVar.mLiveMarkInfo.get(i3).mark_pic, 10, false);
                            c0941b.oCQ.setText(Integer.toString(eVar.level));
                            d += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(13.0f, view.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext());
                            break;
                        case 105:
                            c0941b.oCT.setVisibility(0);
                            c0941b.oCT.startLoad(eVar.mLiveMarkInfo.get(i3).mark_pic, 10, false);
                            d += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(42.0f, c0941b.oCT.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext());
                            break;
                    }
                }
            }
        }
        c0941b.oCL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.oCW != null && view2.getTag() != null && (view2.getTag() instanceof com.baidu.live.data.e)) {
                    b.this.oCW.a((com.baidu.live.data.e) view2.getTag());
                }
            }
        });
        c0941b.oCM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.oCW != null && view2.getTag() != null && (view2.getTag() instanceof com.baidu.live.data.e)) {
                    b.this.oCW.a((com.baidu.live.data.e) view2.getTag());
                }
            }
        });
        c0941b.oCL.setTag(eVar);
        c0941b.oCM.setTag(eVar);
        c0941b.oDa.setTag(eVar);
        c0941b.oDa.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        c0941b.oDa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (eVar.aGj || b.this.context == null) {
                    if (b.this.oCW != null) {
                        if (view2.getTag() == null || !(view2.getTag() instanceof com.baidu.live.data.e)) {
                            b.this.oCW.b(null);
                            return;
                        } else {
                            b.this.oCW.b((com.baidu.live.data.e) view2.getTag());
                            return;
                        }
                    }
                    return;
                }
                BdToast.makeText(b.this.context, b.this.context.getText(a.h.yuyin_ala_apply_unable_text)).show();
            }
        });
        c0941b.oCM.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.4
            @Override // java.lang.Runnable
            public void run() {
                if (c0941b.oCO.getMeasuredWidth() + d > c0941b.oCU.getMeasuredWidth()) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0941b.oCM.getLayoutParams();
                    layoutParams.weight = 1.0f;
                    c0941b.oCM.setLayoutParams(layoutParams);
                    return;
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0941b.oCM.getLayoutParams();
                layoutParams2.weight = 0.0f;
                layoutParams2.width = -2;
                c0941b.oCM.setLayoutParams(layoutParams2);
            }
        });
        c0941b.oCK.setVisibility(i != 0 ? 8 : 0);
        return view;
    }

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0941b {
        private TextView oCI;
        private LinearLayout oCJ;
        private View oCK;
        private HeadImageView oCL;
        private TextView oCM;
        private ImageView oCN;
        private TextView oCO;
        private ImageView oCP;
        private TextView oCQ;
        private FrameLayout oCR;
        private TbImageView oCS;
        private TbImageView oCT;
        private LinearLayout oCU;
        private LinearLayout oCV;
        private AlaAcceptAndInviteBtn oDa;

        private C0941b() {
        }
    }

    public void setOnItemClickLister(a aVar) {
        this.oCW = aVar;
    }

    public void VS(String str) {
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
