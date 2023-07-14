package com.baidu.tieba;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.tbadk.widget.ProgressButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class l36 extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public View b;
    public TbImageView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public ImageView j;
    public ProgressButton k;
    public final TiePlusHelper l;
    public final boolean m;
    public String n;
    public String o;
    public String p;
    public String q;
    public c r;

    /* loaded from: classes6.dex */
    public interface c {
        void a();
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l36 a;

        public a(l36 l36Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l36Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l36Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.l.onClick(view2);
                if (this.a.r != null) {
                    this.a.r.a();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l36 a;

        public b(l36 l36Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l36Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l36Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.dismiss();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l36(@NonNull Context context, TiePlusHelper tiePlusHelper, boolean z) {
        super(context, true, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, tiePlusHelper, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), (DialogInterface.OnCancelListener) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = tiePlusHelper;
        this.m = z;
    }

    public l36 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.p = str;
            return this;
        }
        return (l36) invokeL.objValue;
    }

    public l36 g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.q = str;
            return this;
        }
        return (l36) invokeL.objValue;
    }

    public l36 h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.n = str;
            return this;
        }
        return (l36) invokeL.objValue;
    }

    public l36 i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.o = str;
            return this;
        }
        return (l36) invokeL.objValue;
    }

    public void j(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            this.r = cVar;
        }
    }

    public final int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int l = yi.l(getContext());
            if (l < 975.0d) {
                return 759;
            }
            return (l * 322) / 414;
        }
        return invokeV.intValue;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDetachedFromWindow();
            this.l.C(this.k);
            if (this.m) {
                MessageManager.getInstance().unRegisterListener(this.l);
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b = findViewById(R.id.obfuscated_res_0x7f0908e6);
            this.c = (TbImageView) findViewById(R.id.app_icon);
            this.d = (TextView) findViewById(R.id.app_title);
            this.e = (TextView) findViewById(R.id.app_version);
            this.f = (TextView) findViewById(R.id.app_company);
            this.g = (TextView) findViewById(R.id.app_permisson);
            this.h = (TextView) findViewById(R.id.app_privacy);
            this.i = (TextView) findViewById(R.id.download_cancel);
            this.k = (ProgressButton) findViewById(R.id.download_btn);
            this.j = (ImageView) findViewById(R.id.window_close);
            this.c.setPlaceHolder(2);
            this.c.setConrers(15);
            e();
            this.h.setTag((byte) 16);
            this.g.setTag((byte) 17);
            this.i.setTag((byte) 18);
            if (!StringUtils.isNull(this.n)) {
                this.d.setText(this.n);
            }
            if (!StringUtils.isNull(this.q)) {
                this.c.N(this.q, 10, false);
            }
            if (!StringUtils.isNull(this.o)) {
                this.e.setText(String.format(getContext().getString(R.string.app_version_long), this.o));
            }
            if (!StringUtils.isNull(this.p)) {
                this.f.setText(String.format(getContext().getString(R.string.developer_name), this.p));
            }
            this.g.setOnClickListener(this.l);
            this.h.setOnClickListener(this.l);
            this.i.setOnClickListener(this.l);
            this.k.setOnClickListener(new a(this));
            this.k.setUseLongText(true);
            this.j.setOnClickListener(new b(this));
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d85 d = d85.d(this.a);
            d.o(R.string.J_X06);
            d.f(R.color.CAM_X0201);
            d85 d2 = d85.d(this.d);
            d2.D(R.string.F_X02);
            d2.x(R.color.CAM_X0105);
            d85.d(this.e).x(R.color.CAM_X0108);
            d85.d(this.f).x(R.color.CAM_X0108);
            d85.d(this.g).x(R.color.CAM_X0304);
            d85.d(this.h).x(R.color.CAM_X0304);
            d85.d(this.i).x(R.color.CAM_X0107);
            d85.d(this.b).f(R.color.CAM_X0107);
            WebPManager.setPureDrawable(this.j, R.drawable.icon_pure_dialog_close22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            this.k.i();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onAttachedToWindow();
            this.l.i(this.k);
            if (this.m) {
                MessageManager.getInstance().registerListener(this.l);
            }
            if (!StringUtils.isNull(this.l.s()) && !StringUtils.isNull(this.l.p())) {
                TiePlusHelper tiePlusHelper = this.l;
                tiePlusHelper.a0(tiePlusHelper.s(), this.l.p(), getContext(), this.k);
                TiePlusHelper tiePlusHelper2 = this.l;
                tiePlusHelper2.Z(tiePlusHelper2.s(), getContext(), this.i);
            }
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            getWindow().setBackgroundDrawableResource(R.color.transparent);
            View inflate = getLayoutInflater().inflate(R.layout.tie_plus_download_dialog, (ViewGroup) null);
            this.a = inflate;
            setContentView(inflate);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = c();
            getWindow().setAttributes(attributes);
            d();
        }
    }
}
