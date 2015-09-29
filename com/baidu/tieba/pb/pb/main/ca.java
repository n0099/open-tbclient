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
    private TbPageContext<?> aPb;
    private View.OnClickListener mClickListener;
    private View mView = null;
    private TextView cjF = null;
    private TextView cjV = null;
    private ImageView cjW = null;
    private ImageView cjX = null;
    private boolean cjY = true;

    public boolean agi() {
        return this.cjY;
    }

    public void eC(boolean z) {
        this.cjY = z;
    }

    public ca(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        this.aPb = null;
        this.mClickListener = null;
        this.aPb = tbPageContext;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public void eD(boolean z) {
        this.cjX.setVisibility(z ? 0 : 8);
    }

    public TextView afY() {
        return this.cjF;
    }

    public TextView agj() {
        return this.cjV;
    }

    public ImageView agk() {
        return this.cjW;
    }

    public ImageView agl() {
        return this.cjX;
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.aPb.getPageActivity()).inflate(i.g.pb_reply_view, (ViewGroup) null);
        this.cjF = (TextView) this.mView.findViewById(i.f.pb_reply_view_item_mark);
        this.cjF.setOnClickListener(this.mClickListener);
        this.cjV = (TextView) this.mView.findViewById(i.f.pb_reply_view_item_reply);
        this.cjV.setOnClickListener(this.mClickListener);
        this.cjW = (ImageView) this.mView.findViewById(i.f.pb_reply_view_item_manage);
        this.cjW.setOnClickListener(this.mClickListener);
        this.cjX = (ImageView) this.mView.findViewById(i.f.pb_reply_view_item_report);
        this.cjX.setOnClickListener(this.mClickListener);
    }
}
