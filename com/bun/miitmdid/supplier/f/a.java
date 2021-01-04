package com.bun.miitmdid.supplier.f;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Uri f6046a = Uri.parse("content://cn.nubia.identity/identity");

    public static String a(Context context, String str) {
        String str2;
        Bundle call;
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(f6046a);
                call = acquireUnstableContentProviderClient.call("getAAID", str, null);
                if (acquireUnstableContentProviderClient != null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        acquireUnstableContentProviderClient.close();
                    } else {
                        acquireUnstableContentProviderClient.release();
                    }
                }
            } else {
                call = context.getContentResolver().call(f6046a, "getAAID", str, (Bundle) null);
            }
            if (call.getInt("code", -1) == 0) {
                String string = call.getString("id");
                com.bun.miitmdid.utils.a.a("NubiaLog", "succeed:" + string);
                return string;
            }
            str2 = call.getString("message");
            try {
                com.bun.miitmdid.utils.a.a("NubiaLog", "failed:" + str2);
                return str2;
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                return str2;
            }
        } catch (Exception e2) {
            e = e2;
            str2 = null;
        }
    }

    public static boolean a(Context context) {
        Bundle call;
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(f6046a);
                call = acquireUnstableContentProviderClient.call("isSupport", null, null);
                if (acquireUnstableContentProviderClient != null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        acquireUnstableContentProviderClient.close();
                    } else {
                        acquireUnstableContentProviderClient.release();
                    }
                }
            } else {
                call = context.getContentResolver().call(f6046a, "isSupport", (String) null, (Bundle) null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (call.getInt("code", -1) == 0) {
            com.bun.miitmdid.utils.a.a("NubiaLog", "succeed");
            return call.getBoolean("issupport", true);
        }
        com.bun.miitmdid.utils.a.a("NubiaLog", "failed:" + call.getString("message"));
        return false;
    }

    public static String b(Context context) {
        String str;
        Bundle call;
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(f6046a);
                call = acquireUnstableContentProviderClient.call("getOAID", null, null);
                if (acquireUnstableContentProviderClient != null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        acquireUnstableContentProviderClient.close();
                    } else {
                        acquireUnstableContentProviderClient.release();
                    }
                }
            } else {
                call = context.getContentResolver().call(f6046a, "getOAID", (String) null, (Bundle) null);
            }
            if (call.getInt("code", -1) == 0) {
                String string = call.getString("id");
                com.bun.miitmdid.utils.a.a("NubiaLog", "succeed:" + string);
                return string;
            }
            str = call.getString("message");
            try {
                com.bun.miitmdid.utils.a.a("NubiaLog", "failed:" + str);
                return str;
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                return str;
            }
        } catch (Exception e2) {
            e = e2;
            str = null;
        }
    }

    public static String b(Context context, String str) {
        String str2;
        Bundle bundle;
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(f6046a);
                bundle = acquireUnstableContentProviderClient.call("getVAID", str, null);
                if (acquireUnstableContentProviderClient != null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        acquireUnstableContentProviderClient.close();
                    } else {
                        acquireUnstableContentProviderClient.release();
                    }
                }
            } else {
                context.getContentResolver().call(f6046a, "getVAID", str, (Bundle) null);
                bundle = null;
            }
            if (bundle.getInt("code", -1) == 0) {
                String string = bundle.getString("id");
                com.bun.miitmdid.utils.a.a("NubiaLog", "succeed:" + string);
                return string;
            }
            str2 = bundle.getString("message");
            try {
                com.bun.miitmdid.utils.a.a("NubiaLog", "failed:" + str2);
                return str2;
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                return str2;
            }
        } catch (Exception e2) {
            e = e2;
            str2 = null;
        }
    }
}
