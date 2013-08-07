package com.baidu.tieba;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LabelActivity f1920a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(LabelActivity labelActivity) {
        this.f1920a = labelActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1920a.a(false);
    }
}
