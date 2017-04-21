package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
/* loaded from: classes.dex */
public class dc {
    private TbPageContext ajU;
    private RelativeLayout dVV;
    private com.baidu.tbadk.editortools.pb.n enr;
    private PbFakeFloorModel ens;

    public dc(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.ajU = tbPageContext;
        this.dVV = relativeLayout;
        this.ens = pbFakeFloorModel;
    }

    public void aMl() {
        if (this.enr != null) {
            this.enr.Em();
        }
    }

    private void aMm() {
        if (this.dVV != null && this.enr == null) {
            this.enr = (com.baidu.tbadk.editortools.pb.n) new com.baidu.tbadk.editortools.pb.r().aN(this.ajU.getPageActivity());
            this.enr.a(this.ajU);
            this.enr.b(this.ens);
            this.enr.Dn().bD(true);
            this.enr.f(this.ajU);
            aMn();
        }
    }

    public void bK(String str, String str2) {
        aMm();
        this.enr.setReplyId(str);
        this.enr.fH(str2);
    }

    private void aMn() {
        if (this.dVV != null && this.enr != null && this.enr.Dn() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.dVV.addView(this.enr.Dn(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.enr != null) {
            this.enr.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.enr != null) {
            this.enr.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.enr != null && this.enr.Dn() != null) {
            this.enr.Dn().onChangeSkinType(i);
        }
    }
}
