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
    private int ocM;
    private a ocN;

    /* loaded from: classes4.dex */
    public interface a {
        void MR(int i);

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
            bVar2.ocp = (TextView) view.findViewById(a.f.tv_rank_num);
            bVar2.ocq = view.findViewById(a.f.margin_top_height);
            bVar2.ocs = (HeadImageView) view.findViewById(a.f.user_avatar);
            bVar2.oct = (TextView) view.findViewById(a.f.tv_nickname);
            bVar2.ocu = (TextView) view.findViewById(a.f.tv_temp_nickname);
            bVar2.ocv = (ImageView) view.findViewById(a.f.iv_sex);
            bVar2.ocw = (TextView) view.findViewById(a.f.tv_level);
            bVar2.ocy = (TbImageView) view.findViewById(a.f.iv_level);
            bVar2.ocx = (FrameLayout) view.findViewById(a.f.level_container);
            bVar2.ocz = (TbImageView) view.findViewById(a.f.iv_badge);
            bVar2.ocQ = (ImageView) view.findViewById(a.f.iv_mute);
            bVar2.ocR = (TextView) view.findViewById(a.f.tv_hang_up);
            bVar2.ocA = (LinearLayout) view.findViewById(a.f.content_container);
            bVar2.ocB = (LinearLayout) view.findViewById(a.f.icon_container);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        AlaWheatInfoData alaWheatInfoData = (AlaWheatInfoData) ListUtils.getItem(this.mList, i);
        if (alaWheatInfoData != null) {
            if (i < this.ocM) {
                bVar.ocp.setTextSize(12.0f);
                bVar.ocp.setTypeface(Typeface.defaultFromStyle(0));
                bVar.ocp.setText(this.context.getString(a.h.yuyin_ala_connection_wheat_host_text));
            } else {
                bVar.ocp.setTextSize(18.0f);
                bVar.ocp.setTypeface(Typeface.defaultFromStyle(1));
                bVar.ocp.setText(Integer.toString(alaWheatInfoData.realWheatPosition));
            }
            bVar.ocs.setIsRound(true);
            bVar.ocs.setAutoChangeStyle(false);
            bVar.ocs.setDefaultResource(a.e.yuyin_sdk_default_avatar);
            if (alaWheatInfoData != null && !TextUtils.isEmpty(alaWheatInfoData.portrait)) {
                bVar.ocs.setScaleType(ImageView.ScaleType.FIT_XY);
                bVar.ocs.setUrl(alaWheatInfoData.portrait);
                bVar.ocs.startLoad(alaWheatInfoData.portrait, 12, false);
            }
            bVar.oct.setText(alaWheatInfoData.userName);
            bVar.ocu.setText(alaWheatInfoData.userName);
            bVar.ocQ.setSelected(alaWheatInfoData.isOpenMike());
            if (alaWheatInfoData.sex == 0) {
                bVar.ocv.setVisibility(8);
            } else {
                bVar.ocv.setVisibility(0);
                bVar.ocv.setImageResource(alaWheatInfoData.sex == 1 ? a.e.yuyin_sdk_icon_mine_boy : a.e.yuyin_sdk_icon_mine_girl);
            }
            int i3 = alaWheatInfoData.sex == 0 ? 3 : 2;
            bVar.ocx.setVisibility(8);
            bVar.ocz.setVisibility(8);
            int c = e.c(14.0f, view.getContext()) + (e.c(4.0f, view.getContext()) * 2);
            if (alaWheatInfoData.mLiveMarkInfo != null) {
                i2 = c;
                for (int i4 = 0; i4 < alaWheatInfoData.mLiveMarkInfo.size() && i4 < i3; i4++) {
                    switch (alaWheatInfoData.mLiveMarkInfo.get(i4).type) {
                        case 1:
                            bVar.ocx.setVisibility(0);
                            bVar.ocy.startLoad(alaWheatInfoData.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            bVar.ocw.setText(Integer.toString(alaWheatInfoData.level));
                            i2 += e.c(13.0f, view.getContext()) + e.c(4.0f, view.getContext());
                            break;
                        case 105:
                            bVar.ocz.setVisibility(0);
                            bVar.ocz.startLoad(alaWheatInfoData.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            i2 += e.c(42.0f, bVar.ocz.getContext()) + e.c(4.0f, view.getContext());
                            break;
                    }
                }
            } else {
                i2 = c;
            }
            bVar.ocs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.ocN != null && view2.getTag() != null && (view2.getTag() instanceof AlaWheatInfoData)) {
                        d.this.ocN.i((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.oct.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.ocN != null && view2.getTag() != null && (view2.getTag() instanceof AlaWheatInfoData)) {
                        d.this.ocN.i((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.ocs.setTag(alaWheatInfoData);
            bVar.oct.setTag(alaWheatInfoData);
            bVar.ocR.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
            bVar.ocR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.ocN != null) {
                        d.this.ocN.j((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.ocQ.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
            bVar.ocQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.ocN != null && view2.getTag() != null && (view2.getTag() instanceof AlaWheatInfoData)) {
                        d.this.ocN.k((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.ocR.setTag(alaWheatInfoData);
            bVar.ocQ.setTag(alaWheatInfoData);
            bVar.oct.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.5
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar.ocu.getMeasuredWidth() + i2 > bVar.ocA.getMeasuredWidth()) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.oct.getLayoutParams();
                        layoutParams.weight = 1.0f;
                        bVar.oct.setLayoutParams(layoutParams);
                        return;
                    }
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.oct.getLayoutParams();
                    layoutParams2.weight = 0.0f;
                    layoutParams2.width = -2;
                    bVar.oct.setLayoutParams(layoutParams2);
                }
            });
            bVar.ocq.setVisibility(i != 0 ? 8 : 0);
        }
        return view;
    }

    /* loaded from: classes4.dex */
    private class b {
        private LinearLayout ocA;
        private LinearLayout ocB;
        private ImageView ocQ;
        private TextView ocR;
        private TextView ocp;
        private View ocq;
        private HeadImageView ocs;
        private TextView oct;
        private TextView ocu;
        private ImageView ocv;
        private TextView ocw;
        private FrameLayout ocx;
        private TbImageView ocy;
        private TbImageView ocz;

        private b() {
        }
    }

    public void MQ(int i) {
        this.ocM = i;
    }

    public void setListener(a aVar) {
        this.ocN = aVar;
    }
}
