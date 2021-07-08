package com.baidu.wallet.api;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.pay.BindBack;
import com.baidu.android.pay.PayCallBack;
import com.baidu.wallet.rnauth.RNAuthCallBack;
import java.util.Map;
/* loaded from: classes5.dex */
public interface IWalletPayFacade {
    void accessWalletEntry(Context context, String str);

    void changePayMethod(Activity activity, String str, IPrecashierCallback iPrecashierCallback);

    void checkPwd(Context context, CheckCallBack checkCallBack);

    void doBind(Context context, BindBack bindBack, Map<String, String> map);

    void doBindCardIndependent(Context context, BindBack bindBack, String str);

    void doCheckPwd(Context context, Map<String, String> map, CheckCallBack checkCallBack);

    void doPay(Context context, String str, PayCallBack payCallBack);

    void doPay(Context context, String str, PayCallBack payCallBack, @NonNull Map<String, String> map);

    void doRNAuth(Context context, Map<String, String> map, RNAuthCallBack rNAuthCallBack);

    void getPayMethod(Context context, String str, @NonNull IPrecashierCallback iPrecashierCallback);

    String getWalletOuterInterface(Context context, IWalletOuterInterfaceListener iWalletOuterInterfaceListener);

    void preOrderPay(Context context, String str, IPrecashierCallback iPrecashierCallback);
}
