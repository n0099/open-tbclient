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
/* loaded from: classes6.dex */
public final class jz9 {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public static long b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947900736, "Lcom/baidu/tieba/jz9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947900736, "Lcom/baidu/tieba/jz9;");
                return;
            }
        }
        a = new a(null);
    }

    @JvmStatic
    public static final AlaInfoData c(ds9 ds9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, ds9Var)) == null) ? a.b(ds9Var) : (AlaInfoData) invokeL.objValue;
    }

    @JvmStatic
    public static final void d(ix9 ix9Var, ds9 ds9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ix9Var, ds9Var) == null) {
            a.e(ix9Var, ds9Var);
        }
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: com.baidu.tieba.jz9$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C0358a implements TbMixPlayerView.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ds9 a;

            public C0358a(ds9 ds9Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {ds9Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = ds9Var;
            }

            @Override // com.baidu.tieba.pb.mixplayer.TbMixPlayerView.a
            public void onClick() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    tpa.u("c15499", this.a.O(), jz9.a.b(this.a), 0L);
                }
            }
        }

        /* loaded from: classes6.dex */
        public static final class b implements TbMixPlayerView.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ds9 a;

            public b(ds9 ds9Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {ds9Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = ds9Var;
            }

            @Override // com.baidu.tieba.pb.mixplayer.TbMixPlayerView.b
            public void onError() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = jz9.a;
                    jz9.b = 0L;
                }
            }

            @Override // com.baidu.tieba.pb.mixplayer.TbMixPlayerView.b
            public void onPause() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    jz9.a.d(this.a);
                }
            }

            @Override // com.baidu.tieba.pb.mixplayer.TbMixPlayerView.b
            public void onRelease() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    a aVar = jz9.a;
                    jz9.b = 0L;
                }
            }

            @Override // com.baidu.tieba.pb.mixplayer.TbMixPlayerView.b
            public void onStart() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                    a aVar = jz9.a;
                    jz9.b = System.currentTimeMillis();
                }
            }

            @Override // com.baidu.tieba.pb.mixplayer.TbMixPlayerView.b
            public void onStop() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                    jz9.a.d(this.a);
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
        public final void e(ix9 ix9Var, ds9 pbData) {
            TbMixPlayerView o1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, ix9Var, pbData) == null) {
                Intrinsics.checkNotNullParameter(pbData, "pbData");
                if (ix9Var != null && (o1 = ix9Var.o1()) != null) {
                    o1.setOnClickCallback(new C0358a(pbData));
                    o1.setPlayerStatusCallBack(new b(pbData));
                }
            }
        }

        @JvmStatic
        public final AlaInfoData b(ds9 ds9Var) {
            InterceptResult invokeL;
            ThreadData O;
            HashMap<String, MetaData> userMap;
            MetaData metaData;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ds9Var)) == null) {
                if (ds9Var != null && (O = ds9Var.O()) != null && (userMap = O.getUserMap()) != null && (metaData = userMap.get(c(ds9Var))) != null) {
                    return metaData.getAlaInfo();
                }
                return null;
            }
            return (AlaInfoData) invokeL.objValue;
        }

        public final void d(ds9 ds9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ds9Var) == null) {
                long currentTimeMillis = System.currentTimeMillis() - jz9.b;
                if (jz9.b > 0 && currentTimeMillis > 0) {
                    tpa.u("c15500", ds9Var.O(), b(ds9Var), Long.valueOf(currentTimeMillis));
                }
                jz9.b = 0L;
            }
        }

        public final String c(ds9 ds9Var) {
            InterceptResult invokeL;
            String str;
            String str2;
            ura i;
            ArrayList<ura> F;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ds9Var)) == null) {
                String str3 = "";
                boolean z2 = false;
                if (ds9Var == null || (F = ds9Var.F()) == null) {
                    str = "";
                } else {
                    Iterator<ura> it = F.iterator();
                    str = "";
                    while (it.hasNext()) {
                        ura next = it.next();
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
                    if (ds9Var != null && (i = ds9Var.i()) != null) {
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
