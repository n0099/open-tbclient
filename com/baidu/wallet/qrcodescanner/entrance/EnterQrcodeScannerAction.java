package com.baidu.wallet.qrcodescanner.entrance;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.qrcodescanner.QRScanCodeActivity;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class EnterQrcodeScannerAction implements RouterAction {
    public static final String BEAN_TAG = "enterQrcodeScannerAction";

    private void a(Context context, boolean z, boolean z2) {
        Intent intent = new Intent();
        boolean z3 = context instanceof Activity;
        if (z3) {
            LogUtil.d(BEAN_TAG, "context is activity!");
        } else {
            intent.setFlags(268435456);
        }
        intent.setClass(context, QRScanCodeActivity.class);
        intent.putExtra("with_anim", z);
        if (z2) {
            intent.putExtra("showQrCodeBtns", true);
        }
        WalletLoginHelper.getInstance().verifyPassLogin(false, null);
        context.startActivity(intent);
        if (z3) {
            if (z) {
                BaiduWalletUtils.startActivityAnim(context);
            } else {
                BaiduWalletUtils.overridePendingTransitionNoAnim((Activity) context);
            }
        }
    }

    @Override // com.baidu.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        if (a(context, hashMap, routerCallback)) {
            return;
        }
        a(context, Boolean.parseBoolean((String) hashMap.get("withAnim")), hashMap.containsKey("showQrCodeBtns") ? ((Boolean) hashMap.get("showQrCodeBtns")).booleanValue() : false);
        if (routerCallback != null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("desc", "success");
            routerCallback.onResult(0, hashMap2);
        }
    }

    private boolean a(Context context, HashMap hashMap, RouterCallback routerCallback) {
        if (context == null || hashMap == null || !hashMap.containsKey("withAnim")) {
            if (routerCallback != null) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("errorMsg", "params-error");
                routerCallback.onResult(3, hashMap2);
                return true;
            }
            return true;
        }
        return false;
    }
}
