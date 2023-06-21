package com.baidu.tieba;

import android.content.Context;
import android.text.SpannableString;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class n37 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public interface b {
        @NonNull
        j a();

        f b();

        k c();

        g d();

        i e();

        @NonNull
        h f();

        e g();
    }

    /* loaded from: classes6.dex */
    public interface e extends l {
        @NonNull
        ViewGroup create(Context context);

        void update(@NonNull ViewGroup viewGroup, @NonNull i47 i47Var);
    }

    /* loaded from: classes6.dex */
    public interface f extends l {
        @NonNull
        ViewGroup create(Context context);

        void update(@NonNull ViewGroup viewGroup, @NonNull m47 m47Var);
    }

    /* loaded from: classes6.dex */
    public interface g extends l {
        @NonNull
        ViewGroup create(Context context);

        void update(@NonNull ViewGroup viewGroup, @NonNull n47 n47Var);
    }

    /* loaded from: classes6.dex */
    public interface h extends l {
        @NonNull
        ViewGroup create(Context context);

        void update(@NonNull ViewGroup viewGroup, @NonNull Object obj);
    }

    /* loaded from: classes6.dex */
    public interface i extends l {
        @NonNull
        ViewGroup create(Context context);

        void update(@NonNull ViewGroup viewGroup, @NonNull q47 q47Var);
    }

    /* loaded from: classes6.dex */
    public interface j extends l {
        @NonNull
        ViewGroup create(Context context);

        void update(@NonNull ViewGroup viewGroup, @NonNull y47 y47Var);
    }

    /* loaded from: classes6.dex */
    public interface k {
        SpannableString a(@NonNull Context context, @NonNull d57 d57Var);
    }

    /* loaded from: classes6.dex */
    public interface l {
        void a(@NonNull ViewGroup viewGroup);
    }

    /* loaded from: classes6.dex */
    public static final class c implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes6.dex */
        public class a implements j {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.n37.l
            public void a(@NonNull ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                }
            }

            @Override // com.baidu.tieba.n37.j
            public void update(@NonNull ViewGroup viewGroup, @NonNull y47 y47Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, y47Var) == null) {
                }
            }

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.n37.j
            @NonNull
            public ViewGroup create(Context context) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                    return new LinearLayout(context);
                }
                return (ViewGroup) invokeL.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public class b implements h {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.n37.l
            public void a(@NonNull ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                }
            }

            @Override // com.baidu.tieba.n37.h
            public void update(@NonNull ViewGroup viewGroup, @NonNull Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, obj) == null) {
                }
            }

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.n37.h
            @NonNull
            public ViewGroup create(Context context) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                    return new LinearLayout(context);
                }
                return (ViewGroup) invokeL.objValue;
            }
        }

        /* renamed from: com.baidu.tieba.n37$c$c  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0382c implements e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.n37.l
            public void a(@NonNull ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                }
            }

            @Override // com.baidu.tieba.n37.e
            public void update(@NonNull ViewGroup viewGroup, @NonNull i47 i47Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i47Var) == null) {
                }
            }

            public C0382c(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.n37.e
            @NonNull
            public ViewGroup create(Context context) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                    return new LinearLayout(context);
                }
                return (ViewGroup) invokeL.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public class d implements f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.n37.l
            public void a(@NonNull ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                }
            }

            @Override // com.baidu.tieba.n37.f
            public void update(@NonNull ViewGroup viewGroup, @NonNull m47 m47Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, m47Var) == null) {
                }
            }

            public d(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.n37.f
            @NonNull
            public ViewGroup create(Context context) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                    return new LinearLayout(context);
                }
                return (ViewGroup) invokeL.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public class e implements i {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.n37.l
            public void a(@NonNull ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                }
            }

            @Override // com.baidu.tieba.n37.i
            public void update(@NonNull ViewGroup viewGroup, @NonNull q47 q47Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, q47Var) == null) {
                }
            }

            public e(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.n37.i
            @NonNull
            public ViewGroup create(Context context) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                    return new LinearLayout(context);
                }
                return (ViewGroup) invokeL.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public class f implements g {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.n37.l
            public void a(@NonNull ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                }
            }

            @Override // com.baidu.tieba.n37.g
            public void update(@NonNull ViewGroup viewGroup, @NonNull n47 n47Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, n47Var) == null) {
                }
            }

            public f(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.n37.g
            @NonNull
            public ViewGroup create(Context context) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                    return new LinearLayout(context);
                }
                return (ViewGroup) invokeL.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public class g implements k {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public g(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.n37.k
            public SpannableString a(Context context, d57 d57Var) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, d57Var)) == null) {
                    return new SpannableString("");
                }
                return (SpannableString) invokeLL.objValue;
            }
        }

        public c() {
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

        @Override // com.baidu.tieba.n37.b
        @NonNull
        public j a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new a(this);
            }
            return (j) invokeV.objValue;
        }

        @Override // com.baidu.tieba.n37.b
        public f b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new d(this);
            }
            return (f) invokeV.objValue;
        }

        @Override // com.baidu.tieba.n37.b
        public k c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return new g(this);
            }
            return (k) invokeV.objValue;
        }

        @Override // com.baidu.tieba.n37.b
        public g d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return new f(this);
            }
            return (g) invokeV.objValue;
        }

        @Override // com.baidu.tieba.n37.b
        public i e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return new e(this);
            }
            return (i) invokeV.objValue;
        }

        @Override // com.baidu.tieba.n37.b
        @NonNull
        public h f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return new b(this);
            }
            return (h) invokeV.objValue;
        }

        @Override // com.baidu.tieba.n37.b
        public e g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return new C0382c(this);
            }
            return (e) invokeV.objValue;
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-624265673, "Lcom/baidu/tieba/n37$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-624265673, "Lcom/baidu/tieba/n37$d;");
                    return;
                }
            }
            b bVar = (b) ServiceManager.getService(new ServiceReference("feed", "component.resolver"));
            if (bVar != null) {
                a = bVar;
            } else {
                a = new c(null);
            }
        }
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            return d.a;
        }
        return (b) invokeV.objValue;
    }
}
