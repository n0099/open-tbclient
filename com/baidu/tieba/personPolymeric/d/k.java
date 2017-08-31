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
    private View bhp;
    private UserData eEh;
    private com.baidu.tieba.view.g feW;
    private View flF;
    private TbImageView flG;
    private TextView flH;
    private View flI;
    private TbImageView flJ;
    private TextView flK;
    private View flL;
    private TbImageView flM;
    private TextView flN;

    public k(Context context) {
        super(context);
        init();
    }

    private void init() {
        setOrientation(1);
        View inflate = LayoutInflater.from(getContext()).inflate(d.j.guest_function_layout, this);
        this.flF = inflate.findViewById(d.h.guest_gift_container);
        this.flF.setOnClickListener(this);
        this.flG = (TbImageView) inflate.findViewById(d.h.gift_icon);
        this.flH = (TextView) inflate.findViewById(d.h.gift_desc);
        this.flI = inflate.findViewById(d.h.guest_video_container);
        this.flI.setOnClickListener(this);
        this.flK = (TextView) inflate.findViewById(d.h.video_desc);
        this.flJ = (TbImageView) inflate.findViewById(d.h.video_icon);
        this.flL = inflate.findViewById(d.h.guest_live_container);
        this.flL.setOnClickListener(this);
        this.flM = (TbImageView) inflate.findViewById(d.h.live_icon);
        this.flN = (TextView) inflate.findViewById(d.h.live_desc);
        this.bhp = inflate.findViewById(d.h.guest_function_divider);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.feW != null) {
            com.baidu.tieba.personCenter.c.a aVar = new com.baidu.tieba.personCenter.c.a();
            aVar.cec = new Bundle();
            aVar.cec.putSerializable(UserData.TYPE_USER, this.eEh);
            if (view == this.flF) {
                aVar.ceb = 38;
                this.feW.a(this.flF, aVar);
            } else if (view == this.flI) {
                aVar.ceb = 39;
                this.feW.a(this.flI, aVar);
            } else if (view == this.flL) {
                aVar.ceb = 40;
                this.feW.a(this.flL, aVar);
            }
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.feW = gVar;
    }

    public void setUserData(UserData userData) {
        this.eEh = userData;
    }

    public void onChangeSkinType() {
        aj.k(this.bhp, d.e.cp_bg_line_b);
        aj.j(this.flF, d.g.item_person_center_function_selector);
        aj.j(this.flI, d.g.item_person_center_function_selector);
        aj.j(this.flL, d.g.item_person_center_function_selector);
        aj.c(this.flG, d.g.icon_liwu_caise_heibai);
        aj.c(this.flJ, d.g.icon_shipin_caise_heibai);
        aj.c(this.flM, d.g.icon_zhibou_caise_heibai);
        aj.i(this.flH, d.e.cp_cont_d);
        aj.i(this.flK, d.e.cp_cont_d);
        aj.i(this.flN, d.e.cp_cont_d);
    }
}
