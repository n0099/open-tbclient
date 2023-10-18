package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.c11;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class rh0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public Dialog b;
    public TextView c;
    public RelativeLayout d;
    public TextView e;
    public RelativeLayout f;
    public boolean g;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View.OnClickListener a;
        public final /* synthetic */ rh0 b;

        public a(rh0 rh0Var, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rh0Var, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rh0Var;
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                View.OnClickListener onClickListener = this.a;
                if (onClickListener != null) {
                    onClickListener.onClick(view2);
                }
                this.b.b.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View.OnClickListener a;
        public final /* synthetic */ rh0 b;

        public b(rh0 rh0Var, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rh0Var, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rh0Var;
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.b.dismiss();
                View.OnClickListener onClickListener = this.a;
                if (onClickListener != null) {
                    onClickListener.onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements DialogInterface.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DialogInterface.OnKeyListener a;
        public final /* synthetic */ rh0 b;

        public c(rh0 rh0Var, DialogInterface.OnKeyListener onKeyListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rh0Var, onKeyListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rh0Var;
            this.a = onKeyListener;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i, keyEvent)) == null) {
                if (!this.b.g) {
                    this.b.g = true;
                } else {
                    this.b.b.dismiss();
                    DialogInterface.OnKeyListener onKeyListener = this.a;
                    if (onKeyListener != null) {
                        onKeyListener.onKey(dialogInterface, i, keyEvent);
                    }
                    this.b.g = false;
                }
                return true;
            }
            return invokeLIL.booleanValue;
        }
    }

    public rh0(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = activity;
    }

    public rh0 e(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            this.b.setCancelable(z);
            return this;
        }
        return (rh0) invokeZ.objValue;
    }

    public rh0 f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            this.b.setCanceledOnTouchOutside(z);
            return this;
        }
        return (rh0) invokeZ.objValue;
    }

    public rh0 h(View.OnClickListener onClickListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, onClickListener)) == null) {
            this.f.setOnClickListener(new b(this, onClickListener));
            return this;
        }
        return (rh0) invokeL.objValue;
    }

    public rh0 i(DialogInterface.OnKeyListener onKeyListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, onKeyListener)) == null) {
            this.b.setOnKeyListener(new c(this, onKeyListener));
            return this;
        }
        return (rh0) invokeL.objValue;
    }

    public rh0 j(View.OnClickListener onClickListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, onClickListener)) == null) {
            this.d.setOnClickListener(new a(this, onClickListener));
            return this;
        }
        return (rh0) invokeL.objValue;
    }

    public rh0 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.nad_back_alert_dialog, dg0.b().b(this.a), false);
            this.c = (TextView) inflate.findViewById(R.id.ad_back_alert_dialog_description);
            this.d = (RelativeLayout) inflate.findViewById(R.id.ad_back_alert_dialog_positive_layout);
            TextView textView = (TextView) inflate.findViewById(R.id.ad_back_alert_dialog_positive_button);
            this.e = textView;
            textView.setTextColor(-48831);
            this.f = (RelativeLayout) inflate.findViewById(R.id.ad_back_alert_dialog_negative_layout);
            Dialog dialog = new Dialog(this.a, R.style.obfuscated_res_0x7f100140);
            this.b = dialog;
            dialog.setContentView(inflate);
            Window window = this.b.getWindow();
            if (window != null) {
                window.setGravity(80);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = c11.c.e(this.a);
                window.setAttributes(attributes);
            }
            return this;
        }
        return (rh0) invokeV.objValue;
    }

    public rh0 g(@NonNull eg0 eg0Var) {
        InterceptResult invokeL;
        SpannableString spannableString;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, eg0Var)) == null) {
            String str = eg0Var.p.h;
            if (TextUtils.equals(eg0Var.q.o, "reminded_type_unopen")) {
                spannableString = new SpannableString("您刚刚下载的" + str + "应用还没有体验，是否立即体验？");
                this.e.setText("去体验");
            } else {
                spannableString = new SpannableString("您刚刚下载的" + str + "应用还没有安装，是否立即安装？");
                this.e.setText("去安装");
            }
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(-48831);
            if (!TextUtils.isEmpty(str.trim())) {
                spannableString.setSpan(foregroundColorSpan, 6, str.trim().length() + 6, 18);
            }
            this.c.setText(spannableString);
            return this;
        }
        return (rh0) invokeL.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            u01.b(this.b);
        }
    }
}
