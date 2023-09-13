package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaJumpHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes7.dex */
public class o86 extends bl1<kj0> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements kj0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.kj0
        public String[] c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (String[]) invokeV.objValue;
        }

        @Override // com.baidu.tieba.kj0
        public boolean d(Context context, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, str)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        /* renamed from: com.baidu.tieba.o86$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0422a implements nj0 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ boolean[] a;
            public final /* synthetic */ lj0 b;

            public C0422a(a aVar, boolean[] zArr, lj0 lj0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, zArr, lj0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = zArr;
                this.b = lj0Var;
            }

            @Override // com.baidu.tieba.nj0
            public void onResult(boolean z) {
                lj0 lj0Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    this.a[0] = z;
                    if (z && (lj0Var = this.b) != null) {
                        lj0Var.a(true, null);
                    }
                }
            }
        }

        public a(o86 o86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.kj0
        public boolean a(Context context, String str, @Nullable Map<String, Object> map, @Nullable lj0 lj0Var) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, str, map, lj0Var)) == null) {
                Log.e("CMDConfig", "host invoke command = " + str);
                if (UrlSchemaJumpHelper.isHitBlackList(str)) {
                    return true;
                }
                if (!str.startsWith("http://") && !str.startsWith("https://")) {
                    pj0.a(context, str, null, new C0422a(this, new boolean[1], lj0Var), false);
                    return true;
                }
                UrlManager.getInstance().dealOneLink(new String[]{str});
                return true;
            }
            return invokeLLLL.booleanValue;
        }

        @Override // com.baidu.tieba.kj0
        public void b(String str, String str2, nj0 nj0Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, nj0Var) == null) && nj0Var != null) {
                nj0Var.onResult(true);
            }
        }
    }

    public o86() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bl1
    /* renamed from: a */
    public kj0 createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (kj0) invokeV.objValue;
    }
}
