package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes8.dex */
public final class r0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final int c(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65542, null, i, i2, i3)) == null) ? i < i2 ? i2 : i > i3 ? i3 : i : invokeIII.intValue;
    }

    public static final boolean s(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65558, null, i, i2)) == null) {
            if (i != 0 && i2 != 0) {
                if (i == 0 && i2 == 0) {
                    return true;
                }
                if (((i > 0 && i2 > 0) || (i < 0 && i2 < 0)) && (i & i2) == i2) {
                    return true;
                }
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    public static final boolean v(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65561, null, i)) == null) ? i == 0 : invokeI.booleanValue;
    }

    public static final int y(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65564, null, i, i2)) == null) ? i & (~i2) : invokeII.intValue;
    }

    public static final float A(Paint paint) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, paint)) == null) {
            if (paint != null) {
                return paint.descent() - paint.ascent();
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    public static final int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) {
            return View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE);
        }
        return invokeI.intValue;
    }

    public static final int e(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65544, null, f)) == null) {
            return f((int) f);
        }
        return invokeF.intValue;
    }

    public static final int f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i)) == null) {
            return View.MeasureSpec.makeMeasureSpec(i, 1073741824);
        }
        return invokeI.intValue;
    }

    public static final int j(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, view2)) == null) {
            Intrinsics.checkNotNullParameter(view2, "<this>");
            return (int) view2.getContext().getResources().getDisplayMetrics().density;
        }
        return invokeL.intValue;
    }

    public static final int m(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, view2)) == null) {
            Intrinsics.checkNotNullParameter(view2, "<this>");
            return view2.getContext().getResources().getDisplayMetrics().heightPixels;
        }
        return invokeL.intValue;
    }

    public static final int n(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, view2)) == null) {
            Intrinsics.checkNotNullParameter(view2, "<this>");
            return view2.getContext().getResources().getDisplayMetrics().widthPixels;
        }
        return invokeL.intValue;
    }

    public static final int o(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, view2)) == null) {
            Intrinsics.checkNotNullParameter(view2, "<this>");
            return (view2.getMeasuredHeight() - view2.getPaddingTop()) - view2.getPaddingBottom();
        }
        return invokeL.intValue;
    }

    public static final int p(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, view2)) == null) {
            Intrinsics.checkNotNullParameter(view2, "<this>");
            return (view2.getMeasuredWidth() - view2.getPaddingLeft()) - view2.getPaddingRight();
        }
        return invokeL.intValue;
    }

    public static final void w(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, null, obj) == null) {
            Intrinsics.checkNotNullParameter(obj, "<this>");
            Log.i("DslTabLayout", String.valueOf(obj));
        }
    }

    public static final int z(Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, collection)) == null) {
            if (collection != null) {
                return collection.size();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static final float B(Paint paint, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, paint, str)) == null) {
            if (TextUtils.isEmpty(str) || paint == null) {
                return 0.0f;
            }
            return paint.measureText(str);
        }
        return invokeLL.floatValue;
    }

    public static final Drawable C(Drawable drawable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, drawable, i)) == null) {
            if (drawable == null) {
                return drawable;
            }
            Drawable mutate = DrawableCompat.wrap(drawable).mutate();
            Intrinsics.checkNotNullExpressionValue(mutate, "wrap(this).mutate()");
            if (Build.VERSION.SDK_INT >= 21) {
                DrawableCompat.setTint(mutate, i);
            } else {
                mutate.setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
            }
            return mutate;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static final View g(View view2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, view2, i)) == null) {
            Intrinsics.checkNotNullParameter(view2, "<this>");
            if (view2 instanceof ViewGroup) {
                boolean z = false;
                if (i >= 0 && i < ((ViewGroup) view2).getChildCount()) {
                    z = true;
                }
                if (z) {
                    return ((ViewGroup) view2).getChildAt(i);
                }
                return null;
            }
            return view2;
        }
        return (View) invokeLI.objValue;
    }

    public static final void D(View view2, int i) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, null, view2, i) == null) {
            Drawable drawable2 = null;
            if (view2 instanceof TextView) {
                Drawable[] drawableArr = new Drawable[4];
                TextView textView = (TextView) view2;
                Drawable[] compoundDrawables = textView.getCompoundDrawables();
                Intrinsics.checkNotNullExpressionValue(compoundDrawables, "compoundDrawables");
                int length = compoundDrawables.length;
                int i2 = 0;
                int i3 = 0;
                while (i2 < length) {
                    Drawable drawable3 = compoundDrawables[i2];
                    int i4 = i3 + 1;
                    if (drawable3 != null) {
                        drawable = C(drawable3, i);
                    } else {
                        drawable = null;
                    }
                    drawableArr[i3] = drawable;
                    i2++;
                    i3 = i4;
                }
                textView.setCompoundDrawables(drawableArr[0], drawableArr[1], drawableArr[2], drawableArr[3]);
            } else if (view2 instanceof ImageView) {
                ImageView imageView = (ImageView) view2;
                Drawable drawable4 = imageView.getDrawable();
                if (drawable4 != null) {
                    drawable2 = C(drawable4, i);
                }
                imageView.setImageDrawable(drawable2);
            }
        }
    }

    public static final Rect r(View view2, Rect result) {
        InterceptResult invokeLL;
        Activity activity;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, view2, result)) == null) {
            Intrinsics.checkNotNullParameter(view2, "<this>");
            Intrinsics.checkNotNullParameter(result, "result");
            Context context = view2.getContext();
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            if (activity != null) {
                activity.getWindow().getDecorView().getGlobalVisibleRect(result);
                if (result.width() > result.height()) {
                    i = x(activity);
                    q(view2, i, 0, result);
                    return result;
                }
            }
            i = 0;
            q(view2, i, 0, result);
            return result;
        }
        return (Rect) invokeLL.objValue;
    }

    public static final <T> boolean u(List<? extends T> list, List<? extends T> list2) {
        InterceptResult invokeLL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, list, list2)) == null) {
            if (z(list) != z(list2)) {
                return true;
            }
            if (list != null) {
                int i = 0;
                for (T t : list) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    if (list2 != null) {
                        obj = CollectionsKt___CollectionsKt.getOrNull(list2, i);
                    } else {
                        obj = null;
                    }
                    if (!Intrinsics.areEqual(t, obj)) {
                        return true;
                    }
                    i = i2;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static final int[] b(View view2, String str, String str2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Float floatOrNull;
        Float floatOrNull2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{view2, str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            Intrinsics.checkNotNullParameter(view2, "<this>");
            int[] iArr = {-1, -1};
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return iArr;
            }
            if (!TextUtils.isEmpty(str)) {
                Intrinsics.checkNotNull(str);
                if (StringsKt__StringsKt.contains((CharSequence) str, (CharSequence) TbConfig.SW_APID, true)) {
                    Float floatOrNull3 = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(StringsKt__StringsJVMKt.replace(str, TbConfig.SW_APID, "", true));
                    if (floatOrNull3 != null) {
                        floatOrNull3.floatValue();
                        iArr[0] = (int) (floatOrNull3.floatValue() * (n(view2) - i3));
                    }
                } else if (StringsKt__StringsKt.contains((CharSequence) str, (CharSequence) "pw", true) && (floatOrNull2 = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(StringsKt__StringsJVMKt.replace(str, "pw", "", true))) != null) {
                    floatOrNull2.floatValue();
                    iArr[0] = (int) (floatOrNull2.floatValue() * (i - i3));
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                Intrinsics.checkNotNull(str2);
                if (StringsKt__StringsKt.contains((CharSequence) str2, (CharSequence) "sh", true)) {
                    Float floatOrNull4 = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(StringsKt__StringsJVMKt.replace(str2, "sh", "", true));
                    if (floatOrNull4 != null) {
                        floatOrNull4.floatValue();
                        iArr[1] = (int) (floatOrNull4.floatValue() * (m(view2) - i4));
                    }
                } else if (StringsKt__StringsKt.contains((CharSequence) str2, (CharSequence) "ph", true) && (floatOrNull = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(StringsKt__StringsJVMKt.replace(str2, "ph", "", true))) != null) {
                    floatOrNull.floatValue();
                    iArr[1] = (int) (floatOrNull.floatValue() * (i2 - i4));
                }
            }
            return iArr;
        }
        return (int[]) invokeCommon.objValue;
    }

    public static final int d(float f, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            float clamp = MathUtils.clamp(f, 0.0f, 1.0f);
            int i3 = (i >> 24) & 255;
            int i4 = (i >> 16) & 255;
            int i5 = (i >> 8) & 255;
            int i6 = i & 255;
            return ((i3 + ((int) ((((i2 >> 24) & 255) - i3) * clamp))) << 24) | ((i4 + ((int) ((((i2 >> 16) & 255) - i4) * clamp))) << 16) | ((i5 + ((int) ((((i2 >> 8) & 255) - i5) * clamp))) << 8) | (i6 + ((int) (clamp * ((i2 & 255) - i6))));
        }
        return invokeCommon.intValue;
    }

    public static final float h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return Resources.getSystem().getDisplayMetrics().density;
        }
        return invokeV.floatValue;
    }

    public static final int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return (int) h();
        }
        return invokeV.intValue;
    }

    public static final Rect k(View view2, View view3, Rect result) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65550, null, view2, view3, result)) == null) {
            Intrinsics.checkNotNullParameter(view2, "<this>");
            Intrinsics.checkNotNullParameter(result, "result");
            if (view3 == null) {
                ViewParent parent = view2.getParent();
                if (parent instanceof View) {
                    view3 = (View) parent;
                } else {
                    view3 = null;
                }
            }
            if (view3 == null) {
                r(view2, result);
            } else {
                result.set(0, 0, 0, 0);
                if (!Intrinsics.areEqual(view2, view3)) {
                    l(view2, view3, result);
                }
                result.right = result.left + view2.getMeasuredWidth();
                result.bottom = result.top + view2.getMeasuredHeight();
            }
            return result;
        }
        return (Rect) invokeLLL.objValue;
    }

    public static final View t(ViewGroup viewGroup, @LayoutRes int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65559, null, new Object[]{viewGroup, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            Intrinsics.checkNotNullParameter(viewGroup, "<this>");
            if (i == -1) {
                return viewGroup;
            }
            View rootView = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
            if (z) {
                viewGroup.addView(rootView);
            }
            Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
            return rootView;
        }
        return (View) invokeCommon.objValue;
    }

    public static final void l(View view2, View view3, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, view2, view3, rect) == null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof View) {
                rect.left += view2.getLeft();
                rect.top += view2.getTop();
                if (!Intrinsics.areEqual(parent, view3)) {
                    l((View) parent, view3, rect);
                }
            }
        }
    }

    public static final Rect q(View view2, int i, int i2, Rect result) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), result})) == null) {
            Intrinsics.checkNotNullParameter(view2, "<this>");
            Intrinsics.checkNotNullParameter(result, "result");
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            int i3 = iArr[0] + i;
            int i4 = iArr[1] + i2;
            result.set(i3, i4, view2.getMeasuredWidth() + i3, view2.getMeasuredHeight() + i4);
            return result;
        }
        return (Rect) invokeCommon.objValue;
    }

    public static final int x(Context context) {
        InterceptResult invokeL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, context)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (context instanceof Activity) {
                Rect rect = new Rect();
                Rect rect2 = new Rect();
                Activity activity = (Activity) context;
                activity.getWindow().getDecorView().getGlobalVisibleRect(rect);
                activity.getWindow().findViewById(16908290).getGlobalVisibleRect(rect2);
                if (rect.width() > rect.height()) {
                    i = rect.width();
                    i2 = rect2.width();
                } else {
                    i = rect.bottom;
                    i2 = rect2.bottom;
                }
                return i - i2;
            }
            return 0;
        }
        return invokeL.intValue;
    }
}
