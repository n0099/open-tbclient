package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
/* loaded from: classes.dex */
public class de {
    private TbPageContext ajF;
    private RelativeLayout dWm;
    private com.baidu.tbadk.editortools.pb.n emR;
    private PbFakeFloorModel emS;

    public de(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.ajF = tbPageContext;
        this.dWm = relativeLayout;
        this.emS = pbFakeFloorModel;
    }

    public void aLc() {
        if (this.emR != null) {
            this.emR.DO();
        }
    }

    private void aLd() {
        if (this.dWm != null && this.emR == null) {
            this.emR = (com.baidu.tbadk.editortools.pb.n) new com.baidu.tbadk.editortools.pb.r().aL(this.ajF.getPageActivity());
            this.emR.a(this.ajF);
            this.emR.b(this.emS);
            this.emR.CP().bB(true);
            this.emR.f(this.ajF);
            aLe();
        }
    }

    public void bM(String str, String str2) {
        aLd();
        this.emR.setReplyId(str);
        this.emR.fB(str2);
    }

    private void aLe() {
        if (this.dWm != null && this.emR != null && this.emR.CP() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.dWm.addView(this.emR.CP(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.emR != null) {
            this.emR.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.emR != null) {
            this.emR.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.emR != null && this.emR.CP() != null) {
            this.emR.CP().onChangeSkinType(i);
        }
    }
}
