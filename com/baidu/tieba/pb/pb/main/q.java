package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
/* loaded from: classes.dex */
public class q {
    private TbPageContext alI;
    private RelativeLayout bYq;
    private com.baidu.tbadk.editortools.pb.e eKF;
    private PbFakeFloorModel eKG;

    public q(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.alI = tbPageContext;
        this.bYq = relativeLayout;
        this.eKG = pbFakeFloorModel;
    }

    public void aRp() {
        if (this.eKF != null) {
            this.eKF.DY();
        }
    }

    private void aRq() {
        if (this.bYq != null && this.eKF == null) {
            this.eKF = (com.baidu.tbadk.editortools.pb.e) new com.baidu.tbadk.editortools.pb.f().aR(this.alI.getPageActivity());
            this.eKF.a(this.alI);
            this.eKF.b(this.eKG);
            this.eKF.Da().bE(true);
            this.eKF.g(this.alI);
            aRr();
        }
    }

    public void bL(String str, String str2) {
        aRq();
        this.eKF.setReplyId(str);
        this.eKF.gg(str2);
    }

    private void aRr() {
        if (this.bYq != null && this.eKF != null && this.eKF.Da() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bYq.addView(this.eKF.Da(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eKF != null) {
            this.eKF.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.eKF != null) {
            this.eKF.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eKF != null && this.eKF.Da() != null) {
            this.eKF.Da().onChangeSkinType(i);
        }
    }
}
