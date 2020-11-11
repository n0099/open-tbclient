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
    private int obh;
    private a obi;

    /* loaded from: classes4.dex */
    public interface a {
        void Mo(int i);

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
            bVar2.oaL = (TextView) view.findViewById(a.f.tv_rank_num);
            bVar2.oaM = view.findViewById(a.f.margin_top_height);
            bVar2.oaN = (HeadImageView) view.findViewById(a.f.user_avatar);
            bVar2.oaO = (TextView) view.findViewById(a.f.tv_nickname);
            bVar2.oaP = (TextView) view.findViewById(a.f.tv_temp_nickname);
            bVar2.oaQ = (ImageView) view.findViewById(a.f.iv_sex);
            bVar2.oaR = (TextView) view.findViewById(a.f.tv_level);
            bVar2.oaT = (TbImageView) view.findViewById(a.f.iv_level);
            bVar2.oaS = (FrameLayout) view.findViewById(a.f.level_container);
            bVar2.oaU = (TbImageView) view.findViewById(a.f.iv_badge);
            bVar2.obm = (ImageView) view.findViewById(a.f.iv_mute);
            bVar2.obn = (TextView) view.findViewById(a.f.tv_hang_up);
            bVar2.oaV = (LinearLayout) view.findViewById(a.f.content_container);
            bVar2.oaW = (LinearLayout) view.findViewById(a.f.icon_container);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        AlaWheatInfoData alaWheatInfoData = (AlaWheatInfoData) ListUtils.getItem(this.mList, i);
        if (alaWheatInfoData != null) {
            if (i < this.obh) {
                bVar.oaL.setTextSize(12.0f);
                bVar.oaL.setTypeface(Typeface.defaultFromStyle(0));
                bVar.oaL.setText(this.context.getString(a.h.yuyin_ala_connection_wheat_host_text));
            } else {
                bVar.oaL.setTextSize(18.0f);
                bVar.oaL.setTypeface(Typeface.defaultFromStyle(1));
                bVar.oaL.setText(Integer.toString(alaWheatInfoData.realWheatPosition));
            }
            bVar.oaN.setIsRound(true);
            bVar.oaN.setAutoChangeStyle(false);
            bVar.oaN.setDefaultResource(a.e.yuyin_sdk_default_avatar);
            if (alaWheatInfoData != null && !TextUtils.isEmpty(alaWheatInfoData.portrait)) {
                bVar.oaN.setScaleType(ImageView.ScaleType.FIT_XY);
                bVar.oaN.setUrl(alaWheatInfoData.portrait);
                bVar.oaN.startLoad(alaWheatInfoData.portrait, 12, false);
            }
            bVar.oaO.setText(alaWheatInfoData.userName);
            bVar.oaP.setText(alaWheatInfoData.userName);
            bVar.obm.setSelected(alaWheatInfoData.isOpenMike());
            if (alaWheatInfoData.sex == 0) {
                bVar.oaQ.setVisibility(8);
            } else {
                bVar.oaQ.setVisibility(0);
                bVar.oaQ.setImageResource(alaWheatInfoData.sex == 1 ? a.e.yuyin_sdk_icon_mine_boy : a.e.yuyin_sdk_icon_mine_girl);
            }
            int i3 = alaWheatInfoData.sex == 0 ? 3 : 2;
            bVar.oaS.setVisibility(8);
            bVar.oaU.setVisibility(8);
            int c = e.c(14.0f, view.getContext()) + (e.c(4.0f, view.getContext()) * 2);
            if (alaWheatInfoData.mLiveMarkInfo != null) {
                i2 = c;
                for (int i4 = 0; i4 < alaWheatInfoData.mLiveMarkInfo.size() && i4 < i3; i4++) {
                    switch (alaWheatInfoData.mLiveMarkInfo.get(i4).type) {
                        case 1:
                            bVar.oaS.setVisibility(0);
                            bVar.oaT.startLoad(alaWheatInfoData.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            bVar.oaR.setText(Integer.toString(alaWheatInfoData.level));
                            i2 += e.c(13.0f, view.getContext()) + e.c(4.0f, view.getContext());
                            break;
                        case 105:
                            bVar.oaU.setVisibility(0);
                            bVar.oaU.startLoad(alaWheatInfoData.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            i2 += e.c(42.0f, bVar.oaU.getContext()) + e.c(4.0f, view.getContext());
                            break;
                    }
                }
            } else {
                i2 = c;
            }
            bVar.oaN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.obi != null && view2.getTag() != null && (view2.getTag() instanceof AlaWheatInfoData)) {
                        d.this.obi.i((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.oaO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.obi != null && view2.getTag() != null && (view2.getTag() instanceof AlaWheatInfoData)) {
                        d.this.obi.i((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.oaN.setTag(alaWheatInfoData);
            bVar.oaO.setTag(alaWheatInfoData);
            bVar.obn.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
            bVar.obn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.obi != null) {
                        d.this.obi.j((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.obm.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
            bVar.obm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.obi != null && view2.getTag() != null && (view2.getTag() instanceof AlaWheatInfoData)) {
                        d.this.obi.k((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.obn.setTag(alaWheatInfoData);
            bVar.obm.setTag(alaWheatInfoData);
            bVar.oaO.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.5
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar.oaP.getMeasuredWidth() + i2 > bVar.oaV.getMeasuredWidth()) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.oaO.getLayoutParams();
                        layoutParams.weight = 1.0f;
                        bVar.oaO.setLayoutParams(layoutParams);
                        return;
                    }
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.oaO.getLayoutParams();
                    layoutParams2.weight = 0.0f;
                    layoutParams2.width = -2;
                    bVar.oaO.setLayoutParams(layoutParams2);
                }
            });
            bVar.oaM.setVisibility(i != 0 ? 8 : 0);
        }
        return view;
    }

    /* loaded from: classes4.dex */
    private class b {
        private TextView oaL;
        private View oaM;
        private HeadImageView oaN;
        private TextView oaO;
        private TextView oaP;
        private ImageView oaQ;
        private TextView oaR;
        private FrameLayout oaS;
        private TbImageView oaT;
        private TbImageView oaU;
        private LinearLayout oaV;
        private LinearLayout oaW;
        private ImageView obm;
        private TextView obn;

        private b() {
        }
    }

    public void Mn(int i) {
        this.obh = i;
    }

    public void setListener(a aVar) {
        this.obi = aVar;
    }
}
