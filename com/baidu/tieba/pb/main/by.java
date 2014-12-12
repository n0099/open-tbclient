package com.baidu.tieba.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
/* loaded from: classes.dex */
public class by extends com.baidu.adp.base.g<PbActivity> {
    private TextView bBb;
    private PbActivity bBf;
    private TextView bBl;
    private ImageView bBm;
    private boolean bBn;
    private View.OnClickListener mClickListener;
    private View mView;

    public boolean XD() {
        return this.bBn;
    }

    public void dO(boolean z) {
        this.bBn = z;
    }

    public by(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.bBb = null;
        this.bBl = null;
        this.bBm = null;
        this.bBf = null;
        this.mClickListener = null;
        this.bBn = true;
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

    public TextView XE() {
        return this.bBl;
    }

    public ImageView XF() {
        return this.bBm;
    }

    private void initUI() {
        this.mView = com.baidu.adp.lib.g.b.ek().inflate(this.bBf.getPageContext().getPageActivity(), com.baidu.tieba.x.pb_reply_view, null);
        this.bBb = (TextView) this.mView.findViewById(com.baidu.tieba.w.pb_reply_view_item_mark);
        this.bBb.setOnClickListener(this.mClickListener);
        this.bBl = (TextView) this.mView.findViewById(com.baidu.tieba.w.pb_reply_view_item_reply);
        this.bBl.setOnClickListener(this.mClickListener);
        this.bBm = (ImageView) this.mView.findViewById(com.baidu.tieba.w.pb_reply_view_item_manage);
        this.bBm.setOnClickListener(this.mClickListener);
    }
}
