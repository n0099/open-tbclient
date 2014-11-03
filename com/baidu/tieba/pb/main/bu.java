package com.baidu.tieba.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
/* loaded from: classes.dex */
public class bu extends com.baidu.adp.base.f {
    private View.OnClickListener He;
    private TextView bxj;
    private PbActivity bxo;
    private TextView bxu;
    private ImageView bxv;
    private boolean bxw;
    private View mView;

    public boolean Xg() {
        return this.bxw;
    }

    public void ed(boolean z) {
        this.bxw = z;
    }

    public bu(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity);
        this.mView = null;
        this.bxj = null;
        this.bxu = null;
        this.bxv = null;
        this.bxo = null;
        this.He = null;
        this.bxw = true;
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

    public TextView Xh() {
        return this.bxu;
    }

    public ImageView Xi() {
        return this.bxv;
    }

    private void initUI() {
        this.mView = com.baidu.adp.lib.g.b.ek().inflate(this.bxo, com.baidu.tieba.w.pb_reply_view, null);
        this.bxj = (TextView) this.mView.findViewById(com.baidu.tieba.v.pb_reply_view_item_mark);
        this.bxj.setOnClickListener(this.He);
        this.bxu = (TextView) this.mView.findViewById(com.baidu.tieba.v.pb_reply_view_item_reply);
        this.bxu.setOnClickListener(this.He);
        this.bxv = (ImageView) this.mView.findViewById(com.baidu.tieba.v.pb_reply_view_item_manage);
        this.bxv.setOnClickListener(this.He);
    }
}
