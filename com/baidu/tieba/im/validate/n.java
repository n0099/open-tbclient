package com.baidu.tieba.im.validate;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m f1815a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.f1815a = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ValidateActivity validateActivity;
        validateActivity = this.f1815a.d;
        validateActivity.finish();
    }
}
