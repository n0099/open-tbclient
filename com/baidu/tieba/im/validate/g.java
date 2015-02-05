package com.baidu.tieba.im.validate;

import android.content.DialogInterface;
import com.baidu.tieba.im.data.ValidateItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements DialogInterface.OnClickListener {
    final /* synthetic */ ValidateActivity bpP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ValidateActivity validateActivity) {
        this.bpP = validateActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        m mVar;
        ValidateItemData validateItemData;
        switch (i) {
            case 0:
                mVar = this.bpP.bpJ;
                mVar.setLoadProgressBarVisable(true);
                ValidateActivity validateActivity = this.bpP;
                validateItemData = this.bpP.bpL;
                validateActivity.e(validateItemData);
                return;
            default:
                return;
        }
    }
}
