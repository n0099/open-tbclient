package com.baidu.tieba.im.validate;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ValidateActivity f1719a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ValidateActivity validateActivity) {
        this.f1719a = validateActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        m mVar;
        ValidateItemData validateItemData;
        switch (i) {
            case 0:
                mVar = this.f1719a.b;
                mVar.a(true);
                ValidateActivity validateActivity = this.f1719a;
                validateItemData = this.f1719a.f;
                validateActivity.c(validateItemData);
                return;
            default:
                return;
        }
    }
}
