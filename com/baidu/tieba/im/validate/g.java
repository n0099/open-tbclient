package com.baidu.tieba.im.validate;

import android.content.DialogInterface;
import com.baidu.tieba.im.data.ValidateItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements DialogInterface.OnClickListener {
    final /* synthetic */ ValidateActivity bot;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ValidateActivity validateActivity) {
        this.bot = validateActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        m mVar;
        ValidateItemData validateItemData;
        switch (i) {
            case 0:
                mVar = this.bot.bon;
                mVar.setLoadProgressBarVisable(true);
                ValidateActivity validateActivity = this.bot;
                validateItemData = this.bot.bop;
                validateActivity.e(validateItemData);
                return;
            default:
                return;
        }
    }
}
