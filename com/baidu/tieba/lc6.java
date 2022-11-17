package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.wo8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class lc6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LikeModel a;
    public wo8 b;
    public boolean c;
    public b d;
    public a e;
    public TbPageContext f;

    /* loaded from: classes4.dex */
    public interface a {
        void a(String str, long j);

        void b(String str, long j);

        void c(Object obj);
    }

    /* loaded from: classes4.dex */
    public class b extends q9 implements wo8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public a a;
        public final /* synthetic */ lc6 b;

        public b(lc6 lc6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lc6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lc6Var;
        }

        public void d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
                this.a = aVar;
            }
        }

        @Override // com.baidu.tieba.wo8.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
                this.b.c = false;
                yi.P(this.b.f.getPageActivity(), this.b.a.getErrorString());
                a aVar = this.a;
                if (aVar != null) {
                    aVar.b(str, j);
                }
            }
        }

        @Override // com.baidu.tieba.wo8.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                this.b.c = false;
                a aVar = this.a;
                if (aVar != null) {
                    aVar.a(str, j);
                }
            }
        }

        @Override // com.baidu.tieba.q9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                this.b.c = false;
                if (this.b.a.getErrorCode() == 22) {
                    yi.P(this.b.f.getPageActivity(), this.b.f.getString(R.string.obfuscated_res_0x7f0f084f));
                } else if (obj == null) {
                } else {
                    if (this.b.a.getErrorCode() != 0) {
                        yi.P(this.b.f.getPageActivity(), this.b.a.getErrorString());
                        return;
                    }
                    a aVar = this.a;
                    if (aVar != null) {
                        aVar.c(obj);
                    }
                }
            }
        }
    }

    public lc6() {
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

    public void g(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.e = aVar;
        }
    }

    public void h(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) {
            this.f = tbPageContext;
        }
    }

    public final boolean d(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tbPageContext)) == null) {
            if (!yi.F()) {
                UtilHelper.showToast(tbPageContext.getPageActivity(), tbPageContext.getString(R.string.obfuscated_res_0x7f0f0c81));
                return false;
            } else if (!ViewHelper.checkUpIsLogin(tbPageContext.getPageActivity())) {
                return false;
            } else {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) != null) || this.c || !d(this.f)) {
            return;
        }
        if (this.d == null) {
            b bVar = new b(this);
            this.d = bVar;
            bVar.d(this.e);
        }
        if (this.a == null) {
            LikeModel likeModel = new LikeModel(this.f);
            this.a = likeModel;
            likeModel.setLoadDataCallBack(this.d);
        }
        this.c = true;
        this.a.Q(str, str2);
    }

    public void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) != null) || this.c || !d(this.f)) {
            return;
        }
        if (this.d == null) {
            b bVar = new b(this);
            this.d = bVar;
            bVar.d(this.e);
        }
        if (this.b == null) {
            wo8 wo8Var = new wo8();
            this.b = wo8Var;
            wo8Var.b(this.d);
        }
        long g = xg.g(str2, -1L);
        if (g == -1) {
            return;
        }
        this.c = true;
        this.b.c(str, g);
    }
}
