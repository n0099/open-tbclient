package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class k extends LinearLayout implements View.OnClickListener {
    private View bhj;
    private UserData eDR;
    private com.baidu.tieba.view.g feL;
    private View flp;
    private TbImageView flq;
    private TextView flr;
    private View fls;
    private TbImageView flt;
    private TextView flu;
    private View flv;
    private TbImageView flw;
    private TextView flx;

    public k(Context context) {
        super(context);
        init();
    }

    private void init() {
        setOrientation(1);
        View inflate = LayoutInflater.from(getContext()).inflate(d.j.guest_function_layout, this);
        this.flp = inflate.findViewById(d.h.guest_gift_container);
        this.flp.setOnClickListener(this);
        this.flq = (TbImageView) inflate.findViewById(d.h.gift_icon);
        this.flr = (TextView) inflate.findViewById(d.h.gift_desc);
        this.fls = inflate.findViewById(d.h.guest_video_container);
        this.fls.setOnClickListener(this);
        this.flu = (TextView) inflate.findViewById(d.h.video_desc);
        this.flt = (TbImageView) inflate.findViewById(d.h.video_icon);
        this.flv = inflate.findViewById(d.h.guest_live_container);
        this.flv.setOnClickListener(this);
        this.flw = (TbImageView) inflate.findViewById(d.h.live_icon);
        this.flx = (TextView) inflate.findViewById(d.h.live_desc);
        this.bhj = inflate.findViewById(d.h.guest_function_divider);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.feL != null) {
            com.baidu.tieba.personCenter.c.a aVar = new com.baidu.tieba.personCenter.c.a();
            aVar.cay = new Bundle();
            aVar.cay.putSerializable(UserData.TYPE_USER, this.eDR);
            if (view == this.flp) {
                aVar.cax = 38;
                this.feL.a(this.flp, aVar);
            } else if (view == this.fls) {
                aVar.cax = 39;
                this.feL.a(this.fls, aVar);
            } else if (view == this.flv) {
                aVar.cax = 40;
                this.feL.a(this.flv, aVar);
            }
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.feL = gVar;
    }

    public void setUserData(UserData userData) {
        this.eDR = userData;
    }

    public void onChangeSkinType() {
        ai.k(this.bhj, d.e.cp_bg_line_b);
        ai.j(this.flp, d.g.item_person_center_function_selector);
        ai.j(this.fls, d.g.item_person_center_function_selector);
        ai.j(this.flv, d.g.item_person_center_function_selector);
        ai.c(this.flq, d.g.icon_liwu_caise_heibai);
        ai.c(this.flt, d.g.icon_shipin_caise_heibai);
        ai.c(this.flw, d.g.icon_zhibou_caise_heibai);
        ai.i(this.flr, d.e.cp_cont_d);
        ai.i(this.flu, d.e.cp_cont_d);
        ai.i(this.flx, d.e.cp_cont_d);
    }
}
