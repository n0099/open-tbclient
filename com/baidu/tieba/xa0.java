package com.baidu.tieba;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.minivideo.arface.bean.Sticker;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes9.dex */
public class xa0 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public static String b;
    public static String c;
    public static String d;
    public static Sticker e;
    public static String f;
    public static String g;
    public static String h;
    public static String i;
    public static String j;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948293506, "Lcom/baidu/tieba/xa0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948293506, "Lcom/baidu/tieba/xa0;");
        }
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? "/filter_config.json" : (String) invokeV.objValue;
    }

    public xa0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        h(str);
    }

    public static String d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65541, null, z)) == null) {
            if (z) {
                return i;
            }
            return j;
        }
        return (String) invokeZ.objValue;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return a;
        }
        return (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return f;
        }
        return (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return g;
        }
        return (String) invokeV.objValue;
    }

    public static Sticker f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return e;
        }
        return (Sticker) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return c;
        }
        return (String) invokeV.objValue;
    }

    public static void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            if (wa0.n()) {
                Log.d("DuAr_DuArResConfig", "setPath: " + str);
            }
            String str2 = str + "/";
            a = str2;
            b = str2;
            r0 = a + "ext/";
            c = b + "faceModels/";
            if (TextUtils.isEmpty(str)) {
                f = "file:///android_asset/arsource/filters/yuantu/yuantu.png";
                c = "file:///android_asset/arsource/faceModels/";
                String str3 = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo/arsource";
                g = str3 + "/makeup";
                h = str3 + "/beauty";
                i = str3 + "/arFilterInit";
                j = str3 + "/arFilterEditInit";
                String str4 = h + "/liveVideoFace/live_face_knead.json";
                String str5 = h + "/liveVideoFace/goddess_face_knead.json";
                String str6 = h + "/liveVideoFace/baby_face_knead.json";
            } else {
                f = b + "filters/yuantu/yuantu.png";
                String str7 = b + "filter/beauty_skin_stream.png";
                String str8 = b + "filter/beauty_skin_small_video.png";
                g = a + "makeup/";
                h = a + "beauty/";
                i = a + "arFilterInit/";
                j = a + "arFilterEditInit/";
                r0 = h + "liveVideoFace/live_face_knead.json";
                String str9 = h + "liveVideoFace/goddess_face_knead.json";
                String str10 = h + "liveVideoFace/baby_face_knead.json";
                if (e == null) {
                    Sticker sticker = new Sticker();
                    sticker.setArTyp(10);
                    sticker.setFile(new File(a + "sticker/none_effect"));
                    sticker.setId("-1");
                    sticker.setMiniVersion(480);
                    sticker.setMaxVersion(Integer.MAX_VALUE);
                    e = sticker;
                }
            }
            r0 = b + "global";
            String str11 = b + "vip_list.json";
            d = b + "filters";
            r0 = b + "dlModels/";
            String str12 = d + "/all";
            r0 = b + "global/res/filter";
        }
    }
}
