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
public class z56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity a;
    public kv4 b;
    public kv4 c;
    public kv4 d;
    public int e;
    public View.OnClickListener f;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z56 a;

        public a(z56 z56Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z56Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z56Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int id = view2.getId();
                if (id != R.id.obfuscated_res_0x7f091add && id != R.id.obfuscated_res_0x7f092725) {
                    if (id == R.id.obfuscated_res_0x7f091ad8) {
                        if (this.a.b.isShowing()) {
                            bm8.b("1");
                            this.a.b.dismiss();
                            bm8.a("1", "2");
                        }
                        if (this.a.c == null) {
                            z56 z56Var = this.a;
                            z56Var.c = zp5.a(z56Var.a.getPageContext(), this.a.f, R.string.obfuscated_res_0x7f0f0f4f, R.string.obfuscated_res_0x7f0f1131);
                        }
                        this.a.c.show();
                        bm8.b("2");
                        return;
                    } else if (id == R.id.obfuscated_res_0x7f090426) {
                        z56.h(this.a);
                        if (this.a.c.isShowing()) {
                            this.a.c.dismiss();
                            bm8.a("2", "2");
                            if (this.a.d == null) {
                                z56 z56Var2 = this.a;
                                z56Var2.d = zp5.a(z56Var2.a.getPageContext(), this.a.f, R.string.obfuscated_res_0x7f0f0f50, R.string.obfuscated_res_0x7f0f1126);
                                this.a.d.show();
                                bm8.b("3");
                            }
                        }
                        if (this.a.d.isShowing() && this.a.e == 2) {
                            this.a.d.dismiss();
                            bm8.a("3", "2");
                            this.a.a.finish();
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
                if (this.a.b != null && this.a.b.isShowing()) {
                    bm8.b("1");
                    this.a.b.dismiss();
                    SmartLaunchStats.onConfirmPrivacy();
                    bm8.a("1", "1");
                    fx4.l("logoController", false);
                }
                if (this.a.c != null && this.a.c.isShowing()) {
                    this.a.c.dismiss();
                    bm8.a("2", "1");
                    fx4.l("logoController", false);
                }
                if (this.a.d != null && this.a.d.isShowing()) {
                    this.a.d.dismiss();
                    bm8.a("3", "1");
                    fx4.l("logoController", false);
                }
                qy4.k().x("key_first_enter_app_timestamp", System.currentTimeMillis());
                PermissionUtil.setIsAgreePrivacyPolicy(true);
                PermissionUtil.starMainTabActivity(this.a.a, 2);
                this.a.a.finish();
            }
        }
    }

    public z56(@NonNull BaseFragmentActivity baseFragmentActivity) {
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

    public static /* synthetic */ int h(z56 z56Var) {
        int i = z56Var.e;
        z56Var.e = i + 1;
        return i;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            kv4 b = zp5.b(this.a.getPageContext(), this.f);
            this.b = b;
            b.show();
            TbSingleton.setExceptInsertAdDiaShow(true);
            SmartLaunchStats.onPrivacyDialogShow();
        }
    }
}
