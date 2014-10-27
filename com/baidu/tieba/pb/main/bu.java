package com.baidu.tieba.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
/* loaded from: classes.dex */
public class bu extends com.baidu.adp.base.f {
    private View.OnClickListener Hd;
    private TextView bwV;
    private PbActivity bxa;
    private TextView bxg;
    private ImageView bxh;
    private boolean bxi;
    private View mView;

    public boolean Xd() {
        return this.bxi;
    }

    public void ed(boolean z) {
        this.bxi = z;
    }

    public bu(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity);
        this.mView = null;
        this.bwV = null;
        this.bxg = null;
        this.bxh = null;
        this.bxa = null;
        this.Hd = null;
        this.bxi = true;
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

    public TextView Xe() {
        return this.bxg;
    }

    public ImageView Xf() {
        return this.bxh;
    }

    private void initUI() {
        this.mView = com.baidu.adp.lib.g.b.ek().inflate(this.bxa, com.baidu.tieba.w.pb_reply_view, null);
        this.bwV = (TextView) this.mView.findViewById(com.baidu.tieba.v.pb_reply_view_item_mark);
        this.bwV.setOnClickListener(this.Hd);
        this.bxg = (TextView) this.mView.findViewById(com.baidu.tieba.v.pb_reply_view_item_reply);
        this.bxg.setOnClickListener(this.Hd);
        this.bxh = (ImageView) this.mView.findViewById(com.baidu.tieba.v.pb_reply_view_item_manage);
        this.bxh.setOnClickListener(this.Hd);
    }
}
