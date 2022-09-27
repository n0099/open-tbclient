package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.RemoveFansController;
import com.baidu.tieba.ke6;
import com.baidu.tieba.yy8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class le6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public RemoveFansController b;
    public ke6 c;
    public e48 d;
    public yy8 e;
    public e f;

    /* loaded from: classes4.dex */
    public class a implements ke6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ le6 a;

        public a(le6 le6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {le6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = le6Var;
        }

        @Override // com.baidu.tieba.ke6.b
        public void a(int i, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) || this.a.f == null) {
                return;
            }
            this.a.f.b(i, str, z, 0, 0L);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements RemoveFansController.IResultCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ le6 a;

        public b(le6 le6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {le6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = le6Var;
        }

        @Override // com.baidu.tbadk.core.util.RemoveFansController.IResultCallBack
        public void onResultCallBack(int i, String str, long j, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Long.valueOf(j), Boolean.valueOf(z)}) == null) || this.a.f == null) {
                return;
            }
            this.a.f.b(i, str, z, 1, j);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements yy8.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ le6 a;

        public c(le6 le6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {le6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = le6Var;
        }

        @Override // com.baidu.tieba.yy8.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d.dismiss();
                if (this.a.f != null) {
                    this.a.f.a();
                }
                this.a.c.d();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements yy8.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ le6 a;

        public d(le6 le6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {le6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = le6Var;
        }

        @Override // com.baidu.tieba.yy8.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.d == null) {
                return;
            }
            this.a.d.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a();

        void b(int i, String str, boolean z, int i2, long j);
    }

    public le6(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        ke6 ke6Var = new ke6(tbPageContext, bdUniqueId);
        this.c = ke6Var;
        ke6Var.e(new a(this));
        RemoveFansController removeFansController = new RemoveFansController(tbPageContext, bdUniqueId);
        this.b = removeFansController;
        removeFansController.setResultCallBack(new b(this));
    }

    public void d() {
        yy8 yy8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (yy8Var = this.e) == null) {
            return;
        }
        yy8Var.e();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            h();
        }
    }

    public void f(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.b.removeFans(j);
        }
    }

    public void g(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            this.f = eVar;
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.d == null) {
                yy8 yy8Var = new yy8(this.a.getContext());
                this.e = yy8Var;
                yy8Var.h(this.a.getString(R.string.obfuscated_res_0x7f0f043c));
                ArrayList arrayList = new ArrayList();
                yy8.b bVar = new yy8.b(this.a.getString(R.string.obfuscated_res_0x7f0f0436), this.e);
                bVar.h(new c(this));
                arrayList.add(bVar);
                this.e.g(new d(this));
                this.e.f(arrayList);
                e48 e48Var = new e48(this.a.getPageActivity(), this.e.b());
                this.d = e48Var;
                e48Var.a(0.7f);
            }
            this.d.show();
        }
    }
}
