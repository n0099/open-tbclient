package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.IdRes;
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
public final class wr6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface a {
        c a();
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(View view2, int i);

        void b(View view2, @IdRes int i);

        void c(View view2, String str);

        View create(Context context);

        void d(View view2, @IdRes int i);

        void e(View view2, ImageView.ScaleType scaleType);
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

            /* renamed from: com.baidu.tieba.wr6$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0464a implements c {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.wr6.c
                public void a(View view2, int i) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) {
                    }
                }

                @Override // com.baidu.tieba.wr6.c
                public void b(@NonNull View view2, int i) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i) == null) {
                    }
                }

                @Override // com.baidu.tieba.wr6.c
                public void c(@NonNull View view2, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, str) == null) {
                    }
                }

                @Override // com.baidu.tieba.wr6.c
                public View create(Context context) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
                        return null;
                    }
                    return (View) invokeL.objValue;
                }

                @Override // com.baidu.tieba.wr6.c
                public void d(@NonNull View view2, int i) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048580, this, view2, i) == null) {
                    }
                }

                @Override // com.baidu.tieba.wr6.c
                public void e(View view2, ImageView.ScaleType scaleType) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLL(1048581, this, view2, scaleType) == null) {
                    }
                }

                public C0464a(a aVar) {
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

            @Override // com.baidu.tieba.wr6.a
            public c a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return new C0464a(this);
                }
                return (c) invokeV.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-308451344, "Lcom/baidu/tieba/wr6$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-308451344, "Lcom/baidu/tieba/wr6$b;");
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

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            return b.a;
        }
        return (a) invokeV.objValue;
    }
}
