package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.searchbox.command.CommandUtils;
import com.baidu.searchbox.download.util.MigrateStatisticUtils;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class x91 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final d a;
    public final Intent b;

    /* loaded from: classes8.dex */
    public final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public String b;
        public String c;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(x91 x91Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x91Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.b;
            }
            return (String) invokeV.objValue;
        }

        public final boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a;
            }
            return invokeV.booleanValue;
        }

        public final a c(HashMap<String, String> paramsMap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, paramsMap)) == null) {
                Intrinsics.checkNotNullParameter(paramsMap, "paramsMap");
                this.a = TextUtils.equals((CharSequence) a31.b(paramsMap, CommandUtils.PARAM_APPEND), "1");
                this.b = (String) a31.b(paramsMap, "forbidautorotate");
                this.c = (String) a31.b(paramsMap, "layoutfullscreen");
                return this;
            }
            return (a) invokeL.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("needAppend", this.a);
                jSONObject.put("forbidAutoRotate", this.b);
                jSONObject.put("fullScreen", this.c);
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   …\n            }.toString()");
                return jSONObject2;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final int b;
        public final int c;
        public String d;
        public int e;
        public double f;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b(x91 x91Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x91Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 1;
            this.b = 2;
            this.c = 3;
        }

        public final b c(String data) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, data)) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                JSONObject c = z21.c(data);
                Intrinsics.checkNotNullExpressionValue(c, "JSONUtils.newJSONObject(data)");
                this.d = c.optString("defer_charge_url");
                this.e = c.optInt("defer_type", this.c);
                this.f = c.optDouble("defer_time", 0.0d);
                return this;
            }
            return (b) invokeL.objValue;
        }

        public final String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.d;
            }
            return (String) invokeV.objValue;
        }

        public final double b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.f;
            }
            return invokeV.doubleValue;
        }

        public final boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                int i = this.e;
                if ((i != this.b && i != this.c) || this.f <= 0 || TextUtils.isEmpty(this.d)) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public final boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                int i = this.e;
                if ((i == this.a || i == this.c) && !TextUtils.isEmpty(this.d)) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("deferChargeUrl", this.d);
                jSONObject.put("deferType", this.e);
                jSONObject.put("deferTime", this.f);
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   …\n            }.toString()");
                return jSONObject2;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;

        public c() {
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

        public final String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.f;
            }
            return (String) invokeV.objValue;
        }

        public final String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.e;
            }
            return (String) invokeV.objValue;
        }

        public final String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.d;
            }
            return (String) invokeV.objValue;
        }

        public final String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.b;
            }
            return (String) invokeV.objValue;
        }

        public final String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.g;
            }
            return (String) invokeV.objValue;
        }

        public final c f(String data) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, data)) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                JSONObject c = z21.c(data);
                Intrinsics.checkNotNullExpressionValue(c, "JSONUtils.newJSONObject(data)");
                this.g = c.optString("key");
                this.a = c.optString("pkg_name");
                this.b = c.optString("download_url");
                this.c = c.optString(BreakpointSQLiteKey.CONTENT_LENGTH);
                this.d = c.optString("close_virtual_progress");
                this.e = c.optString("apk_label");
                this.f = c.optString("apk_icon");
                return this;
            }
            return (c) invokeL.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pkgName", this.a);
                jSONObject.put(TTDownloadField.TT_DOWNLOAD_URL, this.b);
                jSONObject.put("contentLength", this.c);
                jSONObject.put("closeVirtualProgress", this.d);
                jSONObject.put("apkLabel", this.e);
                jSONObject.put("apkIcon", this.f);
                jSONObject.put("key", this.g);
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   …\n            }.toString()");
                return jSONObject2;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public boolean j;
        public boolean k;
        public a l;
        public e m;
        public b n;
        public c o;
        public f p;
        public final /* synthetic */ x91 q;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public d(x91 x91Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x91Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.q = x91Var;
        }

        public final void o(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
                this.j = z;
            }
        }

        public final boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return !TextUtils.equals(this.d, "0");
            }
            return invokeV.booleanValue;
        }

        public final String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.b;
            }
            return (String) invokeV.objValue;
        }

        public final a c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.l;
            }
            return (a) invokeV.objValue;
        }

        public final b d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.n;
            }
            return (b) invokeV.objValue;
        }

        public final c e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.o;
            }
            return (c) invokeV.objValue;
        }

        public final String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.e;
            }
            return (String) invokeV.objValue;
        }

        public final String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.i;
            }
            return (String) invokeV.objValue;
        }

        public final String h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.g;
            }
            return (String) invokeV.objValue;
        }

        public final String i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.f;
            }
            return (String) invokeV.objValue;
        }

        public final e j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.m;
            }
            return (e) invokeV.objValue;
        }

        public final f k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return this.p;
            }
            return (f) invokeV.objValue;
        }

        public final String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return this.a;
            }
            return (String) invokeV.objValue;
        }

        public final boolean n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return this.j;
            }
            return invokeV.booleanValue;
        }

        public final d m(Intent intent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, intent)) == null) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                Bundle extras = intent.getExtras();
                String str = null;
                if (extras != null) {
                    Intrinsics.checkNotNullExpressionValue(extras, "intent.extras ?: return null");
                    Serializable serializable = extras.getSerializable("map");
                    if (!(serializable instanceof HashMap)) {
                        serializable = null;
                    }
                    HashMap<String, String> hashMap = (HashMap) serializable;
                    if (hashMap != null) {
                        if (hashMap != null) {
                            if (hashMap == null || hashMap.isEmpty()) {
                                return null;
                            }
                            this.b = (String) a31.b(hashMap, LegoListActivityConfig.AD_ID);
                            this.a = (String) a31.b(hashMap, "url");
                            this.e = (String) a31.b(hashMap, MigrateStatisticUtils.EXT_INFO);
                            this.f = (String) a31.b(hashMap, "refer");
                            this.c = (String) a31.b(hashMap, "charge_url");
                            this.d = (String) a31.b(hashMap, "ad_invoke_flag");
                            this.g = (String) a31.b(hashMap, "lp_real_url");
                            this.h = (String) a31.b(hashMap, "log_switch");
                            this.i = (String) a31.b(hashMap, "lp_org_type");
                            this.k = TextUtils.equals((CharSequence) a31.b(hashMap, "downgrade_to_native"), "1");
                            a aVar = new a(this.q);
                            aVar.c(hashMap);
                            this.l = aVar;
                            String sdScriptStr = (String) a31.b(hashMap, "sdk_script");
                            if (!TextUtils.isEmpty(sdScriptStr)) {
                                e eVar = new e(this.q);
                                Intrinsics.checkNotNullExpressionValue(sdScriptStr, "sdScriptStr");
                                eVar.c(sdScriptStr);
                                this.m = eVar;
                            }
                            String deferChargeStr = (String) a31.b(hashMap, "defer_charge");
                            if (!TextUtils.isEmpty(deferChargeStr)) {
                                b bVar = new b(this.q);
                                Intrinsics.checkNotNullExpressionValue(deferChargeStr, "deferChargeStr");
                                bVar.c(deferChargeStr);
                                this.n = bVar;
                            }
                            String downloadStr = (String) a31.b(hashMap, "download");
                            if (!TextUtils.isEmpty(downloadStr)) {
                                c cVar = new c();
                                Intrinsics.checkNotNullExpressionValue(downloadStr, "downloadStr");
                                cVar.f(downloadStr);
                                this.o = cVar;
                            }
                            String splashStr = (String) a31.b(hashMap, SpeedStatsUtils.UBC_VALUE_SPLASH);
                            if (!TextUtils.isEmpty(splashStr)) {
                                f fVar = new f();
                                Intrinsics.checkNotNullExpressionValue(splashStr, "splashStr");
                                fVar.e(splashStr);
                                this.p = fVar;
                            }
                            x91 x91Var = this.q;
                            String str2 = this.f;
                            String str3 = this.c;
                            b bVar2 = this.n;
                            if (bVar2 != null) {
                                str = bVar2.a();
                            }
                            this.f = x91Var.c(str2, str3, str);
                            return this;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>");
                    }
                }
                return null;
            }
            return (d) invokeL.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", this.a);
                jSONObject.put("adId", this.b);
                jSONObject.put("chargeUrl", this.c);
                jSONObject.put("invokeFlag", this.d);
                jSONObject.put("extInfo", this.e);
                jSONObject.put("refer", this.f);
                jSONObject.put("lpRealUrl", this.g);
                jSONObject.put("logSwitch", this.h);
                jSONObject.put("lpOrgType", this.i);
                jSONObject.put("downgrade", this.k);
                jSONObject.put("containerParams", this.l);
                jSONObject.put("sdkScript", this.m);
                jSONObject.put("deferCharge", this.n);
                jSONObject.put("download", this.o);
                jSONObject.put(SpeedStatsUtils.UBC_VALUE_SPLASH, this.p);
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   …\n            }.toString()");
                return jSONObject2;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public final class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public e(x91 x91Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x91Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final e c(String data) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, data)) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                JSONObject c = z21.c(data);
                Intrinsics.checkNotNullExpressionValue(c, "JSONUtils.newJSONObject(data)");
                this.a = c.optString("receive_title_script");
                this.b = c.optString("start_load_script");
                return this;
            }
            return (e) invokeL.objValue;
        }

        public final String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return (String) invokeV.objValue;
        }

        public final String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.b;
            }
            return (String) invokeV.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("receiveTitleScript", this.a);
                jSONObject.put("startLoadScript", this.b);
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   …\n            }.toString()");
                return jSONObject2;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public long b;
        public String c;
        public String d;
        public String e;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = "";
            this.c = "";
            this.d = "";
            this.e = "";
        }

        public final String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.c;
            }
            return (String) invokeV.objValue;
        }

        public final String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.d;
            }
            return (String) invokeV.objValue;
        }

        public final String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.e;
            }
            return (String) invokeV.objValue;
        }

        public final long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.b;
            }
            return invokeV.longValue;
        }

        public final f e(String data) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, data)) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                JSONObject c = z21.c(data);
                Intrinsics.checkNotNullExpressionValue(c, "JSONUtils.newJSONObject(data)");
                this.a = c.optString("html_url_filter_params");
                this.b = c.optLong("ad_click_real_time", 0L);
                this.c = c.optString("splash_launch_type");
                this.d = c.optString("xuzhang_ext");
                String mUa = c.optString("m_ua", "mua");
                if (!TextUtils.isEmpty(mUa)) {
                    Intrinsics.checkNotNullExpressionValue(mUa, "mUa");
                    Charset charset = Charsets.UTF_8;
                    if (mUa != null) {
                        byte[] bytes = mUa.getBytes(charset);
                        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                        byte[] decode = Base64.decode(bytes, 0);
                        Intrinsics.checkNotNullExpressionValue(decode, "Base64.decode(mUa.toByteArray(), Base64.DEFAULT)");
                        this.e = new String(decode, Charsets.UTF_8);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                }
                String mPn = c.optString("m_pn");
                if (!TextUtils.isEmpty(mPn)) {
                    Intrinsics.checkNotNullExpressionValue(mPn, "mPn");
                    Charset charset2 = Charsets.UTF_8;
                    if (mPn != null) {
                        byte[] bytes2 = mPn.getBytes(charset2);
                        Intrinsics.checkNotNullExpressionValue(bytes2, "(this as java.lang.String).getBytes(charset)");
                        byte[] decode2 = Base64.decode(bytes2, 0);
                        Intrinsics.checkNotNullExpressionValue(decode2, "Base64.decode(mPn.toByteArray(), Base64.DEFAULT)");
                        new String(decode2, Charsets.UTF_8);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                }
                return this;
            }
            return (f) invokeL.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("filterParams", this.a);
                jSONObject.put("splashRealClickTime", this.b);
                jSONObject.put("splashBootType", this.c);
                jSONObject.put("splashExt", this.d);
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   …\n            }.toString()");
                return jSONObject2;
            }
            return (String) invokeV.objValue;
        }
    }

    public x91(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {intent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        this.b = intent;
        this.a = new d(this).m(this.b);
    }

    public final d b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (d) invokeV.objValue;
    }

    public final String c(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            Intrinsics.checkNotNull(str);
            if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "__CHARGE_URL__", false, 2, (Object) null) && !TextUtils.isEmpty(str2)) {
                Intrinsics.checkNotNull(str2);
                str4 = StringsKt__StringsJVMKt.replace(str, "__CHARGE_URL__", str2, false);
            } else {
                str4 = null;
            }
            if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "__DEFER_CHARGE_URL__", false, 2, (Object) null) && !TextUtils.isEmpty(str3)) {
                Intrinsics.checkNotNull(str3);
                return StringsKt__StringsJVMKt.replace(str, "__DEFER_CHARGE_URL__", str3, false);
            }
            return str4;
        }
        return (String) invokeLLL.objValue;
    }
}
