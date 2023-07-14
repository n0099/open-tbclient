package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.searchbox.download.util.MigrateStatisticUtils;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class li0 {
    public static /* synthetic */ Interceptable $ic;
    public static final String e;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public int d;

    /* loaded from: classes6.dex */
    public interface c {
        void onResult(boolean z);
    }

    /* loaded from: classes6.dex */
    public class a implements lk0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ boolean h;
        public final /* synthetic */ String i;
        public final /* synthetic */ li0 j;

        public a(li0 li0Var, c cVar, Context context, String str, String str2, String str3, String str4, String str5, boolean z, String str6) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li0Var, cVar, context, str, str2, str3, str4, str5, Boolean.valueOf(z), str6};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = li0Var;
            this.a = cVar;
            this.b = context;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            this.g = str5;
            this.h = z;
            this.i = str6;
        }

        @Override // com.baidu.tieba.lk0
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    if (!TextUtils.isEmpty(this.j.c)) {
                        ClogBuilder clogBuilder = new ClogBuilder();
                        if (!TextUtils.isEmpty(this.j.a)) {
                            clogBuilder.r(this.j.a);
                        }
                        clogBuilder.v("DEEPLINK");
                        clogBuilder.y(ClogBuilder.LogType.DEEP_LINK);
                        clogBuilder.j(GrsBaseInfo.CountryCodeSource.APP);
                        clogBuilder.p(this.j.c);
                        if (this.j.d == 1) {
                            clogBuilder.k("deferred");
                        }
                        n41.e(clogBuilder);
                    }
                    c cVar = this.a;
                    if (cVar != null) {
                        cVar.onResult(true);
                    }
                    pi0.e(this.j.c);
                    return;
                }
                this.j.j(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements lk0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;
        public final /* synthetic */ li0 d;

        public b(li0 li0Var, c cVar, Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li0Var, cVar, context, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = li0Var;
            this.a = cVar;
            this.b = context;
            this.c = str;
        }

        @Override // com.baidu.tieba.lk0
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    if (!TextUtils.isEmpty(this.d.c)) {
                        ClogBuilder clogBuilder = new ClogBuilder();
                        if (!TextUtils.isEmpty(this.d.a)) {
                            clogBuilder.r(this.d.a);
                        }
                        clogBuilder.v("DEEPLINK");
                        clogBuilder.y(ClogBuilder.LogType.DEEP_LINK);
                        clogBuilder.j("MARKET");
                        clogBuilder.p(this.d.c);
                        n41.e(clogBuilder);
                    }
                    c cVar = this.a;
                    if (cVar != null) {
                        cVar.onResult(true);
                        return;
                    }
                    return;
                }
                c cVar2 = this.a;
                if (cVar2 != null) {
                    cVar2.onResult(this.d.h(this.b, this.c));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947943702, "Lcom/baidu/tieba/li0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947943702, "Lcom/baidu/tieba/li0;");
                return;
            }
        }
        e = rk0.a().r() + "://vendor/ad/easybrowse?ad_id=_AD_ID_&ext_info=_AD_EXT_&url=_URL_TEMPLATE_";
    }

    public li0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = 0;
    }

    public boolean g(Context context, HashMap<String, String> hashMap, c cVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, hashMap, cVar)) == null) {
            return f(context, null, hashMap, cVar);
        }
        return invokeLLL.booleanValue;
    }

    public boolean f(Context context, String str, HashMap<String, String> hashMap, c cVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, str, hashMap, cVar)) == null) {
            this.a = str;
            return k(context, hashMap, cVar);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean h(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (!TextUtils.isEmpty(this.c)) {
                ClogBuilder clogBuilder = new ClogBuilder();
                if (!TextUtils.isEmpty(this.a)) {
                    clogBuilder.r(this.a);
                }
                clogBuilder.v("DEEPLINK");
                clogBuilder.y(ClogBuilder.LogType.DEEP_LINK);
                clogBuilder.j("URL");
                clogBuilder.p(this.c);
                if (this.d == 1) {
                    clogBuilder.k("deferred");
                }
                n41.e(clogBuilder);
            }
            if (!str.startsWith(rk0.a().r()) && !str.startsWith("nadcorevendor://")) {
                if (!str.startsWith("http") && !str.startsWith("https")) {
                    return false;
                }
                String replace = e.replace("_URL_TEMPLATE_", str);
                if (!TextUtils.isEmpty(this.b)) {
                    replace = replace.replace("_AD_ID_", this.b);
                }
                if (!TextUtils.isEmpty(this.c)) {
                    replace = replace.replace("_AD_EXT_", this.c);
                }
                ak0.c(replace, context);
                return true;
            }
            ak0.c(str, context);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void i(Context context, String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, str, str2, str3, str4, str5, str6, Boolean.valueOf(z), str7, cVar}) == null) {
            try {
                try {
                    nk0.a(context, str, str6, new a(this, cVar, context, str2, str3, str4, str5, str6, z, str7), z);
                } catch (Exception unused) {
                    j(context, str2, str3, str4, str5, str6, z, str7, cVar);
                }
            } catch (Exception unused2) {
            }
        }
    }

    public final void j(Context context, String str, String str2, String str3, String str4, String str5, boolean z, String str6, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, str, str2, str3, str4, str5, Boolean.valueOf(z), str6, cVar}) == null) {
            if (TextUtils.isEmpty(str2)) {
                if (cVar != null) {
                    cVar.onResult(h(context, str));
                    return;
                }
                return;
            }
            try {
                nk0.a(context, str2, str3, new b(this, cVar, context, str), z);
            } catch (Exception unused) {
                if (cVar != null) {
                    cVar.onResult(h(context, str));
                }
            }
        }
    }

    public final boolean k(Context context, HashMap<String, String> hashMap, c cVar) {
        InterceptResult invokeLLL;
        int i;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, context, hashMap, cVar)) == null) {
            if (hashMap == null) {
                if (cVar != null) {
                    cVar.onResult(false);
                }
                return false;
            }
            try {
                String str = hashMap.get("app_url");
                String str2 = hashMap.get("web_url");
                String str3 = hashMap.get("min_version");
                String str4 = hashMap.get("pkg_name");
                String str5 = hashMap.get("market_url");
                String str6 = hashMap.get("market_pkg_name");
                String str7 = hashMap.get("exemption");
                if (!TextUtils.isEmpty(str7)) {
                    i = Integer.parseInt(str7);
                } else {
                    i = 0;
                }
                String str8 = hashMap.get("source");
                this.b = hashMap.get(LegoListActivityConfig.AD_ID);
                this.c = hashMap.get(MigrateStatisticUtils.EXT_INFO);
                String str9 = hashMap.get("exemption");
                if (!TextUtils.isEmpty(str9)) {
                    this.d = Integer.parseInt(str9);
                }
                hashMap.get("ad_name");
                if (!TextUtils.isEmpty(str)) {
                    if (i != 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    i(context, str, str2, str5, str6, str3, str4, z2, str8, cVar);
                } else if (!TextUtils.isEmpty(str5)) {
                    if (i != 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    j(context, str2, str5, str6, str3, str4, z, str8, cVar);
                } else if (!TextUtils.isEmpty(str2)) {
                    if (cVar != null) {
                        cVar.onResult(h(context, str2));
                    }
                } else {
                    if (cVar != null) {
                        cVar.onResult(false);
                    }
                    return false;
                }
                return true;
            } catch (NumberFormatException unused) {
                if (cVar != null) {
                    cVar.onResult(false);
                }
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }
}
