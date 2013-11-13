package com.baidu.tieba.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2681a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(WriteActivity writeActivity) {
        this.f2681a = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2681a.o();
    }
}
