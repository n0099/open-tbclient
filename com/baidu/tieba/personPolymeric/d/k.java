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
    private UserData eFL;
    private com.baidu.tieba.view.g fgE;
    private View fni;
    private TbImageView fnj;
    private TextView fnk;
    private View fnl;
    private TbImageView fnm;
    private TextView fnn;
    private View fno;
    private TbImageView fnp;
    private TextView fnq;

    public k(Context context) {
        super(context);
        init();
    }

    private void init() {
        setOrientation(1);
        View inflate = LayoutInflater.from(getContext()).inflate(d.j.guest_function_layout, this);
        this.fni = inflate.findViewById(d.h.guest_gift_container);
        this.fni.setOnClickListener(this);
        this.fnj = (TbImageView) inflate.findViewById(d.h.gift_icon);
        this.fnk = (TextView) inflate.findViewById(d.h.gift_desc);
        this.fnl = inflate.findViewById(d.h.guest_video_container);
        this.fnl.setOnClickListener(this);
        this.fnn = (TextView) inflate.findViewById(d.h.video_desc);
        this.fnm = (TbImageView) inflate.findViewById(d.h.video_icon);
        this.fno = inflate.findViewById(d.h.guest_live_container);
        this.fno.setOnClickListener(this);
        this.fnp = (TbImageView) inflate.findViewById(d.h.live_icon);
        this.fnq = (TextView) inflate.findViewById(d.h.live_desc);
        this.bhj = inflate.findViewById(d.h.guest_function_divider);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fgE != null) {
            com.baidu.tieba.personCenter.c.a aVar = new com.baidu.tieba.personCenter.c.a();
            aVar.cbk = new Bundle();
            aVar.cbk.putSerializable(UserData.TYPE_USER, this.eFL);
            if (view == this.fni) {
                aVar.cbj = 38;
                this.fgE.a(this.fni, aVar);
            } else if (view == this.fnl) {
                aVar.cbj = 39;
                this.fgE.a(this.fnl, aVar);
            } else if (view == this.fno) {
                aVar.cbj = 40;
                this.fgE.a(this.fno, aVar);
            }
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.fgE = gVar;
    }

    public void setUserData(UserData userData) {
        this.eFL = userData;
    }

    public void onChangeSkinType() {
        ai.k(this.bhj, d.e.cp_bg_line_b);
        ai.j(this.fni, d.g.item_person_center_function_selector);
        ai.j(this.fnl, d.g.item_person_center_function_selector);
        ai.j(this.fno, d.g.item_person_center_function_selector);
        ai.c(this.fnj, d.g.icon_liwu_caise_heibai);
        ai.c(this.fnm, d.g.icon_shipin_caise_heibai);
        ai.c(this.fnp, d.g.icon_zhibou_caise_heibai);
        ai.i(this.fnk, d.e.cp_cont_d);
        ai.i(this.fnn, d.e.cp_cont_d);
        ai.i(this.fnq, d.e.cp_cont_d);
    }
}
