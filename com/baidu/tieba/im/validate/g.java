package com.baidu.tieba.im.validate;

import android.content.DialogInterface;
import com.baidu.tieba.im.data.ValidateItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements DialogInterface.OnClickListener {
    final /* synthetic */ ValidateActivity bpQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ValidateActivity validateActivity) {
        this.bpQ = validateActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        m mVar;
        ValidateItemData validateItemData;
        switch (i) {
            case 0:
                mVar = this.bpQ.bpK;
                mVar.setLoadProgressBarVisable(true);
                ValidateActivity validateActivity = this.bpQ;
                validateItemData = this.bpQ.bpM;
                validateActivity.e(validateItemData);
                return;
            default:
                return;
        }
    }
}
