package com.baidu.wallet.base.controllers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.iddetect.IdCardDetectionH5Activity;
import com.baidu.wallet.base.iddetect.IdentityCardDetectionActivity;
import com.baidu.wallet.core.NoProguard;
/* loaded from: classes10.dex */
public class IdCardDetectionController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IIdCardDetectionListener mIdCardResultListener;

    /* renamed from: com.baidu.wallet.base.controllers.IdCardDetectionController$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public interface IIdCardDetectionListener extends NoProguard {
        void onDetectFailed(int i2, String str);

        void onDetectOK(Bundle bundle);
    }

    /* loaded from: classes10.dex */
    public static class SingletonHolder {
        public static /* synthetic */ Interceptable $ic;
        public static final IdCardDetectionController sInstance;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-546515552, "Lcom/baidu/wallet/base/controllers/IdCardDetectionController$SingletonHolder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-546515552, "Lcom/baidu/wallet/base/controllers/IdCardDetectionController$SingletonHolder;");
                    return;
                }
            }
            sInstance = new IdCardDetectionController(null);
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

    public /* synthetic */ IdCardDetectionController(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static final IdCardDetectionController getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? SingletonHolder.sInstance : (IdCardDetectionController) invokeV.objValue;
    }

    public void IdCardDeteFailed(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
            IIdCardDetectionListener iIdCardDetectionListener = this.mIdCardResultListener;
            if (iIdCardDetectionListener != null) {
                iIdCardDetectionListener.onDetectFailed(i2, str);
            }
            this.mIdCardResultListener = null;
        }
    }

    public void IdCardDeteSuccess(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            IIdCardDetectionListener iIdCardDetectionListener = this.mIdCardResultListener;
            if (iIdCardDetectionListener != null) {
                iIdCardDetectionListener.onDetectOK(bundle);
            }
            this.mIdCardResultListener = null;
        }
    }

    public void clearIdCardResultCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mIdCardResultListener = null;
        }
    }

    public IIdCardDetectionListener getIdCardDetectionListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mIdCardResultListener : (IIdCardDetectionListener) invokeV.objValue;
    }

    public void startIdcarddetect(Context context, int i2, IIdCardDetectionListener iIdCardDetectionListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Integer.valueOf(i2), iIdCardDetectionListener, Boolean.valueOf(z)}) == null) {
            this.mIdCardResultListener = iIdCardDetectionListener;
            if (i2 != 5 && i2 != 6) {
                Intent intent = new Intent(context, IdentityCardDetectionActivity.class);
                intent.putExtra(ShaderParams.VALUE_TYPE_STEP, i2);
                intent.putExtra("show_album", z);
                if (!(context instanceof Activity)) {
                    intent.setFlags(268435456);
                }
                context.startActivity(intent);
                return;
            }
            Intent intent2 = new Intent(context, IdCardDetectionH5Activity.class);
            intent2.putExtra(ShaderParams.VALUE_TYPE_STEP, i2);
            if (!(context instanceof Activity)) {
                intent2.setFlags(268435456);
            }
            context.startActivity(intent2);
        }
    }

    public IdCardDetectionController() {
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
