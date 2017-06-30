package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    private TextView eXP;
    private TextView eXQ;
    private View eXR;
    private View eXS;
    private ac eXT;
    private Context mContext;
    private View mRootView;
    private int mCurrentPage = 0;
    private int aln = as.getColor(w.e.cp_cont_b);
    private int alo = as.getColor(w.e.cp_cont_f);

    public v(Context context, ac acVar) {
        this.mContext = context;
        this.eXT = acVar;
    }

    public View Xe() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(w.j.person_button_header_view, (ViewGroup) null);
        this.eXP = (TextView) this.mRootView.findViewById(w.h.fourm_name_btn);
        this.eXQ = (TextView) this.mRootView.findViewById(w.h.reply_btn);
        this.eXR = this.mRootView.findViewById(w.h.fourm_name_divider);
        this.eXS = this.mRootView.findViewById(w.h.reply_btn_divider);
        Vg();
        this.eXP.setTextColor(this.aln);
        this.eXQ.setTextColor(this.alo);
        return this.mRootView;
    }

    private void Vg() {
        this.eXP.setOnClickListener(this);
        this.eXQ.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == w.h.fourm_name_btn) {
            this.mCurrentPage = 0;
            this.eXT.pS(0);
            this.eXR.setVisibility(0);
            this.eXS.setVisibility(4);
            this.eXP.setTextColor(this.aln);
            this.eXQ.setTextColor(this.alo);
        } else if (view.getId() == w.h.reply_btn) {
            this.eXT.pS(1);
            this.eXR.setVisibility(4);
            this.eXS.setVisibility(0);
            this.eXP.setTextColor(this.alo);
            this.eXQ.setTextColor(this.aln);
            this.mCurrentPage = 1;
        }
    }

    public void onChangeSkinType() {
        this.aln = as.getColor(w.e.cp_cont_b);
        this.alo = as.getColor(w.e.cp_cont_f);
        as.j(this.mRootView, w.g.item_person_header_attention_bg_selector);
        as.k(this.eXR, w.e.cp_cont_b);
        as.k(this.eXS, w.e.cp_cont_b);
        oR(this.mCurrentPage);
    }

    public void oR(int i) {
        this.mCurrentPage = i;
        if (i == 0) {
            this.eXR.setVisibility(0);
            this.eXS.setVisibility(4);
            this.eXP.setTextColor(this.aln);
            this.eXQ.setTextColor(this.alo);
        } else if (i == 1) {
            this.eXR.setVisibility(4);
            this.eXS.setVisibility(0);
            this.eXP.setTextColor(this.alo);
            this.eXQ.setTextColor(this.aln);
        }
    }
}
