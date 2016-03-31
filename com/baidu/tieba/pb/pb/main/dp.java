package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class dp extends com.baidu.adp.base.f<PbActivity> {
    private View.OnClickListener OZ;
    private PbActivity dfA;
    private TextView djH;
    private View djI;
    private TextView djJ;
    private TextView djK;
    private TextView djL;
    private View djM;
    private TextView djN;
    private View djO;
    private TextView djz;
    private View mView;

    public dp(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.djz = null;
        this.djH = null;
        this.djI = null;
        this.djJ = null;
        this.djK = null;
        this.djL = null;
        this.djM = null;
        this.djN = null;
        this.djO = null;
        this.dfA = null;
        this.OZ = null;
        this.dfA = pbActivity;
        this.OZ = onClickListener;
        pU();
    }

    public View getView() {
        return this.mView;
    }

    public TextView axB() {
        return this.djz;
    }

    public TextView axK() {
        return this.djH;
    }

    public View axL() {
        return this.djI;
    }

    public TextView axM() {
        return this.djJ;
    }

    public TextView axN() {
        return this.djK;
    }

    public TextView axO() {
        return this.djN;
    }

    public TextView axP() {
        return this.djL;
    }

    public void gh(boolean z) {
        if (z) {
            this.djN.setVisibility(8);
            this.djO.setVisibility(8);
            return;
        }
        this.djN.setVisibility(0);
        this.djO.setVisibility(0);
    }

    public void gi(boolean z) {
        if (z) {
            this.djL.setVisibility(8);
            this.djM.setVisibility(8);
            return;
        }
        this.djL.setVisibility(0);
        this.djM.setVisibility(0);
    }

    private void pU() {
        this.mView = LayoutInflater.from(this.dfA.getPageContext().getPageActivity()).inflate(t.h.pb_more_view, (ViewGroup) null);
        this.djz = (TextView) this.mView.findViewById(t.g.pb_more_view_item_mark);
        this.djz.setOnClickListener(this.OZ);
        this.djH = (TextView) this.mView.findViewById(t.g.pb_more_view_item_share);
        this.djI = this.mView.findViewById(t.g.pb_more_view_item_line_share);
        this.djH.setOnClickListener(this.OZ);
        this.djJ = (TextView) this.mView.findViewById(t.g.pb_more_view_item_jump);
        this.djJ.setOnClickListener(this.OZ);
        this.djK = (TextView) this.mView.findViewById(t.g.pb_more_view_item_see);
        this.djK.setOnClickListener(this.OZ);
        this.djN = (TextView) this.mView.findViewById(t.g.pb_more_view_item_report);
        this.djN.setOnClickListener(this.OZ);
        this.djO = this.mView.findViewById(t.g.pb_more_view_item_report_line);
        this.djL = (TextView) this.mView.findViewById(t.g.pb_more_view_item_upgrade_thread);
        this.djM = this.mView.findViewById(t.g.pb_more_view_item_upgrade_line);
        this.djL.setOnClickListener(this.OZ);
    }
}
