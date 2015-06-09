package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class cf {
    private TbPageContext<?> Yt;
    private View.OnClickListener mClickListener;
    private View mView = null;
    private TextView bLU = null;
    private TextView bNf = null;
    private ImageView bNg = null;
    private ImageView bNh = null;
    private boolean bNi = true;

    public boolean abP() {
        return this.bNi;
    }

    public void ea(boolean z) {
        this.bNi = z;
    }

    public cf(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        this.Yt = null;
        this.mClickListener = null;
        this.Yt = tbPageContext;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public void eb(boolean z) {
        this.bNh.setVisibility(z ? 0 : 8);
    }

    public TextView abF() {
        return this.bLU;
    }

    public TextView abQ() {
        return this.bNf;
    }

    public ImageView abR() {
        return this.bNg;
    }

    public ImageView abS() {
        return this.bNh;
    }

    private void initUI() {
        this.mView = com.baidu.adp.lib.g.b.hr().inflate(this.Yt.getPageActivity(), com.baidu.tieba.r.pb_reply_view, null);
        this.bLU = (TextView) this.mView.findViewById(com.baidu.tieba.q.pb_reply_view_item_mark);
        this.bLU.setOnClickListener(this.mClickListener);
        this.bNf = (TextView) this.mView.findViewById(com.baidu.tieba.q.pb_reply_view_item_reply);
        this.bNf.setOnClickListener(this.mClickListener);
        this.bNg = (ImageView) this.mView.findViewById(com.baidu.tieba.q.pb_reply_view_item_manage);
        this.bNg.setOnClickListener(this.mClickListener);
        this.bNh = (ImageView) this.mView.findViewById(com.baidu.tieba.q.pb_reply_view_item_report);
        this.bNh.setOnClickListener(this.mClickListener);
    }
}
