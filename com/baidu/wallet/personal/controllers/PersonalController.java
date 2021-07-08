package com.baidu.wallet.personal.controllers;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.payresult.view.WalletPayResultCommonActivity;
import com.baidu.wallet.personal.PersonWalletSmsActivity;
/* loaded from: classes5.dex */
public class PersonalController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f27077a;

    /* renamed from: com.baidu.wallet.personal.controllers.PersonalController$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public interface a {
        void a(String str);

        void a(boolean z);
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static PersonalController f27078a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1903178142, "Lcom/baidu/wallet/personal/controllers/PersonalController$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1903178142, "Lcom/baidu/wallet/personal/controllers/PersonalController$b;");
                    return;
                }
            }
            f27078a = new PersonalController(null);
        }
    }

    public /* synthetic */ PersonalController(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static PersonalController getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.f27078a : (PersonalController) invokeV.objValue;
    }

    public void onReceiveFailed(String str) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (aVar = this.f27077a) == null) {
            return;
        }
        aVar.a(str);
    }

    public void onReceiveSuccess(boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (aVar = this.f27077a) == null) {
            return;
        }
        aVar.a(z);
    }

    public void receive(Context context, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, aVar) == null) {
            this.f27077a = aVar;
            Intent intent = new Intent(context, WalletPayResultCommonActivity.class);
            intent.putExtra(BeanConstants.KEY_PAY_RESULT_TYPE, 3);
            context.startActivity(intent);
        }
    }

    public void receiveWithSms(Context context, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, aVar) == null) {
            this.f27077a = aVar;
            Intent intent = new Intent();
            intent.putExtra(BeanConstants.SMS_ACTIVITY_FROM_KEY, 3);
            intent.setClass(context, PersonWalletSmsActivity.class);
            context.startActivity(intent);
        }
    }

    public void removeCallBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f27077a = null;
        }
    }

    public PersonalController() {
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
