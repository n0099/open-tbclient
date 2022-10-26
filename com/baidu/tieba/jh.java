package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.IBinder;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class jh {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(Dialog dialog, Activity activity) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, dialog, activity)) == null) {
            if (dialog == null || activity == null || activity.isFinishing() || activity.getWindow() == null || !h(activity.getWindow().getDecorView())) {
                return false;
            }
            dialog.dismiss();
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static final boolean d(PopupWindow popupWindow, Activity activity) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, popupWindow, activity)) == null) {
            if (popupWindow != null && activity != null) {
                if (g(activity) || !h(activity.getWindow().getDecorView())) {
                    return false;
                }
                popupWindow.dismiss();
                return true;
            }
            return c(popupWindow);
        }
        return invokeLL.booleanValue;
    }

    public static final boolean b(Dialog dialog, r9 r9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, dialog, r9Var)) == null) {
            if (r9Var != null && r9Var.getPageActivity() != null) {
                return a(dialog, r9Var.getPageActivity());
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static final boolean j(Dialog dialog, r9 r9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, dialog, r9Var)) == null) {
            if (r9Var != null && r9Var.getPageActivity() != null) {
                return i(dialog, r9Var.getPageActivity());
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static final boolean k(PopupWindow popupWindow, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, popupWindow, view2)) == null) {
            if (popupWindow != null && view2 != null && !g(view2.getContext()) && h(view2)) {
                try {
                    popupWindow.showAsDropDown(view2);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static final boolean c(PopupWindow popupWindow) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, popupWindow)) == null) {
            if (popupWindow == null || g(popupWindow.getContentView().getContext()) || !h(popupWindow.getContentView())) {
                return false;
            }
            popupWindow.dismiss();
            return true;
        }
        return invokeL.booleanValue;
    }

    public static final boolean e(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity)) == null) {
            if (activity == null || g(activity)) {
                return false;
            }
            if (!h(activity.getWindow().getDecorView()) && activity.getWindow().isActive()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static final boolean f(r9 r9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, r9Var)) == null) {
            if (r9Var == null) {
                return false;
            }
            return e(r9Var.getPageActivity());
        }
        return invokeL.booleanValue;
    }

    public static final boolean g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            if (context instanceof Activity) {
                return ((Activity) context).isFinishing();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static final boolean h(View view2) {
        InterceptResult invokeL;
        IBinder windowToken;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, view2)) == null) {
            if (view2 != null && (windowToken = view2.getWindowToken()) != null) {
                try {
                    if (windowToken.isBinderAlive()) {
                        if (windowToken.pingBinder()) {
                            return true;
                        }
                        return false;
                    }
                    return false;
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static final boolean i(Dialog dialog, Activity activity) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, dialog, activity)) == null) {
            if (dialog == null || activity == null || activity.isFinishing()) {
                return false;
            }
            if (activity.getWindow() != null && !activity.getWindow().isActive()) {
                try {
                    dialog.show();
                    return true;
                } catch (Exception unused) {
                }
            }
            if (activity.getWindow() != null && h(activity.getWindow().getDecorView())) {
                try {
                    dialog.show();
                    return true;
                } catch (Exception unused2) {
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static final boolean l(PopupWindow popupWindow, View view2, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65547, null, popupWindow, view2, i, i2)) == null) {
            if (popupWindow != null && view2 != null && !g(view2.getContext()) && h(view2)) {
                try {
                    popupWindow.showAsDropDown(view2, i, i2);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeLLII.booleanValue;
    }

    public static final boolean m(PopupWindow popupWindow, View view2, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{popupWindow, view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (popupWindow != null && view2 != null && !g(view2.getContext()) && h(view2)) {
                try {
                    popupWindow.showAtLocation(view2, i, i2, i3);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
