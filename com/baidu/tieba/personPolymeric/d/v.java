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
    private TextView eNG;
    private TextView eNH;
    private View eNI;
    private View eNJ;
    private ac eNK;
    private Context mContext;
    private View mRootView;
    private int mCurrentPage = 0;
    private int akz = aq.getColor(w.e.cp_cont_b);
    private int akA = aq.getColor(w.e.cp_cont_f);

    public v(Context context, ac acVar) {
        this.mContext = context;
        this.eNK = acVar;
    }

    public View VN() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(w.j.person_button_header_view, (ViewGroup) null);
        this.eNG = (TextView) this.mRootView.findViewById(w.h.fourm_name_btn);
        this.eNH = (TextView) this.mRootView.findViewById(w.h.reply_btn);
        this.eNI = this.mRootView.findViewById(w.h.fourm_name_divider);
        this.eNJ = this.mRootView.findViewById(w.h.reply_btn_divider);
        TR();
        this.eNG.setTextColor(this.akz);
        this.eNH.setTextColor(this.akA);
        return this.mRootView;
    }

    private void TR() {
        this.eNG.setOnClickListener(this);
        this.eNH.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == w.h.fourm_name_btn) {
            this.mCurrentPage = 0;
            this.eNK.pz(0);
            this.eNI.setVisibility(0);
            this.eNJ.setVisibility(4);
            this.eNG.setTextColor(this.akz);
            this.eNH.setTextColor(this.akA);
        } else if (view.getId() == w.h.reply_btn) {
            this.eNK.pz(1);
            this.eNI.setVisibility(4);
            this.eNJ.setVisibility(0);
            this.eNG.setTextColor(this.akA);
            this.eNH.setTextColor(this.akz);
            this.mCurrentPage = 1;
        }
    }

    public void onChangeSkinType() {
        this.akz = aq.getColor(w.e.cp_cont_b);
        this.akA = aq.getColor(w.e.cp_cont_f);
        aq.j(this.mRootView, w.g.item_person_header_attention_bg_selector);
        aq.k(this.eNI, w.e.cp_cont_b);
        aq.k(this.eNJ, w.e.cp_cont_b);
        oA(this.mCurrentPage);
    }

    public void oA(int i) {
        this.mCurrentPage = i;
        if (i == 0) {
            this.eNI.setVisibility(0);
            this.eNJ.setVisibility(4);
            this.eNG.setTextColor(this.akz);
            this.eNH.setTextColor(this.akA);
        } else if (i == 1) {
            this.eNI.setVisibility(4);
            this.eNJ.setVisibility(0);
            this.eNG.setTextColor(this.akA);
            this.eNH.setTextColor(this.akz);
        }
    }
}
