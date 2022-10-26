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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.u21;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class tl0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public Dialog b;
    public TextView c;
    public RelativeLayout d;
    public TextView e;
    public RelativeLayout f;
    public boolean g;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View.OnClickListener a;
        public final /* synthetic */ tl0 b;

        public a(tl0 tl0Var, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tl0Var, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tl0Var;
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

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View.OnClickListener a;
        public final /* synthetic */ tl0 b;

        public b(tl0 tl0Var, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tl0Var, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tl0Var;
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

    /* loaded from: classes6.dex */
    public class c implements DialogInterface.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DialogInterface.OnKeyListener a;
        public final /* synthetic */ tl0 b;

        public c(tl0 tl0Var, DialogInterface.OnKeyListener onKeyListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tl0Var, onKeyListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tl0Var;
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

    public tl0(Activity activity) {
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

    public tl0 e(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            this.b.setCancelable(z);
            return this;
        }
        return (tl0) invokeZ.objValue;
    }

    public tl0 f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            this.b.setCanceledOnTouchOutside(z);
            return this;
        }
        return (tl0) invokeZ.objValue;
    }

    public tl0 h(View.OnClickListener onClickListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, onClickListener)) == null) {
            this.f.setOnClickListener(new b(this, onClickListener));
            return this;
        }
        return (tl0) invokeL.objValue;
    }

    public tl0 i(DialogInterface.OnKeyListener onKeyListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, onKeyListener)) == null) {
            this.b.setOnKeyListener(new c(this, onKeyListener));
            return this;
        }
        return (tl0) invokeL.objValue;
    }

    public tl0 j(View.OnClickListener onClickListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, onClickListener)) == null) {
            this.d.setOnClickListener(new a(this, onClickListener));
            return this;
        }
        return (tl0) invokeL.objValue;
    }

    public tl0 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d05d6, lk0.b().b(this.a), false);
            this.c = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09008f);
            this.d = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090093);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090092);
            this.e = textView;
            textView.setTextColor(-48831);
            this.f = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090091);
            Dialog dialog = new Dialog(this.a, R.style.obfuscated_res_0x7f100133);
            this.b = dialog;
            dialog.setContentView(inflate);
            Window window = this.b.getWindow();
            if (window != null) {
                window.setGravity(80);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = u21.c.e(this.a);
                window.setAttributes(attributes);
            }
            return this;
        }
        return (tl0) invokeV.objValue;
    }

    public tl0 g(mk0 mk0Var) {
        InterceptResult invokeL;
        SpannableString spannableString;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, mk0Var)) == null) {
            String str = mk0Var.p.h;
            if (TextUtils.equals(mk0Var.q.o, "reminded_type_unopen")) {
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
        return (tl0) invokeL.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            o21.b(this.b);
        }
    }
}
