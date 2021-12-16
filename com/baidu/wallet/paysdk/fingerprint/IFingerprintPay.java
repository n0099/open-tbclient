package com.baidu.wallet.paysdk.fingerprint;

import android.app.Activity;
import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes13.dex */
public interface IFingerprintPay extends Serializable {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes13.dex */
    public static final class Action {
        public static final /* synthetic */ Action[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Action CLOSE;
        public static final Action OPEN;
        public static final Action VERIFY;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(630410798, "Lcom/baidu/wallet/paysdk/fingerprint/IFingerprintPay$Action;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(630410798, "Lcom/baidu/wallet/paysdk/fingerprint/IFingerprintPay$Action;");
                    return;
                }
            }
            OPEN = new Action("OPEN", 0);
            CLOSE = new Action("CLOSE", 1);
            Action action = new Action("VERIFY", 2);
            VERIFY = action;
            $VALUES = new Action[]{OPEN, CLOSE, action};
        }

        public Action(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Action valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Action) Enum.valueOf(Action.class, str) : (Action) invokeL.objValue;
        }

        public static Action[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Action[]) $VALUES.clone() : (Action[]) invokeV.objValue;
        }
    }

    void close(Activity activity, FingerprintCallback fingerprintCallback);

    void closeFingerprint(Context context);

    void destory();

    void open(Activity activity, FingerprintCallback fingerprintCallback, boolean z);

    void verify(Activity activity, FingerprintCallback fingerprintCallback);
}
