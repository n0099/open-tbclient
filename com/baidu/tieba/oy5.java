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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.tbadk.widget.ProgressButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class oy5 extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public View b;
    public View c;
    public TbImageView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public ImageView l;
    public ProgressButton m;
    public final TiePlusHelper n;
    public final boolean o;
    public String p;
    public String q;
    public String r;
    public String s;
    public d t;

    /* loaded from: classes7.dex */
    public interface d {
        void a();
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oy5 a;

        public a(oy5 oy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oy5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oy5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                BdUtilHelper.showToast(this.a.r, 2000, true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oy5 a;

        public b(oy5 oy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oy5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oy5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.n.onClick(view2);
                if (this.a.t != null) {
                    this.a.t.a();
                }
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oy5 a;

        public c(oy5 oy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oy5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oy5Var;
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
    public oy5(@NonNull Context context, TiePlusHelper tiePlusHelper, boolean z) {
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
        this.n = tiePlusHelper;
        this.o = z;
    }

    public oy5 g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.r = str;
            return this;
        }
        return (oy5) invokeL.objValue;
    }

    public oy5 h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.s = str;
            return this;
        }
        return (oy5) invokeL.objValue;
    }

    public oy5 i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.p = str;
            return this;
        }
        return (oy5) invokeL.objValue;
    }

    public oy5 j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.q = str;
            return this;
        }
        return (oy5) invokeL.objValue;
    }

    public void k(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
            this.t = dVar;
        }
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int equipmentWidth = BdUtilHelper.getEquipmentWidth(getContext());
            if (equipmentWidth < 975.0d) {
                return 759;
            }
            return (equipmentWidth * 322) / 414;
        }
        return invokeV.intValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b = findViewById(R.id.obfuscated_res_0x7f090925);
            this.d = (TbImageView) findViewById(R.id.app_icon);
            this.e = (TextView) findViewById(R.id.app_title);
            this.f = (TextView) findViewById(R.id.app_version);
            this.g = (TextView) findViewById(R.id.app_company);
            this.h = (TextView) findViewById(R.id.app_permisson);
            this.i = (TextView) findViewById(R.id.app_privacy);
            this.j = (TextView) findViewById(R.id.app_function);
            this.c = findViewById(R.id.divider_function);
            this.k = (TextView) findViewById(R.id.download_cancel);
            this.m = (ProgressButton) findViewById(R.id.download_btn);
            this.l = (ImageView) findViewById(R.id.window_close);
            this.d.setPlaceHolder(2);
            this.d.setConrers(15);
            f();
            this.i.setTag((byte) 16);
            this.h.setTag((byte) 17);
            this.j.setTag((byte) 19);
            this.k.setTag((byte) 18);
            if (!StringUtils.isNull(this.p)) {
                this.e.setText(this.p);
            }
            if (!StringUtils.isNull(this.s)) {
                this.d.startLoad(this.s, 10, false);
            }
            if (!StringUtils.isNull(this.q)) {
                this.f.setText(String.format(getContext().getString(R.string.app_version_long), this.q));
            }
            if (!StringUtils.isNull(this.r)) {
                this.g.setText(String.format(getContext().getString(R.string.developer_name), this.r));
                this.g.setOnClickListener(new a(this));
            }
            this.h.setOnClickListener(this.n);
            this.i.setOnClickListener(this.n);
            this.j.setOnClickListener(this.n);
            this.k.setOnClickListener(this.n);
            this.m.setOnClickListener(new b(this));
            this.m.setUseLongText(true);
            this.l.setOnClickListener(new c(this));
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            EMManager.from(this.a).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0201);
            EMManager.from(this.e).setTextStyle(R.string.F_X02).setTextColor(R.color.CAM_X0105);
            EMManager.from(this.f).setTextColor(R.color.CAM_X0108);
            EMManager.from(this.g).setTextColor(R.color.CAM_X0108);
            EMManager.from(this.h).setTextColor(R.color.CAM_X0304);
            EMManager.from(this.i).setTextColor(R.color.CAM_X0304);
            EMManager.from(this.j).setTextColor(R.color.CAM_X0304);
            EMManager.from(this.k).setTextColor(R.color.CAM_X0107);
            EMManager.from(this.b).setBackGroundColor(R.color.CAM_X0107);
            EMManager.from(this.c).setBackGroundColor(R.color.CAM_X0107);
            WebPManager.setPureDrawable(this.l, R.drawable.icon_pure_dialog_close22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            this.m.i();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onAttachedToWindow();
            this.n.p(this.m);
            if (this.n.A() == null) {
                if (this.o) {
                    MessageManager.getInstance().registerListener(this.n);
                }
                if (!StringUtils.isNull(this.n.C()) && !StringUtils.isNull(this.n.y())) {
                    TiePlusHelper tiePlusHelper = this.n;
                    tiePlusHelper.q0(tiePlusHelper.C(), this.n.y(), getContext(), this.m);
                    TiePlusHelper tiePlusHelper2 = this.n;
                    tiePlusHelper2.n0(tiePlusHelper2.C(), getContext(), this.k);
                    return;
                }
                return;
            }
            TiePlusHelper tiePlusHelper3 = this.n;
            tiePlusHelper3.D(tiePlusHelper3.A()).g(this.n);
            this.n.p0(this.m, null);
            this.n.m0(this.k);
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
            attributes.width = d();
            getWindow().setAttributes(attributes);
            e();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDetachedFromWindow();
            this.n.O(this.m);
            if (this.o) {
                if (this.n.A() == null) {
                    MessageManager.getInstance().unRegisterListener(this.n);
                    return;
                }
                TiePlusHelper tiePlusHelper = this.n;
                tiePlusHelper.D(tiePlusHelper.A()).u(this.n);
            }
        }
    }
}
