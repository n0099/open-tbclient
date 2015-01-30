package com.baidu.tieba.pb.main;

import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
public class bu extends com.baidu.adp.base.g<PbActivity> {
    private TextView bCL;
    private View bCM;
    private TextView bCN;
    private TextView bCO;
    private PbActivity bCP;
    private View.OnClickListener mClickListener;
    private TextView mShareTextView;
    private View mView;

    public bu(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.bCL = null;
        this.mShareTextView = null;
        this.bCM = null;
        this.bCN = null;
        this.bCO = null;
        this.bCP = null;
        this.mClickListener = null;
        this.bCP = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView XZ() {
        return this.bCL;
    }

    public TextView Ya() {
        return this.mShareTextView;
    }

    public View Yb() {
        return this.bCM;
    }

    public TextView Yc() {
        return this.bCN;
    }

    public TextView Yd() {
        return this.bCO;
    }

    private void initUI() {
        this.mView = com.baidu.adp.lib.g.b.ei().inflate(this.bCP.getPageContext().getPageActivity(), com.baidu.tieba.x.pb_more_view, null);
        this.bCL = (TextView) this.mView.findViewById(com.baidu.tieba.w.pb_more_view_item_mark);
        this.bCL.setOnClickListener(this.mClickListener);
        this.mShareTextView = (TextView) this.mView.findViewById(com.baidu.tieba.w.pb_more_view_item_share);
        this.bCM = this.mView.findViewById(com.baidu.tieba.w.pb_more_view_item_line_share);
        this.mShareTextView.setOnClickListener(this.mClickListener);
        this.bCN = (TextView) this.mView.findViewById(com.baidu.tieba.w.pb_more_view_item_jump);
        this.bCN.setOnClickListener(this.mClickListener);
        this.bCO = (TextView) this.mView.findViewById(com.baidu.tieba.w.pb_more_view_item_see);
        this.bCO.setOnClickListener(this.mClickListener);
    }
}
