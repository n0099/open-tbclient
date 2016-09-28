package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements Runnable {
    final /* synthetic */ bl ghL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bl blVar) {
        this.ghL = blVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.editortools.j jVar;
        com.baidu.tbadk.editortools.l lVar;
        com.baidu.tbadk.editortools.l lVar2;
        com.baidu.tbadk.editortools.j jVar2;
        BaseActivity baseActivity;
        jVar = this.ghL.ghI;
        if (jVar != null) {
            lVar = this.ghL.atO;
            if (lVar != null) {
                lVar2 = this.ghL.atO;
                com.baidu.tbadk.editortools.s ew = lVar2.ew(24);
                if (ew instanceof View) {
                    jVar2 = this.ghL.ghI;
                    baseActivity = this.ghL.aRd;
                    jVar2.d(baseActivity.getPageContext().getPageActivity(), (View) ew);
                }
                this.ghL.ghJ = true;
            }
        }
    }
}
