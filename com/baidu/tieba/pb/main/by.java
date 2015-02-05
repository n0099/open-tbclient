package com.baidu.tieba.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
/* loaded from: classes.dex */
public class by extends com.baidu.adp.base.g<PbActivity> {
    private TextView bCK;
    private PbActivity bCO;
    private TextView bCU;
    private ImageView bCV;
    private boolean bCW;
    private View.OnClickListener mClickListener;
    private View mView;

    public boolean Yd() {
        return this.bCW;
    }

    public void dU(boolean z) {
        this.bCW = z;
    }

    public by(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.bCK = null;
        this.bCU = null;
        this.bCV = null;
        this.bCO = null;
        this.mClickListener = null;
        this.bCW = true;
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

    public TextView Ye() {
        return this.bCU;
    }

    public ImageView Yf() {
        return this.bCV;
    }

    private void initUI() {
        this.mView = com.baidu.adp.lib.g.b.ei().inflate(this.bCO.getPageContext().getPageActivity(), com.baidu.tieba.x.pb_reply_view, null);
        this.bCK = (TextView) this.mView.findViewById(com.baidu.tieba.w.pb_reply_view_item_mark);
        this.bCK.setOnClickListener(this.mClickListener);
        this.bCU = (TextView) this.mView.findViewById(com.baidu.tieba.w.pb_reply_view_item_reply);
        this.bCU.setOnClickListener(this.mClickListener);
        this.bCV = (ImageView) this.mView.findViewById(com.baidu.tieba.w.pb_reply_view_item_manage);
        this.bCV.setOnClickListener(this.mClickListener);
    }
}
