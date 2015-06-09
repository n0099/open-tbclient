package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
public class bt extends com.baidu.adp.base.g<PbActivity> {
    private TextView bLU;
    private View bLV;
    private TextView bLW;
    private TextView bLX;
    private TextView bLY;
    private View bLZ;
    private PbActivity bMa;
    private View.OnClickListener mClickListener;
    private TextView mShareTextView;
    private View mView;

    public bt(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.bLU = null;
        this.mShareTextView = null;
        this.bLV = null;
        this.bLW = null;
        this.bLX = null;
        this.bLY = null;
        this.bLZ = null;
        this.bMa = null;
        this.mClickListener = null;
        this.bMa = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView abF() {
        return this.bLU;
    }

    public TextView abG() {
        return this.mShareTextView;
    }

    public View abH() {
        return this.bLV;
    }

    public TextView abI() {
        return this.bLW;
    }

    public TextView abJ() {
        return this.bLX;
    }

    public TextView abK() {
        return this.bLY;
    }

    public void dZ(boolean z) {
        if (z) {
            this.bLY.setVisibility(8);
            this.bLZ.setVisibility(8);
            return;
        }
        this.bLY.setVisibility(0);
        this.bLZ.setVisibility(0);
    }

    private void initUI() {
        this.mView = com.baidu.adp.lib.g.b.hr().inflate(this.bMa.getPageContext().getPageActivity(), com.baidu.tieba.r.pb_more_view, null);
        this.bLU = (TextView) this.mView.findViewById(com.baidu.tieba.q.pb_more_view_item_mark);
        this.bLU.setOnClickListener(this.mClickListener);
        this.mShareTextView = (TextView) this.mView.findViewById(com.baidu.tieba.q.pb_more_view_item_share);
        this.bLV = this.mView.findViewById(com.baidu.tieba.q.pb_more_view_item_line_share);
        this.mShareTextView.setOnClickListener(this.mClickListener);
        this.bLW = (TextView) this.mView.findViewById(com.baidu.tieba.q.pb_more_view_item_jump);
        this.bLW.setOnClickListener(this.mClickListener);
        this.bLX = (TextView) this.mView.findViewById(com.baidu.tieba.q.pb_more_view_item_see);
        this.bLX.setOnClickListener(this.mClickListener);
        this.bLY = (TextView) this.mView.findViewById(com.baidu.tieba.q.pb_more_view_item_report);
        this.bLY.setOnClickListener(this.mClickListener);
        this.bLZ = this.mView.findViewById(com.baidu.tieba.q.pb_more_view_item_report_line);
    }
}
