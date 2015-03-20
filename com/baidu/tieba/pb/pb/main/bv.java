package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
public class bv extends com.baidu.adp.base.g<PbActivity> {
    private TextView bJA;
    private TextView bJB;
    private TextView bJC;
    private View bJD;
    private PbActivity bJE;
    private TextView bJy;
    private View bJz;
    private View.OnClickListener mClickListener;
    private TextView mShareTextView;
    private View mView;

    public bv(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.bJy = null;
        this.mShareTextView = null;
        this.bJz = null;
        this.bJA = null;
        this.bJB = null;
        this.bJC = null;
        this.bJD = null;
        this.bJE = null;
        this.mClickListener = null;
        this.bJE = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView aad() {
        return this.bJy;
    }

    public TextView aae() {
        return this.mShareTextView;
    }

    public View aaf() {
        return this.bJz;
    }

    public TextView aag() {
        return this.bJA;
    }

    public TextView aah() {
        return this.bJB;
    }

    public TextView aai() {
        return this.bJC;
    }

    public void dQ(boolean z) {
        if (z) {
            this.bJC.setVisibility(8);
            this.bJD.setVisibility(8);
            return;
        }
        this.bJC.setVisibility(0);
        this.bJD.setVisibility(0);
    }

    private void initUI() {
        this.mView = com.baidu.adp.lib.g.b.hH().inflate(this.bJE.getPageContext().getPageActivity(), com.baidu.tieba.w.pb_more_view, null);
        this.bJy = (TextView) this.mView.findViewById(com.baidu.tieba.v.pb_more_view_item_mark);
        this.bJy.setOnClickListener(this.mClickListener);
        this.mShareTextView = (TextView) this.mView.findViewById(com.baidu.tieba.v.pb_more_view_item_share);
        this.bJz = this.mView.findViewById(com.baidu.tieba.v.pb_more_view_item_line_share);
        this.mShareTextView.setOnClickListener(this.mClickListener);
        this.bJA = (TextView) this.mView.findViewById(com.baidu.tieba.v.pb_more_view_item_jump);
        this.bJA.setOnClickListener(this.mClickListener);
        this.bJB = (TextView) this.mView.findViewById(com.baidu.tieba.v.pb_more_view_item_see);
        this.bJB.setOnClickListener(this.mClickListener);
        this.bJC = (TextView) this.mView.findViewById(com.baidu.tieba.v.pb_more_view_item_report);
        this.bJC.setOnClickListener(this.mClickListener);
        this.bJD = this.mView.findViewById(com.baidu.tieba.v.pb_more_view_item_report_line);
    }
}
