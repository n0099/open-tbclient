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
public class l65 {
    public static /* synthetic */ Interceptable $ic;
    public static final l65 c;
    public static final l65 d;
    public static final l65 e;
    public static final l65 f;
    public static final l65 g;
    public static final l65 h;
    public static final l65 i;
    public static final l65 j;
    public static final l65 k;
    public static final l65 l;
    public static final l65 m;
    public static final l65 n;
    public static final l65 o;
    public static final l65 p;
    public static final l65 q;
    public static final l65 r;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final boolean b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947894846, "Lcom/baidu/tieba/l65;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947894846, "Lcom/baidu/tieba/l65;");
                return;
            }
        }
        c = new l65("sync_finish", false);
        d = new l65("main_page_load_finish", false);
        e = new l65("pb_load_finish", false);
        f = new l65("frs_load_finish", false);
        g = new l65("main_page_recommend", true);
        h = new l65("main_page_common_tab", true);
        i = new l65("main_page_hot_topic", true);
        j = new l65("main_page_concern", true);
        k = new l65("main_page_enter_forum", true);
        l = new l65("main_page_message", true);
        m = new l65("main_page_person_info", true);
        n = new l65("write_page", true);
        o = new l65("pb_page", true);
        p = new l65("frs_page", true);
        q = new l65("main_page_idle", false);
        r = new l65("splash_close", false);
    }

    public l65(String str, boolean z) {
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

    public static l65 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return new l65("main_page_common_tab_" + str, true);
        }
        return (l65) invokeL.objValue;
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
