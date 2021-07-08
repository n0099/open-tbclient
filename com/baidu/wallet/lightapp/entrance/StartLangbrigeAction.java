package com.baidu.wallet.lightapp.entrance;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.lightapp.business.LightappBrowseActivity;
import com.baidu.wallet.lightapp.multipage.LangbridgeActivity;
import com.baidu.wallet.lightapp.multipage.h;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class StartLangbrigeAction implements RouterAction {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public StartLangbrigeAction() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, context, hashMap, routerCallback) == null) || hashMap == null) {
            return;
        }
        String str = (String) hashMap.get("url");
        String str2 = (String) hashMap.get("title");
        boolean booleanValue = ((Boolean) hashMap.get("with_anim")).booleanValue();
        boolean booleanValue2 = ((Boolean) hashMap.get("show_share")).booleanValue();
        Bundle bundle = (Bundle) hashMap.get("bundle");
        if (TextUtils.isEmpty(str)) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errorMsg", "url is null");
            routerCallback.onResult(3, hashMap2);
        } else if (h.a().a(context).MW_USE_OLD) {
            LightappBrowseActivity.startLightApp(context, str, str2, booleanValue, booleanValue2, bundle);
        } else {
            LangbridgeActivity.startLangbridge(context, str, str2, booleanValue, booleanValue2, bundle);
        }
    }
}
