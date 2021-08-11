package com.baidu.wallet.base.iddetect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.NoProguard;
/* loaded from: classes8.dex */
public class IdCardController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IIdCardRecognizeListener mIdCardResultListener;

    /* renamed from: com.baidu.wallet.base.iddetect.IdCardController$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public interface IIdCardRecognizeListener extends NoProguard {
        void onFail(int i2, Bundle bundle);

        void onSuccess(Bundle bundle);
    }

    /* loaded from: classes8.dex */
    public static class SingletonHolder {
        public static /* synthetic */ Interceptable $ic;
        public static IdCardController sInstance;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-969870874, "Lcom/baidu/wallet/base/iddetect/IdCardController$SingletonHolder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-969870874, "Lcom/baidu/wallet/base/iddetect/IdCardController$SingletonHolder;");
                    return;
                }
            }
            sInstance = new IdCardController(null);
        }

        public SingletonHolder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public /* synthetic */ IdCardController(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static IdCardController getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? SingletonHolder.sInstance : (IdCardController) invokeV.objValue;
    }

    public void fail(int i2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, bundle) == null) {
            IIdCardRecognizeListener iIdCardRecognizeListener = this.mIdCardResultListener;
            if (iIdCardRecognizeListener != null) {
                iIdCardRecognizeListener.onFail(i2, bundle);
            }
            this.mIdCardResultListener = null;
        }
    }

    public void startIdcarddetect(Context context, IIdCardRecognizeListener iIdCardRecognizeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, iIdCardRecognizeListener) == null) {
            this.mIdCardResultListener = iIdCardRecognizeListener;
            Intent intent = new Intent(context, IdCardActivity.class);
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    public void success(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            IIdCardRecognizeListener iIdCardRecognizeListener = this.mIdCardResultListener;
            if (iIdCardRecognizeListener != null) {
                iIdCardRecognizeListener.onSuccess(bundle);
            }
            this.mIdCardResultListener = null;
        }
    }

    public IdCardController() {
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
