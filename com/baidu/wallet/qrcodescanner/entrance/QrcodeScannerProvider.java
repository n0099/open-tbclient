package com.baidu.wallet.qrcodescanner.entrance;

import com.baidu.wallet.router.RouterProvider;
/* loaded from: classes5.dex */
public class QrcodeScannerProvider extends RouterProvider {
    @Override // com.baidu.wallet.router.RouterProvider
    public void registerActions() {
        registerAction("qrcodescanner", new EnterQrcodeScannerAction());
        registerAction("qrcodescanresult", new GetQRScanCodeResultAction());
    }
}
