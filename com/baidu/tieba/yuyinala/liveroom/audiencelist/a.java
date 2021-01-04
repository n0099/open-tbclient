package com.baidu.tieba.yuyinala.liveroom.audiencelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.q;
import com.baidu.live.data.r;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private List<q> aKA;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void d(r rVar) {
        this.aKA = new ArrayList();
        if (rVar != null && rVar.getList() != null && !rVar.getList().isEmpty()) {
            for (q qVar : rVar.getList()) {
                if (qVar != null && qVar.aKu != null) {
                    this.aKA.add(qVar);
                }
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aKA == null) {
            return 0;
        }
        return this.aKA.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aKA == null) {
            return null;
        }
        return this.aKA.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0897a c0897a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.yuyin_ala_live_audience_header_image, (ViewGroup) null);
            C0897a c0897a2 = new C0897a(view);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                c0897a2.htT.setDefaultResource(a.e.sdk_icon_default_avatar100_hk);
            } else {
                c0897a2.htT.setDefaultResource(a.e.sdk_icon_default_avatar100);
            }
            c0897a2.htT.setIsRound(true);
            c0897a2.htT.setDrawBorder(true);
            c0897a2.htT.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
            c0897a2.htT.setAutoChangeStyle(false);
            c0897a2.htT.setScaleType(ImageView.ScaleType.CENTER_CROP);
            c0897a2.htU.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            view.setTag(c0897a2);
            c0897a = c0897a2;
        } else {
            c0897a = (C0897a) view.getTag();
        }
        q qVar = (q) getItem(i);
        c0897a.htT.setDrawBorder(true);
        if (i == 0 && qVar.aKu.contribution > 0) {
            c0897a.htU.setVisibility(0);
            c0897a.htU.setImageResource(a.e.pic_live_top1);
            c0897a.htV.setBackgroundResource(a.e.round_header_day_list_bg_1);
        } else if (i == 1 && qVar.aKu.contribution > 0) {
            c0897a.htU.setVisibility(0);
            c0897a.htU.setImageResource(a.e.pic_live_top2);
            c0897a.htV.setBackgroundResource(a.e.round_header_day_list_bg_2);
        } else if (i == 2 && qVar.aKu.contribution > 0) {
            c0897a.htU.setVisibility(0);
            c0897a.htU.setImageResource(a.e.pic_live_top3);
            c0897a.htV.setBackgroundResource(a.e.round_header_day_list_bg_3);
        } else {
            c0897a.htU.setVisibility(8);
            c0897a.htV.setBackgroundResource(a.e.round_header_day_list_bg_normal);
        }
        c0897a.htV.setText(qVar.aKu.contributionStr);
        if (qVar.aKu.contribution <= 0) {
            c0897a.htV.setVisibility(4);
        } else {
            c0897a.htV.setVisibility(0);
        }
        m.a(c0897a.htT, qVar.aKu.portrait, true, !StringUtils.isNull(qVar.aKu.appId));
        return view;
    }

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.audiencelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0897a {
        public HeadImageView htT;
        public ImageView htU;
        public TextView htV;
        public View rootView;

        public C0897a(View view) {
            this.rootView = view;
            this.htT = (HeadImageView) view.findViewById(a.f.ala_live_room_audience_header_img);
            this.htU = (ImageView) view.findViewById(a.f.ala_live_room_audience_pendant);
            this.htV = (TextView) view.findViewById(a.f.ala_live_room_audience_charm_count);
        }
    }
}
