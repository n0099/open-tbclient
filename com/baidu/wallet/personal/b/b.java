package com.baidu.wallet.personal.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.utils.LogUtil;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static HashMap<String, NinePatchDrawable> a = null;

    /* renamed from: b  reason: collision with root package name */
    public static final String f51188b = "b";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1002748877, "Lcom/baidu/wallet/personal/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1002748877, "Lcom/baidu/wallet/personal/b/b;");
                return;
            }
        }
        a = new HashMap<>();
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int a(Context context, int i2) {
        InterceptResult invokeLI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, context, i2)) == null) {
            if (i2 != 8) {
                if (i2 != 11 && i2 != 22 && i2 != 33 && i2 != 44) {
                    if (i2 != 55) {
                        if (i2 != 66) {
                            switch (i2) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 6:
                                    str = "coupon_base_red_f73f31";
                                    break;
                                case 5:
                                    break;
                                default:
                                    str = "coupon_base_red_f75348";
                                    break;
                            }
                        }
                    }
                    str = "coupon_base_orage_f7d1af";
                }
                str = "coupon_base_orage_bf5f0d";
            } else {
                str = "coupon_base_orage_f3d1b1";
            }
            return ResUtils.getColor(context, str);
        }
        return invokeLI.intValue;
    }

    public static int a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, str, str2)) == null) {
            int color = ResUtils.getColor(context, str2);
            if (TextUtils.isEmpty(str)) {
                return color;
            }
            try {
                return Color.parseColor(str);
            } catch (Exception e2) {
                LogUtil.d(f51188b, e2.getMessage());
                return color;
            }
        }
        return invokeLLL.intValue;
    }

    public static GradientDrawable a(Context context, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i2, i3)) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(i2);
            gradientDrawable.setShape(i3);
            gradientDrawable.setCornerRadii(new float[]{DisplayUtils.dip2px(context, 1.5f), DisplayUtils.dip2px(context, 1.5f), DisplayUtils.dip2px(context, 1.5f), DisplayUtils.dip2px(context, 1.5f), DisplayUtils.dip2px(context, 1.5f), DisplayUtils.dip2px(context, 1.5f), DisplayUtils.dip2px(context, 1.5f), DisplayUtils.dip2px(context, 1.5f)});
            return gradientDrawable;
        }
        return (GradientDrawable) invokeLII.objValue;
    }

    public static GradientDrawable a(Context context, int i2, int i3, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2)})) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(i2);
            gradientDrawable.setShape(i3);
            gradientDrawable.setCornerRadii(new float[]{DisplayUtils.dip2px(context, f2), DisplayUtils.dip2px(context, f2), DisplayUtils.dip2px(context, f2), DisplayUtils.dip2px(context, f2), DisplayUtils.dip2px(context, f2), DisplayUtils.dip2px(context, f2), DisplayUtils.dip2px(context, f2), DisplayUtils.dip2px(context, f2)});
            return gradientDrawable;
        }
        return (GradientDrawable) invokeCommon.objValue;
    }

    public static NinePatchDrawable a(Context context, String str) {
        InterceptResult invokeLL;
        NinePatchDrawable b2;
        HashMap<String, NinePatchDrawable> hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) {
            String str2 = str.contains(",") ? str.split(",")[0] : str;
            HashMap<String, NinePatchDrawable> hashMap2 = a;
            if (hashMap2 == null) {
                b2 = b(context, str2);
                hashMap = new HashMap<>();
                a = hashMap;
            } else if (hashMap2.containsKey(str) && a.get(str) != null) {
                return a.get(str);
            } else {
                b2 = b(context, str2);
                hashMap = a;
            }
            hashMap.put(str, b2);
            return b2;
        }
        return (NinePatchDrawable) invokeLL.objValue;
    }

    public static NinePatchDrawable a(Context context, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65543, null, context, str, i2)) == null) {
            return a(context, str + "," + i2);
        }
        return (NinePatchDrawable) invokeLLI.objValue;
    }

    public static int b(Context context, int i2) {
        InterceptResult invokeLI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, context, i2)) == null) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        str = "coupon_base_yellow_f1ac00";
                    } else if (i2 != 4) {
                        if (i2 != 5) {
                            if (i2 == 8) {
                                return -1;
                            }
                            if (i2 != 11 && i2 != 22 && i2 != 33 && i2 != 44) {
                                if (i2 != 55) {
                                    if (i2 != 66) {
                                        str = "coupon_base_red_f75348";
                                    }
                                }
                            }
                            str = "coupon_base_yellow_c77228";
                        }
                    }
                    return ResUtils.getColor(context, str);
                }
                str = "coupon_base_red_fc6a60";
                return ResUtils.getColor(context, str);
            }
            str = "coupon_base_blue_5077e8";
            return ResUtils.getColor(context, str);
        }
        return invokeLI.intValue;
    }

    public static NinePatchDrawable b(Context context, String str) {
        InterceptResult invokeLL;
        BitmapDrawable bitmapDrawable;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, context, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    bitmapDrawable = (BitmapDrawable) ResUtils.getDrawable(context, str);
                } catch (OutOfMemoryError unused) {
                    Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_4444);
                    createBitmap.eraseColor(Color.parseColor("#f5f5f5"));
                    bitmapDrawable = new BitmapDrawable(createBitmap);
                }
                if (bitmapDrawable != null && (bitmap = bitmapDrawable.getBitmap()) != null) {
                    LogUtil.d("coupon", "bitmap res height = " + bitmap.getHeight() + " ; width = " + bitmap.getWidth() + " ; density = " + bitmap.getDensity());
                    a aVar = new a(context.getResources(), bitmap);
                    aVar.a(1);
                    return aVar.c();
                }
            }
            return null;
        }
        return (NinePatchDrawable) invokeLL.objValue;
    }
}
