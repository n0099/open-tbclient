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
/* loaded from: classes11.dex */
public class b extends BaseAdapter {
    private Context context;
    private List<com.baidu.live.data.e> mList;
    private a oxR;
    private int oxz = -1;

    /* loaded from: classes11.dex */
    public interface a {
        void Nx(int i);

        void a(com.baidu.live.data.e eVar);

        void b(com.baidu.live.data.e eVar);
    }

    public b(Context context) {
        this.context = context;
    }

    public void setData(List<com.baidu.live.data.e> list, int i) {
        this.mList = list;
        this.oxz = i;
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
        final C0916b c0916b;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(a.g.yuyin_item_connection_wheat_apply, (ViewGroup) null);
            C0916b c0916b2 = new C0916b();
            c0916b2.oxD = (TextView) view.findViewById(a.f.tv_rank_num);
            c0916b2.oxE = (LinearLayout) view.findViewById(a.f.item_selected_bg);
            c0916b2.oxF = view.findViewById(a.f.margin_top_height);
            c0916b2.oxG = (HeadImageView) view.findViewById(a.f.user_avatar);
            c0916b2.oxI = (ImageView) view.findViewById(a.f.team_fright_flag);
            c0916b2.oxH = (TextView) view.findViewById(a.f.tv_nickname);
            c0916b2.oxJ = (TextView) view.findViewById(a.f.tv_temp_nickname);
            c0916b2.oxK = (ImageView) view.findViewById(a.f.iv_sex);
            c0916b2.oxL = (TextView) view.findViewById(a.f.tv_level);
            c0916b2.oxN = (TbImageView) view.findViewById(a.f.iv_level);
            c0916b2.oxM = (FrameLayout) view.findViewById(a.f.level_container);
            c0916b2.oxO = (TbImageView) view.findViewById(a.f.iv_badge);
            c0916b2.oxV = (AlaAcceptAndInviteBtn) view.findViewById(a.f.tv_accept_invite);
            c0916b2.oxP = (LinearLayout) view.findViewById(a.f.content_container);
            c0916b2.oxQ = (LinearLayout) view.findViewById(a.f.icon_container);
            view.setTag(c0916b2);
            c0916b = c0916b2;
        } else {
            c0916b = (C0916b) view.getTag();
        }
        final com.baidu.live.data.e eVar = (com.baidu.live.data.e) ListUtils.getItem(this.mList, i);
        final int c = com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(14.0f, view.getContext()) + (com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(4.0f, view.getContext()) * 2);
        if (eVar != null) {
            if (!o.eff().efv()) {
                c0916b.oxD.setTextColor(c0916b.oxD.getResources().getColor(a.c.sdk_color_B8B8B8));
                c0916b.oxI.setVisibility(8);
                c0916b.oxD.setTextSize(18.0f);
            } else {
                c0916b.oxI.setVisibility(0);
                c0916b.oxD.setTextColor(c0916b.oxD.getResources().getColor(a.c.sdk_white_alpha100));
                c0916b.oxD.setTextSize(13.0f);
                if (eVar.isApplyRedTeam()) {
                    c0916b.oxI.setImageResource(a.e.yuyin_audio_wheat_red_flag);
                } else {
                    c0916b.oxI.setImageResource(a.e.yuyin_audio_wheat_blue_flag);
                }
            }
            c0916b.oxE.setBackgroundColor(this.oxz == i ? Color.parseColor("#F5F5F5") : Color.parseColor("#FFFFFF"));
            c0916b.oxV.setSelectedState(eVar.aJj ? 1 : 0);
            c0916b.oxD.setText(Integer.toString(eVar.mPos));
            c0916b.oxG.setIsRound(true);
            c0916b.oxG.setAutoChangeStyle(false);
            c0916b.oxG.setDefaultResource(a.e.yuyin_sdk_default_avatar);
            if (eVar != null && !TextUtils.isEmpty(eVar.mPortrait)) {
                c0916b.oxG.setScaleType(ImageView.ScaleType.FIT_XY);
                c0916b.oxG.setUrl(eVar.mPortrait);
                c0916b.oxG.startLoad(eVar.mPortrait, 12, false);
            }
            c0916b.oxH.setText(eVar.mUserName);
            c0916b.oxJ.setText(eVar.mUserName);
            if (eVar.mSex == 0) {
                c0916b.oxK.setVisibility(8);
            } else {
                c0916b.oxK.setVisibility(0);
                c0916b.oxK.setImageResource(eVar.mSex == 1 ? a.e.yuyin_sdk_icon_mine_boy : a.e.yuyin_sdk_icon_mine_girl);
            }
            int i2 = eVar.mSex == 0 ? 3 : 2;
            c0916b.oxM.setVisibility(8);
            c0916b.oxO.setVisibility(8);
            if (eVar.mLiveMarkInfo != null) {
                for (int i3 = 0; i3 < eVar.mLiveMarkInfo.size() && i3 < i2; i3++) {
                    switch (eVar.mLiveMarkInfo.get(i3).type) {
                        case 1:
                            c0916b.oxM.setVisibility(0);
                            c0916b.oxN.startLoad(eVar.mLiveMarkInfo.get(i3).mark_pic, 10, false);
                            c0916b.oxL.setText(Integer.toString(eVar.level));
                            c += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(13.0f, view.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(4.0f, view.getContext());
                            break;
                        case 105:
                            c0916b.oxO.setVisibility(0);
                            c0916b.oxO.startLoad(eVar.mLiveMarkInfo.get(i3).mark_pic, 10, false);
                            c += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(42.0f, c0916b.oxO.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(4.0f, view.getContext());
                            break;
                    }
                }
            }
        }
        c0916b.oxG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.oxR != null && view2.getTag() != null && (view2.getTag() instanceof com.baidu.live.data.e)) {
                    b.this.oxR.a((com.baidu.live.data.e) view2.getTag());
                }
            }
        });
        c0916b.oxH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.oxR != null && view2.getTag() != null && (view2.getTag() instanceof com.baidu.live.data.e)) {
                    b.this.oxR.a((com.baidu.live.data.e) view2.getTag());
                }
            }
        });
        c0916b.oxG.setTag(eVar);
        c0916b.oxH.setTag(eVar);
        c0916b.oxV.setTag(eVar);
        c0916b.oxV.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        c0916b.oxV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (eVar.aJj || b.this.context == null) {
                    if (b.this.oxR != null) {
                        if (view2.getTag() == null || !(view2.getTag() instanceof com.baidu.live.data.e)) {
                            b.this.oxR.b(null);
                            return;
                        } else {
                            b.this.oxR.b((com.baidu.live.data.e) view2.getTag());
                            return;
                        }
                    }
                    return;
                }
                BdToast.makeText(b.this.context, b.this.context.getText(a.h.yuyin_ala_apply_unable_text)).show();
            }
        });
        c0916b.oxH.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.4
            @Override // java.lang.Runnable
            public void run() {
                if (c0916b.oxJ.getMeasuredWidth() + c > c0916b.oxP.getMeasuredWidth()) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0916b.oxH.getLayoutParams();
                    layoutParams.weight = 1.0f;
                    c0916b.oxH.setLayoutParams(layoutParams);
                    return;
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0916b.oxH.getLayoutParams();
                layoutParams2.weight = 0.0f;
                layoutParams2.width = -2;
                c0916b.oxH.setLayoutParams(layoutParams2);
            }
        });
        c0916b.oxF.setVisibility(i != 0 ? 8 : 0);
        return view;
    }

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0916b {
        private TextView oxD;
        private LinearLayout oxE;
        private View oxF;
        private HeadImageView oxG;
        private TextView oxH;
        private ImageView oxI;
        private TextView oxJ;
        private ImageView oxK;
        private TextView oxL;
        private FrameLayout oxM;
        private TbImageView oxN;
        private TbImageView oxO;
        private LinearLayout oxP;
        private LinearLayout oxQ;
        private AlaAcceptAndInviteBtn oxV;

        private C0916b() {
        }
    }

    public void setOnItemClickLister(a aVar) {
        this.oxR = aVar;
    }

    public void Wc(String str) {
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
