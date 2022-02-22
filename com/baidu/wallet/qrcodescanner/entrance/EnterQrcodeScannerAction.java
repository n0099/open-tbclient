package com.baidu.wallet.qrcodescanner.entrance;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.IScannerDispatchListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.qrcodescanner.IScanCodeListener;
import com.baidu.wallet.qrcodescanner.QRScanCodeActivity;
import com.baidu.wallet.qrcodescanner.ScanCodeController;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class EnterQrcodeScannerAction implements RouterAction {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BEAN_TAG = "enterQrcodeScannerAction";
    public transient /* synthetic */ FieldHolder $fh;

    public EnterQrcodeScannerAction() {
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

    private void a(Context context, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
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
    }

    @Override // com.baidu.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, context, hashMap, routerCallback) == null) || a(context, hashMap, routerCallback)) {
            return;
        }
        boolean booleanValue = hashMap.containsKey("showQrCodeBtns") ? ((Boolean) hashMap.get("showQrCodeBtns")).booleanValue() : false;
        if (hashMap.containsKey("type")) {
            int intValue = ((Integer) hashMap.get("type")).intValue();
            if (!ScanCodeController.a(intValue)) {
                LogUtil.d("zxing", "EnterQrcodeScannerAction:not supprot type= " + intValue);
                if (routerCallback != null) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("errorMsg", "notSupport");
                    routerCallback.onResult(5, hashMap2);
                    return;
                }
                return;
            }
        }
        boolean booleanValue2 = hashMap.containsKey("qrcodeNeedResult") ? ((Boolean) hashMap.get("qrcodeNeedResult")).booleanValue() : false;
        LogUtil.i("zxing", "needQRCodeResult" + booleanValue2);
        if (booleanValue2) {
            QRScanCodeActivity.mLightAppListener = new IScanCodeListener(this, routerCallback) { // from class: com.baidu.wallet.qrcodescanner.entrance.EnterQrcodeScannerAction.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RouterCallback a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ EnterQrcodeScannerAction f52899b;

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
                    this.f52899b = this;
                    this.a = routerCallback;
                }

                @Override // com.baidu.wallet.qrcodescanner.IScanCodeListener
                public void dispatchUrl(Context context2, String str, IScannerDispatchListener iScannerDispatchListener) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, context2, str, iScannerDispatchListener) == null) {
                        QRScanCodeActivity.mLightAppListener = null;
                        if (iScannerDispatchListener != null) {
                            iScannerDispatchListener.onClose();
                        }
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("value", str);
                        RouterCallback routerCallback2 = this.a;
                        if (routerCallback2 != null) {
                            routerCallback2.onResult(0, hashMap3);
                        }
                    }
                }

                @Override // com.baidu.wallet.qrcodescanner.IScanCodeListener
                public void onResult(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                        QRScanCodeActivity.mLightAppListener = null;
                        if (this.a != null) {
                            LogUtil.i("zxing", "needQRCodeResult" + i2);
                            HashMap hashMap3 = new HashMap();
                            hashMap3.put("errCode", Integer.valueOf(i2));
                            hashMap3.put("errorMsg", str);
                            this.a.onResult(1, hashMap3);
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
        a(context, Boolean.parseBoolean((String) hashMap.get("withAnim")), booleanValue);
        if (booleanValue2 || routerCallback == null) {
            return;
        }
        HashMap hashMap3 = new HashMap();
        hashMap3.put("desc", "success");
        routerCallback.onResult(0, hashMap3);
    }

    private boolean a(Context context, HashMap hashMap, RouterCallback routerCallback) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, context, hashMap, routerCallback)) == null) {
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
        return invokeLLL.booleanValue;
    }
}
