package com.baidu.wallet.qrcodescanner.entrance;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.IScannerDispatchListener;
import com.baidu.wallet.qrcodescanner.IScanCodeListener;
import com.baidu.wallet.qrcodescanner.QRScanCodeActivity;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class GetQRScanCodeResultAction implements RouterAction {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public GetQRScanCodeResultAction() {
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
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, hashMap, routerCallback) == null) {
            QRScanCodeActivity.mLightAppListener = new IScanCodeListener(this, routerCallback) { // from class: com.baidu.wallet.qrcodescanner.entrance.GetQRScanCodeResultAction.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ RouterCallback f27432a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ GetQRScanCodeResultAction f27433b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, routerCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f27433b = this;
                    this.f27432a = routerCallback;
                }

                @Override // com.baidu.wallet.qrcodescanner.IScanCodeListener
                public void dispatchUrl(Context context2, String str, IScannerDispatchListener iScannerDispatchListener) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, context2, str, iScannerDispatchListener) == null) {
                        QRScanCodeActivity.mLightAppListener = null;
                        if (iScannerDispatchListener != null) {
                            iScannerDispatchListener.onClose();
                        }
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("value", str);
                        RouterCallback routerCallback2 = this.f27432a;
                        if (routerCallback2 != null) {
                            routerCallback2.onResult(0, hashMap2);
                        }
                    }
                }

                @Override // com.baidu.wallet.qrcodescanner.IScanCodeListener
                public void onResult(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                        QRScanCodeActivity.mLightAppListener = null;
                        if (this.f27432a != null) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put(RouterCallback.KEY_ERROR_CODE, Integer.valueOf(i2));
                            hashMap2.put("errorMsg", str);
                            this.f27432a.onResult(1, hashMap2);
                        }
                    }
                }

                @Override // com.baidu.wallet.qrcodescanner.IScanCodeListener
                public boolean shouldDispatchUrl(String str) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        return true;
                    }
                    return invokeL.booleanValue;
                }
            };
        }
    }
}
