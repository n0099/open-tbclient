package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.setting.oauth.TaskState;
import com.baidu.tieba.pb3;
import com.baidu.tieba.t52;
import com.baidu.tieba.tb3;
import com.baidu.tieba.tu1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes8.dex */
public class ta3 extends l63 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public xe3 a;
    public final String b;
    public final String c;
    public final Set<j> d;
    public final Map<String, pb3> e;
    public final al3 f;

    /* loaded from: classes8.dex */
    public interface j {
        void a();
    }

    public void w(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, activity) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements dl3<kb3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dl3 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ ta3 e;

        /* renamed from: com.baidu.tieba.ta3$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0482a implements dl3<nb3<pb3.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0482a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.dl3
            /* renamed from: b */
            public void a(nb3<pb3.e> nb3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nb3Var) == null) {
                    a aVar = this.a;
                    aVar.e.u(aVar.a, nb3Var);
                }
            }
        }

        public a(ta3 ta3Var, dl3 dl3Var, String str, boolean z, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta3Var, dl3Var, str, Boolean.valueOf(z), context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ta3Var;
            this.a = dl3Var;
            this.b = str;
            this.c = z;
            this.d = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r8v4, types: [com.baidu.tieba.pb3$e, ResultDataT] */
        /* JADX WARN: Type inference failed for: r8v6, types: [com.baidu.tieba.pb3$e, ResultDataT] */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(kb3 kb3Var) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kb3Var) == null) {
                nb3 nb3Var = new nb3();
                if (ta3.g && j23.m()) {
                    nb3Var.e();
                    nb3Var.a = new pb3.e(true, null);
                    this.e.u(this.a, nb3Var);
                    return;
                }
                boolean z2 = false;
                if (kb3Var == null) {
                    z = true;
                } else {
                    z = false;
                }
                k32.k("SwanAppSetting", "isResultNull = " + z + "; scope = " + this.b);
                if (!z && !kb3Var.d) {
                    if (!this.c ? kb3Var.j == 0 : kb3Var.j <= 0) {
                        z2 = true;
                    }
                    if (z2) {
                        this.e.c(this.d, this.b, this.c, new C0482a(this));
                        return;
                    }
                    if (kb3Var.j > 0) {
                        nb3Var.e();
                        nb3Var.a = new pb3.e(true, null);
                    } else {
                        nb3Var.d(new OAuthException(10003));
                    }
                    this.e.u(this.a, nb3Var);
                    return;
                }
                nb3Var.d(new OAuthException(10005));
                this.e.u(this.a, nb3Var);
                k32.l("SwanAppSetting", "checkOrAuthorize", new Exception("authorize fail"));
                dd3.r(10005, kb3Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends yk3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pb3 b;
        public final /* synthetic */ String c;

        /* loaded from: classes8.dex */
        public class a implements dl3<nb3<pb3.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.dl3
            /* renamed from: b */
            public void a(nb3<pb3.e> nb3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nb3Var) == null) {
                    this.a.a();
                }
            }
        }

        public d(ta3 ta3Var, pb3 pb3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta3Var, pb3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pb3Var;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                pb3 pb3Var = this.b;
                pb3Var.r(vc3.a(this.c));
                pb3Var.p(new a(this));
                this.b.a();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h extends yk3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ tu1.d c;
        public final /* synthetic */ Bundle d;
        public final /* synthetic */ String e;
        public final /* synthetic */ dl3 f;

        /* loaded from: classes8.dex */
        public class a implements dl3<nb3<tb3.d>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h a;

            public a(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = hVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.dl3
            /* renamed from: b */
            public void a(nb3<tb3.d> nb3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nb3Var) == null) {
                    this.a.a();
                }
            }
        }

        public h(ta3 ta3Var, Activity activity, tu1.d dVar, Bundle bundle, String str, dl3 dl3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta3Var, activity, dVar, bundle, str, dl3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = activity;
            this.c = dVar;
            this.d = bundle;
            this.e = str;
            this.f = dl3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                tb3 b = j63.K().x().a().b().b(this.b, this.c, this.d);
                b.r(this.e);
                b.p(this.f);
                b.p(new a(this));
                b.a();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements dl3<kb3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dl3 a;
        public final /* synthetic */ ta3 b;

        public b(ta3 ta3Var, dl3 dl3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta3Var, dl3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ta3Var;
            this.a = dl3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(kb3 kb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kb3Var) != null) {
                return;
            }
            this.b.u(this.a, kb3Var);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements dl3<nb3<pb3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ta3 b;

        public c(ta3 ta3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ta3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(nb3<pb3.e> nb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nb3Var) == null) {
                this.b.e.remove(this.a);
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [ResulT] */
    /* loaded from: classes8.dex */
    public class e<ResulT> extends i<dl3<ResulT>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Object a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ta3 ta3Var, Object obj) {
            super(ta3Var, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta3Var, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ta3) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.dl3<ResulT> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tieba.ta3.i
        /* renamed from: b */
        public void a(dl3<ResulT> dl3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dl3Var) == null) {
                dl3Var.a(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;
        public final /* synthetic */ Object b;

        public f(ta3 ta3Var, i iVar, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta3Var, iVar, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iVar;
            this.b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a(this.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g extends i<j> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(ta3 ta3Var) {
            super(ta3Var, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ta3) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ta3.i
        /* renamed from: b */
        public void a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jVar) == null) {
                jVar.a();
            }
        }
    }

    /* loaded from: classes8.dex */
    public abstract class i<CallBackT> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract void a(CallBackT callbackt);

        public i(ta3 ta3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ i(ta3 ta3Var, a aVar) {
            this(ta3Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948174435, "Lcom/baidu/tieba/ta3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948174435, "Lcom/baidu/tieba/ta3;");
                return;
            }
        }
        g = vm1.a;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            o().edit().clear().apply();
        }
    }

    public synchronized void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this) {
                this.e.clear();
                this.f.c();
                k();
            }
        }
    }

    public synchronized void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            synchronized (this) {
                this.d.clear();
            }
        }
    }

    @SuppressLint({"ApplySharedPref"})
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            o().edit().clear().commit();
        }
    }

    public final xe3 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.a == null) {
                this.a = new xe3(this.c, false);
            }
            return this.a;
        }
        return (xe3) invokeV.objValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public synchronized void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            synchronized (this) {
                t(this.d, new g(this));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ta3(k63 k63Var) {
        super(k63Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k63Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((k63) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = new HashSet();
        this.e = new HashMap();
        this.f = new al3();
        this.b = sd3.t(k63Var);
        this.c = "aiapp_setting_" + this.b;
    }

    public void g(Context context, String str, dl3<nb3<pb3.e>> dl3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, context, str, dl3Var) == null) {
            h(context, str, false, dl3Var);
        }
    }

    public static void x(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, runnable) == null) {
            ek3.e0(runnable);
        }
    }

    public synchronized void C(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jVar) == null) {
            synchronized (this) {
                this.d.add(jVar);
            }
        }
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.a.remove(str);
        }
    }

    public synchronized void F(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jVar) == null) {
            synchronized (this) {
                this.d.remove(jVar);
            }
        }
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (g && j23.m()) {
                return true;
            }
            kb3 k = iy2.k(str);
            if (k != null && !k.d && k.a()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void A(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j2) == null) {
            o().putLong(str, j2);
        }
    }

    public void B(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            o().putString(str, str2);
        }
    }

    public void e(String str, dl3<kb3> dl3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, dl3Var) == null) {
            if (TextUtils.isEmpty(str)) {
                u(dl3Var, null);
            } else {
                iy2.i(str, new b(this, dl3Var));
            }
        }
    }

    public boolean m(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048592, this, str, z)) == null) {
            return o().getBoolean(str, z);
        }
        return invokeLZ.booleanValue;
    }

    public long n(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048593, this, str, j2)) == null) {
            return o().getLong(str, j2);
        }
        return invokeLJ.longValue;
    }

    public String q(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, str, str2)) == null) {
            return o().getString(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public synchronized <CallBackT> void s(CallBackT callbackt, i<CallBackT> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, callbackt, iVar) == null) {
            synchronized (this) {
                x(new f(this, iVar, callbackt));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.tieba.ta3 */
    /* JADX WARN: Multi-variable type inference failed */
    public synchronized <CallBackT> void t(Collection<CallBackT> collection, i<CallBackT> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, collection, iVar) == null) {
            synchronized (this) {
                Iterator it = new ArrayList(collection).iterator();
                while (it.hasNext()) {
                    s(it.next(), iVar);
                }
            }
        }
    }

    public final <ResulT> void u(dl3<ResulT> dl3Var, ResulT result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, dl3Var, result) == null) {
            s(dl3Var, new e(this, result));
        }
    }

    public void z(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048604, this, str, z) == null) {
            o().putBoolean(str, z);
        }
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            t52 W = xr2.V().W();
            if (W == null) {
                c63.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f01dd).G();
                return false;
            }
            t52.b i2 = W.i("navigateTo");
            i2.n(t52.g, t52.i);
            i2.k("authority", null).a();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void c(Context context, String str, boolean z, dl3<nb3<pb3.e>> dl3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, str, Boolean.valueOf(z), dl3Var}) == null) {
            d(context, str, z, true, false, dl3Var);
        }
    }

    public void d(Context context, String str, boolean z, boolean z2, boolean z3, dl3<nb3<pb3.e>> dl3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{context, str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), dl3Var}) == null) {
            y(context, str, z, z2, z3, dl3Var);
        }
    }

    public void h(Context context, String str, boolean z, dl3<nb3<pb3.e>> dl3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, str, Boolean.valueOf(z), dl3Var}) == null) {
            e(str, new a(this, dl3Var, str, z, context));
        }
    }

    public void r(Activity activity, tu1.d dVar, Bundle bundle, dl3<nb3<tb3.d>> dl3Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048597, this, activity, dVar, bundle, dl3Var, str) == null) {
            this.f.d(new h(this, activity, dVar, bundle, str, dl3Var));
        }
    }

    public final void y(Context context, String str, boolean z, boolean z2, boolean z3, dl3<nb3<pb3.e>> dl3Var) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{context, str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), dl3Var}) == null) {
            if (TextUtils.isEmpty(str)) {
                str2 = "";
            } else {
                str2 = str;
            }
            pb3 pb3Var = this.e.get(str2);
            if (pb3Var != null && TaskState.FINISHED != pb3Var.f()) {
                pb3Var.p(dl3Var);
                return;
            }
            pb3 d2 = j63.K().x().a().b().d(context, z, z2, new String[]{str2}, null, z3);
            this.e.put(str2, d2);
            d2.p(dl3Var);
            d2.p(new c(this, str2));
            dd3.T(vc3.a(str), "requestModifyScope");
            this.f.d(new d(this, d2, str));
        }
    }
}
