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
    private List<p> aKb;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void d(q qVar) {
        this.aKb = new ArrayList();
        if (qVar != null && qVar.getList() != null && !qVar.getList().isEmpty()) {
            for (p pVar : qVar.getList()) {
                if (pVar != null && pVar.aJV != null) {
                    this.aKb.add(pVar);
                }
            }
        }
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
        C0923a c0923a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.yuyin_ala_live_audience_header_image, (ViewGroup) null);
            C0923a c0923a2 = new C0923a(view);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                c0923a2.hhW.setDefaultResource(a.e.sdk_icon_default_avatar100_hk);
            } else {
                c0923a2.hhW.setDefaultResource(a.e.sdk_icon_default_avatar100);
            }
            c0923a2.hhW.setIsRound(true);
            c0923a2.hhW.setDrawBorder(true);
            c0923a2.hhW.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
            c0923a2.hhW.setAutoChangeStyle(false);
            c0923a2.hhW.setScaleType(ImageView.ScaleType.CENTER_CROP);
            c0923a2.hhX.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            view.setTag(c0923a2);
            c0923a = c0923a2;
        } else {
            c0923a = (C0923a) view.getTag();
        }
        p pVar = (p) getItem(i);
        c0923a.hhW.setDrawBorder(true);
        if (i == 0 && pVar.aJV.contribution > 0) {
            c0923a.hhX.setVisibility(0);
            c0923a.hhX.setImageResource(a.e.pic_live_top1);
            c0923a.hhY.setBackgroundResource(a.e.round_header_day_list_bg_1);
        } else if (i == 1 && pVar.aJV.contribution > 0) {
            c0923a.hhX.setVisibility(0);
            c0923a.hhX.setImageResource(a.e.pic_live_top2);
            c0923a.hhY.setBackgroundResource(a.e.round_header_day_list_bg_2);
        } else if (i == 2 && pVar.aJV.contribution > 0) {
            c0923a.hhX.setVisibility(0);
            c0923a.hhX.setImageResource(a.e.pic_live_top3);
            c0923a.hhY.setBackgroundResource(a.e.round_header_day_list_bg_3);
        } else {
            c0923a.hhX.setVisibility(8);
            c0923a.hhY.setBackgroundResource(a.e.round_header_day_list_bg_normal);
        }
        c0923a.hhY.setText(StringHelper.formatForHeaderDayCharmValue(pVar.aJV.contribution));
        if (pVar.aJV.contribution <= 0) {
            c0923a.hhY.setVisibility(4);
        } else {
            c0923a.hhY.setVisibility(0);
        }
        l.a(c0923a.hhW, pVar.aJV.portrait, true, !StringUtils.isNull(pVar.aJV.appId));
        return view;
    }

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.audiencelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0923a {
        public HeadImageView hhW;
        public ImageView hhX;
        public TextView hhY;
        public View rootView;

        public C0923a(View view) {
            this.rootView = view;
            this.hhW = (HeadImageView) view.findViewById(a.f.ala_live_room_audience_header_img);
            this.hhX = (ImageView) view.findViewById(a.f.ala_live_room_audience_pendant);
            this.hhY = (TextView) view.findViewById(a.f.ala_live_room_audience_charm_count);
        }
    }
}
