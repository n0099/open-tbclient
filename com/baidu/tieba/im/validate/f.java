package com.baidu.tieba.im.validate;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements DialogInterface.OnClickListener {
    final /* synthetic */ ValidateActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ValidateActivity validateActivity) {
        this.a = validateActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        t tVar;
        ValidateItemData validateItemData;
        switch (i) {
            case 0:
                tVar = this.a.b;
                tVar.a(true);
                ValidateActivity validateActivity = this.a;
                validateItemData = this.a.f;
                validateActivity.c(validateItemData);
                return;
            default:
                return;
        }
    }
}
