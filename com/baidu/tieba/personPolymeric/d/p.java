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
    private TextView fnF;
    private TextView fnG;
    private View fnH;
    private View fnI;
    private s fnJ;
    private Context mContext;
    private View mRootView;
    private int mCurrentPage = 0;
    private int anl = ai.getColor(d.e.cp_cont_b);
    private int anm = ai.getColor(d.e.cp_cont_f);

    public p(Context context, s sVar) {
        this.mContext = context;
        this.fnJ = sVar;
    }

    public View Ym() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.j.person_button_header_view, (ViewGroup) null);
        this.fnF = (TextView) this.mRootView.findViewById(d.h.fourm_name_btn);
        this.fnG = (TextView) this.mRootView.findViewById(d.h.reply_btn);
        this.fnH = this.mRootView.findViewById(d.h.fourm_name_divider);
        this.fnI = this.mRootView.findViewById(d.h.reply_btn_divider);
        Wo();
        this.fnF.setTextColor(this.anl);
        this.fnG.setTextColor(this.anm);
        return this.mRootView;
    }

    private void Wo() {
        this.fnF.setOnClickListener(this);
        this.fnG.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.h.fourm_name_btn) {
            this.mCurrentPage = 0;
            this.fnJ.qr(0);
            this.fnH.setVisibility(0);
            this.fnI.setVisibility(4);
            this.fnF.setTextColor(this.anl);
            this.fnG.setTextColor(this.anm);
        } else if (view.getId() == d.h.reply_btn) {
            this.fnJ.qr(1);
            this.fnH.setVisibility(4);
            this.fnI.setVisibility(0);
            this.fnF.setTextColor(this.anm);
            this.fnG.setTextColor(this.anl);
            this.mCurrentPage = 1;
        }
    }

    public void onChangeSkinType() {
        this.anl = ai.getColor(d.e.cp_cont_b);
        this.anm = ai.getColor(d.e.cp_cont_f);
        ai.j(this.mRootView, d.g.item_person_header_attention_bg_selector);
        ai.k(this.fnH, d.e.cp_cont_b);
        ai.k(this.fnI, d.e.cp_cont_b);
        pk(this.mCurrentPage);
    }

    public void pk(int i) {
        this.mCurrentPage = i;
        if (i == 0) {
            this.fnH.setVisibility(0);
            this.fnI.setVisibility(4);
            this.fnF.setTextColor(this.anl);
            this.fnG.setTextColor(this.anm);
        } else if (i == 1) {
            this.fnH.setVisibility(4);
            this.fnI.setVisibility(0);
            this.fnF.setTextColor(this.anm);
            this.fnG.setTextColor(this.anl);
        }
    }
}
