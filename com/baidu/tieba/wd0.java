package com.baidu.tieba;

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
/* loaded from: classes8.dex */
public class wd0 extends xd0 {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<String, String[]> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948266598, "Lcom/baidu/tieba/wd0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948266598, "Lcom/baidu/tieba/wd0;");
                return;
            }
        }
        b = new HashMap<>();
    }

    public wd0() {
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
        b.put("color_1F1F1F", new String[]{"#1F1F1F", "#666666", "", "#858585", "#E6FFFFFF"});
        b.put("color_white1", new String[]{"#FFFFFF", "#191919", "", "#161823", "#161823"});
        b.put("color_white2", new String[]{"#FFFFFF", "#222222", "", "#1F2337", "#1F2337"});
        b.put("color_white3", new String[]{"#FFFFFF", "#4DFFFFFF", "", "#FFFFFF", "#E6FFFFFF"});
        b.put("color_F5F5F51", new String[]{"#F5F5F5", "#191919", "", "#161823", "#00000000"});
        b.put("color_F5F5F52", new String[]{"#F5F5F5", "#121212", "", "#161823", "#161823"});
        b.put("color_F5F5F53", new String[]{"#F5F5F5", "#121212", "", "#1AFFFFFF", "#1AFFFFFF"});
        b.put("color_FF33551", new String[]{"#FF3355", "#80192A", "", "#FF3355", "#FF3355"});
        b.put("color_FF33552", new String[]{"#1AFF3355", "#1A80192A", "", "#26FF3355", "#26FF3355"});
        b.put("color_858585", new String[]{"#858585", "#444444", "", "#858585", "#80FFFFFF"});
        b.put("color_525252", new String[]{"#525252", "#555555", "", "#858585", "#858585"});
        b.put("color_FF3333", new String[]{"#FF3333", "#7F1919", "", "#FF3333", "#FF3333"});
        b.put("color_768CAE", new String[]{"#768CAE", "#3A4556", "", "#768CAE", "#768CAE"});
        b.put("color_4E6EF2", new String[]{"#4E6EF2", "#263678", "", "#4E6EF2", "#4E6EF2"});
        b.put("color_8585852", new String[]{"#858585", "#444444", "", "#858585", "#858585"});
        b.put("color_5252522", new String[]{"#525252", "#555555", "", "#99FFFFFF", "#99FFFFFF"});
        b.put("color_btn_stroke", new String[]{"#B8B8B8", "#00000000", "", "#00000000", "#00000000"});
        b.put("color_btn_fill", new String[]{"#00000000", "#303030", "", "#66666666", "#66666666"});
        b.put("color_sub_tab_normal", new String[]{"#1F1F1F", "#666666", "", "#858585", "#858585"});
        b.put("color_main_bg", new String[]{"#FFFFFF", "#191919", "", "#161823", "#00000000"});
        b.put("color_white4", new String[]{"#1F1F1F", "#666666", "", "#FFFFFF", "#E6FFFFFF"});
        b.put("color_gradient_1", new String[]{"#FFFFFF", "#191919", "", "#161823", "#161823"});
        b.put("color_gradient_2", new String[]{"#00FFFFFF", "#00191919", "", "#00161823", "#00161823"});
        b.put("color_4367B4", new String[]{"#4367B4", "#21335A", "", "#BF75B1FF", "#BF75B1FF"});
        b.put("color_8585853", new String[]{"#858585", "#444444", "", "#7FFFFFFF", "#7FFFFFFF"});
        b.put("color_B8B8B8", new String[]{"#B8B8B8", "#4D4D4D", "", "#66FFFFFF", "#66FFFFFF"});
        b.put("color_E0E0E0", new String[]{"#E0E0E0", "#33ffffff", "", ""});
        b.put("color_EEEEEE", new String[]{"#eeeeee", "#121212", "", ""});
    }

    @Override // com.baidu.tieba.xd0
    public int a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, str, str2)) == null) {
            String[] strArr = b.get(str2);
            if (strArr == null) {
                return -16777216;
            }
            String str3 = strArr[0];
            if ("recommend".equals(str)) {
                return be0.c().a(context, str, str2);
            }
            if (LiveFeedPageSdk.IMMERSION.equals(str)) {
                str3 = strArr[3];
            } else if (!LiveFeedPageSdk.VIDEO_BAR.equals(str) && !LiveFeedPageSdk.FOLLOW_VIDEO.equals(str)) {
                if ("night".equals(this.a)) {
                    str3 = strArr[1];
                }
            } else {
                str3 = strArr[4];
            }
            if (rd0.a(str3)) {
                return -16777216;
            }
            try {
                return Color.parseColor(str3);
            } catch (Exception e) {
                e.printStackTrace();
                return -16777216;
            }
        }
        return invokeLLL.intValue;
    }
}
