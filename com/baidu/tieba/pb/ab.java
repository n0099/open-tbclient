package com.baidu.tieba.pb;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f2039a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(ImagePbActivity imagePbActivity) {
        this.f2039a = imagePbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ImagePbActivity imagePbActivity = this.f2039a;
        i = this.f2039a.x;
        imagePbActivity.e(i);
    }
}
