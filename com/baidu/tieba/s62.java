package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.tieba.n7c;
import com.baidu.tieba.t62;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public abstract class s62<V extends View, M extends t62> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public t72 a;
    @Nullable
    public V b;
    @NonNull
    public M c;
    @Nullable
    public M d;
    @Nullable
    public SwanAppComponentContainerView e;
    @Nullable
    public t7c f;
    public int g;

    public void A(@NonNull V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, v) == null) {
        }
    }

    @NonNull
    public abstract V v(@NonNull Context context);

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a extends t7c<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String e;
        public final /* synthetic */ s62 f;

        public a(s62 s62Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s62Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = s62Var;
            this.e = str;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.baidu.tieba.s62 */
        /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: com.baidu.tieba.s62 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tieba.o7c
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                s62 s62Var = this.f;
                s62Var.b = s62Var.v(s62Var.a.getContext());
                s62 s62Var2 = this.f;
                s62Var2.A(s62Var2.b);
                this.f.e.setTargetView(this.f.b, 0);
                s62 s62Var3 = this.f;
                s62Var3.C(s62Var3.b, this.f.c, new v72(true));
                if (s62.h) {
                    Log.d("Component-Base", this.e + " insert delayed（view）: success");
                }
            }
        }

        @Override // com.baidu.tieba.o7c
        @SuppressLint({"BDThrowableCheck"})
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                d82.o("Component-Base", this.e + " insert delayed（view）: fail");
                if (s62.h && th != null && TextUtils.equals(th.getMessage(), "save subscriber and return subscriber: nolinear !")) {
                    throw new RuntimeException("save subscriber and return subscriber: nolinear !");
                }
                this.f.B();
            }
        }

        @Override // com.baidu.tieba.o7c
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                d82.o("Component-Base", this.e + " success should call onCompleted");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements n7c.a<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ s62 b;

        public b(s62 s62Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s62Var, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s62Var;
            this.a = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.n7c.a, com.baidu.tieba.b8c
        public void call(t7c<? super Object> t7cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, t7cVar) == null) {
                if (s62.h) {
                    Log.d("Component-Base", "insert delayed => save thread: " + Thread.currentThread().getName());
                }
                if (this.a != Thread.currentThread().getId()) {
                    w72.a("Component-Base", "save subscriber and return subscriber: nolinear !");
                }
                this.b.f = t7cVar;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends jq3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(s62 s62Var, String str, String str2, String str3, boolean z) {
            super(str, str2, str3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s62Var, str, str2, str3, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (String) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = z;
        }

        @Override // com.baidu.tieba.jq3, android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.j && super.onTouch(view2, motionEvent)) {
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948103290, "Lcom/baidu/tieba/s62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948103290, "Lcom/baidu/tieba/s62;");
                return;
            }
        }
        h = nr1.a;
    }

    public final void E() {
        t7c t7cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (t7cVar = this.f) != null && !t7cVar.isUnsubscribed()) {
            this.f.unsubscribe();
        }
    }

    @NonNull
    public final M l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return j(this.c);
        }
        return (M) invokeV.objValue;
    }

    @Nullable
    public final SwanAppComponentContainerView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.e;
        }
        return (SwanAppComponentContainerView) invokeV.objValue;
    }

    @NonNull
    public final M n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.c;
        }
        return (M) invokeV.objValue;
    }

    @Nullable
    public final M p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.d;
        }
        return (M) invokeV.objValue;
    }

    @Nullable
    public final V q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.b;
        }
        return (V) invokeV.objValue;
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.d != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @CallSuper
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (h) {
                Log.d("Component-Base", o() + " onDestroy");
            }
            E();
        }
    }

    @CallSuper
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            E();
        }
    }

    public s62(@Nullable Context context, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, m};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        M j = j(m);
        this.c = j;
        t72 c2 = q72.c(j);
        this.a = c2;
        if (c2 == null) {
            d82.c("Component-Base", o() + " context is null !");
        } else if (context != null) {
            c2.c(context);
        }
    }

    @NonNull
    public final s62 g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            this.g = i | this.g;
            return this;
        }
        return (s62) invokeI.objValue;
    }

    public final boolean h(@NonNull t72 t72Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, t72Var)) == null) {
            boolean b2 = t72Var.a().b(this);
            x(b2);
            return b2;
        }
        return invokeL.booleanValue;
    }

    public final boolean s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            if ((this.g & i) == i) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @NonNull
    public SwanAppComponentContainerView u(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, context)) == null) {
            return new SwanAppComponentContainerView(context);
        }
        return (SwanAppComponentContainerView) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.s62<V extends android.view.View, M extends com.baidu.tieba.t62> */
    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    @UiThread
    public /* bridge */ /* synthetic */ u62 update(@NonNull v62 v62Var) {
        return update((s62<V, M>) ((t62) v62Var));
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void r(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, swanAppComponentContainerView, m) == null) {
            swanAppComponentContainerView.setOnTouchListener(new c(this, m.c, m.b, m.a, m.g));
        }
    }

    @NonNull
    @UiThread
    public final u62 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String o = o();
            if (h) {
                Log.i("Component-Base", "=====================" + o + " start remove=====================");
            }
            t72 t72Var = this.a;
            if (t72Var == null) {
                w72.a("Component-Base", o + " remove with a null component context!");
                return new u62(202, "component context is null");
            } else if (this.e == null) {
                d82.c("Component-Base", o + " remove must after insert");
                return new u62(202, "component remove must after insert");
            } else if (!t72Var.a().e(this)) {
                String str = o + " remove fail";
                d82.c("Component-Base", str);
                return new u62(1001, str);
            } else {
                z();
                if (h) {
                    Log.d("Component-Base", o + " remove: success");
                }
                return new u62(0, "success");
            }
        }
        return (u62) invokeV.objValue;
    }

    @CallSuper
    public void C(@NonNull V v, @NonNull M m, @NonNull v72 v72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, v, m, v72Var) == null) {
            D(m, v72Var);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void D(@NonNull M m, @NonNull v72 v72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, m, v72Var) == null) {
            if (this.e == null) {
                w72.a("Component-Base", "renderContainerView with a null container view");
                return;
            }
            if (v72Var.a(1)) {
                this.e.setHidden(m.f);
            }
            if (v72Var.a(2)) {
                r(this.e, m);
            }
        }
    }

    @NonNull
    @CallSuper
    public v72 k(@NonNull M m, @NonNull M m2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, m, m2)) == null) {
            v72 v72Var = new v72();
            j13 j13Var = m2.h;
            if (j13Var != null && j13Var.b(m.h)) {
                v72Var.b(3);
            }
            if (m.f != m2.f) {
                v72Var.b(1);
            }
            if (m.g != m2.g) {
                v72Var.b(2);
            }
            return v72Var;
        }
        return (v72) invokeLL.objValue;
    }

    @NonNull
    public final u62 i(M m) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, m)) == null) {
            if (m == null) {
                return new u62(202, "model is null");
            }
            if (TextUtils.isEmpty(m.c)) {
                return new u62(202, "slave id is empty");
            }
            if (!m.isValid()) {
                return new u62(202, "model is invalid");
            }
            return new u62(0, "model is valid");
        }
        return (u62) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0027  */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final M j(@NonNull M m) {
        InterceptResult invokeL;
        t62 t62Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, m)) == null) {
            try {
                t62Var = (t62) m.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                w72.b("Component-Base", "model must implement cloneable", e);
                t62Var = null;
                if (t62Var == null) {
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                w72.b("Component-Base", "clone model fail ！", e2);
                t62Var = null;
                if (t62Var == null) {
                }
            }
            if (t62Var == null) {
                w72.a("Component-Base", "clone model fail ！");
                return m;
            }
            return (M) t62Var;
        }
        return (M) invokeL.objValue;
    }

    @NonNull
    @UiThread
    public final u62 insert() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            String o = o();
            u62 i = i(this.c);
            if (!i.a()) {
                d82.c("Component-Base", o + " insert with a invalid model => " + i.b);
                return i;
            }
            if (h) {
                Log.i("Component-Base", "=====================" + o + " start insert=====================");
            }
            t72 t72Var = this.a;
            if (t72Var == null) {
                d82.c("Component-Base", o + " insert with a null component context!");
                return new u62(202, "component context is null");
            }
            Context context = t72Var.getContext();
            if (this.e != null || this.b != null) {
                d82.o("Component-Base", o + " repeat insert");
            }
            V v = v(this.a.getContext());
            this.b = v;
            A(v);
            SwanAppComponentContainerView u = u(context);
            this.e = u;
            u.setTargetView(this.b);
            C(this.b, this.c, new v72(true));
            if (h(this.a)) {
                if (h) {
                    Log.d("Component-Base", o + " insert: success");
                }
                return new u62(0, "success");
            }
            d82.c("Component-Base", o + " insert: attach fail");
            return new u62(1001, "attach fail");
        }
        return (u62) invokeV.objValue;
    }

    @Nullable
    @UiThread
    public final t7c w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            String o = o();
            u62 i = i(this.c);
            if (!i.a()) {
                d82.c("Component-Base", o + " insert delayed with a invalid model => " + i.b);
                return null;
            }
            if (h) {
                Log.i("Component-Base", "=====================" + o + " start insertDelayed=====================");
            }
            if (this.a == null) {
                w72.a("Component-Base", o + " insert delayed with a null component context!");
                return null;
            }
            if (this.e != null) {
                d82.o("Component-Base", o + " repeat insert delayed: container view repeat");
            }
            t7c t7cVar = this.f;
            if (t7cVar != null && !t7cVar.isUnsubscribed()) {
                this.f.unsubscribe();
                this.f = null;
                d82.o("Component-Base", o + " insert delayed repeat: subscriber repeat");
            }
            this.e = u(this.a.getContext());
            D(this.c, new v72(true));
            if (h(this.a)) {
                if (h) {
                    Log.d("Component-Base", o + " insert delayed（container view）: success");
                }
                n7c.d(new b(this, Thread.currentThread().getId())).F(new a(this, o));
                return this.f;
            }
            d82.c("Component-Base", o + " insert delayed: attach fail");
            return null;
        }
        return (t7c) invokeV.objValue;
    }

    @NonNull
    public final String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            u62 i = i(this.c);
            if (i.a()) {
                return this.c.d();
            }
            return "【illegal component#" + i.b + "】";
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    @UiThread
    public final u62 update(@NonNull M m) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, m)) == null) {
            String o = o();
            u62 i = i(m);
            if (!i.a()) {
                d82.c("Component-Base", o + " update with a invalid model => " + i.b);
                return i;
            }
            if (h) {
                Log.i("Component-Base", "=====================" + o + " start update=====================");
            }
            M m2 = this.c;
            if (m2 == m) {
                String str = o + " update with the same model";
                w72.a("Component-Base", str);
                return new u62(202, str);
            } else if (!TextUtils.equals(m2.b, m.b)) {
                String str2 = o + " update with different id: " + this.c.b + StringUtil.ARRAY_ELEMENT_SEPARATOR + m.b;
                w72.a("Component-Base", str2);
                return new u62(202, str2);
            } else if (!TextUtils.equals(this.c.c, m.c)) {
                String str3 = o + " update with different slave id: " + this.c.c + StringUtil.ARRAY_ELEMENT_SEPARATOR + m.c;
                w72.a("Component-Base", str3);
                return new u62(202, str3);
            } else if (this.b != null && this.e != null) {
                if (this.a == null) {
                    w72.a("Component-Base", o + " update with a null component context!");
                    return new u62(202, "component context is null");
                }
                M m3 = this.c;
                this.d = m3;
                v72 k = k(m3, m);
                M j = j(m);
                this.c = j;
                C(this.b, j, k);
                boolean f = this.a.a().f(this, k);
                this.d = null;
                if (!f) {
                    String str4 = o + " update component fail";
                    d82.c("Component-Base", str4);
                    return new u62(1001, str4);
                }
                if (h) {
                    Log.d("Component-Base", o + " component update: success");
                }
                return new u62(0, "success");
            } else {
                String str5 = o + " update must after insert succeeded";
                w72.a("Component-Base", str5);
                return new u62(202, str5);
            }
        }
        return (u62) invokeL.objValue;
    }
}
