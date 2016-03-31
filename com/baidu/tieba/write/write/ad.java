package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity eNd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(WriteActivity writeActivity) {
        this.eNd = writeActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        com.baidu.tbadk.editortools.l lVar;
        com.baidu.tbadk.editortools.l lVar2;
        if (z) {
            this.eNd.eMV = false;
            this.eNd.eNa = false;
            this.eNd.bbj();
            lVar = this.eNd.atG;
            if (lVar != null) {
                lVar2 = this.eNd.atG;
                lVar2.BD();
            }
        }
    }
}
