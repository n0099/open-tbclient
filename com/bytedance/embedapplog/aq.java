package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
/* loaded from: classes6.dex */
public class aq {

    /* renamed from: a  reason: collision with root package name */
    private static volatile String f5784a = null;

    public static String a(Context context, cn cnVar) {
        if (TextUtils.isEmpty(f5784a)) {
            synchronized (aq.class) {
                if (!TextUtils.isEmpty(f5784a)) {
                    return f5784a;
                }
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
                String id = advertisingIdInfo != null ? advertisingIdInfo.getId() : null;
                if (TextUtils.isEmpty(id)) {
                    id = cnVar.eog().getString("google_aid", null);
                } else if (!TextUtils.equals(cnVar.eog().getString("google_aid", null), id)) {
                    a(context, id, cnVar);
                }
                f5784a = id;
            }
        }
        return f5784a;
    }

    private static void a(Context context, String str, cn cnVar) {
        if (!TextUtils.isEmpty(str) && context != null) {
            cnVar.eog().edit().putString("google_aid", str).apply();
        }
    }
}
