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
/* loaded from: classes8.dex */
public final class y47 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public interface b {
        @NonNull
        n a();

        i b();

        p c();

        g d();

        e e();

        o f();

        j g();

        k h();

        m i();

        @NonNull
        l j();

        h k();

        f l();
    }

    /* loaded from: classes8.dex */
    public interface e extends r {
        @NonNull
        ViewGroup create(@NonNull Context context);

        void update(@NonNull ViewGroup viewGroup, @NonNull n77 n77Var);
    }

    /* loaded from: classes8.dex */
    public interface f extends r {
        @NonNull
        ViewGroup create(@NonNull Context context);

        void update(@NonNull ViewGroup viewGroup, @NonNull j77 j77Var);
    }

    /* loaded from: classes8.dex */
    public interface g {
        void a(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull JSONObject jSONObject);

        @NonNull
        Map<String, JSONObject> b(@NonNull String str, @NonNull String str2);
    }

    /* loaded from: classes8.dex */
    public interface h extends r {
        @NonNull
        ViewGroup create(Context context);

        void update(@NonNull ViewGroup viewGroup, @NonNull x57 x57Var);
    }

    /* loaded from: classes8.dex */
    public interface i extends r {
        @NonNull
        ViewGroup create(Context context);

        void update(@NonNull ViewGroup viewGroup, @NonNull b67 b67Var);
    }

    /* loaded from: classes8.dex */
    public interface j extends r {
        @NonNull
        ViewGroup create(Context context);

        void update(@NonNull ViewGroup viewGroup, @NonNull o67 o67Var);
    }

    /* loaded from: classes8.dex */
    public interface k extends r {
        @NonNull
        ViewGroup create(Context context);

        void update(@NonNull ViewGroup viewGroup, @NonNull c67 c67Var);
    }

    /* loaded from: classes8.dex */
    public interface l extends r {
        @NonNull
        ViewGroup create(Context context);

        void update(@NonNull ViewGroup viewGroup, @NonNull n67 n67Var);
    }

    /* loaded from: classes8.dex */
    public interface m extends r {
        @NonNull
        ViewGroup create(Context context);

        void update(@NonNull ViewGroup viewGroup, @NonNull h67 h67Var);
    }

    /* loaded from: classes8.dex */
    public interface n extends r {
        @NonNull
        ViewGroup create(Context context);

        void update(@NonNull ViewGroup viewGroup, @NonNull u67 u67Var);
    }

    /* loaded from: classes8.dex */
    public interface o {
        SpannableString a(@NonNull Context context, @NonNull a77 a77Var);
    }

    /* loaded from: classes8.dex */
    public interface p {
        @NonNull
        q a(@NonNull Context context, @NonNull ViewGroup viewGroup);

        void update(@NonNull q qVar, @NonNull l67 l67Var);
    }

    /* loaded from: classes8.dex */
    public interface q extends hx9 {
        void a();

        void onBackground(boolean z);

        void onVolumeUp();

        void update(@NonNull l67 l67Var);
    }

    /* loaded from: classes8.dex */
    public interface r {
        void a(@NonNull ViewGroup viewGroup);
    }

    /* loaded from: classes8.dex */
    public static final class c implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes8.dex */
        public class l implements p {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.y47.p
            public void update(@NonNull q qVar, @NonNull l67 l67Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qVar, l67Var) == null) {
                }
            }

            /* loaded from: classes8.dex */
            public class a implements q {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.y47.q
                public void a() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    }
                }

                @Override // com.baidu.tieba.hx9
                public int getCurrentPosition() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return 0;
                    }
                    return invokeV.intValue;
                }

                @Override // com.baidu.tieba.hx9
                public String getPlayUrl() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        return null;
                    }
                    return (String) invokeV.objValue;
                }

                @Override // com.baidu.tieba.hx9
                public View getVideoContainer() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                        return null;
                    }
                    return (View) invokeV.objValue;
                }

                @Override // com.baidu.tieba.hx9
                public boolean isFullScreen() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                        return false;
                    }
                    return invokeV.booleanValue;
                }

                @Override // com.baidu.tieba.hx9
                public boolean isPlayStarted() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                        return false;
                    }
                    return invokeV.booleanValue;
                }

                @Override // com.baidu.tieba.hx9
                public boolean isPlaying() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                        return false;
                    }
                    return invokeV.booleanValue;
                }

                @Override // com.baidu.tieba.y47.q
                public void onBackground(boolean z) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
                    }
                }

                @Override // com.baidu.tieba.y47.q
                public void onVolumeUp() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                    }
                }

                @Override // com.baidu.tieba.hx9
                public void startPlay() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                    }
                }

                @Override // com.baidu.tieba.hx9
                public void stopPlay() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                    }
                }

                @Override // com.baidu.tieba.y47.q
                public void update(@NonNull l67 l67Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048587, this, l67Var) == null) {
                    }
                }

                public a(l lVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {lVar};
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

            @Override // com.baidu.tieba.y47.p
            public q a(@NonNull Context context, @NonNull ViewGroup viewGroup) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, viewGroup)) == null) {
                    return new a(this);
                }
                return (q) invokeLL.objValue;
            }
        }

        /* loaded from: classes8.dex */
        public class a implements f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.y47.r
            public void a(@NonNull ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                }
            }

            @Override // com.baidu.tieba.y47.f
            public void update(@NonNull ViewGroup viewGroup, @NonNull j77 j77Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, j77Var) == null) {
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

            @Override // com.baidu.tieba.y47.f
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

        /* loaded from: classes8.dex */
        public class b implements e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.y47.r
            public void a(@NonNull ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                }
            }

            @Override // com.baidu.tieba.y47.e
            public void update(@NonNull ViewGroup viewGroup, @NonNull n77 n77Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, n77Var) == null) {
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

            @Override // com.baidu.tieba.y47.e
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

        /* renamed from: com.baidu.tieba.y47$c$c  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0537c implements g {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.y47.g
            public void a(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, str3, jSONObject) == null) {
                }
            }

            public C0537c(c cVar) {
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

            @Override // com.baidu.tieba.y47.g
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

        /* loaded from: classes8.dex */
        public class d implements n {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.y47.r
            public void a(@NonNull ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                }
            }

            @Override // com.baidu.tieba.y47.n
            public void update(@NonNull ViewGroup viewGroup, @NonNull u67 u67Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, u67Var) == null) {
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

            @Override // com.baidu.tieba.y47.n
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

        /* loaded from: classes8.dex */
        public class e implements l {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.y47.r
            public void a(@NonNull ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                }
            }

            @Override // com.baidu.tieba.y47.l
            public void update(@NonNull ViewGroup viewGroup, @NonNull n67 n67Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, n67Var) == null) {
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

            @Override // com.baidu.tieba.y47.l
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

        /* loaded from: classes8.dex */
        public class f implements h {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.y47.r
            public void a(@NonNull ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                }
            }

            @Override // com.baidu.tieba.y47.h
            public void update(@NonNull ViewGroup viewGroup, @NonNull x57 x57Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, x57Var) == null) {
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

            @Override // com.baidu.tieba.y47.h
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

        /* loaded from: classes8.dex */
        public class g implements i {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.y47.r
            public void a(@NonNull ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                }
            }

            @Override // com.baidu.tieba.y47.i
            public void update(@NonNull ViewGroup viewGroup, @NonNull b67 b67Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, b67Var) == null) {
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

            @Override // com.baidu.tieba.y47.i
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

        /* loaded from: classes8.dex */
        public class h implements j {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.y47.r
            public void a(@NonNull ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                }
            }

            @Override // com.baidu.tieba.y47.j
            public void update(@NonNull ViewGroup viewGroup, @NonNull o67 o67Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, o67Var) == null) {
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

            @Override // com.baidu.tieba.y47.j
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

        /* loaded from: classes8.dex */
        public class i implements m {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.y47.r
            public void a(@NonNull ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                }
            }

            @Override // com.baidu.tieba.y47.m
            public void update(@NonNull ViewGroup viewGroup, @NonNull h67 h67Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, h67Var) == null) {
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

            @Override // com.baidu.tieba.y47.m
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

        /* loaded from: classes8.dex */
        public class j implements k {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.y47.r
            public void a(@NonNull ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                }
            }

            @Override // com.baidu.tieba.y47.k
            public void update(@NonNull ViewGroup viewGroup, @NonNull c67 c67Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, c67Var) == null) {
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

            @Override // com.baidu.tieba.y47.k
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

        /* loaded from: classes8.dex */
        public class k implements o {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

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

            @Override // com.baidu.tieba.y47.o
            public SpannableString a(Context context, a77 a77Var) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, a77Var)) == null) {
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

        @Override // com.baidu.tieba.y47.b
        @NonNull
        public n a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new d(this);
            }
            return (n) invokeV.objValue;
        }

        @Override // com.baidu.tieba.y47.b
        public i b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new g(this);
            }
            return (i) invokeV.objValue;
        }

        @Override // com.baidu.tieba.y47.b
        public p c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return new l(this);
            }
            return (p) invokeV.objValue;
        }

        @Override // com.baidu.tieba.y47.b
        public g d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return new C0537c(this);
            }
            return (g) invokeV.objValue;
        }

        @Override // com.baidu.tieba.y47.b
        public e e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return new b(this);
            }
            return (e) invokeV.objValue;
        }

        @Override // com.baidu.tieba.y47.b
        public o f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return new k(this);
            }
            return (o) invokeV.objValue;
        }

        @Override // com.baidu.tieba.y47.b
        public j g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return new h(this);
            }
            return (j) invokeV.objValue;
        }

        @Override // com.baidu.tieba.y47.b
        public k h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return new j(this);
            }
            return (k) invokeV.objValue;
        }

        @Override // com.baidu.tieba.y47.b
        public m i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return new i(this);
            }
            return (m) invokeV.objValue;
        }

        @Override // com.baidu.tieba.y47.b
        @NonNull
        public l j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return new e(this);
            }
            return (l) invokeV.objValue;
        }

        @Override // com.baidu.tieba.y47.b
        public h k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return new f(this);
            }
            return (h) invokeV.objValue;
        }

        @Override // com.baidu.tieba.y47.b
        public f l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return new a(this);
            }
            return (f) invokeV.objValue;
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* loaded from: classes8.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-308421491, "Lcom/baidu/tieba/y47$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-308421491, "Lcom/baidu/tieba/y47$d;");
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
