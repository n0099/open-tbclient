package com.bytedance.pangle.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusConstants;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
@Keep
/* loaded from: classes12.dex */
public class ContentProviderManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PLUGIN_PKG_NAME = "plugin_pkg_name";
    public static final String PLUGIN_PROCESS_NAME = "process_name";
    public static final String PROVIDER_PARAM_FEILD = "provider_params";
    public static final String PROVIDER_PLUGIN_AUTHORITY = "provider_params";
    public static final String PROVIDER_PROXY_URI = "provider_proxy_uri";
    public static final String PROVIDER_URI = "uri";
    public static ContentProviderManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, String> mAuthorityProcessNameMap;
    public final Map<b, a> mContentProviderMap;
    public final Map<String, c> mSystemProviderInfoMap;

    /* loaded from: classes12.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final b a;

        /* renamed from: b  reason: collision with root package name */
        public final ProviderInfo f54614b;

        /* renamed from: c  reason: collision with root package name */
        public final PluginContentProvider f54615c;

        public a(b bVar, ProviderInfo providerInfo, PluginContentProvider pluginContentProvider) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, providerInfo, pluginContentProvider};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54614b = providerInfo;
            this.a = bVar;
            this.f54615c = pluginContentProvider;
        }
    }

    /* loaded from: classes12.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public final String f54616b;

        /* renamed from: c  reason: collision with root package name */
        public final String f54617c;

        public b(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str2;
            this.f54616b = str3;
            this.f54617c = str;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj instanceof b) {
                    b bVar = (b) obj;
                    if (TextUtils.equals(this.f54617c, bVar.f54617c) && TextUtils.equals(this.f54616b, bVar.f54616b) && TextUtils.equals(this.a, bVar.a)) {
                        return true;
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    return Objects.hash(this.a, this.f54616b, this.f54617c);
                }
                return (this.a + this.f54616b + this.a).hashCode();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes12.dex */
    public static final class c extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public final ProviderInfo f54618d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, String str2, ProviderInfo providerInfo) {
            super(str, str2, providerInfo.authority);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, providerInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (String) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54618d = providerInfo;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1397482888, "Lcom/bytedance/pangle/provider/ContentProviderManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1397482888, "Lcom/bytedance/pangle/provider/ContentProviderManager;");
        }
    }

    public ContentProviderManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContentProviderMap = new HashMap();
        this.mAuthorityProcessNameMap = new HashMap();
        this.mSystemProviderInfoMap = new HashMap();
    }

    public static ContentProviderManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (sInstance == null) {
                synchronized (ContentProviderManager.class) {
                    if (sInstance == null) {
                        sInstance = new ContentProviderManager();
                    }
                }
            }
            return sInstance;
        }
        return (ContentProviderManager) invokeV.objValue;
    }

    private void installProvider(ProviderInfo providerInfo, Plugin plugin2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, providerInfo, plugin2) == null) {
            if (providerInfo == null) {
                ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "ProviderInfo is null !! can not install plugin provider ， plugin-mPkgName：【" + plugin2.mPkgName + "】");
                return;
            }
            ZeusLogger.v(ZeusLogger.TAG_PROVIDER, "Start install plugin provider [authority:" + providerInfo.authority + "] [className:" + providerInfo.name + PreferencesUtil.RIGHT_MOUNT);
            try {
                PluginContentProvider instantiateProvider = instantiateProvider(plugin2.mClassLoader, providerInfo.name);
                instantiateProvider.attachInfo(ZeusTransformUtils.wrapperContext(plugin2.mHostApplication, plugin2.mPkgName), providerInfo);
                ZeusLogger.v(ZeusLogger.TAG_PROVIDER, "Install plugin provider finish and invoke plugin provider attachInfo(onCreate) method finish [className:" + providerInfo.name + PreferencesUtil.RIGHT_MOUNT);
                b bVar = new b(providerInfo.packageName, providerInfo.processName, providerInfo.authority);
                this.mContentProviderMap.put(bVar, new a(bVar, providerInfo, instantiateProvider));
                this.mAuthorityProcessNameMap.put(providerInfo.authority, providerInfo.processName);
            } catch (Exception e2) {
                ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "Instantiating Exception : ", e2);
            }
        }
    }

    private PluginContentProvider instantiateProvider(ClassLoader classLoader, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, classLoader, str)) == null) ? (PluginContentProvider) classLoader.loadClass(str).newInstance() : (PluginContentProvider) invokeLL.objValue;
    }

    public Bundle call(ContentResolver contentResolver, Uri uri, String str, String str2, Bundle bundle, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{contentResolver, uri, str, str2, bundle, str3})) == null) ? com.bytedance.pangle.provider.a.a(contentResolver, uri, str, str2, bundle, str3) : (Bundle) invokeCommon.objValue;
    }

    public int delete(ContentResolver contentResolver, Uri uri, String str, String[] strArr, String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, contentResolver, uri, str, strArr, str2)) == null) ? com.bytedance.pangle.provider.a.a(contentResolver, uri, str, strArr, str2) : invokeLLLLL.intValue;
    }

    public String getPluginProcessNameByAuthority(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? this.mAuthorityProcessNameMap.get(str) : (String) invokeL.objValue;
    }

    public PluginContentProvider getPluginProvider(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bVar)) == null) {
            a aVar = this.mContentProviderMap.get(bVar);
            if (aVar == null) {
                return null;
            }
            return aVar.f54615c;
        }
        return (PluginContentProvider) invokeL.objValue;
    }

    public Map<String, c> getSystemProviderInfoMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mSystemProviderInfoMap : (Map) invokeV.objValue;
    }

    public String getType(ContentResolver contentResolver, Uri uri, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, contentResolver, uri, str)) == null) ? com.bytedance.pangle.provider.a.a(contentResolver, uri, str) : (String) invokeLLL.objValue;
    }

    public void initSystemContentProviderInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            try {
                ProviderInfo[] providerInfoArr = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 8).providers;
                if (providerInfoArr == null || providerInfoArr.length == 0) {
                    return;
                }
                for (ProviderInfo providerInfo : providerInfoArr) {
                    if (providerInfo != null && providerInfo.authority != null && providerInfo.authority.contains(ZeusConstants.f54452b)) {
                        try {
                            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "Need to init system provider info start [packageNam:=" + providerInfo.packageName + "],[processName=" + providerInfo.processName + "],[authority:" + providerInfo.authority + PreferencesUtil.RIGHT_MOUNT);
                            if (providerInfo.authority.contains(Zeus.getAppApplication().getPackageName() + ZeusConstants.f54452b)) {
                                String a2 = com.bytedance.pangle.helper.c.a(providerInfo.processName);
                                this.mSystemProviderInfoMap.put(a2, new c(Zeus.getAppApplication().getPackageName(), a2, providerInfo));
                                ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "Init system provider info finish [packageNam:=" + providerInfo.packageName + "],[processName=" + providerInfo.processName + "],[authority:" + providerInfo.authority + PreferencesUtil.RIGHT_MOUNT);
                            }
                        } catch (Exception e2) {
                            ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "Init system contentProviderInfo [authority:" + providerInfo.authority + "],exception：", e2);
                        }
                    }
                }
            } catch (Throwable th) {
                ZeusLogger.e(ZeusLogger.TAG_PROVIDER, "init System ContentProviderInfo exception：", th);
            }
        }
    }

    public Uri insert(ContentResolver contentResolver, Uri uri, ContentValues contentValues, String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, contentResolver, uri, contentValues, str)) == null) ? com.bytedance.pangle.provider.a.a(contentResolver, uri, contentValues, str) : (Uri) invokeLLLL.objValue;
    }

    public void installContentProviders(Collection<ProviderInfo> collection, Plugin plugin2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, collection, plugin2) == null) || collection == null || collection.size() == 0 || plugin2 == null) {
            return;
        }
        for (ProviderInfo providerInfo : collection) {
            if (ZeusLogger.isDebug()) {
                StringBuilder sb = new StringBuilder(128);
                sb.append("Install plugin provider [authority:");
                sb.append(providerInfo.authority);
                sb.append("] - [className:");
                sb.append(providerInfo.name);
                sb.append(PreferencesUtil.RIGHT_MOUNT);
                ZeusLogger.v(ZeusLogger.TAG_PROVIDER, sb.toString());
            }
            installProvider(providerInfo, plugin2);
        }
    }

    public boolean isPluginProvider(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, uri)) == null) {
            if (uri == null) {
                return true;
            }
            String authority = uri.getAuthority();
            Set<String> keySet = this.mAuthorityProcessNameMap.keySet();
            return keySet != null && keySet.contains(authority);
        }
        return invokeL.booleanValue;
    }

    @RequiresApi(api = 16)
    public Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{contentResolver, uri, strArr, str, strArr2, str2, cancellationSignal, str3})) == null) ? com.bytedance.pangle.provider.a.a(contentResolver, uri, strArr, str, strArr2, str2, cancellationSignal, str3) : (Cursor) invokeCommon.objValue;
    }

    public int update(ContentResolver contentResolver, Uri uri, ContentValues contentValues, String str, String[] strArr, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{contentResolver, uri, contentValues, str, strArr, str2})) == null) ? com.bytedance.pangle.provider.a.a(contentResolver, uri, contentValues, str, strArr, str2) : invokeCommon.intValue;
    }

    public final Bundle call(ContentResolver contentResolver, String str, String str2, String str3, Bundle bundle, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{contentResolver, str, str2, str3, bundle, str4})) == null) ? com.bytedance.pangle.provider.a.a(contentResolver, str, str2, str3, bundle, str4) : (Bundle) invokeCommon.objValue;
    }

    public int delete(ContentResolver contentResolver, Uri uri, Bundle bundle, String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, contentResolver, uri, bundle, str)) == null) ? com.bytedance.pangle.provider.a.a(contentResolver, uri, bundle, str) : invokeLLLL.intValue;
    }

    public Uri insert(ContentResolver contentResolver, Uri uri, ContentValues contentValues, Bundle bundle, String str) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048585, this, contentResolver, uri, contentValues, bundle, str)) == null) ? com.bytedance.pangle.provider.a.a(contentResolver, uri, contentValues, bundle, str) : (Uri) invokeLLLLL.objValue;
    }

    public Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{contentResolver, uri, strArr, str, strArr2, str2, str3})) == null) ? com.bytedance.pangle.provider.a.a(contentResolver, uri, strArr, str, strArr2, str2, str3) : (Cursor) invokeCommon.objValue;
    }

    public int update(ContentResolver contentResolver, Uri uri, ContentValues contentValues, Bundle bundle, String str) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048592, this, contentResolver, uri, contentValues, bundle, str)) == null) ? com.bytedance.pangle.provider.a.b(contentResolver, uri, contentValues, bundle, str) : invokeLLLLL.intValue;
    }

    @RequiresApi(api = 26)
    public Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{contentResolver, uri, strArr, bundle, cancellationSignal, str})) == null) ? com.bytedance.pangle.provider.a.a(contentResolver, uri, strArr, bundle, cancellationSignal, str) : (Cursor) invokeCommon.objValue;
    }
}
