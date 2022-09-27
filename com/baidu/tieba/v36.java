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
public class v36 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity a;
    public nu4 b;
    public nu4 c;
    public nu4 d;
    public int e;
    public View.OnClickListener f;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v36 a;

        public a(v36 v36Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v36Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v36Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int id = view2.getId();
                if (id == R.id.obfuscated_res_0x7f091a92 || id == R.id.obfuscated_res_0x7f0926d8) {
                    if (this.a.b != null && this.a.b.isShowing()) {
                        vj8.b("1");
                        this.a.b.dismiss();
                        SmartLaunchStats.onConfirmPrivacy();
                        vj8.a("1", "1");
                        wv4.l("logoController", false);
                    }
                    if (this.a.c != null && this.a.c.isShowing()) {
                        this.a.c.dismiss();
                        vj8.a("2", "1");
                        wv4.l("logoController", false);
                    }
                    if (this.a.d != null && this.a.d.isShowing()) {
                        this.a.d.dismiss();
                        vj8.a("3", "1");
                        wv4.l("logoController", false);
                    }
                    ox4.k().x("key_first_enter_app_timestamp", System.currentTimeMillis());
                    PermissionUtil.setIsAgreePrivacyPolicy(true);
                    PermissionUtil.starMainTabActivity(this.a.a, 2);
                    this.a.a.finish();
                } else if (id == R.id.obfuscated_res_0x7f091a8d) {
                    if (this.a.b.isShowing()) {
                        vj8.b("1");
                        this.a.b.dismiss();
                        vj8.a("1", "2");
                    }
                    if (this.a.c == null) {
                        v36 v36Var = this.a;
                        v36Var.c = go5.a(v36Var.a.getPageContext(), this.a.f, R.string.obfuscated_res_0x7f0f0f1f, R.string.obfuscated_res_0x7f0f10fd);
                    }
                    this.a.c.show();
                    vj8.b("2");
                } else if (id == R.id.obfuscated_res_0x7f090410) {
                    v36.h(this.a);
                    if (this.a.c.isShowing()) {
                        this.a.c.dismiss();
                        vj8.a("2", "2");
                        if (this.a.d == null) {
                            v36 v36Var2 = this.a;
                            v36Var2.d = go5.a(v36Var2.a.getPageContext(), this.a.f, R.string.obfuscated_res_0x7f0f0f20, R.string.obfuscated_res_0x7f0f10f2);
                            this.a.d.show();
                            vj8.b("3");
                        }
                    }
                    if (this.a.d.isShowing() && this.a.e == 2) {
                        this.a.d.dismiss();
                        vj8.a("3", "2");
                        this.a.a.finish();
                    }
                }
            }
        }
    }

    public v36(@NonNull BaseFragmentActivity baseFragmentActivity) {
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

    public static /* synthetic */ int h(v36 v36Var) {
        int i = v36Var.e;
        v36Var.e = i + 1;
        return i;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            nu4 b = go5.b(this.a.getPageContext(), this.f);
            this.b = b;
            b.show();
            TbSingleton.setExceptInsertAdDiaShow(true);
            SmartLaunchStats.onPrivacyDialogShow();
        }
    }
}
