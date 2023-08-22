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
import com.baidu.tbadk.core.elementsMaven.EMManager;
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
public class pf9 implements nf9, View.OnClickListener {
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

    @Override // com.baidu.tieba.nf9
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
        public final /* synthetic */ pf9 a;

        public a(pf9 pf9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pf9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pf9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webAuthResult) == null) {
                this.a.a.showToast(String.format(this.a.a.getString(R.string.obfuscated_res_0x7f0f139c), Integer.valueOf(webAuthResult.getResultCode()), webAuthResult.getResultMsg()));
                this.a.a.Q1();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, webAuthResult) == null) {
                this.a.a.R1();
                this.a.a.H1(DialogLoginHelper.DIALOG_TYPE_SHARE);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends WebAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SocialType a;
        public final /* synthetic */ pf9 b;

        public b(pf9 pf9Var, SocialType socialType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pf9Var, socialType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pf9Var;
            this.a = socialType;
        }

        @Override // com.baidu.sapi2.shell.listener.WebAuthListener
        public void beforeSuccess(SapiAccount sapiAccount) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sapiAccount) == null) {
                this.b.a.U1();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, webAuthResult) == null) {
                this.b.a.closeLoadingDialog();
                this.b.a.showToast(String.format(this.b.a.getString(R.string.obfuscated_res_0x7f0f163a), Integer.valueOf(webAuthResult.getResultCode()), webAuthResult.getResultMsg()));
                this.b.a.Q1();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, webAuthResult) == null) {
                this.b.a.R1();
                this.b.a.H1(this.a.name().toLowerCase());
            }
        }
    }

    public pf9(@NonNull String str) {
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

    @Override // com.baidu.tieba.nf9
    public void a(LoginDialogActivity loginDialogActivity, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, loginDialogActivity, viewGroup) == null) {
            this.a = loginDialogActivity;
            View inflate = LayoutInflater.from(loginDialogActivity).inflate(R.layout.obfuscated_res_0x7f0d08b2, viewGroup, true);
            this.b = inflate.findViewById(R.id.obfuscated_res_0x7f0908a2);
            this.c = inflate.findViewById(R.id.obfuscated_res_0x7f0908bc);
            this.d = inflate.findViewById(R.id.obfuscated_res_0x7f09073b);
            this.e = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09073c);
            this.f = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0908c9);
            this.g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0908c7);
            this.h = inflate.findViewById(R.id.obfuscated_res_0x7f092858);
            this.i = (TbImageView) inflate.findViewById(R.id.user_avatar);
            this.j = (TextView) inflate.findViewById(R.id.user_name);
            this.k = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092882);
            this.l = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091675);
            this.m = inflate.findViewById(R.id.obfuscated_res_0x7f091e00);
            this.n = inflate.findViewById(R.id.obfuscated_res_0x7f092a30);
            this.o = inflate.findViewById(R.id.obfuscated_res_0x7f092a33);
            this.p = inflate.findViewById(R.id.obfuscated_res_0x7f092ab5);
            this.q = inflate.findViewById(R.id.obfuscated_res_0x7f0917ac);
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
            this.a.P1();
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
        this.i.startLoad(storageModel.url, 10, false);
        this.j.setText(this.r.displayname);
        this.k.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f139b, this.r.app));
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view2) == null) {
            int id = view2.getId();
            if (id != R.id.obfuscated_res_0x7f0908a2 && id != R.id.obfuscated_res_0x7f09073b && id != R.id.obfuscated_res_0x7f09073c) {
                if (id == R.id.obfuscated_res_0x7f091675) {
                    e();
                    return;
                } else if (id == R.id.obfuscated_res_0x7f091e00) {
                    g();
                    return;
                } else if (id == R.id.obfuscated_res_0x7f092a30) {
                    i();
                    return;
                } else if (id == R.id.obfuscated_res_0x7f092a33) {
                    j();
                    return;
                } else if (id == R.id.obfuscated_res_0x7f092ab5) {
                    k();
                    return;
                } else if (id == R.id.obfuscated_res_0x7f0917ac) {
                    f();
                    return;
                } else {
                    return;
                }
            }
            c();
        }
    }

    @Override // com.baidu.tieba.nf9
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            EMManager.from(this.c).setCardType(1).setCorner(R.string.J_X14).setBackGroundColor(R.color.CAM_X0207);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.e, R.drawable.icon_pure_close12_n_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            EMManager.from(this.f).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X05).setTextStyle(R.string.F_X02);
            EMManager.from(this.g).setTextColor(R.color.CAM_X0108).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X01);
            EMManager.from(this.h).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0204);
            EMManager.from(this.j).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X05).setTextStyle(R.string.F_X02);
            EMManager.from(this.k).setTextColor(R.color.CAM_X0108).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X01);
            EMManager.from(this.l).setTextColor(R.color.CAM_X0101).setTextSize(R.dimen.T_X05).setTextStyle(R.string.F_X01).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0302);
        }
    }
}
