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
    private TbPageContext<?> adB;
    private View.OnClickListener mClickListener;
    private View mView = null;
    private TextView cdr = null;
    private TextView ceE = null;
    private ImageView ceF = null;
    private ImageView ceG = null;
    private boolean ceH = true;

    public boolean aek() {
        return this.ceH;
    }

    public void ex(boolean z) {
        this.ceH = z;
    }

    public bz(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        this.adB = null;
        this.mClickListener = null;
        this.adB = tbPageContext;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public void ey(boolean z) {
        this.ceG.setVisibility(z ? 0 : 8);
    }

    public TextView aea() {
        return this.cdr;
    }

    public TextView ael() {
        return this.ceE;
    }

    public ImageView aem() {
        return this.ceF;
    }

    public ImageView aen() {
        return this.ceG;
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.adB.getPageActivity()).inflate(i.g.pb_reply_view, (ViewGroup) null);
        this.cdr = (TextView) this.mView.findViewById(i.f.pb_reply_view_item_mark);
        this.cdr.setOnClickListener(this.mClickListener);
        this.ceE = (TextView) this.mView.findViewById(i.f.pb_reply_view_item_reply);
        this.ceE.setOnClickListener(this.mClickListener);
        this.ceF = (ImageView) this.mView.findViewById(i.f.pb_reply_view_item_manage);
        this.ceF.setOnClickListener(this.mClickListener);
        this.ceG = (ImageView) this.mView.findViewById(i.f.pb_reply_view_item_report);
        this.ceG.setOnClickListener(this.mClickListener);
    }
}
