package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
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
import java.util.List;
/* loaded from: classes6.dex */
public final class k37 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface a {
        e a();

        c b();
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(View view2, List<String> list);

        View create(Context context);
    }

    /* loaded from: classes6.dex */
    public interface e {
        void a(View view2, int i);

        void b(View view2, boolean z);

        void c(View view2, d dVar);

        View create(Context context);

        void d(View view2, @IdRes int i);

        void e(View view2, boolean z, float f, float f2);

        void f(View view2, String str);

        void g(View view2, @IdRes int i);

        void h(View view2, ImageView.ScaleType scaleType);

        void i(View view2, String str);
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes6.dex */
        public class a implements a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: com.baidu.tieba.k37$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0375a implements e {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.k37.e
                public void a(View view2, int i) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) {
                    }
                }

                @Override // com.baidu.tieba.k37.e
                public void b(View view2, boolean z) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, z) == null) {
                    }
                }

                @Override // com.baidu.tieba.k37.e
                public void c(@NonNull View view2, @NonNull d dVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, dVar) == null) {
                    }
                }

                @Override // com.baidu.tieba.k37.e
                public View create(Context context) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
                        return null;
                    }
                    return (View) invokeL.objValue;
                }

                @Override // com.baidu.tieba.k37.e
                public void d(@NonNull View view2, int i) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048580, this, view2, i) == null) {
                    }
                }

                @Override // com.baidu.tieba.k37.e
                public void e(View view2, boolean z, float f, float f2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{view2, Boolean.valueOf(z), Float.valueOf(f), Float.valueOf(f2)}) == null) {
                    }
                }

                @Override // com.baidu.tieba.k37.e
                public void f(@NonNull View view2, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLL(1048582, this, view2, str) == null) {
                    }
                }

                @Override // com.baidu.tieba.k37.e
                public void g(@NonNull View view2, int i) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048583, this, view2, i) == null) {
                    }
                }

                @Override // com.baidu.tieba.k37.e
                public void h(View view2, ImageView.ScaleType scaleType) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, scaleType) == null) {
                    }
                }

                @Override // com.baidu.tieba.k37.e
                public void i(View view2, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLL(1048585, this, view2, str) == null) {
                    }
                }

                public C0375a(a aVar) {
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
                        }
                    }
                }
            }

            /* renamed from: com.baidu.tieba.k37$b$a$b  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0376b implements c {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.k37.c
                public void a(View view2, List<String> list) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLL(1048576, this, view2, list) == null) {
                    }
                }

                @Override // com.baidu.tieba.k37.c
                public View create(Context context) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                        return null;
                    }
                    return (View) invokeL.objValue;
                }

                public C0376b(a aVar) {
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
                        }
                    }
                }
            }

            public a() {
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

            @Override // com.baidu.tieba.k37.a
            public e a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return new C0375a(this);
                }
                return (e) invokeV.objValue;
            }

            @Override // com.baidu.tieba.k37.a
            public c b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return new C0376b(this);
                }
                return (c) invokeV.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-710153188, "Lcom/baidu/tieba/k37$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-710153188, "Lcom/baidu/tieba/k37$b;");
                    return;
                }
            }
            a aVar = (a) ServiceManager.getService(new ServiceReference("feed", "widget.resolver"));
            if (aVar == null) {
                aVar = new a();
            }
            a = aVar;
        }
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;

        public d() {
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
            this.e = 3;
        }
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            return b.a;
        }
        return (a) invokeV.objValue;
    }
}
