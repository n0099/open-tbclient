package com.baidu.tieba.im.validate;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ValidateActivity f1897a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ValidateActivity validateActivity) {
        this.f1897a = validateActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        n nVar;
        ValidateItemData validateItemData;
        switch (i) {
            case 0:
                nVar = this.f1897a.b;
                nVar.a(true);
                ValidateActivity validateActivity = this.f1897a;
                validateItemData = this.f1897a.f;
                validateActivity.c(validateItemData);
                return;
            default:
                return;
        }
    }
}
