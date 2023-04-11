package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class vb0 extends ub0 {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<String, String[]> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948234885, "Lcom/baidu/tieba/vb0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948234885, "Lcom/baidu/tieba/vb0;");
                return;
            }
        }
        b = new HashMap<>();
    }

    public vb0() {
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
        b.put("color_1F1F1F", new String[]{"#1F1F1F", "", "#CCFFFFFF", ""});
        b.put("color_white1", new String[]{"#FFFFFF", "", "#1C1C1C", ""});
        b.put("color_white2", new String[]{"#FFFFFF", "", "#333333", ""});
        b.put("color_white3", new String[]{"#FFFFFF", "", "#FFFFFF", ""});
        b.put("color_F5F5F51", new String[]{"#F4F5F6", "", "#1C1C1C", ""});
        b.put("color_F5F5F52", new String[]{"#F4F5F6", "", "#000000", ""});
        b.put("color_F5F5F53", new String[]{"#F4F5F6", "", "#292929", ""});
        b.put("color_FF33551", new String[]{"#FF3355", "", "#F63B68", ""});
        b.put("color_FF33552", new String[]{"#1AFF3355", "", "#26F63B68", ""});
        b.put("color_858585", new String[]{"#858585", "", "#80FFFFFF", ""});
        b.put("color_525252", new String[]{"#525252", "", "#80FFFFFF", ""});
        b.put("color_FF3333", new String[]{"#FF3333", "", "#FF3333", ""});
        b.put("color_768CAE", new String[]{"#768CAE", "", "#768CAE", ""});
        b.put("color_4E6EF2", new String[]{"#4E6EF2", "", "#4E6EF2", ""});
        b.put("color_8585852", new String[]{"#858585", "", "#66FFFFFF", ""});
        b.put("color_5252522", new String[]{"#525252", "", "#1AFFFFFF", ""});
        b.put("color_btn_stroke", new String[]{"#EEEEEE", "", "#00FFFFFF", ""});
        b.put("color_btn_fill", new String[]{"#00000000", "", "#1AFFFFFF", ""});
        b.put("color_sub_tab_normal", new String[]{"#888888", "", "#CCFFFFFF", ""});
        b.put("color_main_bg", new String[]{"#FFFFFF", "", "#1C1C1C", ""});
        b.put("color_white4", new String[]{"#1F1F1F", "", "#CCFFFFFF", ""});
        b.put("color_gradient_1", new String[]{"#FFFFFF", "", "#1C1C1C", ""});
        b.put("color_gradient_2", new String[]{"#00FFFFFF", "", "#001C1C1C", ""});
        b.put("color_E0E0E0", new String[]{"#E0E0E0", "", "", ""});
        b.put("color_EEEEEE", new String[]{"#eeeeee", "", "", ""});
    }

    @Override // com.baidu.tieba.ub0
    @SuppressLint({"Range"})
    public int a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, str, str2)) == null) {
            if (!b.containsKey(str2)) {
                return -16777216;
            }
            String str3 = "";
            try {
                str3 = b.get(str2)[0];
            } catch (Exception e) {
                LiveFeedPageSdk.liveLog("getColor Exception: " + e.getMessage());
            }
            if ("recommend".equals(str)) {
                return yb0.c().a(context, str, str2);
            }
            if (LiveFeedPageSdk.IMMERSION.equals(str)) {
                str3 = b.get(str2)[3];
            } else if ("dark".equals(this.a)) {
                str3 = b.get(str2)[2];
            }
            if (ob0.a(str3)) {
                return -16777216;
            }
            try {
                return Color.parseColor(str3);
            } catch (Exception e2) {
                e2.printStackTrace();
                return -16777216;
            }
        }
        return invokeLLL.intValue;
    }
}
