package com.baidu.wallet.paysdk.entrance;

import android.content.Context;
import android.os.Bundle;
import com.baidu.wallet.base.controllers.IdCardDetectionController;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class EnterWalletIdCardDetectAction implements RouterAction {
    private void a(Context context, int i2, boolean z, final RouterCallback routerCallback) {
        IdCardDetectionController.getInstance().startIdcarddetect(context, i2, new IdCardDetectionController.IIdCardDetectionListener() { // from class: com.baidu.wallet.paysdk.entrance.EnterWalletIdCardDetectAction.1
            @Override // com.baidu.wallet.base.controllers.IdCardDetectionController.IIdCardDetectionListener
            public void onDetectFailed(int i3, String str) {
                if (routerCallback != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(RouterCallback.KEY_ERROR_CODE, Integer.valueOf(i3));
                    hashMap.put("errMsg", str);
                    routerCallback.onResult(1, hashMap);
                }
            }

            @Override // com.baidu.wallet.base.controllers.IdCardDetectionController.IIdCardDetectionListener
            public void onDetectOK(Bundle bundle) {
                if (routerCallback != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("result", bundle);
                    routerCallback.onResult(0, hashMap);
                }
            }
        }, z);
    }

    @Override // com.baidu.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        if (context != null && hashMap != null && hashMap.containsKey("type") && (hashMap.get("type") instanceof Integer) && hashMap.containsKey("showAlbum") && (hashMap.get("showAlbum") instanceof Boolean)) {
            a(context, ((Integer) hashMap.get("type")).intValue(), ((Boolean) hashMap.get("showAlbum")).booleanValue(), routerCallback);
        } else if (routerCallback != null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errorMsg", "params-error");
            routerCallback.onResult(3, hashMap2);
        }
    }
}
