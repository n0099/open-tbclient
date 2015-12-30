package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class co extends com.baidu.adp.base.f<PbActivity> {
    private TextView cHA;
    private TextView cHH;
    private View cHI;
    private TextView cHJ;
    private TextView cHK;
    private TextView cHL;
    private View cHM;
    private TextView cHN;
    private View cHO;
    private PbActivity cHP;
    private View.OnClickListener mClickListener;
    private View mView;

    public co(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.cHA = null;
        this.cHH = null;
        this.cHI = null;
        this.cHJ = null;
        this.cHK = null;
        this.cHL = null;
        this.cHM = null;
        this.cHN = null;
        this.cHO = null;
        this.cHP = null;
        this.mClickListener = null;
        this.cHP = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView amf() {
        return this.cHA;
    }

    public TextView amk() {
        return this.cHH;
    }

    public View aml() {
        return this.cHI;
    }

    public TextView amm() {
        return this.cHJ;
    }

    public TextView amn() {
        return this.cHK;
    }

    public TextView amo() {
        return this.cHN;
    }

    public TextView amp() {
        return this.cHL;
    }

    public void fi(boolean z) {
        if (z) {
            this.cHN.setVisibility(8);
            this.cHO.setVisibility(8);
            return;
        }
        this.cHN.setVisibility(0);
        this.cHO.setVisibility(0);
    }

    public void fj(boolean z) {
        if (z) {
            this.cHL.setVisibility(8);
            this.cHM.setVisibility(8);
            return;
        }
        this.cHL.setVisibility(0);
        this.cHM.setVisibility(0);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.cHP.getPageContext().getPageActivity()).inflate(n.h.pb_more_view, (ViewGroup) null);
        this.cHA = (TextView) this.mView.findViewById(n.g.pb_more_view_item_mark);
        this.cHA.setOnClickListener(this.mClickListener);
        this.cHH = (TextView) this.mView.findViewById(n.g.pb_more_view_item_share);
        this.cHI = this.mView.findViewById(n.g.pb_more_view_item_line_share);
        this.cHH.setOnClickListener(this.mClickListener);
        this.cHJ = (TextView) this.mView.findViewById(n.g.pb_more_view_item_jump);
        this.cHJ.setOnClickListener(this.mClickListener);
        this.cHK = (TextView) this.mView.findViewById(n.g.pb_more_view_item_see);
        this.cHK.setOnClickListener(this.mClickListener);
        this.cHN = (TextView) this.mView.findViewById(n.g.pb_more_view_item_report);
        this.cHN.setOnClickListener(this.mClickListener);
        this.cHO = this.mView.findViewById(n.g.pb_more_view_item_report_line);
        this.cHL = (TextView) this.mView.findViewById(n.g.pb_more_view_item_upgrade_thread);
        this.cHM = this.mView.findViewById(n.g.pb_more_view_item_upgrade_line);
        this.cHL.setOnClickListener(this.mClickListener);
    }
}
