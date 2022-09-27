package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.presenter.LPDownloadManager;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.tieba.i41;
import com.baidu.tieba.qk0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class jk0 extends ff1<i41> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements i41 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.jk0$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0302a extends fm0<qk0> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i41.b b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0302a(a aVar, Class cls, i41.b bVar) {
                super(cls);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, cls, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((Class) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.fm0
            public void onEvent(@NonNull qk0 qk0Var) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qk0Var) == null) || this.b == null || wz0.g(qk0Var.a)) {
                    return;
                }
                for (qk0.a aVar : qk0Var.a) {
                    if (aVar instanceof qk0.a) {
                        qk0.a aVar2 = aVar;
                        if (!TextUtils.isEmpty(aVar2.b) && !TextUtils.isEmpty(aVar2.a) && !TextUtils.isEmpty(aVar2.c)) {
                            this.b.a("javascript:" + aVar2.a + "('" + xz0.a(aVar2.c) + "');");
                        }
                    }
                }
            }
        }

        public a(jk0 jk0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jk0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.i41
        public void a(Object obj, i41.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, obj, bVar) == null) {
                bm0.a().b(obj, new C0302a(this, qk0.class, bVar));
            }
        }

        @Override // com.baidu.tieba.i41
        public void b(Context context, RelativeLayout relativeLayout, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, relativeLayout, str) == null) {
                LPDownloadManager.f(context, relativeLayout, str, true);
            }
        }

        @Override // com.baidu.tieba.i41
        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }
    }

    public jk0() {
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
    @Override // com.baidu.tieba.ff1
    /* renamed from: a */
    public i41 createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this) : (i41) invokeV.objValue;
    }
}
