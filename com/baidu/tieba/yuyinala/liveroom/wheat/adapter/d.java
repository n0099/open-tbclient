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
/* loaded from: classes10.dex */
public class d extends BaseAdapter {
    private Context context;
    private List<AlaWheatInfoData> mList;
    private int otv;
    private a otw;

    /* loaded from: classes10.dex */
    public interface a {
        void LS(int i);

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
            bVar2.osW = (TextView) view.findViewById(a.f.tv_rank_num);
            bVar2.osY = view.findViewById(a.f.margin_top_height);
            bVar2.otb = (ImageView) view.findViewById(a.f.team_fright_flag);
            bVar2.osZ = (HeadImageView) view.findViewById(a.f.user_avatar);
            bVar2.ota = (TextView) view.findViewById(a.f.tv_nickname);
            bVar2.otc = (TextView) view.findViewById(a.f.tv_temp_nickname);
            bVar2.otd = (ImageView) view.findViewById(a.f.iv_sex);
            bVar2.ote = (TextView) view.findViewById(a.f.tv_level);
            bVar2.otg = (TbImageView) view.findViewById(a.f.iv_level);
            bVar2.otf = (FrameLayout) view.findViewById(a.f.level_container);
            bVar2.oth = (TbImageView) view.findViewById(a.f.iv_badge);
            bVar2.otz = (ImageView) view.findViewById(a.f.iv_mute);
            bVar2.otA = (TextView) view.findViewById(a.f.tv_hang_up);
            bVar2.oti = (LinearLayout) view.findViewById(a.f.content_container);
            bVar2.otj = (LinearLayout) view.findViewById(a.f.icon_container);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        AlaWheatInfoData alaWheatInfoData = (AlaWheatInfoData) ListUtils.getItem(this.mList, i);
        if (alaWheatInfoData != null) {
            if (i >= this.otv) {
                if (o.ebo().ebE()) {
                    bVar.osW.setPadding(0, 0, com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(3.0f, bVar.osW.getContext()), 0);
                    bVar.otb.setVisibility(0);
                    bVar.osW.setTextColor(bVar.osW.getResources().getColor(a.c.sdk_white_alpha100));
                    bVar.osW.setTextSize(13.0f);
                    if (alaWheatInfoData.isApplyRedTeam()) {
                        bVar.otb.setImageResource(a.e.yuyin_audio_wheat_red_flag);
                    } else {
                        bVar.otb.setImageResource(a.e.yuyin_audio_wheat_blue_flag);
                    }
                } else {
                    bVar.osW.setPadding(0, 0, 0, 0);
                    bVar.osW.setTextColor(bVar.osW.getResources().getColor(a.c.sdk_color_B8B8B8));
                    bVar.otb.setVisibility(8);
                    bVar.osW.setTextSize(18.0f);
                }
                bVar.osW.setText(Integer.toString(alaWheatInfoData.realWheatPosition));
            } else {
                bVar.osW.setPadding(0, 0, 0, 0);
                bVar.osW.setTextColor(bVar.osW.getResources().getColor(a.c.sdk_color_B8B8B8));
                bVar.otb.setVisibility(8);
                bVar.osW.setTextSize(12.0f);
                bVar.osW.setText(this.context.getString(a.h.yuyin_ala_connection_wheat_host_text));
            }
            bVar.osZ.setIsRound(true);
            bVar.osZ.setAutoChangeStyle(false);
            bVar.osZ.setDefaultResource(a.e.yuyin_sdk_default_avatar);
            if (alaWheatInfoData != null && !TextUtils.isEmpty(alaWheatInfoData.portrait)) {
                bVar.osZ.setScaleType(ImageView.ScaleType.FIT_XY);
                bVar.osZ.setUrl(alaWheatInfoData.portrait);
                bVar.osZ.startLoad(alaWheatInfoData.portrait, 12, false);
            }
            bVar.ota.setText(alaWheatInfoData.userName);
            bVar.otc.setText(alaWheatInfoData.userName);
            bVar.otz.setSelected(alaWheatInfoData.isOpenMike());
            if (alaWheatInfoData.sex == 0) {
                bVar.otd.setVisibility(8);
            } else {
                bVar.otd.setVisibility(0);
                bVar.otd.setImageResource(alaWheatInfoData.sex == 1 ? a.e.yuyin_sdk_icon_mine_boy : a.e.yuyin_sdk_icon_mine_girl);
            }
            int i3 = alaWheatInfoData.sex == 0 ? 3 : 2;
            bVar.otf.setVisibility(8);
            bVar.oth.setVisibility(8);
            int d = com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(14.0f, view.getContext()) + (com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext()) * 2);
            if (alaWheatInfoData.mLiveMarkInfo != null) {
                i2 = d;
                for (int i4 = 0; i4 < alaWheatInfoData.mLiveMarkInfo.size() && i4 < i3; i4++) {
                    switch (alaWheatInfoData.mLiveMarkInfo.get(i4).type) {
                        case 1:
                            bVar.otf.setVisibility(0);
                            bVar.otg.startLoad(alaWheatInfoData.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            bVar.ote.setText(Integer.toString(alaWheatInfoData.level));
                            i2 += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(13.0f, view.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext());
                            break;
                        case 105:
                            bVar.oth.setVisibility(0);
                            bVar.oth.startLoad(alaWheatInfoData.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            i2 += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(42.0f, bVar.oth.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext());
                            break;
                    }
                }
            } else {
                i2 = d;
            }
            bVar.osZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.otw != null && view2.getTag() != null && (view2.getTag() instanceof AlaWheatInfoData)) {
                        d.this.otw.g((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.ota.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.otw != null && view2.getTag() != null && (view2.getTag() instanceof AlaWheatInfoData)) {
                        d.this.otw.g((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.osZ.setTag(alaWheatInfoData);
            bVar.ota.setTag(alaWheatInfoData);
            bVar.otA.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
            bVar.otA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.otw != null) {
                        d.this.otw.h((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.otz.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
            bVar.otz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.otw != null && view2.getTag() != null && (view2.getTag() instanceof AlaWheatInfoData)) {
                        d.this.otw.i((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.otA.setTag(alaWheatInfoData);
            bVar.otz.setTag(alaWheatInfoData);
            bVar.ota.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.5
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar.otc.getMeasuredWidth() + i2 > bVar.oti.getMeasuredWidth()) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.ota.getLayoutParams();
                        layoutParams.weight = 1.0f;
                        bVar.ota.setLayoutParams(layoutParams);
                        return;
                    }
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.ota.getLayoutParams();
                    layoutParams2.weight = 0.0f;
                    layoutParams2.width = -2;
                    bVar.ota.setLayoutParams(layoutParams2);
                }
            });
            bVar.osY.setVisibility(i != 0 ? 8 : 0);
        }
        return view;
    }

    /* loaded from: classes10.dex */
    private class b {
        private TextView osW;
        private View osY;
        private HeadImageView osZ;
        private TextView otA;
        private TextView ota;
        private ImageView otb;
        private TextView otc;
        private ImageView otd;
        private TextView ote;
        private FrameLayout otf;
        private TbImageView otg;
        private TbImageView oth;
        private LinearLayout oti;
        private LinearLayout otj;
        private ImageView otz;

        private b() {
        }
    }

    public void LR(int i) {
        this.otv = i;
    }

    public void setListener(a aVar) {
        this.otw = aVar;
    }
}
