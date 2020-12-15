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
    private int orO;
    private a orP;

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
            bVar2.ors = (TextView) view.findViewById(a.f.tv_rank_num);
            bVar2.ort = view.findViewById(a.f.margin_top_height);
            bVar2.oru = (HeadImageView) view.findViewById(a.f.user_avatar);
            bVar2.orv = (TextView) view.findViewById(a.f.tv_nickname);
            bVar2.orw = (TextView) view.findViewById(a.f.tv_temp_nickname);
            bVar2.orx = (ImageView) view.findViewById(a.f.iv_sex);
            bVar2.ory = (TextView) view.findViewById(a.f.tv_level);
            bVar2.orA = (TbImageView) view.findViewById(a.f.iv_level);
            bVar2.orz = (FrameLayout) view.findViewById(a.f.level_container);
            bVar2.orB = (TbImageView) view.findViewById(a.f.iv_badge);
            bVar2.orS = (ImageView) view.findViewById(a.f.iv_mute);
            bVar2.orT = (TextView) view.findViewById(a.f.tv_hang_up);
            bVar2.orC = (LinearLayout) view.findViewById(a.f.content_container);
            bVar2.orD = (LinearLayout) view.findViewById(a.f.icon_container);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        AlaWheatInfoData alaWheatInfoData = (AlaWheatInfoData) ListUtils.getItem(this.mList, i);
        if (alaWheatInfoData != null) {
            if (i < this.orO) {
                bVar.ors.setTextSize(12.0f);
                bVar.ors.setTypeface(Typeface.defaultFromStyle(0));
                bVar.ors.setText(this.context.getString(a.h.yuyin_ala_connection_wheat_host_text));
            } else {
                bVar.ors.setTextSize(18.0f);
                bVar.ors.setTypeface(Typeface.defaultFromStyle(1));
                bVar.ors.setText(Integer.toString(alaWheatInfoData.realWheatPosition));
            }
            bVar.oru.setIsRound(true);
            bVar.oru.setAutoChangeStyle(false);
            bVar.oru.setDefaultResource(a.e.yuyin_sdk_default_avatar);
            if (alaWheatInfoData != null && !TextUtils.isEmpty(alaWheatInfoData.portrait)) {
                bVar.oru.setScaleType(ImageView.ScaleType.FIT_XY);
                bVar.oru.setUrl(alaWheatInfoData.portrait);
                bVar.oru.startLoad(alaWheatInfoData.portrait, 12, false);
            }
            bVar.orv.setText(alaWheatInfoData.userName);
            bVar.orw.setText(alaWheatInfoData.userName);
            bVar.orS.setSelected(alaWheatInfoData.isOpenMike());
            if (alaWheatInfoData.sex == 0) {
                bVar.orx.setVisibility(8);
            } else {
                bVar.orx.setVisibility(0);
                bVar.orx.setImageResource(alaWheatInfoData.sex == 1 ? a.e.yuyin_sdk_icon_mine_boy : a.e.yuyin_sdk_icon_mine_girl);
            }
            int i3 = alaWheatInfoData.sex == 0 ? 3 : 2;
            bVar.orz.setVisibility(8);
            bVar.orB.setVisibility(8);
            int c = e.c(14.0f, view.getContext()) + (e.c(4.0f, view.getContext()) * 2);
            if (alaWheatInfoData.mLiveMarkInfo != null) {
                i2 = c;
                for (int i4 = 0; i4 < alaWheatInfoData.mLiveMarkInfo.size() && i4 < i3; i4++) {
                    switch (alaWheatInfoData.mLiveMarkInfo.get(i4).type) {
                        case 1:
                            bVar.orz.setVisibility(0);
                            bVar.orA.startLoad(alaWheatInfoData.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            bVar.ory.setText(Integer.toString(alaWheatInfoData.level));
                            i2 += e.c(13.0f, view.getContext()) + e.c(4.0f, view.getContext());
                            break;
                        case 105:
                            bVar.orB.setVisibility(0);
                            bVar.orB.startLoad(alaWheatInfoData.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            i2 += e.c(42.0f, bVar.orB.getContext()) + e.c(4.0f, view.getContext());
                            break;
                    }
                }
            } else {
                i2 = c;
            }
            bVar.oru.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.orP != null && view2.getTag() != null && (view2.getTag() instanceof AlaWheatInfoData)) {
                        d.this.orP.i((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.orv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.orP != null && view2.getTag() != null && (view2.getTag() instanceof AlaWheatInfoData)) {
                        d.this.orP.i((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.oru.setTag(alaWheatInfoData);
            bVar.orv.setTag(alaWheatInfoData);
            bVar.orT.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
            bVar.orT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.orP != null) {
                        d.this.orP.j((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.orS.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
            bVar.orS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.orP != null && view2.getTag() != null && (view2.getTag() instanceof AlaWheatInfoData)) {
                        d.this.orP.k((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.orT.setTag(alaWheatInfoData);
            bVar.orS.setTag(alaWheatInfoData);
            bVar.orv.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.5
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar.orw.getMeasuredWidth() + i2 > bVar.orC.getMeasuredWidth()) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.orv.getLayoutParams();
                        layoutParams.weight = 1.0f;
                        bVar.orv.setLayoutParams(layoutParams);
                        return;
                    }
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.orv.getLayoutParams();
                    layoutParams2.weight = 0.0f;
                    layoutParams2.width = -2;
                    bVar.orv.setLayoutParams(layoutParams2);
                }
            });
            bVar.ort.setVisibility(i != 0 ? 8 : 0);
        }
        return view;
    }

    /* loaded from: classes4.dex */
    private class b {
        private TbImageView orA;
        private TbImageView orB;
        private LinearLayout orC;
        private LinearLayout orD;
        private ImageView orS;
        private TextView orT;
        private TextView ors;
        private View ort;
        private HeadImageView oru;
        private TextView orv;
        private TextView orw;
        private ImageView orx;
        private TextView ory;
        private FrameLayout orz;

        private b() {
        }
    }

    public void NI(int i) {
        this.orO = i;
    }

    public void setListener(a aVar) {
        this.orP = aVar;
    }
}
