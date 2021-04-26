package com.baidu.wallet.qrcodescanner.entrance;

import android.content.Context;
import com.baidu.wallet.api.IScannerDispatchListener;
import com.baidu.wallet.qrcodescanner.IScanCodeListener;
import com.baidu.wallet.qrcodescanner.QRScanCodeActivity;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class GetQRScanCodeResultAction implements RouterAction {
    @Override // com.baidu.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, final RouterCallback routerCallback) {
        QRScanCodeActivity.mLightAppListener = new IScanCodeListener() { // from class: com.baidu.wallet.qrcodescanner.entrance.GetQRScanCodeResultAction.1
            @Override // com.baidu.wallet.qrcodescanner.IScanCodeListener
            public void dispatchUrl(Context context2, String str, IScannerDispatchListener iScannerDispatchListener) {
                QRScanCodeActivity.mLightAppListener = null;
                if (iScannerDispatchListener != null) {
                    iScannerDispatchListener.onClose();
                }
                HashMap hashMap2 = new HashMap();
                hashMap2.put("value", str);
                RouterCallback routerCallback2 = routerCallback;
                if (routerCallback2 != null) {
                    routerCallback2.onResult(0, hashMap2);
                }
            }

            @Override // com.baidu.wallet.qrcodescanner.IScanCodeListener
            public void onResult(int i2, String str) {
                QRScanCodeActivity.mLightAppListener = null;
                if (routerCallback != null) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put(RouterCallback.KEY_ERROR_CODE, Integer.valueOf(i2));
                    hashMap2.put("errorMsg", str);
                    routerCallback.onResult(1, hashMap2);
                }
            }

            @Override // com.baidu.wallet.qrcodescanner.IScanCodeListener
            public boolean shouldDispatchUrl(String str) {
                return true;
            }
        };
    }
}
