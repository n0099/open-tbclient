package com.baidu.tieba.yuyinala.liveroom.audiencelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.p;
import com.baidu.live.data.q;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private List<p> aIk;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void d(q qVar) {
        this.aIk = new ArrayList();
        if (qVar != null && qVar.getList() != null && !qVar.getList().isEmpty()) {
            for (p pVar : qVar.getList()) {
                if (pVar != null && pVar.aIe != null) {
                    this.aIk.add(pVar);
                }
            }
        }
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
        C0888a c0888a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.yuyin_ala_live_audience_header_image, (ViewGroup) null);
            C0888a c0888a2 = new C0888a(view);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                c0888a2.gSD.setDefaultResource(a.f.sdk_icon_default_avatar100_hk);
            } else {
                c0888a2.gSD.setDefaultResource(a.f.sdk_icon_default_avatar100);
            }
            c0888a2.gSD.setIsRound(true);
            c0888a2.gSD.setDrawBorder(true);
            c0888a2.gSD.setBorderColor(this.mContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
            c0888a2.gSD.setAutoChangeStyle(false);
            c0888a2.gSD.setScaleType(ImageView.ScaleType.CENTER_CROP);
            c0888a2.gSE.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            view.setTag(c0888a2);
            c0888a = c0888a2;
        } else {
            c0888a = (C0888a) view.getTag();
        }
        p pVar = (p) getItem(i);
        c0888a.gSD.setDrawBorder(true);
        if (i == 0 && pVar.aIe.contribution > 0) {
            c0888a.gSE.setVisibility(0);
            c0888a.gSE.setImageResource(a.f.pic_live_top1);
            c0888a.gSF.setBackgroundResource(a.f.round_header_day_list_bg_1);
        } else if (i == 1 && pVar.aIe.contribution > 0) {
            c0888a.gSE.setVisibility(0);
            c0888a.gSE.setImageResource(a.f.pic_live_top2);
            c0888a.gSF.setBackgroundResource(a.f.round_header_day_list_bg_2);
        } else if (i == 2 && pVar.aIe.contribution > 0) {
            c0888a.gSE.setVisibility(0);
            c0888a.gSE.setImageResource(a.f.pic_live_top3);
            c0888a.gSF.setBackgroundResource(a.f.round_header_day_list_bg_3);
        } else {
            c0888a.gSE.setVisibility(8);
            c0888a.gSF.setBackgroundResource(a.f.round_header_day_list_bg_normal);
        }
        c0888a.gSF.setText(StringHelper.formatForHeaderDayCharmValue(pVar.aIe.contribution));
        if (pVar.aIe.contribution <= 0) {
            c0888a.gSF.setVisibility(4);
        } else {
            c0888a.gSF.setVisibility(0);
        }
        l.a(c0888a.gSD, pVar.aIe.portrait, true, !StringUtils.isNull(pVar.aIe.appId));
        return view;
    }

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.audiencelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0888a {
        public HeadImageView gSD;
        public ImageView gSE;
        public TextView gSF;
        public View rootView;

        public C0888a(View view) {
            this.rootView = view;
            this.gSD = (HeadImageView) view.findViewById(a.g.ala_live_room_audience_header_img);
            this.gSE = (ImageView) view.findViewById(a.g.ala_live_room_audience_pendant);
            this.gSF = (TextView) view.findViewById(a.g.ala_live_room_audience_charm_count);
        }
    }
}
