package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.pb.mixplayer.TbMixPlayerView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes7.dex */
public final class kz9 {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public static long b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947930527, "Lcom/baidu/tieba/kz9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947930527, "Lcom/baidu/tieba/kz9;");
                return;
            }
        }
        a = new a(null);
    }

    @JvmStatic
    public static final AlaInfoData c(es9 es9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, es9Var)) == null) ? a.b(es9Var) : (AlaInfoData) invokeL.objValue;
    }

    @JvmStatic
    public static final void d(jx9 jx9Var, es9 es9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jx9Var, es9Var) == null) {
            a.e(jx9Var, es9Var);
        }
    }

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: com.baidu.tieba.kz9$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class C0364a implements TbMixPlayerView.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ es9 a;

            public C0364a(es9 es9Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {es9Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = es9Var;
            }

            @Override // com.baidu.tieba.pb.mixplayer.TbMixPlayerView.a
            public void onClick() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    upa.u("c15499", this.a.O(), kz9.a.b(this.a), 0L);
                }
            }
        }

        /* loaded from: classes7.dex */
        public static final class b implements TbMixPlayerView.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ es9 a;

            public b(es9 es9Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {es9Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = es9Var;
            }

            @Override // com.baidu.tieba.pb.mixplayer.TbMixPlayerView.b
            public void onError() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = kz9.a;
                    kz9.b = 0L;
                }
            }

            @Override // com.baidu.tieba.pb.mixplayer.TbMixPlayerView.b
            public void onPause() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    kz9.a.d(this.a);
                }
            }

            @Override // com.baidu.tieba.pb.mixplayer.TbMixPlayerView.b
            public void onRelease() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    a aVar = kz9.a;
                    kz9.b = 0L;
                }
            }

            @Override // com.baidu.tieba.pb.mixplayer.TbMixPlayerView.b
            public void onStart() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                    a aVar = kz9.a;
                    kz9.b = System.currentTimeMillis();
                }
            }

            @Override // com.baidu.tieba.pb.mixplayer.TbMixPlayerView.b
            public void onStop() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                    kz9.a.d(this.a);
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

        @JvmStatic
        public final void e(jx9 jx9Var, es9 pbData) {
            TbMixPlayerView o1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, jx9Var, pbData) == null) {
                Intrinsics.checkNotNullParameter(pbData, "pbData");
                if (jx9Var != null && (o1 = jx9Var.o1()) != null) {
                    o1.setOnClickCallback(new C0364a(pbData));
                    o1.setPlayerStatusCallBack(new b(pbData));
                }
            }
        }

        @JvmStatic
        public final AlaInfoData b(es9 es9Var) {
            InterceptResult invokeL;
            ThreadData O;
            HashMap<String, MetaData> userMap;
            MetaData metaData;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, es9Var)) == null) {
                if (es9Var != null && (O = es9Var.O()) != null && (userMap = O.getUserMap()) != null && (metaData = userMap.get(c(es9Var))) != null) {
                    return metaData.getAlaInfo();
                }
                return null;
            }
            return (AlaInfoData) invokeL.objValue;
        }

        public final void d(es9 es9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, es9Var) == null) {
                long currentTimeMillis = System.currentTimeMillis() - kz9.b;
                if (kz9.b > 0 && currentTimeMillis > 0) {
                    upa.u("c15500", es9Var.O(), b(es9Var), Long.valueOf(currentTimeMillis));
                }
                kz9.b = 0L;
            }
        }

        public final String c(es9 es9Var) {
            InterceptResult invokeL;
            String str;
            String str2;
            vra i;
            ArrayList<vra> F;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, es9Var)) == null) {
                String str3 = "";
                boolean z2 = false;
                if (es9Var == null || (F = es9Var.F()) == null) {
                    str = "";
                } else {
                    Iterator<vra> it = F.iterator();
                    str = "";
                    while (it.hasNext()) {
                        vra next = it.next();
                        if (next != null && next.J() == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            str = next.u();
                            Intrinsics.checkNotNullExpressionValue(str, "data.authorId");
                        }
                    }
                }
                if ((str == null || StringsKt__StringsJVMKt.isBlank(str)) ? true : true) {
                    if (es9Var != null && (i = es9Var.i()) != null) {
                        str2 = i.u();
                    } else {
                        str2 = null;
                    }
                    if (str2 != null) {
                        str3 = str2;
                    }
                    return str3;
                }
                return str;
            }
            return (String) invokeL.objValue;
        }
    }
}
