package com.baidu.tieba;

import android.content.Context;
import android.graphics.Color;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class yb0 extends ub0 {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<String, String[]> b;
    public static yb0 c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final yb0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-266148155, "Lcom/baidu/tieba/yb0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-266148155, "Lcom/baidu/tieba/yb0$a;");
                    return;
                }
            }
            a = new yb0();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948324258, "Lcom/baidu/tieba/yb0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948324258, "Lcom/baidu/tieba/yb0;");
                return;
            }
        }
        b = new HashMap<>();
    }

    public static yb0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c == null) {
                c = a.a;
            }
            return c;
        }
        return (yb0) invokeV.objValue;
    }

    public yb0() {
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
        b.put("color_1F1F1F", new String[]{"#FFFFFF"});
        b.put("color_white1", new String[]{"#161823"});
        b.put("color_white2", new String[]{"#1F2337"});
        b.put("color_white3", new String[]{"#FFFFFF"});
        b.put("color_F5F5F51", new String[]{"#161823"});
        b.put("color_F5F5F52", new String[]{"#161823"});
        b.put("color_F5F5F53", new String[]{"#1AFFFFFF"});
        b.put("color_FF33551", new String[]{"#FF3355"});
        b.put("color_FF33552", new String[]{"#26FF3355"});
        b.put("color_858585", new String[]{"#858585"});
        b.put("color_525252", new String[]{"#858585"});
        b.put("color_FF3333", new String[]{"#FF3333"});
        b.put("color_768CAE", new String[]{"#768CAE"});
        b.put("color_4E6EF2", new String[]{"#4E6EF2"});
        b.put("color_8585852", new String[]{"#858585"});
        b.put("color_5252522", new String[]{"#99FFFFFF"});
        b.put("color_btn_stroke", new String[]{"#99FFFFFF"});
        b.put("color_btn_fill", new String[]{"#66666666"});
        b.put("color_sub_tab_normal", new String[]{"#858585"});
        b.put("color_main_bg", new String[]{"#161823"});
        b.put("color_white4", new String[]{"#FFFFFF"});
        b.put("color_E0E0E0", new String[]{"#33ffffff"});
        b.put("color_EEEEEE", new String[]{"#121212"});
    }

    @Override // com.baidu.tieba.ub0
    public int a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, str, str2)) == null) {
            if (!b.containsKey(str2)) {
                return -1;
            }
            try {
                return Color.parseColor(b.get(str2)[0]);
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        }
        return invokeLLL.intValue;
    }
}
