package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements Runnable {
    final /* synthetic */ bl fJF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bl blVar) {
        this.fJF = blVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.editortools.j jVar;
        com.baidu.tbadk.editortools.l lVar;
        com.baidu.tbadk.editortools.l lVar2;
        com.baidu.tbadk.editortools.j jVar2;
        BaseActivity baseActivity;
        jVar = this.fJF.fJC;
        if (jVar != null) {
            lVar = this.fJF.aqo;
            if (lVar != null) {
                lVar2 = this.fJF.aqo;
                com.baidu.tbadk.editortools.s ej = lVar2.ej(24);
                if (ej instanceof View) {
                    jVar2 = this.fJF.fJC;
                    baseActivity = this.fJF.bkc;
                    jVar2.c(baseActivity.getPageContext().getPageActivity(), (View) ej);
                }
                this.fJF.fJD = true;
            }
        }
    }
}
