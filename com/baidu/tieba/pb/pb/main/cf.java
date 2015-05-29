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
    private TextView bLT = null;
    private TextView bNe = null;
    private ImageView bNf = null;
    private ImageView bNg = null;
    private boolean bNh = true;

    public boolean abO() {
        return this.bNh;
    }

    public void ea(boolean z) {
        this.bNh = z;
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
        this.bNg.setVisibility(z ? 0 : 8);
    }

    public TextView abE() {
        return this.bLT;
    }

    public TextView abP() {
        return this.bNe;
    }

    public ImageView abQ() {
        return this.bNf;
    }

    public ImageView abR() {
        return this.bNg;
    }

    private void initUI() {
        this.mView = com.baidu.adp.lib.g.b.hr().inflate(this.Yt.getPageActivity(), com.baidu.tieba.r.pb_reply_view, null);
        this.bLT = (TextView) this.mView.findViewById(com.baidu.tieba.q.pb_reply_view_item_mark);
        this.bLT.setOnClickListener(this.mClickListener);
        this.bNe = (TextView) this.mView.findViewById(com.baidu.tieba.q.pb_reply_view_item_reply);
        this.bNe.setOnClickListener(this.mClickListener);
        this.bNf = (ImageView) this.mView.findViewById(com.baidu.tieba.q.pb_reply_view_item_manage);
        this.bNf.setOnClickListener(this.mClickListener);
        this.bNg = (ImageView) this.mView.findViewById(com.baidu.tieba.q.pb_reply_view_item_report);
        this.bNg.setOnClickListener(this.mClickListener);
    }
}
