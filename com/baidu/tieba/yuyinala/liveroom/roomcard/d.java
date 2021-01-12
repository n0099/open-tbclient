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
/* loaded from: classes10.dex */
public class d extends BaseAdapter {
    private List<e.a> aFN;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void gq(List<e.a> list) {
        this.aFN = list;
    }

    public List<e.a> dZw() {
        return this.aFN;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aFN == null) {
            return 0;
        }
        return this.aFN.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aFN == null) {
            return null;
        }
        return this.aFN.get(i);
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
                aVar2.hpn.setDefaultResource(a.e.sdk_icon_default_avatar100_hk);
            } else {
                aVar2.hpn.setDefaultResource(a.e.yuyin_sdk_default_avatar);
            }
            aVar2.hpn.setIsRound(true);
            aVar2.hpn.setDrawBorder(true);
            aVar2.hpn.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
            aVar2.hpn.setAutoChangeStyle(false);
            aVar2.hpn.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        e.a aVar3 = (e.a) getItem(i);
        aVar.hpn.setDrawBorder(true);
        switch (aVar3.ooN) {
            case 1:
                aVar.ooD.setBackgroundResource(a.e.yuyin_round_header_day_list_bg_fangzhu);
                break;
            case 2:
                aVar.ooD.setBackgroundResource(a.e.yuyin_round_header_day_list_bg_manage);
                break;
            case 3:
                aVar.ooD.setBackgroundResource(a.e.yuyin_round_header_day_list_bg_zhuchi);
                break;
        }
        aVar.ooD.setText(aVar3.dZx());
        if (!TextUtils.isEmpty(aVar3.ooO)) {
            aVar.hpn.startLoad(aVar3.ooO, 12, false, false);
        } else {
            aVar.hpn.setDefaultResource(a.e.yuyin_sdk_icon_default_zhuchi);
        }
        return view;
    }

    /* loaded from: classes10.dex */
    public static class a {
        public HeadImageView hpn;
        public TextView ooD;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.hpn = (HeadImageView) view.findViewById(a.f.ala_live_room_audience_header_img);
            this.ooD = (TextView) view.findViewById(a.f.ala_live_room_audience_charm_count);
        }
    }
}
