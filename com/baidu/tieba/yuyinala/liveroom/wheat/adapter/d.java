package com.baidu.tieba.yuyinala.liveroom.wheat.adapter;

import android.content.Context;
import android.graphics.Typeface;
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
import com.baidu.tieba.yuyinala.liveroom.wheat.d.e;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends BaseAdapter {
    private Context context;
    private List<AlaWheatInfoData> mList;
    private int nTT;
    private a nTU;

    /* loaded from: classes4.dex */
    public interface a {
        void LX(int i);

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
            view = LayoutInflater.from(this.context).inflate(a.h.yuyin_item_connection_wheat_manager, (ViewGroup) null);
            b bVar2 = new b();
            bVar2.nTy = (TextView) view.findViewById(a.g.tv_rank_num);
            bVar2.nTz = view.findViewById(a.g.margin_top_height);
            bVar2.nTA = (HeadImageView) view.findViewById(a.g.user_avatar);
            bVar2.nTB = (TextView) view.findViewById(a.g.tv_nickname);
            bVar2.nTC = (TextView) view.findViewById(a.g.tv_temp_nickname);
            bVar2.nTD = (ImageView) view.findViewById(a.g.iv_sex);
            bVar2.nTE = (TextView) view.findViewById(a.g.tv_level);
            bVar2.nTG = (TbImageView) view.findViewById(a.g.iv_level);
            bVar2.nTF = (FrameLayout) view.findViewById(a.g.level_container);
            bVar2.nTH = (TbImageView) view.findViewById(a.g.iv_badge);
            bVar2.nTX = (ImageView) view.findViewById(a.g.iv_mute);
            bVar2.nTY = (TextView) view.findViewById(a.g.tv_hang_up);
            bVar2.nTI = (LinearLayout) view.findViewById(a.g.content_container);
            bVar2.nTJ = (LinearLayout) view.findViewById(a.g.icon_container);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        AlaWheatInfoData alaWheatInfoData = (AlaWheatInfoData) ListUtils.getItem(this.mList, i);
        if (alaWheatInfoData != null) {
            if (i < this.nTT) {
                bVar.nTy.setTextSize(12.0f);
                bVar.nTy.setTypeface(Typeface.defaultFromStyle(0));
                bVar.nTy.setText(this.context.getString(a.i.yuyin_ala_connection_wheat_host_text));
            } else {
                bVar.nTy.setTextSize(18.0f);
                bVar.nTy.setTypeface(Typeface.defaultFromStyle(1));
                bVar.nTy.setText(Integer.toString(alaWheatInfoData.realWheatPosition));
            }
            bVar.nTA.setIsRound(true);
            bVar.nTA.setAutoChangeStyle(false);
            bVar.nTA.setDefaultResource(a.f.yuyin_sdk_default_avatar);
            if (alaWheatInfoData != null && !TextUtils.isEmpty(alaWheatInfoData.portrait)) {
                bVar.nTA.setScaleType(ImageView.ScaleType.FIT_XY);
                bVar.nTA.setUrl(alaWheatInfoData.portrait);
                bVar.nTA.startLoad(alaWheatInfoData.portrait, 12, false);
            }
            bVar.nTB.setText(alaWheatInfoData.userName);
            bVar.nTC.setText(alaWheatInfoData.userName);
            bVar.nTX.setSelected(alaWheatInfoData.isOpenMike());
            if (alaWheatInfoData.sex == 0) {
                bVar.nTD.setVisibility(8);
            } else {
                bVar.nTD.setVisibility(0);
                bVar.nTD.setImageResource(alaWheatInfoData.sex == 1 ? a.f.yuyin_sdk_icon_mine_boy : a.f.yuyin_sdk_icon_mine_girl);
            }
            int i3 = alaWheatInfoData.sex == 0 ? 3 : 2;
            bVar.nTF.setVisibility(8);
            bVar.nTH.setVisibility(8);
            int c = e.c(14.0f, view.getContext()) + (e.c(4.0f, view.getContext()) * 2);
            if (alaWheatInfoData.mLiveMarkInfo != null) {
                i2 = c;
                for (int i4 = 0; i4 < alaWheatInfoData.mLiveMarkInfo.size() && i4 < i3; i4++) {
                    switch (alaWheatInfoData.mLiveMarkInfo.get(i4).type) {
                        case 1:
                            bVar.nTF.setVisibility(0);
                            bVar.nTG.startLoad(alaWheatInfoData.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            bVar.nTE.setText(Integer.toString(alaWheatInfoData.level));
                            i2 += e.c(13.0f, view.getContext()) + e.c(4.0f, view.getContext());
                            break;
                        case 105:
                            bVar.nTH.setVisibility(0);
                            bVar.nTH.startLoad(alaWheatInfoData.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            i2 += e.c(42.0f, bVar.nTH.getContext()) + e.c(4.0f, view.getContext());
                            break;
                    }
                }
            } else {
                i2 = c;
            }
            bVar.nTA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.nTU != null && view2.getTag() != null && (view2.getTag() instanceof AlaWheatInfoData)) {
                        d.this.nTU.g((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.nTB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.nTU != null && view2.getTag() != null && (view2.getTag() instanceof AlaWheatInfoData)) {
                        d.this.nTU.g((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.nTA.setTag(alaWheatInfoData);
            bVar.nTB.setTag(alaWheatInfoData);
            bVar.nTY.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
            bVar.nTY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.nTU != null) {
                        d.this.nTU.h((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.nTX.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
            bVar.nTX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.nTU != null && view2.getTag() != null && (view2.getTag() instanceof AlaWheatInfoData)) {
                        d.this.nTU.i((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.nTY.setTag(alaWheatInfoData);
            bVar.nTX.setTag(alaWheatInfoData);
            bVar.nTB.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.5
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar.nTC.getMeasuredWidth() + i2 > bVar.nTI.getMeasuredWidth()) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.nTB.getLayoutParams();
                        layoutParams.weight = 1.0f;
                        bVar.nTB.setLayoutParams(layoutParams);
                        return;
                    }
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.nTB.getLayoutParams();
                    layoutParams2.weight = 0.0f;
                    layoutParams2.width = -2;
                    bVar.nTB.setLayoutParams(layoutParams2);
                }
            });
            bVar.nTz.setVisibility(i != 0 ? 8 : 0);
        }
        return view;
    }

    /* loaded from: classes4.dex */
    private class b {
        private HeadImageView nTA;
        private TextView nTB;
        private TextView nTC;
        private ImageView nTD;
        private TextView nTE;
        private FrameLayout nTF;
        private TbImageView nTG;
        private TbImageView nTH;
        private LinearLayout nTI;
        private LinearLayout nTJ;
        private ImageView nTX;
        private TextView nTY;
        private TextView nTy;
        private View nTz;

        private b() {
        }
    }

    public void LW(int i) {
        this.nTT = i;
    }

    public void setListener(a aVar) {
        this.nTU = aVar;
    }
}
