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
    private TextView fmV;
    private TextView fmW;
    private View fmX;
    private View fmY;
    private s fmZ;
    private Context mContext;
    private View mRootView;
    private int mCurrentPage = 0;
    private int amD = aj.getColor(d.e.cp_cont_b);
    private int amE = aj.getColor(d.e.cp_cont_f);

    public p(Context context, s sVar) {
        this.mContext = context;
        this.fmZ = sVar;
    }

    public View Zx() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.j.person_button_header_view, (ViewGroup) null);
        this.fmV = (TextView) this.mRootView.findViewById(d.h.fourm_name_btn);
        this.fmW = (TextView) this.mRootView.findViewById(d.h.reply_btn);
        this.fmX = this.mRootView.findViewById(d.h.fourm_name_divider);
        this.fmY = this.mRootView.findViewById(d.h.reply_btn_divider);
        Xz();
        this.fmV.setTextColor(this.amD);
        this.fmW.setTextColor(this.amE);
        return this.mRootView;
    }

    private void Xz() {
        this.fmV.setOnClickListener(this);
        this.fmW.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.h.fourm_name_btn) {
            this.mCurrentPage = 0;
            this.fmZ.qt(0);
            this.fmX.setVisibility(0);
            this.fmY.setVisibility(4);
            this.fmV.setTextColor(this.amD);
            this.fmW.setTextColor(this.amE);
        } else if (view.getId() == d.h.reply_btn) {
            this.fmZ.qt(1);
            this.fmX.setVisibility(4);
            this.fmY.setVisibility(0);
            this.fmV.setTextColor(this.amE);
            this.fmW.setTextColor(this.amD);
            this.mCurrentPage = 1;
        }
    }

    public void onChangeSkinType() {
        this.amD = aj.getColor(d.e.cp_cont_b);
        this.amE = aj.getColor(d.e.cp_cont_f);
        aj.j(this.mRootView, d.g.item_person_header_attention_bg_selector);
        aj.k(this.fmX, d.e.cp_cont_b);
        aj.k(this.fmY, d.e.cp_cont_b);
        pt(this.mCurrentPage);
    }

    public void pt(int i) {
        this.mCurrentPage = i;
        if (i == 0) {
            this.fmX.setVisibility(0);
            this.fmY.setVisibility(4);
            this.fmV.setTextColor(this.amD);
            this.fmW.setTextColor(this.amE);
        } else if (i == 1) {
            this.fmX.setVisibility(4);
            this.fmY.setVisibility(0);
            this.fmV.setTextColor(this.amE);
            this.fmW.setTextColor(this.amD);
        }
    }
}
