package com.baidu.wallet.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.bankdetection.BuildConfig;
import com.baidu.crabsdk.lite.CrabLite;
import com.baidu.wallet.base.statistics.StatSettings;
import com.baidu.wallet.core.DebugConfig;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.utils.LogUtil;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class CrabHelper {
    public static final String CRAB_TAG = "crab";

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f23165a = false;

    public static void b(Context context) {
        f23165a = true;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Class.forName("com.baidu.crabsdk.lite.CrabLite");
            try {
                System.currentTimeMillis();
                c(context);
                System.currentTimeMillis();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            LogUtil.d(CRAB_TAG, "crab init success with cost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        } catch (ClassNotFoundException unused) {
            LogUtil.d(CRAB_TAG, "crab lite sdk not package into wallet sdk (Try this only 1 time)");
        }
    }

    public static void c(Context context) {
        String str = BeanConstants.VERSION_NO;
        String str2 = BeanConstants.CHANNEL_ID;
        String str3 = PhoneUtils.getAppVersionCode(context) + "";
        String passUserName = WalletLoginHelper.getInstance().isLogin() ? WalletLoginHelper.getInstance().getPassUserName() : "";
        String str4 = TextUtils.isEmpty(passUserName) ? "" : passUserName;
        List<String> generateSDKPackageConcerned = generateSDKPackageConcerned();
        LogUtil.d(CRAB_TAG, "init crab with pkg size:" + generateSDKPackageConcerned.size());
        int i = 0;
        for (String str5 : generateSDKPackageConcerned) {
            long currentTimeMillis = System.currentTimeMillis();
            a(context, "e4ede3580390f467", str, str3, str5, str2, str4);
            StringBuilder sb = new StringBuilder();
            sb.append("init ");
            i++;
            sb.append(i);
            sb.append(" cost :");
            sb.append(System.currentTimeMillis() - currentTimeMillis);
            LogUtil.d(CRAB_TAG, sb.toString());
        }
        CrabLite.a("com.baidu.wallet");
    }

    public static List<String> generateSDKPackageConcerned() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("com.baidu.wallet");
        linkedList.add(BuildConfig.APPLICATION_ID);
        linkedList.add("com.baidu.android.pay");
        linkedList.add("com.baidu.apollon");
        linkedList.add("com.baidu.android.minipay");
        linkedList.add("com.baidu.android.lbspay");
        return linkedList;
    }

    public static void initCrab(final Context context) {
        if (StatSettings.getInstance(context).isEnableCrashHandler() && !f23165a) {
            new Thread(new Runnable() { // from class: com.baidu.wallet.api.CrabHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    LogUtil.d(CrabHelper.CRAB_TAG, "init in child thread");
                    CrabHelper.b(context);
                }
            }).start();
            return;
        }
        if (f23165a) {
            LogUtil.d(CRAB_TAG, "crab already init :" + f23165a);
        }
        if (StatSettings.getInstance(context).isEnableCrashHandler()) {
            return;
        }
        LogUtil.d(CRAB_TAG, "crab disabled ");
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        CrabLite.b(context, str, str4, str2, str3);
        CrabLite.h(str4, false);
        CrabLite.i(str4, !DebugConfig.getInstance().isOnline());
        CrabLite.j(str4, true);
        CrabLite.k(str4, true);
        CrabLite.n(str4, str6);
        Object[] objArr = new Object[2];
        objArr[0] = str4;
        WalletLoginHelper.getInstance().dynamicCallPass(CrabLite.class, objArr, 26, 1, "setUid", new Class[]{String.class, String.class});
        CrabLite.f(str4, str5);
        CrabLite.m(str4, -1);
        CrabLite.l(str4, -1);
        CrabLite.o(str4, "Environment", DebugConfig.getInstance().getEnvironment());
        CrabLite.o(str4, "Server", DebugConfig.getInstance().getWalletHttpsHost());
        CrabLite.o(str4, "appVersionName", PhoneUtils.getAppVersionName(context));
        CrabLite.o(str4, "appVersionCode", PhoneUtils.getAppVersionCode(context) + "");
    }
}
