package com.baidu.wallet.lightapp.multipage;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
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
/* loaded from: classes5.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f25918a;

    /* renamed from: b  reason: collision with root package name */
    public LangbridgeSettings f25919b;

    /* renamed from: c  reason: collision with root package name */
    public b f25920c;

    /* renamed from: d  reason: collision with root package name */
    public Set<WeakReference<a>> f25921d;

    /* renamed from: com.baidu.wallet.lightapp.multipage.h$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public interface a {
        void onSettingUpdated(LangbridgeSettings langbridgeSettings);
    }

    /* loaded from: classes5.dex */
    public interface b {
        LangbridgeSettings a(Context context, LangbridgeSettings langbridgeSettings);
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static h f25922a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(549841943, "Lcom/baidu/wallet/lightapp/multipage/h$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(549841943, "Lcom/baidu/wallet/lightapp/multipage/h$c;");
                    return;
                }
            }
            f25922a = new h(null);
        }
    }

    public /* synthetic */ h(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static h a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? c.f25922a : (h) invokeV.objValue;
    }

    public void b(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, context) == null) || this.f25919b == null) {
            return;
        }
        LogUtil.d("LangbridgeSettings", "");
        for (WeakReference<a> weakReference : this.f25921d) {
            if (weakReference != null && weakReference.get() != null) {
                a aVar = weakReference.get();
                b bVar = this.f25920c;
                aVar.onSettingUpdated(bVar != null ? bVar.a(context, this.f25919b) : this.f25919b);
            }
        }
    }

    public h() {
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
        this.f25921d = new CopyOnWriteArraySet();
        this.f25920c = e.a();
    }

    public LangbridgeSettings a(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            if (this.f25919b == null) {
                this.f25919b = a(this.f25918a);
            }
            if (this.f25919b == null) {
                this.f25919b = new LangbridgeSettings();
            }
            LogUtil.d("LangbridgeSettings", "");
            b bVar = this.f25920c;
            return bVar != null ? bVar.a(context, this.f25919b) : this.f25919b;
        }
        return (LangbridgeSettings) invokeL.objValue;
    }

    public void a(@NonNull Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str) == null) {
            if (this.f25919b == null) {
                this.f25919b = new LangbridgeSettings();
            }
            if (TextUtils.isEmpty(str)) {
                this.f25919b = new LangbridgeSettings();
                if (!TextUtils.isEmpty(this.f25918a)) {
                    this.f25918a = JsonUtils.toJson(this.f25919b);
                }
                LogUtil.d("WebViewCacheManager", "updateSettings CLEAR mSettings = " + this.f25919b.toString());
                return;
            }
            LangbridgeSettings a2 = a(str);
            StringBuilder sb = new StringBuilder();
            sb.append("updateSettings oldSettings = ");
            LangbridgeSettings langbridgeSettings = this.f25919b;
            String str2 = langbridgeSettings;
            if (langbridgeSettings != null) {
                str2 = langbridgeSettings.toString();
            }
            sb.append((Object) str2);
            sb.append("\nnewSettings = ");
            sb.append((Object) (a2 != null ? a2.toString() : a2));
            LogUtil.d("WebViewCacheManager", sb.toString());
            if (a2 != null && !a2.MW_USE_OLD && a2.MW_ON && !TextUtils.isEmpty(this.f25918a)) {
                LangbridgeSettings langbridgeSettings2 = this.f25919b;
                if (langbridgeSettings2.MW_USE_OLD || !langbridgeSettings2.MW_ON) {
                    LogUtil.d("WebViewCacheManager", "updateSettings CANCEL mSettings = " + this.f25919b.toString());
                    return;
                }
            }
            if (a2 != null) {
                this.f25919b = a2;
                LogUtil.d("LangbridgeSettings", "");
                this.f25918a = str;
                for (WeakReference<a> weakReference : this.f25921d) {
                    if (weakReference != null && weakReference.get() != null) {
                        a aVar = weakReference.get();
                        b bVar = this.f25920c;
                        aVar.onSettingUpdated(bVar != null ? bVar.a(context, this.f25919b) : this.f25919b);
                    }
                }
            }
            LogUtil.d("WebViewCacheManager", "updateSettings SUCCESS mSettings = " + this.f25919b.toString());
        }
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || aVar == null) {
            return;
        }
        this.f25921d.add(new WeakReference<>(aVar));
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
