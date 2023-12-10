package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.baidu.tieba.forum.databinding.ActivityForumBinding;
import com.baidu.tieba.forum.secondfloor.AISecondFloorHybridBiz;
import com.baidu.tieba.forum.secondfloor.AISecondFloorView;
import com.baidu.tieba.forum.secondfloor.SecondFloorVisitHelper;
import com.baidu.tieba.forum.viewmodel.ForumViewModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class pm7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends lm7> List<km7<T>> a(FragmentActivity activity, ActivityForumBinding binding, om7<?> secondFloorController, T t) {
        InterceptResult invokeLLLL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, activity, binding, secondFloorController, t)) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(secondFloorController, "secondFloorController");
            if (t instanceof oi7) {
                arrayList = new ArrayList();
                arrayList.add(new AISecondFloorHybridBiz(activity, binding, secondFloorController));
            } else {
                arrayList = null;
            }
            if (!(arrayList instanceof List)) {
                return null;
            }
            return arrayList;
        }
        return (List) invokeLLLL.objValue;
    }

    public static final <T extends lm7> om7<T> b(FragmentActivity activity, ActivityForumBinding binding, jn7 jn7Var, T t) {
        InterceptResult invokeLLLL;
        om7<T> om7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, activity, binding, jn7Var, t)) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(binding, "binding");
            if (t == null) {
                return null;
            }
            if (t instanceof oi7) {
                om7Var = new om7<>(activity, binding, jn7Var);
            } else {
                om7Var = null;
            }
            if (om7Var == null) {
                return null;
            }
            om7Var.u(t);
            return om7Var;
        }
        return (om7) invokeLLLL.objValue;
    }

    public static final void c(mm7<?> mm7Var) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, mm7Var) == null) {
            ViewGroup viewGroup = null;
            if (mm7Var instanceof View) {
                view2 = (View) mm7Var;
            } else {
                view2 = null;
            }
            if (view2 != null) {
                ViewParent parent = view2.getParent();
                if (parent instanceof ViewGroup) {
                    viewGroup = (ViewGroup) parent;
                }
                if (viewGroup != null) {
                    viewGroup.removeView(view2);
                }
            }
        }
    }

    public static final lm7 d(FragmentActivity activity) {
        InterceptResult invokeL;
        ni7 a;
        mi7 mi7Var;
        boolean z;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, activity)) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            si7 value = ((ForumViewModel) new ViewModelProvider(activity).get(ForumViewModel.class)).c().getValue();
            mi7 mi7Var2 = null;
            if (value == null || (a = value.a()) == null) {
                return null;
            }
            mi7 c = SecondFloorVisitHelper.a.c(a, String.valueOf(value.f()));
            if (c != null) {
                List<mi7> a2 = a.a();
                if (a2 != null) {
                    Iterator<T> it = a2.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj = it.next();
                            if (Intrinsics.areEqual(c.d(), ((mi7) obj).d())) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    mi7Var = (mi7) obj;
                } else {
                    mi7Var = null;
                }
                if (mi7Var != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    mi7Var2 = c;
                }
            }
            a.h(mi7Var2);
            return a.i();
        }
        return (lm7) invokeL.objValue;
    }

    public static final <T extends lm7> mm7<T> e(ViewGroup parent, T t, List<? extends km7<T>> list) {
        InterceptResult invokeLLL;
        AISecondFloorView aISecondFloorView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, parent, t, list)) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            AISecondFloorView aISecondFloorView2 = null;
            if (t instanceof oi7) {
                Context context = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "parent.context");
                aISecondFloorView = new AISecondFloorView(context, null, 0, 6, null);
            } else {
                aISecondFloorView = null;
            }
            if (aISecondFloorView == null) {
                return null;
            }
            boolean z = true;
            if ((list == null || !(list.isEmpty() ^ true)) ? false : false) {
                aISecondFloorView.d(list);
            }
            if (aISecondFloorView instanceof View) {
                aISecondFloorView2 = aISecondFloorView;
            }
            if (aISecondFloorView2 != null) {
                parent.addView(aISecondFloorView2, 0, new ViewGroup.LayoutParams(-1, -1));
            }
            Intrinsics.checkNotNull(t);
            aISecondFloorView.e(t);
            return aISecondFloorView;
        }
        return (mm7) invokeLLL.objValue;
    }
}
