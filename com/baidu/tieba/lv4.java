package com.baidu.tieba;

import android.app.Application;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.Direction;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Arrays;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class lv4 {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap a;
    public static final HashMap b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947956319, "Lcom/baidu/tieba/lv4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947956319, "Lcom/baidu/tieba/lv4;");
                return;
            }
        }
        a = new HashMap();
        b = new HashMap();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            a.clear();
            b.clear();
        }
    }

    public static float[] A(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, strArr)) == null) {
            int min = Math.min(strArr.length, 4);
            float[] fArr = new float[8];
            for (int i = 0; i < min; i++) {
                float y = y(strArr[i]);
                int i2 = i * 2;
                fArr[i2] = y;
                fArr[i2 + 1] = y;
            }
            return fArr;
        }
        return (float[]) invokeL.objValue;
    }

    public static String p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65562, null, i)) == null) {
            try {
                String str = (String) b.get(Integer.valueOf(i));
                if (str == null) {
                    if (i == 0) {
                        str = "";
                    } else {
                        str = TbadkCoreApplication.getInst().getResources().getResourceEntryName(i);
                    }
                    b.put(Integer.valueOf(i), str);
                }
                return str;
            } catch (ArrayIndexOutOfBoundsException e) {
                ih9.g(e);
                return "";
            }
        }
        return (String) invokeI.objValue;
    }

    public static Drawable B(View view2, Drawable drawable, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, view2, drawable, strArr)) == null) {
            if (strArr != null && strArr.length == 3) {
                String[] split = strArr[2].split(",");
                if (split.length == 2) {
                    mv4 mv4Var = (mv4) d(drawable).clone();
                    mv4Var.L(k(strArr[0]));
                    mv4Var.M(o(strArr[1]));
                    mv4Var.I(o(split[0]));
                    mv4Var.J(o(split[1]));
                    return mv4Var.n(view2);
                }
                throw new IndexOutOfBoundsException("Please check the number of xy resource!");
            }
            throw new IndexOutOfBoundsException("Please check the number of shadow resource!");
        }
        return (Drawable) invokeLLL.objValue;
    }

    public static float[] C(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            String[] G = G(i);
            float[] fArr = new float[4];
            if (G != null && G.length == 3) {
                String[] split = G[2].split(",");
                if (split.length == 2) {
                    fArr[0] = k(G[0]);
                    fArr[1] = o(G[1]);
                    fArr[2] = o(split[0]);
                    fArr[3] = o(split[1]);
                    if (fArr[1] == 0.0f) {
                        fArr[1] = 0.01f;
                    }
                    return fArr;
                }
                throw new IndexOutOfBoundsException("Please check the number of xy resource!");
            }
            throw new IndexOutOfBoundsException("Please check the number of shadow resource!");
        }
        return (float[]) invokeI.objValue;
    }

    public static Drawable D(Drawable drawable, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, drawable, i, i2)) == null) {
            mv4 d = d(drawable);
            d.z();
            GradientDrawable l = d.l(i2);
            l.setColor(i(i));
            l.setStroke((int) d.t(), vl8.a(d.s(), d.r()));
            GradientDrawable l2 = d.l(i2);
            l2.setColor(vl8.a(i(i), SkinManager.RESOURCE_ALPHA_PRESS));
            l2.setStroke((int) d.t(), vl8.a(d.s(), SkinManager.RESOURCE_ALPHA_PRESS * d.r()));
            GradientDrawable l3 = d.l(i2);
            l3.setColor(vl8.a(i(i), SkinManager.RESOURCE_ALPHA_DISABLE));
            l3.setStroke((int) d.t(), vl8.a(d.s(), SkinManager.RESOURCE_ALPHA_DISABLE * d.r()));
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842910, 16842919}, l2);
            stateListDrawable.addState(new int[]{16842910, 16842908}, l2);
            stateListDrawable.addState(new int[]{-16842910}, l3);
            stateListDrawable.addState(new int[0], l);
            return stateListDrawable;
        }
        return (Drawable) invokeLII.objValue;
    }

    public static Drawable E(Drawable drawable, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65541, null, drawable, i, i2, i3)) == null) {
            mv4 d = d(drawable);
            d.z();
            GradientDrawable l = d.l(i3);
            l.setColor(i(i));
            l.setStroke((int) d.t(), vl8.a(d.s(), d.r()));
            GradientDrawable l2 = d.l(i3);
            l2.setColor(i(i2));
            l2.setStroke((int) d.t(), vl8.a(d.s(), SkinManager.RESOURCE_ALPHA_PRESS * d.r()));
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842910, 16842919}, l2);
            stateListDrawable.addState(new int[]{16842910, 16842908}, l2);
            stateListDrawable.addState(new int[0], l);
            return stateListDrawable;
        }
        return (Drawable) invokeLIII.objValue;
    }

    public static String F(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            int idByABTest = EMABTest.getIdByABTest(i, EMABTest.TYPE_STRING);
            if (idByABTest == 0) {
                return "";
            }
            return TbadkCoreApplication.getInst().getResources().getString(idByABTest);
        }
        return (String) invokeI.objValue;
    }

    public static String[] G(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) {
            return TbadkCoreApplication.getInst().getResources().getStringArray(EMABTest.getIdByABTest(i, "array"));
        }
        return (String[]) invokeI.objValue;
    }

    public static ColorStateList H(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i)) == null) {
            return SkinManager.createColorStateList(i);
        }
        return (ColorStateList) invokeI.objValue;
    }

    public static Typeface I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if ("bold".equals(str)) {
                return Typeface.DEFAULT_BOLD;
            }
            return Typeface.DEFAULT;
        }
        return (Typeface) invokeL.objValue;
    }

    public static float[] J(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65546, null, f)) == null) {
            float[] fArr = new float[8];
            Arrays.fill(fArr, f);
            return fArr;
        }
        return (float[]) invokeF.objValue;
    }

    public static float b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i)) == null) {
            return eh.d(F(i), 0.0f);
        }
        return invokeI.floatValue;
    }

    public static mv4 d(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, drawable)) == null) {
            if (drawable instanceof mv4) {
                return (mv4) drawable;
            }
            return mv4.y();
        }
        return (mv4) invokeL.objValue;
    }

    public static mv4 e(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, view2)) == null) {
            Drawable background = view2.getBackground();
            if (background instanceof mv4) {
                return (mv4) background;
            }
            return mv4.y();
        }
        return (mv4) invokeL.objValue;
    }

    public static int i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65555, null, i)) == null) {
            return SkinManager.getColor(i);
        }
        return invokeI.intValue;
    }

    public static int k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, str)) == null) {
            return i(t(str, "color"));
        }
        return invokeL.intValue;
    }

    public static int n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65560, null, i)) == null) {
            return UtilHelper.getDimenPixelSize(i);
        }
        return invokeI.intValue;
    }

    public static int o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, str)) == null) {
            return n(t("tbds" + str, EMABTest.TYPE_DIMEN));
        }
        return invokeL.intValue;
    }

    public static int[] r(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, iArr)) == null) {
            int length = iArr.length;
            for (int i = 0; i < length; i++) {
                iArr[i] = i(iArr[i]);
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public static int[] s(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, strArr)) == null) {
            int length = strArr.length;
            int[] iArr = new int[length];
            for (int i = 0; i < length; i++) {
                iArr[i] = k(strArr[i]);
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public static float[] v(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, strArr)) == null) {
            int min = Math.min(strArr.length, 4);
            float[] fArr = new float[min];
            for (int i = 0; i < min; i++) {
                fArr[i] = eh.d(strArr[i], 0.0f);
            }
            return fArr;
        }
        return (float[]) invokeL.objValue;
    }

    public static float y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, str)) == null) {
            if (str.endsWith("H")) {
                return Float.parseFloat(str.substring(0, str.length() - 1));
            }
            return o(str);
        }
        return invokeL.floatValue;
    }

    public static Drawable c(Drawable drawable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, drawable, i)) == null) {
            mv4 mv4Var = (mv4) d(drawable).clone();
            mv4Var.A(b(i));
            return mv4Var;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static Drawable f(Drawable drawable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65552, null, drawable, i)) == null) {
            mv4 mv4Var = (mv4) d(drawable).clone();
            mv4Var.D(b(i));
            return mv4Var;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static Drawable g(Drawable drawable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65553, null, drawable, i)) == null) {
            mv4 mv4Var = (mv4) d(drawable).clone();
            mv4Var.E(i(i));
            return mv4Var;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static Drawable h(Drawable drawable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65554, null, drawable, i)) == null) {
            mv4 mv4Var = (mv4) d(drawable).clone();
            mv4Var.F(n(i));
            return mv4Var;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static Drawable j(Drawable drawable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65556, null, drawable, i)) == null) {
            mv4 mv4Var = (mv4) d(drawable).clone();
            mv4Var.B(i(i));
            return mv4Var;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static Drawable l(Drawable drawable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65558, null, drawable, i)) == null) {
            mv4 mv4Var = (mv4) d(drawable).clone();
            mv4Var.P(A(F(i).split(",")));
            return mv4Var;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static Drawable m(Drawable drawable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65559, null, drawable, i)) == null) {
            mv4 mv4Var = (mv4) d(drawable).clone();
            mv4Var.G(i);
            return mv4Var;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static Drawable w(Drawable drawable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65569, null, drawable, i)) == null) {
            mv4 mv4Var = (mv4) d(drawable).clone();
            mv4Var.E(i);
            return mv4Var;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static Drawable x(Drawable drawable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65570, null, drawable, i)) == null) {
            mv4 mv4Var = (mv4) d(drawable).clone();
            mv4Var.B(i);
            return mv4Var;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static Drawable q(Drawable drawable, Direction direction, int[] iArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65563, null, drawable, direction, iArr)) == null) {
            mv4 mv4Var = (mv4) d(drawable).clone();
            r(iArr);
            mv4Var.C(iArr);
            mv4Var.H(direction);
            return mv4Var;
        }
        return (Drawable) invokeLLL.objValue;
    }

    public static int t(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65566, null, str, str2)) == null) {
            HashMap hashMap = (HashMap) a.get(str2);
            if (hashMap == null) {
                hashMap = new HashMap();
                a.put(str2, hashMap);
            }
            Integer num = (Integer) hashMap.get(str);
            if (num == null) {
                num = Integer.valueOf(TbadkCoreApplication.getInst().getResources().getIdentifier(str, str2, TbadkCoreApplication.getInst().getPackageName()));
                hashMap.put(str, num);
            }
            return num.intValue();
        }
        return invokeLL.intValue;
    }

    public static Drawable u(Drawable drawable, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65567, null, drawable, strArr)) == null) {
            if (strArr != null && strArr.length == 3) {
                String[] split = strArr[0].split(",");
                String[] split2 = strArr[1].split(",");
                String str = strArr[2];
                mv4 mv4Var = (mv4) d(drawable).clone();
                if (!TextUtils.isEmpty(str)) {
                    mv4Var.H(Direction.valueOf(str.toUpperCase()));
                }
                mv4Var.C(s(split));
                mv4Var.K(v(split2));
                return mv4Var;
            }
            throw new IndexOutOfBoundsException("Please check the number of mask resource!");
        }
        return (Drawable) invokeLL.objValue;
    }

    public static float[] z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65572, null, i)) == null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (app == null) {
                return J(0.0f);
            }
            String[] split = app.getString(i).split(",");
            int min = Math.min(split.length, 4);
            float[] fArr = new float[8];
            for (int i2 = 0; i2 < min; i2++) {
                float y = y(split[i2]);
                int i3 = i2 * 2;
                fArr[i3] = y;
                fArr[i3 + 1] = y;
            }
            return fArr;
        }
        return (float[]) invokeI.objValue;
    }
}
