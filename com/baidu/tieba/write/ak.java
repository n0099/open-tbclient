package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements View.OnClickListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Bitmap bitmap;
        WriteActivity writeActivity = this.a;
        bitmap = this.a.w;
        WriteImageActivity.a(writeActivity, bitmap, 1200003);
    }
}
