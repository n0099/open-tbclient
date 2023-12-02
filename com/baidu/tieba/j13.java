package com.baidu.tieba;

import android.content.Context;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppBaseActivity;
import com.baidu.tieba.m53;
import com.baidu.tieba.o13;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.FreeSpaceBox;
/* loaded from: classes6.dex */
public final class j13 implements o13.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public boolean c;
    public final int d;
    public final n13 e;
    public final Context f;

    /* loaded from: classes6.dex */
    public class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ j13 b;

        public a(j13 j13Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j13Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j13Var;
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
        public final /* synthetic */ j13 b;

        public b(j13 j13Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j13Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j13Var;
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
        public final /* synthetic */ j13 b;

        public c(j13 j13Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j13Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j13Var;
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
        public final /* synthetic */ j13 a;

        public d(j13 j13Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j13Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j13Var;
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
        public final /* synthetic */ n13 b;
        public final /* synthetic */ j13 c;

        public e(j13 j13Var, String str, n13 n13Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j13Var, str, n13Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = j13Var;
            this.a = str;
            this.b = n13Var;
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

    public j13(Context context, int i, @NonNull n13 n13Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), n13Var};
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
        this.e = n13Var;
    }

    public final boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return ye3.a().getBoolean(str, false);
        }
        return invokeL.booleanValue;
    }

    public final String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            Context applicationContext = j63.K().getApplicationContext();
            return applicationContext.getString(R.string.obfuscated_res_0x7f0f15a3, ek3.l(applicationContext), str);
        }
        return (String) invokeL.objValue;
    }

    public final String n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            return j63.K().getApplicationContext().getString(R.string.obfuscated_res_0x7f0f15a4, str);
        }
        return (String) invokeL.objValue;
    }

    public final void p(String str, n13 n13Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, n13Var) == null) {
            Context context = this.f;
            if (context != null && fn4.a(context, str)) {
                z = true;
            } else {
                z = false;
            }
            this.c = z;
            if (z) {
                n13Var.a("permission granted successful");
            } else {
                n13Var.b(1, "user denied");
            }
        }
    }

    public final void r(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048587, this, str, z) == null) && str != null) {
            ye3.a().putBoolean(str, z);
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
            oj3.g(this.f);
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            j63 K = j63.K();
            String appId = K.getAppId();
            md3 md3Var = new md3();
            md3Var.f = appId;
            md3Var.a = "swan";
            md3Var.c = k13.a(this.d);
            md3Var.g = "minipnl";
            md3Var.b = str;
            md3Var.e = k13.b(this.c);
            md3Var.a("appid", appId);
            md3Var.a("appname", K.q().a0());
            md3Var.a("host", rp2.n().a());
            xc3.onEvent(md3Var);
        }
    }

    public final String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            String P = j63.K().q().P();
            return "permission/" + str + "/" + P;
        }
        return (String) invokeL.objValue;
    }

    public final m53 o(Context context, String str, String str2, String str3, String str4, n13 n13Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{context, str, str2, str3, str4, n13Var})) == null) {
            m53.a aVar = new m53.a(context);
            aVar.f0(str);
            aVar.e0(str2);
            aVar.i0(new e(this, str4, n13Var));
            aVar.j0(new d(this));
            aVar.g0(new c(this, str3));
            aVar.k0(new b(this, str3));
            aVar.h0(new a(this, str3));
            return aVar.c();
        }
        return (m53) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.o13.a
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
                        if (!uj4.g((SwanAppBaseActivity) this.f, str)) {
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

    public final void q(String str, n13 n13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, n13Var) == null) {
            if (!(this.f instanceof SwanAppBaseActivity)) {
                this.e.b(2, "request permission fail");
                return;
            }
            String l = l(str);
            if (k(l)) {
                this.e.b(2, "request permission fail");
                return;
            }
            String n = oj3.n(str);
            if (n != null && n.trim().length() != 0) {
                o(this.f, n(n), m(n), l, str, n13Var).show();
                return;
            }
            this.e.b(2, "request permission fail");
        }
    }

    public o13.a s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return new i13(this.d, this.e);
        }
        return (o13.a) invokeV.objValue;
    }
}
