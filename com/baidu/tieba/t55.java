package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class t55 {
    public static /* synthetic */ Interceptable $ic;
    public static final t55 c;
    public static final t55 d;
    public static final t55 e;
    public static final t55 f;
    public static final t55 g;
    public static final t55 h;
    public static final t55 i;
    public static final t55 j;
    public static final t55 k;
    public static final t55 l;
    public static final t55 m;
    public static final t55 n;
    public static final t55 o;
    public static final t55 p;
    public static final t55 q;
    public static final t55 r;
    public static final t55 s;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final boolean b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948132213, "Lcom/baidu/tieba/t55;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948132213, "Lcom/baidu/tieba/t55;");
                return;
            }
        }
        c = new t55("sync_finish", false);
        d = new t55("main_page_load_finish", false);
        e = new t55("pb_load_finish", false);
        f = new t55("frs_load_finish", false);
        g = new t55("main_page_recommend", true);
        h = new t55("main_page_common_tab", true);
        i = new t55("main_page_hot_topic", true);
        j = new t55("main_page_concern", true);
        k = new t55("main_page_enter_forum", true);
        l = new t55("main_page_message", true);
        m = new t55("main_page_person_info", true);
        n = new t55("write_page", true);
        o = new t55("webview_write_page", true);
        p = new t55("pb_page", true);
        q = new t55("frs_page", true);
        r = new t55("main_page_idle", false);
        s = new t55("splash_close", false);
    }

    public t55(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str;
        this.b = z;
    }

    public static t55 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return new t55("main_page_common_tab_" + str, true);
        }
        return (t55) invokeL.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }
}
