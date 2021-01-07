package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
/* loaded from: classes4.dex */
public class aq {

    /* renamed from: a  reason: collision with root package name */
    private static volatile String f6082a = null;

    public static String a(Context context, cn cnVar) {
        if (TextUtils.isEmpty(f6082a)) {
            synchronized (aq.class) {
                if (!TextUtils.isEmpty(f6082a)) {
                    return f6082a;
                }
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
                String id = advertisingIdInfo != null ? advertisingIdInfo.getId() : null;
                if (TextUtils.isEmpty(id)) {
                    id = cnVar.epI().getString("google_aid", null);
                } else if (!TextUtils.equals(cnVar.epI().getString("google_aid", null), id)) {
                    a(context, id, cnVar);
                }
                f6082a = id;
            }
        }
        return f6082a;
    }

    private static void a(Context context, String str, cn cnVar) {
        if (!TextUtils.isEmpty(str) && context != null) {
            cnVar.epI().edit().putString("google_aid", str).apply();
        }
    }
}
