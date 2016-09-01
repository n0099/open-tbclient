package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements Runnable {
    final /* synthetic */ bl gfB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bl blVar) {
        this.gfB = blVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.editortools.j jVar;
        com.baidu.tbadk.editortools.l lVar;
        com.baidu.tbadk.editortools.l lVar2;
        com.baidu.tbadk.editortools.j jVar2;
        BaseActivity baseActivity;
        jVar = this.gfB.gfy;
        if (jVar != null) {
            lVar = this.gfB.auk;
            if (lVar != null) {
                lVar2 = this.gfB.auk;
                com.baidu.tbadk.editortools.s ex = lVar2.ex(24);
                if (ex instanceof View) {
                    jVar2 = this.gfB.gfy;
                    baseActivity = this.gfB.aPR;
                    jVar2.d(baseActivity.getPageContext().getPageActivity(), (View) ex);
                }
                this.gfB.gfz = true;
            }
        }
    }
}
