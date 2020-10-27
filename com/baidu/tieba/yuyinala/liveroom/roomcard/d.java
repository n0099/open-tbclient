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
    private List<e.a> aIk;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void gc(List<e.a> list) {
        this.aIk = list;
    }

    public List<e.a> dVC() {
        return this.aIk;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aIk == null) {
            return 0;
        }
        return this.aIk.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aIk == null) {
            return null;
        }
        return this.aIk.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.yuyin_ala_room_card_manager_header_image, (ViewGroup) null);
            a aVar2 = new a(view);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                aVar2.gSD.setDefaultResource(a.f.sdk_icon_default_avatar100_hk);
            } else {
                aVar2.gSD.setDefaultResource(a.f.sdk_icon_default_avatar100);
            }
            aVar2.gSD.setIsRound(true);
            aVar2.gSD.setDrawBorder(true);
            aVar2.gSD.setBorderColor(this.mContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
            aVar2.gSD.setAutoChangeStyle(false);
            aVar2.gSD.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        e.a aVar3 = (e.a) getItem(i);
        aVar.gSD.setDrawBorder(true);
        switch (aVar3.nSl) {
            case 1:
                aVar.nSb.setBackgroundResource(a.f.yuyin_round_header_day_list_bg_fangzhu);
                break;
            case 2:
                aVar.nSb.setBackgroundResource(a.f.yuyin_round_header_day_list_bg_manage);
                break;
            case 3:
                aVar.nSb.setBackgroundResource(a.f.yuyin_round_header_day_list_bg_zhuchi);
                break;
        }
        aVar.nSb.setText(aVar3.dVD());
        if (!TextUtils.isEmpty(aVar3.nSm)) {
            aVar.gSD.startLoad(aVar3.nSm, 12, false, false);
        } else {
            aVar.gSD.setDefaultResource(a.f.yuyin_sdk_icon_default_zhuchi);
        }
        return view;
    }

    /* loaded from: classes4.dex */
    public static class a {
        public HeadImageView gSD;
        public TextView nSb;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gSD = (HeadImageView) view.findViewById(a.g.ala_live_room_audience_header_img);
            this.nSb = (TextView) view.findViewById(a.g.ala_live_room_audience_charm_count);
        }
    }
}
