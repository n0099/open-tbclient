package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ci extends com.baidu.adp.base.g<PbActivity> {
    private TextView bJN;
    private PbActivity bJT;
    private TextView bKY;
    private ImageView bKZ;
    private ImageView bLa;
    private boolean bLb;
    private View.OnClickListener mClickListener;
    private View mView;

    public boolean aaA() {
        return this.bLb;
    }

    public void dP(boolean z) {
        this.bLb = z;
    }

    public ci(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.bJN = null;
        this.bKY = null;
        this.bKZ = null;
        this.bLa = null;
        this.bJT = null;
        this.mClickListener = null;
        this.bLb = true;
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

    public TextView aaB() {
        return this.bKY;
    }

    public ImageView aaC() {
        return this.bKZ;
    }

    public ImageView aaD() {
        return this.bLa;
    }

    private void initUI() {
        this.mView = com.baidu.adp.lib.g.b.hH().inflate(this.bJT.getPageContext().getPageActivity(), com.baidu.tieba.w.pb_reply_view, null);
        this.bJN = (TextView) this.mView.findViewById(com.baidu.tieba.v.pb_reply_view_item_mark);
        this.bJN.setOnClickListener(this.mClickListener);
        this.bKY = (TextView) this.mView.findViewById(com.baidu.tieba.v.pb_reply_view_item_reply);
        this.bKY.setOnClickListener(this.mClickListener);
        this.bKZ = (ImageView) this.mView.findViewById(com.baidu.tieba.v.pb_reply_view_item_manage);
        this.bKZ.setOnClickListener(this.mClickListener);
        this.bLa = (ImageView) this.mView.findViewById(com.baidu.tieba.v.pb_reply_view_item_report);
        this.bLa.setOnClickListener(this.mClickListener);
    }
}
