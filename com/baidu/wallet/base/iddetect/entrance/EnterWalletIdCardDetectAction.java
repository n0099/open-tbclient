package com.baidu.wallet.base.iddetect.entrance;

import android.content.Context;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.controllers.IdCardDetectionController;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class EnterWalletIdCardDetectAction implements RouterAction {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public EnterWalletIdCardDetectAction() {
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

    private void startIdCardDetect(Context context, int i2, boolean z, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{context, Integer.valueOf(i2), Boolean.valueOf(z), routerCallback}) == null) {
            IdCardDetectionController.getInstance().startIdcarddetect(context, i2, new IdCardDetectionController.IIdCardDetectionListener(this, routerCallback) { // from class: com.baidu.wallet.base.iddetect.entrance.EnterWalletIdCardDetectAction.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ EnterWalletIdCardDetectAction this$0;
                public final /* synthetic */ RouterCallback val$callback;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, routerCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$callback = routerCallback;
                }

                @Override // com.baidu.wallet.base.controllers.IdCardDetectionController.IIdCardDetectionListener
                public void onDetectFailed(int i3, String str) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, str) == null) || this.val$callback == null) {
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("errCode", Integer.valueOf(i3));
                    hashMap.put("errMsg", str);
                    this.val$callback.onResult(1, hashMap);
                }

                @Override // com.baidu.wallet.base.controllers.IdCardDetectionController.IIdCardDetectionListener
                public void onDetectOK(Bundle bundle) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) || this.val$callback == null) {
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("result", bundle);
                    this.val$callback.onResult(0, hashMap);
                }
            }, z);
        }
    }

    @Override // com.baidu.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, hashMap, routerCallback) == null) {
            if (context != null && hashMap != null && hashMap.containsKey("type") && (hashMap.get("type") instanceof Integer) && hashMap.containsKey("showAlbum") && (hashMap.get("showAlbum") instanceof Boolean)) {
                startIdCardDetect(context, ((Integer) hashMap.get("type")).intValue(), ((Boolean) hashMap.get("showAlbum")).booleanValue(), routerCallback);
            } else if (routerCallback != null) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("errorMsg", "params-error");
                routerCallback.onResult(3, hashMap2);
            }
        }
    }
}
