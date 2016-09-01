package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity gfs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(WriteActivity writeActivity) {
        this.gfs = writeActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        com.baidu.tbadk.editortools.l lVar;
        com.baidu.tbadk.editortools.l lVar2;
        if (z) {
            this.gfs.gfa = false;
            this.gfs.gfo = false;
            this.gfs.bti();
            lVar = this.gfs.auk;
            if (lVar != null) {
                lVar2 = this.gfs.auk;
                lVar2.AS();
            }
        }
    }
}
