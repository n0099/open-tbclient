package com.baidu.wallet.api;

import android.content.Context;
import android.os.Bundle;
/* loaded from: classes5.dex */
public interface IWalletBaseFacade {
    void callQRCodeScanner(Context context, IWalletQRScannerCallback iWalletQRScannerCallback);

    String getBindUrl(String str);

    void gotoWalletService(Context context, String str, String str2);

    void initWallet(Context context);

    void initWallet(Context context, String str);

    void initWallet(IWalletListener iWalletListener, Context context, String str);

    void initWallet(IWalletListener iWalletListener, Context context, String str, ISecurityListener iSecurityListener);

    void logout(Context context);

    void openH5Module(Context context, String str, boolean z);

    void openH5Module(Context context, String str, boolean z, Bundle bundle);

    void setDebugOn(Context context, boolean z);

    boolean startWallet(Context context);
}
