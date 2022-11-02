package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public final class oa0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, view2)) == null) {
            return b(view2, false);
        }
        return invokeL.intValue;
    }

    public static int c(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view2)) == null) {
            if (view2 == null) {
                return 0;
            }
            return MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) view2.getLayoutParams());
        }
        return invokeL.intValue;
    }

    public static int d(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, view2)) == null) {
            if (view2 == null) {
                return 0;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
            return MarginLayoutParamsCompat.getMarginStart(marginLayoutParams) + MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams);
        }
        return invokeL.intValue;
    }

    public static int e(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, view2)) == null) {
            if (view2 == null) {
                return 0;
            }
            return MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) view2.getLayoutParams());
        }
        return invokeL.intValue;
    }

    public static int f(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, view2)) == null) {
            if (view2 == null) {
                return 0;
            }
            return view2.getMeasuredWidth();
        }
        return invokeL.intValue;
    }

    public static int g(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, view2)) == null) {
            if (view2 == null) {
                return 0;
            }
            return ViewCompat.getPaddingEnd(view2);
        }
        return invokeL.intValue;
    }

    public static int h(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, view2)) == null) {
            if (view2 == null) {
                return 0;
            }
            return view2.getPaddingLeft() + view2.getPaddingRight();
        }
        return invokeL.intValue;
    }

    public static int i(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, view2)) == null) {
            if (view2 == null) {
                return 0;
            }
            return ViewCompat.getPaddingStart(view2);
        }
        return invokeL.intValue;
    }

    public static int j(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, view2)) == null) {
            return k(view2, false);
        }
        return invokeL.intValue;
    }

    public static int l(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, view2)) == null) {
            if (view2 == null) {
                return 0;
            }
            return view2.getWidth();
        }
        return invokeL.intValue;
    }

    public static int m(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, view2)) == null) {
            return l(view2) + d(view2);
        }
        return invokeL.intValue;
    }

    public static boolean n(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, view2)) == null) {
            if (ViewCompat.getLayoutDirection(view2) == 1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int b(View view2, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, view2, z)) == null) {
            if (view2 == null) {
                return 0;
            }
            if (n(view2)) {
                if (z) {
                    return view2.getLeft() + g(view2);
                }
                return view2.getLeft();
            } else if (z) {
                return view2.getRight() - g(view2);
            } else {
                return view2.getRight();
            }
        }
        return invokeLZ.intValue;
    }

    public static int k(View view2, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65546, null, view2, z)) == null) {
            if (view2 == null) {
                return 0;
            }
            if (n(view2)) {
                if (z) {
                    return view2.getRight() - i(view2);
                }
                return view2.getRight();
            } else if (z) {
                return view2.getLeft() + i(view2);
            } else {
                return view2.getLeft();
            }
        }
        return invokeLZ.intValue;
    }
}
