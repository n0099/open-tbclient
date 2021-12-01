package com.baidu.wallet.paysdk.payresult.adapters;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.dxmpay.wallet.core.BaseActivity;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes12.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static IPayResultDataAdapter a(BaseActivity baseActivity, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, baseActivity, i2)) == null) {
            try {
            } catch (Throwable th) {
                th.getMessage();
            }
            if (i2 != 1) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 == 5) {
                            return new HCEPayResultAdapter(baseActivity);
                        }
                        return null;
                    }
                    return new SignContractPayResultAdapter(baseActivity);
                }
                try {
                    try {
                        return (IPayResultDataAdapter) Class.forName("com.baidu.wallet.paysdk.payresult.adapters.TransferRecvResultAdapter").getConstructor(BaseActivity.class).newInstance(baseActivity);
                    } catch (InstantiationException e2) {
                        e2.printStackTrace();
                        return null;
                    } catch (InvocationTargetException e3) {
                        e3.printStackTrace();
                        return null;
                    }
                } catch (ClassNotFoundException e4) {
                    e4.printStackTrace();
                    return null;
                } catch (IllegalAccessException e5) {
                    e5.printStackTrace();
                    return null;
                } catch (NoSuchMethodException e6) {
                    e6.printStackTrace();
                    return null;
                }
            }
            return new PayResultAdapter(baseActivity);
        }
        return (IPayResultDataAdapter) invokeLI.objValue;
    }

    public static IPayResultDataAdapter a(BaseActivity baseActivity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, baseActivity, str)) == null) {
            try {
                if (BaiduPay.PAY_FROM_BIND_CARD.equalsIgnoreCase(str)) {
                    return new ActivieBindCardResultAdapter(baseActivity);
                }
                if (BaiduPay.PAY_FROM_HUA_FEI.equalsIgnoreCase(str)) {
                    return new FastPayResultAdapter(baseActivity);
                }
                if (BaiduPay.PAY_FROM_HUA_ZHUAN_ZHANG.equalsIgnoreCase(str)) {
                    return new TransferResultAdapter(baseActivity);
                }
                if (BaiduPay.PAY_FROM_TRAFFIC.equalsIgnoreCase(str)) {
                    return new TrafficPayResultAdapter(baseActivity);
                }
                if (BaiduPay.PAY_FROM_NFC_BUSCARD_CHARGE.equalsIgnoreCase(str)) {
                    return new BusCardPayResultAdapter(baseActivity);
                }
                return null;
            } catch (Exception e2) {
                e2.getMessage();
                return null;
            }
        }
        return (IPayResultDataAdapter) invokeLL.objValue;
    }
}
