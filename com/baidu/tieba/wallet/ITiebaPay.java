package com.baidu.tieba.wallet;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes8.dex */
public interface ITiebaPay {
    String getWalletUa();

    void onPayResult(String str, String str2, Context context, boolean z);

    void pay(String str, HashMap<String, String> hashMap, ITiebaPayCallback iTiebaPayCallback);

    void release();
}
