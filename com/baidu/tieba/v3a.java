package com.baidu.tieba;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tieba.cn8;
import com.baidu.tieba.s55;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class v3a extends s55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MainTabActivity c;
    public boolean d;

    /* loaded from: classes8.dex */
    public class a implements cn8.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s55.a a;
        public final /* synthetic */ v3a b;

        public a(v3a v3aVar, s55.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v3aVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v3aVar;
            this.a = aVar;
        }

        @Override // com.baidu.tieba.cn8.e
        public void a() {
            s55.a aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (aVar = this.a) != null) {
                aVar.callback(false);
            }
        }

        @Override // com.baidu.tieba.cn8.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (!cn8.n(this.b.c).k(this.b.c.B.intValue(), 2)) {
                    s55.a aVar = this.a;
                    if (aVar != null) {
                        aVar.callback(false);
                        return;
                    }
                    return;
                }
                s55.a aVar2 = this.a;
                if (aVar2 != null) {
                    aVar2.callback(true);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements cn8.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v3a a;

        public b(v3a v3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v3aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v3aVar;
        }

        @Override // com.baidu.tieba.cn8.f
        public void dismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                z55.s("insertAd");
                this.a.c();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v3a a;

        public c(v3a v3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v3aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v3aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!cn8.n(this.a.c).H(this.a.c.B.intValue(), 2)) {
                    this.a.c();
                } else {
                    z55.m("insertAd");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v3a(TbPageContext tbPageContext, a1a a1aVar, MainTabActivity mainTabActivity, boolean z) {
        super(mainTabActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, a1aVar, mainTabActivity, Boolean.valueOf(z)};
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

    @Override // com.baidu.tieba.s55
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            cn8.n(this.c).l();
        }
    }

    @Override // com.baidu.tieba.s55
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            cn8.n(this.c).E(new b(this));
            wg.a().postDelayed(new c(this), 400L);
        }
    }

    @Override // com.baidu.tieba.s55
    public void d(s55.a aVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            if (z55.j() && aVar != null) {
                aVar.callback(false);
            } else if (!cn8.m && ((TbSingleton.getInstance().isCanShowHotSplash || cn8.m || TbSingleton.getInstance().mIsSplashClick) && !this.d)) {
                if (aVar != null) {
                    aVar.callback(false);
                }
            } else {
                cn8 n = cn8.n(this.c);
                if (cn8.m) {
                    str = "1";
                } else {
                    str = "2";
                }
                if (!n.B(str, this.c.B.intValue(), 2, this.c.K, new a(this, aVar), false) && aVar != null) {
                    aVar.callback(false);
                }
            }
        }
    }
}
