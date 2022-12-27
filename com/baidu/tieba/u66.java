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
/* loaded from: classes6.dex */
public class u66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity a;
    public lv4 b;
    public lv4 c;
    public lv4 d;
    public int e;
    public View.OnClickListener f;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u66 a;

        /* renamed from: com.baidu.tieba.u66$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0447a extends ik5<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0447a(a aVar) {
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

            @Override // com.baidu.tieba.ik5
            public Object doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    d09.b();
                    return null;
                }
                return invokeV.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public class b implements mj5<Object> {
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

            @Override // com.baidu.tieba.mj5
            public void onReturnDataInUI(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeL(1048576, this, obj) != null) {
                    return;
                }
                this.a.a.j();
            }
        }

        public a(u66 u66Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u66Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u66Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int id = view2.getId();
                if (id != R.id.private_yes && id != R.id.obfuscated_res_0x7f092799) {
                    if (id == R.id.private_no) {
                        if (this.a.b.isShowing()) {
                            this.a.b.dismiss();
                            bp8.a("1", "2");
                        }
                        if (this.a.c == null) {
                            u66 u66Var = this.a;
                            u66Var.c = uq5.a(u66Var.a.getPageContext(), this.a.f, R.string.privacy_policy_guide_one, R.string.secret_hint_no_agree);
                        }
                        this.a.c.show();
                        bp8.b("2");
                        return;
                    } else if (id == R.id.obfuscated_res_0x7f090427) {
                        u66.g(this.a);
                        if (this.a.c.isShowing()) {
                            this.a.c.dismiss();
                            bp8.a("2", "2");
                            if (this.a.d == null) {
                                u66 u66Var2 = this.a;
                                TbPageContext<BaseFragmentActivity> pageContext = u66Var2.a.getPageContext();
                                View.OnClickListener onClickListener = this.a.f;
                                if (TbBrowseModeSwitch.isOn()) {
                                    i = R.string.secret_hint_browser;
                                } else {
                                    i = R.string.secret_hint_browser_exit;
                                }
                                u66Var2.d = uq5.a(pageContext, onClickListener, R.string.privacy_policy_guide_two, i);
                                this.a.d.show();
                                bp8.b("3");
                            }
                        }
                        if (this.a.d.isShowing() && this.a.e == 2) {
                            this.a.d.dismiss();
                            bp8.a("3", "2");
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
                mk5.b(new C0447a(this), new b(this));
            }
        }
    }

    public u66(@NonNull BaseFragmentActivity baseFragmentActivity) {
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

    public static /* synthetic */ int g(u66 u66Var) {
        int i = u66Var.e;
        u66Var.e = i + 1;
        return i;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            lv4 lv4Var = this.b;
            if (lv4Var != null && lv4Var.isShowing()) {
                this.b.dismiss();
                SmartLaunchStats.onConfirmPrivacy();
                bp8.a("1", "1");
                fx4.k("logoController", false);
            }
            lv4 lv4Var2 = this.c;
            if (lv4Var2 != null && lv4Var2.isShowing()) {
                this.c.dismiss();
                bp8.a("2", "1");
                fx4.k("logoController", false);
            }
            lv4 lv4Var3 = this.d;
            if (lv4Var3 != null && lv4Var3.isShowing()) {
                this.d.dismiss();
                bp8.a("3", "1");
                fx4.k("logoController", false);
            }
            ry4.l().y("key_first_enter_app_timestamp", System.currentTimeMillis());
            PermissionUtil.doAgreePrivacyInit();
            PermissionUtil.starMainTabActivity(this.a, 2);
            this.a.finish();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            lv4 b = uq5.b(this.a.getPageContext(), this.f);
            this.b = b;
            b.show();
            bp8.b("1");
            TbSingleton.setExceptInsertAdDiaShow(true);
            SmartLaunchStats.onPrivacyDialogShow();
        }
    }
}
