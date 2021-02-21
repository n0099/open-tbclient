package com.baidu.tieba.yuyinala.liveroom.audiencelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.u;
import com.baidu.live.data.v;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private List<u> aIj;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void d(v vVar) {
        this.aIj = new ArrayList();
        if (vVar != null && vVar.getList() != null && !vVar.getList().isEmpty()) {
            for (u uVar : vVar.getList()) {
                if (uVar != null && uVar.aId != null) {
                    this.aIj.add(uVar);
                }
            }
        }
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
        C0923a c0923a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.yuyin_ala_live_audience_header_image, (ViewGroup) null);
            C0923a c0923a2 = new C0923a(view);
            c0923a2.htM.setDefaultResource(a.e.sdk_icon_default_avatar100);
            c0923a2.htM.setIsRound(true);
            c0923a2.htM.setDrawBorder(true);
            c0923a2.htM.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
            c0923a2.htM.setAutoChangeStyle(false);
            c0923a2.htM.setScaleType(ImageView.ScaleType.CENTER_CROP);
            c0923a2.htN.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            view.setTag(c0923a2);
            c0923a = c0923a2;
        } else {
            c0923a = (C0923a) view.getTag();
        }
        u uVar = (u) getItem(i);
        c0923a.htM.setDrawBorder(true);
        if (i == 0 && uVar.aId.contribution > 0) {
            c0923a.htN.setVisibility(0);
            c0923a.htN.setImageResource(a.e.pic_live_top1);
            c0923a.htO.setBackgroundResource(a.e.round_header_day_list_bg_1);
        } else if (i == 1 && uVar.aId.contribution > 0) {
            c0923a.htN.setVisibility(0);
            c0923a.htN.setImageResource(a.e.pic_live_top2);
            c0923a.htO.setBackgroundResource(a.e.round_header_day_list_bg_2);
        } else if (i == 2 && uVar.aId.contribution > 0) {
            c0923a.htN.setVisibility(0);
            c0923a.htN.setImageResource(a.e.pic_live_top3);
            c0923a.htO.setBackgroundResource(a.e.round_header_day_list_bg_3);
        } else {
            c0923a.htN.setVisibility(8);
            c0923a.htO.setBackgroundResource(a.e.round_header_day_list_bg_normal);
        }
        c0923a.htO.setText(uVar.aId.contributionStr);
        if (uVar.aId.contribution <= 0) {
            c0923a.htO.setVisibility(4);
        } else {
            c0923a.htO.setVisibility(0);
        }
        m.a(c0923a.htM, uVar.aId.portrait, true, !StringUtils.isNull(uVar.aId.appId));
        return view;
    }

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.audiencelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0923a {
        public HeadImageView htM;
        public ImageView htN;
        public TextView htO;
        public View rootView;

        public C0923a(View view) {
            this.rootView = view;
            this.htM = (HeadImageView) view.findViewById(a.f.ala_live_room_audience_header_img);
            this.htN = (ImageView) view.findViewById(a.f.ala_live_room_audience_pendant);
            this.htO = (TextView) view.findViewById(a.f.ala_live_room_audience_charm_count);
        }
    }
}
