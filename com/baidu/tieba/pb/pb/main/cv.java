package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class cv {
    private TbPageContext GO;
    private RelativeLayout dKv;
    private com.baidu.tbadk.editortools.e.p ebd;
    private com.baidu.tieba.pb.pb.main.view.c ebe;

    public cv(TbPageContext tbPageContext, com.baidu.tieba.pb.pb.main.view.c cVar, RelativeLayout relativeLayout) {
        this.GO = tbPageContext;
        this.dKv = relativeLayout;
        this.ebe = cVar;
    }

    public void aJT() {
        if (this.ebd != null) {
            this.ebd.DA();
        }
    }

    private void aJU() {
        if (this.dKv != null && this.ebd == null) {
            this.ebd = (com.baidu.tbadk.editortools.e.p) new com.baidu.tbadk.editortools.e.t().al(this.GO.getPageActivity());
            this.ebd.a(this.GO);
            this.ebd.b(this.ebe);
            this.ebd.CB().bC(true);
            this.ebd.f(this.GO);
            aJV();
        }
    }

    public void bL(String str, String str2) {
        aJU();
        this.ebd.setReplyId(str);
        this.ebd.fP(str2);
    }

    private void aJV() {
        if (this.dKv != null && this.ebd != null && this.ebd.CB() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.dKv.addView(this.ebd.CB(), layoutParams);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.ebd != null) {
            this.ebd.onActivityResult(i, i2, intent);
        }
    }

    public void onStop() {
        if (this.ebd != null) {
            this.ebd.onStop();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ebd != null && this.ebd.CB() != null) {
            this.ebd.CB().onChangeSkinType(i);
        }
    }
}
