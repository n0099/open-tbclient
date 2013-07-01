package com.baidu.tieba;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LabelActivity f1475a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(LabelActivity labelActivity) {
        this.f1475a = labelActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1475a.a(false);
    }
}
