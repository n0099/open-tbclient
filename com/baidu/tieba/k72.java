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
import com.baidu.tieba.l72;
import com.baidu.tieba.u1c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class k72<V extends View, M extends l72> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public l82 a;
    @Nullable
    public V b;
    @NonNull
    public M c;
    @Nullable
    public M d;
    @Nullable
    public SwanAppComponentContainerView e;
    @Nullable
    public a2c f;
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

    /* loaded from: classes6.dex */
    public class a extends a2c<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String e;
        public final /* synthetic */ k72 f;

        public a(k72 k72Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k72Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = k72Var;
            this.e = str;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.baidu.tieba.k72 */
        /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: com.baidu.tieba.k72 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tieba.v1c
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                k72 k72Var = this.f;
                k72Var.b = k72Var.v(k72Var.a.getContext());
                k72 k72Var2 = this.f;
                k72Var2.A(k72Var2.b);
                this.f.e.setTargetView(this.f.b, 0);
                k72 k72Var3 = this.f;
                k72Var3.C(k72Var3.b, this.f.c, new n82(true));
                if (k72.h) {
                    Log.d("Component-Base", this.e + " insert delayed（view）: success");
                }
            }
        }

        @Override // com.baidu.tieba.v1c
        @SuppressLint({"BDThrowableCheck"})
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                v82.o("Component-Base", this.e + " insert delayed（view）: fail");
                if (k72.h && th != null && TextUtils.equals(th.getMessage(), "save subscriber and return subscriber: nolinear !")) {
                    throw new RuntimeException("save subscriber and return subscriber: nolinear !");
                }
                this.f.B();
            }
        }

        @Override // com.baidu.tieba.v1c
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                v82.o("Component-Base", this.e + " success should call onCompleted");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements u1c.a<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ k72 b;

        public b(k72 k72Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k72Var, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k72Var;
            this.a = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.u1c.a, com.baidu.tieba.i2c
        public void call(a2c<? super Object> a2cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, a2cVar) == null) {
                if (k72.h) {
                    Log.d("Component-Base", "insert delayed => save thread: " + Thread.currentThread().getName());
                }
                if (this.a != Thread.currentThread().getId()) {
                    o82.a("Component-Base", "save subscriber and return subscriber: nolinear !");
                }
                this.b.f = a2cVar;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends br3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(k72 k72Var, String str, String str2, String str3, boolean z) {
            super(str, str2, str3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k72Var, str, str2, str3, Boolean.valueOf(z)};
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

        @Override // com.baidu.tieba.br3, android.view.View.OnTouchListener
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947865923, "Lcom/baidu/tieba/k72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947865923, "Lcom/baidu/tieba/k72;");
                return;
            }
        }
        h = fs1.a;
    }

    public final void E() {
        a2c a2cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (a2cVar = this.f) != null && !a2cVar.isUnsubscribed()) {
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

    public k72(@Nullable Context context, @NonNull M m) {
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
        l82 c2 = i82.c(j);
        this.a = c2;
        if (c2 == null) {
            v82.c("Component-Base", o() + " context is null !");
        } else if (context != null) {
            c2.c(context);
        }
    }

    @NonNull
    public final k72 g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            this.g = i | this.g;
            return this;
        }
        return (k72) invokeI.objValue;
    }

    public final boolean h(@NonNull l82 l82Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, l82Var)) == null) {
            boolean b2 = l82Var.a().b(this);
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

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.k72<V extends android.view.View, M extends com.baidu.tieba.l72> */
    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    @UiThread
    public /* bridge */ /* synthetic */ m72 update(@NonNull n72 n72Var) {
        return update((k72<V, M>) ((l72) n72Var));
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
    public final m72 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String o = o();
            if (h) {
                Log.i("Component-Base", "=====================" + o + " start remove=====================");
            }
            l82 l82Var = this.a;
            if (l82Var == null) {
                o82.a("Component-Base", o + " remove with a null component context!");
                return new m72(202, "component context is null");
            } else if (this.e == null) {
                v82.c("Component-Base", o + " remove must after insert");
                return new m72(202, "component remove must after insert");
            } else if (!l82Var.a().e(this)) {
                String str = o + " remove fail";
                v82.c("Component-Base", str);
                return new m72(1001, str);
            } else {
                z();
                if (h) {
                    Log.d("Component-Base", o + " remove: success");
                }
                return new m72(0, "success");
            }
        }
        return (m72) invokeV.objValue;
    }

    @CallSuper
    public void C(@NonNull V v, @NonNull M m, @NonNull n82 n82Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, v, m, n82Var) == null) {
            D(m, n82Var);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void D(@NonNull M m, @NonNull n82 n82Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, m, n82Var) == null) {
            if (this.e == null) {
                o82.a("Component-Base", "renderContainerView with a null container view");
                return;
            }
            if (n82Var.a(1)) {
                this.e.setHidden(m.f);
            }
            if (n82Var.a(2)) {
                r(this.e, m);
            }
        }
    }

    @NonNull
    @CallSuper
    public n82 k(@NonNull M m, @NonNull M m2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, m, m2)) == null) {
            n82 n82Var = new n82();
            b23 b23Var = m2.h;
            if (b23Var != null && b23Var.b(m.h)) {
                n82Var.b(3);
            }
            if (m.f != m2.f) {
                n82Var.b(1);
            }
            if (m.g != m2.g) {
                n82Var.b(2);
            }
            return n82Var;
        }
        return (n82) invokeLL.objValue;
    }

    @NonNull
    public final m72 i(M m) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, m)) == null) {
            if (m == null) {
                return new m72(202, "model is null");
            }
            if (TextUtils.isEmpty(m.c)) {
                return new m72(202, "slave id is empty");
            }
            if (!m.isValid()) {
                return new m72(202, "model is invalid");
            }
            return new m72(0, "model is valid");
        }
        return (m72) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0027  */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final M j(@NonNull M m) {
        InterceptResult invokeL;
        l72 l72Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, m)) == null) {
            try {
                l72Var = (l72) m.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                o82.b("Component-Base", "model must implement cloneable", e);
                l72Var = null;
                if (l72Var == null) {
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                o82.b("Component-Base", "clone model fail ！", e2);
                l72Var = null;
                if (l72Var == null) {
                }
            }
            if (l72Var == null) {
                o82.a("Component-Base", "clone model fail ！");
                return m;
            }
            return (M) l72Var;
        }
        return (M) invokeL.objValue;
    }

    @NonNull
    @UiThread
    public final m72 insert() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            String o = o();
            m72 i = i(this.c);
            if (!i.a()) {
                v82.c("Component-Base", o + " insert with a invalid model => " + i.b);
                return i;
            }
            if (h) {
                Log.i("Component-Base", "=====================" + o + " start insert=====================");
            }
            l82 l82Var = this.a;
            if (l82Var == null) {
                v82.c("Component-Base", o + " insert with a null component context!");
                return new m72(202, "component context is null");
            }
            Context context = l82Var.getContext();
            if (this.e != null || this.b != null) {
                v82.o("Component-Base", o + " repeat insert");
            }
            V v = v(this.a.getContext());
            this.b = v;
            A(v);
            SwanAppComponentContainerView u = u(context);
            this.e = u;
            u.setTargetView(this.b);
            C(this.b, this.c, new n82(true));
            if (h(this.a)) {
                if (h) {
                    Log.d("Component-Base", o + " insert: success");
                }
                return new m72(0, "success");
            }
            v82.c("Component-Base", o + " insert: attach fail");
            return new m72(1001, "attach fail");
        }
        return (m72) invokeV.objValue;
    }

    @Nullable
    @UiThread
    public final a2c w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            String o = o();
            m72 i = i(this.c);
            if (!i.a()) {
                v82.c("Component-Base", o + " insert delayed with a invalid model => " + i.b);
                return null;
            }
            if (h) {
                Log.i("Component-Base", "=====================" + o + " start insertDelayed=====================");
            }
            if (this.a == null) {
                o82.a("Component-Base", o + " insert delayed with a null component context!");
                return null;
            }
            if (this.e != null) {
                v82.o("Component-Base", o + " repeat insert delayed: container view repeat");
            }
            a2c a2cVar = this.f;
            if (a2cVar != null && !a2cVar.isUnsubscribed()) {
                this.f.unsubscribe();
                this.f = null;
                v82.o("Component-Base", o + " insert delayed repeat: subscriber repeat");
            }
            this.e = u(this.a.getContext());
            D(this.c, new n82(true));
            if (h(this.a)) {
                if (h) {
                    Log.d("Component-Base", o + " insert delayed（container view）: success");
                }
                u1c.d(new b(this, Thread.currentThread().getId())).F(new a(this, o));
                return this.f;
            }
            v82.c("Component-Base", o + " insert delayed: attach fail");
            return null;
        }
        return (a2c) invokeV.objValue;
    }

    @NonNull
    public final String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            m72 i = i(this.c);
            if (i.a()) {
                return this.c.d();
            }
            return "【illegal component#" + i.b + "】";
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    @UiThread
    public final m72 update(@NonNull M m) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, m)) == null) {
            String o = o();
            m72 i = i(m);
            if (!i.a()) {
                v82.c("Component-Base", o + " update with a invalid model => " + i.b);
                return i;
            }
            if (h) {
                Log.i("Component-Base", "=====================" + o + " start update=====================");
            }
            M m2 = this.c;
            if (m2 == m) {
                String str = o + " update with the same model";
                o82.a("Component-Base", str);
                return new m72(202, str);
            } else if (!TextUtils.equals(m2.b, m.b)) {
                String str2 = o + " update with different id: " + this.c.b + StringUtil.ARRAY_ELEMENT_SEPARATOR + m.b;
                o82.a("Component-Base", str2);
                return new m72(202, str2);
            } else if (!TextUtils.equals(this.c.c, m.c)) {
                String str3 = o + " update with different slave id: " + this.c.c + StringUtil.ARRAY_ELEMENT_SEPARATOR + m.c;
                o82.a("Component-Base", str3);
                return new m72(202, str3);
            } else if (this.b != null && this.e != null) {
                if (this.a == null) {
                    o82.a("Component-Base", o + " update with a null component context!");
                    return new m72(202, "component context is null");
                }
                M m3 = this.c;
                this.d = m3;
                n82 k = k(m3, m);
                M j = j(m);
                this.c = j;
                C(this.b, j, k);
                boolean f = this.a.a().f(this, k);
                this.d = null;
                if (!f) {
                    String str4 = o + " update component fail";
                    v82.c("Component-Base", str4);
                    return new m72(1001, str4);
                }
                if (h) {
                    Log.d("Component-Base", o + " component update: success");
                }
                return new m72(0, "success");
            } else {
                String str5 = o + " update must after insert succeeded";
                o82.a("Component-Base", str5);
                return new m72(202, str5);
            }
        }
        return (m72) invokeL.objValue;
    }
}
