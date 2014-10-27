package com.baidu.tieba.im.validate;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements DialogInterface.OnClickListener {
    final /* synthetic */ ValidateActivity biR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ValidateActivity validateActivity) {
        this.biR = validateActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        r rVar;
        ValidateItemData validateItemData;
        switch (i) {
            case 0:
                rVar = this.biR.biL;
                rVar.dg(true);
                ValidateActivity validateActivity = this.biR;
                validateItemData = this.biR.biN;
                validateActivity.e(validateItemData);
                return;
            default:
                return;
        }
    }
}
