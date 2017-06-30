package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
/* loaded from: classes.dex */
public class ei {
    private TbPageContext ajP;
    private RelativeLayout bSW;
    private com.baidu.tbadk.editortools.pb.n eyi;
    private PbFakeFloorModel eyj;

    public ei(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.ajP = tbPageContext;
        this.bSW = relativeLayout;
        this.eyj = pbFakeFloorModel;
    }

    public void aOB() {
        if (this.eyi != null) {
            this.eyi.DE();
        }
    }

    private void aOC() {
        if (this.bSW != null && this.eyi == null) {
            this.eyi = (com.baidu.tbadk.editortools.pb.n) new com.baidu.tbadk.editortools.pb.r().aQ(this.ajP.getPageActivity());
            this.eyi.a(this.ajP);
            this.eyi.b(this.eyj);
            this.eyi.CG().bB(true);
            this.eyi.f(this.ajP);
            aOD();
        }
    }

    public void bK(String str, String str2) {
        aOC();
        this.eyi.setReplyId(str);
        this.eyi.fW(str2);
    }

    private void aOD() {
        if (this.bSW != null && this.eyi != null && this.eyi.CG() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bSW.addView(this.eyi.CG(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eyi != null) {
            this.eyi.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.eyi != null) {
            this.eyi.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eyi != null && this.eyi.CG() != null) {
            this.eyi.CG().onChangeSkinType(i);
        }
    }
}
