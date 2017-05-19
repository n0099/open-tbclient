package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    private TextView eER;
    private TextView eES;
    private View eET;
    private View eEU;
    private ab eEV;
    private Context mContext;
    private View mRootView;
    private int mCurrentPage = 0;
    private int akJ = aq.getColor(w.e.cp_cont_b);
    private int akK = aq.getColor(w.e.cp_cont_f);

    public v(Context context, ab abVar) {
        this.mContext = context;
        this.eEV = abVar;
    }

    public View UK() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(w.j.person_button_header_view, (ViewGroup) null);
        this.eER = (TextView) this.mRootView.findViewById(w.h.fourm_name_btn);
        this.eES = (TextView) this.mRootView.findViewById(w.h.reply_btn);
        this.eET = this.mRootView.findViewById(w.h.fourm_name_divider);
        this.eEU = this.mRootView.findViewById(w.h.reply_btn_divider);
        aQb();
        this.eER.setTextColor(this.akJ);
        this.eES.setTextColor(this.akK);
        return this.mRootView;
    }

    private void aQb() {
        this.eER.setOnClickListener(this);
        this.eES.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == w.h.fourm_name_btn) {
            this.mCurrentPage = 0;
            this.eEV.pa(0);
            this.eET.setVisibility(0);
            this.eEU.setVisibility(4);
            this.eER.setTextColor(this.akJ);
            this.eES.setTextColor(this.akK);
        } else if (view.getId() == w.h.reply_btn) {
            this.eEV.pa(1);
            this.eET.setVisibility(4);
            this.eEU.setVisibility(0);
            this.eER.setTextColor(this.akK);
            this.eES.setTextColor(this.akJ);
            this.mCurrentPage = 1;
        }
    }

    public void onChangeSkinType() {
        this.akJ = aq.getColor(w.e.cp_cont_b);
        this.akK = aq.getColor(w.e.cp_cont_f);
        aq.j(this.mRootView, w.g.item_person_header_attention_bg_selector);
        aq.k(this.eET, w.e.cp_cont_b);
        aq.k(this.eEU, w.e.cp_cont_b);
        oh(this.mCurrentPage);
    }

    public void oh(int i) {
        this.mCurrentPage = i;
        if (i == 0) {
            this.eET.setVisibility(0);
            this.eEU.setVisibility(4);
            this.eER.setTextColor(this.akJ);
            this.eES.setTextColor(this.akK);
        } else if (i == 1) {
            this.eET.setVisibility(4);
            this.eEU.setVisibility(0);
            this.eER.setTextColor(this.akK);
            this.eES.setTextColor(this.akJ);
        }
    }
}
