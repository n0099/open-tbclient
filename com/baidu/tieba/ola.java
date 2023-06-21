package com.baidu.tieba;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatusbarColorUtils;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.pla;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.write.data.CreateTagResponseData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.bottomsheet.BottomSheetDialog;
/* loaded from: classes7.dex */
public class ola {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public w95 b;
    public BottomSheetDialog c;
    public BdTopToast d;
    public ViewGroup e;
    public View f;
    public TextView g;
    public TextView h;
    public TextView i;
    public LinearLayout j;
    public EditText k;
    public ImageView l;
    public int m;
    public String n;
    public String o;
    public pla p;
    public lla q;
    public final Runnable r;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ola a;

        public a(ola olaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {olaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = olaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null && this.a.k != null) {
                wi.O(this.a.a, this.a.k);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ola a;

        public b(ola olaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {olaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = olaVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dialogInterface) != null) {
                return;
            }
            this.a.o();
        }
    }

    /* loaded from: classes7.dex */
    public class c implements pla.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ola a;

        public c(ola olaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {olaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = olaVar;
        }

        @Override // com.baidu.tieba.pla.b
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || this.a.a == null) {
                return;
            }
            this.a.n();
            this.a.w(str);
        }

        @Override // com.baidu.tieba.pla.b
        public void a(CreateTagResponseData createTagResponseData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, createTagResponseData) == null) {
                this.a.n();
                if (createTagResponseData != null && createTagResponseData.tagInfo != null && this.a.q != null) {
                    this.a.q.a(createTagResponseData.tagInfo);
                }
                if (this.a.c != null) {
                    this.a.c.dismiss();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ola a;

        public d(ola olaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {olaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = olaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String trim = this.a.k.getText().toString().trim();
                if (!TextUtils.isEmpty(trim) && trim.equals(this.a.o)) {
                    if (this.a.c != null) {
                        this.a.c.dismiss();
                    }
                } else if (this.a.p != null) {
                    this.a.p.c(this.a.k.getText().toString().trim(), this.a.n);
                    this.a.o();
                    this.a.v();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ola a;

        public e(ola olaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {olaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = olaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.c != null) {
                this.a.c.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ola a;

        public f(ola olaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {olaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = olaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.k.setText((CharSequence) null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ola a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }

        public g(ola olaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {olaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = olaVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, editable) != null) {
                return;
            }
            this.a.t(editable);
        }
    }

    /* loaded from: classes7.dex */
    public class h implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ola a;

        public h(ola olaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {olaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = olaVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                xg.a().removeCallbacks(this.a.r);
            }
        }
    }

    public ola() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = new a(this);
    }

    public final void n() {
        w95 w95Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (w95Var = this.b) != null) {
            w95Var.b();
        }
    }

    public final void o() {
        BdTopToast bdTopToast;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (bdTopToast = this.d) == null) {
            return;
        }
        bdTopToast.b();
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            pla plaVar = new pla();
            this.p = plaVar;
            plaVar.e();
            this.p.f(new c(this));
        }
    }

    public void s() {
        pla plaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (plaVar = this.p) != null) {
            plaVar.g();
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.b == null) {
                w95 w95Var = new w95(this.a);
                w95Var.c(false);
                w95Var.d(this.a.getString(R.string.obfuscated_res_0x7f0f050d));
                this.b = w95Var;
            }
            this.b.e();
        }
    }

    public final void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (this.d == null) {
                this.d = new BdTopToast(this.a);
            }
            this.d.g(str);
            this.d.i(this.e);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.c = new BottomSheetDialog(this.a, R.style.obfuscated_res_0x7f1000fc);
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0262, (ViewGroup) null);
            this.f = inflate;
            this.g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090807);
            this.h = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f090529);
            this.i = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f09077e);
            this.j = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f09013b);
            this.k = (EditText) this.f.findViewById(R.id.obfuscated_res_0x7f090a48);
            this.l = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f0911d4);
            this.i.setOnClickListener(new d(this));
            this.h.setOnClickListener(new e(this));
            this.l.setOnClickListener(new f(this));
            this.k.addTextChangedListener(new g(this));
            this.c.setContentView(this.f);
            if (this.c.getWindow() != null && this.c.getWindow().getAttributes() != null) {
                this.m = this.c.getWindow().getAttributes().windowAnimations;
            }
            this.c.setOnDismissListener(new h(this));
            r();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0105);
            p75 d2 = p75.d(this.f);
            d2.n(1);
            d2.o(R.string.J_X14);
            d2.f(R.color.CAM_X0211);
            p75 d3 = p75.d(this.j);
            d3.o(R.string.J_X07);
            d3.f(R.color.CAM_X0209);
            SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0105);
            TextView textView = this.i;
            if (textView != null) {
                textView.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0302, TbadkCoreApplication.getInst().getSkinType()));
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0105);
            EditText editText = this.k;
            if (editText != null) {
                editText.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            }
        }
    }

    public final void t(Editable editable) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, editable) == null) {
            int i = 0;
            if (editable != null && editable.toString().trim().length() > 0) {
                z = true;
            } else {
                z = false;
            }
            this.i.setEnabled(z);
            ImageView imageView = this.l;
            if (!z) {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    public void u(@NonNull Activity activity, @Nullable String str, @NonNull String str2, @Nullable lla llaVar) {
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, activity, str, str2, llaVar) == null) {
            this.a = activity;
            this.n = str2;
            this.o = str;
            this.q = llaVar;
            if (this.p == null) {
                p();
            }
            if (this.c == null) {
                q();
            }
            this.c.setOnDismissListener(new b(this));
            if (this.c.getWindow() != null && this.m > 0) {
                this.c.getWindow().setWindowAnimations(this.m);
            }
            this.c.show();
            if (this.c.getWindow() != null) {
                this.c.getWindow().setWindowAnimations(-1);
                this.e = (ViewGroup) this.c.getWindow().getDecorView();
                StatusbarColorUtils.setStatusBarDarkIcon(this.c.getWindow(), true);
            }
            EditText editText = this.k;
            if (editText != null) {
                editText.setText(str);
                EditText editText2 = this.k;
                if (editText2.getText() == null) {
                    length = 0;
                } else {
                    length = this.k.getText().length();
                }
                editText2.setSelection(length);
                t(this.k.getText());
                this.k.requestFocus();
                xg.a().postDelayed(this.r, 150L);
            }
        }
    }
}
