package com.baidu.wallet.base.iddetect.utils;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.wallet.core.utils.LogUtil;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static com.baidu.wallet.base.iddetect.a f24231a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1531880334, "Lcom/baidu/wallet/base/iddetect/utils/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1531880334, "Lcom/baidu/wallet/base/iddetect/utils/b;");
        }
    }

    public static com.baidu.wallet.base.iddetect.a a(Context context, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{context, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (f24231a == null || z) {
                f24231a = a(i2, context);
            }
            return f24231a;
        }
        return (com.baidu.wallet.base.iddetect.a) invokeCommon.objValue;
    }

    public static Rect a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (Build.VERSION.SDK_INT < 14) {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                return new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
            Rect rect = new Rect();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRectSize(rect);
            return rect;
        }
        return (Rect) invokeL.objValue;
    }

    public static float a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i2, i3)) == null) ? a((i2 * 1.0f) / i3) : invokeII.floatValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.baidu.wallet.base.iddetect.a a(int i2, Context context) {
        InterceptResult invokeIL;
        com.baidu.wallet.base.iddetect.a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(AdIconUtil.BAIDU_LOGO_ID, null, i2, context)) == null) {
            Camera a3 = a(i2);
            if (a3 != null) {
                try {
                    if (a3.getParameters() != null) {
                        List<com.baidu.wallet.base.iddetect.a> a4 = a(a3.getParameters().getSupportedPreviewSizes());
                        Rect a5 = a(context);
                        a2 = a(context, a5, a(a5.width(), a5.height()), a4);
                        if (a3 != null) {
                            LogUtil.errord(com.baidu.wallet.base.iddetect.a.class.getSimpleName(), "release camera");
                            a3.release();
                        }
                        return a2;
                    }
                } catch (Exception e2) {
                    String simpleName = com.baidu.wallet.base.iddetect.a.class.getSimpleName();
                    LogUtil.errord(simpleName, "exception = " + e2.getMessage());
                    throw e2;
                }
            }
            a2 = null;
            if (a3 != null) {
            }
            return a2;
        }
        return (com.baidu.wallet.base.iddetect.a) invokeIL.objValue;
    }

    public static Camera a(int i2) {
        InterceptResult invokeI;
        Camera open;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 9) {
                    try {
                        if (i2 == 1) {
                            open = Camera.open(0);
                        } else {
                            open = Camera.open(1);
                        }
                    } catch (Exception unused) {
                        open = Camera.open();
                    }
                    return open;
                }
                return Camera.open();
            } catch (Exception unused2) {
                return null;
            }
        }
        return (Camera) invokeI.objValue;
    }

    public static com.baidu.wallet.base.iddetect.a a(Context context, Rect rect, float f2, List<com.baidu.wallet.base.iddetect.a> list) {
        InterceptResult invokeCommon;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{context, rect, Float.valueOf(f2), list})) == null) {
            boolean z2 = false;
            com.baidu.wallet.base.iddetect.a aVar = null;
            int i3 = 0;
            while (true) {
                if (i3 >= list.size()) {
                    z = false;
                    break;
                }
                aVar = list.get(i3);
                float a2 = a(aVar.f24225b, aVar.f24224a);
                list.get(i3).f24227d = Math.abs(a2 - f2);
                list.get(i3).f24228e = true;
                if (a2 == f2 && (i2 = aVar.f24225b) >= 480 && i2 <= 720) {
                    aVar.f24226c = 0.6306f;
                    z = true;
                    break;
                }
                i3++;
            }
            if (!z) {
                Collections.sort(list);
                int i4 = 0;
                while (true) {
                    if (i4 < list.size()) {
                        if (list.get(i4).f24225b >= 480 && list.get(i4).f24225b <= 720 && list.get(i4).f24227d <= 0.1f) {
                            aVar = list.get(i4);
                            aVar.f24226c = a(context, rect, aVar);
                            z2 = true;
                            break;
                        }
                        i4++;
                    } else {
                        break;
                    }
                }
            }
            if (!z && !z2) {
                if (aVar == null) {
                    aVar = new com.baidu.wallet.base.iddetect.a(640, 480);
                } else {
                    aVar.f24225b = 480;
                    aVar.f24224a = 640;
                }
                aVar.f24226c = a(context, rect, aVar);
            }
            return aVar;
        }
        return (com.baidu.wallet.base.iddetect.a) invokeCommon.objValue;
    }

    public static float a(Context context, Rect rect, com.baidu.wallet.base.iddetect.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, rect, aVar)) == null) {
            float width = (rect.width() * 1.0f) / aVar.f24225b;
            float height = (rect.height() * 1.0f) / aVar.f24224a;
            return width > height ? (width * 0.6306f) / height : (height * 0.6306f) / width;
        }
        return invokeLLL.floatValue;
    }

    public static List<com.baidu.wallet.base.iddetect.a> a(List<Camera.Size> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                Camera.Size size = list.get(i2);
                arrayList.add(new com.baidu.wallet.base.iddetect.a(size.width, size.height));
            }
            Collections.sort(arrayList);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static float a(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65537, null, f2)) == null) ? Float.parseFloat(new DecimalFormat("##0.00").format(f2)) : invokeF.floatValue;
    }
}
