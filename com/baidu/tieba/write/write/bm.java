package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements Runnable {
    final /* synthetic */ bl fVw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bl blVar) {
        this.fVw = blVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.editortools.j jVar;
        com.baidu.tbadk.editortools.l lVar;
        com.baidu.tbadk.editortools.l lVar2;
        com.baidu.tbadk.editortools.j jVar2;
        BaseActivity baseActivity;
        jVar = this.fVw.fVt;
        if (jVar != null) {
            lVar = this.fVw.ard;
            if (lVar != null) {
                lVar2 = this.fVw.ard;
                com.baidu.tbadk.editortools.s ej = lVar2.ej(24);
                if (ej instanceof View) {
                    jVar2 = this.fVw.fVt;
                    baseActivity = this.fVw.bem;
                    jVar2.d(baseActivity.getPageContext().getPageActivity(), (View) ej);
                }
                this.fVw.fVu = true;
            }
        }
    }
}
