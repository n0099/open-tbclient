package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
import com.angcyo.tablayout.DslSelectorConfig;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public class m0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup a;
    public DslSelectorConfig b;
    public final List<View> c;
    public final List<Integer> d;
    public final List<View> e;
    public final View.OnClickListener f;
    public final CompoundButton.OnCheckedChangeListener g;
    public int h;

    public m0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new DslSelectorConfig();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new View.OnClickListener() { // from class: com.baidu.tieba.h0
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    m0.b(m0.this, view2);
                }
            }
        };
        this.g = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.g0
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLZ(1048576, this, compoundButton, z) == null) {
                    m0.a(compoundButton, z);
                }
            }
        };
        this.h = -1;
    }

    public final void q() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            int i = 0;
            for (Object obj : this.c) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                View view2 = (View) obj;
                if (this.h != i && !j(view2)) {
                    z = false;
                } else {
                    z = true;
                }
                this.b.g().invoke(view2, Integer.valueOf(i), Boolean.valueOf(z));
                i = i2;
            }
        }
    }

    public static final void a(CompoundButton compoundButton, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65537, null, compoundButton, z) == null) {
            compoundButton.setChecked(compoundButton.isSelected());
        }
    }

    public final void o(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048587, this, view2, z) == null) {
            Intrinsics.checkNotNullParameter(view2, "<this>");
            view2.setSelected(z);
            if (view2 instanceof CompoundButton) {
                ((CompoundButton) view2).setChecked(z);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void b(m0 this$0, View it) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, this$0, it) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            int indexOf = this$0.c.indexOf(it);
            if (this$0.b.c() || this$0.b.b() < 1) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (this$0.j(it)) {
                    z = false;
                    if (this$0.i(indexOf, z, true)) {
                        int indexOf2 = this$0.c.indexOf(it);
                        if ((it instanceof CompoundButton) && this$0.b.c()) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        this$0.l(indexOf2, z, true, true, z2);
                        return;
                    }
                    return;
                }
            }
            z = true;
            if (this$0.i(indexOf, z, true)) {
            }
        }
    }

    public final m0 h(ViewGroup viewGroup, Function1<? super DslSelectorConfig, Unit> config) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, viewGroup, config)) == null) {
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            Intrinsics.checkNotNullParameter(config, "config");
            this.h = -1;
            this.a = viewGroup;
            r();
            config.invoke(this.b);
            q();
            p();
            int size = this.c.size();
            int i = this.h;
            boolean z = false;
            if (i >= 0 && i < size) {
                z = true;
            }
            if (z) {
                m(this, this.h, false, false, false, false, 30, null);
            }
            return this;
        }
        return (m0) invokeLL.objValue;
    }

    public static /* synthetic */ void m(m0 m0Var, int i, boolean z, boolean z2, boolean z3, boolean z4, int i2, Object obj) {
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z5 = true;
            } else {
                z5 = z;
            }
            if ((i2 & 4) != 0) {
                z6 = true;
            } else {
                z6 = z2;
            }
            if ((i2 & 8) != 0) {
                z7 = false;
            } else {
                z7 = z3;
            }
            if ((i2 & 16) != 0) {
                z8 = false;
            } else {
                z8 = z4;
            }
            m0Var.l(i, z5, z6, z7, z8);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selector");
    }

    public final boolean c(int i, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            List<View> list = this.c;
            if (i >= 0 && i < list.size()) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z3) {
                r0.w("index out of list.");
                return false;
            }
            List<Integer> e = e();
            List<View> f = f();
            if (!e.isEmpty()) {
                if (z) {
                    if (this.b.c()) {
                        if (e.contains(Integer.valueOf(i))) {
                            return false;
                        }
                    } else {
                        for (Number number : e) {
                            int intValue = number.intValue();
                            if (intValue != i) {
                                o(list.get(intValue), false);
                            }
                        }
                        if (e.contains(Integer.valueOf(i))) {
                            return true;
                        }
                    }
                } else if (!e.contains(Integer.valueOf(i))) {
                    return false;
                }
            }
            if (z) {
                if (f.size() + 1 > this.b.a()) {
                    return false;
                }
            } else if (f.size() - 1 < this.b.b()) {
                return false;
            }
            View view2 = list.get(i);
            o(view2, z);
            if (!this.b.c()) {
                for (View view3 : f) {
                    int indexOf = list.indexOf(view3);
                    if (indexOf != i && !this.b.e().invoke(view3, Integer.valueOf(indexOf), Boolean.FALSE, Boolean.valueOf(z2)).booleanValue()) {
                        o(view3, false);
                        this.b.g().invoke(view3, Integer.valueOf(indexOf), Boolean.FALSE);
                    }
                }
            }
            this.b.g().invoke(view2, Integer.valueOf(i), Boolean.valueOf(z));
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public final List<View> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public final List<Integer> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            this.d.clear();
            int i = 0;
            for (Object obj : this.c) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                if (j((View) obj)) {
                    this.d.add(Integer.valueOf(i));
                }
                i = i2;
            }
            return this.d;
        }
        return (List) invokeV.objValue;
    }

    public final List<View> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.e.clear();
            int i = 0;
            for (Object obj : this.c) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                View view2 = (View) obj;
                if (j(view2) || i == this.h) {
                    this.e.add(view2);
                }
                i = i2;
            }
            return this.e;
        }
        return (List) invokeV.objValue;
    }

    public final void p() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (viewGroup = this.a) != null) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt != null) {
                    Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
                    childAt.setOnClickListener(this.f);
                    if (childAt instanceof CompoundButton) {
                        ((CompoundButton) childAt).setOnCheckedChangeListener(this.g);
                    }
                }
            }
        }
    }

    public final boolean i(int i, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            List<View> list = this.c;
            boolean z3 = false;
            if (i >= 0 && i < list.size()) {
                z3 = true;
            }
            if (!z3) {
                return true;
            }
            return this.b.e().invoke(list.get(i), Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)).booleanValue();
        }
        return invokeCommon.booleanValue;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object] */
    public final void k(int i, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            List<Integer> e = e();
            this.b.f().invoke(CollectionsKt___CollectionsKt.getOrNull(this.c, i), f(), Boolean.valueOf(z), Boolean.valueOf(z2));
            this.b.d().invoke(Integer.valueOf(i), e, Boolean.valueOf(z), Boolean.valueOf(z2));
        }
    }

    public final boolean j(View view2) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view2)) == null) {
            Intrinsics.checkNotNullParameter(view2, "<this>");
            if (!view2.isSelected()) {
                if (view2 instanceof CompoundButton) {
                    z = ((CompoundButton) view2).isChecked();
                } else {
                    z = false;
                }
                if (!z) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.h = i;
        }
    }

    public final void l(int i, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
            List list = CollectionsKt___CollectionsKt.toList(e());
            Integer num = (Integer) CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) list);
            boolean z6 = true;
            boolean z7 = false;
            if (!this.b.c() && (!list.isEmpty()) && list.contains(Integer.valueOf(i))) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (!c(i, z, z3) && !z4) {
                z6 = false;
            }
            if (r0.u(list, e())) {
                z7 = z6;
            }
            if (z7 || z5) {
                Integer num2 = (Integer) CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) e());
                int i3 = -1;
                if (num2 != null) {
                    i2 = num2.intValue();
                } else {
                    i2 = -1;
                }
                this.h = i2;
                if (z2) {
                    if (num != null) {
                        i3 = num.intValue();
                    }
                    k(i3, z5, z3);
                }
            }
        }
    }

    public final List<View> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            this.c.clear();
            ViewGroup viewGroup = this.a;
            boolean z = false;
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt != null) {
                        Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
                        if (childAt.getVisibility() == 0) {
                            this.c.add(childAt);
                        }
                    }
                }
            }
            int size = this.c.size();
            int i2 = this.h;
            if (i2 >= 0 && i2 < size) {
                z = true;
            }
            if (z) {
                if (!j(this.c.get(this.h))) {
                    o(this.c.get(this.h), true);
                }
            } else {
                this.h = -1;
            }
            return this.c;
        }
        return (List) invokeV.objValue;
    }
}
