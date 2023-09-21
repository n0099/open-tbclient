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
public final class rr9 {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public static long b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948131376, "Lcom/baidu/tieba/rr9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948131376, "Lcom/baidu/tieba/rr9;");
                return;
            }
        }
        a = new a(null);
    }

    @JvmStatic
    public static final AlaInfoData c(lk9 lk9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, lk9Var)) == null) ? a.b(lk9Var) : (AlaInfoData) invokeL.objValue;
    }

    @JvmStatic
    public static final void d(qp9 qp9Var, lk9 lk9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, qp9Var, lk9Var) == null) {
            a.e(qp9Var, lk9Var);
        }
    }

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: com.baidu.tieba.rr9$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class C0454a implements TbMixPlayerView.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ lk9 a;

            public C0454a(lk9 lk9Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lk9Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = lk9Var;
            }

            @Override // com.baidu.tieba.pb.mixplayer.TbMixPlayerView.a
            public void onClick() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    yha.u("c15499", this.a.O(), rr9.a.b(this.a), 0L);
                }
            }
        }

        /* loaded from: classes7.dex */
        public static final class b implements TbMixPlayerView.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ lk9 a;

            public b(lk9 lk9Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lk9Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = lk9Var;
            }

            @Override // com.baidu.tieba.pb.mixplayer.TbMixPlayerView.b
            public void onError() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = rr9.a;
                    rr9.b = 0L;
                }
            }

            @Override // com.baidu.tieba.pb.mixplayer.TbMixPlayerView.b
            public void onPause() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    rr9.a.d(this.a);
                }
            }

            @Override // com.baidu.tieba.pb.mixplayer.TbMixPlayerView.b
            public void onRelease() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    a aVar = rr9.a;
                    rr9.b = 0L;
                }
            }

            @Override // com.baidu.tieba.pb.mixplayer.TbMixPlayerView.b
            public void onStart() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                    a aVar = rr9.a;
                    rr9.b = System.currentTimeMillis();
                }
            }

            @Override // com.baidu.tieba.pb.mixplayer.TbMixPlayerView.b
            public void onStop() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                    rr9.a.d(this.a);
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
        public final void e(qp9 qp9Var, lk9 pbData) {
            TbMixPlayerView o1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, qp9Var, pbData) == null) {
                Intrinsics.checkNotNullParameter(pbData, "pbData");
                if (qp9Var != null && (o1 = qp9Var.o1()) != null) {
                    o1.setOnClickCallback(new C0454a(pbData));
                    o1.setPlayerStatusCallBack(new b(pbData));
                }
            }
        }

        @JvmStatic
        public final AlaInfoData b(lk9 lk9Var) {
            InterceptResult invokeL;
            ThreadData O;
            HashMap<String, MetaData> userMap;
            MetaData metaData;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, lk9Var)) == null) {
                if (lk9Var != null && (O = lk9Var.O()) != null && (userMap = O.getUserMap()) != null && (metaData = userMap.get(c(lk9Var))) != null) {
                    return metaData.getAlaInfo();
                }
                return null;
            }
            return (AlaInfoData) invokeL.objValue;
        }

        public final void d(lk9 lk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lk9Var) == null) {
                long currentTimeMillis = System.currentTimeMillis() - rr9.b;
                if (rr9.b > 0 && currentTimeMillis > 0) {
                    yha.u("c15500", lk9Var.O(), b(lk9Var), Long.valueOf(currentTimeMillis));
                }
                rr9.b = 0L;
            }
        }

        public final String c(lk9 lk9Var) {
            InterceptResult invokeL;
            String str;
            String str2;
            zja i;
            ArrayList<zja> F;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lk9Var)) == null) {
                String str3 = "";
                boolean z2 = false;
                if (lk9Var == null || (F = lk9Var.F()) == null) {
                    str = "";
                } else {
                    Iterator<zja> it = F.iterator();
                    str = "";
                    while (it.hasNext()) {
                        zja next = it.next();
                        if (next != null && next.L() == 1) {
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
                    if (lk9Var != null && (i = lk9Var.i()) != null) {
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
