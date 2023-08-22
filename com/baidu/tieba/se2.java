package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class se2 extends de2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b D;

    /* loaded from: classes8.dex */
    public interface b {
        void a();

        void b(wm3 wm3Var);

        void onSuccess();
    }

    @Override // com.baidu.tieba.he2
    public int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.de2
    public PMSDownloadType k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (PMSDownloadType) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ wm3 b;
        public final /* synthetic */ se2 c;

        public a(se2 se2Var, int i, wm3 wm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {se2Var, Integer.valueOf(i), wm3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = se2Var;
            this.a = i;
            this.b = wm3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.c.D != null) {
                int i = this.a;
                if (i != -1) {
                    if (i != 0) {
                        if (i == 1) {
                            this.c.D.onSuccess();
                            return;
                        }
                        return;
                    }
                    this.c.D.a();
                    return;
                }
                this.c.D.b(this.b);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public se2(String str, b bVar) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.D = bVar;
    }

    @Override // com.baidu.tieba.de2, com.baidu.tieba.yi4
    public void C(xj4 xj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xj4Var) == null) {
            super.C(xj4Var);
            wm3 wm3Var = new wm3();
            wm3Var.k(10L);
            wm3Var.c(xj4Var);
            J0(-1, wm3Var);
        }
    }

    public final void I0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            J0(i, null);
        }
    }

    @Override // com.baidu.tieba.de2
    public void w0(Throwable th) {
        wm3 wm3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, th) == null) {
            if (th instanceof PkgDownloadError) {
                wm3Var = ((PkgDownloadError) th).getErrCode();
            } else {
                wm3Var = new wm3();
                wm3Var.k(10L);
                wm3Var.i(0L);
            }
            J0(-1, wm3Var);
        }
    }

    @Override // com.baidu.tieba.yi4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            I0(0);
        }
    }

    @Override // com.baidu.tieba.de2
    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.v0();
            wm3 F0 = F0();
            if (F0 == null) {
                I0(1);
                A0("page_route_download", "0");
                return;
            }
            J0(-1, F0);
        }
    }

    public final void J0(int i, wm3 wm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, wm3Var) == null) {
            xo3.a0(new a(this, i, wm3Var));
        }
    }
}
