package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    private TextView fmc;
    private TextView fmd;
    private View fme;
    private View fmf;
    private s fmg;
    private Context mContext;
    private View mRootView;
    private int mCurrentPage = 0;
    private int amF = aj.getColor(d.e.cp_cont_b);
    private int amG = aj.getColor(d.e.cp_cont_f);

    public p(Context context, s sVar) {
        this.mContext = context;
        this.fmg = sVar;
    }

    public View Zm() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.j.person_button_header_view, (ViewGroup) null);
        this.fmc = (TextView) this.mRootView.findViewById(d.h.fourm_name_btn);
        this.fmd = (TextView) this.mRootView.findViewById(d.h.reply_btn);
        this.fme = this.mRootView.findViewById(d.h.fourm_name_divider);
        this.fmf = this.mRootView.findViewById(d.h.reply_btn_divider);
        Xo();
        this.fmc.setTextColor(this.amF);
        this.fmd.setTextColor(this.amG);
        return this.mRootView;
    }

    private void Xo() {
        this.fmc.setOnClickListener(this);
        this.fmd.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.h.fourm_name_btn) {
            this.mCurrentPage = 0;
            this.fmg.qr(0);
            this.fme.setVisibility(0);
            this.fmf.setVisibility(4);
            this.fmc.setTextColor(this.amF);
            this.fmd.setTextColor(this.amG);
        } else if (view.getId() == d.h.reply_btn) {
            this.fmg.qr(1);
            this.fme.setVisibility(4);
            this.fmf.setVisibility(0);
            this.fmc.setTextColor(this.amG);
            this.fmd.setTextColor(this.amF);
            this.mCurrentPage = 1;
        }
    }

    public void onChangeSkinType() {
        this.amF = aj.getColor(d.e.cp_cont_b);
        this.amG = aj.getColor(d.e.cp_cont_f);
        aj.j(this.mRootView, d.g.item_person_header_attention_bg_selector);
        aj.k(this.fme, d.e.cp_cont_b);
        aj.k(this.fmf, d.e.cp_cont_b);
        pr(this.mCurrentPage);
    }

    public void pr(int i) {
        this.mCurrentPage = i;
        if (i == 0) {
            this.fme.setVisibility(0);
            this.fmf.setVisibility(4);
            this.fmc.setTextColor(this.amF);
            this.fmd.setTextColor(this.amG);
        } else if (i == 1) {
            this.fme.setVisibility(4);
            this.fmf.setVisibility(0);
            this.fmc.setTextColor(this.amG);
            this.fmd.setTextColor(this.amF);
        }
    }
}
