package com.baidu.wallet.paysdk.sms.controller;

import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.baidu.wallet.statistics.api.StatisticManager;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class j {
    public static ISmsController a(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    switch (i2) {
                        case 5:
                            return new g();
                        case 6:
                            final ISmsController[] iSmsControllerArr = {null};
                            LocalRouter.getInstance(null).route(null, new RouterRequest().provider("hce").action("getsmscontroller"), new RouterCallback() { // from class: com.baidu.wallet.paysdk.sms.controller.j.1
                                @Override // com.baidu.wallet.router.RouterCallback
                                public void onResult(int i3, HashMap hashMap) {
                                    if (i3 == 0 || hashMap != null) {
                                        Object obj = hashMap.get("value");
                                        if (obj == null || !(obj instanceof ISmsController)) {
                                            return;
                                        }
                                        iSmsControllerArr[0] = (ISmsController) obj;
                                    } else if (i3 == 5) {
                                        HashMap hashMap2 = new HashMap();
                                        hashMap2.put("provider", "hce");
                                        hashMap2.put("action", "getsmscontroller");
                                        StatisticManager.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i3, hashMap2.values());
                                    }
                                }
                            });
                            return iSmsControllerArr[0];
                        case 7:
                            break;
                        case 8:
                        case 10:
                            return new b();
                        case 9:
                            return new c();
                        default:
                            return null;
                    }
                } else {
                    return new e();
                }
            } else {
                return new f();
            }
        }
        return new d();
    }
}
