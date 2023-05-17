package com.bytedance.pangle.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;
/* loaded from: classes8.dex */
public final class a {
    public static int a(ContentResolver contentResolver, Uri uri, ContentValues contentValues, String str, String[] strArr, String str2) {
        if (contentResolver == null) {
            return 0;
        }
        try {
            try {
                return contentResolver.update(a(uri, str2), contentValues, str, strArr);
            } catch (Throwable th) {
                ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#update throw exception:", th);
                return 0;
            }
        } catch (IllegalArgumentException unused) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute update !!!");
            return contentResolver.update(uri, contentValues, str, strArr);
        } catch (Exception e) {
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#update throw exception:", e);
            return 0;
        }
    }

    public static int a(ContentResolver contentResolver, Uri uri, Bundle bundle, String str) {
        if (contentResolver == null) {
            return -1;
        }
        try {
            try {
                return contentResolver.delete(a(uri, str), bundle);
            } catch (Throwable th) {
                ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#delete throw exception:", th);
                return -1;
            }
        } catch (IllegalArgumentException unused) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute delete !!!");
            return contentResolver.delete(uri, bundle);
        } catch (Exception e) {
            e = e;
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#delete throw exception:", e);
            return -1;
        } catch (IncompatibleClassChangeError e2) {
            e = e2;
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#delete throw exception:", e);
            return -1;
        }
    }

    public static int a(ContentResolver contentResolver, Uri uri, String str, String[] strArr, String str2) {
        if (contentResolver == null) {
            return -1;
        }
        try {
            try {
                return contentResolver.delete(a(uri, str2), str, strArr);
            } catch (Throwable th) {
                ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#delete throw exception:", th);
                return -1;
            }
        } catch (IllegalArgumentException unused) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute delete !!!");
            return contentResolver.delete(uri, str, strArr);
        } catch (Exception e) {
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#delete throw exception:", e);
            return -1;
        }
    }

    public static int b(ContentResolver contentResolver, Uri uri, ContentValues contentValues, Bundle bundle, String str) {
        if (contentResolver == null) {
            return 0;
        }
        try {
            try {
                return contentResolver.update(a(uri, str), contentValues, bundle);
            } catch (Throwable th) {
                ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#update throw exception:", th);
                return 0;
            }
        } catch (IllegalArgumentException unused) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute update !!!");
            return contentResolver.update(uri, contentValues, bundle);
        } catch (Exception e) {
            e = e;
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#update throw exception:", e);
            return 0;
        } catch (IncompatibleClassChangeError e2) {
            e = e2;
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#update throw exception:", e);
            return 0;
        }
    }

    @RequiresApi(api = 26)
    public static Cursor a(ContentResolver contentResolver, Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal, String str) {
        if (contentResolver == null) {
            return null;
        }
        try {
            try {
                return contentResolver.query(a(uri, str), strArr, bundle, cancellationSignal);
            } catch (Throwable th) {
                ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "not found host provider-ContentProviderManager#query(4 params) throw exception:", th);
                return null;
            }
        } catch (IllegalArgumentException unused) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute query(5 params) !!!");
            return contentResolver.query(uri, strArr, bundle, cancellationSignal);
        } catch (Exception e) {
            e = e;
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#query(4 params) throw exception:", e);
            return null;
        } catch (IncompatibleClassChangeError e2) {
            e = e2;
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#query(4 params) throw exception:", e);
            return null;
        }
    }

    @RequiresApi(api = 16)
    public static Cursor a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal, String str3) {
        if (contentResolver == null) {
            return null;
        }
        try {
            try {
                return contentResolver.query(a(uri, str3), strArr, str, strArr2, str2, cancellationSignal);
            } catch (Throwable th) {
                ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "not found host provider-ContentProviderManager#query(6 params) throw exception:", th);
                return null;
            }
        } catch (IllegalArgumentException unused) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute query(6 params) !!!");
            return contentResolver.query(uri, strArr, str, strArr2, str2, cancellationSignal);
        } catch (Exception e) {
            e = e;
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#query(6 params) throw exception:", e);
            return null;
        } catch (IncompatibleClassChangeError e2) {
            e = e2;
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#query(6 params) throw exception:", e);
            return null;
        }
    }

    public static Cursor a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, String str3) {
        if (contentResolver == null) {
            return null;
        }
        try {
            try {
                return contentResolver.query(a(uri, str3), strArr, str, strArr2, str2);
            } catch (Throwable th) {
                ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "not found host provider-ContentProviderManager#query(5 params) throw exception:", th);
                return null;
            }
        } catch (IllegalArgumentException unused) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute query(5 params) !!!");
            return contentResolver.query(uri, strArr, str, strArr2, str2);
        } catch (Exception e) {
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#query(5 params) throw exception:", e);
            return null;
        }
    }

    public static Uri a(ContentResolver contentResolver, Uri uri, ContentValues contentValues, Bundle bundle, String str) {
        if (contentResolver == null) {
            return null;
        }
        try {
            try {
                return contentResolver.insert(a(uri, str), contentValues, bundle);
            } catch (Throwable th) {
                ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "not found host provider-ContentProviderManager#insert throw exception:", th);
                return null;
            }
        } catch (IllegalArgumentException unused) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute insert !!!");
            return contentResolver.insert(uri, contentValues, bundle);
        } catch (Exception e) {
            e = e;
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#insert throw exception:", e);
            return null;
        } catch (IncompatibleClassChangeError e2) {
            e = e2;
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#insert throw exception:", e);
            return null;
        }
    }

    public static Uri a(ContentResolver contentResolver, Uri uri, ContentValues contentValues, String str) {
        if (contentResolver == null) {
            return null;
        }
        try {
            try {
                return contentResolver.insert(a(uri, str), contentValues);
            } catch (Throwable th) {
                ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "not found host provider-ContentProviderManager#insert throw exception:", th);
                return null;
            }
        } catch (IllegalArgumentException unused) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute insert !!!");
            return contentResolver.insert(uri, contentValues);
        } catch (Exception e) {
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#insert throw exception:", e);
            return null;
        }
    }

    public static Uri a(Uri uri, String str) {
        if (ContentProviderManager.getInstance().isPluginProvider(uri)) {
            Uri a = a(str, uri, (String) null);
            ZeusLogger.d(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#buildProxyUri-->proxyUri=".concat(String.valueOf(a)));
            return a;
        }
        return uri;
    }

    public static Uri a(String str, Uri uri, String str2) {
        String encodeToString;
        ContentProviderManager contentProviderManager = ContentProviderManager.getInstance();
        if (uri != null) {
            str2 = uri.getAuthority();
        }
        String pluginProcessNameByAuthority = contentProviderManager.getPluginProcessNameByAuthority(str2);
        String a = b.a(pluginProcessNameByAuthority, str, uri);
        if (TextUtils.isEmpty(a)) {
            encodeToString = "";
        } else {
            encodeToString = Base64.encodeToString(a.getBytes(), 10);
        }
        String str3 = ContentProviderManager.getInstance().getSystemProviderInfoMap().get(pluginProcessNameByAuthority).b;
        Uri parse = Uri.parse("content://" + str3 + File.separator + "proxy?provider_params=" + encodeToString);
        ZeusLogger.d(ZeusLogger.TAG_PROVIDER, "进程[processName=" + pluginProcessNameByAuthority + "] build provider 【 uri:" + parse + " 】");
        return parse;
    }

    public static Bundle a(ContentResolver contentResolver, Uri uri, String str, String str2, Bundle bundle, String str3) {
        if (contentResolver != null && uri != null) {
            try {
                try {
                    Uri a = a(uri, str3);
                    if (bundle == null) {
                        bundle = new Bundle();
                    }
                    bundle.putString("provider_params", uri.getAuthority());
                    bundle.putString(ContentProviderManager.PROVIDER_PROXY_URI, a.toString());
                    return contentResolver.call(a, str, str2, bundle);
                } catch (Throwable th) {
                    ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#call throw exception:", th);
                }
            } catch (IllegalArgumentException unused) {
                ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute call !!!");
                return contentResolver.call(uri, str, str2, bundle);
            } catch (Exception e) {
                e = e;
                ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#call throw exception:", e);
                return null;
            } catch (IncompatibleClassChangeError e2) {
                e = e2;
                ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#call throw exception:", e);
                return null;
            }
        }
        return null;
    }

    public static Bundle a(ContentResolver contentResolver, String str, String str2, String str3, Bundle bundle, String str4) {
        if (contentResolver == null) {
            return null;
        }
        String str5 = ContentProviderManager.getInstance().getSystemProviderInfoMap().get(ContentProviderManager.getInstance().getPluginProcessNameByAuthority(str)).b;
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("provider_params", str);
        bundle.putString(ContentProviderManager.PROVIDER_PROXY_URI, a(str4, (Uri) null, str).toString());
        try {
            try {
                return contentResolver.call(str5, str2, str3, bundle);
            } catch (Throwable th) {
                ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#call throw exception:", th);
                return null;
            }
        } catch (IllegalArgumentException unused) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute call !!!");
            return contentResolver.call(str, str2, str3, bundle);
        } catch (Exception e) {
            e = e;
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#call throw exception:", e);
            return null;
        } catch (IncompatibleClassChangeError e2) {
            e = e2;
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#call throw exception:", e);
            return null;
        }
    }

    public static String a(ContentResolver contentResolver, Uri uri, String str) {
        if (contentResolver == null) {
            return null;
        }
        try {
            try {
                return contentResolver.getType(a(uri, str));
            } catch (Throwable th) {
                ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "not found host provider-ContentProviderManager#getType throw exception:", th);
                return null;
            }
        } catch (IllegalArgumentException unused) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute getType !!!");
            return contentResolver.getType(uri);
        } catch (Exception e) {
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#getType throw exception:", e);
            return null;
        }
    }
}
