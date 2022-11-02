package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.searchbox.launch.SmartLaunchStats;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class m56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity a;
    public iv4 b;
    public iv4 c;
    public iv4 d;
    public int e;
    public View.OnClickListener f;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m56 a;

        public a(m56 m56Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m56Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m56Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int id = view2.getId();
                if (id != R.id.obfuscated_res_0x7f091ad3 && id != R.id.obfuscated_res_0x7f092715) {
                    if (id == R.id.obfuscated_res_0x7f091ace) {
                        if (this.a.b.isShowing()) {
                            pl8.b("1");
                            this.a.b.dismiss();
                            pl8.a("1", "2");
                        }
                        if (this.a.c == null) {
                            m56 m56Var = this.a;
                            m56Var.c = mp5.a(m56Var.a.getPageContext(), this.a.f, R.string.obfuscated_res_0x7f0f0f4a, R.string.obfuscated_res_0x7f0f112b);
                        }
                        this.a.c.show();
                        pl8.b("2");
                        return;
                    } else if (id == R.id.obfuscated_res_0x7f090426) {
                        m56.h(this.a);
                        if (this.a.c.isShowing()) {
                            this.a.c.dismiss();
                            pl8.a("2", "2");
                            if (this.a.d == null) {
                                m56 m56Var2 = this.a;
                                m56Var2.d = mp5.a(m56Var2.a.getPageContext(), this.a.f, R.string.obfuscated_res_0x7f0f0f4b, R.string.obfuscated_res_0x7f0f1120);
                                this.a.d.show();
                                pl8.b("3");
                            }
                        }
                        if (this.a.d.isShowing() && this.a.e == 2) {
                            this.a.d.dismiss();
                            pl8.a("3", "2");
                            this.a.a.finish();
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
                if (this.a.b != null && this.a.b.isShowing()) {
                    pl8.b("1");
                    this.a.b.dismiss();
                    SmartLaunchStats.onConfirmPrivacy();
                    pl8.a("1", "1");
                    zw4.l("logoController", false);
                }
                if (this.a.c != null && this.a.c.isShowing()) {
                    this.a.c.dismiss();
                    pl8.a("2", "1");
                    zw4.l("logoController", false);
                }
                if (this.a.d != null && this.a.d.isShowing()) {
                    this.a.d.dismiss();
                    pl8.a("3", "1");
                    zw4.l("logoController", false);
                }
                ky4.k().x("key_first_enter_app_timestamp", System.currentTimeMillis());
                PermissionUtil.setIsAgreePrivacyPolicy(true);
                PermissionUtil.starMainTabActivity(this.a.a, 2);
                this.a.a.finish();
            }
        }
    }

    public m56(@NonNull BaseFragmentActivity baseFragmentActivity) {
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

    public static /* synthetic */ int h(m56 m56Var) {
        int i = m56Var.e;
        m56Var.e = i + 1;
        return i;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            iv4 b = mp5.b(this.a.getPageContext(), this.f);
            this.b = b;
            b.show();
            TbSingleton.setExceptInsertAdDiaShow(true);
            SmartLaunchStats.onPrivacyDialogShow();
        }
    }
}
