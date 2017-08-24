package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
/* loaded from: classes.dex */
public class q {
    private RelativeLayout bZd;
    private com.baidu.tbadk.editortools.pb.e eMB;
    private PbFakeFloorModel eMC;
    private TbPageContext oW;

    public q(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.oW = tbPageContext;
        this.bZd = relativeLayout;
        this.eMC = pbFakeFloorModel;
    }

    public void aRR() {
        if (this.eMB != null) {
            this.eMB.DY();
        }
    }

    private void aRS() {
        if (this.bZd != null && this.eMB == null) {
            this.eMB = (com.baidu.tbadk.editortools.pb.e) new com.baidu.tbadk.editortools.pb.f().aR(this.oW.getPageActivity());
            this.eMB.a(this.oW);
            this.eMB.b(this.eMC);
            this.eMB.Da().bE(true);
            this.eMB.g(this.oW);
            aRT();
        }
    }

    public void bN(String str, String str2) {
        aRS();
        this.eMB.setReplyId(str);
        this.eMB.gk(str2);
    }

    private void aRT() {
        if (this.bZd != null && this.eMB != null && this.eMB.Da() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bZd.addView(this.eMB.Da(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eMB != null) {
            this.eMB.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.eMB != null) {
            this.eMB.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eMB != null && this.eMB.Da() != null) {
            this.eMB.Da().onChangeSkinType(i);
        }
    }
}
