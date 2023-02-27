package com.baidu.tieba;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class te5 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static int b;
    public static int c;
    public static int d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface b {
        void a(boolean z);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948178341, "Lcom/baidu/tieba/te5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948178341, "Lcom/baidu/tieba/te5;");
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final ViewGroup b;
        public final oe5 c;
        public final boolean d;
        public final boolean e;
        public final boolean f;
        public final int g;
        public boolean h;
        public final b i;
        public final int j;
        public boolean k;
        public int l;

        public a(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, oe5 oe5Var, b bVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), viewGroup, oe5Var, bVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 0;
            this.k = false;
            this.b = viewGroup;
            this.c = oe5Var;
            this.d = z;
            this.e = z2;
            this.f = z3;
            this.g = ue5.a(viewGroup.getContext());
            this.i = bVar;
            this.j = i;
        }

        private Context getContext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
                return this.b.getContext();
            }
            return (Context) invokeV.objValue;
        }

        public final void a(int i) {
            int abs;
            int h;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (this.a == 0) {
                    this.a = i;
                    this.c.refreshHeight(te5.h(getContext()));
                    return;
                }
                if (se5.a(this.d, this.e, this.f)) {
                    abs = ((View) this.b.getParent()).getHeight() - i;
                } else {
                    abs = Math.abs(i - this.a);
                }
                if (abs <= te5.f(getContext())) {
                    int height = ((View) this.b.getParent()).getHeight() - i;
                    if (i < this.a) {
                        abs = height - this.g;
                    } else {
                        return;
                    }
                }
                if (abs != this.g && te5.i(getContext(), abs) && this.c.getHeight() != (h = te5.h(getContext()))) {
                    this.c.refreshHeight(h);
                }
            }
        }

        public final void b(int i) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                View view2 = (View) this.b.getParent();
                int height = view2.getHeight() - view2.getPaddingTop();
                boolean z2 = true;
                if (se5.a(this.d, this.e, this.f)) {
                    if (!this.e && height - i == this.g) {
                        z = this.h;
                    } else {
                        if (height <= i) {
                            z2 = false;
                        }
                        z = z2;
                    }
                } else {
                    int i2 = this.b.getResources().getDisplayMetrics().heightPixels;
                    int i3 = this.l;
                    if (i3 == 0) {
                        z = this.h;
                    } else {
                        if (i >= i3 - te5.f(getContext())) {
                            z2 = false;
                        }
                        z = z2;
                    }
                    this.l = Math.max(this.l, height);
                }
                if (this.h != z) {
                    this.c.a(z);
                    b bVar = this.i;
                    if (bVar != null) {
                        bVar.a(z);
                    }
                }
                this.h = z;
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @TargetApi(13)
        public void onGlobalLayout() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                boolean z = false;
                View childAt = this.b.getChildAt(0);
                View view2 = (View) this.b.getParent();
                Rect rect = new Rect();
                if (this.e) {
                    view2.getWindowVisibleDisplayFrame(rect);
                    i = rect.bottom - rect.top;
                    if (!this.k) {
                        if (i == this.j) {
                            z = true;
                        }
                        this.k = z;
                    }
                    if (!this.k) {
                        i += this.g;
                    }
                } else if (childAt != null) {
                    childAt.getWindowVisibleDisplayFrame(rect);
                    i = rect.bottom - rect.top;
                } else {
                    i = -1;
                }
                if (i == -1) {
                    return;
                }
                a(i);
                b(i);
                this.a = i;
            }
        }
    }

    @TargetApi(16)
    public static void c(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, activity, onGlobalLayoutListener) == null) {
            ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
            if (Build.VERSION.SDK_INT >= 16) {
                viewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
            } else {
                viewGroup.getViewTreeObserver().removeGlobalOnLayoutListener(onGlobalLayoutListener);
            }
        }
    }

    public static boolean i(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, context, i)) == null) {
            if (a == i || i <= 0) {
                return false;
            }
            a = i;
            TbadkCoreApplication.getInst().setKeyboardHeight(a);
            b55.m().z("key_last_keyboard_height", i);
            return true;
        }
        return invokeLI.booleanValue;
    }

    @TargetApi(13)
    public static ViewTreeObserver.OnGlobalLayoutListener b(Activity activity, oe5 oe5Var, b bVar) {
        InterceptResult invokeLLL;
        int height;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, activity, oe5Var, bVar)) == null) {
            ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
            boolean b2 = ve5.b(activity);
            boolean c2 = ve5.c(activity);
            boolean a2 = ve5.a(activity);
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 13) {
                Point point = new Point();
                defaultDisplay.getSize(point);
                height = point.y;
            } else {
                height = defaultDisplay.getHeight();
            }
            a aVar = new a(b2, c2, a2, viewGroup, oe5Var, bVar, height);
            viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(aVar);
            return aVar;
        }
        return (ViewTreeObserver.OnGlobalLayoutListener) invokeLLL.objValue;
    }

    public static int d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (a == 0) {
                int n = b55.m().n("key_last_keyboard_height", g(context.getResources()));
                a = n;
                if (n > 0) {
                    TbadkCoreApplication.getInst().setKeyboardHeight(a);
                }
            }
            return a;
        }
        return invokeL.intValue;
    }

    public static int e(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, resources)) == null) {
            if (b == 0) {
                b = resources.getDimensionPixelSize(R.dimen.max_editor_panel_height);
            }
            return b;
        }
        return invokeL.intValue;
    }

    public static int f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            if (d == 0) {
                d = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702c9);
            }
            return d;
        }
        return invokeL.intValue;
    }

    public static int g(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, resources)) == null) {
            if (c == 0) {
                c = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702c9);
            }
            return c;
        }
        return invokeL.intValue;
    }

    public static int h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            return Math.min(e(context.getResources()), Math.max(g(context.getResources()), d(context)));
        }
        return invokeL.intValue;
    }

    public static void j(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, view2) == null) {
            view2.requestFocus();
            ((InputMethodManager) view2.getContext().getSystemService("input_method")).showSoftInput(view2, 0);
        }
    }
}
