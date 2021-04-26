package com.baidu.wallet.personal;

import com.baidu.wallet.paysdk.sms.controller.ISmsController;
import com.baidu.wallet.paysdk.ui.WalletSmsActivity;
import com.baidu.wallet.personal.controllers.a;
/* loaded from: classes5.dex */
public class PersonWalletSmsActivity extends WalletSmsActivity {
    @Override // com.baidu.wallet.paysdk.ui.WalletSmsActivity
    public ISmsController getController(int i2) {
        return new a();
    }
}
