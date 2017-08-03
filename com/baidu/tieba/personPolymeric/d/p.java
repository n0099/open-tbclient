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
    private TextView fkA;
    private TextView fkB;
    private View fkC;
    private View fkD;
    private s fkE;
    private Context mContext;
    private View mRootView;
    private int mCurrentPage = 0;
    private int alR = ai.getColor(d.e.cp_cont_b);
    private int alS = ai.getColor(d.e.cp_cont_f);

    public p(Context context, s sVar) {
        this.mContext = context;
        this.fkE = sVar;
    }

    public View XM() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.j.person_button_header_view, (ViewGroup) null);
        this.fkA = (TextView) this.mRootView.findViewById(d.h.fourm_name_btn);
        this.fkB = (TextView) this.mRootView.findViewById(d.h.reply_btn);
        this.fkC = this.mRootView.findViewById(d.h.fourm_name_divider);
        this.fkD = this.mRootView.findViewById(d.h.reply_btn_divider);
        VN();
        this.fkA.setTextColor(this.alR);
        this.fkB.setTextColor(this.alS);
        return this.mRootView;
    }

    private void VN() {
        this.fkA.setOnClickListener(this);
        this.fkB.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.h.fourm_name_btn) {
            this.mCurrentPage = 0;
            this.fkE.qh(0);
            this.fkC.setVisibility(0);
            this.fkD.setVisibility(4);
            this.fkA.setTextColor(this.alR);
            this.fkB.setTextColor(this.alS);
        } else if (view.getId() == d.h.reply_btn) {
            this.fkE.qh(1);
            this.fkC.setVisibility(4);
            this.fkD.setVisibility(0);
            this.fkA.setTextColor(this.alS);
            this.fkB.setTextColor(this.alR);
            this.mCurrentPage = 1;
        }
    }

    public void onChangeSkinType() {
        this.alR = ai.getColor(d.e.cp_cont_b);
        this.alS = ai.getColor(d.e.cp_cont_f);
        ai.j(this.mRootView, d.g.item_person_header_attention_bg_selector);
        ai.k(this.fkC, d.e.cp_cont_b);
        ai.k(this.fkD, d.e.cp_cont_b);
        pa(this.mCurrentPage);
    }

    public void pa(int i) {
        this.mCurrentPage = i;
        if (i == 0) {
            this.fkC.setVisibility(0);
            this.fkD.setVisibility(4);
            this.fkA.setTextColor(this.alR);
            this.fkB.setTextColor(this.alS);
        } else if (i == 1) {
            this.fkC.setVisibility(4);
            this.fkD.setVisibility(0);
            this.fkA.setTextColor(this.alS);
            this.fkB.setTextColor(this.alR);
        }
    }
}
