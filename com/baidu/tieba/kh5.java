package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.dynamicres.data.AgreeMaterial;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class kh5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AgreeMaterial a;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final kh5 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-661266157, "Lcom/baidu/tieba/kh5$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-661266157, "Lcom/baidu/tieba/kh5$b;");
                    return;
                }
            }
            a = new kh5(null);
        }
    }

    public kh5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static kh5 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (kh5) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        AgreeMaterial.Data data;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            AgreeMaterial agreeMaterial = this.a;
            if (agreeMaterial != null && (data = agreeMaterial.doubleTapData) != null) {
                return data.activityId;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        AgreeMaterial.Data data;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            AgreeMaterial agreeMaterial = this.a;
            if (agreeMaterial != null && (data = agreeMaterial.longPressData) != null) {
                return data.activityId;
            }
            return "1";
        }
        return (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        AgreeMaterial.Data data;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            AgreeMaterial agreeMaterial = this.a;
            if (agreeMaterial != null && (data = agreeMaterial.singleTapData) != null) {
                return data.activityId;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public /* synthetic */ kh5(a aVar) {
        this();
    }

    public void a(AgreeMaterial agreeMaterial) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, agreeMaterial) == null) {
            this.a = agreeMaterial;
            if (agreeMaterial == null) {
                return;
            }
            AgreeMaterial.Data data = agreeMaterial.staticData;
            if (data != null) {
                data.N();
            }
            AgreeMaterial.Data data2 = agreeMaterial.singleTapData;
            if (data2 != null) {
                data2.N();
            }
            AgreeMaterial.Data data3 = agreeMaterial.doubleTapData;
            if (data3 != null) {
                data3.N();
            }
            AgreeMaterial.Data data4 = agreeMaterial.longPressData;
            if (data4 != null) {
                data4.N();
            }
        }
    }

    public final void j(@NonNull jh5 jh5Var) {
        boolean z;
        int i;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jh5Var) == null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i = R.raw.lottie_pb_new_double_tap_agree_2;
            } else {
                i = R.raw.lottie_pb_new_double_tap_agree;
            }
            if (z) {
                str = "lottie_pb_new_double_tap_agree_2/";
            } else {
                str = "lottie_pb_new_double_tap_agree/";
            }
            jh5Var.a(i, str);
        }
    }

    public void b(String str, String str2, jh5 jh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jh5Var) == null) {
            d("", str, str2, true, 2, jh5Var);
        }
    }

    public final void m(int i, String str, jh5 jh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048587, this, i, str, jh5Var) == null) {
            if (i != 1) {
                if (i != 2) {
                    jh5Var.a(0, null);
                    return;
                } else {
                    j(jh5Var);
                    return;
                }
            }
            n(jh5Var, str);
        }
    }

    public void c(ih5 ih5Var) {
        AgreeMaterial.Data data;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ih5Var) != null) || ih5Var == null) {
            return;
        }
        AgreeMaterial agreeMaterial = this.a;
        if (agreeMaterial != null && (data = agreeMaterial.longPressData) != null) {
            String P = data.P("", "", "");
            if (StringUtils.isNull(P)) {
                l(ih5Var);
                return;
            } else {
                k(P, ih5Var);
                return;
            }
        }
        l(ih5Var);
    }

    public final void d(String str, String str2, String str3, boolean z, int i, jh5 jh5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, Boolean.valueOf(z), Integer.valueOf(i), jh5Var}) != null) || jh5Var == null) {
            return;
        }
        if (str == null) {
            str = "";
        }
        AgreeMaterial agreeMaterial = this.a;
        if (agreeMaterial != null && z) {
            AgreeMaterial.Data data = null;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            data = agreeMaterial.longPressData;
                        }
                    } else {
                        data = agreeMaterial.doubleTapData;
                    }
                } else {
                    data = agreeMaterial.singleTapData;
                }
            } else {
                data = agreeMaterial.staticData;
            }
            if (data == null) {
                m(i, str, jh5Var);
                return;
            }
            String P = data.P(str, str2, str3);
            if (StringUtils.isNull(P)) {
                m(i, str, jh5Var);
                return;
            } else {
                jh5Var.b(P);
                return;
            }
        }
        m(i, str, jh5Var);
    }

    public void e(String str, String str2, String str3, boolean z, jh5 jh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, str3, Boolean.valueOf(z), jh5Var}) == null) {
            d(str, str2, str3, z, 1, jh5Var);
        }
    }

    public final void k(String str, ih5 ih5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, ih5Var) == null) {
            ArrayList arrayList = new ArrayList();
            File file = new File(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + TbConfig.getTempDirName() + "/animation/" + str);
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        arrayList.add(BitmapFactory.decodeFile(file2.toString()));
                    }
                    ih5Var.a(arrayList);
                    return;
                }
                l(ih5Var);
                return;
            }
            l(ih5Var);
        }
    }

    public final void l(ih5 ih5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ih5Var) == null) {
            ArrayList arrayList = new ArrayList();
            Bitmap decodeResource = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.icon_mask_zuma_emotion_1);
            Bitmap decodeResource2 = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.icon_mask_zuma_emotion_2);
            Bitmap decodeResource3 = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.icon_mask_zuma_emotion_3);
            Bitmap decodeResource4 = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.icon_mask_zuma_emotion_4);
            Bitmap decodeResource5 = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.icon_mask_zuma_emotion_5);
            arrayList.add(decodeResource);
            arrayList.add(decodeResource2);
            arrayList.add(decodeResource3);
            arrayList.add(decodeResource4);
            arrayList.add(decodeResource5);
            ih5Var.a(arrayList);
        }
    }

    public final void n(@NonNull jh5 jh5Var, String str) {
        boolean z;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, jh5Var, str) == null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                z = true;
            } else {
                z = false;
            }
            if ("/feed".equals(str)) {
                if (z) {
                    i2 = R.raw.lottie_feed_new_agree_2;
                } else {
                    i2 = R.raw.lottie_feed_new_agree;
                }
                jh5Var.a(i2, "lottie_feed_new_agree/");
            } else if ("/duang1".equals(str)) {
                jh5Var.a(R.raw.lottie_feed_agree_fire_duang1, "lottie_feed_firework_duang1/");
            } else if ("/duang2".equals(str)) {
                jh5Var.a(R.raw.lottie_feed_agree_fire_duang2, "lottie_feed_firework_duang2/");
            } else {
                if (z) {
                    i = R.raw.lottie_pb_new_agree_2;
                } else {
                    i = R.raw.lottie_pb_new_agree;
                }
                jh5Var.a(i, "lottie_feed_new_agree/");
            }
        }
    }
}
