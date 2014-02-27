package com.baidu.tieba.im.validate;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d implements DialogInterface.OnClickListener {
    final /* synthetic */ ValidateActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ValidateActivity validateActivity) {
        this.a = validateActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        r rVar;
        ValidateItemData validateItemData;
        switch (i) {
            case 0:
                rVar = this.a.b;
                rVar.a(true);
                ValidateActivity validateActivity = this.a;
                validateItemData = this.a.f;
                ValidateActivity.a(validateActivity, validateItemData);
                return;
            default:
                return;
        }
    }
}
