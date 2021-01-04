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
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
import java.util.List;
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private Context context;
    private List<com.baidu.live.data.e> mList;
    private InterfaceC0915a oxy;
    private int oxz = -1;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0915a {
        void a(com.baidu.live.data.e eVar);
    }

    public a(Context context) {
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
        final b bVar;
        final int i2;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(a.g.yuyin_item_connection_wheat_apply_2, (ViewGroup) null);
            b bVar2 = new b();
            bVar2.oxD = (TextView) view.findViewById(a.f.tv_rank_num);
            bVar2.oxE = (LinearLayout) view.findViewById(a.f.item_selected_bg);
            bVar2.oxF = view.findViewById(a.f.margin_top_height);
            bVar2.oxG = (HeadImageView) view.findViewById(a.f.user_avatar);
            bVar2.oxH = (TextView) view.findViewById(a.f.tv_nickname);
            bVar2.oxI = (ImageView) view.findViewById(a.f.team_fright_flag);
            bVar2.oxJ = (TextView) view.findViewById(a.f.tv_temp_nickname);
            bVar2.oxK = (ImageView) view.findViewById(a.f.iv_sex);
            bVar2.oxN = (TbImageView) view.findViewById(a.f.iv_level);
            bVar2.oxL = (TextView) view.findViewById(a.f.tv_level);
            bVar2.oxM = (FrameLayout) view.findViewById(a.f.level_container);
            bVar2.oxO = (TbImageView) view.findViewById(a.f.iv_badge);
            bVar2.oxP = (LinearLayout) view.findViewById(a.f.content_container);
            bVar2.oxQ = (LinearLayout) view.findViewById(a.f.icon_container);
            bVar2.oxP = (LinearLayout) view.findViewById(a.f.content_container);
            bVar2.oxQ = (LinearLayout) view.findViewById(a.f.icon_container);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        com.baidu.live.data.e eVar = (com.baidu.live.data.e) ListUtils.getItem(this.mList, i);
        if (eVar != null) {
            if (!o.eff().efv()) {
                bVar.oxD.setTextColor(bVar.oxD.getResources().getColor(a.c.sdk_color_B8B8B8));
                bVar.oxI.setVisibility(8);
                bVar.oxD.setTextSize(18.0f);
            } else {
                bVar.oxI.setVisibility(0);
                bVar.oxD.setTextColor(bVar.oxD.getResources().getColor(a.c.sdk_white_alpha100));
                bVar.oxD.setTextSize(13.0f);
                if (eVar.isApplyRedTeam()) {
                    bVar.oxI.setImageResource(a.e.yuyin_audio_wheat_red_flag);
                } else {
                    bVar.oxI.setImageResource(a.e.yuyin_audio_wheat_blue_flag);
                }
            }
            bVar.oxE.setBackgroundColor(this.oxz == i ? Color.parseColor("#F5F5F5") : Color.parseColor("#FFFFFF"));
            bVar.oxD.setText(Integer.toString(eVar.mPos));
            bVar.oxG.setIsRound(true);
            bVar.oxG.setAutoChangeStyle(false);
            bVar.oxG.setDefaultResource(a.e.yuyin_sdk_default_avatar);
            if (eVar != null && !TextUtils.isEmpty(eVar.mPortrait)) {
                bVar.oxG.setScaleType(ImageView.ScaleType.FIT_XY);
                bVar.oxG.setUrl(eVar.mPortrait);
                bVar.oxG.startLoad(eVar.mPortrait, 12, false);
            }
            bVar.oxH.setText(eVar.mUserName);
            bVar.oxJ.setText(eVar.mUserName);
            if (eVar.mSex == 0) {
                bVar.oxK.setVisibility(8);
            } else {
                bVar.oxK.setVisibility(0);
                bVar.oxK.setImageResource(eVar.mSex == 1 ? a.e.yuyin_sdk_icon_mine_boy : a.e.yuyin_sdk_icon_mine_girl);
            }
            int i3 = eVar.mSex == 0 ? 3 : 2;
            bVar.oxM.setVisibility(8);
            bVar.oxO.setVisibility(8);
            int c = com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(14.0f, view.getContext()) + (com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(4.0f, view.getContext()) * 2);
            if (eVar.mLiveMarkInfo != null) {
                i2 = c;
                for (int i4 = 0; i4 < eVar.mLiveMarkInfo.size() && i4 < i3; i4++) {
                    switch (eVar.mLiveMarkInfo.get(i4).type) {
                        case 1:
                            bVar.oxM.setVisibility(0);
                            bVar.oxN.startLoad(eVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            bVar.oxL.setText(Integer.toString(eVar.level));
                            i2 += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(13.0f, view.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(4.0f, view.getContext());
                            break;
                        case 105:
                            bVar.oxO.setVisibility(0);
                            bVar.oxO.startLoad(eVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            i2 += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(42.0f, bVar.oxO.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(4.0f, view.getContext());
                            break;
                    }
                }
            } else {
                i2 = c;
            }
            bVar.oxG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.oxy != null && view2.getTag() != null && (view2.getTag() instanceof com.baidu.live.data.e)) {
                        a.this.oxy.a((com.baidu.live.data.e) view2.getTag());
                    }
                }
            });
            bVar.oxH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.oxy != null && view2.getTag() != null && (view2.getTag() instanceof com.baidu.live.data.e)) {
                        a.this.oxy.a((com.baidu.live.data.e) view2.getTag());
                    }
                }
            });
            bVar.oxG.setTag(eVar);
            bVar.oxH.setTag(eVar);
            bVar.oxH.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar.oxJ.getMeasuredWidth() + i2 > bVar.oxP.getMeasuredWidth()) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.oxH.getLayoutParams();
                        layoutParams.weight = 1.0f;
                        bVar.oxH.setLayoutParams(layoutParams);
                        return;
                    }
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.oxH.getLayoutParams();
                    layoutParams2.weight = 0.0f;
                    layoutParams2.width = -2;
                    bVar.oxH.setLayoutParams(layoutParams2);
                }
            });
            bVar.oxF.setVisibility(i != 0 ? 8 : 0);
        }
        return view;
    }

    /* loaded from: classes11.dex */
    private class b {
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

        private b() {
        }
    }

    public void a(InterfaceC0915a interfaceC0915a) {
        this.oxy = interfaceC0915a;
    }
}
