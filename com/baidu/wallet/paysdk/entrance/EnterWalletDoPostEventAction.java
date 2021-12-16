package com.baidu.wallet.paysdk.entrance;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.BdWalletUtils;
import java.util.HashMap;
/* loaded from: classes13.dex */
public class EnterWalletDoPostEventAction implements RouterAction {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public EnterWalletDoPostEventAction() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        BdWalletUtils.putFunctionNameList("postEvent");
    }

    private void a(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, this, context, str, str2) == null) {
            EventBus eventBus = EventBus.getInstance();
            eventBus.getClass();
            EventBus.getInstance().post(new EventBus.Event(eventBus, str, str2));
        }
    }

    @Override // com.baidu.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, hashMap, routerCallback) == null) {
            if (context != null && hashMap != null && hashMap.containsKey("event_key") && (hashMap.get("event_key") instanceof String) && hashMap.containsKey("event_value") && (hashMap.get("event_value") instanceof String)) {
                a(context, (String) hashMap.get("event_key"), (String) hashMap.get("event_value"));
                return;
            }
            if (routerCallback != null) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("errorMsg", "params-error");
                routerCallback.onResult(3, hashMap2);
            }
            StatisticManager.onEvent(PayStatServiceEvent.PAY_DO_POST_EVENT_FAIL);
        }
    }
}
