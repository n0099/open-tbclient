package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.SmartLaunchStats;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class s16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity a;
    public vr4 b;
    public vr4 c;
    public vr4 d;
    public int e;
    public View.OnClickListener f;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s16 a;

        public a(s16 s16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s16Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int id = view2.getId();
                if (id == R.id.obfuscated_res_0x7f091a51 || id == R.id.obfuscated_res_0x7f092678) {
                    if (this.a.b != null && this.a.b.isShowing()) {
                        this.a.b.dismiss();
                        SmartLaunchStats.onConfirmPrivacy();
                        sh8.a("1", "1");
                        bt4.l("logoController", false);
                    }
                    if (this.a.c != null && this.a.c.isShowing()) {
                        this.a.c.dismiss();
                        sh8.a("2", "1");
                        bt4.l("logoController", false);
                    }
                    if (this.a.d != null && this.a.d.isShowing()) {
                        this.a.d.dismiss();
                        sh8.a("3", "1");
                        bt4.l("logoController", false);
                    }
                    su4.k().x("key_first_enter_app_timestamp", System.currentTimeMillis());
                    PermissionUtil.setIsAgreePrivacyPolicy(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921639, 2));
                } else if (id == R.id.obfuscated_res_0x7f091a4c) {
                    if (this.a.b.isShowing()) {
                        this.a.b.dismiss();
                        sh8.a("1", "2");
                    }
                    if (this.a.c == null) {
                        s16 s16Var = this.a;
                        s16Var.c = kl5.a(s16Var.a.getPageContext(), this.a.f, R.string.obfuscated_res_0x7f0f0f02, R.string.obfuscated_res_0x7f0f10e0);
                    }
                    this.a.c.show();
                    sh8.b("2");
                } else if (id == R.id.obfuscated_res_0x7f090404) {
                    s16.h(this.a);
                    if (this.a.c.isShowing()) {
                        this.a.c.dismiss();
                        sh8.a("2", "2");
                        if (this.a.d == null) {
                            s16 s16Var2 = this.a;
                            s16Var2.d = kl5.a(s16Var2.a.getPageContext(), this.a.f, R.string.obfuscated_res_0x7f0f0f03, R.string.obfuscated_res_0x7f0f10d5);
                            this.a.d.show();
                            sh8.b("3");
                        }
                    }
                    if (this.a.d.isShowing() && this.a.e == 2) {
                        this.a.d.dismiss();
                        sh8.a("3", "2");
                        this.a.a.finish();
                    }
                }
            }
        }
    }

    public s16(@NonNull BaseFragmentActivity baseFragmentActivity) {
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

    public static /* synthetic */ int h(s16 s16Var) {
        int i = s16Var.e;
        s16Var.e = i + 1;
        return i;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            vr4 vr4Var = this.b;
            if (vr4Var != null) {
                vr4Var.dismiss();
            }
            vr4 vr4Var2 = this.c;
            if (vr4Var2 != null) {
                vr4Var2.dismiss();
            }
            vr4 vr4Var3 = this.d;
            if (vr4Var3 != null) {
                vr4Var3.dismiss();
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            vr4 b = kl5.b(this.a.getPageContext(), this.f);
            this.b = b;
            b.show();
            TbSingleton.getInstance().setExceptInsertAdDiaShow(true);
            SmartLaunchStats.onPrivacyDialogShow();
            sh8.b("1");
        }
    }
}
