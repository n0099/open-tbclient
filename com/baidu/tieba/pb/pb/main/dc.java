package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
/* loaded from: classes.dex */
public class dc {
    private TbPageContext ajT;
    private RelativeLayout dTF;
    private com.baidu.tbadk.editortools.pb.n ekZ;
    private PbFakeFloorModel ela;

    public dc(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.ajT = tbPageContext;
        this.dTF = relativeLayout;
        this.ela = pbFakeFloorModel;
    }

    public void aLk() {
        if (this.ekZ != null) {
            this.ekZ.Em();
        }
    }

    private void aLl() {
        if (this.dTF != null && this.ekZ == null) {
            this.ekZ = (com.baidu.tbadk.editortools.pb.n) new com.baidu.tbadk.editortools.pb.r().aN(this.ajT.getPageActivity());
            this.ekZ.a(this.ajT);
            this.ekZ.b(this.ela);
            this.ekZ.Dn().bD(true);
            this.ekZ.f(this.ajT);
            aLm();
        }
    }

    public void bL(String str, String str2) {
        aLl();
        this.ekZ.setReplyId(str);
        this.ekZ.fH(str2);
    }

    private void aLm() {
        if (this.dTF != null && this.ekZ != null && this.ekZ.Dn() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.dTF.addView(this.ekZ.Dn(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.ekZ != null) {
            this.ekZ.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.ekZ != null) {
            this.ekZ.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ekZ != null && this.ekZ.Dn() != null) {
            this.ekZ.Dn().onChangeSkinType(i);
        }
    }
}
