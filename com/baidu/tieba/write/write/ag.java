package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    final /* synthetic */ WriteActivity ets;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(WriteActivity writeActivity) {
        this.ets = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.ets.aTp();
        this.ets.aUO();
    }
}
