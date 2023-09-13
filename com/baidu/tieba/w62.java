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
import com.baidu.tieba.sac;
import com.baidu.tieba.x62;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public abstract class w62<V extends View, M extends x62> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public x72 a;
    @Nullable
    public V b;
    @NonNull
    public M c;
    @Nullable
    public M d;
    @Nullable
    public SwanAppComponentContainerView e;
    @Nullable
    public yac f;
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
    public class a extends yac<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String e;
        public final /* synthetic */ w62 f;

        public a(w62 w62Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w62Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = w62Var;
            this.e = str;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.baidu.tieba.w62 */
        /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: com.baidu.tieba.w62 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tieba.tac
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                w62 w62Var = this.f;
                w62Var.b = w62Var.v(w62Var.a.getContext());
                w62 w62Var2 = this.f;
                w62Var2.A(w62Var2.b);
                this.f.e.setTargetView(this.f.b, 0);
                w62 w62Var3 = this.f;
                w62Var3.C(w62Var3.b, this.f.c, new z72(true));
                if (w62.h) {
                    Log.d("Component-Base", this.e + " insert delayed（view）: success");
                }
            }
        }

        @Override // com.baidu.tieba.tac
        @SuppressLint({"BDThrowableCheck"})
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                h82.o("Component-Base", this.e + " insert delayed（view）: fail");
                if (w62.h && th != null && TextUtils.equals(th.getMessage(), "save subscriber and return subscriber: nolinear !")) {
                    throw new RuntimeException("save subscriber and return subscriber: nolinear !");
                }
                this.f.B();
            }
        }

        @Override // com.baidu.tieba.tac
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                h82.o("Component-Base", this.e + " success should call onCompleted");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements sac.a<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ w62 b;

        public b(w62 w62Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w62Var, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = w62Var;
            this.a = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sac.a, com.baidu.tieba.gbc
        public void call(yac<? super Object> yacVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, yacVar) == null) {
                if (w62.h) {
                    Log.d("Component-Base", "insert delayed => save thread: " + Thread.currentThread().getName());
                }
                if (this.a != Thread.currentThread().getId()) {
                    a82.a("Component-Base", "save subscriber and return subscriber: nolinear !");
                }
                this.b.f = yacVar;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends nq3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(w62 w62Var, String str, String str2, String str3, boolean z) {
            super(str, str2, str3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w62Var, str, str2, str3, Boolean.valueOf(z)};
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

        @Override // com.baidu.tieba.nq3, android.view.View.OnTouchListener
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948222454, "Lcom/baidu/tieba/w62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948222454, "Lcom/baidu/tieba/w62;");
                return;
            }
        }
        h = rr1.a;
    }

    public final void E() {
        yac yacVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (yacVar = this.f) != null && !yacVar.isUnsubscribed()) {
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

    public w62(@Nullable Context context, @NonNull M m) {
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
        x72 c2 = u72.c(j);
        this.a = c2;
        if (c2 == null) {
            h82.c("Component-Base", o() + " context is null !");
        } else if (context != null) {
            c2.c(context);
        }
    }

    @NonNull
    public final w62 g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            this.g = i | this.g;
            return this;
        }
        return (w62) invokeI.objValue;
    }

    public final boolean h(@NonNull x72 x72Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, x72Var)) == null) {
            boolean b2 = x72Var.a().b(this);
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

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.w62<V extends android.view.View, M extends com.baidu.tieba.x62> */
    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    @UiThread
    public /* bridge */ /* synthetic */ y62 update(@NonNull z62 z62Var) {
        return update((w62<V, M>) ((x62) z62Var));
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
    public final y62 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String o = o();
            if (h) {
                Log.i("Component-Base", "=====================" + o + " start remove=====================");
            }
            x72 x72Var = this.a;
            if (x72Var == null) {
                a82.a("Component-Base", o + " remove with a null component context!");
                return new y62(202, "component context is null");
            } else if (this.e == null) {
                h82.c("Component-Base", o + " remove must after insert");
                return new y62(202, "component remove must after insert");
            } else if (!x72Var.a().e(this)) {
                String str = o + " remove fail";
                h82.c("Component-Base", str);
                return new y62(1001, str);
            } else {
                z();
                if (h) {
                    Log.d("Component-Base", o + " remove: success");
                }
                return new y62(0, "success");
            }
        }
        return (y62) invokeV.objValue;
    }

    @CallSuper
    public void C(@NonNull V v, @NonNull M m, @NonNull z72 z72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, v, m, z72Var) == null) {
            D(m, z72Var);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void D(@NonNull M m, @NonNull z72 z72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, m, z72Var) == null) {
            if (this.e == null) {
                a82.a("Component-Base", "renderContainerView with a null container view");
                return;
            }
            if (z72Var.a(1)) {
                this.e.setHidden(m.f);
            }
            if (z72Var.a(2)) {
                r(this.e, m);
            }
        }
    }

    @NonNull
    @CallSuper
    public z72 k(@NonNull M m, @NonNull M m2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, m, m2)) == null) {
            z72 z72Var = new z72();
            n13 n13Var = m2.h;
            if (n13Var != null && n13Var.b(m.h)) {
                z72Var.b(3);
            }
            if (m.f != m2.f) {
                z72Var.b(1);
            }
            if (m.g != m2.g) {
                z72Var.b(2);
            }
            return z72Var;
        }
        return (z72) invokeLL.objValue;
    }

    @NonNull
    public final y62 i(M m) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, m)) == null) {
            if (m == null) {
                return new y62(202, "model is null");
            }
            if (TextUtils.isEmpty(m.c)) {
                return new y62(202, "slave id is empty");
            }
            if (!m.isValid()) {
                return new y62(202, "model is invalid");
            }
            return new y62(0, "model is valid");
        }
        return (y62) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0027  */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final M j(@NonNull M m) {
        InterceptResult invokeL;
        x62 x62Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, m)) == null) {
            try {
                x62Var = (x62) m.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                a82.b("Component-Base", "model must implement cloneable", e);
                x62Var = null;
                if (x62Var == null) {
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                a82.b("Component-Base", "clone model fail ！", e2);
                x62Var = null;
                if (x62Var == null) {
                }
            }
            if (x62Var == null) {
                a82.a("Component-Base", "clone model fail ！");
                return m;
            }
            return (M) x62Var;
        }
        return (M) invokeL.objValue;
    }

    @NonNull
    @UiThread
    public final y62 insert() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            String o = o();
            y62 i = i(this.c);
            if (!i.a()) {
                h82.c("Component-Base", o + " insert with a invalid model => " + i.b);
                return i;
            }
            if (h) {
                Log.i("Component-Base", "=====================" + o + " start insert=====================");
            }
            x72 x72Var = this.a;
            if (x72Var == null) {
                h82.c("Component-Base", o + " insert with a null component context!");
                return new y62(202, "component context is null");
            }
            Context context = x72Var.getContext();
            if (this.e != null || this.b != null) {
                h82.o("Component-Base", o + " repeat insert");
            }
            V v = v(this.a.getContext());
            this.b = v;
            A(v);
            SwanAppComponentContainerView u = u(context);
            this.e = u;
            u.setTargetView(this.b);
            C(this.b, this.c, new z72(true));
            if (h(this.a)) {
                if (h) {
                    Log.d("Component-Base", o + " insert: success");
                }
                return new y62(0, "success");
            }
            h82.c("Component-Base", o + " insert: attach fail");
            return new y62(1001, "attach fail");
        }
        return (y62) invokeV.objValue;
    }

    @Nullable
    @UiThread
    public final yac w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            String o = o();
            y62 i = i(this.c);
            if (!i.a()) {
                h82.c("Component-Base", o + " insert delayed with a invalid model => " + i.b);
                return null;
            }
            if (h) {
                Log.i("Component-Base", "=====================" + o + " start insertDelayed=====================");
            }
            if (this.a == null) {
                a82.a("Component-Base", o + " insert delayed with a null component context!");
                return null;
            }
            if (this.e != null) {
                h82.o("Component-Base", o + " repeat insert delayed: container view repeat");
            }
            yac yacVar = this.f;
            if (yacVar != null && !yacVar.isUnsubscribed()) {
                this.f.unsubscribe();
                this.f = null;
                h82.o("Component-Base", o + " insert delayed repeat: subscriber repeat");
            }
            this.e = u(this.a.getContext());
            D(this.c, new z72(true));
            if (h(this.a)) {
                if (h) {
                    Log.d("Component-Base", o + " insert delayed（container view）: success");
                }
                sac.d(new b(this, Thread.currentThread().getId())).F(new a(this, o));
                return this.f;
            }
            h82.c("Component-Base", o + " insert delayed: attach fail");
            return null;
        }
        return (yac) invokeV.objValue;
    }

    @NonNull
    public final String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            y62 i = i(this.c);
            if (i.a()) {
                return this.c.d();
            }
            return "【illegal component#" + i.b + "】";
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    @UiThread
    public final y62 update(@NonNull M m) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, m)) == null) {
            String o = o();
            y62 i = i(m);
            if (!i.a()) {
                h82.c("Component-Base", o + " update with a invalid model => " + i.b);
                return i;
            }
            if (h) {
                Log.i("Component-Base", "=====================" + o + " start update=====================");
            }
            M m2 = this.c;
            if (m2 == m) {
                String str = o + " update with the same model";
                a82.a("Component-Base", str);
                return new y62(202, str);
            } else if (!TextUtils.equals(m2.b, m.b)) {
                String str2 = o + " update with different id: " + this.c.b + StringUtil.ARRAY_ELEMENT_SEPARATOR + m.b;
                a82.a("Component-Base", str2);
                return new y62(202, str2);
            } else if (!TextUtils.equals(this.c.c, m.c)) {
                String str3 = o + " update with different slave id: " + this.c.c + StringUtil.ARRAY_ELEMENT_SEPARATOR + m.c;
                a82.a("Component-Base", str3);
                return new y62(202, str3);
            } else if (this.b != null && this.e != null) {
                if (this.a == null) {
                    a82.a("Component-Base", o + " update with a null component context!");
                    return new y62(202, "component context is null");
                }
                M m3 = this.c;
                this.d = m3;
                z72 k = k(m3, m);
                M j = j(m);
                this.c = j;
                C(this.b, j, k);
                boolean f = this.a.a().f(this, k);
                this.d = null;
                if (!f) {
                    String str4 = o + " update component fail";
                    h82.c("Component-Base", str4);
                    return new y62(1001, str4);
                }
                if (h) {
                    Log.d("Component-Base", o + " component update: success");
                }
                return new y62(0, "success");
            } else {
                String str5 = o + " update must after insert succeeded";
                a82.a("Component-Base", str5);
                return new y62(202, str5);
            }
        }
        return (y62) invokeL.objValue;
    }
}
