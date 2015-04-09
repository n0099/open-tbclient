package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
public class bw extends com.baidu.adp.base.g<PbActivity> {
    private TextView bJN;
    private View bJO;
    private TextView bJP;
    private TextView bJQ;
    private TextView bJR;
    private View bJS;
    private PbActivity bJT;
    private View.OnClickListener mClickListener;
    private TextView mShareTextView;
    private View mView;

    public bw(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.bJN = null;
        this.mShareTextView = null;
        this.bJO = null;
        this.bJP = null;
        this.bJQ = null;
        this.bJR = null;
        this.bJS = null;
        this.bJT = null;
        this.mClickListener = null;
        this.bJT = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView aaq() {
        return this.bJN;
    }

    public TextView aar() {
        return this.mShareTextView;
    }

    public View aas() {
        return this.bJO;
    }

    public TextView aat() {
        return this.bJP;
    }

    public TextView aau() {
        return this.bJQ;
    }

    public TextView aav() {
        return this.bJR;
    }

    public void dO(boolean z) {
        if (z) {
            this.bJR.setVisibility(8);
            this.bJS.setVisibility(8);
            return;
        }
        this.bJR.setVisibility(0);
        this.bJS.setVisibility(0);
    }

    private void initUI() {
        this.mView = com.baidu.adp.lib.g.b.hH().inflate(this.bJT.getPageContext().getPageActivity(), com.baidu.tieba.w.pb_more_view, null);
        this.bJN = (TextView) this.mView.findViewById(com.baidu.tieba.v.pb_more_view_item_mark);
        this.bJN.setOnClickListener(this.mClickListener);
        this.mShareTextView = (TextView) this.mView.findViewById(com.baidu.tieba.v.pb_more_view_item_share);
        this.bJO = this.mView.findViewById(com.baidu.tieba.v.pb_more_view_item_line_share);
        this.mShareTextView.setOnClickListener(this.mClickListener);
        this.bJP = (TextView) this.mView.findViewById(com.baidu.tieba.v.pb_more_view_item_jump);
        this.bJP.setOnClickListener(this.mClickListener);
        this.bJQ = (TextView) this.mView.findViewById(com.baidu.tieba.v.pb_more_view_item_see);
        this.bJQ.setOnClickListener(this.mClickListener);
        this.bJR = (TextView) this.mView.findViewById(com.baidu.tieba.v.pb_more_view_item_report);
        this.bJR.setOnClickListener(this.mClickListener);
        this.bJS = this.mView.findViewById(com.baidu.tieba.v.pb_more_view_item_report_line);
    }
}
