package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn implements Runnable {
    final /* synthetic */ bm gpx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bm bmVar) {
        this.gpx = bmVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.editortools.j jVar;
        com.baidu.tbadk.editortools.l lVar;
        com.baidu.tbadk.editortools.l lVar2;
        com.baidu.tbadk.editortools.j jVar2;
        BaseActivity baseActivity;
        jVar = this.gpx.gpu;
        if (jVar != null) {
            lVar = this.gpx.auI;
            if (lVar != null) {
                lVar2 = this.gpx.auI;
                com.baidu.tbadk.editortools.s ez = lVar2.ez(24);
                if (ez instanceof View) {
                    jVar2 = this.gpx.gpu;
                    baseActivity = this.gpx.aTb;
                    jVar2.d(baseActivity.getPageContext().getPageActivity(), (View) ez);
                }
                this.gpx.gpv = true;
            }
        }
    }
}
