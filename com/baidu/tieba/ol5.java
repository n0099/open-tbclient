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
/* loaded from: classes5.dex */
public class ol5 extends Dialog {
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

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ol5 a;

        public a(ol5 ol5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ol5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ol5Var;
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

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ol5 a;

        public b(ol5 ol5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ol5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ol5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ol5(@NonNull Context context, TiePlusHelper tiePlusHelper, boolean z) {
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

    public final int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int k = ej.k(getContext());
            if (k < 975.0d) {
                return 759;
            }
            return (k * 322) / 414;
        }
        return invokeV.intValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b = findViewById(R.id.obfuscated_res_0x7f0907f9);
            this.c = (TbImageView) findViewById(R.id.obfuscated_res_0x7f09029c);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f0902a7);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f0902a8);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f090297);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f0902a2);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f0902a3);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f090832);
            this.k = (ProgressButton) findViewById(R.id.obfuscated_res_0x7f09082f);
            this.j = (ImageView) findViewById(R.id.obfuscated_res_0x7f09269d);
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
                this.c.K(this.q, 10, false);
            }
            if (!StringUtils.isNull(this.o)) {
                this.e.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f02a2), this.o));
            }
            if (!StringUtils.isNull(this.p)) {
                this.f.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f04ed), this.p));
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
            hv4 d = hv4.d(this.a);
            d.n(R.string.J_X06);
            d.f(R.color.CAM_X0201);
            hv4 d2 = hv4.d(this.d);
            d2.A(R.string.F_X02);
            d2.v(R.color.CAM_X0105);
            hv4.d(this.e).v(R.color.CAM_X0108);
            hv4.d(this.f).v(R.color.CAM_X0108);
            hv4.d(this.g).v(R.color.CAM_X0304);
            hv4.d(this.h).v(R.color.CAM_X0304);
            hv4.d(this.i).v(R.color.CAM_X0107);
            hv4.d(this.b).f(R.color.CAM_X0107);
            WebPManager.setPureDrawable(this.j, R.drawable.obfuscated_res_0x7f080944, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            this.k.i();
        }
    }

    public ol5 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.p = str;
            return this;
        }
        return (ol5) invokeL.objValue;
    }

    public ol5 g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.q = str;
            return this;
        }
        return (ol5) invokeL.objValue;
    }

    public ol5 h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.n = str;
            return this;
        }
        return (ol5) invokeL.objValue;
    }

    public ol5 i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.o = str;
            return this;
        }
        return (ol5) invokeL.objValue;
    }

    public void j(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            this.r = cVar;
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
            if (StringUtils.isNull(this.l.s()) || StringUtils.isNull(this.l.p())) {
                return;
            }
            TiePlusHelper tiePlusHelper = this.l;
            tiePlusHelper.Y(tiePlusHelper.s(), this.l.p(), getContext(), this.k);
            TiePlusHelper tiePlusHelper2 = this.l;
            tiePlusHelper2.X(tiePlusHelper2.s(), getContext(), this.i);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            getWindow().setBackgroundDrawableResource(R.color.transparent);
            View inflate = getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d088c, (ViewGroup) null);
            this.a = inflate;
            setContentView(inflate);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = c();
            getWindow().setAttributes(attributes);
            d();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDetachedFromWindow();
            this.l.A(this.k);
            if (this.m) {
                MessageManager.getInstance().unRegisterListener(this.l);
            }
        }
    }
}
