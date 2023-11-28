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
public final class km7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends gm7> List<fm7<T>> a(FragmentActivity activity, ActivityForumBinding binding, jm7<?> secondFloorController, T t) {
        InterceptResult invokeLLLL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, activity, binding, secondFloorController, t)) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(secondFloorController, "secondFloorController");
            if (t instanceof ji7) {
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

    public static final <T extends gm7> jm7<T> b(FragmentActivity activity, ActivityForumBinding binding, en7 en7Var, T t) {
        InterceptResult invokeLLLL;
        jm7<T> jm7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, activity, binding, en7Var, t)) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(binding, "binding");
            if (t == null) {
                return null;
            }
            if (t instanceof ji7) {
                jm7Var = new jm7<>(activity, binding, en7Var);
            } else {
                jm7Var = null;
            }
            if (jm7Var == null) {
                return null;
            }
            jm7Var.u(t);
            return jm7Var;
        }
        return (jm7) invokeLLLL.objValue;
    }

    public static final void c(hm7<?> hm7Var) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, hm7Var) == null) {
            ViewGroup viewGroup = null;
            if (hm7Var instanceof View) {
                view2 = (View) hm7Var;
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

    public static final gm7 d(FragmentActivity activity) {
        InterceptResult invokeL;
        ii7 a;
        hi7 hi7Var;
        boolean z;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, activity)) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            ni7 value = ((ForumViewModel) new ViewModelProvider(activity).get(ForumViewModel.class)).c().getValue();
            hi7 hi7Var2 = null;
            if (value == null || (a = value.a()) == null) {
                return null;
            }
            hi7 c = SecondFloorVisitHelper.a.c(a, String.valueOf(value.e()));
            if (c != null) {
                List<hi7> a2 = a.a();
                if (a2 != null) {
                    Iterator<T> it = a2.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj = it.next();
                            if (Intrinsics.areEqual(c.d(), ((hi7) obj).d())) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    hi7Var = (hi7) obj;
                } else {
                    hi7Var = null;
                }
                if (hi7Var != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    hi7Var2 = c;
                }
            }
            a.h(hi7Var2);
            return a.i();
        }
        return (gm7) invokeL.objValue;
    }

    public static final <T extends gm7> hm7<T> e(ViewGroup parent, T t, List<? extends fm7<T>> list) {
        InterceptResult invokeLLL;
        AISecondFloorView aISecondFloorView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, parent, t, list)) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            AISecondFloorView aISecondFloorView2 = null;
            if (t instanceof ji7) {
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
        return (hm7) invokeLLL.objValue;
    }
}
