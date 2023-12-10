package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.security.MD5Util;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.passaccount.app.LoginDialogActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class pt9 implements ot9, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public String B;
    public String C;
    public LoginDialogActivity a;
    public View b;
    public View c;
    public View d;
    public ImageView e;
    public ImageView f;
    public LinearLayout g;
    public LinearLayout h;
    public Animation i;
    public Vibrator j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public View o;
    public View p;
    public View q;
    public View r;
    public View s;
    public TextView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public TextView y;
    public TextView z;

    @Override // com.baidu.tieba.ot9
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pt9 a;

        public a(pt9 pt9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pt9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pt9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                view2.setTag(Boolean.valueOf(!((Boolean) view2.getTag()).booleanValue()));
                if (((Boolean) view2.getTag()).booleanValue()) {
                    this.a.f.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_strok324_select, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                } else {
                    this.a.f.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_strok324, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends OneKeyLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pt9 a;

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onGuideProcess(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oneKeyLoginResult) == null) {
            }
        }

        public b(pt9 pt9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pt9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pt9Var;
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onSuccess(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, oneKeyLoginResult) == null) {
                this.a.a.M1();
                this.a.a.A1(DialogLoginHelper.DIALOG_TYPE_ONE_KEY);
                qf.a().i(Config.DEVICE_PART, "login success from one key");
            }
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onFail(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, oneKeyLoginResult) == null) {
                this.a.a.closeLoadingDialog();
                this.a.a.showToast(String.format(this.a.a.getString(R.string.obfuscated_res_0x7f0f0f31), Integer.valueOf(oneKeyLoginResult.getResultCode()), oneKeyLoginResult.getResultMsg()));
                this.a.a.K1();
                qf.a().e(Config.DEVICE_PART, "login fail from one key");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends WebAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SocialType a;
        public final /* synthetic */ pt9 b;

        public c(pt9 pt9Var, SocialType socialType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pt9Var, socialType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pt9Var;
            this.a = socialType;
        }

        @Override // com.baidu.sapi2.shell.listener.WebAuthListener
        public void beforeSuccess(SapiAccount sapiAccount) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sapiAccount) == null) {
                this.b.a.P1();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, webAuthResult) == null) {
                this.b.a.closeLoadingDialog();
                this.b.a.showToast(String.format(this.b.a.getString(R.string.obfuscated_res_0x7f0f168f), Integer.valueOf(webAuthResult.getResultCode()), webAuthResult.getResultMsg()));
                this.b.a.K1();
                TbLog a = qf.a();
                a.e(Config.DEVICE_PART, "login fail from third. ThirdType: " + this.a.name().toLowerCase());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, webAuthResult) == null) {
                this.b.a.M1();
                this.b.a.A1(this.a.name().toLowerCase());
                TbLog a = qf.a();
                a.i(Config.DEVICE_PART, "login success from third. ThirdType: " + this.a.name().toLowerCase());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
        if (r7.equals("CU") == false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public pt9(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        char c2 = 0;
        this.A = 0;
        this.B = str;
        this.C = str3;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        int hashCode = str2.hashCode();
        if (hashCode != 2154) {
            if (hashCode != 2161) {
                if (hashCode == 2162) {
                }
                c2 = 65535;
            } else {
                if (str2.equals("CT")) {
                    c2 = 1;
                }
                c2 = 65535;
            }
        } else {
            if (str2.equals("CM")) {
                c2 = 2;
            }
            c2 = 65535;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                this.A = 3;
                return;
            } else {
                this.A = 2;
                return;
            }
        }
        this.A = 1;
    }

    public final void p(SocialType socialType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, socialType) == null) {
            PassportSDK.getInstance().loadThirdPartyLogin(new c(this, socialType), socialType);
        }
    }

    public static String j(Activity activity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, activity, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.length() > 7) {
                String substring = str.substring(0, 8);
                String substring2 = str.substring(8, str.length());
                String upperCase = SapiUtils.getClientId(activity).toUpperCase();
                return substring + MD5Util.toMd5((substring2 + MD5Util.toMd5(upperCase.getBytes(), false)).getBytes(), false);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.ot9
    public void D(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            EMManager.from(this.c).setCardType(1).setCorner(R.string.J_X14).setBackGroundColor(R.color.CAM_X0207);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.e, R.drawable.icon_pure_close12_n_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            EMManager.from(this.k).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X05).setTextStyle(R.string.F_X02);
            EMManager.from(this.l).setTextColor(R.color.CAM_X0108).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X01);
            EMManager.from(this.m).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X03).setTextStyle(R.string.F_X02);
            EMManager.from(this.n).setTextColor(R.color.CAM_X0101).setTextSize(R.dimen.T_X05).setTextStyle(R.string.F_X01).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0302);
            EMManager.from(this.t).setTextColor(R.color.CAM_X0108).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X01);
            EMManager.from(this.v).setTextColor(R.color.CAM_X0108).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X01);
            EMManager.from(this.x).setTextColor(R.color.CAM_X0108).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X01);
            EMManager.from(this.z).setTextColor(R.color.CAM_X0108).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X01);
            EMManager.from(this.u).setTextColor(R.color.CAM_X0108).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X02);
            EMManager.from(this.w).setTextColor(R.color.CAM_X0108).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X02);
            EMManager.from(this.y).setTextColor(R.color.CAM_X0108).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X02);
        }
    }

    @Override // com.baidu.tieba.ot9
    public void a(LoginDialogActivity loginDialogActivity, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, loginDialogActivity, viewGroup) == null) {
            this.a = loginDialogActivity;
            View inflate = LayoutInflater.from(loginDialogActivity).inflate(R.layout.obfuscated_res_0x7f0d078b, viewGroup, true);
            this.b = inflate.findViewById(R.id.obfuscated_res_0x7f0908e9);
            this.c = inflate.findViewById(R.id.obfuscated_res_0x7f090903);
            this.g = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f09090f);
            this.d = inflate.findViewById(R.id.obfuscated_res_0x7f09077e);
            this.e = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09077f);
            this.k = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090910);
            this.l = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09090e);
            this.m = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092945);
            this.n = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091733);
            this.o = inflate.findViewById(R.id.obfuscated_res_0x7f091ed4);
            this.p = inflate.findViewById(R.id.obfuscated_res_0x7f092b11);
            this.q = inflate.findViewById(R.id.obfuscated_res_0x7f092b14);
            this.r = inflate.findViewById(R.id.obfuscated_res_0x7f092b8f);
            this.s = inflate.findViewById(R.id.obfuscated_res_0x7f091872);
            this.f = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090731);
            this.h = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f09072d);
            this.t = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09265c);
            this.u = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091af2);
            this.v = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09265d);
            this.w = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09018b);
            this.x = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09265e);
            this.y = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091e35);
            this.z = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09265f);
            this.b.setOnClickListener(this);
            this.d.setOnClickListener(this);
            this.e.setOnClickListener(this);
            this.c.setOnClickListener(this);
            this.n.setOnClickListener(this);
            this.o.setOnClickListener(this);
            this.p.setOnClickListener(this);
            this.q.setOnClickListener(this);
            this.r.setOnClickListener(this);
            this.s.setOnClickListener(this);
            this.u.setOnClickListener(this);
            this.w.setOnClickListener(this);
            this.y.setOnClickListener(this);
            this.j = (Vibrator) loginDialogActivity.getSystemService("vibrator");
            this.f.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_strok324, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
            this.h.setTag(Boolean.FALSE);
            this.h.setOnClickListener(new a(this));
            g();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LoginDialogActivity loginDialogActivity = this.a;
            BrowserHelper.startWebActivity((Context) loginDialogActivity, loginDialogActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0f28), "https://passport.baidu.com/static/passpc-account/html/protocal.html", false);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.J1();
            this.a.finish();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.m.setText(this.B);
            h(this.A);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.a.P1();
            PassportSDK passportSDK = PassportSDK.getInstance();
            LoginDialogActivity loginDialogActivity = this.a;
            passportSDK.loadOneKeyLogin(loginDialogActivity, j(loginDialogActivity, this.C), new b(this));
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            LoginDialogActivity loginDialogActivity = this.a;
            BrowserHelper.startWebActivity((Context) loginDialogActivity, loginDialogActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0f2c), "http://privacy.baidu.com/mdetail?id=288", false);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            p(SocialType.QQ_SSO);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            p(SocialType.WEIXIN);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            p(SocialType.SINA_WEIBO_SSO);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            p(SocialType.YY);
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!((Boolean) this.h.getTag()).booleanValue()) {
                this.j.vibrate(300L);
                Animation loadAnimation = AnimationUtils.loadAnimation(SelectorHelper.getContext(), R.anim.obfuscated_res_0x7f010113);
                this.i = loadAnimation;
                this.g.startAnimation(loadAnimation);
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.a.finish();
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.a, true);
            loginActivityConfig.setLoginListener(this.a.G1());
            loginActivityConfig.setJumpUrl(this.a.E1());
            loginActivityConfig.setFrom(this.a.getPreExtraPageKey());
            loginActivityConfig.setFromDialog("onkey_more");
            loginActivityConfig.start();
        }
    }

    public final void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        this.u.setText(R.string.obfuscated_res_0x7f0f0f2b);
                        return;
                    }
                    return;
                }
                this.u.setText(R.string.obfuscated_res_0x7f0f0f2a);
                return;
            }
            this.u.setText(R.string.obfuscated_res_0x7f0f0f29);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            int i = this.A;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        LoginDialogActivity loginDialogActivity = this.a;
                        BrowserHelper.startWebActivity((Context) loginDialogActivity, loginDialogActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0f2b), "https://wap.cmpassport.com/resources/html/contract.html", false);
                        return;
                    }
                    return;
                }
                LoginDialogActivity loginDialogActivity2 = this.a;
                BrowserHelper.startWebActivity((Context) loginDialogActivity2, loginDialogActivity2.getResources().getString(R.string.obfuscated_res_0x7f0f0f2a), "https://e.189.cn/sdk/agreement/detail.do?hidetop=true", false);
                return;
            }
            LoginDialogActivity loginDialogActivity3 = this.a;
            BrowserHelper.startWebActivity((Context) loginDialogActivity3, loginDialogActivity3.getResources().getString(R.string.obfuscated_res_0x7f0f0f29), "https://ms.zzx9.cn/html/oauth/protocol2.html", false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view2) == null) {
            int id = view2.getId();
            if (id != R.id.obfuscated_res_0x7f0908e9 && id != R.id.obfuscated_res_0x7f09077e && id != R.id.obfuscated_res_0x7f09077f) {
                if (id == R.id.obfuscated_res_0x7f091733) {
                    if (f()) {
                        i();
                        return;
                    }
                    return;
                } else if (id == R.id.obfuscated_res_0x7f091ed4) {
                    if (f()) {
                        o();
                        return;
                    }
                    return;
                } else if (id == R.id.obfuscated_res_0x7f092b11) {
                    if (f()) {
                        q();
                        return;
                    }
                    return;
                } else if (id == R.id.obfuscated_res_0x7f092b14) {
                    if (f()) {
                        r();
                        return;
                    }
                    return;
                } else if (id == R.id.obfuscated_res_0x7f092b8f) {
                    if (f()) {
                        s();
                        return;
                    }
                    return;
                } else if (id == R.id.obfuscated_res_0x7f091872) {
                    l();
                    return;
                } else if (id == R.id.obfuscated_res_0x7f091af2) {
                    k();
                    return;
                } else if (id == R.id.obfuscated_res_0x7f09018b) {
                    d();
                    return;
                } else if (id == R.id.obfuscated_res_0x7f091e35) {
                    n();
                    return;
                } else {
                    return;
                }
            }
            e();
        }
    }
}
