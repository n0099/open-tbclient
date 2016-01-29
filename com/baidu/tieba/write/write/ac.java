package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity ets;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(WriteActivity writeActivity) {
        this.ets = writeActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        com.baidu.tbadk.editortools.k kVar;
        com.baidu.tbadk.editortools.k kVar2;
        if (z) {
            this.ets.etl = false;
            this.ets.etp = false;
            this.ets.aUI();
            kVar = this.ets.ath;
            if (kVar != null) {
                kVar2 = this.ets.ath;
                kVar2.Ba();
            }
        }
    }
}
