package com.baidu.wallet.util;

import android.text.TextUtils;
import com.baidu.mobads.container.config.AppConfigImp;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class StatHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class Key {
        public static final /* synthetic */ Key[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Key channelId;
        public static final Key fromPkg;
        public static final Key hasPwd;
        public static final Key orderId;
        public static final Key orderNo;
        public static final Key passLoginStatus;
        public static final Key payAmount;
        public static final Key payType;
        public static final Key payWay;
        public static final Key precashierMark;
        public static final Key sessionId;
        public static final Key spNo;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-262641031, "Lcom/baidu/wallet/util/StatHelper$Key;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-262641031, "Lcom/baidu/wallet/util/StatHelper$Key;");
                    return;
                }
            }
            orderNo = new Key("orderNo", 0);
            spNo = new Key("spNo", 1);
            fromPkg = new Key("fromPkg", 2);
            hasPwd = new Key("hasPwd", 3);
            payType = new Key("payType", 4);
            payWay = new Key("payWay", 5);
            orderId = new Key("orderId", 6);
            channelId = new Key(AppConfigImp.KEY_CHANNELID, 7);
            passLoginStatus = new Key("passLoginStatus", 8);
            sessionId = new Key("sessionId", 9);
            payAmount = new Key("payAmount", 10);
            Key key = new Key("precashierMark", 11);
            precashierMark = key;
            $VALUES = new Key[]{orderNo, spNo, fromPkg, hasPwd, payType, payWay, orderId, channelId, passLoginStatus, sessionId, payAmount, key};
        }

        public Key(String str, int i2) {
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

        public static Key valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Key) Enum.valueOf(Key.class, str) : (Key) invokeL.objValue;
        }

        public static Key[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Key[]) $VALUES.clone() : (Key[]) invokeV.objValue;
        }
    }

    public StatHelper() {
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

    public static void cacheChannelId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            a.a(Key.channelId.name(), str);
        }
    }

    public static void cacheFromPkg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            a.a(Key.fromPkg.name(), str);
        }
    }

    public static void cacheHasPwd(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, null, z) == null) {
            a.a(Key.hasPwd.name(), z ? "1" : "0");
        }
    }

    public static void cacheOrderId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, null, str) == null) {
            a.a(Key.orderId.name(), str);
        }
    }

    public static void cacheOrderNo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) {
            a.a(Key.orderNo.name(), str);
        }
    }

    public static void cachePassLoginStatus(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str) == null) {
            a.a(Key.passLoginStatus.name(), str);
        }
    }

    public static void cachePayAmount(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Double.valueOf(d2)}) == null) {
            a.a(Key.payAmount.name(), Double.valueOf(d2));
        }
    }

    public static void cachePayType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, null, i2) == null) {
            a.a(Key.payType.name(), String.valueOf(i2));
        }
    }

    public static void cachePayWay(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65545, null, i2) == null) {
            a.a(Key.payWay.name(), String.valueOf(i2));
        }
    }

    public static void cacheSessionId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            a.a(Key.sessionId.name(), str);
        }
    }

    public static void cacheSpNo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            a.a(Key.spNo.name(), str);
        }
    }

    public static void clearPay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            a.a(Key.payWay.name(), null);
            a.a(Key.payType.name(), null);
            a.a(Key.hasPwd.name(), null);
        }
    }

    public static List<String> collectData(String str, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, str, strArr)) == null) {
            ArrayList arrayList = new ArrayList();
            if (str != null) {
                arrayList.add(str);
            }
            for (String str2 : strArr) {
                arrayList.add(str2);
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static String getChannelId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? (String) a.a(Key.channelId.name()) : (String) invokeV.objValue;
    }

    public static String getFromPkg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? (String) a.a(Key.fromPkg.name()) : (String) invokeV.objValue;
    }

    public static String getHasPwd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? (String) a.a(Key.hasPwd.name()) : (String) invokeV.objValue;
    }

    public static String getOrderId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? (String) a.a(Key.orderId.name()) : (String) invokeV.objValue;
    }

    public static String getOrderNo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return com.baidu.wallet.base.a.a.a(str, "order_no");
        }
        return (String) invokeL.objValue;
    }

    public static String getPassLoginStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? (String) a.a(Key.passLoginStatus.name()) : (String) invokeV.objValue;
    }

    public static String getPayAmount(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return com.baidu.wallet.base.a.a.a(str, "total_amount");
        }
        return (String) invokeL.objValue;
    }

    public static String getPayType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) ? (String) a.a(Key.payType.name()) : (String) invokeV.objValue;
    }

    public static String getPayWay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) ? (String) a.a(Key.payWay.name()) : (String) invokeV.objValue;
    }

    public static String getSessionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) ? (String) a.a(Key.sessionId.name()) : (String) invokeV.objValue;
    }

    public static String getSpNo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65563, null, str)) == null) ? com.baidu.wallet.base.a.a.a(str, PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID) : (String) invokeL.objValue;
    }

    public static boolean isPrecashierPay(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.equals(a.a(Key.precashierMark.name()));
        }
        return invokeL.booleanValue;
    }

    public static void setPrecashierMark(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65565, null, str) == null) {
            a.a(Key.precashierMark.name(), str);
        }
    }

    public static String getSpNo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) ? (String) a.a(Key.spNo.name()) : (String) invokeV.objValue;
    }

    public static String getOrderNo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? (String) a.a(Key.orderNo.name()) : (String) invokeV.objValue;
    }

    public static Double getPayAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? (Double) a.a(Key.payAmount.name()) : (Double) invokeV.objValue;
    }
}
