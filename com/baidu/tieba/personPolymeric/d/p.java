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
    private TextView flM;
    private TextView flN;
    private View flO;
    private View flP;
    private s flQ;
    private Context mContext;
    private View mRootView;
    private int mCurrentPage = 0;
    private int ank = ai.getColor(d.e.cp_cont_b);
    private int anl = ai.getColor(d.e.cp_cont_f);

    public p(Context context, s sVar) {
        this.mContext = context;
        this.flQ = sVar;
    }

    public View XR() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.j.person_button_header_view, (ViewGroup) null);
        this.flM = (TextView) this.mRootView.findViewById(d.h.fourm_name_btn);
        this.flN = (TextView) this.mRootView.findViewById(d.h.reply_btn);
        this.flO = this.mRootView.findViewById(d.h.fourm_name_divider);
        this.flP = this.mRootView.findViewById(d.h.reply_btn_divider);
        VS();
        this.flM.setTextColor(this.ank);
        this.flN.setTextColor(this.anl);
        return this.mRootView;
    }

    private void VS() {
        this.flM.setOnClickListener(this);
        this.flN.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.h.fourm_name_btn) {
            this.mCurrentPage = 0;
            this.flQ.qh(0);
            this.flO.setVisibility(0);
            this.flP.setVisibility(4);
            this.flM.setTextColor(this.ank);
            this.flN.setTextColor(this.anl);
        } else if (view.getId() == d.h.reply_btn) {
            this.flQ.qh(1);
            this.flO.setVisibility(4);
            this.flP.setVisibility(0);
            this.flM.setTextColor(this.anl);
            this.flN.setTextColor(this.ank);
            this.mCurrentPage = 1;
        }
    }

    public void onChangeSkinType() {
        this.ank = ai.getColor(d.e.cp_cont_b);
        this.anl = ai.getColor(d.e.cp_cont_f);
        ai.j(this.mRootView, d.g.item_person_header_attention_bg_selector);
        ai.k(this.flO, d.e.cp_cont_b);
        ai.k(this.flP, d.e.cp_cont_b);
        pa(this.mCurrentPage);
    }

    public void pa(int i) {
        this.mCurrentPage = i;
        if (i == 0) {
            this.flO.setVisibility(0);
            this.flP.setVisibility(4);
            this.flM.setTextColor(this.ank);
            this.flN.setTextColor(this.anl);
        } else if (i == 1) {
            this.flO.setVisibility(4);
            this.flP.setVisibility(0);
            this.flM.setTextColor(this.anl);
            this.flN.setTextColor(this.ank);
        }
    }
}
