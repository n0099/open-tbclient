package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
/* loaded from: classes.dex */
public class q {
    private RelativeLayout cca;
    private com.baidu.tbadk.editortools.pb.e eKS;
    private PbFakeFloorModel eKT;
    private TbPageContext mF;

    public q(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mF = tbPageContext;
        this.cca = relativeLayout;
        this.eKT = pbFakeFloorModel;
    }

    public void aRi() {
        if (this.eKS != null) {
            this.eKS.DT();
        }
    }

    private void aRj() {
        if (this.cca != null && this.eKS == null) {
            this.eKS = (com.baidu.tbadk.editortools.pb.e) new com.baidu.tbadk.editortools.pb.f().aW(this.mF.getPageActivity());
            this.eKS.a(this.mF);
            this.eKS.b(this.eKT);
            this.eKS.CV().bD(true);
            this.eKS.g(this.mF);
            aRk();
        }
    }

    public void bN(String str, String str2) {
        aRj();
        this.eKS.setReplyId(str);
        this.eKS.ge(str2);
    }

    private void aRk() {
        if (this.cca != null && this.eKS != null && this.eKS.CV() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.cca.addView(this.eKS.CV(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eKS != null) {
            this.eKS.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.eKS != null) {
            this.eKS.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eKS != null && this.eKS.CV() != null) {
            this.eKS.CV().onChangeSkinType(i);
        }
    }
}
