package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2095a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(WriteActivity writeActivity) {
        this.f2095a = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Bitmap bitmap;
        WriteActivity writeActivity = this.f2095a;
        bitmap = this.f2095a.B;
        WriteImageActivity.a(writeActivity, bitmap, 12003);
    }
}
