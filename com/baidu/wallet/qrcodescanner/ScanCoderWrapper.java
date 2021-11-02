package com.baidu.wallet.qrcodescanner;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.IScannerDispatchListener;
import com.baidu.wallet.core.NoProguard;
/* loaded from: classes10.dex */
public class ScanCoderWrapper implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public IScanCodeListener f60819a;

    /* renamed from: com.baidu.wallet.qrcodescanner.ScanCoderWrapper$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static ScanCoderWrapper f60820a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1838169620, "Lcom/baidu/wallet/qrcodescanner/ScanCoderWrapper$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1838169620, "Lcom/baidu/wallet/qrcodescanner/ScanCoderWrapper$a;");
                    return;
                }
            }
            f60820a = new ScanCoderWrapper(null);
        }
    }

    public /* synthetic */ ScanCoderWrapper(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static ScanCoderWrapper getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f60820a : (ScanCoderWrapper) invokeV.objValue;
    }

    public void dispatchUrl(Context context, String str, IScannerDispatchListener iScannerDispatchListener) {
        IScanCodeListener iScanCodeListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, context, str, iScannerDispatchListener) == null) || (iScanCodeListener = this.f60819a) == null) {
            return;
        }
        iScanCodeListener.dispatchUrl(context, str, iScannerDispatchListener);
    }

    public void initListener(IScanCodeListener iScanCodeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iScanCodeListener) == null) {
            this.f60819a = iScanCodeListener;
        }
    }

    public boolean shouldDispatchUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            IScanCodeListener iScanCodeListener = this.f60819a;
            if (iScanCodeListener != null) {
                return iScanCodeListener.shouldDispatchUrl(str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public ScanCoderWrapper() {
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
}
