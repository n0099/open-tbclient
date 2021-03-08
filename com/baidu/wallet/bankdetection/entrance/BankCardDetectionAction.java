package com.baidu.wallet.bankdetection.entrance;

import android.content.Context;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.wallet.bankdetection.BankcardDetectionController;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;
/* loaded from: classes14.dex */
public class BankCardDetectionAction implements RouterAction {
    public void invoke(Context context, HashMap hashMap, final RouterCallback routerCallback) {
        BankcardDetectionController.getInstance().gotoDetctionCard(context, new BankcardDetectionController.IDetectionListener() { // from class: com.baidu.wallet.bankdetection.entrance.BankCardDetectionAction.1
            @Override // com.baidu.wallet.bankdetection.BankcardDetectionController.IDetectionListener
            public void onResult(String str) {
                if (routerCallback != null) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("card_num", str);
                    routerCallback.onResult(0, hashMap2);
                }
            }

            @Override // com.baidu.wallet.bankdetection.BankcardDetectionController.IDetectionListener
            public void onFail(int i, String str) {
                if (routerCallback != null) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put(TiebaInitialize.LogFields.ERROR_MESSAGE, str);
                    hashMap2.put("errCode", Integer.valueOf(i));
                    routerCallback.onResult(1, hashMap2);
                }
            }
        });
    }
}
