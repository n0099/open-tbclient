package com.baidu.wallet.paysdk.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.ui.PayTypeActivity;
import java.util.List;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static a f25376a;

    public static boolean a() {
        return !TextUtils.isEmpty(PayDataCache.getInstance().getPureSign());
    }

    public static boolean b() {
        return "1".equals(PayDataCache.getInstance().getPureSign());
    }

    public static boolean c() {
        return "0".equals(PayDataCache.getInstance().getPureSign());
    }

    public static void a(List<RestNameValuePair> list) {
        if (list == null) {
            return;
        }
        list.add(new RestNameValuePair("pure_sign", PayDataCache.getInstance().getPureSign()));
    }

    public static void a(Context context, a aVar) {
        f25376a = aVar;
        Intent intent = new Intent();
        intent.setClass(context, PayTypeActivity.class);
        if (!BaiduWalletUtils.isActivity(context)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }
}
