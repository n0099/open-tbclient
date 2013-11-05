package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2640a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(WriteActivity writeActivity) {
        this.f2640a = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Bitmap bitmap;
        WriteActivity writeActivity = this.f2640a;
        bitmap = this.f2640a.B;
        WriteImageActivity.a(writeActivity, bitmap, 12003);
    }
}
