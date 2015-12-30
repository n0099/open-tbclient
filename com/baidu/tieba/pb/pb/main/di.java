package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class di {
    private TbPageContext<?> aYy;
    private View.OnClickListener mClickListener;
    private View mView = null;
    private TextView cHA = null;
    private TextView cIe = null;
    private ImageView cIf = null;
    private ImageView cIg = null;
    private boolean cIh = true;

    public void fh(boolean z) {
        this.cIh = z;
    }

    public di(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        this.aYy = null;
        this.mClickListener = null;
        this.aYy = tbPageContext;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public void fg(boolean z) {
        this.cIg.setVisibility(z ? 0 : 8);
    }

    public TextView amf() {
        return this.cHA;
    }

    public TextView amu() {
        return this.cIe;
    }

    public ImageView amv() {
        return this.cIf;
    }

    public ImageView amw() {
        return this.cIg;
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.aYy.getPageActivity()).inflate(n.h.pb_reply_view, (ViewGroup) null);
        this.cHA = (TextView) this.mView.findViewById(n.g.pb_reply_view_item_mark);
        this.cHA.setOnClickListener(this.mClickListener);
        this.cIe = (TextView) this.mView.findViewById(n.g.pb_reply_view_item_reply);
        this.cIe.setOnClickListener(this.mClickListener);
        this.cIf = (ImageView) this.mView.findViewById(n.g.pb_reply_view_item_manage);
        this.cIf.setOnClickListener(this.mClickListener);
        this.cIg = (ImageView) this.mView.findViewById(n.g.pb_reply_view_item_report);
        this.cIg.setOnClickListener(this.mClickListener);
    }
}
