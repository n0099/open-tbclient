package com.baidu.tieba.pb.main;

import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
public class br extends com.baidu.adp.base.f {
    private View.OnClickListener Hd;
    private TextView bwV;
    private TextView bwW;
    private View bwX;
    private TextView bwY;
    private TextView bwZ;
    private PbActivity bxa;
    private View mView;

    public br(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity);
        this.mView = null;
        this.bwV = null;
        this.bwW = null;
        this.bwX = null;
        this.bwY = null;
        this.bwZ = null;
        this.bxa = null;
        this.Hd = null;
        this.bxa = pbActivity;
        this.Hd = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView WU() {
        return this.bwV;
    }

    public TextView WV() {
        return this.bwW;
    }

    public View WW() {
        return this.bwX;
    }

    public TextView WX() {
        return this.bwY;
    }

    public TextView WY() {
        return this.bwZ;
    }

    private void initUI() {
        this.mView = com.baidu.adp.lib.g.b.ek().inflate(this.bxa, com.baidu.tieba.w.pb_more_view, null);
        this.bwV = (TextView) this.mView.findViewById(com.baidu.tieba.v.pb_more_view_item_mark);
        this.bwV.setOnClickListener(this.Hd);
        this.bwW = (TextView) this.mView.findViewById(com.baidu.tieba.v.pb_more_view_item_share);
        this.bwX = this.mView.findViewById(com.baidu.tieba.v.pb_more_view_item_line_share);
        this.bwW.setOnClickListener(this.Hd);
        this.bwY = (TextView) this.mView.findViewById(com.baidu.tieba.v.pb_more_view_item_jump);
        this.bwY.setOnClickListener(this.Hd);
        this.bwZ = (TextView) this.mView.findViewById(com.baidu.tieba.v.pb_more_view_item_see);
        this.bwZ.setOnClickListener(this.Hd);
    }
}
