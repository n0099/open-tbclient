package com.baidu.wallet.paysdk.payresult.adapters;

import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.api.BaiduPay;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes5.dex */
public class a {
    public static IPayResultDataAdapter a(BaseActivity baseActivity, int i2) {
        try {
        } catch (Throwable th) {
            LogUtil.d(th.getMessage());
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
                    try {
                        try {
                            return (IPayResultDataAdapter) Class.forName("com.baidu.wallet.paysdk.payresult.adapters.TransferRecvResultAdapter").getConstructor(BaseActivity.class).newInstance(baseActivity);
                        } catch (InvocationTargetException e2) {
                            e2.printStackTrace();
                            return null;
                        }
                    } catch (ClassNotFoundException e3) {
                        e3.printStackTrace();
                        return null;
                    }
                } catch (NoSuchMethodException e4) {
                    e4.printStackTrace();
                    return null;
                }
            } catch (IllegalAccessException e5) {
                e5.printStackTrace();
                return null;
            } catch (InstantiationException e6) {
                e6.printStackTrace();
                return null;
            }
        }
        return new PayResultAdapter(baseActivity);
    }

    public static IPayResultDataAdapter a(BaseActivity baseActivity, String str) {
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
            LogUtil.d(e2.getMessage());
            return null;
        }
    }
}
