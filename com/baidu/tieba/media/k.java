package com.baidu.tieba.media;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        this.a = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        this.a.g = m.STOP;
        aVar = this.a.a;
        aVar.h();
    }
}
