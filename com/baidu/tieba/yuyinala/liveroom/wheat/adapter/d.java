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
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
import java.util.List;
/* loaded from: classes11.dex */
public class d extends BaseAdapter {
    private Context context;
    private List<AlaWheatInfoData> mList;
    private int oyc;
    private a oyd;

    /* loaded from: classes11.dex */
    public interface a {
        void Nz(int i);

        void g(AlaWheatInfoData alaWheatInfoData);

        void h(AlaWheatInfoData alaWheatInfoData);

        void i(AlaWheatInfoData alaWheatInfoData);
    }

    public d(Context context) {
        this.context = context;
    }

    public void setData(List<AlaWheatInfoData> list) {
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

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final b bVar;
        final int i2;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(a.g.yuyin_item_connection_wheat_manager, (ViewGroup) null);
            b bVar2 = new b();
            bVar2.oxD = (TextView) view.findViewById(a.f.tv_rank_num);
            bVar2.oxF = view.findViewById(a.f.margin_top_height);
            bVar2.oxI = (ImageView) view.findViewById(a.f.team_fright_flag);
            bVar2.oxG = (HeadImageView) view.findViewById(a.f.user_avatar);
            bVar2.oxH = (TextView) view.findViewById(a.f.tv_nickname);
            bVar2.oxJ = (TextView) view.findViewById(a.f.tv_temp_nickname);
            bVar2.oxK = (ImageView) view.findViewById(a.f.iv_sex);
            bVar2.oxL = (TextView) view.findViewById(a.f.tv_level);
            bVar2.oxN = (TbImageView) view.findViewById(a.f.iv_level);
            bVar2.oxM = (FrameLayout) view.findViewById(a.f.level_container);
            bVar2.oxO = (TbImageView) view.findViewById(a.f.iv_badge);
            bVar2.oyg = (ImageView) view.findViewById(a.f.iv_mute);
            bVar2.oyh = (TextView) view.findViewById(a.f.tv_hang_up);
            bVar2.oxP = (LinearLayout) view.findViewById(a.f.content_container);
            bVar2.oxQ = (LinearLayout) view.findViewById(a.f.icon_container);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        AlaWheatInfoData alaWheatInfoData = (AlaWheatInfoData) ListUtils.getItem(this.mList, i);
        if (alaWheatInfoData != null) {
            if (i >= this.oyc) {
                if (o.eff().efv()) {
                    bVar.oxD.setPadding(0, 0, com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(3.0f, bVar.oxD.getContext()), 0);
                    bVar.oxI.setVisibility(0);
                    bVar.oxD.setTextColor(bVar.oxD.getResources().getColor(a.c.sdk_white_alpha100));
                    bVar.oxD.setTextSize(13.0f);
                    if (alaWheatInfoData.isApplyRedTeam()) {
                        bVar.oxI.setImageResource(a.e.yuyin_audio_wheat_red_flag);
                    } else {
                        bVar.oxI.setImageResource(a.e.yuyin_audio_wheat_blue_flag);
                    }
                } else {
                    bVar.oxD.setPadding(0, 0, 0, 0);
                    bVar.oxD.setTextColor(bVar.oxD.getResources().getColor(a.c.sdk_color_B8B8B8));
                    bVar.oxI.setVisibility(8);
                    bVar.oxD.setTextSize(18.0f);
                }
                bVar.oxD.setText(Integer.toString(alaWheatInfoData.realWheatPosition));
            } else {
                bVar.oxD.setPadding(0, 0, 0, 0);
                bVar.oxD.setTextColor(bVar.oxD.getResources().getColor(a.c.sdk_color_B8B8B8));
                bVar.oxI.setVisibility(8);
                bVar.oxD.setTextSize(12.0f);
                bVar.oxD.setText(this.context.getString(a.h.yuyin_ala_connection_wheat_host_text));
            }
            bVar.oxG.setIsRound(true);
            bVar.oxG.setAutoChangeStyle(false);
            bVar.oxG.setDefaultResource(a.e.yuyin_sdk_default_avatar);
            if (alaWheatInfoData != null && !TextUtils.isEmpty(alaWheatInfoData.portrait)) {
                bVar.oxG.setScaleType(ImageView.ScaleType.FIT_XY);
                bVar.oxG.setUrl(alaWheatInfoData.portrait);
                bVar.oxG.startLoad(alaWheatInfoData.portrait, 12, false);
            }
            bVar.oxH.setText(alaWheatInfoData.userName);
            bVar.oxJ.setText(alaWheatInfoData.userName);
            bVar.oyg.setSelected(alaWheatInfoData.isOpenMike());
            if (alaWheatInfoData.sex == 0) {
                bVar.oxK.setVisibility(8);
            } else {
                bVar.oxK.setVisibility(0);
                bVar.oxK.setImageResource(alaWheatInfoData.sex == 1 ? a.e.yuyin_sdk_icon_mine_boy : a.e.yuyin_sdk_icon_mine_girl);
            }
            int i3 = alaWheatInfoData.sex == 0 ? 3 : 2;
            bVar.oxM.setVisibility(8);
            bVar.oxO.setVisibility(8);
            int c = com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(14.0f, view.getContext()) + (com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(4.0f, view.getContext()) * 2);
            if (alaWheatInfoData.mLiveMarkInfo != null) {
                i2 = c;
                for (int i4 = 0; i4 < alaWheatInfoData.mLiveMarkInfo.size() && i4 < i3; i4++) {
                    switch (alaWheatInfoData.mLiveMarkInfo.get(i4).type) {
                        case 1:
                            bVar.oxM.setVisibility(0);
                            bVar.oxN.startLoad(alaWheatInfoData.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            bVar.oxL.setText(Integer.toString(alaWheatInfoData.level));
                            i2 += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(13.0f, view.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(4.0f, view.getContext());
                            break;
                        case 105:
                            bVar.oxO.setVisibility(0);
                            bVar.oxO.startLoad(alaWheatInfoData.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            i2 += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(42.0f, bVar.oxO.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(4.0f, view.getContext());
                            break;
                    }
                }
            } else {
                i2 = c;
            }
            bVar.oxG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.oyd != null && view2.getTag() != null && (view2.getTag() instanceof AlaWheatInfoData)) {
                        d.this.oyd.g((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.oxH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.oyd != null && view2.getTag() != null && (view2.getTag() instanceof AlaWheatInfoData)) {
                        d.this.oyd.g((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.oxG.setTag(alaWheatInfoData);
            bVar.oxH.setTag(alaWheatInfoData);
            bVar.oyh.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
            bVar.oyh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.oyd != null) {
                        d.this.oyd.h((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.oyg.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
            bVar.oyg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.oyd != null && view2.getTag() != null && (view2.getTag() instanceof AlaWheatInfoData)) {
                        d.this.oyd.i((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.oyh.setTag(alaWheatInfoData);
            bVar.oyg.setTag(alaWheatInfoData);
            bVar.oxH.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.5
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
        private ImageView oyg;
        private TextView oyh;

        private b() {
        }
    }

    public void Ny(int i) {
        this.oyc = i;
    }

    public void setListener(a aVar) {
        this.oyd = aVar;
    }
}
