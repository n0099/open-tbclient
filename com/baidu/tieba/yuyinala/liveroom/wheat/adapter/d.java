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
import com.baidu.tieba.yuyinala.liveroom.wheat.c.q;
import java.util.List;
/* loaded from: classes11.dex */
public class d extends BaseAdapter {
    private Context context;
    private List<AlaWheatInfoData> mList;
    private int oDh;
    private a oDi;

    /* loaded from: classes11.dex */
    public interface a {
        void Mn(int i);

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
            bVar2.oCI = (TextView) view.findViewById(a.f.tv_rank_num);
            bVar2.oCK = view.findViewById(a.f.margin_top_height);
            bVar2.oCN = (ImageView) view.findViewById(a.f.team_fright_flag);
            bVar2.oCL = (HeadImageView) view.findViewById(a.f.user_avatar);
            bVar2.oCM = (TextView) view.findViewById(a.f.tv_nickname);
            bVar2.oCO = (TextView) view.findViewById(a.f.tv_temp_nickname);
            bVar2.oCP = (ImageView) view.findViewById(a.f.iv_sex);
            bVar2.oCQ = (TextView) view.findViewById(a.f.tv_level);
            bVar2.oCS = (TbImageView) view.findViewById(a.f.iv_level);
            bVar2.oCR = (FrameLayout) view.findViewById(a.f.level_container);
            bVar2.oCT = (TbImageView) view.findViewById(a.f.iv_badge);
            bVar2.oDl = (ImageView) view.findViewById(a.f.iv_mute);
            bVar2.oDm = (TextView) view.findViewById(a.f.tv_hang_up);
            bVar2.oCU = (LinearLayout) view.findViewById(a.f.content_container);
            bVar2.oCV = (LinearLayout) view.findViewById(a.f.icon_container);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        AlaWheatInfoData alaWheatInfoData = (AlaWheatInfoData) ListUtils.getItem(this.mList, i);
        if (alaWheatInfoData != null) {
            if (i >= this.oDh) {
                if (q.edE().edR()) {
                    bVar.oCI.setPadding(0, 0, com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(3.0f, bVar.oCI.getContext()), 0);
                    bVar.oCN.setVisibility(0);
                    bVar.oCI.setTextColor(bVar.oCI.getResources().getColor(a.c.sdk_white_alpha100));
                    bVar.oCI.setTextSize(13.0f);
                    if (alaWheatInfoData.isApplyRedTeam()) {
                        bVar.oCN.setImageResource(a.e.yuyin_audio_wheat_red_flag);
                    } else {
                        bVar.oCN.setImageResource(a.e.yuyin_audio_wheat_blue_flag);
                    }
                } else {
                    bVar.oCI.setPadding(0, 0, 0, 0);
                    bVar.oCI.setTextColor(bVar.oCI.getResources().getColor(a.c.sdk_color_B8B8B8));
                    bVar.oCN.setVisibility(8);
                    bVar.oCI.setTextSize(18.0f);
                }
                bVar.oCI.setText(Integer.toString(alaWheatInfoData.realWheatPosition));
            } else {
                bVar.oCI.setPadding(0, 0, 0, 0);
                bVar.oCI.setTextColor(bVar.oCI.getResources().getColor(a.c.sdk_color_B8B8B8));
                bVar.oCN.setVisibility(8);
                bVar.oCI.setTextSize(12.0f);
                bVar.oCI.setText(this.context.getString(a.h.yuyin_ala_connection_wheat_host_text));
            }
            bVar.oCL.setIsRound(true);
            bVar.oCL.setAutoChangeStyle(false);
            bVar.oCL.setDefaultResource(a.e.yuyin_sdk_default_avatar);
            if (alaWheatInfoData != null && !TextUtils.isEmpty(alaWheatInfoData.portrait)) {
                bVar.oCL.setScaleType(ImageView.ScaleType.FIT_XY);
                bVar.oCL.setUrl(alaWheatInfoData.portrait);
                bVar.oCL.startLoad(alaWheatInfoData.portrait, 12, false);
            }
            bVar.oCM.setText(alaWheatInfoData.userName);
            bVar.oCO.setText(alaWheatInfoData.userName);
            bVar.oDl.setSelected(alaWheatInfoData.isOpenMike());
            if (alaWheatInfoData.sex == 0) {
                bVar.oCP.setVisibility(8);
            } else {
                bVar.oCP.setVisibility(0);
                bVar.oCP.setImageResource(alaWheatInfoData.sex == 1 ? a.e.yuyin_sdk_icon_mine_boy : a.e.yuyin_sdk_icon_mine_girl);
            }
            int i3 = alaWheatInfoData.sex == 0 ? 3 : 2;
            bVar.oCR.setVisibility(8);
            bVar.oCT.setVisibility(8);
            int d = com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(14.0f, view.getContext()) + (com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext()) * 2);
            if (alaWheatInfoData.mLiveMarkInfo != null) {
                i2 = d;
                for (int i4 = 0; i4 < alaWheatInfoData.mLiveMarkInfo.size() && i4 < i3; i4++) {
                    switch (alaWheatInfoData.mLiveMarkInfo.get(i4).type) {
                        case 1:
                            bVar.oCR.setVisibility(0);
                            bVar.oCS.startLoad(alaWheatInfoData.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            bVar.oCQ.setText(Integer.toString(alaWheatInfoData.level));
                            i2 += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(13.0f, view.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext());
                            break;
                        case 105:
                            bVar.oCT.setVisibility(0);
                            bVar.oCT.startLoad(alaWheatInfoData.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            i2 += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(42.0f, bVar.oCT.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext());
                            break;
                    }
                }
            } else {
                i2 = d;
            }
            bVar.oCL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.oDi != null && view2.getTag() != null && (view2.getTag() instanceof AlaWheatInfoData)) {
                        d.this.oDi.g((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.oCM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.oDi != null && view2.getTag() != null && (view2.getTag() instanceof AlaWheatInfoData)) {
                        d.this.oDi.g((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.oCL.setTag(alaWheatInfoData);
            bVar.oCM.setTag(alaWheatInfoData);
            bVar.oDm.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
            bVar.oDm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.oDi != null) {
                        d.this.oDi.h((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.oDl.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
            bVar.oDl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.oDi != null && view2.getTag() != null && (view2.getTag() instanceof AlaWheatInfoData)) {
                        d.this.oDi.i((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.oDm.setTag(alaWheatInfoData);
            bVar.oDl.setTag(alaWheatInfoData);
            bVar.oCM.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.5
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar.oCO.getMeasuredWidth() + i2 > bVar.oCU.getMeasuredWidth()) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.oCM.getLayoutParams();
                        layoutParams.weight = 1.0f;
                        bVar.oCM.setLayoutParams(layoutParams);
                        return;
                    }
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.oCM.getLayoutParams();
                    layoutParams2.weight = 0.0f;
                    layoutParams2.width = -2;
                    bVar.oCM.setLayoutParams(layoutParams2);
                }
            });
            bVar.oCK.setVisibility(i != 0 ? 8 : 0);
        }
        return view;
    }

    /* loaded from: classes11.dex */
    private class b {
        private TextView oCI;
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
        private ImageView oDl;
        private TextView oDm;

        private b() {
        }
    }

    public void Mm(int i) {
        this.oDh = i;
    }

    public void setListener(a aVar) {
        this.oDi = aVar;
    }
}
