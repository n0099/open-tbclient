package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn implements Runnable {
    final /* synthetic */ bm eNl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bm bmVar) {
        this.eNl = bmVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.editortools.j jVar;
        com.baidu.tbadk.editortools.l lVar;
        com.baidu.tbadk.editortools.l lVar2;
        com.baidu.tbadk.editortools.j jVar2;
        BaseActivity baseActivity;
        jVar = this.eNl.eNi;
        if (jVar != null) {
            lVar = this.eNl.atG;
            if (lVar != null) {
                lVar2 = this.eNl.atG;
                com.baidu.tbadk.editortools.s eA = lVar2.eA(24);
                if (eA instanceof View) {
                    jVar2 = this.eNl.eNi;
                    baseActivity = this.eNl.bix;
                    jVar2.e(baseActivity.getPageContext().getPageActivity(), (View) eA);
                }
                this.eNl.eNj = true;
            }
        }
    }
}
