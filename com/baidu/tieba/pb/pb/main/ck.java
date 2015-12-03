package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class ck extends com.baidu.adp.base.f<PbActivity> {
    private TextView cDH;
    private TextView cDN;
    private View cDO;
    private TextView cDP;
    private TextView cDQ;
    private TextView cDR;
    private View cDS;
    private TextView cDT;
    private View cDU;
    private PbActivity cDV;
    private View.OnClickListener mClickListener;
    private View mView;

    public ck(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.cDH = null;
        this.cDN = null;
        this.cDO = null;
        this.cDP = null;
        this.cDQ = null;
        this.cDR = null;
        this.cDS = null;
        this.cDT = null;
        this.cDU = null;
        this.cDV = null;
        this.mClickListener = null;
        this.cDV = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView akU() {
        return this.cDH;
    }

    public TextView akY() {
        return this.cDN;
    }

    public View akZ() {
        return this.cDO;
    }

    public TextView ala() {
        return this.cDP;
    }

    public TextView alb() {
        return this.cDQ;
    }

    public TextView alc() {
        return this.cDT;
    }

    public TextView ald() {
        return this.cDR;
    }

    public void fj(boolean z) {
        if (z) {
            this.cDT.setVisibility(8);
            this.cDU.setVisibility(8);
            return;
        }
        this.cDT.setVisibility(0);
        this.cDU.setVisibility(0);
    }

    public void fk(boolean z) {
        if (z) {
            this.cDR.setVisibility(8);
            this.cDS.setVisibility(8);
            return;
        }
        this.cDR.setVisibility(0);
        this.cDS.setVisibility(0);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.cDV.getPageContext().getPageActivity()).inflate(n.g.pb_more_view, (ViewGroup) null);
        this.cDH = (TextView) this.mView.findViewById(n.f.pb_more_view_item_mark);
        this.cDH.setOnClickListener(this.mClickListener);
        this.cDN = (TextView) this.mView.findViewById(n.f.pb_more_view_item_share);
        this.cDO = this.mView.findViewById(n.f.pb_more_view_item_line_share);
        this.cDN.setOnClickListener(this.mClickListener);
        this.cDP = (TextView) this.mView.findViewById(n.f.pb_more_view_item_jump);
        this.cDP.setOnClickListener(this.mClickListener);
        this.cDQ = (TextView) this.mView.findViewById(n.f.pb_more_view_item_see);
        this.cDQ.setOnClickListener(this.mClickListener);
        this.cDT = (TextView) this.mView.findViewById(n.f.pb_more_view_item_report);
        this.cDT.setOnClickListener(this.mClickListener);
        this.cDU = this.mView.findViewById(n.f.pb_more_view_item_report_line);
        this.cDR = (TextView) this.mView.findViewById(n.f.pb_more_view_item_upgrade_thread);
        this.cDS = this.mView.findViewById(n.f.pb_more_view_item_upgrade_line);
        this.cDR.setOnClickListener(this.mClickListener);
    }
}
