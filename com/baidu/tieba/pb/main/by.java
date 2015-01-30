package com.baidu.tieba.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
/* loaded from: classes.dex */
public class by extends com.baidu.adp.base.g<PbActivity> {
    private TextView bCL;
    private PbActivity bCP;
    private TextView bCV;
    private ImageView bCW;
    private boolean bCX;
    private View.OnClickListener mClickListener;
    private View mView;

    public boolean Yi() {
        return this.bCX;
    }

    public void dU(boolean z) {
        this.bCX = z;
    }

    public by(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.bCL = null;
        this.bCV = null;
        this.bCW = null;
        this.bCP = null;
        this.mClickListener = null;
        this.bCX = true;
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

    public TextView Yj() {
        return this.bCV;
    }

    public ImageView Yk() {
        return this.bCW;
    }

    private void initUI() {
        this.mView = com.baidu.adp.lib.g.b.ei().inflate(this.bCP.getPageContext().getPageActivity(), com.baidu.tieba.x.pb_reply_view, null);
        this.bCL = (TextView) this.mView.findViewById(com.baidu.tieba.w.pb_reply_view_item_mark);
        this.bCL.setOnClickListener(this.mClickListener);
        this.bCV = (TextView) this.mView.findViewById(com.baidu.tieba.w.pb_reply_view_item_reply);
        this.bCV.setOnClickListener(this.mClickListener);
        this.bCW = (ImageView) this.mView.findViewById(com.baidu.tieba.w.pb_reply_view_item_manage);
        this.bCW.setOnClickListener(this.mClickListener);
    }
}
