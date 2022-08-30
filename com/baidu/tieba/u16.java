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
/* loaded from: classes6.dex */
public class u16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity a;
    public wr4 b;
    public wr4 c;
    public wr4 d;
    public int e;
    public View.OnClickListener f;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u16 a;

        public a(u16 u16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u16Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int id = view2.getId();
                if (id == R.id.obfuscated_res_0x7f091a51 || id == R.id.obfuscated_res_0x7f092678) {
                    if (this.a.b != null && this.a.b.isShowing()) {
                        uh8.b("1");
                        this.a.b.dismiss();
                        SmartLaunchStats.onConfirmPrivacy();
                        uh8.a("1", "1");
                        ct4.l("logoController", false);
                    }
                    if (this.a.c != null && this.a.c.isShowing()) {
                        this.a.c.dismiss();
                        uh8.a("2", "1");
                        ct4.l("logoController", false);
                    }
                    if (this.a.d != null && this.a.d.isShowing()) {
                        this.a.d.dismiss();
                        uh8.a("3", "1");
                        ct4.l("logoController", false);
                    }
                    tu4.k().x("key_first_enter_app_timestamp", System.currentTimeMillis());
                    PermissionUtil.setIsAgreePrivacyPolicy(true);
                    PermissionUtil.starMainTabActivity(this.a.a, 2);
                    this.a.a.finish();
                } else if (id == R.id.obfuscated_res_0x7f091a4c) {
                    if (this.a.b.isShowing()) {
                        uh8.b("1");
                        this.a.b.dismiss();
                        uh8.a("1", "2");
                    }
                    if (this.a.c == null) {
                        u16 u16Var = this.a;
                        u16Var.c = ml5.a(u16Var.a.getPageContext(), this.a.f, R.string.obfuscated_res_0x7f0f0f02, R.string.obfuscated_res_0x7f0f10e0);
                    }
                    this.a.c.show();
                    uh8.b("2");
                } else if (id == R.id.obfuscated_res_0x7f090404) {
                    u16.h(this.a);
                    if (this.a.c.isShowing()) {
                        this.a.c.dismiss();
                        uh8.a("2", "2");
                        if (this.a.d == null) {
                            u16 u16Var2 = this.a;
                            u16Var2.d = ml5.a(u16Var2.a.getPageContext(), this.a.f, R.string.obfuscated_res_0x7f0f0f03, R.string.obfuscated_res_0x7f0f10d5);
                            this.a.d.show();
                            uh8.b("3");
                        }
                    }
                    if (this.a.d.isShowing() && this.a.e == 2) {
                        this.a.d.dismiss();
                        uh8.a("3", "2");
                        this.a.a.finish();
                    }
                }
            }
        }
    }

    public u16(@NonNull BaseFragmentActivity baseFragmentActivity) {
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

    public static /* synthetic */ int h(u16 u16Var) {
        int i = u16Var.e;
        u16Var.e = i + 1;
        return i;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            wr4 b = ml5.b(this.a.getPageContext(), this.f);
            this.b = b;
            b.show();
            TbSingleton.setExceptInsertAdDiaShow(true);
            SmartLaunchStats.onPrivacyDialogShow();
        }
    }
}
