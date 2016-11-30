package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class cz {
    private TbPageContext GO;
    private RelativeLayout efO;
    private com.baidu.tbadk.editortools.e.p ewI;
    private com.baidu.tieba.pb.pb.main.view.c ewJ;

    public cz(TbPageContext tbPageContext, com.baidu.tieba.pb.pb.main.view.c cVar, RelativeLayout relativeLayout) {
        this.GO = tbPageContext;
        this.efO = relativeLayout;
        this.ewJ = cVar;
    }

    public void aPU() {
        if (this.ewI != null) {
            this.ewI.DS();
        }
    }

    private void aPV() {
        if (this.efO != null && this.ewI == null) {
            this.ewI = (com.baidu.tbadk.editortools.e.p) new com.baidu.tbadk.editortools.e.t().an(this.GO.getPageActivity());
            this.ewI.a(this.GO);
            this.ewI.b(this.ewJ);
            this.ewI.CO().bC(true);
            this.ewI.e(this.GO);
            aPW();
        }
    }

    public void bI(String str, String str2) {
        aPV();
        this.ewI.setReplyId(str);
        this.ewI.fT(str2);
    }

    private void aPW() {
        if (this.efO != null && this.ewI != null && this.ewI.CO() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.efO.addView(this.ewI.CO(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.ewI != null) {
            this.ewI.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.ewI != null) {
            this.ewI.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ewI != null && this.ewI.CO() != null) {
            this.ewI.CO().onChangeSkinType(i);
        }
    }
}
