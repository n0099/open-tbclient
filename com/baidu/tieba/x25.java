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
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategyGroup;
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
/* loaded from: classes9.dex */
public class x25 {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<String, HashMap<String, Integer>> a;
    public static final HashMap<Integer, String> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948248494, "Lcom/baidu/tieba/x25;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948248494, "Lcom/baidu/tieba/x25;");
                return;
            }
        }
        a = new HashMap<>();
        b = new HashMap<>();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            a.clear();
            b.clear();
        }
    }

    public static float A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str.endsWith(IEruptionStrategyGroup.STRATEGY_MODIFIER_H)) {
                return Float.parseFloat(str.substring(0, str.length() - 1));
            }
            return q(str);
        }
        return invokeL.floatValue;
    }

    public static String H(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i)) == null) {
            int idByABTest = EMABTest.getIdByABTest(i, EMABTest.TYPE_STRING);
            if (idByABTest == 0) {
                return "";
            }
            return TbadkCoreApplication.getInst().getResources().getString(idByABTest);
        }
        return (String) invokeI.objValue;
    }

    public static String[] I(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i)) == null) {
            return TbadkCoreApplication.getInst().getResources().getStringArray(EMABTest.getIdByABTest(i, "array"));
        }
        return (String[]) invokeI.objValue;
    }

    public static ColorStateList J(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i)) == null) {
            return SkinManager.createColorStateList(i);
        }
        return (ColorStateList) invokeI.objValue;
    }

    public static Typeface L(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            if ("bold".equals(str)) {
                return Typeface.DEFAULT_BOLD;
            }
            return Typeface.DEFAULT;
        }
        return (Typeface) invokeL.objValue;
    }

    public static float[] N(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65550, null, f)) == null) {
            float[] fArr = new float[8];
            Arrays.fill(fArr, f);
            return fArr;
        }
        return (float[]) invokeF.objValue;
    }

    public static float b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65552, null, i)) == null) {
            return JavaTypesHelper.toFloat(H(i), 0.0f);
        }
        return invokeI.floatValue;
    }

    public static y25 d(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, drawable)) == null) {
            if (drawable instanceof y25) {
                return (y25) drawable;
            }
            return y25.y();
        }
        return (y25) invokeL.objValue;
    }

    public static y25 e(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, view2)) == null) {
            Drawable background = view2.getBackground();
            if (background instanceof y25) {
                return (y25) background;
            }
            return y25.y();
        }
        return (y25) invokeL.objValue;
    }

    public static int i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65559, null, i)) == null) {
            return SkinManager.getColor(i);
        }
        return invokeI.intValue;
    }

    public static int j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, str)) == null) {
            return tua.f(str);
        }
        return invokeL.intValue;
    }

    public static int m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, str)) == null) {
            return i(v(str, "color"));
        }
        return invokeL.intValue;
    }

    public static int p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65566, null, i)) == null) {
            return UtilHelper.getDimenPixelSize(i);
        }
        return invokeI.intValue;
    }

    public static int q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, str)) == null) {
            return p(v("tbds" + str, EMABTest.TYPE_DIMEN));
        }
        return invokeL.intValue;
    }

    public static int[] t(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, iArr)) == null) {
            int length = iArr.length;
            for (int i = 0; i < length; i++) {
                iArr[i] = i(iArr[i]);
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public static int[] u(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, strArr)) == null) {
            int length = strArr.length;
            int[] iArr = new int[length];
            for (int i = 0; i < length; i++) {
                iArr[i] = m(strArr[i]);
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public static float[] x(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, strArr)) == null) {
            int min = Math.min(strArr.length, 4);
            float[] fArr = new float[min];
            for (int i = 0; i < min; i++) {
                fArr[i] = JavaTypesHelper.toFloat(strArr[i], 0.0f);
            }
            return fArr;
        }
        return (float[]) invokeL.objValue;
    }

    public static float[] B(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (app == null) {
                return N(0.0f);
            }
            String[] split = app.getString(i).split(",");
            int min = Math.min(split.length, 4);
            float[] fArr = new float[8];
            for (int i2 = 0; i2 < min; i2++) {
                float A = A(split[i2]);
                int i3 = i2 * 2;
                fArr[i3] = A;
                fArr[i3 + 1] = A;
            }
            return fArr;
        }
        return (float[]) invokeI.objValue;
    }

    public static float[] C(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, strArr)) == null) {
            int min = Math.min(strArr.length, 4);
            float[] fArr = new float[8];
            for (int i = 0; i < min; i++) {
                float A = A(strArr[i]);
                int i2 = i * 2;
                fArr[i2] = A;
                fArr[i2 + 1] = A;
            }
            return fArr;
        }
        return (float[]) invokeL.objValue;
    }

    public static String r(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65568, null, i)) == null) {
            try {
                String str = b.get(Integer.valueOf(i));
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
                swb.g(e);
                return "";
            }
        }
        return (String) invokeI.objValue;
    }

    public static Drawable D(View view2, Drawable drawable, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, view2, drawable, strArr)) == null) {
            if (strArr != null && strArr.length == 3) {
                String[] split = strArr[2].split(",");
                if (split.length == 2) {
                    y25 y25Var = (y25) d(drawable).clone();
                    y25Var.L(m(strArr[0]));
                    y25Var.M(q(strArr[1]));
                    y25Var.I(q(split[0]));
                    y25Var.J(q(split[1]));
                    return y25Var.n(view2);
                }
                throw new IndexOutOfBoundsException("Please check the number of xy resource!");
            }
            throw new IndexOutOfBoundsException("Please check the number of shadow resource!");
        }
        return (Drawable) invokeLLL.objValue;
    }

    public static float[] E(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) {
            String[] I = I(i);
            float[] fArr = new float[4];
            if (I != null && I.length == 3) {
                String[] split = I[2].split(",");
                if (split.length == 2) {
                    fArr[0] = m(I[0]);
                    fArr[1] = q(I[1]);
                    fArr[2] = q(split[0]);
                    fArr[3] = q(split[1]);
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

    public static Drawable F(Drawable drawable, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65542, null, drawable, i, i2)) == null) {
            y25 d = d(drawable);
            d.z();
            GradientDrawable l = d.l(i2);
            l.setColor(i(i));
            l.setStroke((int) d.t(), tua.a(d.s(), d.r()));
            GradientDrawable l2 = d.l(i2);
            l2.setColor(tua.a(i(i), SkinManager.RESOURCE_ALPHA_PRESS));
            l2.setStroke((int) d.t(), tua.a(d.s(), SkinManager.RESOURCE_ALPHA_PRESS * d.r()));
            GradientDrawable l3 = d.l(i2);
            l3.setColor(tua.a(i(i), SkinManager.RESOURCE_ALPHA_DISABLE));
            l3.setStroke((int) d.t(), tua.a(d.s(), SkinManager.RESOURCE_ALPHA_DISABLE * d.r()));
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842910, 16842919}, l2);
            stateListDrawable.addState(new int[]{16842910, 16842908}, l2);
            stateListDrawable.addState(new int[]{-16842910}, l3);
            stateListDrawable.addState(new int[0], l);
            return stateListDrawable;
        }
        return (Drawable) invokeLII.objValue;
    }

    public static Drawable G(Drawable drawable, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65543, null, drawable, i, i2, i3)) == null) {
            y25 d = d(drawable);
            d.z();
            GradientDrawable l = d.l(i3);
            l.setColor(i(i));
            l.setStroke((int) d.t(), tua.a(d.s(), d.r()));
            GradientDrawable l2 = d.l(i3);
            l2.setColor(i(i2));
            l2.setStroke((int) d.t(), tua.a(d.s(), SkinManager.RESOURCE_ALPHA_PRESS * d.r()));
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842910, 16842919}, l2);
            stateListDrawable.addState(new int[]{16842910, 16842908}, l2);
            stateListDrawable.addState(new int[0], l);
            return stateListDrawable;
        }
        return (Drawable) invokeLIII.objValue;
    }

    public static ColorStateList K(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65547, null, i, i2)) == null) {
            return SkinManager.createColorStateList(i, i2);
        }
        return (ColorStateList) invokeII.objValue;
    }

    public static Drawable c(Drawable drawable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65553, null, drawable, i)) == null) {
            y25 y25Var = (y25) d(drawable).clone();
            y25Var.A(b(i));
            return y25Var;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static Drawable f(Drawable drawable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65556, null, drawable, i)) == null) {
            y25 y25Var = (y25) d(drawable).clone();
            y25Var.D(b(i));
            return y25Var;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static Drawable g(Drawable drawable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65557, null, drawable, i)) == null) {
            y25 y25Var = (y25) d(drawable).clone();
            y25Var.E(i(i));
            return y25Var;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static Drawable h(Drawable drawable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65558, null, drawable, i)) == null) {
            y25 y25Var = (y25) d(drawable).clone();
            y25Var.F(p(i));
            return y25Var;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static Drawable k(Drawable drawable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65561, null, drawable, i)) == null) {
            y25 y25Var = (y25) d(drawable).clone();
            y25Var.B(i(i));
            return y25Var;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static Drawable l(Drawable drawable, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, drawable, str)) == null) {
            y25 y25Var = (y25) d(drawable).clone();
            y25Var.B(j(str));
            return y25Var;
        }
        return (Drawable) invokeLL.objValue;
    }

    public static Drawable n(Drawable drawable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65564, null, drawable, i)) == null) {
            y25 y25Var = (y25) d(drawable).clone();
            y25Var.P(C(H(i).split(",")));
            return y25Var;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static Drawable o(Drawable drawable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65565, null, drawable, i)) == null) {
            y25 y25Var = (y25) d(drawable).clone();
            y25Var.G(i);
            return y25Var;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static Drawable y(Drawable drawable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65575, null, drawable, i)) == null) {
            y25 y25Var = (y25) d(drawable).clone();
            y25Var.E(i);
            return y25Var;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static Drawable z(Drawable drawable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65576, null, drawable, i)) == null) {
            y25 y25Var = (y25) d(drawable).clone();
            y25Var.B(i);
            return y25Var;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static Drawable M(Drawable drawable, Direction direction, int[] iArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, drawable, direction, iArr)) == null) {
            y25 y25Var = (y25) d(drawable).clone();
            y25Var.C(iArr);
            y25Var.H(direction);
            return y25Var;
        }
        return (Drawable) invokeLLL.objValue;
    }

    public static Drawable s(Drawable drawable, Direction direction, int[] iArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65569, null, drawable, direction, iArr)) == null) {
            y25 y25Var = (y25) d(drawable).clone();
            t(iArr);
            y25Var.C(iArr);
            y25Var.H(direction);
            return y25Var;
        }
        return (Drawable) invokeLLL.objValue;
    }

    public static int v(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65572, null, str, str2)) == null) {
            HashMap<String, Integer> hashMap = a.get(str2);
            if (hashMap == null) {
                hashMap = new HashMap<>();
                a.put(str2, hashMap);
            }
            Integer num = hashMap.get(str);
            if (num == null) {
                num = Integer.valueOf(TbadkCoreApplication.getInst().getResources().getIdentifier(str, str2, TbadkCoreApplication.getInst().getPackageName()));
                hashMap.put(str, num);
            }
            return num.intValue();
        }
        return invokeLL.intValue;
    }

    public static Drawable w(Drawable drawable, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65573, null, drawable, strArr)) == null) {
            if (strArr != null && strArr.length == 3) {
                String[] split = strArr[0].split(",");
                String[] split2 = strArr[1].split(",");
                String str = strArr[2];
                y25 y25Var = (y25) d(drawable).clone();
                if (!TextUtils.isEmpty(str)) {
                    y25Var.H(Direction.valueOf(str.toUpperCase()));
                }
                y25Var.C(u(split));
                y25Var.K(x(split2));
                return y25Var;
            }
            throw new IndexOutOfBoundsException("Please check the number of mask resource!");
        }
        return (Drawable) invokeLL.objValue;
    }
}
