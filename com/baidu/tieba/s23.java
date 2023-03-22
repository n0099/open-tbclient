package com.baidu.tieba;

import android.content.Context;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppBaseActivity;
import com.baidu.tieba.v63;
import com.baidu.tieba.x23;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.FreeSpaceBox;
/* loaded from: classes6.dex */
public final class s23 implements x23.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public boolean c;
    public final int d;
    public final w23 e;
    public final Context f;

    /* loaded from: classes6.dex */
    public class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ s23 b;

        public a(s23 s23Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s23Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s23Var;
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

    /* loaded from: classes6.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ s23 b;

        public b(s23 s23Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s23Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s23Var;
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

    /* loaded from: classes6.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ s23 b;

        public c(s23 s23Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s23Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s23Var;
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

    /* loaded from: classes6.dex */
    public class d implements DialogInterface.OnShowListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s23 a;

        public d(s23 s23Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s23Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s23Var;
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

    /* loaded from: classes6.dex */
    public class e implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ w23 b;
        public final /* synthetic */ s23 c;

        public e(s23 s23Var, String str, w23 w23Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s23Var, str, w23Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = s23Var;
            this.a = str;
            this.b = w23Var;
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

    public s23(Context context, int i, @NonNull w23 w23Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), w23Var};
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
        this.e = w23Var;
    }

    public final boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return hg3.a().getBoolean(str, false);
        }
        return invokeL.booleanValue;
    }

    public final String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            Context applicationContext = s73.K().getApplicationContext();
            return applicationContext.getString(R.string.obfuscated_res_0x7f0f13d1, nl3.l(applicationContext), str);
        }
        return (String) invokeL.objValue;
    }

    public final String n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            return s73.K().getApplicationContext().getString(R.string.obfuscated_res_0x7f0f13d2, str);
        }
        return (String) invokeL.objValue;
    }

    public final void p(String str, w23 w23Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, w23Var) == null) {
            Context context = this.f;
            if (context != null && po4.a(context, str)) {
                z = true;
            } else {
                z = false;
            }
            this.c = z;
            if (z) {
                w23Var.a("permission granted successful");
            } else {
                w23Var.b(1, "user denied");
            }
        }
    }

    public final void r(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048587, this, str, z) == null) && str != null) {
            hg3.a().putBoolean(str, z);
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
            xk3.g(this.f);
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            s73 K = s73.K();
            String appId = K.getAppId();
            ve3 ve3Var = new ve3();
            ve3Var.f = appId;
            ve3Var.a = "swan";
            ve3Var.c = t23.a(this.d);
            ve3Var.g = "minipnl";
            ve3Var.b = str;
            ve3Var.e = t23.b(this.c);
            ve3Var.a("appid", appId);
            ve3Var.a("appname", K.q().Z());
            ve3Var.a("host", ar2.n().a());
            ge3.onEvent(ve3Var);
        }
    }

    public final String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            String O = s73.K().q().O();
            return "permission/" + str + "/" + O;
        }
        return (String) invokeL.objValue;
    }

    public final v63 o(Context context, String str, String str2, String str3, String str4, w23 w23Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{context, str, str2, str3, str4, w23Var})) == null) {
            v63.a aVar = new v63.a(context);
            aVar.f0(str);
            aVar.e0(str2);
            aVar.i0(new e(this, str4, w23Var));
            aVar.j0(new d(this));
            aVar.g0(new c(this, str3));
            aVar.k0(new b(this, str3));
            aVar.h0(new a(this, str3));
            return aVar.c();
        }
        return (v63) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.x23.a
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
                        if (!dl4.f((SwanAppBaseActivity) this.f, str)) {
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

    public final void q(String str, w23 w23Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, w23Var) == null) {
            if (!(this.f instanceof SwanAppBaseActivity)) {
                this.e.b(2, "request permission fail");
                return;
            }
            String l = l(str);
            if (k(l)) {
                this.e.b(2, "request permission fail");
                return;
            }
            String m = xk3.m(str);
            if (m != null && m.trim().length() != 0) {
                o(this.f, n(m), m(m), l, str, w23Var).show();
                return;
            }
            this.e.b(2, "request permission fail");
        }
    }

    public x23.a s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return new r23(this.d, this.e);
        }
        return (x23.a) invokeV.objValue;
    }
}
