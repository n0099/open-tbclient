package com.baidu.tieba;

import android.content.Context;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppBaseActivity;
import com.baidu.tieba.a23;
import com.baidu.tieba.cy2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.FreeSpaceBox;
/* loaded from: classes6.dex */
public final class xx2 implements cy2.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public boolean c;
    public final int d;
    public final by2 e;
    public final Context f;

    /* loaded from: classes6.dex */
    public class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ xx2 b;

        public a(xx2 xx2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xx2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xx2Var;
            this.a = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) && this.b.a) {
                if (!this.b.b) {
                    this.b.h(this.a, i, dialogInterface);
                } else {
                    dialogInterface.dismiss();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ xx2 b;

        public b(xx2 xx2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xx2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xx2Var;
            this.a = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.b.i(this.a, i, dialogInterface);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ xx2 b;

        public c(xx2 xx2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xx2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xx2Var;
            this.a = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.b.h(this.a, i, dialogInterface);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements DialogInterface.OnShowListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xx2 a;

        public d(xx2 xx2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xx2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xx2Var;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.a = true;
                this.a.j("show");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ by2 b;
        public final /* synthetic */ xx2 c;

        public e(xx2 xx2Var, String str, by2 by2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xx2Var, str, by2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xx2Var;
            this.a = str;
            this.b = by2Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.c.p(this.a, this.b);
                this.c.a = false;
            }
        }
    }

    public xx2(Context context, int i, @NonNull by2 by2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), by2Var};
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
        this.e = by2Var;
    }

    public final void h(String str, int i, DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i, dialogInterface) == null) {
            boolean z = i == 1;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i, dialogInterface) == null) {
            boolean z = i == 1;
            r(str, z);
            if (z) {
                j("skip_mute");
            } else {
                j(FreeSpaceBox.TYPE);
            }
            this.b = true;
            dialogInterface.dismiss();
            cg3.g(this.f);
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            x23 K = x23.K();
            String appId = K.getAppId();
            aa3 aa3Var = new aa3();
            aa3Var.f = appId;
            aa3Var.a = "swan";
            aa3Var.c = yx2.a(this.d);
            aa3Var.g = "minipnl";
            aa3Var.b = str;
            aa3Var.e = yx2.b(this.c);
            aa3Var.a("appid", appId);
            aa3Var.a("appname", K.q().Z());
            aa3Var.a("host", fm2.n().a());
            l93.onEvent(aa3Var);
        }
    }

    public final boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? mb3.a().getBoolean(str, false) : invokeL.booleanValue;
    }

    public final String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            String O = x23.K().q().O();
            return "permission/" + str + "/" + O;
        }
        return (String) invokeL.objValue;
    }

    public final String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            Context applicationContext = x23.K().getApplicationContext();
            return applicationContext.getString(R.string.obfuscated_res_0x7f0f12f9, sg3.l(applicationContext), str);
        }
        return (String) invokeL.objValue;
    }

    public final String n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? x23.K().getApplicationContext().getString(R.string.obfuscated_res_0x7f0f12fa, str) : (String) invokeL.objValue;
    }

    public final a23 o(Context context, String str, String str2, String str3, String str4, by2 by2Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{context, str, str2, str3, str4, by2Var})) == null) {
            a23.a aVar = new a23.a(context);
            aVar.f0(str);
            aVar.e0(str2);
            aVar.i0(new e(this, str4, by2Var));
            aVar.j0(new d(this));
            aVar.g0(new c(this, str3));
            aVar.k0(new b(this, str3));
            aVar.h0(new a(this, str3));
            return aVar.c();
        }
        return (a23) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.cy2.a
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
                        if (!ig4.f((SwanAppBaseActivity) this.f, str)) {
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

    public final void p(String str, by2 by2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, by2Var) == null) {
            Context context = this.f;
            boolean z = context != null && uj4.a(context, str);
            this.c = z;
            if (z) {
                by2Var.a("permission granted successful");
            } else {
                by2Var.b(1, "user denied");
            }
        }
    }

    public final void q(String str, by2 by2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, by2Var) == null) {
            if (!(this.f instanceof SwanAppBaseActivity)) {
                this.e.b(2, "request permission fail");
                return;
            }
            String l = l(str);
            if (k(l)) {
                this.e.b(2, "request permission fail");
                return;
            }
            String m = cg3.m(str);
            if (m != null && m.trim().length() != 0) {
                o(this.f, n(m), m(m), l, str, by2Var).show();
                return;
            }
            this.e.b(2, "request permission fail");
        }
    }

    public final void r(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048587, this, str, z) == null) || str == null) {
            return;
        }
        mb3.a().putBoolean(str, z);
    }

    public cy2.a s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? new wx2(this.d, this.e) : (cy2.a) invokeV.objValue;
    }
}
