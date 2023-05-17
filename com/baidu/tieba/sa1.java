package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class sa1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public c b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public a j;
    public b k;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public int b;
        public double c;

        public a() {
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

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i = this.b;
                if ((i == 2 || i == 3) && this.c > 0.0d && !TextUtils.isEmpty(this.a)) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public static a b(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                a aVar = new a();
                JSONObject c = p11.c(str);
                aVar.a = c.optString("defer_charge_url");
                aVar.b = c.optInt("defer_type", 3);
                aVar.c = c.optDouble("defer_time", 0.0d);
                return aVar;
            }
            return (a) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;

        public b() {
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

        public static b a(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                b bVar = new b();
                JSONObject c = p11.c(str);
                bVar.e = c.optString("key");
                c.optString("pkg_name");
                bVar.a = c.optString("download_url");
                c.optString(BreakpointSQLiteKey.CONTENT_LENGTH);
                bVar.b = c.optString("close_virtual_progress");
                bVar.c = c.optString("apk_label");
                bVar.d = c.optString("apk_icon");
                return bVar;
            }
            return (b) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

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

        public static c a(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                c cVar = new c();
                JSONObject c = p11.c(str);
                cVar.a = c.optString("receive_title_script");
                c.optString("start_load_script");
                return cVar;
            }
            return (c) invokeL.objValue;
        }
    }

    public sa1() {
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

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return !TextUtils.equals(this.e, "0");
        }
        return invokeV.booleanValue;
    }

    public static sa1 b(@NonNull Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, intent)) == null) {
            Bundle extras = intent.getExtras();
            sa1 sa1Var = null;
            if (extras == null) {
                return null;
            }
            Serializable serializable = extras.getSerializable("map");
            if (!(serializable instanceof HashMap)) {
                return null;
            }
            HashMap hashMap = (HashMap) serializable;
            if (hashMap != null && !hashMap.isEmpty()) {
                sa1Var = new sa1();
                sa1Var.c = (String) q11.b(hashMap, LegoListActivityConfig.AD_ID);
                sa1Var.a = (String) q11.b(hashMap, "url");
                sa1Var.f = (String) q11.b(hashMap, "ext_info");
                sa1Var.g = (String) q11.b(hashMap, TiebaStatic.Params.REFER);
                sa1Var.d = (String) q11.b(hashMap, "charge_url");
                sa1Var.e = (String) q11.b(hashMap, "ad_invoke_flag");
                sa1Var.h = (String) q11.b(hashMap, "lp_real_url");
                String str = (String) q11.b(hashMap, "log_switch");
                if (TextUtils.isEmpty(str)) {
                    str = "1";
                }
                sa1Var.i = str;
                String str2 = (String) q11.b(hashMap, "sdk_script");
                if (!TextUtils.isEmpty(str2)) {
                    sa1Var.b = c.a(str2);
                }
                String str3 = (String) q11.b(hashMap, "defer_charge");
                if (!TextUtils.isEmpty(str3)) {
                    sa1Var.j = a.b(str3);
                }
                String str4 = (String) q11.b(hashMap, "download");
                if (!TextUtils.isEmpty(str4)) {
                    sa1Var.k = b.a(str4);
                }
                sa1Var.c();
            }
            return sa1Var;
        }
        return (sa1) invokeL.objValue;
    }

    public final void c() {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || TextUtils.isEmpty(this.g)) {
            return;
        }
        if (this.g.contains("__CHARGE_URL__") && !TextUtils.isEmpty(this.d)) {
            this.g = this.g.replace("__CHARGE_URL__", this.d);
        }
        if (this.g.contains("__DEFER_CHARGE_URL__") && (aVar = this.j) != null && !TextUtils.isEmpty(aVar.a)) {
            this.g = this.g.replace("__DEFER_CHARGE_URL__", this.j.a);
        }
    }
}
