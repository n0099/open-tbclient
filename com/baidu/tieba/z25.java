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
public class z25 {
    public static /* synthetic */ Interceptable $ic;
    public static final z25 c;
    public static final z25 d;
    public static final z25 e;
    public static final z25 f;
    public static final z25 g;
    public static final z25 h;
    public static final z25 i;
    public static final z25 j;
    public static final z25 k;
    public static final z25 l;
    public static final z25 m;
    public static final z25 n;
    public static final z25 o;
    public static final z25 p;
    public static final z25 q;
    public static final z25 r;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final boolean b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948308076, "Lcom/baidu/tieba/z25;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948308076, "Lcom/baidu/tieba/z25;");
                return;
            }
        }
        c = new z25("sync_finish", false);
        d = new z25("main_page_load_finish", false);
        e = new z25("pb_load_finish", false);
        f = new z25("frs_load_finish", false);
        g = new z25("main_page_recommend", true);
        h = new z25("main_page_common_tab", true);
        i = new z25("main_page_hot_topic", true);
        j = new z25("main_page_concern", true);
        k = new z25("main_page_enter_forum", true);
        l = new z25("main_page_message", true);
        m = new z25("main_page_person_info", true);
        n = new z25("write_page", true);
        o = new z25("pb_page", true);
        p = new z25("frs_page", true);
        q = new z25("main_page_idle", false);
        r = new z25("splash_close", false);
    }

    public z25(String str, boolean z) {
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

    public static z25 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return new z25("main_page_common_tab_" + str, true);
        }
        return (z25) invokeL.objValue;
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
