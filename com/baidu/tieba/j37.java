package com.baidu.tieba;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class j37 {
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
        o a();

        j b();

        q c();

        h d();

        e e();

        p f();

        k g();

        l h();

        n i();

        @NonNull
        m j();

        f k();

        i l();

        g m();
    }

    /* loaded from: classes6.dex */
    public interface e extends s {
        @NonNull
        ViewGroup create(@NonNull Context context);

        void j(@NonNull ViewGroup viewGroup, @NonNull p67 p67Var);
    }

    /* loaded from: classes6.dex */
    public interface f extends s {
        @NonNull
        ViewGroup create(Context context);

        void f(@NonNull ViewGroup viewGroup, @NonNull t47 t47Var);
    }

    /* loaded from: classes6.dex */
    public interface g extends s {
        @NonNull
        ViewGroup create(@NonNull Context context);

        void g(@NonNull ViewGroup viewGroup, @NonNull k67 k67Var);
    }

    /* loaded from: classes6.dex */
    public interface h {
        void a(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull JSONObject jSONObject);

        @NonNull
        Map<String, JSONObject> b(@NonNull String str, @NonNull String str2);
    }

    /* loaded from: classes6.dex */
    public interface i extends s {
        @NonNull
        ViewGroup create(Context context);

        void e(@NonNull ViewGroup viewGroup, @NonNull m47 m47Var);
    }

    /* loaded from: classes6.dex */
    public interface j extends s {
        @NonNull
        ViewGroup create(Context context);

        void d(@NonNull ViewGroup viewGroup, @NonNull q47 q47Var);
    }

    /* loaded from: classes6.dex */
    public interface k extends s {
        void c(@NonNull ViewGroup viewGroup, @NonNull e57 e57Var);

        @NonNull
        ViewGroup create(Context context);
    }

    /* loaded from: classes6.dex */
    public interface l extends s {
        @NonNull
        ViewGroup create(Context context);

        void i(@NonNull ViewGroup viewGroup, @NonNull r47 r47Var);
    }

    /* loaded from: classes6.dex */
    public interface m extends s {
        void a(@NonNull ViewGroup viewGroup, @NonNull d57 d57Var);

        @NonNull
        ViewGroup create(Context context);
    }

    /* loaded from: classes6.dex */
    public interface n extends s {
        @NonNull
        ViewGroup create(Context context);

        void k(@NonNull ViewGroup viewGroup, @NonNull x47 x47Var);
    }

    /* loaded from: classes6.dex */
    public interface o extends s {
        @NonNull
        ViewGroup create(Context context);

        void h(@NonNull ViewGroup viewGroup, @NonNull k57 k57Var);
    }

    /* loaded from: classes6.dex */
    public interface p {
        SpannableString a(@NonNull Context context, @NonNull v57 v57Var);
    }

    /* loaded from: classes6.dex */
    public interface q {
        void a(@NonNull r rVar, @NonNull b57 b57Var);

        @NonNull
        r b(@NonNull Context context, @NonNull ViewGroup viewGroup);
    }

    /* loaded from: classes6.dex */
    public interface r extends pda {
        void j(@NonNull b57 b57Var);

        void onBackground(boolean z);

        void onChangeSkinType();

        void onVolumeUp();
    }

    /* loaded from: classes6.dex */
    public interface s {
        void b(@NonNull ViewGroup viewGroup);
    }

    /* loaded from: classes6.dex */
    public static final class c implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes6.dex */
        public class m implements q {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.j37.q
            public void a(@NonNull r rVar, @NonNull b57 b57Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, rVar, b57Var) == null) {
                }
            }

            /* loaded from: classes6.dex */
            public class a implements r {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.pda
                public int getCurrentPosition() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                        return 0;
                    }
                    return invokeV.intValue;
                }

                @Override // com.baidu.tieba.pda
                public String getPlayUrl() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return null;
                    }
                    return (String) invokeV.objValue;
                }

                @Override // com.baidu.tieba.pda
                public View getVideoContainer() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        return null;
                    }
                    return (View) invokeV.objValue;
                }

                @Override // com.baidu.tieba.pda
                public boolean isFullScreen() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                        return false;
                    }
                    return invokeV.booleanValue;
                }

                @Override // com.baidu.tieba.pda
                public boolean isPlayStarted() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                        return false;
                    }
                    return invokeV.booleanValue;
                }

                @Override // com.baidu.tieba.pda
                public boolean isPlaying() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                        return false;
                    }
                    return invokeV.booleanValue;
                }

                @Override // com.baidu.tieba.j37.r
                public void j(@NonNull b57 b57Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048582, this, b57Var) == null) {
                    }
                }

                @Override // com.baidu.tieba.j37.r
                public void onBackground(boolean z) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
                    }
                }

                @Override // com.baidu.tieba.j37.r
                public void onChangeSkinType() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                    }
                }

                @Override // com.baidu.tieba.j37.r
                public void onVolumeUp() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                    }
                }

                @Override // com.baidu.tieba.pda
                public void startPlay() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                    }
                }

                @Override // com.baidu.tieba.pda
                public void stopPlay() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                    }
                }

                public a(m mVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mVar};
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

            public m(c cVar) {
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

            @Override // com.baidu.tieba.j37.q
            public r b(@NonNull Context context, @NonNull ViewGroup viewGroup) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, viewGroup)) == null) {
                    return new a(this);
                }
                return (r) invokeLL.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public class a implements g {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.j37.s
            public void b(@NonNull ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                }
            }

            @Override // com.baidu.tieba.j37.g
            public void g(@NonNull ViewGroup viewGroup, @NonNull k67 k67Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, k67Var) == null) {
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

            @Override // com.baidu.tieba.j37.g
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
        public class b implements e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.j37.s
            public void b(@NonNull ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                }
            }

            @Override // com.baidu.tieba.j37.e
            public void j(@NonNull ViewGroup viewGroup, @NonNull p67 p67Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, p67Var) == null) {
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

            @Override // com.baidu.tieba.j37.e
            @NonNull
            public ViewGroup create(@NonNull Context context) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                    return new LinearLayout(context);
                }
                return (ViewGroup) invokeL.objValue;
            }
        }

        /* renamed from: com.baidu.tieba.j37$c$c  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0361c implements h {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.j37.h
            public void a(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, str3, jSONObject) == null) {
                }
            }

            public C0361c(c cVar) {
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

            @Override // com.baidu.tieba.j37.h
            @NonNull
            public Map<String, JSONObject> b(@NonNull String str, @NonNull String str2) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
                    return new HashMap();
                }
                return (Map) invokeLL.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public class d implements f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.j37.s
            public void b(@NonNull ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                }
            }

            @Override // com.baidu.tieba.j37.f
            public void f(@NonNull ViewGroup viewGroup, @NonNull t47 t47Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, t47Var) == null) {
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

            @Override // com.baidu.tieba.j37.f
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
        public class e implements o {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.j37.s
            public void b(@NonNull ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                }
            }

            @Override // com.baidu.tieba.j37.o
            public void h(@NonNull ViewGroup viewGroup, @NonNull k57 k57Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, k57Var) == null) {
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

            @Override // com.baidu.tieba.j37.o
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
        public class f implements m {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.j37.m
            public void a(@NonNull ViewGroup viewGroup, @NonNull d57 d57Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, viewGroup, d57Var) == null) {
                }
            }

            @Override // com.baidu.tieba.j37.s
            public void b(@NonNull ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) == null) {
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

            @Override // com.baidu.tieba.j37.m
            @NonNull
            public ViewGroup create(Context context) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
                    return new LinearLayout(context);
                }
                return (ViewGroup) invokeL.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public class g implements i {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.j37.s
            public void b(@NonNull ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                }
            }

            @Override // com.baidu.tieba.j37.i
            public void e(@NonNull ViewGroup viewGroup, @NonNull m47 m47Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, m47Var) == null) {
                }
            }

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

            @Override // com.baidu.tieba.j37.i
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
        public class h implements j {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.j37.s
            public void b(@NonNull ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                }
            }

            @Override // com.baidu.tieba.j37.j
            public void d(@NonNull ViewGroup viewGroup, @NonNull q47 q47Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, q47Var) == null) {
                }
            }

            public h(c cVar) {
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

            @Override // com.baidu.tieba.j37.j
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
        public class i implements k {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.j37.s
            public void b(@NonNull ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                }
            }

            @Override // com.baidu.tieba.j37.k
            public void c(@NonNull ViewGroup viewGroup, @NonNull e57 e57Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, e57Var) == null) {
                }
            }

            public i(c cVar) {
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

            @Override // com.baidu.tieba.j37.k
            @NonNull
            public ViewGroup create(Context context) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
                    return new LinearLayout(context);
                }
                return (ViewGroup) invokeL.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public class j implements n {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.j37.s
            public void b(@NonNull ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                }
            }

            @Override // com.baidu.tieba.j37.n
            public void k(@NonNull ViewGroup viewGroup, @NonNull x47 x47Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, x47Var) == null) {
                }
            }

            public j(c cVar) {
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

            @Override // com.baidu.tieba.j37.n
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
        public class k implements l {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.j37.s
            public void b(@NonNull ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                }
            }

            @Override // com.baidu.tieba.j37.l
            public void i(@NonNull ViewGroup viewGroup, @NonNull r47 r47Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, r47Var) == null) {
                }
            }

            public k(c cVar) {
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

            @Override // com.baidu.tieba.j37.l
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
        public class l implements p {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public l(c cVar) {
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

            @Override // com.baidu.tieba.j37.p
            public SpannableString a(Context context, v57 v57Var) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, v57Var)) == null) {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.j37.b
        @NonNull
        public o a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new e(this);
            }
            return (o) invokeV.objValue;
        }

        @Override // com.baidu.tieba.j37.b
        public j b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new h(this);
            }
            return (j) invokeV.objValue;
        }

        @Override // com.baidu.tieba.j37.b
        public q c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return new m(this);
            }
            return (q) invokeV.objValue;
        }

        @Override // com.baidu.tieba.j37.b
        public h d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return new C0361c(this);
            }
            return (h) invokeV.objValue;
        }

        @Override // com.baidu.tieba.j37.b
        public e e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return new b(this);
            }
            return (e) invokeV.objValue;
        }

        @Override // com.baidu.tieba.j37.b
        public p f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return new l(this);
            }
            return (p) invokeV.objValue;
        }

        @Override // com.baidu.tieba.j37.b
        public k g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return new i(this);
            }
            return (k) invokeV.objValue;
        }

        @Override // com.baidu.tieba.j37.b
        public l h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return new k(this);
            }
            return (l) invokeV.objValue;
        }

        @Override // com.baidu.tieba.j37.b
        public n i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return new j(this);
            }
            return (n) invokeV.objValue;
        }

        @Override // com.baidu.tieba.j37.b
        @NonNull
        public m j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return new f(this);
            }
            return (m) invokeV.objValue;
        }

        @Override // com.baidu.tieba.j37.b
        public f k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return new d(this);
            }
            return (f) invokeV.objValue;
        }

        @Override // com.baidu.tieba.j37.b
        public i l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return new g(this);
            }
            return (i) invokeV.objValue;
        }

        @Override // com.baidu.tieba.j37.b
        public g m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return new a(this);
            }
            return (g) invokeV.objValue;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-738782277, "Lcom/baidu/tieba/j37$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-738782277, "Lcom/baidu/tieba/j37$d;");
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
