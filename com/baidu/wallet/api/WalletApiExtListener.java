package com.baidu.wallet.api;

import android.app.Activity;
import android.content.Context;
import com.alipay.security.mobile.module.http.model.c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes10.dex */
public interface WalletApiExtListener {

    /* loaded from: classes10.dex */
    public interface LoginstatuSyncListener {
        void onHandleWalletError(int i2);

        void onWebViewLogout(Context context);

        void syncLoginStatus(Context context, String str, SyncLoginStatusCb syncLoginStatusCb);
    }

    /* loaded from: classes10.dex */
    public interface SensorsAdapter {
        void sendPerformanceInfo(Map<String, String> map);
    }

    /* loaded from: classes10.dex */
    public interface SyncLoginStatusCb {

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes10.dex */
        public static final class SyncResult {
            public static final /* synthetic */ SyncResult[] $VALUES;
            public static /* synthetic */ Interceptable $ic;
            public static final SyncResult BDUSSEMPTY;
            public static final SyncResult BDUSSEXPIRED;
            public static final SyncResult FAIL;
            public static final SyncResult SUCCESS;
            public transient /* synthetic */ FieldHolder $fh;
            public int val;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(200033995, "Lcom/baidu/wallet/api/WalletApiExtListener$SyncLoginStatusCb$SyncResult;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(200033995, "Lcom/baidu/wallet/api/WalletApiExtListener$SyncLoginStatusCb$SyncResult;");
                        return;
                    }
                }
                SUCCESS = new SyncResult(c.p, 0, 0);
                FAIL = new SyncResult("FAIL", 1, 1);
                BDUSSEMPTY = new SyncResult("BDUSSEMPTY", 2, 2);
                SyncResult syncResult = new SyncResult("BDUSSEXPIRED", 3, 3);
                BDUSSEXPIRED = syncResult;
                $VALUES = new SyncResult[]{SUCCESS, FAIL, BDUSSEMPTY, syncResult};
            }

            public SyncResult(String str, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        String str2 = (String) objArr2[0];
                        ((Integer) objArr2[1]).intValue();
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                        return;
                    }
                }
                this.val = i3;
            }

            public static SyncResult valueOf(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SyncResult) Enum.valueOf(SyncResult.class, str) : (SyncResult) invokeL.objValue;
            }

            public static SyncResult[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SyncResult[]) $VALUES.clone() : (SyncResult[]) invokeV.objValue;
            }

            public int getVal() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.val : invokeV.intValue;
            }
        }

        void onResult(SyncResult syncResult);
    }

    /* loaded from: classes10.dex */
    public interface ThirdPartyLoginInterface {
        void callBindPhone(Activity activity, ThirdPartyLoginListener thirdPartyLoginListener);

        void callTuristNormalize(Activity activity, ThirdPartyLoginListener thirdPartyLoginListener);
    }

    /* loaded from: classes10.dex */
    public interface ThirdPartyLoginListener {
        void onCallFail(int i2, String str);

        void onCallSuccess(int i2, String str);
    }
}
