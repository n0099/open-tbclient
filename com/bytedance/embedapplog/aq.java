package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
/* loaded from: classes4.dex */
public class aq {

    /* renamed from: a  reason: collision with root package name */
    private static volatile String f5782a = null;

    public static String a(Context context, cn cnVar) {
        if (TextUtils.isEmpty(f5782a)) {
            synchronized (aq.class) {
                if (!TextUtils.isEmpty(f5782a)) {
                    return f5782a;
                }
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
                String id = advertisingIdInfo != null ? advertisingIdInfo.getId() : null;
                if (TextUtils.isEmpty(id)) {
                    id = cnVar.elM().getString("google_aid", null);
                } else if (!TextUtils.equals(cnVar.elM().getString("google_aid", null), id)) {
                    a(context, id, cnVar);
                }
                f5782a = id;
            }
        }
        return f5782a;
    }

    private static void a(Context context, String str, cn cnVar) {
        if (!TextUtils.isEmpty(str) && context != null) {
            cnVar.elM().edit().putString("google_aid", str).apply();
        }
    }
}
