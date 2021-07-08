package com.baidu.wallet.base.iddetect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.NoProguard;
/* loaded from: classes5.dex */
public class IdCardController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public IIdCardRecognizeListener f24046a;

    /* renamed from: com.baidu.wallet.base.iddetect.IdCardController$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public interface IIdCardRecognizeListener extends NoProguard {
        void onFail(int i2, Bundle bundle);

        void onSuccess(Bundle bundle);
    }

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static IdCardController f24047a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(225804220, "Lcom/baidu/wallet/base/iddetect/IdCardController$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(225804220, "Lcom/baidu/wallet/base/iddetect/IdCardController$a;");
                    return;
                }
            }
            f24047a = new IdCardController(null);
        }
    }

    public /* synthetic */ IdCardController(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static IdCardController getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f24047a : (IdCardController) invokeV.objValue;
    }

    public void fail(int i2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, bundle) == null) {
            IIdCardRecognizeListener iIdCardRecognizeListener = this.f24046a;
            if (iIdCardRecognizeListener != null) {
                iIdCardRecognizeListener.onFail(i2, bundle);
            }
            this.f24046a = null;
        }
    }

    public void startIdcarddetect(Context context, IIdCardRecognizeListener iIdCardRecognizeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, iIdCardRecognizeListener) == null) {
            this.f24046a = iIdCardRecognizeListener;
            Intent intent = new Intent(context, IdCardActivity.class);
            if (!(context instanceof Activity)) {
                intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            context.startActivity(intent);
        }
    }

    public void success(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            IIdCardRecognizeListener iIdCardRecognizeListener = this.f24046a;
            if (iIdCardRecognizeListener != null) {
                iIdCardRecognizeListener.onSuccess(bundle);
            }
            this.f24046a = null;
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
