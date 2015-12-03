package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class cy {
    private TbPageContext<?> aUx;
    private View.OnClickListener mClickListener;
    private View mView = null;
    private TextView cDH = null;
    private TextView cEf = null;
    private ImageView cEg = null;
    private ImageView cEh = null;
    private boolean cEi = true;

    public void fi(boolean z) {
        this.cEi = z;
    }

    public cy(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        this.aUx = null;
        this.mClickListener = null;
        this.aUx = tbPageContext;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public void fh(boolean z) {
        this.cEh.setVisibility(z ? 0 : 8);
    }

    public TextView akU() {
        return this.cDH;
    }

    public TextView ali() {
        return this.cEf;
    }

    public ImageView alj() {
        return this.cEg;
    }

    public ImageView alk() {
        return this.cEh;
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.aUx.getPageActivity()).inflate(n.g.pb_reply_view, (ViewGroup) null);
        this.cDH = (TextView) this.mView.findViewById(n.f.pb_reply_view_item_mark);
        this.cDH.setOnClickListener(this.mClickListener);
        this.cEf = (TextView) this.mView.findViewById(n.f.pb_reply_view_item_reply);
        this.cEf.setOnClickListener(this.mClickListener);
        this.cEg = (ImageView) this.mView.findViewById(n.f.pb_reply_view_item_manage);
        this.cEg.setOnClickListener(this.mClickListener);
        this.cEh = (ImageView) this.mView.findViewById(n.f.pb_reply_view_item_report);
        this.cEh.setOnClickListener(this.mClickListener);
    }
}
