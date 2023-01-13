package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.SmartLaunchStats;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.switchs.TbBrowseModeSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ma6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity a;
    public wv4 b;
    public wv4 c;
    public wv4 d;
    public int e;
    public View.OnClickListener f;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ma6 a;

        /* renamed from: com.baidu.tieba.ma6$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0354a extends zk5<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0354a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.zk5
            public Object doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    z49.b();
                    return null;
                }
                return invokeV.objValue;
            }
        }

        /* loaded from: classes5.dex */
        public class b implements dk5<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.baidu.tieba.dk5
            public void onReturnDataInUI(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeL(1048576, this, obj) != null) {
                    return;
                }
                this.a.a.j();
            }
        }

        public a(ma6 ma6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ma6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ma6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int id = view2.getId();
                if (id != R.id.private_yes && id != R.id.obfuscated_res_0x7f0927c9) {
                    if (id == R.id.private_no) {
                        if (this.a.b.isShowing()) {
                            this.a.b.dismiss();
                            xt8.a("1", "2");
                        }
                        if (this.a.c == null) {
                            ma6 ma6Var = this.a;
                            ma6Var.c = or5.a(ma6Var.a.getPageContext(), this.a.f, R.string.privacy_policy_guide_one, R.string.secret_hint_no_agree);
                        }
                        this.a.c.show();
                        xt8.b("2");
                        return;
                    } else if (id == R.id.obfuscated_res_0x7f090422) {
                        ma6.g(this.a);
                        if (this.a.c.isShowing()) {
                            this.a.c.dismiss();
                            xt8.a("2", "2");
                            if (this.a.d == null) {
                                ma6 ma6Var2 = this.a;
                                TbPageContext<BaseFragmentActivity> pageContext = ma6Var2.a.getPageContext();
                                View.OnClickListener onClickListener = this.a.f;
                                if (TbBrowseModeSwitch.isOn()) {
                                    i = R.string.secret_hint_browser;
                                } else {
                                    i = R.string.secret_hint_browser_exit;
                                }
                                ma6Var2.d = or5.a(pageContext, onClickListener, R.string.privacy_policy_guide_two, i);
                                this.a.d.show();
                                xt8.b("3");
                            }
                        }
                        if (this.a.d.isShowing() && this.a.e == 2) {
                            this.a.d.dismiss();
                            xt8.a("3", "2");
                            if (TbBrowseModeSwitch.isOn()) {
                                PermissionUtil.doBrowseModeInit();
                                PermissionUtil.starMainTabActivity(this.a.a, 2);
                            }
                            this.a.a.finish();
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
                dl5.b(new C0354a(this), new b(this));
            }
        }
    }

    public ma6(@NonNull BaseFragmentActivity baseFragmentActivity) {
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

    public static /* synthetic */ int g(ma6 ma6Var) {
        int i = ma6Var.e;
        ma6Var.e = i + 1;
        return i;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            wv4 wv4Var = this.b;
            if (wv4Var != null && wv4Var.isShowing()) {
                this.b.dismiss();
                SmartLaunchStats.onConfirmPrivacy();
                xt8.a("1", "1");
                qx4.k("logoController", false);
            }
            wv4 wv4Var2 = this.c;
            if (wv4Var2 != null && wv4Var2.isShowing()) {
                this.c.dismiss();
                xt8.a("2", "1");
                qx4.k("logoController", false);
            }
            wv4 wv4Var3 = this.d;
            if (wv4Var3 != null && wv4Var3.isShowing()) {
                this.d.dismiss();
                xt8.a("3", "1");
                qx4.k("logoController", false);
            }
            cz4.l().y("key_first_enter_app_timestamp", System.currentTimeMillis());
            PermissionUtil.doAgreePrivacyInit();
            PermissionUtil.starMainTabActivity(this.a, 2);
            this.a.finish();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            wv4 b = or5.b(this.a.getPageContext(), this.f);
            this.b = b;
            b.show();
            xt8.b("1");
            TbSingleton.setExceptInsertAdDiaShow(true);
            SmartLaunchStats.onPrivacyDialogShow();
        }
    }
}
