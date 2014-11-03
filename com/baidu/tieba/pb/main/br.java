package com.baidu.tieba.pb.main;

import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
public class br extends com.baidu.adp.base.f {
    private View.OnClickListener He;
    private TextView bxj;
    private TextView bxk;
    private View bxl;
    private TextView bxm;
    private TextView bxn;
    private PbActivity bxo;
    private View mView;

    public br(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity);
        this.mView = null;
        this.bxj = null;
        this.bxk = null;
        this.bxl = null;
        this.bxm = null;
        this.bxn = null;
        this.bxo = null;
        this.He = null;
        this.bxo = pbActivity;
        this.He = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView WX() {
        return this.bxj;
    }

    public TextView WY() {
        return this.bxk;
    }

    public View WZ() {
        return this.bxl;
    }

    public TextView Xa() {
        return this.bxm;
    }

    public TextView Xb() {
        return this.bxn;
    }

    private void initUI() {
        this.mView = com.baidu.adp.lib.g.b.ek().inflate(this.bxo, com.baidu.tieba.w.pb_more_view, null);
        this.bxj = (TextView) this.mView.findViewById(com.baidu.tieba.v.pb_more_view_item_mark);
        this.bxj.setOnClickListener(this.He);
        this.bxk = (TextView) this.mView.findViewById(com.baidu.tieba.v.pb_more_view_item_share);
        this.bxl = this.mView.findViewById(com.baidu.tieba.v.pb_more_view_item_line_share);
        this.bxk.setOnClickListener(this.He);
        this.bxm = (TextView) this.mView.findViewById(com.baidu.tieba.v.pb_more_view_item_jump);
        this.bxm.setOnClickListener(this.He);
        this.bxn = (TextView) this.mView.findViewById(com.baidu.tieba.v.pb_more_view_item_see);
        this.bxn.setOnClickListener(this.He);
    }
}
