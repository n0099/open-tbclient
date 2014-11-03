package com.baidu.tieba.im.validate;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements DialogInterface.OnClickListener {
    final /* synthetic */ ValidateActivity bjf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ValidateActivity validateActivity) {
        this.bjf = validateActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        r rVar;
        ValidateItemData validateItemData;
        switch (i) {
            case 0:
                rVar = this.bjf.biZ;
                rVar.dg(true);
                ValidateActivity validateActivity = this.bjf;
                validateItemData = this.bjf.bjb;
                validateActivity.e(validateItemData);
                return;
            default:
                return;
        }
    }
}
