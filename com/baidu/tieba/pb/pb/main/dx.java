package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class dx {
    private View.OnClickListener OS;
    private TbPageContext<?> baN;
    private View mView = null;
    private TextView cPi = null;
    private TextView cQg = null;
    private ImageView cQh = null;
    private ImageView cQi = null;
    private boolean cQj = true;

    public void fw(boolean z) {
        this.cQj = z;
    }

    public dx(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        this.baN = null;
        this.OS = null;
        this.baN = tbPageContext;
        this.OS = onClickListener;
        qD();
    }

    public View getView() {
        return this.mView;
    }

    public void fv(boolean z) {
        this.cQi.setVisibility(z ? 0 : 8);
    }

    public TextView aql() {
        return this.cPi;
    }

    public TextView aqO() {
        return this.cQg;
    }

    public ImageView aqP() {
        return this.cQh;
    }

    public ImageView aqQ() {
        return this.cQi;
    }

    private void qD() {
        this.mView = LayoutInflater.from(this.baN.getPageActivity()).inflate(t.h.pb_reply_view, (ViewGroup) null);
        this.cPi = (TextView) this.mView.findViewById(t.g.pb_reply_view_item_mark);
        this.cPi.setOnClickListener(this.OS);
        this.cQg = (TextView) this.mView.findViewById(t.g.pb_reply_view_item_reply);
        this.cQg.setOnClickListener(this.OS);
        this.cQh = (ImageView) this.mView.findViewById(t.g.pb_reply_view_item_manage);
        this.cQh.setOnClickListener(this.OS);
        this.cQi = (ImageView) this.mView.findViewById(t.g.pb_reply_view_item_report);
        this.cQi.setOnClickListener(this.OS);
    }
}
