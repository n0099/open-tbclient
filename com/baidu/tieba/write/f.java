package com.baidu.tieba.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e gdS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.gdS = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.gdS.bry();
    }
}
