package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ch extends com.baidu.adp.base.g<PbActivity> {
    private PbActivity bJE;
    private TextView bJy;
    private TextView bKJ;
    private ImageView bKK;
    private ImageView bKL;
    private boolean bKM;
    private View.OnClickListener mClickListener;
    private View mView;

    public boolean aan() {
        return this.bKM;
    }

    public void dR(boolean z) {
        this.bKM = z;
    }

    public ch(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.bJy = null;
        this.bKJ = null;
        this.bKK = null;
        this.bKL = null;
        this.bJE = null;
        this.mClickListener = null;
        this.bKM = true;
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

    public TextView aao() {
        return this.bKJ;
    }

    public ImageView aap() {
        return this.bKK;
    }

    public ImageView aaq() {
        return this.bKL;
    }

    private void initUI() {
        this.mView = com.baidu.adp.lib.g.b.hH().inflate(this.bJE.getPageContext().getPageActivity(), com.baidu.tieba.w.pb_reply_view, null);
        this.bJy = (TextView) this.mView.findViewById(com.baidu.tieba.v.pb_reply_view_item_mark);
        this.bJy.setOnClickListener(this.mClickListener);
        this.bKJ = (TextView) this.mView.findViewById(com.baidu.tieba.v.pb_reply_view_item_reply);
        this.bKJ.setOnClickListener(this.mClickListener);
        this.bKK = (ImageView) this.mView.findViewById(com.baidu.tieba.v.pb_reply_view_item_manage);
        this.bKK.setOnClickListener(this.mClickListener);
        this.bKL = (ImageView) this.mView.findViewById(com.baidu.tieba.v.pb_reply_view_item_report);
        this.bKL.setOnClickListener(this.mClickListener);
    }
}
