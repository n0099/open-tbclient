package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
/* loaded from: classes.dex */
public class dd {
    private TbPageContext FY;
    private RelativeLayout dTs;
    private com.baidu.tbadk.editortools.pb.n ejV;
    private PbFakeFloorModel ejW;

    public dd(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.FY = tbPageContext;
        this.dTs = relativeLayout;
        this.ejW = pbFakeFloorModel;
    }

    public void aLG() {
        if (this.ejV != null) {
            this.ejV.Dv();
        }
    }

    private void aLH() {
        if (this.dTs != null && this.ejV == null) {
            this.ejV = (com.baidu.tbadk.editortools.pb.n) new com.baidu.tbadk.editortools.pb.r().an(this.FY.getPageActivity());
            this.ejV.a(this.FY);
            this.ejV.b(this.ejW);
            this.ejV.Cw().bC(true);
            this.ejV.f(this.FY);
            aLI();
        }
    }

    public void bT(String str, String str2) {
        aLH();
        this.ejV.setReplyId(str);
        this.ejV.fM(str2);
    }

    private void aLI() {
        if (this.dTs != null && this.ejV != null && this.ejV.Cw() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.dTs.addView(this.ejV.Cw(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.ejV != null) {
            this.ejV.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.ejV != null) {
            this.ejV.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ejV != null && this.ejV.Cw() != null) {
            this.ejV.Cw().onChangeSkinType(i);
        }
    }
}
