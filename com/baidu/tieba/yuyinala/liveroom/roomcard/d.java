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
/* loaded from: classes11.dex */
public class d extends BaseAdapter {
    private List<e.a> aIj;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public void go(List<e.a> list) {
        this.aIj = list;
    }

    public List<e.a> ebR() {
        return this.aIj;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aIj == null) {
            return 0;
        }
        return this.aIj.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aIj == null) {
            return null;
        }
        return this.aIj.get(i);
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
                aVar2.htM.setDefaultResource(a.e.sdk_icon_default_avatar100);
            } else {
                aVar2.htM.setDefaultResource(a.e.yuyin_sdk_default_avatar);
            }
            aVar2.htM.setIsRound(true);
            aVar2.htM.setDrawBorder(true);
            aVar2.htM.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
            aVar2.htM.setAutoChangeStyle(false);
            aVar2.htM.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        e.a aVar3 = (e.a) getItem(i);
        aVar.htM.setDrawBorder(true);
        switch (aVar3.oze) {
            case 1:
                aVar.oyU.setBackgroundResource(a.e.yuyin_round_header_day_list_bg_fangzhu);
                break;
            case 2:
                aVar.oyU.setBackgroundResource(a.e.yuyin_round_header_day_list_bg_manage);
                break;
            case 3:
                aVar.oyU.setBackgroundResource(a.e.yuyin_round_header_day_list_bg_zhuchi);
                break;
        }
        aVar.oyU.setText(aVar3.ebS());
        if (!TextUtils.isEmpty(aVar3.ozf)) {
            aVar.htM.startLoad(aVar3.ozf, 12, false, false);
        } else {
            aVar.htM.setDefaultResource(a.e.yuyin_sdk_icon_default_zhuchi);
        }
        return view;
    }

    /* loaded from: classes11.dex */
    public static class a {
        public HeadImageView htM;
        public TextView oyU;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.htM = (HeadImageView) view.findViewById(a.f.ala_live_room_audience_header_img);
            this.oyU = (TextView) view.findViewById(a.f.ala_live_room_audience_charm_count);
        }
    }
}
