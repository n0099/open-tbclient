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
import com.baidu.tieba.yuyinala.liveroom.wheat.e.e;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends BaseAdapter {
    private Context context;
    private List<AlaWheatInfoData> mList;
    private int orM;
    private a orN;

    /* loaded from: classes4.dex */
    public interface a {
        void NJ(int i);

        void i(AlaWheatInfoData alaWheatInfoData);

        void j(AlaWheatInfoData alaWheatInfoData);

        void k(AlaWheatInfoData alaWheatInfoData);
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
            bVar2.orq = (TextView) view.findViewById(a.f.tv_rank_num);
            bVar2.orr = view.findViewById(a.f.margin_top_height);
            bVar2.ors = (HeadImageView) view.findViewById(a.f.user_avatar);
            bVar2.ort = (TextView) view.findViewById(a.f.tv_nickname);
            bVar2.oru = (TextView) view.findViewById(a.f.tv_temp_nickname);
            bVar2.orv = (ImageView) view.findViewById(a.f.iv_sex);
            bVar2.orw = (TextView) view.findViewById(a.f.tv_level);
            bVar2.ory = (TbImageView) view.findViewById(a.f.iv_level);
            bVar2.orx = (FrameLayout) view.findViewById(a.f.level_container);
            bVar2.orz = (TbImageView) view.findViewById(a.f.iv_badge);
            bVar2.orQ = (ImageView) view.findViewById(a.f.iv_mute);
            bVar2.orR = (TextView) view.findViewById(a.f.tv_hang_up);
            bVar2.orA = (LinearLayout) view.findViewById(a.f.content_container);
            bVar2.orB = (LinearLayout) view.findViewById(a.f.icon_container);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        AlaWheatInfoData alaWheatInfoData = (AlaWheatInfoData) ListUtils.getItem(this.mList, i);
        if (alaWheatInfoData != null) {
            if (i < this.orM) {
                bVar.orq.setTextSize(12.0f);
                bVar.orq.setTypeface(Typeface.defaultFromStyle(0));
                bVar.orq.setText(this.context.getString(a.h.yuyin_ala_connection_wheat_host_text));
            } else {
                bVar.orq.setTextSize(18.0f);
                bVar.orq.setTypeface(Typeface.defaultFromStyle(1));
                bVar.orq.setText(Integer.toString(alaWheatInfoData.realWheatPosition));
            }
            bVar.ors.setIsRound(true);
            bVar.ors.setAutoChangeStyle(false);
            bVar.ors.setDefaultResource(a.e.yuyin_sdk_default_avatar);
            if (alaWheatInfoData != null && !TextUtils.isEmpty(alaWheatInfoData.portrait)) {
                bVar.ors.setScaleType(ImageView.ScaleType.FIT_XY);
                bVar.ors.setUrl(alaWheatInfoData.portrait);
                bVar.ors.startLoad(alaWheatInfoData.portrait, 12, false);
            }
            bVar.ort.setText(alaWheatInfoData.userName);
            bVar.oru.setText(alaWheatInfoData.userName);
            bVar.orQ.setSelected(alaWheatInfoData.isOpenMike());
            if (alaWheatInfoData.sex == 0) {
                bVar.orv.setVisibility(8);
            } else {
                bVar.orv.setVisibility(0);
                bVar.orv.setImageResource(alaWheatInfoData.sex == 1 ? a.e.yuyin_sdk_icon_mine_boy : a.e.yuyin_sdk_icon_mine_girl);
            }
            int i3 = alaWheatInfoData.sex == 0 ? 3 : 2;
            bVar.orx.setVisibility(8);
            bVar.orz.setVisibility(8);
            int c = e.c(14.0f, view.getContext()) + (e.c(4.0f, view.getContext()) * 2);
            if (alaWheatInfoData.mLiveMarkInfo != null) {
                i2 = c;
                for (int i4 = 0; i4 < alaWheatInfoData.mLiveMarkInfo.size() && i4 < i3; i4++) {
                    switch (alaWheatInfoData.mLiveMarkInfo.get(i4).type) {
                        case 1:
                            bVar.orx.setVisibility(0);
                            bVar.ory.startLoad(alaWheatInfoData.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            bVar.orw.setText(Integer.toString(alaWheatInfoData.level));
                            i2 += e.c(13.0f, view.getContext()) + e.c(4.0f, view.getContext());
                            break;
                        case 105:
                            bVar.orz.setVisibility(0);
                            bVar.orz.startLoad(alaWheatInfoData.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            i2 += e.c(42.0f, bVar.orz.getContext()) + e.c(4.0f, view.getContext());
                            break;
                    }
                }
            } else {
                i2 = c;
            }
            bVar.ors.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.orN != null && view2.getTag() != null && (view2.getTag() instanceof AlaWheatInfoData)) {
                        d.this.orN.i((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.ort.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.orN != null && view2.getTag() != null && (view2.getTag() instanceof AlaWheatInfoData)) {
                        d.this.orN.i((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.ors.setTag(alaWheatInfoData);
            bVar.ort.setTag(alaWheatInfoData);
            bVar.orR.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
            bVar.orR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.orN != null) {
                        d.this.orN.j((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.orQ.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
            bVar.orQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.orN != null && view2.getTag() != null && (view2.getTag() instanceof AlaWheatInfoData)) {
                        d.this.orN.k((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.orR.setTag(alaWheatInfoData);
            bVar.orQ.setTag(alaWheatInfoData);
            bVar.ort.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.5
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar.oru.getMeasuredWidth() + i2 > bVar.orA.getMeasuredWidth()) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.ort.getLayoutParams();
                        layoutParams.weight = 1.0f;
                        bVar.ort.setLayoutParams(layoutParams);
                        return;
                    }
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.ort.getLayoutParams();
                    layoutParams2.weight = 0.0f;
                    layoutParams2.width = -2;
                    bVar.ort.setLayoutParams(layoutParams2);
                }
            });
            bVar.orr.setVisibility(i != 0 ? 8 : 0);
        }
        return view;
    }

    /* loaded from: classes4.dex */
    private class b {
        private LinearLayout orA;
        private LinearLayout orB;
        private ImageView orQ;
        private TextView orR;
        private TextView orq;
        private View orr;
        private HeadImageView ors;
        private TextView ort;
        private TextView oru;
        private ImageView orv;
        private TextView orw;
        private FrameLayout orx;
        private TbImageView ory;
        private TbImageView orz;

        private b() {
        }
    }

    public void NI(int i) {
        this.orM = i;
    }

    public void setListener(a aVar) {
        this.orN = aVar;
    }
}
