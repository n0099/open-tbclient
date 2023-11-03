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
public class s05 {
    public static /* synthetic */ Interceptable $ic;
    public static final s05 c;
    public static final s05 d;
    public static final s05 e;
    public static final s05 f;
    public static final s05 g;
    public static final s05 h;
    public static final s05 i;
    public static final s05 j;
    public static final s05 k;
    public static final s05 l;
    public static final s05 m;
    public static final s05 n;
    public static final s05 o;
    public static final s05 p;
    public static final s05 q;
    public static final s05 r;
    public static final s05 s;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final boolean b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948097617, "Lcom/baidu/tieba/s05;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948097617, "Lcom/baidu/tieba/s05;");
                return;
            }
        }
        c = new s05("sync_finish", false);
        d = new s05("main_page_load_finish", false);
        e = new s05("pb_load_finish", false);
        f = new s05("frs_load_finish", false);
        g = new s05("main_page_recommend", true);
        h = new s05("main_page_common_tab", true);
        i = new s05("main_page_hot_topic", true);
        j = new s05("main_page_concern", true);
        k = new s05("main_page_enter_forum", true);
        l = new s05("main_page_message", true);
        m = new s05("main_page_person_info", true);
        n = new s05("write_page", true);
        o = new s05("webview_write_page", true);
        p = new s05("pb_page", true);
        q = new s05("frs_page", true);
        r = new s05("main_page_idle", false);
        s = new s05("splash_close", false);
    }

    public s05(String str, boolean z) {
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

    public static s05 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return new s05("main_page_common_tab_" + str, true);
        }
        return (s05) invokeL.objValue;
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
