package com.baidu.tieba;

import android.content.Context;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppBaseActivity;
import com.baidu.tieba.r43;
import com.baidu.tieba.t03;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.FreeSpaceBox;
/* loaded from: classes7.dex */
public final class o03 implements t03.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public boolean c;
    public final int d;
    public final s03 e;
    public final Context f;

    /* loaded from: classes7.dex */
    public class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ o03 b;

        public a(o03 o03Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o03Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o03Var;
            this.a = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(1048576, this, dialogInterface, i) != null) || !this.b.a) {
                return;
            }
            if (this.b.b) {
                dialogInterface.dismiss();
            } else {
                this.b.h(this.a, i, dialogInterface);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ o03 b;

        public b(o03 o03Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o03Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o03Var;
            this.a = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLI(1048576, this, dialogInterface, i) != null) {
                return;
            }
            this.b.i(this.a, i, dialogInterface);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ o03 b;

        public c(o03 o03Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o03Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o03Var;
            this.a = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLI(1048576, this, dialogInterface, i) != null) {
                return;
            }
            this.b.h(this.a, i, dialogInterface);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements DialogInterface.OnShowListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o03 a;

        public d(o03 o03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o03Var;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dialogInterface) != null) {
                return;
            }
            this.a.a = true;
            this.a.j("show");
        }
    }

    /* loaded from: classes7.dex */
    public class e implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ s03 b;
        public final /* synthetic */ o03 c;

        public e(o03 o03Var, String str, s03 s03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o03Var, str, s03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = o03Var;
            this.a = str;
            this.b = s03Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dialogInterface) != null) {
                return;
            }
            this.c.p(this.a, this.b);
            this.c.a = false;
        }
    }

    public o03(Context context, int i, @NonNull s03 s03Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), s03Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.b = false;
        this.c = false;
        this.f = context;
        this.d = i;
        this.e = s03Var;
    }

    public final boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return de3.a().getBoolean(str, false);
        }
        return invokeL.booleanValue;
    }

    public final String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            Context applicationContext = o53.K().getApplicationContext();
            return applicationContext.getString(R.string.obfuscated_res_0x7f0f157b, jj3.l(applicationContext), str);
        }
        return (String) invokeL.objValue;
    }

    public final String n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            return o53.K().getApplicationContext().getString(R.string.obfuscated_res_0x7f0f157c, str);
        }
        return (String) invokeL.objValue;
    }

    public final void p(String str, s03 s03Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, s03Var) == null) {
            Context context = this.f;
            if (context != null && km4.a(context, str)) {
                z = true;
            } else {
                z = false;
            }
            this.c = z;
            if (z) {
                s03Var.a("permission granted successful");
            } else {
                s03Var.b(1, "user denied");
            }
        }
    }

    public final void r(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048587, this, str, z) == null) && str != null) {
            de3.a().putBoolean(str, z);
        }
    }

    public final void h(String str, int i, DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i, dialogInterface) == null) {
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            r(str, z);
            if (z) {
                j("deny_mute");
            } else {
                j("deny");
            }
            dialogInterface.dismiss();
        }
    }

    public final void i(String str, int i, DialogInterface dialogInterface) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i, dialogInterface) == null) {
            if (i == 1) {
                z = true;
            } else {
                z = false;
            }
            r(str, z);
            if (z) {
                j("skip_mute");
            } else {
                j(FreeSpaceBox.TYPE);
            }
            this.b = true;
            dialogInterface.dismiss();
            ti3.g(this.f);
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            o53 K = o53.K();
            String appId = K.getAppId();
            rc3 rc3Var = new rc3();
            rc3Var.f = appId;
            rc3Var.a = "swan";
            rc3Var.c = p03.a(this.d);
            rc3Var.g = "minipnl";
            rc3Var.b = str;
            rc3Var.e = p03.b(this.c);
            rc3Var.a("appid", appId);
            rc3Var.a("appname", K.q().a0());
            rc3Var.a("host", wo2.n().a());
            cc3.onEvent(rc3Var);
        }
    }

    public final String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            String P = o53.K().q().P();
            return "permission/" + str + "/" + P;
        }
        return (String) invokeL.objValue;
    }

    public final r43 o(Context context, String str, String str2, String str3, String str4, s03 s03Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{context, str, str2, str3, str4, s03Var})) == null) {
            r43.a aVar = new r43.a(context);
            aVar.f0(str);
            aVar.e0(str2);
            aVar.i0(new e(this, str4, s03Var));
            aVar.j0(new d(this));
            aVar.g0(new c(this, str3));
            aVar.k0(new b(this, str3));
            aVar.h0(new a(this, str3));
            return aVar.c();
        }
        return (r43) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.t03.a
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, strArr, iArr) == null) {
            if (i != this.d) {
                this.e.b(2, "request permission fail");
            } else if (strArr.length == 0 && iArr.length == 0) {
                this.e.a("permission granted successful");
            } else if (strArr.length != iArr.length) {
                this.e.b(2, "request permission fail");
            } else if (!(this.f instanceof SwanAppBaseActivity)) {
                this.e.b(2, "request permission fail");
            } else {
                for (int i2 = 0; i2 < iArr.length; i2++) {
                    String str = strArr[i2];
                    if (iArr[i2] == -1) {
                        if (!zi4.g((SwanAppBaseActivity) this.f, str)) {
                            q(str, this.e);
                            return;
                        } else {
                            this.e.b(1, "user denied");
                            return;
                        }
                    }
                }
                this.e.a("permission granted successful");
            }
        }
    }

    public final void q(String str, s03 s03Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, s03Var) == null) {
            if (!(this.f instanceof SwanAppBaseActivity)) {
                this.e.b(2, "request permission fail");
                return;
            }
            String l = l(str);
            if (k(l)) {
                this.e.b(2, "request permission fail");
                return;
            }
            String n = ti3.n(str);
            if (n != null && n.trim().length() != 0) {
                o(this.f, n(n), m(n), l, str, s03Var).show();
                return;
            }
            this.e.b(2, "request permission fail");
        }
    }

    public t03.a s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return new n03(this.d, this.e);
        }
        return (t03.a) invokeV.objValue;
    }
}
