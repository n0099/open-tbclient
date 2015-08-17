package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class bz {
    private TbPageContext<?> adr;
    private View.OnClickListener mClickListener;
    private View mView = null;
    private TextView ccu = null;
    private TextView cdH = null;
    private ImageView cdI = null;
    private ImageView cdJ = null;
    private boolean cdK = true;

    public boolean adW() {
        return this.cdK;
    }

    public void ep(boolean z) {
        this.cdK = z;
    }

    public bz(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        this.adr = null;
        this.mClickListener = null;
        this.adr = tbPageContext;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public void eq(boolean z) {
        this.cdJ.setVisibility(z ? 0 : 8);
    }

    public TextView adM() {
        return this.ccu;
    }

    public TextView adX() {
        return this.cdH;
    }

    public ImageView adY() {
        return this.cdI;
    }

    public ImageView adZ() {
        return this.cdJ;
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.adr.getPageActivity()).inflate(i.g.pb_reply_view, (ViewGroup) null);
        this.ccu = (TextView) this.mView.findViewById(i.f.pb_reply_view_item_mark);
        this.ccu.setOnClickListener(this.mClickListener);
        this.cdH = (TextView) this.mView.findViewById(i.f.pb_reply_view_item_reply);
        this.cdH.setOnClickListener(this.mClickListener);
        this.cdI = (ImageView) this.mView.findViewById(i.f.pb_reply_view_item_manage);
        this.cdI.setOnClickListener(this.mClickListener);
        this.cdJ = (ImageView) this.mView.findViewById(i.f.pb_reply_view_item_report);
        this.cdJ.setOnClickListener(this.mClickListener);
    }
}
