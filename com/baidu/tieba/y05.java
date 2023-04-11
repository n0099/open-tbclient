package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class y05 {
    public static /* synthetic */ Interceptable $ic;
    public static final y05 c;
    public static final y05 d;
    public static final y05 e;
    public static final y05 f;
    public static final y05 g;
    public static final y05 h;
    public static final y05 i;
    public static final y05 j;
    public static final y05 k;
    public static final y05 l;
    public static final y05 m;
    public static final y05 n;
    public static final y05 o;
    public static final y05 p;
    public static final y05 q;
    public static final y05 r;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final boolean b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948276363, "Lcom/baidu/tieba/y05;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948276363, "Lcom/baidu/tieba/y05;");
                return;
            }
        }
        c = new y05("sync_finish", false);
        d = new y05("main_page_load_finish", false);
        e = new y05("pb_load_finish", false);
        f = new y05("frs_load_finish", false);
        g = new y05("main_page_recommend", true);
        h = new y05("main_page_common_tab", true);
        i = new y05("main_page_hot_topic", true);
        j = new y05("main_page_concern", true);
        k = new y05("main_page_enter_forum", true);
        l = new y05("main_page_message", true);
        m = new y05("main_page_person_info", true);
        n = new y05("write_page", true);
        o = new y05("pb_page", true);
        p = new y05("frs_page", true);
        q = new y05("main_page_idle", false);
        r = new y05("splash_close", false);
    }

    public y05(String str, boolean z) {
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

    public static y05 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return new y05("main_page_common_tab_" + str, true);
        }
        return (y05) invokeL.objValue;
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
