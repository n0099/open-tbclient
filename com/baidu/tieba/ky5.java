package com.baidu.tieba;

import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.level.TbLevelView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class ky5 {
    public static /* synthetic */ Interceptable $ic;
    public static final ky5 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947929442, "Lcom/baidu/tieba/ky5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947929442, "Lcom/baidu/tieba/ky5;");
                return;
            }
        }
        a = new ky5();
    }

    public ky5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @JvmStatic
    public static final void c(int i, String str, TextView nickName, TbLevelView levelView, List<? extends View> orderList, UserIconBox userIconBox) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), str, nickName, levelView, orderList, userIconBox}) == null) {
            Intrinsics.checkNotNullParameter(nickName, "nickName");
            Intrinsics.checkNotNullParameter(levelView, "levelView");
            Intrinsics.checkNotNullParameter(orderList, "orderList");
            if (str == null) {
                str2 = "";
            } else {
                str2 = str;
            }
            float measureText = nickName.getPaint().measureText(str2) + a.a(nickName);
            if (levelView.getVisibility() != 8) {
                levelView.setMode(true);
                measureText += levelView.b() + a.a(levelView);
            }
            for (View view2 : orderList) {
                if (!(view2 instanceof TbLevelView) && view2.getVisibility() != 8) {
                    measureText += a.b(view2);
                }
            }
            if (userIconBox != null && userIconBox.getVisibility() != 8) {
                int childCount = userIconBox.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = userIconBox.getChildAt(i2);
                    if (childAt != null) {
                        Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
                        childAt.setVisibility(0);
                        measureText += a.b(childAt);
                    }
                }
            }
            float f = i;
            if (measureText <= f) {
                nickName.setText(str);
                return;
            }
            float e = a.e(i, measureText, str2, nickName);
            if (e <= f) {
                return;
            }
            float d = a.d(e, levelView);
            if (d <= f) {
                return;
            }
            a.f(i, d, orderList, userIconBox);
        }
    }

    public final int a(View view2) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = null;
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
            int i2 = 0;
            if (marginLayoutParams2 != null) {
                i = marginLayoutParams2.leftMargin;
            } else {
                i = 0;
            }
            ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = layoutParams2;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams3 = marginLayoutParams;
            if (marginLayoutParams3 != null) {
                i2 = marginLayoutParams3.rightMargin;
            }
            return i + i2;
        }
        return invokeL.intValue;
    }

    public final int b(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            return view2.getMeasuredWidth() + a(view2);
        }
        return invokeL.intValue;
    }

    public final float d(float f, TbLevelView tbLevelView) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f), tbLevelView})) == null) {
            float b = tbLevelView.b();
            tbLevelView.setMode(false);
            return f - (b - tbLevelView.b());
        }
        return invokeCommon.floatValue;
    }

    public final float e(int i, float f, String str, TextView textView) {
        InterceptResult invokeCommon;
        float measureText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), str, textView})) == null) {
            if (fy5.e(str) <= 12) {
                textView.setText(str);
                return f;
            }
            float measureText2 = textView.getPaint().measureText(str);
            float f2 = f - i;
            int e = fy5.e(str);
            do {
                str = fy5.m(str, e - 1);
                e = fy5.e(str);
                TextPaint paint = textView.getPaint();
                measureText = paint.measureText(str + "...");
                if (f2 <= measureText2 - measureText) {
                    break;
                }
            } while (e > 10);
            textView.setText(str + "...");
            return (f - measureText2) + measureText;
        }
        return invokeCommon.floatValue;
    }

    public final float f(int i, float f, List<? extends View> list, UserIconBox userIconBox) {
        InterceptResult invokeCommon;
        float b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), list, userIconBox})) == null) {
            if (userIconBox != null && userIconBox.getVisibility() != 8) {
                for (int childCount = userIconBox.getChildCount() - 1; -1 < childCount; childCount--) {
                    View childAt = userIconBox.getChildAt(childCount);
                    if (childAt != null) {
                        Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
                        childAt.setVisibility(8);
                        f -= a.b(childAt);
                        if (f <= i) {
                            return f;
                        }
                    }
                }
            }
            for (int size = list.size() - 1; -1 < size; size--) {
                if (list.get(size).getVisibility() != 8) {
                    list.get(size).setVisibility(8);
                    if (list.get(size) instanceof TbLevelView) {
                        b = ((TbLevelView) list.get(size)).b() + a(list.get(size));
                    } else {
                        b = b(list.get(size));
                    }
                    f -= b;
                    if (f <= i) {
                        return f;
                    }
                }
            }
            return f;
        }
        return invokeCommon.floatValue;
    }
}
