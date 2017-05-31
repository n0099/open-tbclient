package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
/* loaded from: classes.dex */
public class dz {
    private TbPageContext ajh;
    private RelativeLayout bMv;
    private com.baidu.tbadk.editortools.pb.n eoZ;
    private PbFakeFloorModel epa;

    public dz(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.ajh = tbPageContext;
        this.bMv = relativeLayout;
        this.epa = pbFakeFloorModel;
    }

    public void aKE() {
        if (this.eoZ != null) {
            this.eoZ.Dk();
        }
    }

    private void aKF() {
        if (this.bMv != null && this.eoZ == null) {
            this.eoZ = (com.baidu.tbadk.editortools.pb.n) new com.baidu.tbadk.editortools.pb.r().aQ(this.ajh.getPageActivity());
            this.eoZ.a(this.ajh);
            this.eoZ.b(this.epa);
            this.eoZ.Cm().bA(true);
            this.eoZ.f(this.ajh);
            aKG();
        }
    }

    public void bH(String str, String str2) {
        aKF();
        this.eoZ.setReplyId(str);
        this.eoZ.fC(str2);
    }

    private void aKG() {
        if (this.bMv != null && this.eoZ != null && this.eoZ.Cm() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bMv.addView(this.eoZ.Cm(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eoZ != null) {
            this.eoZ.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.eoZ != null) {
            this.eoZ.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eoZ != null && this.eoZ.Cm() != null) {
            this.eoZ.Cm().onChangeSkinType(i);
        }
    }
}
