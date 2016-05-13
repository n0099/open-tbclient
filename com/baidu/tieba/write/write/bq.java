package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements Runnable {
    final /* synthetic */ bp fek;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bp bpVar) {
        this.fek = bpVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.editortools.j jVar;
        com.baidu.tbadk.editortools.l lVar;
        com.baidu.tbadk.editortools.l lVar2;
        com.baidu.tbadk.editortools.j jVar2;
        BaseActivity baseActivity;
        jVar = this.fek.feh;
        if (jVar != null) {
            lVar = this.fek.apy;
            if (lVar != null) {
                lVar2 = this.fek.apy;
                com.baidu.tbadk.editortools.s ef = lVar2.ef(24);
                if (ef instanceof View) {
                    jVar2 = this.fek.feh;
                    baseActivity = this.fek.bek;
                    jVar2.c(baseActivity.getPageContext().getPageActivity(), (View) ef);
                }
                this.fek.fei = true;
            }
        }
    }
}
