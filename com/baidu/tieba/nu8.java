package com.baidu.tieba;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tieba.oh7;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.tieba.zv4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class nu8 extends zv4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MainTabActivity c;
    public boolean d;

    /* loaded from: classes5.dex */
    public class a implements oh7.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zv4.a a;
        public final /* synthetic */ nu8 b;

        public a(nu8 nu8Var, zv4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nu8Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nu8Var;
            this.a = aVar;
        }

        @Override // com.baidu.tieba.oh7.e
        public void a() {
            zv4.a aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (aVar = this.a) != null) {
                aVar.a(false);
            }
        }

        @Override // com.baidu.tieba.oh7.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (!oh7.n(this.b.c).k(this.b.c.B.intValue(), 0)) {
                    zv4.a aVar = this.a;
                    if (aVar != null) {
                        aVar.a(false);
                        return;
                    }
                    return;
                }
                zv4.a aVar2 = this.a;
                if (aVar2 != null) {
                    aVar2.a(true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements oh7.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nu8 a;

        public b(nu8 nu8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nu8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nu8Var;
        }

        @Override // com.baidu.tieba.oh7.f
        public void dismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                gw4.r("insertAd");
                this.a.c();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nu8 a;

        public c(nu8 nu8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nu8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nu8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!oh7.n(this.a.c).I(this.a.c.B.intValue(), 0)) {
                    this.a.c();
                } else {
                    gw4.m("insertAd");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nu8(TbPageContext tbPageContext, zr8 zr8Var, MainTabActivity mainTabActivity, boolean z) {
        super(mainTabActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, zr8Var, mainTabActivity, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Activity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = mainTabActivity;
        this.d = z;
    }

    @Override // com.baidu.tieba.zv4
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            oh7.n(this.c).l();
        }
    }

    @Override // com.baidu.tieba.zv4
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            oh7.n(this.c).F(new b(this));
            ah.a().postDelayed(new c(this), 400L);
        }
    }

    @Override // com.baidu.tieba.zv4
    public void d(zv4.a aVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            if (gw4.k() && aVar != null) {
                aVar.a(false);
            } else if (!oh7.m && ((TbSingleton.getInstance().isCanShowHotSplash || oh7.m || TbSingleton.getInstance().mIsSplashClick) && !this.d)) {
                if (aVar != null) {
                    aVar.a(false);
                }
            } else {
                oh7 n = oh7.n(this.c);
                if (oh7.m) {
                    str = "1";
                } else {
                    str = "2";
                }
                if (!n.C(str, this.c.B.intValue(), 0, this.c.K, new a(this, aVar), false) && aVar != null) {
                    aVar.a(false);
                }
            }
        }
    }
}
