package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ca {
    private TbPageContext<?> aPm;
    private View.OnClickListener mClickListener;
    private View mView = null;
    private TextView cjQ = null;
    private TextView ckg = null;
    private ImageView ckh = null;
    private ImageView cki = null;
    private boolean ckj = true;

    public boolean agi() {
        return this.ckj;
    }

    public void eC(boolean z) {
        this.ckj = z;
    }

    public ca(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        this.aPm = null;
        this.mClickListener = null;
        this.aPm = tbPageContext;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public void eD(boolean z) {
        this.cki.setVisibility(z ? 0 : 8);
    }

    public TextView afY() {
        return this.cjQ;
    }

    public TextView agj() {
        return this.ckg;
    }

    public ImageView agk() {
        return this.ckh;
    }

    public ImageView agl() {
        return this.cki;
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.aPm.getPageActivity()).inflate(i.g.pb_reply_view, (ViewGroup) null);
        this.cjQ = (TextView) this.mView.findViewById(i.f.pb_reply_view_item_mark);
        this.cjQ.setOnClickListener(this.mClickListener);
        this.ckg = (TextView) this.mView.findViewById(i.f.pb_reply_view_item_reply);
        this.ckg.setOnClickListener(this.mClickListener);
        this.ckh = (ImageView) this.mView.findViewById(i.f.pb_reply_view_item_manage);
        this.ckh.setOnClickListener(this.mClickListener);
        this.cki = (ImageView) this.mView.findViewById(i.f.pb_reply_view_item_report);
        this.cki.setOnClickListener(this.mClickListener);
    }
}
