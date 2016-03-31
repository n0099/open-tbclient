package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class es {
    private View.OnClickListener OZ;
    private TbPageContext<?> bfx;
    private View mView = null;
    private TextView djz = null;
    private TextView dkx = null;
    private ImageView dky = null;
    private ImageView dkz = null;
    private boolean dkA = true;

    public void gg(boolean z) {
        this.dkA = z;
    }

    public es(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        this.bfx = null;
        this.OZ = null;
        this.bfx = tbPageContext;
        this.OZ = onClickListener;
        pU();
    }

    public View getView() {
        return this.mView;
    }

    public void gf(boolean z) {
        this.dkz.setVisibility(z ? 0 : 8);
    }

    public TextView axB() {
        return this.djz;
    }

    public TextView aye() {
        return this.dkx;
    }

    public ImageView ayf() {
        return this.dky;
    }

    public ImageView ayg() {
        return this.dkz;
    }

    private void pU() {
        this.mView = LayoutInflater.from(this.bfx.getPageActivity()).inflate(t.h.pb_reply_view, (ViewGroup) null);
        this.djz = (TextView) this.mView.findViewById(t.g.pb_reply_view_item_mark);
        this.djz.setOnClickListener(this.OZ);
        this.dkx = (TextView) this.mView.findViewById(t.g.pb_reply_view_item_reply);
        this.dkx.setOnClickListener(this.OZ);
        this.dky = (ImageView) this.mView.findViewById(t.g.pb_reply_view_item_manage);
        this.dky.setOnClickListener(this.OZ);
        this.dkz = (ImageView) this.mView.findViewById(t.g.pb_reply_view_item_report);
        this.dkz.setOnClickListener(this.OZ);
    }
}
