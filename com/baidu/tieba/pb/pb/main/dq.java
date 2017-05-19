package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
/* loaded from: classes.dex */
public class dq {
    private TbPageContext ajr;
    private RelativeLayout bGH;
    private com.baidu.tbadk.editortools.pb.n ejn;
    private PbFakeFloorModel ejo;

    public dq(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.ajr = tbPageContext;
        this.bGH = relativeLayout;
        this.ejo = pbFakeFloorModel;
    }

    public void aJK() {
        if (this.ejn != null) {
            this.ejn.Dq();
        }
    }

    private void aJL() {
        if (this.bGH != null && this.ejn == null) {
            this.ejn = (com.baidu.tbadk.editortools.pb.n) new com.baidu.tbadk.editortools.pb.r().aQ(this.ajr.getPageActivity());
            this.ejn.a(this.ajr);
            this.ejn.b(this.ejo);
            this.ejn.Cs().bD(true);
            this.ejn.f(this.ajr);
            aJM();
        }
    }

    public void bJ(String str, String str2) {
        aJL();
        this.ejn.setReplyId(str);
        this.ejn.fE(str2);
    }

    private void aJM() {
        if (this.bGH != null && this.ejn != null && this.ejn.Cs() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bGH.addView(this.ejn.Cs(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.ejn != null) {
            this.ejn.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.ejn != null) {
            this.ejn.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ejn != null && this.ejn.Cs() != null) {
            this.ejn.Cs().onChangeSkinType(i);
        }
    }
}
