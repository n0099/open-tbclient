package com.baidu.tieba.yuyinala.liveroom.roomcard;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.tieba.yuyinala.liveroom.roomcard.e;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends BaseAdapter {
    private List<e.a> aKb;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void gy(List<e.a> list) {
        this.aKb = list;
    }

    public List<e.a> edV() {
        return this.aKb;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aKb == null) {
            return 0;
        }
        return this.aKb.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aKb == null) {
            return null;
        }
        return this.aKb.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.yuyin_ala_room_card_manager_header_image, (ViewGroup) null);
            a aVar2 = new a(view);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                aVar2.hhW.setDefaultResource(a.e.sdk_icon_default_avatar100_hk);
            } else {
                aVar2.hhW.setDefaultResource(a.e.sdk_icon_default_avatar100);
            }
            aVar2.hhW.setIsRound(true);
            aVar2.hhW.setDrawBorder(true);
            aVar2.hhW.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
            aVar2.hhW.setAutoChangeStyle(false);
            aVar2.hhW.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        e.a aVar3 = (e.a) getItem(i);
        aVar.hhW.setDrawBorder(true);
        switch (aVar3.oqe) {
            case 1:
                aVar.opU.setBackgroundResource(a.e.yuyin_round_header_day_list_bg_fangzhu);
                break;
            case 2:
                aVar.opU.setBackgroundResource(a.e.yuyin_round_header_day_list_bg_manage);
                break;
            case 3:
                aVar.opU.setBackgroundResource(a.e.yuyin_round_header_day_list_bg_zhuchi);
                break;
        }
        aVar.opU.setText(aVar3.edW());
        if (!TextUtils.isEmpty(aVar3.oqf)) {
            aVar.hhW.startLoad(aVar3.oqf, 12, false, false);
        } else {
            aVar.hhW.setDefaultResource(a.e.yuyin_sdk_icon_default_zhuchi);
        }
        return view;
    }

    /* loaded from: classes4.dex */
    public static class a {
        public HeadImageView hhW;
        public TextView opU;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.hhW = (HeadImageView) view.findViewById(a.f.ala_live_room_audience_header_img);
            this.opU = (TextView) view.findViewById(a.f.ala_live_room_audience_charm_count);
        }
    }
}
