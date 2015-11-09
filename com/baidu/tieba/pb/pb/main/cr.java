package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class cr {
    private TbPageContext<?> aPu;
    private View.OnClickListener mClickListener;
    private View mView = null;
    private TextView cld = null;
    private TextView clt = null;
    private ImageView clu = null;
    private ImageView clv = null;
    private boolean clw = true;

    public boolean agJ() {
        return this.clw;
    }

    public void eF(boolean z) {
        this.clw = z;
    }

    public cr(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        this.aPu = null;
        this.mClickListener = null;
        this.aPu = tbPageContext;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public void eG(boolean z) {
        this.clv.setVisibility(z ? 0 : 8);
    }

    public TextView agz() {
        return this.cld;
    }

    public TextView agK() {
        return this.clt;
    }

    public ImageView agL() {
        return this.clu;
    }

    public ImageView agM() {
        return this.clv;
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.aPu.getPageActivity()).inflate(i.g.pb_reply_view, (ViewGroup) null);
        this.cld = (TextView) this.mView.findViewById(i.f.pb_reply_view_item_mark);
        this.cld.setOnClickListener(this.mClickListener);
        this.clt = (TextView) this.mView.findViewById(i.f.pb_reply_view_item_reply);
        this.clt.setOnClickListener(this.mClickListener);
        this.clu = (ImageView) this.mView.findViewById(i.f.pb_reply_view_item_manage);
        this.clu.setOnClickListener(this.mClickListener);
        this.clv = (ImageView) this.mView.findViewById(i.f.pb_reply_view_item_report);
        this.clv.setOnClickListener(this.mClickListener);
    }
}
