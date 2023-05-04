package com.baidu.tieba.memberCenter.tail.management;

import android.os.Bundle;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.to8;
import com.baidu.tieba.wo8;
import com.baidu.tieba.xo8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class TailManagementActivity extends BaseActivity<TailManagementActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public to8 a;
    public wo8 b;
    public xo8 c;
    public to8.f d;
    public View.OnClickListener e;

    /* loaded from: classes5.dex */
    public class a implements to8.f {
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

        @Override // com.baidu.tieba.to8.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean g = this.a.b.g();
                boolean z = true;
                if (this.a.b.h().size() == 0 && g) {
                    g = !this.a.b.g();
                    this.a.b.l(g);
                }
                TailManagementActivity tailManagementActivity = this.a;
                xo8 xo8Var = tailManagementActivity.c;
                if (tailManagementActivity.b.h().size() != 0) {
                    z = false;
                }
                xo8Var.e(g, z);
            }
        }
    }

    /* loaded from: classes5.dex */
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
                    xo8 xo8Var = tailManagementActivity.c;
                    if (tailManagementActivity.b.h().size() != 0) {
                        z = false;
                    }
                    xo8Var.e(z2, z);
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
            setContentView(R.layout.obfuscated_res_0x7f0d08d8);
            this.b = new wo8(getPageContext());
            this.a = new to8(getPageContext(), this.b, this.d);
            xo8 xo8Var = new xo8(this, this.e);
            this.c = xo8Var;
            xo8Var.d(this.a);
            xo8 xo8Var2 = this.c;
            if (this.b.h().size() == 0) {
                z = true;
            } else {
                z = false;
            }
            xo8Var2.e(false, z);
            if (this.b.i(getIntent().getSerializableExtra("list"))) {
                this.a.j();
            }
        }
    }
}
