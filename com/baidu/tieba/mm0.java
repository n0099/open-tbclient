package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.scheduled.NadScheduledConfirmView;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class mm0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mm0 a;

        public a(mm0 mm0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mm0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mm0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                mm0 mm0Var = this.a;
                mm0Var.a = !mm0Var.a;
                if (view2 instanceof RadioButton) {
                    ((RadioButton) view2).setChecked(this.a.a);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Dialog c;
        public final /* synthetic */ mm0 d;

        public b(mm0 mm0Var, String str, String str2, Dialog dialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mm0Var, str, str2, dialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = mm0Var;
            this.a = str;
            this.b = str2;
            this.c = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                nm0.b().c(this.a, this.d.a);
                mm0 mm0Var = this.d;
                mm0Var.f(true, this.b, mm0Var.a);
                this.c.dismiss();
                if (this.d.a) {
                    View inflate = LayoutInflater.from(tj0.b()).inflate(R.layout.nad_scheduled_confirm_toast_view, (ViewGroup) null);
                    ((TextView) inflate.findViewById(R.id.nad_scheduled_confirm_toast_view)).setText(tj0.b().getResources().getString(R.string.nad_scheduled_dialog_toast_text));
                    Toast toast = new Toast(view2.getContext());
                    toast.setView(inflate);
                    toast.setGravity(17, 0, 0);
                    toast.show();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ mm0 c;

        public c(mm0 mm0Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mm0Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = mm0Var;
            this.a = str;
            this.b = str2;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                nm0.b().c(this.a, false);
                mm0 mm0Var = this.c;
                mm0Var.f(false, this.b, mm0Var.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(mm0 mm0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mm0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                fn0.a().a(new qm0(false));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public static final mm0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-599539112, "Lcom/baidu/tieba/mm0$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-599539112, "Lcom/baidu/tieba/mm0$e;");
                    return;
                }
            }
            a = new mm0(null);
        }
    }

    public mm0() {
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

    public static mm0 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return e.a;
        }
        return (mm0) invokeV.objValue;
    }

    public /* synthetic */ mm0(a aVar) {
        this();
    }

    public void e(String str, String str2, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048576, this, str, str2, context) != null) || !(context instanceof Activity)) {
            return;
        }
        Dialog dialog = new Dialog(context, R.style.obfuscated_res_0x7f10010c);
        NadScheduledConfirmView nadScheduledConfirmView = new NadScheduledConfirmView(context);
        this.a = true;
        nadScheduledConfirmView.setOnWifiBtnClickListener(new a(this));
        nadScheduledConfirmView.setOnPosBtnClickListener(new b(this, str, str2, dialog));
        dialog.setContentView(nadScheduledConfirmView);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.setOnCancelListener(new c(this, str, str2));
        dialog.setOnDismissListener(new d(this));
        dialog.show();
        fn0.a().a(new qm0(true));
    }

    public final void f(boolean z, String str, boolean z2) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.u(ClogBuilder.Page.SCHEDULED_DOWNLOAD);
            clogBuilder.y(ClogBuilder.LogType.NAVIDEO_POP_CLOSE);
            clogBuilder.p(str);
            clogBuilder.j("ScheduledPop");
            String str3 = "0";
            if (z) {
                str2 = "0";
            } else {
                str2 = "1";
            }
            if (z2) {
                str3 = "1";
            }
            clogBuilder.k(str2);
            clogBuilder.l(str3);
            x31.e(clogBuilder);
        }
    }
}
