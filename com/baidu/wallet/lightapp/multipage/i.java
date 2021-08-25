package com.baidu.wallet.lightapp.multipage;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.utils.LogUtil;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
/* loaded from: classes8.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f62028a;

    /* renamed from: b  reason: collision with root package name */
    public LangbridgeSettings f62029b;

    /* renamed from: c  reason: collision with root package name */
    public b f62030c;

    /* renamed from: d  reason: collision with root package name */
    public b f62031d;

    /* renamed from: e  reason: collision with root package name */
    public Set<WeakReference<a>> f62032e;

    /* renamed from: com.baidu.wallet.lightapp.multipage.i$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public interface a {
        void onSettingUpdated(LangbridgeSettings langbridgeSettings);
    }

    /* loaded from: classes8.dex */
    public interface b {
        LangbridgeSettings a(Context context, LangbridgeSettings langbridgeSettings);
    }

    /* loaded from: classes8.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static i f62033a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(549871734, "Lcom/baidu/wallet/lightapp/multipage/i$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(549871734, "Lcom/baidu/wallet/lightapp/multipage/i$c;");
                    return;
                }
            }
            f62033a = new i(null);
        }
    }

    public /* synthetic */ i(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static i a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? c.f62033a : (i) invokeV.objValue;
    }

    private LangbridgeSettings d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context)) == null) {
            b bVar = this.f62030c;
            LangbridgeSettings a2 = bVar != null ? bVar.a(context, this.f62029b) : this.f62029b;
            b bVar2 = this.f62031d;
            return bVar2 != null ? bVar2.a(context, a2) : a2;
        }
        return (LangbridgeSettings) invokeL.objValue;
    }

    public LangbridgeSettings b(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            if (this.f62029b == null) {
                this.f62029b = a(this.f62028a);
            }
            if (this.f62029b == null) {
                this.f62029b = new LangbridgeSettings();
            }
            LogUtil.d("LangbridgeSettings", "");
            return this.f62029b;
        }
        return (LangbridgeSettings) invokeL.objValue;
    }

    public void c(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, context) == null) || this.f62029b == null) {
            return;
        }
        LogUtil.d("LangbridgeSettings", "");
        for (WeakReference<a> weakReference : this.f62032e) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().onSettingUpdated(d(context));
            }
        }
    }

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62032e = new CopyOnWriteArraySet();
        this.f62030c = e.a();
        this.f62031d = f.a();
    }

    public LangbridgeSettings a(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            if (this.f62029b == null) {
                this.f62029b = a(this.f62028a);
            }
            if (this.f62029b == null) {
                this.f62029b = new LangbridgeSettings();
            }
            LogUtil.d("LangbridgeSettings", "");
            return d(context);
        }
        return (LangbridgeSettings) invokeL.objValue;
    }

    public void a(@NonNull Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str) == null) {
            if (this.f62029b == null) {
                this.f62029b = new LangbridgeSettings();
            }
            if (TextUtils.isEmpty(str)) {
                this.f62029b = new LangbridgeSettings();
                if (!TextUtils.isEmpty(this.f62028a)) {
                    this.f62028a = JsonUtils.toJson(this.f62029b);
                }
                LogUtil.d("WebViewCacheManager", "updateSettings CLEAR mSettings = " + this.f62029b.toString());
                return;
            }
            LangbridgeSettings a2 = a(str);
            StringBuilder sb = new StringBuilder();
            sb.append("updateSettings oldSettings = ");
            LangbridgeSettings langbridgeSettings = this.f62029b;
            String str2 = langbridgeSettings;
            if (langbridgeSettings != null) {
                str2 = langbridgeSettings.toString();
            }
            sb.append((Object) str2);
            sb.append("\nnewSettings = ");
            sb.append((Object) (a2 != null ? a2.toString() : a2));
            LogUtil.d("WebViewCacheManager", sb.toString());
            if (a2 != null && !a2.MW_USE_OLD && a2.MW_ON && !TextUtils.isEmpty(this.f62028a)) {
                LangbridgeSettings langbridgeSettings2 = this.f62029b;
                if (langbridgeSettings2.MW_USE_OLD || !langbridgeSettings2.MW_ON) {
                    LogUtil.d("WebViewCacheManager", "updateSettings CANCEL mSettings = " + this.f62029b.toString());
                    return;
                }
            }
            if (a2 != null) {
                this.f62029b = a2;
                LogUtil.d("LangbridgeSettings", "");
                this.f62028a = str;
                for (WeakReference<a> weakReference : this.f62032e) {
                    if (weakReference != null && weakReference.get() != null) {
                        weakReference.get().onSettingUpdated(d(context));
                    }
                }
            }
            LogUtil.d("WebViewCacheManager", "updateSettings SUCCESS mSettings = " + this.f62029b.toString());
        }
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || aVar == null) {
            return;
        }
        this.f62032e.add(new WeakReference<>(aVar));
    }

    private LangbridgeSettings a(String str) {
        InterceptResult invokeL;
        LangbridgeSettings langbridgeSettings;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    langbridgeSettings = (LangbridgeSettings) JsonUtils.fromJson(str, LangbridgeSettings.class);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                if (langbridgeSettings == null && langbridgeSettings.isValid()) {
                    return langbridgeSettings;
                }
                return null;
            }
            langbridgeSettings = null;
            if (langbridgeSettings == null) {
            }
            return null;
        }
        return (LangbridgeSettings) invokeL.objValue;
    }

    public String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            String a2 = com.baidu.wallet.lightapp.business.a.a(str);
            if (!TextUtils.isEmpty(a2)) {
                str2 = a2;
            }
            LogUtil.d("WebViewCacheManager", "LangbridgeSettingManager获取注入js文件：" + str2);
            return str2;
        }
        return (String) invokeLL.objValue;
    }
}
