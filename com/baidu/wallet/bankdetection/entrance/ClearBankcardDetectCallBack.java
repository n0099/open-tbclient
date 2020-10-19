package com.baidu.wallet.bankdetection.entrance;

import android.content.Context;
import com.baidu.wallet.bankdetection.BankcardDetectionController;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;
/* loaded from: classes16.dex */
public class ClearBankcardDetectCallBack implements RouterAction {
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        BankcardDetectionController.getInstance().clearCardDetectionCallback();
        if (routerCallback != null) {
            routerCallback.onResult(0, (HashMap) null);
        }
    }
}
