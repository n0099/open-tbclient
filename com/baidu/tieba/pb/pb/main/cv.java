package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class cv extends com.baidu.adp.base.f<PbActivity> {
    private View.OnClickListener OS;
    private TextView cPi;
    private TextView cPq;
    private View cPr;
    private TextView cPs;
    private TextView cPt;
    private TextView cPu;
    private View cPv;
    private TextView cPw;
    private View cPx;
    private PbActivity cPy;
    private View mView;

    public cv(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.cPi = null;
        this.cPq = null;
        this.cPr = null;
        this.cPs = null;
        this.cPt = null;
        this.cPu = null;
        this.cPv = null;
        this.cPw = null;
        this.cPx = null;
        this.cPy = null;
        this.OS = null;
        this.cPy = pbActivity;
        this.OS = onClickListener;
        qD();
    }

    public View getView() {
        return this.mView;
    }

    public TextView aql() {
        return this.cPi;
    }

    public TextView aqu() {
        return this.cPq;
    }

    public View aqv() {
        return this.cPr;
    }

    public TextView aqw() {
        return this.cPs;
    }

    public TextView aqx() {
        return this.cPt;
    }

    public TextView aqy() {
        return this.cPw;
    }

    public TextView aqz() {
        return this.cPu;
    }

    public void fx(boolean z) {
        if (z) {
            this.cPw.setVisibility(8);
            this.cPx.setVisibility(8);
            return;
        }
        this.cPw.setVisibility(0);
        this.cPx.setVisibility(0);
    }

    public void fy(boolean z) {
        if (z) {
            this.cPu.setVisibility(8);
            this.cPv.setVisibility(8);
            return;
        }
        this.cPu.setVisibility(0);
        this.cPv.setVisibility(0);
    }

    private void qD() {
        this.mView = LayoutInflater.from(this.cPy.getPageContext().getPageActivity()).inflate(t.h.pb_more_view, (ViewGroup) null);
        this.cPi = (TextView) this.mView.findViewById(t.g.pb_more_view_item_mark);
        this.cPi.setOnClickListener(this.OS);
        this.cPq = (TextView) this.mView.findViewById(t.g.pb_more_view_item_share);
        this.cPr = this.mView.findViewById(t.g.pb_more_view_item_line_share);
        this.cPq.setOnClickListener(this.OS);
        this.cPs = (TextView) this.mView.findViewById(t.g.pb_more_view_item_jump);
        this.cPs.setOnClickListener(this.OS);
        this.cPt = (TextView) this.mView.findViewById(t.g.pb_more_view_item_see);
        this.cPt.setOnClickListener(this.OS);
        this.cPw = (TextView) this.mView.findViewById(t.g.pb_more_view_item_report);
        this.cPw.setOnClickListener(this.OS);
        this.cPx = this.mView.findViewById(t.g.pb_more_view_item_report_line);
        this.cPu = (TextView) this.mView.findViewById(t.g.pb_more_view_item_upgrade_thread);
        this.cPv = this.mView.findViewById(t.g.pb_more_view_item_upgrade_line);
        this.cPu.setOnClickListener(this.OS);
    }
}
