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
    private View bhk;
    private UserData eFN;
    private com.baidu.tieba.view.g fgG;
    private View fnk;
    private TbImageView fnl;
    private TextView fnm;
    private View fnn;
    private TbImageView fno;
    private TextView fnp;
    private View fnq;
    private TbImageView fnr;
    private TextView fns;

    public k(Context context) {
        super(context);
        init();
    }

    private void init() {
        setOrientation(1);
        View inflate = LayoutInflater.from(getContext()).inflate(d.j.guest_function_layout, this);
        this.fnk = inflate.findViewById(d.h.guest_gift_container);
        this.fnk.setOnClickListener(this);
        this.fnl = (TbImageView) inflate.findViewById(d.h.gift_icon);
        this.fnm = (TextView) inflate.findViewById(d.h.gift_desc);
        this.fnn = inflate.findViewById(d.h.guest_video_container);
        this.fnn.setOnClickListener(this);
        this.fnp = (TextView) inflate.findViewById(d.h.video_desc);
        this.fno = (TbImageView) inflate.findViewById(d.h.video_icon);
        this.fnq = inflate.findViewById(d.h.guest_live_container);
        this.fnq.setOnClickListener(this);
        this.fnr = (TbImageView) inflate.findViewById(d.h.live_icon);
        this.fns = (TextView) inflate.findViewById(d.h.live_desc);
        this.bhk = inflate.findViewById(d.h.guest_function_divider);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fgG != null) {
            com.baidu.tieba.personCenter.c.a aVar = new com.baidu.tieba.personCenter.c.a();
            aVar.cbl = new Bundle();
            aVar.cbl.putSerializable(UserData.TYPE_USER, this.eFN);
            if (view == this.fnk) {
                aVar.cbk = 38;
                this.fgG.a(this.fnk, aVar);
            } else if (view == this.fnn) {
                aVar.cbk = 39;
                this.fgG.a(this.fnn, aVar);
            } else if (view == this.fnq) {
                aVar.cbk = 40;
                this.fgG.a(this.fnq, aVar);
            }
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.fgG = gVar;
    }

    public void setUserData(UserData userData) {
        this.eFN = userData;
    }

    public void onChangeSkinType() {
        ai.k(this.bhk, d.e.cp_bg_line_b);
        ai.j(this.fnk, d.g.item_person_center_function_selector);
        ai.j(this.fnn, d.g.item_person_center_function_selector);
        ai.j(this.fnq, d.g.item_person_center_function_selector);
        ai.c(this.fnl, d.g.icon_liwu_caise_heibai);
        ai.c(this.fno, d.g.icon_shipin_caise_heibai);
        ai.c(this.fnr, d.g.icon_zhibou_caise_heibai);
        ai.i(this.fnm, d.e.cp_cont_d);
        ai.i(this.fnp, d.e.cp_cont_d);
        ai.i(this.fns, d.e.cp_cont_d);
    }
}
