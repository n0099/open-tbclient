package com.baidu.tieba.media;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar) {
        this.a = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        View.OnClickListener onClickListener;
        this.a.g = m.DOWNLOADING;
        aVar = this.a.a;
        onClickListener = this.a.h;
        aVar.b(onClickListener);
        this.a.g();
    }
}
