package com.baidu.tieba.memberCenter.tail.management;

import android.os.Bundle;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.am7;
import com.repackage.dm7;
import com.repackage.em7;
/* loaded from: classes3.dex */
public class TailManagementActivity extends BaseActivity<TailManagementActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public am7 a;
    public dm7 b;
    public em7 c;
    public am7.f d;
    public View.OnClickListener e;

    /* loaded from: classes3.dex */
    public class a implements am7.f {
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

        @Override // com.repackage.am7.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean g = this.a.b.g();
                if (this.a.b.h().size() == 0 && g) {
                    g = !this.a.b.g();
                    this.a.b.l(g);
                }
                TailManagementActivity tailManagementActivity = this.a;
                tailManagementActivity.c.e(g, tailManagementActivity.b.h().size() == 0);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                    boolean z = !this.a.b.g();
                    this.a.b.l(z);
                    TailManagementActivity tailManagementActivity = this.a;
                    tailManagementActivity.c.e(z, tailManagementActivity.b.h().size() == 0);
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d083f);
            this.b = new dm7(getPageContext());
            this.a = new am7(getPageContext(), this.b, this.d);
            em7 em7Var = new em7(this, this.e);
            this.c = em7Var;
            em7Var.d(this.a);
            this.c.e(false, this.b.h().size() == 0);
            if (this.b.i(getIntent().getSerializableExtra("list"))) {
                this.a.j();
            }
        }
    }
}
