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
public class y56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity a;
    public jv4 b;
    public jv4 c;
    public jv4 d;
    public int e;
    public View.OnClickListener f;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y56 a;

        public a(y56 y56Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y56Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y56Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int id = view2.getId();
                if (id != R.id.obfuscated_res_0x7f091add && id != R.id.obfuscated_res_0x7f092725) {
                    if (id == R.id.obfuscated_res_0x7f091ad8) {
                        if (this.a.b.isShowing()) {
                            am8.b("1");
                            this.a.b.dismiss();
                            am8.a("1", "2");
                        }
                        if (this.a.c == null) {
                            y56 y56Var = this.a;
                            y56Var.c = yp5.a(y56Var.a.getPageContext(), this.a.f, R.string.obfuscated_res_0x7f0f0f4f, R.string.obfuscated_res_0x7f0f1131);
                        }
                        this.a.c.show();
                        am8.b("2");
                        return;
                    } else if (id == R.id.obfuscated_res_0x7f090426) {
                        y56.h(this.a);
                        if (this.a.c.isShowing()) {
                            this.a.c.dismiss();
                            am8.a("2", "2");
                            if (this.a.d == null) {
                                y56 y56Var2 = this.a;
                                y56Var2.d = yp5.a(y56Var2.a.getPageContext(), this.a.f, R.string.obfuscated_res_0x7f0f0f50, R.string.obfuscated_res_0x7f0f1126);
                                this.a.d.show();
                                am8.b("3");
                            }
                        }
                        if (this.a.d.isShowing() && this.a.e == 2) {
                            this.a.d.dismiss();
                            am8.a("3", "2");
                            this.a.a.finish();
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
                if (this.a.b != null && this.a.b.isShowing()) {
                    am8.b("1");
                    this.a.b.dismiss();
                    SmartLaunchStats.onConfirmPrivacy();
                    am8.a("1", "1");
                    ex4.l("logoController", false);
                }
                if (this.a.c != null && this.a.c.isShowing()) {
                    this.a.c.dismiss();
                    am8.a("2", "1");
                    ex4.l("logoController", false);
                }
                if (this.a.d != null && this.a.d.isShowing()) {
                    this.a.d.dismiss();
                    am8.a("3", "1");
                    ex4.l("logoController", false);
                }
                py4.k().x("key_first_enter_app_timestamp", System.currentTimeMillis());
                PermissionUtil.setIsAgreePrivacyPolicy(true);
                PermissionUtil.starMainTabActivity(this.a.a, 2);
                this.a.a.finish();
            }
        }
    }

    public y56(@NonNull BaseFragmentActivity baseFragmentActivity) {
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

    public static /* synthetic */ int h(y56 y56Var) {
        int i = y56Var.e;
        y56Var.e = i + 1;
        return i;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            jv4 b = yp5.b(this.a.getPageContext(), this.f);
            this.b = b;
            b.show();
            TbSingleton.setExceptInsertAdDiaShow(true);
            SmartLaunchStats.onPrivacyDialogShow();
        }
    }
}
