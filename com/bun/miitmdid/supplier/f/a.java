package com.bun.miitmdid.supplier.f;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Uri f26807a = Uri.parse("content://cn.nubia.identity/identity");

    public static String a(Context context, String str) {
        Bundle call;
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(f26807a);
                call = acquireUnstableContentProviderClient.call("getAAID", str, null);
                if (acquireUnstableContentProviderClient != null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        acquireUnstableContentProviderClient.close();
                    } else {
                        acquireUnstableContentProviderClient.release();
                    }
                }
            } else {
                call = context.getContentResolver().call(f26807a, "getAAID", str, (Bundle) null);
            }
            if (call.getInt("code", -1) == 0) {
                String string = call.getString("id");
                com.bun.miitmdid.utils.a.a("NubiaLog", "succeed:" + string);
                return string;
            }
            String string2 = call.getString("message");
            com.bun.miitmdid.utils.a.a("NubiaLog", "failed:" + string2);
            return string2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean a(Context context) {
        Bundle call;
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(f26807a);
                call = acquireUnstableContentProviderClient.call("isSupport", null, null);
                if (acquireUnstableContentProviderClient != null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        acquireUnstableContentProviderClient.close();
                    } else {
                        acquireUnstableContentProviderClient.release();
                    }
                }
            } else {
                call = context.getContentResolver().call(f26807a, "isSupport", (String) null, (Bundle) null);
            }
            if (call.getInt("code", -1) == 0) {
                com.bun.miitmdid.utils.a.a("NubiaLog", "succeed");
                return call.getBoolean("issupport", true);
            }
            String string = call.getString("message");
            com.bun.miitmdid.utils.a.a("NubiaLog", "failed:" + string);
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static String b(Context context) {
        Bundle call;
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(f26807a);
                call = acquireUnstableContentProviderClient.call("getOAID", null, null);
                if (acquireUnstableContentProviderClient != null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        acquireUnstableContentProviderClient.close();
                    } else {
                        acquireUnstableContentProviderClient.release();
                    }
                }
            } else {
                call = context.getContentResolver().call(f26807a, "getOAID", (String) null, (Bundle) null);
            }
            if (call.getInt("code", -1) == 0) {
                String string = call.getString("id");
                com.bun.miitmdid.utils.a.a("NubiaLog", "succeed:" + string);
                return string;
            }
            String string2 = call.getString("message");
            com.bun.miitmdid.utils.a.a("NubiaLog", "failed:" + string2);
            return string2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String b(Context context, String str) {
        Bundle bundle;
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(f26807a);
                bundle = acquireUnstableContentProviderClient.call("getVAID", str, null);
                if (acquireUnstableContentProviderClient != null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        acquireUnstableContentProviderClient.close();
                    } else {
                        acquireUnstableContentProviderClient.release();
                    }
                }
            } else {
                context.getContentResolver().call(f26807a, "getVAID", str, (Bundle) null);
                bundle = null;
            }
            if (bundle.getInt("code", -1) == 0) {
                String string = bundle.getString("id");
                com.bun.miitmdid.utils.a.a("NubiaLog", "succeed:" + string);
                return string;
            }
            String string2 = bundle.getString("message");
            com.bun.miitmdid.utils.a.a("NubiaLog", "failed:" + string2);
            return string2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
