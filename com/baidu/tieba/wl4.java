package com.baidu.tieba;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class wl4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface f {
        View getView();
    }

    /* loaded from: classes6.dex */
    public static class a extends Transition.EpicenterCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Rect a;

        public a(Rect rect) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rect};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rect;
        }

        @Override // android.transition.Transition.EpicenterCallback
        public Rect onGetEpicenter(Transition transition) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, transition)) == null) {
                return this.a;
            }
            return (Rect) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements ViewTreeObserver.OnPreDrawListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ Transition b;
        public final /* synthetic */ View c;
        public final /* synthetic */ f d;
        public final /* synthetic */ Map e;
        public final /* synthetic */ Map f;
        public final /* synthetic */ ArrayList g;

        public b(View view2, Transition transition, View view3, f fVar, Map map, Map map2, ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, transition, view3, fVar, map, map2, arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
            this.b = transition;
            this.c = view3;
            this.d = fVar;
            this.e = map;
            this.f = map2;
            this.g = arrayList;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.a.getViewTreeObserver().removeOnPreDrawListener(this);
                Transition transition = this.b;
                if (transition != null) {
                    transition.removeTarget(this.c);
                }
                View view2 = this.d.getView();
                if (view2 != null) {
                    if (!this.e.isEmpty()) {
                        wl4.m(this.f, view2);
                        this.f.keySet().retainAll(this.e.values());
                        for (Map.Entry entry : this.e.entrySet()) {
                            View view3 = (View) this.f.get((String) entry.getValue());
                            if (view3 != null) {
                                view3.setTransitionName((String) entry.getKey());
                            }
                        }
                    }
                    if (this.b != null) {
                        wl4.h(this.g, view2);
                        this.g.removeAll(this.f.values());
                        this.g.add(this.c);
                        wl4.c(this.b, this.g);
                        return true;
                    }
                    return true;
                }
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends Transition.EpicenterCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Rect a;
        public final /* synthetic */ e b;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = eVar;
        }

        @Override // android.transition.Transition.EpicenterCallback
        public Rect onGetEpicenter(Transition transition) {
            InterceptResult invokeL;
            View view2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, transition)) == null) {
                if (this.a == null && (view2 = this.b.a) != null) {
                    this.a = wl4.n(view2);
                }
                return this.a;
            }
            return (Rect) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements ViewTreeObserver.OnPreDrawListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ Transition b;
        public final /* synthetic */ ArrayList c;
        public final /* synthetic */ Transition d;
        public final /* synthetic */ ArrayList e;
        public final /* synthetic */ Transition f;
        public final /* synthetic */ ArrayList g;
        public final /* synthetic */ Map h;
        public final /* synthetic */ ArrayList i;
        public final /* synthetic */ Transition j;
        public final /* synthetic */ View k;

        public d(View view2, Transition transition, ArrayList arrayList, Transition transition2, ArrayList arrayList2, Transition transition3, ArrayList arrayList3, Map map, ArrayList arrayList4, Transition transition4, View view3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {view2, transition, arrayList, transition2, arrayList2, transition3, arrayList3, map, arrayList4, transition4, view3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
            this.b = transition;
            this.c = arrayList;
            this.d = transition2;
            this.e = arrayList2;
            this.f = transition3;
            this.g = arrayList3;
            this.h = map;
            this.i = arrayList4;
            this.j = transition4;
            this.k = view3;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.a.getViewTreeObserver().removeOnPreDrawListener(this);
                Transition transition = this.b;
                if (transition != null) {
                    wl4.s(transition, this.c);
                }
                Transition transition2 = this.d;
                if (transition2 != null) {
                    wl4.s(transition2, this.e);
                }
                Transition transition3 = this.f;
                if (transition3 != null) {
                    wl4.s(transition3, this.g);
                }
                for (Map.Entry entry : this.h.entrySet()) {
                    ((View) entry.getValue()).setTransitionName((String) entry.getKey());
                }
                int size = this.i.size();
                for (int i = 0; i < size; i++) {
                    this.j.excludeTarget((View) this.i.get(i), false);
                }
                this.j.excludeTarget(this.k, false);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public static void e(ViewGroup viewGroup, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, viewGroup, obj) == null) {
            TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
        }
    }

    public static void t(Object obj, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, obj, view2) == null) {
            ((Transition) obj).setEpicenterCallback(new a(n(view2)));
        }
    }

    public static void u(Transition transition, e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65556, null, transition, eVar) == null) && transition != null) {
            transition.setEpicenterCallback(new c(eVar));
        }
    }

    public static Object j(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, obj)) == null) {
            if (obj != null) {
                return ((Transition) obj).clone();
            }
            return obj;
        }
        return invokeL.objValue;
    }

    public static String o(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, view2)) == null) {
            return view2.getTransitionName();
        }
        return (String) invokeL.objValue;
    }

    public static boolean q(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, list)) == null) {
            if (list != null && !list.isEmpty()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static Object w(Object obj) {
        InterceptResult invokeL;
        Transition transition;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, obj)) == null) {
            if (obj == null || (transition = (Transition) obj) == null) {
                return null;
            }
            TransitionSet transitionSet = new TransitionSet();
            transitionSet.addTransition(transition);
            return transitionSet;
        }
        return invokeL.objValue;
    }

    public static void c(Object obj, ArrayList<View> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, obj, arrayList) == null) {
            Transition transition = (Transition) obj;
            int i = 0;
            if (transition instanceof TransitionSet) {
                TransitionSet transitionSet = (TransitionSet) transition;
                int transitionCount = transitionSet.getTransitionCount();
                while (i < transitionCount) {
                    c(transitionSet.getTransitionAt(i), arrayList);
                    i++;
                }
            } else if (!p(transition) && q(transition.getTargets())) {
                int size = arrayList.size();
                while (i < size) {
                    transition.addTarget(arrayList.get(i));
                    i++;
                }
            }
        }
    }

    public static void f(List<View> list, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, list, view2) == null) {
            int size = list.size();
            if (k(list, view2, size)) {
                return;
            }
            list.add(view2);
            for (int i = size; i < list.size(); i++) {
                View view3 = list.get(i);
                if (view3 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view3;
                    int childCount = viewGroup.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = viewGroup.getChildAt(i2);
                        if (!k(list, childAt, size)) {
                            list.add(childAt);
                        }
                    }
                }
            }
        }
    }

    public static void s(Object obj, ArrayList<View> arrayList) {
        List<View> targets;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, obj, arrayList) == null) {
            Transition transition = (Transition) obj;
            if (transition instanceof TransitionSet) {
                TransitionSet transitionSet = (TransitionSet) transition;
                int transitionCount = transitionSet.getTransitionCount();
                for (int i = 0; i < transitionCount; i++) {
                    s(transitionSet.getTransitionAt(i), arrayList);
                }
            } else if (!p(transition) && (targets = transition.getTargets()) != null && targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    transition.removeTarget(arrayList.get(size));
                }
            }
        }
    }

    public static void d(Object obj, Object obj2, View view2, f fVar, View view3, e eVar, Map<String, String> map, ArrayList<View> arrayList, Map<String, View> map2, Map<String, View> map3, ArrayList<View> arrayList2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{obj, obj2, view2, fVar, view3, eVar, map, arrayList, map2, map3, arrayList2}) == null) {
            if (obj != null || obj2 != null) {
                Transition transition = (Transition) obj;
                if (transition != null) {
                    transition.addTarget(view3);
                }
                if (obj2 != null) {
                    v(obj2, view3, map2, arrayList2);
                }
                if (fVar != null) {
                    view2.getViewTreeObserver().addOnPreDrawListener(new b(view2, transition, view3, fVar, map, map3, arrayList));
                }
                u(transition, eVar);
            }
        }
    }

    public static void i(View view2, View view3, Object obj, ArrayList<View> arrayList, Object obj2, ArrayList<View> arrayList2, Object obj3, ArrayList<View> arrayList3, Object obj4, ArrayList<View> arrayList4, Map<String, View> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{view2, view3, obj, arrayList, obj2, arrayList2, obj3, arrayList3, obj4, arrayList4, map}) == null) {
            Transition transition = (Transition) obj;
            Transition transition2 = (Transition) obj2;
            Transition transition3 = (Transition) obj3;
            Transition transition4 = (Transition) obj4;
            if (transition4 != null) {
                view2.getViewTreeObserver().addOnPreDrawListener(new d(view2, transition, arrayList, transition2, arrayList2, transition3, arrayList3, map, arrayList4, transition4, view3));
            }
        }
    }

    public static Object g(Object obj, View view2, ArrayList<View> arrayList, Map<String, View> map, View view3) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65542, null, obj, view2, arrayList, map, view3)) == null) {
            if (obj != null) {
                h(arrayList, view2);
                if (map != null) {
                    arrayList.removeAll(map.values());
                }
                if (arrayList.isEmpty()) {
                    return null;
                }
                arrayList.add(view3);
                c((Transition) obj, arrayList);
                return obj;
            }
            return obj;
        }
        return invokeLLLLL.objValue;
    }

    public static void h(ArrayList<View> arrayList, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65543, null, arrayList, view2) == null) && view2.getVisibility() == 0) {
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                if (viewGroup.isTransitionGroup()) {
                    arrayList.add(viewGroup);
                    return;
                }
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    h(arrayList, viewGroup.getChildAt(i));
                }
                return;
            }
            arrayList.add(view2);
        }
    }

    public static void m(Map<String, View> map, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, null, map, view2) == null) && view2.getVisibility() == 0) {
            String transitionName = view2.getTransitionName();
            if (transitionName != null) {
                map.put(transitionName, view2);
            }
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    m(map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    public static boolean k(List<View> list, View view2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65546, null, list, view2, i)) == null) {
            for (int i2 = 0; i2 < i; i2++) {
                if (list.get(i2) == view2) {
                    return true;
                }
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    public static void l(Object obj, View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65547, null, obj, view2, z) == null) {
            ((Transition) obj).excludeTarget(view2, z);
        }
    }

    public static Rect n(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, view2)) == null) {
            Rect rect = new Rect();
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            rect.set(iArr[0], iArr[1], iArr[0] + view2.getWidth(), iArr[1] + view2.getHeight());
            return rect;
        }
        return (Rect) invokeL.objValue;
    }

    public static boolean p(Transition transition) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, transition)) == null) {
            if (q(transition.getTargetIds()) && q(transition.getTargetNames()) && q(transition.getTargetTypes())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static Object r(Object obj, Object obj2, Object obj3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{obj, obj2, obj3, Boolean.valueOf(z)})) == null) {
            Transition transition = (Transition) obj;
            Transition transition2 = (Transition) obj2;
            Transition transition3 = (Transition) obj3;
            if ((transition == null || transition2 == null) ? true : true) {
                TransitionSet transitionSet = new TransitionSet();
                if (transition != null) {
                    transitionSet.addTransition(transition);
                }
                if (transition2 != null) {
                    transitionSet.addTransition(transition2);
                }
                if (transition3 != null) {
                    transitionSet.addTransition(transition3);
                    return transitionSet;
                }
                return transitionSet;
            }
            if (transition2 != null && transition != null) {
                transition = new TransitionSet().addTransition(transition2).addTransition(transition).setOrdering(1);
            } else if (transition2 != null) {
                transition = transition2;
            } else if (transition == null) {
                transition = null;
            }
            if (transition3 != null) {
                TransitionSet transitionSet2 = new TransitionSet();
                if (transition != null) {
                    transitionSet2.addTransition(transition);
                }
                transitionSet2.addTransition(transition3);
                return transitionSet2;
            }
            return transition;
        }
        return invokeCommon.objValue;
    }

    public static void v(Object obj, View view2, Map<String, View> map, ArrayList<View> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65557, null, obj, view2, map, arrayList) == null) {
            TransitionSet transitionSet = (TransitionSet) obj;
            arrayList.clear();
            arrayList.addAll(map.values());
            List<View> targets = transitionSet.getTargets();
            targets.clear();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                f(targets, arrayList.get(i));
            }
            arrayList.add(view2);
            c(transitionSet, arrayList);
        }
    }
}
