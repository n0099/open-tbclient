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
    private int oDH;
    private a oDI;

    /* loaded from: classes11.dex */
    public interface a {
        void Mo(int i);

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
            bVar2.oDi = (TextView) view.findViewById(a.f.tv_rank_num);
            bVar2.oDk = view.findViewById(a.f.margin_top_height);
            bVar2.oDn = (ImageView) view.findViewById(a.f.team_fright_flag);
            bVar2.oDl = (HeadImageView) view.findViewById(a.f.user_avatar);
            bVar2.oDm = (TextView) view.findViewById(a.f.tv_nickname);
            bVar2.oDo = (TextView) view.findViewById(a.f.tv_temp_nickname);
            bVar2.oDp = (ImageView) view.findViewById(a.f.iv_sex);
            bVar2.oDq = (TextView) view.findViewById(a.f.tv_level);
            bVar2.oDs = (TbImageView) view.findViewById(a.f.iv_level);
            bVar2.oDr = (FrameLayout) view.findViewById(a.f.level_container);
            bVar2.oDt = (TbImageView) view.findViewById(a.f.iv_badge);
            bVar2.oDL = (ImageView) view.findViewById(a.f.iv_mute);
            bVar2.oDM = (TextView) view.findViewById(a.f.tv_hang_up);
            bVar2.oDu = (LinearLayout) view.findViewById(a.f.content_container);
            bVar2.oDv = (LinearLayout) view.findViewById(a.f.icon_container);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        AlaWheatInfoData alaWheatInfoData = (AlaWheatInfoData) ListUtils.getItem(this.mList, i);
        if (alaWheatInfoData != null) {
            if (i >= this.oDH) {
                if (q.edM().edZ()) {
                    bVar.oDi.setPadding(0, 0, com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(3.0f, bVar.oDi.getContext()), 0);
                    bVar.oDn.setVisibility(0);
                    bVar.oDi.setTextColor(bVar.oDi.getResources().getColor(a.c.sdk_white_alpha100));
                    bVar.oDi.setTextSize(13.0f);
                    if (alaWheatInfoData.isApplyRedTeam()) {
                        bVar.oDn.setImageResource(a.e.yuyin_audio_wheat_red_flag);
                    } else {
                        bVar.oDn.setImageResource(a.e.yuyin_audio_wheat_blue_flag);
                    }
                } else {
                    bVar.oDi.setPadding(0, 0, 0, 0);
                    bVar.oDi.setTextColor(bVar.oDi.getResources().getColor(a.c.sdk_color_B8B8B8));
                    bVar.oDn.setVisibility(8);
                    bVar.oDi.setTextSize(18.0f);
                }
                bVar.oDi.setText(Integer.toString(alaWheatInfoData.realWheatPosition));
            } else {
                bVar.oDi.setPadding(0, 0, 0, 0);
                bVar.oDi.setTextColor(bVar.oDi.getResources().getColor(a.c.sdk_color_B8B8B8));
                bVar.oDn.setVisibility(8);
                bVar.oDi.setTextSize(12.0f);
                bVar.oDi.setText(this.context.getString(a.h.yuyin_ala_connection_wheat_host_text));
            }
            bVar.oDl.setIsRound(true);
            bVar.oDl.setAutoChangeStyle(false);
            bVar.oDl.setDefaultResource(a.e.yuyin_sdk_default_avatar);
            if (alaWheatInfoData != null && !TextUtils.isEmpty(alaWheatInfoData.portrait)) {
                bVar.oDl.setScaleType(ImageView.ScaleType.FIT_XY);
                bVar.oDl.setUrl(alaWheatInfoData.portrait);
                bVar.oDl.startLoad(alaWheatInfoData.portrait, 12, false);
            }
            bVar.oDm.setText(alaWheatInfoData.userName);
            bVar.oDo.setText(alaWheatInfoData.userName);
            bVar.oDL.setSelected(alaWheatInfoData.isOpenMike());
            if (alaWheatInfoData.sex == 0) {
                bVar.oDp.setVisibility(8);
            } else {
                bVar.oDp.setVisibility(0);
                bVar.oDp.setImageResource(alaWheatInfoData.sex == 1 ? a.e.yuyin_sdk_icon_mine_boy : a.e.yuyin_sdk_icon_mine_girl);
            }
            int i3 = alaWheatInfoData.sex == 0 ? 3 : 2;
            bVar.oDr.setVisibility(8);
            bVar.oDt.setVisibility(8);
            int d = com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(14.0f, view.getContext()) + (com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext()) * 2);
            if (alaWheatInfoData.mLiveMarkInfo != null) {
                i2 = d;
                for (int i4 = 0; i4 < alaWheatInfoData.mLiveMarkInfo.size() && i4 < i3; i4++) {
                    switch (alaWheatInfoData.mLiveMarkInfo.get(i4).type) {
                        case 1:
                            bVar.oDr.setVisibility(0);
                            bVar.oDs.startLoad(alaWheatInfoData.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            bVar.oDq.setText(Integer.toString(alaWheatInfoData.level));
                            i2 += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(13.0f, view.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext());
                            break;
                        case 105:
                            bVar.oDt.setVisibility(0);
                            bVar.oDt.startLoad(alaWheatInfoData.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            i2 += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(42.0f, bVar.oDt.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext());
                            break;
                    }
                }
            } else {
                i2 = d;
            }
            bVar.oDl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.oDI != null && view2.getTag() != null && (view2.getTag() instanceof AlaWheatInfoData)) {
                        d.this.oDI.g((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.oDm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.oDI != null && view2.getTag() != null && (view2.getTag() instanceof AlaWheatInfoData)) {
                        d.this.oDI.g((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.oDl.setTag(alaWheatInfoData);
            bVar.oDm.setTag(alaWheatInfoData);
            bVar.oDM.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
            bVar.oDM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.oDI != null) {
                        d.this.oDI.h((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.oDL.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
            bVar.oDL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.oDI != null && view2.getTag() != null && (view2.getTag() instanceof AlaWheatInfoData)) {
                        d.this.oDI.i((AlaWheatInfoData) view2.getTag());
                    }
                }
            });
            bVar.oDM.setTag(alaWheatInfoData);
            bVar.oDL.setTag(alaWheatInfoData);
            bVar.oDm.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.5
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar.oDo.getMeasuredWidth() + i2 > bVar.oDu.getMeasuredWidth()) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.oDm.getLayoutParams();
                        layoutParams.weight = 1.0f;
                        bVar.oDm.setLayoutParams(layoutParams);
                        return;
                    }
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.oDm.getLayoutParams();
                    layoutParams2.weight = 0.0f;
                    layoutParams2.width = -2;
                    bVar.oDm.setLayoutParams(layoutParams2);
                }
            });
            bVar.oDk.setVisibility(i != 0 ? 8 : 0);
        }
        return view;
    }

    /* loaded from: classes11.dex */
    private class b {
        private ImageView oDL;
        private TextView oDM;
        private TextView oDi;
        private View oDk;
        private HeadImageView oDl;
        private TextView oDm;
        private ImageView oDn;
        private TextView oDo;
        private ImageView oDp;
        private TextView oDq;
        private FrameLayout oDr;
        private TbImageView oDs;
        private TbImageView oDt;
        private LinearLayout oDu;
        private LinearLayout oDv;

        private b() {
        }
    }

    public void Mn(int i) {
        this.oDH = i;
    }

    public void setListener(a aVar) {
        this.oDI = aVar;
    }
}
