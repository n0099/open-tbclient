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
/* loaded from: classes10.dex */
public class d extends BaseAdapter {
    private Context context;
    private List<AlaWheatInfoData> mList;
    private int oFM;
    private a oFN;

    /* loaded from: classes10.dex */
    public interface a {
        void Ms(int i);

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
            bVar2.oFn = (TextView) view.findViewById(a.f.tv_rank_num);
            bVar2.oFp = view.findViewById(a.f.margin_top_height);
            bVar2.oFs = (ImageView) view.findViewById(a.f.team_fright_flag);
            bVar2.oFq = (HeadImageView) view.findViewById(a.f.user_avatar);
            bVar2.oFr = (TextView) view.findViewById(a.f.tv_nickname);
            bVar2.oFt = (TextView) view.findViewById(a.f.tv_temp_nickname);
            bVar2.oFu = (ImageView) view.findViewById(a.f.iv_sex);
            bVar2.oFv = (TextView) view.findViewById(a.f.tv_level);
            bVar2.oFx = (TbImageView) view.findViewById(a.f.iv_level);
            bVar2.oFw = (FrameLayout) view.findViewById(a.f.level_container);
            bVar2.oFy = (TbImageView) view.findViewById(a.f.iv_badge);
            bVar2.oFQ = (ImageView) view.findViewById(a.f.iv_mute);
            bVar2.oFR = (TextView) view.findViewById(a.f.tv_hang_up);
            bVar2.oFz = (LinearLayout) view.findViewById(a.f.content_container);
            bVar2.oFA = (LinearLayout) view.findViewById(a.f.icon_container);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        AlaWheatInfoData alaWheatInfoData = (AlaWheatInfoData) ListUtils.getItem(this.mList, i);
        if (alaWheatInfoData != null) {
            if (i >= this.oFM) {
                if (q.edU().eeh()) {
                    bVar.oFn.setPadding(0, 0, com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(3.0f, bVar.oFn.getContext()), 0);
                    bVar.oFs.setVisibility(0);
                    bVar.oFn.setTextColor(bVar.oFn.getResources().getColor(a.c.sdk_white_alpha100));
                    bVar.oFn.setTextSize(13.0f);
                    if (alaWheatInfoData.isApplyRedTeam()) {
                        bVar.oFs.setImageResource(a.e.yuyin_audio_wheat_red_flag);
                    } else {
                        bVar.oFs.setImageResource(a.e.yuyin_audio_wheat_blue_flag);
                    }
                } else {
                    bVar.oFn.setPadding(0, 0, 0, 0);
                    bVar.oFn.setTextColor(bVar.oFn.getResources().getColor(a.c.sdk_color_B8B8B8));
                    bVar.oFs.setVisibility(8);
                    bVar.oFn.setTextSize(18.0f);
                }
                bVar.oFn.setText(Integer.toString(alaWheatInfoData.realWheatPosition));
            } else {
                bVar.oFn.setPadding(0, 0, 0, 0);
                bVar.oFn.setTextColor(bVar.oFn.getResources().getColor(a.c.sdk_color_B8B8B8));
                bVar.oFs.setVisibility(8);
                bVar.oFn.setTextSize(12.0f);
                bVar.oFn.setText(this.context.getString(a.h.yuyin_ala_connection_wheat_host_text));
            }
            bVar.oFq.setIsRound(true);
            bVar.oFq.setAutoChangeStyle(false);
            bVar.oFq.setDefaultResource(a.e.yuyin_sdk_default_avatar);
            if (alaWheatInfoData != null && !TextUtils.isEmpty(alaWheatInfoData.portrait)) {
                bVar.oFq.setScaleType(ImageView.ScaleType.FIT_XY);
                bVar.oFq.setUrl(alaWheatInfoData.portrait);
                bVar.oFq.startLoad(alaWheatInfoData.portrait, 12, false);
            }
            bVar.oFr.setText(alaWheatInfoData.userName);
            bVar.oFt.setText(alaWheatInfoData.userName);
            bVar.oFQ.setSelected(alaWheatInfoData.isOpenMike());
            if (alaWheatInfoData.sex == 0) {
                bVar.oFu.setVisibility(8);
            } else {
                bVar.oFu.setVisibility(0);
                bVar.oFu.setImageResource(alaWheatInfoData.sex == 1 ? a.e.yuyin_sdk_icon_mine_boy : a.e.yuyin_sdk_icon_mine_girl);
            }
            int i3 = alaWheatInfoData.sex == 0 ? 3 : 2;
            bVar.oFw.setVisibility(8);
            bVar.oFy.setVisibility(8);
            int d = com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(14.0f, view.getContext()) + (com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext()) * 2);
            if (alaWheatInfoData.mLiveMarkInfo != null) {
                i2 = d;
                for (int i4 = 0; i4 < alaWheatInfoData.mLiveMarkInfo.size() && i4 < i3; i4++) {
                    switch (alaWheatInfoData.mLiveMarkInfo.get(i4).type) {
                        case 1:
                            bVar.oFw.setVisibility(0);
                            bVar.oFx.startLoad(alaWheatInfoData.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            bVar.oFv.setText(Integer.toString(alaWheatInfoData.level));
                            i2 += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(13.0f, view.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext());
                            break;
                        case 105:
                            bVar.oFy.setVisibility(0);
                            bVar.oFy.startLoad(alaWheatInfoData.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            i2 += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(42.0f, bVar.oFy.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext());
                            break;
                    }
                }
            } else {
                i2 = d;
            }
            bVar.oFq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.oFN != null && view2.getTag() != null && (view2.getTag() instanceof AlaWheatInfoData)) {
                        d.this.oFN.g((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.oFr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.oFN != null && view2.getTag() != null && (view2.getTag() instanceof AlaWheatInfoData)) {
                        d.this.oFN.g((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.oFq.setTag(alaWheatInfoData);
            bVar.oFr.setTag(alaWheatInfoData);
            bVar.oFR.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
            bVar.oFR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.oFN != null) {
                        d.this.oFN.h((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.oFQ.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
            bVar.oFQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.oFN != null && view2.getTag() != null && (view2.getTag() instanceof AlaWheatInfoData)) {
                        d.this.oFN.i((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.oFR.setTag(alaWheatInfoData);
            bVar.oFQ.setTag(alaWheatInfoData);
            bVar.oFr.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.5
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar.oFt.getMeasuredWidth() + i2 > bVar.oFz.getMeasuredWidth()) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.oFr.getLayoutParams();
                        layoutParams.weight = 1.0f;
                        bVar.oFr.setLayoutParams(layoutParams);
                        return;
                    }
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.oFr.getLayoutParams();
                    layoutParams2.weight = 0.0f;
                    layoutParams2.width = -2;
                    bVar.oFr.setLayoutParams(layoutParams2);
                }
            });
            bVar.oFp.setVisibility(i != 0 ? 8 : 0);
        }
        return view;
    }

    /* loaded from: classes10.dex */
    private class b {
        private LinearLayout oFA;
        private ImageView oFQ;
        private TextView oFR;
        private TextView oFn;
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

        private b() {
        }
    }

    public void Mr(int i) {
        this.oFM = i;
    }

    public void setListener(a aVar) {
        this.oFN = aVar;
    }
}
