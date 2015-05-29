package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
public class bt extends com.baidu.adp.base.g<PbActivity> {
    private TextView bLT;
    private View bLU;
    private TextView bLV;
    private TextView bLW;
    private TextView bLX;
    private View bLY;
    private PbActivity bLZ;
    private View.OnClickListener mClickListener;
    private TextView mShareTextView;
    private View mView;

    public bt(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.bLT = null;
        this.mShareTextView = null;
        this.bLU = null;
        this.bLV = null;
        this.bLW = null;
        this.bLX = null;
        this.bLY = null;
        this.bLZ = null;
        this.mClickListener = null;
        this.bLZ = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView abE() {
        return this.bLT;
    }

    public TextView abF() {
        return this.mShareTextView;
    }

    public View abG() {
        return this.bLU;
    }

    public TextView abH() {
        return this.bLV;
    }

    public TextView abI() {
        return this.bLW;
    }

    public TextView abJ() {
        return this.bLX;
    }

    public void dZ(boolean z) {
        if (z) {
            this.bLX.setVisibility(8);
            this.bLY.setVisibility(8);
            return;
        }
        this.bLX.setVisibility(0);
        this.bLY.setVisibility(0);
    }

    private void initUI() {
        this.mView = com.baidu.adp.lib.g.b.hr().inflate(this.bLZ.getPageContext().getPageActivity(), com.baidu.tieba.r.pb_more_view, null);
        this.bLT = (TextView) this.mView.findViewById(com.baidu.tieba.q.pb_more_view_item_mark);
        this.bLT.setOnClickListener(this.mClickListener);
        this.mShareTextView = (TextView) this.mView.findViewById(com.baidu.tieba.q.pb_more_view_item_share);
        this.bLU = this.mView.findViewById(com.baidu.tieba.q.pb_more_view_item_line_share);
        this.mShareTextView.setOnClickListener(this.mClickListener);
        this.bLV = (TextView) this.mView.findViewById(com.baidu.tieba.q.pb_more_view_item_jump);
        this.bLV.setOnClickListener(this.mClickListener);
        this.bLW = (TextView) this.mView.findViewById(com.baidu.tieba.q.pb_more_view_item_see);
        this.bLW.setOnClickListener(this.mClickListener);
        this.bLX = (TextView) this.mView.findViewById(com.baidu.tieba.q.pb_more_view_item_report);
        this.bLX.setOnClickListener(this.mClickListener);
        this.bLY = this.mView.findViewById(com.baidu.tieba.q.pb_more_view_item_report_line);
    }
}
