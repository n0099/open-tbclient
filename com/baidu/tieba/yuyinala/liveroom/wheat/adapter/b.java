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
    private a oxQ;
    private int oxy = -1;

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
        this.oxy = i;
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
        final C0954b c0954b;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(a.g.yuyin_item_connection_wheat_apply, (ViewGroup) null);
            C0954b c0954b2 = new C0954b();
            c0954b2.oxC = (TextView) view.findViewById(a.f.tv_rank_num);
            c0954b2.oxD = (LinearLayout) view.findViewById(a.f.item_selected_bg);
            c0954b2.oxE = view.findViewById(a.f.margin_top_height);
            c0954b2.oxF = (HeadImageView) view.findViewById(a.f.user_avatar);
            c0954b2.oxH = (ImageView) view.findViewById(a.f.team_fright_flag);
            c0954b2.oxG = (TextView) view.findViewById(a.f.tv_nickname);
            c0954b2.oxI = (TextView) view.findViewById(a.f.tv_temp_nickname);
            c0954b2.oxJ = (ImageView) view.findViewById(a.f.iv_sex);
            c0954b2.oxK = (TextView) view.findViewById(a.f.tv_level);
            c0954b2.oxM = (TbImageView) view.findViewById(a.f.iv_level);
            c0954b2.oxL = (FrameLayout) view.findViewById(a.f.level_container);
            c0954b2.oxN = (TbImageView) view.findViewById(a.f.iv_badge);
            c0954b2.oxU = (AlaAcceptAndInviteBtn) view.findViewById(a.f.tv_accept_invite);
            c0954b2.oxO = (LinearLayout) view.findViewById(a.f.content_container);
            c0954b2.oxP = (LinearLayout) view.findViewById(a.f.icon_container);
            view.setTag(c0954b2);
            c0954b = c0954b2;
        } else {
            c0954b = (C0954b) view.getTag();
        }
        final com.baidu.live.data.e eVar = (com.baidu.live.data.e) ListUtils.getItem(this.mList, i);
        final int c = com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(14.0f, view.getContext()) + (com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(4.0f, view.getContext()) * 2);
        if (eVar != null) {
            if (!o.efg().efw()) {
                c0954b.oxC.setTextColor(c0954b.oxC.getResources().getColor(a.c.sdk_color_B8B8B8));
                c0954b.oxH.setVisibility(8);
                c0954b.oxC.setTextSize(18.0f);
            } else {
                c0954b.oxH.setVisibility(0);
                c0954b.oxC.setTextColor(c0954b.oxC.getResources().getColor(a.c.sdk_white_alpha100));
                c0954b.oxC.setTextSize(13.0f);
                if (eVar.isApplyRedTeam()) {
                    c0954b.oxH.setImageResource(a.e.yuyin_audio_wheat_red_flag);
                } else {
                    c0954b.oxH.setImageResource(a.e.yuyin_audio_wheat_blue_flag);
                }
            }
            c0954b.oxD.setBackgroundColor(this.oxy == i ? Color.parseColor("#F5F5F5") : Color.parseColor("#FFFFFF"));
            c0954b.oxU.setSelectedState(eVar.aJj ? 1 : 0);
            c0954b.oxC.setText(Integer.toString(eVar.mPos));
            c0954b.oxF.setIsRound(true);
            c0954b.oxF.setAutoChangeStyle(false);
            c0954b.oxF.setDefaultResource(a.e.yuyin_sdk_default_avatar);
            if (eVar != null && !TextUtils.isEmpty(eVar.mPortrait)) {
                c0954b.oxF.setScaleType(ImageView.ScaleType.FIT_XY);
                c0954b.oxF.setUrl(eVar.mPortrait);
                c0954b.oxF.startLoad(eVar.mPortrait, 12, false);
            }
            c0954b.oxG.setText(eVar.mUserName);
            c0954b.oxI.setText(eVar.mUserName);
            if (eVar.mSex == 0) {
                c0954b.oxJ.setVisibility(8);
            } else {
                c0954b.oxJ.setVisibility(0);
                c0954b.oxJ.setImageResource(eVar.mSex == 1 ? a.e.yuyin_sdk_icon_mine_boy : a.e.yuyin_sdk_icon_mine_girl);
            }
            int i2 = eVar.mSex == 0 ? 3 : 2;
            c0954b.oxL.setVisibility(8);
            c0954b.oxN.setVisibility(8);
            if (eVar.mLiveMarkInfo != null) {
                for (int i3 = 0; i3 < eVar.mLiveMarkInfo.size() && i3 < i2; i3++) {
                    switch (eVar.mLiveMarkInfo.get(i3).type) {
                        case 1:
                            c0954b.oxL.setVisibility(0);
                            c0954b.oxM.startLoad(eVar.mLiveMarkInfo.get(i3).mark_pic, 10, false);
                            c0954b.oxK.setText(Integer.toString(eVar.level));
                            c += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(13.0f, view.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(4.0f, view.getContext());
                            break;
                        case 105:
                            c0954b.oxN.setVisibility(0);
                            c0954b.oxN.startLoad(eVar.mLiveMarkInfo.get(i3).mark_pic, 10, false);
                            c += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(42.0f, c0954b.oxN.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(4.0f, view.getContext());
                            break;
                    }
                }
            }
        }
        c0954b.oxF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.oxQ != null && view2.getTag() != null && (view2.getTag() instanceof com.baidu.live.data.e)) {
                    b.this.oxQ.a((com.baidu.live.data.e) view2.getTag());
                }
            }
        });
        c0954b.oxG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.oxQ != null && view2.getTag() != null && (view2.getTag() instanceof com.baidu.live.data.e)) {
                    b.this.oxQ.a((com.baidu.live.data.e) view2.getTag());
                }
            }
        });
        c0954b.oxF.setTag(eVar);
        c0954b.oxG.setTag(eVar);
        c0954b.oxU.setTag(eVar);
        c0954b.oxU.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        c0954b.oxU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (eVar.aJj || b.this.context == null) {
                    if (b.this.oxQ != null) {
                        if (view2.getTag() == null || !(view2.getTag() instanceof com.baidu.live.data.e)) {
                            b.this.oxQ.b(null);
                            return;
                        } else {
                            b.this.oxQ.b((com.baidu.live.data.e) view2.getTag());
                            return;
                        }
                    }
                    return;
                }
                BdToast.makeText(b.this.context, b.this.context.getText(a.h.yuyin_ala_apply_unable_text)).show();
            }
        });
        c0954b.oxG.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.4
            @Override // java.lang.Runnable
            public void run() {
                if (c0954b.oxI.getMeasuredWidth() + c > c0954b.oxO.getMeasuredWidth()) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0954b.oxG.getLayoutParams();
                    layoutParams.weight = 1.0f;
                    c0954b.oxG.setLayoutParams(layoutParams);
                    return;
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0954b.oxG.getLayoutParams();
                layoutParams2.weight = 0.0f;
                layoutParams2.width = -2;
                c0954b.oxG.setLayoutParams(layoutParams2);
            }
        });
        c0954b.oxE.setVisibility(i != 0 ? 8 : 0);
        return view;
    }

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0954b {
        private TextView oxC;
        private LinearLayout oxD;
        private View oxE;
        private HeadImageView oxF;
        private TextView oxG;
        private ImageView oxH;
        private TextView oxI;
        private ImageView oxJ;
        private TextView oxK;
        private FrameLayout oxL;
        private TbImageView oxM;
        private TbImageView oxN;
        private LinearLayout oxO;
        private LinearLayout oxP;
        private AlaAcceptAndInviteBtn oxU;

        private C0954b() {
        }
    }

    public void setOnItemClickLister(a aVar) {
        this.oxQ = aVar;
    }

    public void Wb(String str) {
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
