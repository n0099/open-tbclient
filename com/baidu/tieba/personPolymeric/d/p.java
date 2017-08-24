package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    private TextView fnH;
    private TextView fnI;
    private View fnJ;
    private View fnK;
    private s fnL;
    private Context mContext;
    private View mRootView;
    private int mCurrentPage = 0;
    private int anl = ai.getColor(d.e.cp_cont_b);
    private int anm = ai.getColor(d.e.cp_cont_f);

    public p(Context context, s sVar) {
        this.mContext = context;
        this.fnL = sVar;
    }

    public View Yj() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.j.person_button_header_view, (ViewGroup) null);
        this.fnH = (TextView) this.mRootView.findViewById(d.h.fourm_name_btn);
        this.fnI = (TextView) this.mRootView.findViewById(d.h.reply_btn);
        this.fnJ = this.mRootView.findViewById(d.h.fourm_name_divider);
        this.fnK = this.mRootView.findViewById(d.h.reply_btn_divider);
        Wl();
        this.fnH.setTextColor(this.anl);
        this.fnI.setTextColor(this.anm);
        return this.mRootView;
    }

    private void Wl() {
        this.fnH.setOnClickListener(this);
        this.fnI.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.h.fourm_name_btn) {
            this.mCurrentPage = 0;
            this.fnL.qr(0);
            this.fnJ.setVisibility(0);
            this.fnK.setVisibility(4);
            this.fnH.setTextColor(this.anl);
            this.fnI.setTextColor(this.anm);
        } else if (view.getId() == d.h.reply_btn) {
            this.fnL.qr(1);
            this.fnJ.setVisibility(4);
            this.fnK.setVisibility(0);
            this.fnH.setTextColor(this.anm);
            this.fnI.setTextColor(this.anl);
            this.mCurrentPage = 1;
        }
    }

    public void onChangeSkinType() {
        this.anl = ai.getColor(d.e.cp_cont_b);
        this.anm = ai.getColor(d.e.cp_cont_f);
        ai.j(this.mRootView, d.g.item_person_header_attention_bg_selector);
        ai.k(this.fnJ, d.e.cp_cont_b);
        ai.k(this.fnK, d.e.cp_cont_b);
        pk(this.mCurrentPage);
    }

    public void pk(int i) {
        this.mCurrentPage = i;
        if (i == 0) {
            this.fnJ.setVisibility(0);
            this.fnK.setVisibility(4);
            this.fnH.setTextColor(this.anl);
            this.fnI.setTextColor(this.anm);
        } else if (i == 1) {
            this.fnJ.setVisibility(4);
            this.fnK.setVisibility(0);
            this.fnH.setTextColor(this.anm);
            this.fnI.setTextColor(this.anl);
        }
    }
}
