package com.baidu.tieba.pb.main;

import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
public class bu extends com.baidu.adp.base.g<PbActivity> {
    private TextView bBb;
    private View bBc;
    private TextView bBd;
    private TextView bBe;
    private PbActivity bBf;
    private View.OnClickListener mClickListener;
    private TextView mShareTextView;
    private View mView;

    public bu(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.bBb = null;
        this.mShareTextView = null;
        this.bBc = null;
        this.bBd = null;
        this.bBe = null;
        this.bBf = null;
        this.mClickListener = null;
        this.bBf = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView Xu() {
        return this.bBb;
    }

    public TextView Xv() {
        return this.mShareTextView;
    }

    public View Xw() {
        return this.bBc;
    }

    public TextView Xx() {
        return this.bBd;
    }

    public TextView Xy() {
        return this.bBe;
    }

    private void initUI() {
        this.mView = com.baidu.adp.lib.g.b.ek().inflate(this.bBf.getPageContext().getPageActivity(), com.baidu.tieba.x.pb_more_view, null);
        this.bBb = (TextView) this.mView.findViewById(com.baidu.tieba.w.pb_more_view_item_mark);
        this.bBb.setOnClickListener(this.mClickListener);
        this.mShareTextView = (TextView) this.mView.findViewById(com.baidu.tieba.w.pb_more_view_item_share);
        this.bBc = this.mView.findViewById(com.baidu.tieba.w.pb_more_view_item_line_share);
        this.mShareTextView.setOnClickListener(this.mClickListener);
        this.bBd = (TextView) this.mView.findViewById(com.baidu.tieba.w.pb_more_view_item_jump);
        this.bBd.setOnClickListener(this.mClickListener);
        this.bBe = (TextView) this.mView.findViewById(com.baidu.tieba.w.pb_more_view_item_see);
        this.bBe.setOnClickListener(this.mClickListener);
    }
}
