package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class k extends LinearLayout implements View.OnClickListener {
    private View bhm;
    private UserData eFb;
    private com.baidu.tieba.view.g ffP;
    private TextView fmA;
    private View fmB;
    private TbImageView fmC;
    private TextView fmD;
    private View fmE;
    private TbImageView fmF;
    private TextView fmG;
    private View fmy;
    private TbImageView fmz;

    public k(Context context) {
        super(context);
        init();
    }

    private void init() {
        setOrientation(1);
        View inflate = LayoutInflater.from(getContext()).inflate(d.j.guest_function_layout, this);
        this.fmy = inflate.findViewById(d.h.guest_gift_container);
        this.fmy.setOnClickListener(this);
        this.fmz = (TbImageView) inflate.findViewById(d.h.gift_icon);
        this.fmA = (TextView) inflate.findViewById(d.h.gift_desc);
        this.fmB = inflate.findViewById(d.h.guest_video_container);
        this.fmB.setOnClickListener(this);
        this.fmD = (TextView) inflate.findViewById(d.h.video_desc);
        this.fmC = (TbImageView) inflate.findViewById(d.h.video_icon);
        this.fmE = inflate.findViewById(d.h.guest_live_container);
        this.fmE.setOnClickListener(this);
        this.fmF = (TbImageView) inflate.findViewById(d.h.live_icon);
        this.fmG = (TextView) inflate.findViewById(d.h.live_desc);
        this.bhm = inflate.findViewById(d.h.guest_function_divider);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ffP != null) {
            com.baidu.tieba.personCenter.c.a aVar = new com.baidu.tieba.personCenter.c.a();
            aVar.ceU = new Bundle();
            aVar.ceU.putSerializable(UserData.TYPE_USER, this.eFb);
            if (view == this.fmy) {
                aVar.ceT = 38;
                this.ffP.a(this.fmy, aVar);
            } else if (view == this.fmB) {
                aVar.ceT = 39;
                this.ffP.a(this.fmB, aVar);
            } else if (view == this.fmE) {
                aVar.ceT = 40;
                this.ffP.a(this.fmE, aVar);
            }
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.ffP = gVar;
    }

    public void setUserData(UserData userData) {
        this.eFb = userData;
    }

    public void onChangeSkinType() {
        aj.k(this.bhm, d.e.cp_bg_line_b);
        aj.j(this.fmy, d.g.item_person_center_function_selector);
        aj.j(this.fmB, d.g.item_person_center_function_selector);
        aj.j(this.fmE, d.g.item_person_center_function_selector);
        aj.c(this.fmz, d.g.icon_liwu_caise_heibai);
        aj.c(this.fmC, d.g.icon_shipin_caise_heibai);
        aj.c(this.fmF, d.g.icon_zhibou_caise_heibai);
        aj.i(this.fmA, d.e.cp_cont_d);
        aj.i(this.fmD, d.e.cp_cont_d);
        aj.i(this.fmG, d.e.cp_cont_d);
    }
}
