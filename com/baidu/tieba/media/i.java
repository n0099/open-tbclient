package com.baidu.tieba.media;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(e eVar) {
        this.a = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        View.OnClickListener onClickListener;
        this.a.g = m.PAUSE;
        aVar = this.a.a;
        onClickListener = this.a.i;
        aVar.a(onClickListener);
    }
}
