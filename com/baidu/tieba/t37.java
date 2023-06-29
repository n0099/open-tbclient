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
/* loaded from: classes7.dex */
public final class t37 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface a {
        d a();
    }

    /* loaded from: classes7.dex */
    public interface d {
        void a(View view2, int i);

        void b(View view2, c cVar);

        void c(View view2, @IdRes int i);

        View create(Context context);

        void d(View view2, boolean z, float f, float f2);

        void e(View view2, String str);

        void f(View view2, @IdRes int i);

        void g(View view2, ImageView.ScaleType scaleType);

        void h(View view2, String str);
    }

    /* loaded from: classes7.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public static class a implements a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: com.baidu.tieba.t37$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C0476a implements d {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.t37.d
                public void a(View view2, int i) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) {
                    }
                }

                @Override // com.baidu.tieba.t37.d
                public void b(@NonNull View view2, @NonNull c cVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, cVar) == null) {
                    }
                }

                @Override // com.baidu.tieba.t37.d
                public void c(@NonNull View view2, int i) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, view2, i) == null) {
                    }
                }

                @Override // com.baidu.tieba.t37.d
                public View create(Context context) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
                        return null;
                    }
                    return (View) invokeL.objValue;
                }

                @Override // com.baidu.tieba.t37.d
                public void d(View view2, boolean z, float f, float f2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{view2, Boolean.valueOf(z), Float.valueOf(f), Float.valueOf(f2)}) == null) {
                    }
                }

                @Override // com.baidu.tieba.t37.d
                public void e(@NonNull View view2, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLL(1048581, this, view2, str) == null) {
                    }
                }

                @Override // com.baidu.tieba.t37.d
                public void f(@NonNull View view2, int i) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048582, this, view2, i) == null) {
                    }
                }

                @Override // com.baidu.tieba.t37.d
                public void g(View view2, ImageView.ScaleType scaleType) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLL(1048583, this, view2, scaleType) == null) {
                    }
                }

                @Override // com.baidu.tieba.t37.d
                public void h(View view2, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, str) == null) {
                    }
                }

                public C0476a(a aVar) {
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

            @Override // com.baidu.tieba.t37.a
            public d a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return new C0476a(this);
                }
                return (d) invokeV.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-452490829, "Lcom/baidu/tieba/t37$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-452490829, "Lcom/baidu/tieba/t37$b;");
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

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public int c;
        public int d;

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
