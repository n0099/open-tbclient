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
    private View bfY;
    private UserData eCE;
    private com.baidu.tieba.view.g fdz;
    private View fkd;
    private TbImageView fke;
    private TextView fkf;
    private View fkg;
    private TbImageView fkh;
    private TextView fki;
    private View fkj;
    private TbImageView fkk;
    private TextView fkl;

    public k(Context context) {
        super(context);
        init();
    }

    private void init() {
        setOrientation(1);
        View inflate = LayoutInflater.from(getContext()).inflate(d.j.guest_function_layout, this);
        this.fkd = inflate.findViewById(d.h.guest_gift_container);
        this.fkd.setOnClickListener(this);
        this.fke = (TbImageView) inflate.findViewById(d.h.gift_icon);
        this.fkf = (TextView) inflate.findViewById(d.h.gift_desc);
        this.fkg = inflate.findViewById(d.h.guest_video_container);
        this.fkg.setOnClickListener(this);
        this.fki = (TextView) inflate.findViewById(d.h.video_desc);
        this.fkh = (TbImageView) inflate.findViewById(d.h.video_icon);
        this.fkj = inflate.findViewById(d.h.guest_live_container);
        this.fkj.setOnClickListener(this);
        this.fkk = (TbImageView) inflate.findViewById(d.h.live_icon);
        this.fkl = (TextView) inflate.findViewById(d.h.live_desc);
        this.bfY = inflate.findViewById(d.h.guest_function_divider);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fdz != null) {
            com.baidu.tieba.personCenter.c.a aVar = new com.baidu.tieba.personCenter.c.a();
            aVar.bZs = new Bundle();
            aVar.bZs.putSerializable(UserData.TYPE_USER, this.eCE);
            if (view == this.fkd) {
                aVar.bZr = 38;
                this.fdz.a(this.fkd, aVar);
            } else if (view == this.fkg) {
                aVar.bZr = 39;
                this.fdz.a(this.fkg, aVar);
            } else if (view == this.fkj) {
                aVar.bZr = 40;
                this.fdz.a(this.fkj, aVar);
            }
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.fdz = gVar;
    }

    public void setUserData(UserData userData) {
        this.eCE = userData;
    }

    public void onChangeSkinType() {
        ai.k(this.bfY, d.e.cp_bg_line_b);
        ai.j(this.fkd, d.g.item_person_center_function_selector);
        ai.j(this.fkg, d.g.item_person_center_function_selector);
        ai.j(this.fkj, d.g.item_person_center_function_selector);
        ai.c(this.fke, d.g.icon_liwu_caise_heibai);
        ai.c(this.fkh, d.g.icon_shipin_caise_heibai);
        ai.c(this.fkk, d.g.icon_zhibou_caise_heibai);
        ai.i(this.fkf, d.e.cp_cont_d);
        ai.i(this.fki, d.e.cp_cont_d);
        ai.i(this.fkl, d.e.cp_cont_d);
    }
}
