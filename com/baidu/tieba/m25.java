package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class m25 {
    public static /* synthetic */ Interceptable $ic;
    public static final m25 c;
    public static final m25 d;
    public static final m25 e;
    public static final m25 f;
    public static final m25 g;
    public static final m25 h;
    public static final m25 i;
    public static final m25 j;
    public static final m25 k;
    public static final m25 l;
    public static final m25 m;
    public static final m25 n;
    public static final m25 o;
    public static final m25 p;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final boolean b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947920793, "Lcom/baidu/tieba/m25;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947920793, "Lcom/baidu/tieba/m25;");
                return;
            }
        }
        c = new m25("sync_finish", false);
        d = new m25("main_page_load_finish", false);
        e = new m25("pb_load_finish", false);
        f = new m25("frs_load_finish", false);
        g = new m25("main_page_recommend", true);
        h = new m25("main_page_common_tab", true);
        i = new m25("main_page_hot_topic", true);
        j = new m25("main_page_concern", true);
        k = new m25("main_page_enter_forum", true);
        l = new m25("main_page_message", true);
        m = new m25("main_page_person_info", true);
        n = new m25("write_page", true);
        o = new m25("pb_page", true);
        p = new m25("frs_page", true);
    }

    public m25(String str, boolean z) {
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

    public static m25 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return new m25("main_page_common_tab_" + str, true);
        }
        return (m25) invokeL.objValue;
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
