package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class rw4 {
    public static /* synthetic */ Interceptable $ic;
    public static final rw4 c;
    public static final rw4 d;
    public static final rw4 e;
    public static final rw4 f;
    public static final rw4 g;
    public static final rw4 h;
    public static final rw4 i;
    public static final rw4 j;
    public static final rw4 k;
    public static final rw4 l;
    public static final rw4 m;
    public static final rw4 n;
    public static final rw4 o;
    public static final rw4 p;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final boolean b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948136026, "Lcom/baidu/tieba/rw4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948136026, "Lcom/baidu/tieba/rw4;");
                return;
            }
        }
        c = new rw4("sync_finish", false);
        d = new rw4("main_page_load_finish", false);
        e = new rw4("pb_load_finish", false);
        f = new rw4("frs_load_finish", false);
        g = new rw4("main_page_recommend", true);
        h = new rw4("main_page_common_tab", true);
        i = new rw4("main_page_hot_topic", true);
        j = new rw4("main_page_concern", true);
        k = new rw4("main_page_enter_forum", true);
        l = new rw4("main_page_message", true);
        m = new rw4("main_page_person_info", true);
        n = new rw4("write_page", true);
        o = new rw4("pb_page", true);
        p = new rw4("frs_page", true);
    }

    public rw4(String str, boolean z) {
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

    public static rw4 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return new rw4("main_page_common_tab_" + str, true);
        }
        return (rw4) invokeL.objValue;
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
