package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f1911a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(WriteActivity writeActivity) {
        this.f1911a = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Bitmap bitmap;
        WriteActivity writeActivity = this.f1911a;
        bitmap = this.f1911a.y;
        WriteImageActivity.a(writeActivity, bitmap, 12003);
    }
}
