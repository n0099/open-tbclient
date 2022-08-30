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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.provider.ContentProviderManager;
import org.json.JSONObject;
@Keep
/* loaded from: classes7.dex */
public class ContentProviderProxy extends ContentProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ContentProviderManager mPluginProviderManager;

    public ContentProviderProxy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private PluginContentProvider obtainPluginProvider(Uri uri, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, uri, str)) == null) ? obtainPluginProvider(uri, str, null) : (PluginContentProvider) invokeLL.objValue;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Bundle call(@NonNull String str, @Nullable String str2, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, bundle)) == null) {
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
        return (Bundle) invokeLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, uri, str, strArr)) == null) {
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
        return invokeLLL.intValue;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, uri)) == null) {
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
        return (String) invokeL.objValue;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, uri, contentValues)) == null) {
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
        return (Uri) invokeLL.objValue;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            this.mPluginProviderManager = ContentProviderManager.getInstance();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048585, this, uri, strArr, str, strArr2, str2)) == null) {
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
        return (Cursor) invokeLLLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, uri, contentValues, str, strArr)) == null) {
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
        return invokeLLLL.intValue;
    }

    private PluginContentProvider obtainPluginProvider(Uri uri, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, uri, str, str2)) == null) {
            String queryParameter = uri.getQueryParameter("provider_params");
            Uri uri2 = null;
            if (queryParameter == null) {
                return null;
            }
            if (!TextUtils.isEmpty(queryParameter)) {
                queryParameter = TextUtils.isEmpty(queryParameter) ? "" : new String(Base64.decode(queryParameter, 10));
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
        return (PluginContentProvider) invokeLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, uri, bundle)) == null) {
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
        return invokeLL.intValue;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, uri, contentValues, bundle)) == null) {
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
        return (Uri) invokeLLL.objValue;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2, @Nullable CancellationSignal cancellationSignal) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{uri, strArr, str, strArr2, str2, cancellationSignal})) == null) {
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
        return (Cursor) invokeCommon.objValue;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, uri, contentValues, bundle)) == null) {
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
        return invokeLLL.intValue;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Bundle call(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable Bundle bundle) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, bundle)) == null) {
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
        return (Bundle) invokeLLLL.objValue;
    }

    @Override // android.content.ContentProvider
    @Nullable
    @RequiresApi(api = 26)
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable Bundle bundle, @Nullable CancellationSignal cancellationSignal) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, uri, strArr, bundle, cancellationSignal)) == null) {
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
        return (Cursor) invokeLLLL.objValue;
    }
}
