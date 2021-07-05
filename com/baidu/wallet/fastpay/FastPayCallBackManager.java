package com.baidu.wallet.fastpay;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.fastpay.datamodel.QueryLocationResponse;
import com.baidu.wallet.fastpay.datamodel.SimpleOrderInfo;
import com.baidu.wallet.fastpay.sdk.a;
import java.io.Serializable;
/* loaded from: classes6.dex */
public final class FastPayCallBackManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class PayStateContent implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 8703238535820968744L;
        public transient /* synthetic */ FieldHolder $fh;
        public String notify;
        public String order_no;

        public PayStateContent() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.notify = "";
            this.order_no = "";
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "PayStateContent [notify=" + this.notify + ", order_no=" + this.order_no + PreferencesUtil.RIGHT_MOUNT;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class PayStateModle implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int PAY_STATUS_CANCEL = 2;
        public static final int PAY_STATUS_PAYING = 3;
        public static final int PAY_STATUS_SUCCESS = 1;
        public static final long serialVersionUID = 393136306694361260L;
        public transient /* synthetic */ FieldHolder $fh;
        public PayStateContent content;
        public SimpleOrderInfo orderInfo;
        public int statecode;

        public PayStateModle() {
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

    public static void a(int i2, int i3, SimpleOrderInfo simpleOrderInfo, PayStateContent payStateContent) {
        a.b a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), simpleOrderInfo, payStateContent}) == null) || (a2 = a.a().a(i2)) == null) {
            return;
        }
        a2.onFastPaySuccess(i2, 1, a(i3, simpleOrderInfo, payStateContent));
        a.a().b(i2);
    }

    public static void a(int i2, Object obj) {
        a.b a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65539, null, i2, obj) == null) || (a2 = a.a().a(i2)) == null) {
            return;
        }
        a2.onFastPaySuccess(i2, 0, obj);
        if (obj instanceof QueryLocationResponse) {
            a.a().b(i2);
        }
    }

    public static void a(int i2, int i3, int i4, String str, SimpleOrderInfo simpleOrderInfo) {
        a.b a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, simpleOrderInfo}) == null) || (a2 = a.a().a(i2)) == null) {
            return;
        }
        a2.onFastPayFail(i2, i3, new a.C0263a(i4, str, simpleOrderInfo));
        a.a().b(i2);
    }

    public static PayStateModle a(int i2, SimpleOrderInfo simpleOrderInfo, PayStateContent payStateContent) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65536, null, i2, simpleOrderInfo, payStateContent)) == null) {
            PayStateModle payStateModle = new PayStateModle();
            payStateModle.orderInfo = simpleOrderInfo;
            payStateContent.order_no = simpleOrderInfo.mOrderNo;
            payStateModle.content = payStateContent;
            payStateModle.statecode = i2;
            return payStateModle;
        }
        return (PayStateModle) invokeILL.objValue;
    }
}
