package com.baidu.tieba.wallet;

import android.app.Activity;
import android.content.Context;
import com.baidu.adp.BdUniqueId;
import d.a.o0.l0.f;
import java.util.Map;
/* loaded from: classes4.dex */
public interface IWalletPlugin {
    void accessWalletEntry(Context context, String str);

    String doAliPay(Activity activity, String str, boolean z);

    void doAliPay(Activity activity, String str, BdUniqueId bdUniqueId);

    void doBaiduLBSPay(Activity activity, Map<String, String> map, String str, BdUniqueId bdUniqueId);

    void doBaiduNovelPay(Context context, String str);

    void doBaiduPay(Context context, String str, BdUniqueId bdUniqueId);

    void doBindCard(Context context, Map<String, String> map);

    ITiebaPay doTiebaPay(Activity activity);

    void doYYPay(f fVar);

    void gotoWalletService(Context context, String str);

    void init();

    void openH5Module(Context context, String str);

    void registerIntent();

    void startWallet(Context context);
}
