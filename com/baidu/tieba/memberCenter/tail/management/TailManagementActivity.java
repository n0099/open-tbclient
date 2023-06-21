package com.baidu.tieba.memberCenter.tail.management;

import android.os.Bundle;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.jx8;
import com.baidu.tieba.mx8;
import com.baidu.tieba.nx8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class TailManagementActivity extends BaseActivity<TailManagementActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jx8 a;
    public mx8 b;
    public nx8 c;
    public jx8.f d;
    public View.OnClickListener e;

    /* loaded from: classes6.dex */
    public class a implements jx8.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TailManagementActivity a;

        public a(TailManagementActivity tailManagementActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tailManagementActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tailManagementActivity;
        }

        @Override // com.baidu.tieba.jx8.f
        public void callback() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean g = this.a.b.g();
                boolean z = true;
                if (this.a.b.h().size() == 0 && g) {
                    g = !this.a.b.g();
                    this.a.b.l(g);
                }
                TailManagementActivity tailManagementActivity = this.a;
                nx8 nx8Var = tailManagementActivity.c;
                if (tailManagementActivity.b.h().size() != 0) {
                    z = false;
                }
                nx8Var.e(g, z);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TailManagementActivity a;

        public b(TailManagementActivity tailManagementActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tailManagementActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tailManagementActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2 == this.a.c.a()) {
                    this.a.finish();
                } else if (view2 == this.a.c.b()) {
                    boolean z = true;
                    boolean z2 = !this.a.b.g();
                    this.a.b.l(z2);
                    TailManagementActivity tailManagementActivity = this.a;
                    nx8 nx8Var = tailManagementActivity.c;
                    if (tailManagementActivity.b.h().size() != 0) {
                        z = false;
                    }
                    nx8Var.e(z2, z);
                    this.a.a.j();
                }
            }
        }
    }

    public TailManagementActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new a(this);
        this.e = new b(this);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.onChangeSkinType(i);
            this.c.c(i);
            this.a.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0923);
            this.b = new mx8(getPageContext());
            this.a = new jx8(getPageContext(), this.b, this.d);
            nx8 nx8Var = new nx8(this, this.e);
            this.c = nx8Var;
            nx8Var.d(this.a);
            nx8 nx8Var2 = this.c;
            if (this.b.h().size() == 0) {
                z = true;
            } else {
                z = false;
            }
            nx8Var2.e(false, z);
            if (this.b.i(getIntent().getSerializableExtra("list"))) {
                this.a.j();
            }
        }
    }
}
