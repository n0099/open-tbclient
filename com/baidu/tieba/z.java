package com.baidu.tieba;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LabelActivity f1922a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(LabelActivity labelActivity) {
        this.f1922a = labelActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1922a.o();
    }
}
