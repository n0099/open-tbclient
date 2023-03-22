package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.passaccount.app.LoginDialogActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
/* loaded from: classes7.dex */
public class yg8 implements wg8, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LoginDialogActivity a;
    public View b;
    public View c;
    public View d;
    public ImageView e;
    public TextView f;
    public TextView g;
    public View h;
    public TbImageView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public View m;
    public View n;
    public View o;
    public View p;
    public View q;
    public final ShareStorage.StorageModel r;

    @Override // com.baidu.tieba.wg8
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a extends WebAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yg8 a;

        public a(yg8 yg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yg8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yg8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webAuthResult) == null) {
                this.a.a.showToast(String.format(this.a.a.getString(R.string.obfuscated_res_0x7f0f1226), Integer.valueOf(webAuthResult.getResultCode()), webAuthResult.getResultMsg()));
                this.a.a.P1();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, webAuthResult) == null) {
                this.a.a.Q1();
                this.a.a.H1(DialogLoginHelper.DIALOG_TYPE_SHARE);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends WebAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SocialType a;
        public final /* synthetic */ yg8 b;

        public b(yg8 yg8Var, SocialType socialType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yg8Var, socialType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yg8Var;
            this.a = socialType;
        }

        @Override // com.baidu.sapi2.shell.listener.WebAuthListener
        public void beforeSuccess(SapiAccount sapiAccount) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sapiAccount) == null) {
                this.b.a.S1();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, webAuthResult) == null) {
                this.b.a.closeLoadingDialog();
                this.b.a.showToast(String.format(this.b.a.getString(R.string.obfuscated_res_0x7f0f14bb), Integer.valueOf(webAuthResult.getResultCode()), webAuthResult.getResultMsg()));
                this.b.a.P1();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, webAuthResult) == null) {
                this.b.a.Q1();
                this.b.a.H1(this.a.name().toLowerCase());
            }
        }
    }

    public yg8(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = (ShareStorage.StorageModel) new Gson().fromJson(str, (Class<Object>) ShareStorage.StorageModel.class);
    }

    public final void h(SocialType socialType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, socialType) == null) {
            PassportSDK.getInstance().loadThirdPartyLogin(new b(this, socialType), socialType);
        }
    }

    @Override // com.baidu.tieba.wg8
    public void a(LoginDialogActivity loginDialogActivity, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, loginDialogActivity, viewGroup) == null) {
            this.a = loginDialogActivity;
            View inflate = LayoutInflater.from(loginDialogActivity).inflate(R.layout.obfuscated_res_0x7f0d0828, viewGroup, true);
            this.b = inflate.findViewById(R.id.obfuscated_res_0x7f09085a);
            this.c = inflate.findViewById(R.id.obfuscated_res_0x7f090874);
            this.d = inflate.findViewById(R.id.obfuscated_res_0x7f0906f9);
            this.e = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0906fa);
            this.f = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090881);
            this.g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09087f);
            this.h = inflate.findViewById(R.id.obfuscated_res_0x7f0926ad);
            this.i = (TbImageView) inflate.findViewById(R.id.user_avatar);
            this.j = (TextView) inflate.findViewById(R.id.user_name);
            this.k = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0926d7);
            this.l = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0915ad);
            this.m = inflate.findViewById(R.id.obfuscated_res_0x7f091cc1);
            this.n = inflate.findViewById(R.id.obfuscated_res_0x7f092886);
            this.o = inflate.findViewById(R.id.obfuscated_res_0x7f092889);
            this.p = inflate.findViewById(R.id.obfuscated_res_0x7f092909);
            this.q = inflate.findViewById(R.id.obfuscated_res_0x7f0916dd);
            this.b.setOnClickListener(this);
            this.d.setOnClickListener(this);
            this.e.setOnClickListener(this);
            this.c.setOnClickListener(this);
            this.i.setIsRound(true);
            this.i.setDefaultBgResource(R.drawable.icon_default_avatar100_bg);
            this.l.setOnClickListener(this);
            this.m.setOnClickListener(this);
            this.n.setOnClickListener(this);
            this.o.setOnClickListener(this);
            this.p.setOnClickListener(this);
            this.q.setOnClickListener(this);
            d();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.O1();
            this.a.finish();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.r != null) {
            PassportSDK.getInstance().invokeV2ShareLogin(this.a, new a(this), this.r);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            h(SocialType.QQ_SSO);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            h(SocialType.WEIXIN);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            h(SocialType.SINA_WEIBO_SSO);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            h(SocialType.YY);
        }
    }

    public final void d() {
        ShareStorage.StorageModel storageModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (storageModel = this.r) == null) {
            return;
        }
        this.i.M(storageModel.url, 10, false);
        this.j.setText(this.r.displayname);
        this.k.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1225, this.r.app));
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.finish();
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.a, true);
            loginActivityConfig.setLoginListener(this.a.L1());
            loginActivityConfig.setFrom(this.a.getPreExtraPageKey());
            loginActivityConfig.setFromDialog("share_more");
            loginActivityConfig.start();
        }
    }

    @Override // com.baidu.tieba.wg8
    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            n15 d = n15.d(this.c);
            d.n(1);
            d.o(R.string.J_X14);
            d.f(R.color.CAM_X0207);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.e, R.drawable.icon_pure_close12_n_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            n15 d2 = n15.d(this.f);
            d2.w(R.color.CAM_X0105);
            d2.A(R.dimen.T_X05);
            d2.B(R.string.F_X02);
            n15 d3 = n15.d(this.g);
            d3.w(R.color.CAM_X0108);
            d3.A(R.dimen.T_X08);
            d3.B(R.string.F_X01);
            n15 d4 = n15.d(this.h);
            d4.o(R.string.J_X05);
            d4.f(R.color.CAM_X0204);
            n15 d5 = n15.d(this.j);
            d5.w(R.color.CAM_X0105);
            d5.A(R.dimen.T_X05);
            d5.B(R.string.F_X02);
            n15 d6 = n15.d(this.k);
            d6.w(R.color.CAM_X0108);
            d6.A(R.dimen.T_X08);
            d6.B(R.string.F_X01);
            n15 d7 = n15.d(this.l);
            d7.w(R.color.CAM_X0101);
            d7.A(R.dimen.T_X05);
            d7.B(R.string.F_X01);
            d7.o(R.string.J_X01);
            d7.f(R.color.CAM_X0302);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view2) == null) {
            int id = view2.getId();
            if (id != R.id.obfuscated_res_0x7f09085a && id != R.id.obfuscated_res_0x7f0906f9 && id != R.id.obfuscated_res_0x7f0906fa) {
                if (id == R.id.obfuscated_res_0x7f0915ad) {
                    e();
                    return;
                } else if (id == R.id.obfuscated_res_0x7f091cc1) {
                    g();
                    return;
                } else if (id == R.id.obfuscated_res_0x7f092886) {
                    i();
                    return;
                } else if (id == R.id.obfuscated_res_0x7f092889) {
                    j();
                    return;
                } else if (id == R.id.obfuscated_res_0x7f092909) {
                    k();
                    return;
                } else if (id == R.id.obfuscated_res_0x7f0916dd) {
                    f();
                    return;
                } else {
                    return;
                }
            }
            c();
        }
    }
}
