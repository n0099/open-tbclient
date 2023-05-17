package com.bytedance.pangle.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.provider.ContentProviderManager;
import org.json.JSONObject;
@Keep
/* loaded from: classes8.dex */
public class ContentProviderProxy extends ContentProvider {
    public ContentProviderManager mPluginProviderManager;

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.mPluginProviderManager = ContentProviderManager.getInstance();
        return true;
    }

    private PluginContentProvider obtainPluginProvider(Uri uri, String str) {
        return obtainPluginProvider(uri, str, null);
    }

    private PluginContentProvider obtainPluginProvider(Uri uri, String str, String str2) {
        String queryParameter = uri.getQueryParameter("provider_params");
        Uri uri2 = null;
        if (queryParameter == null) {
            return null;
        }
        if (!TextUtils.isEmpty(queryParameter)) {
            if (TextUtils.isEmpty(queryParameter)) {
                queryParameter = "";
            } else {
                queryParameter = new String(Base64.decode(queryParameter, 10));
            }
        }
        JSONObject jSONObject = new JSONObject(queryParameter);
        String optString = jSONObject.optString(ContentProviderManager.PLUGIN_PROCESS_NAME);
        String optString2 = jSONObject.optString("plugin_pkg_name");
        String optString3 = jSONObject.optString("uri");
        Zeus.loadPlugin(optString2);
        if (!TextUtils.isEmpty(optString3)) {
            uri2 = Uri.parse(optString3);
            str2 = uri2.getAuthority();
        }
        if (str2 == null) {
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "[Method:obtainPluginProvider()] plugin Authority is null !!! plugin provider can not find !!");
        }
        PluginContentProvider pluginProvider = this.mPluginProviderManager.getPluginProvider(new ContentProviderManager.b(optString2, optString, str2));
        pluginProvider.pluginUri = uri2;
        return pluginProvider;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Bundle call(@NonNull String str, @Nullable String str2, @Nullable Bundle bundle) {
        try {
            String string = bundle.getString("provider_params", "");
            Uri parse = Uri.parse(bundle.getString(ContentProviderManager.PROVIDER_PROXY_URI, ""));
            PluginContentProvider obtainPluginProvider = obtainPluginProvider(parse, parse.getAuthority(), string);
            if (obtainPluginProvider != null) {
                return obtainPluginProvider.call(str, str2, bundle);
            }
            return null;
        } catch (Throwable th) {
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "proxy provider#call(3 params) className=" + getClass().getSimpleName() + ",exception:", th);
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        if (uri == null) {
            return -1;
        }
        try {
            PluginContentProvider obtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority());
            if (obtainPluginProvider != null) {
                return obtainPluginProvider.delete(obtainPluginProvider.pluginUri, str, strArr);
            }
        } catch (Throwable th) {
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "proxy provider#delete(3 params) className=" + getClass().getSimpleName() + ",exception:", th);
        }
        return -1;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable Bundle bundle) {
        if (uri == null) {
            return null;
        }
        try {
            PluginContentProvider obtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority());
            if (obtainPluginProvider != null) {
                return obtainPluginProvider.insert(obtainPluginProvider.pluginUri, contentValues, bundle);
            }
        } catch (Throwable th) {
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "proxy provider#insert(3 params) className=" + getClass().getSimpleName() + ",exception:", th);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable Bundle bundle) {
        if (uri == null) {
            return 0;
        }
        try {
            PluginContentProvider obtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority());
            if (obtainPluginProvider != null) {
                return obtainPluginProvider.update(obtainPluginProvider.pluginUri, contentValues, bundle);
            }
        } catch (Throwable th) {
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "proxy provider#update(3 params) className=" + getClass().getSimpleName() + ",exception:", th);
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Bundle call(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable Bundle bundle) {
        try {
            String string = bundle.getString("provider_params", "");
            Uri parse = Uri.parse(bundle.getString(ContentProviderManager.PROVIDER_PROXY_URI, ""));
            PluginContentProvider obtainPluginProvider = obtainPluginProvider(parse, parse.getAuthority(), string);
            if (obtainPluginProvider != null) {
                return obtainPluginProvider.call(string, str2, str3, bundle);
            }
            return null;
        } catch (Throwable th) {
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "proxy provider#call(4 params-Added in API level 29) className=" + getClass().getSimpleName() + ",exception:", th);
            return null;
        }
    }

    @Override // android.content.ContentProvider
    @Nullable
    @RequiresApi(api = 26)
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable Bundle bundle, @Nullable CancellationSignal cancellationSignal) {
        if (uri == null) {
            return null;
        }
        try {
            PluginContentProvider obtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority());
            if (obtainPluginProvider != null) {
                return obtainPluginProvider.query(obtainPluginProvider.pluginUri, strArr, bundle, cancellationSignal);
            }
        } catch (Throwable th) {
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "proxy provider#query(4 params) className=" + getClass().getSimpleName() + ",exception:", th);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        if (uri == null) {
            return 0;
        }
        try {
            PluginContentProvider obtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority());
            if (obtainPluginProvider != null) {
                return obtainPluginProvider.update(obtainPluginProvider.pluginUri, contentValues, str, strArr);
            }
        } catch (Throwable th) {
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "proxy provider#update(4 params) className=" + getClass().getSimpleName() + ",exception:", th);
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable Bundle bundle) {
        if (uri == null) {
            return -1;
        }
        try {
            PluginContentProvider obtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority());
            if (obtainPluginProvider != null) {
                return obtainPluginProvider.delete(obtainPluginProvider.pluginUri, bundle);
            }
        } catch (Throwable th) {
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "proxy provider#delete(2 params) className=" + getClass().getSimpleName() + ",exception:", th);
        }
        return -1;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        if (uri == null) {
            return null;
        }
        try {
            PluginContentProvider obtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority());
            if (obtainPluginProvider != null) {
                return obtainPluginProvider.insert(obtainPluginProvider.pluginUri, contentValues);
            }
        } catch (Throwable th) {
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "proxy provider#insert(2 params) className=" + getClass().getSimpleName() + ",exception:", th);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        if (uri == null) {
            return null;
        }
        try {
            PluginContentProvider obtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority());
            if (obtainPluginProvider != null) {
                return obtainPluginProvider.getType(obtainPluginProvider.pluginUri);
            }
        } catch (Throwable th) {
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "proxy provider#getType className=" + getClass().getSimpleName() + ",exception:", th);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        if (uri == null) {
            return null;
        }
        try {
            PluginContentProvider obtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority());
            if (obtainPluginProvider != null) {
                return obtainPluginProvider.query(obtainPluginProvider.pluginUri, strArr, str, strArr2, str2);
            }
        } catch (Throwable th) {
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "proxy provider#query(5 params) className=" + getClass().getSimpleName() + ",exception:", th);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2, @Nullable CancellationSignal cancellationSignal) {
        if (uri == null) {
            return null;
        }
        try {
            PluginContentProvider obtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority());
            if (obtainPluginProvider != null) {
                return obtainPluginProvider.query(obtainPluginProvider.pluginUri, strArr, str, strArr2, str2, cancellationSignal);
            }
        } catch (Throwable th) {
            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "proxy provider#query(6 params) className=" + getClass().getSimpleName() + ",exception:", th);
        }
        return null;
    }
}
