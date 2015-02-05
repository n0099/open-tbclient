package com.baidu.tieba.pb.main;

import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
public class bu extends com.baidu.adp.base.g<PbActivity> {
    private TextView bCK;
    private View bCL;
    private TextView bCM;
    private TextView bCN;
    private PbActivity bCO;
    private View.OnClickListener mClickListener;
    private TextView mShareTextView;
    private View mView;

    public bu(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.bCK = null;
        this.mShareTextView = null;
        this.bCL = null;
        this.bCM = null;
        this.bCN = null;
        this.bCO = null;
        this.mClickListener = null;
        this.bCO = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView XU() {
        return this.bCK;
    }

    public TextView XV() {
        return this.mShareTextView;
    }

    public View XW() {
        return this.bCL;
    }

    public TextView XX() {
        return this.bCM;
    }

    public TextView XY() {
        return this.bCN;
    }

    private void initUI() {
        this.mView = com.baidu.adp.lib.g.b.ei().inflate(this.bCO.getPageContext().getPageActivity(), com.baidu.tieba.x.pb_more_view, null);
        this.bCK = (TextView) this.mView.findViewById(com.baidu.tieba.w.pb_more_view_item_mark);
        this.bCK.setOnClickListener(this.mClickListener);
        this.mShareTextView = (TextView) this.mView.findViewById(com.baidu.tieba.w.pb_more_view_item_share);
        this.bCL = this.mView.findViewById(com.baidu.tieba.w.pb_more_view_item_line_share);
        this.mShareTextView.setOnClickListener(this.mClickListener);
        this.bCM = (TextView) this.mView.findViewById(com.baidu.tieba.w.pb_more_view_item_jump);
        this.bCM.setOnClickListener(this.mClickListener);
        this.bCN = (TextView) this.mView.findViewById(com.baidu.tieba.w.pb_more_view_item_see);
        this.bCN.setOnClickListener(this.mClickListener);
    }
}
