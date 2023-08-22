package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.SmartLaunchStats;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.growthFunnel.GrowthFunnelHelper;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.switchs.TbBrowseModeSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class rs6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity a;
    public s45 b;
    public s45 c;
    public s45 d;
    public int e;
    public View.OnClickListener f;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rs6 a;

        public a(rs6 rs6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rs6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rs6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int id = view2.getId();
                if (id == R.id.private_yes || id == R.id.obfuscated_res_0x7f092aa2) {
                    this.a.j();
                } else if (id == R.id.private_no) {
                    if (this.a.b.isShowing()) {
                        this.a.b.dismiss();
                        laa.a("1", "2");
                    }
                    if (this.a.c == null) {
                        rs6 rs6Var = this.a;
                        rs6Var.c = f46.a(rs6Var.a.getPageContext(), this.a.f, R.string.privacy_policy_guide_one, R.string.secret_hint_no_agree);
                    }
                    this.a.c.show();
                    laa.b("2");
                } else if (id == R.id.obfuscated_res_0x7f090495) {
                    rs6.g(this.a);
                    if (this.a.c.isShowing()) {
                        this.a.c.dismiss();
                        laa.a("2", "2");
                        if (this.a.d == null) {
                            rs6 rs6Var2 = this.a;
                            TbPageContext<BaseFragmentActivity> pageContext = rs6Var2.a.getPageContext();
                            View.OnClickListener onClickListener = this.a.f;
                            if (TbBrowseModeSwitch.isOn()) {
                                i = R.string.secret_hint_browser;
                            } else {
                                i = R.string.secret_hint_browser_exit;
                            }
                            rs6Var2.d = f46.a(pageContext, onClickListener, R.string.privacy_policy_guide_two, i);
                            this.a.d.show();
                            laa.b("3");
                        }
                    }
                    if (this.a.d.isShowing() && this.a.e == 2) {
                        this.a.d.dismiss();
                        laa.a("3", "2");
                        if (TbBrowseModeSwitch.isOn()) {
                            PermissionUtil.doBrowseModeInit();
                            PermissionUtil.starMainTabActivity(this.a.a, 2);
                        }
                        this.a.a.finish();
                    }
                }
            }
        }
    }

    public rs6(@NonNull BaseFragmentActivity baseFragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = 0;
        this.f = new a(this);
        this.a = baseFragmentActivity;
    }

    public static /* synthetic */ int g(rs6 rs6Var) {
        int i = rs6Var.e;
        rs6Var.e = i + 1;
        return i;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            s45 s45Var = this.b;
            if (s45Var != null && s45Var.isShowing()) {
                this.b.dismiss();
                SmartLaunchStats.onConfirmPrivacy();
                laa.a("1", "1");
                GrowthFunnelHelper.logClientDau("logoController", false);
            }
            s45 s45Var2 = this.c;
            if (s45Var2 != null && s45Var2.isShowing()) {
                this.c.dismiss();
                laa.a("2", "1");
                GrowthFunnelHelper.logClientDau("logoController", false);
            }
            s45 s45Var3 = this.d;
            if (s45Var3 != null && s45Var3.isShowing()) {
                this.d.dismiss();
                laa.a("3", "1");
                GrowthFunnelHelper.logClientDau("logoController", false);
            }
            SharedPrefHelper.getInstance().putLong("key_first_enter_app_timestamp", System.currentTimeMillis());
            PermissionUtil.doAgreePrivacyInit();
            PermissionUtil.starMainTabActivity(this.a, 2);
            this.a.finish();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            s45 b = f46.b(this.a.getPageContext(), this.f);
            this.b = b;
            b.show();
            laa.b("1");
            TbSingleton.setExceptInsertAdDiaShow(true);
            SmartLaunchStats.onPrivacyDialogShow();
        }
    }
}
