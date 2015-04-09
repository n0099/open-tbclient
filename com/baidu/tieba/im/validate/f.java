package com.baidu.tieba.im.validate;

import android.view.View;
import com.baidu.tieba.im.data.ValidateItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ ValidateActivity bnW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ValidateActivity validateActivity) {
        this.bnW = validateActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        p pVar;
        ValidateItemData validateItemData;
        eVar.dismiss();
        switch (i) {
            case 0:
                pVar = this.bnW.bnQ;
                pVar.setLoadProgressBarVisable(true);
                ValidateActivity validateActivity = this.bnW;
                validateItemData = this.bnW.bnS;
                validateActivity.e(validateItemData);
                return;
            default:
                return;
        }
    }
}
