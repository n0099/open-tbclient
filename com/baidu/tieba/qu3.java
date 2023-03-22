package com.baidu.tieba;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog;
import com.baidu.swan.apps.view.SwanAppErrorDialog;
import com.baidu.swan.facade.init.SwanAppInitHelper;
import com.baidu.swan.facade.requred.webview.LoadingActivity;
import com.baidu.tieba.ou3;
import com.baidu.tieba.ud2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
/* loaded from: classes6.dex */
public class qu3 implements ou3.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    @Override // com.baidu.tieba.ou3.b
    public Bitmap d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (Bitmap) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class b implements mm3<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vd2 a;
        public final /* synthetic */ qu3 b;

        /* loaded from: classes6.dex */
        public class a implements ud2.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Boolean a;
            public final /* synthetic */ b b;

            public a(b bVar, Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, bool};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = bool;
            }

            @Override // com.baidu.tieba.ud2.e
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b bVar = this.b;
                    bVar.b.i(this.a, bVar.a);
                }
            }
        }

        public b(qu3 qu3Var, vd2 vd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu3Var, vd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qu3Var;
            this.a = vd2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm3
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                if (qu3.b) {
                    Log.i("SailorSoDownloadAdapter", "startDownload onCallback: " + bool);
                }
                if (!bool.booleanValue()) {
                    this.b.i(bool, this.a);
                } else {
                    SwanAppInitHelper.doWebViewInit(s73.K(), new a(this, bool));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vd2 a;
        public final /* synthetic */ qu3 b;

        public a(qu3 qu3Var, vd2 vd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu3Var, vd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qu3Var;
            this.a = vd2Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(1048576, this, dialogInterface, i) != null) || -2 == i) {
                return;
            }
            this.b.j();
            this.b.l(this.a);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(qu3 qu3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Context appContext = AppRuntime.getAppContext();
                Intent intent = new Intent(appContext, LoadingActivity.class);
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                intent.putExtra("so_lib_name", ZeusWebViewPreloadClass.ZEUS_FILE_DIR);
                ck3.g(appContext, intent);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(qu3 qu3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                s73.K().p("loading_hide");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948104282, "Lcom/baidu/tieba/qu3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948104282, "Lcom/baidu/tieba/qu3;");
                return;
            }
        }
        b = do1.a;
    }

    public qu3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
    }

    @Override // com.baidu.tieba.ou3.b
    public sk4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new vp4();
        }
        return (sk4) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            s73.M().post(new d(this));
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            s73.M().post(new c(this));
        }
    }

    @Override // com.baidu.tieba.ou3.b
    public void b(boolean z, vd2 vd2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, vd2Var) == null) {
            if (this.a) {
                if (!z) {
                    j();
                }
                l(vd2Var);
            } else if (z) {
                l(vd2Var);
            } else {
                k(new a(this, vd2Var));
            }
        }
    }

    public final void i(Boolean bool, vd2 vd2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bool, vd2Var) == null) {
            this.a = false;
            h();
            if (vd2Var != null) {
                if (bool.booleanValue()) {
                    vd2Var.onSuccess();
                } else {
                    vd2Var.onFail();
                }
            }
        }
    }

    public void k(DialogInterface.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            BaseActivityDialog.e r = SwanAppErrorDialog.r();
            r.B(R.string.obfuscated_res_0x7f0f01e2);
            r.u(R.string.obfuscated_res_0x7f0f01e1);
            r.w(R.string.obfuscated_res_0x7f0f01df, onClickListener);
            r.z(R.string.obfuscated_res_0x7f0f01e0, onClickListener);
            r.D();
        }
    }

    public final void l(vd2 vd2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, vd2Var) == null) {
            this.a = true;
            if (b) {
                Log.i("SailorSoDownloadAdapter", "startDownload: ");
            }
            ih2 ih2Var = ih2.d;
            jh2 jh2Var = new jh2();
            jh2Var.h(ZeusWebViewPreloadClass.ZEUS_FILE_DIR, new b(this, vd2Var));
            ih2Var.C(jh2Var);
        }
    }
}
