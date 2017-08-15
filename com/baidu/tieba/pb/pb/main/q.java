package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
/* loaded from: classes.dex */
public class q {
    private RelativeLayout bZc;
    private PbFakeFloorModel eMA;
    private com.baidu.tbadk.editortools.pb.e eMz;
    private TbPageContext oV;

    public q(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.oV = tbPageContext;
        this.bZc = relativeLayout;
        this.eMA = pbFakeFloorModel;
    }

    public void aRW() {
        if (this.eMz != null) {
            this.eMz.DY();
        }
    }

    private void aRX() {
        if (this.bZc != null && this.eMz == null) {
            this.eMz = (com.baidu.tbadk.editortools.pb.e) new com.baidu.tbadk.editortools.pb.f().aR(this.oV.getPageActivity());
            this.eMz.a(this.oV);
            this.eMz.b(this.eMA);
            this.eMz.Da().bE(true);
            this.eMz.g(this.oV);
            aRY();
        }
    }

    public void bM(String str, String str2) {
        aRX();
        this.eMz.setReplyId(str);
        this.eMz.gg(str2);
    }

    private void aRY() {
        if (this.bZc != null && this.eMz != null && this.eMz.Da() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bZc.addView(this.eMz.Da(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eMz != null) {
            this.eMz.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.eMz != null) {
            this.eMz.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eMz != null && this.eMz.Da() != null) {
            this.eMz.Da().onChangeSkinType(i);
        }
    }
}
