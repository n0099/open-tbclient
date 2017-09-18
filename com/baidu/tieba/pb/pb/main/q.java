package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
/* loaded from: classes.dex */
public class q {
    private RelativeLayout ccS;
    private com.baidu.tbadk.editortools.pb.e eLM;
    private PbFakeFloorModel eLN;
    private TbPageContext mF;

    public q(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.mF = tbPageContext;
        this.ccS = relativeLayout;
        this.eLN = pbFakeFloorModel;
    }

    public void aRt() {
        if (this.eLM != null) {
            this.eLM.DT();
        }
    }

    private void aRu() {
        if (this.ccS != null && this.eLM == null) {
            this.eLM = (com.baidu.tbadk.editortools.pb.e) new com.baidu.tbadk.editortools.pb.f().aX(this.mF.getPageActivity());
            this.eLM.a(this.mF);
            this.eLM.b(this.eLN);
            this.eLM.CV().bD(true);
            this.eLM.g(this.mF);
            aRv();
        }
    }

    public void bN(String str, String str2) {
        aRu();
        this.eLM.setReplyId(str);
        this.eLM.ge(str2);
    }

    private void aRv() {
        if (this.ccS != null && this.eLM != null && this.eLM.CV() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.ccS.addView(this.eLM.CV(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eLM != null) {
            this.eLM.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.eLM != null) {
            this.eLM.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eLM != null && this.eLM.CV() != null) {
            this.eLM.CV().onChangeSkinType(i);
        }
    }
}
