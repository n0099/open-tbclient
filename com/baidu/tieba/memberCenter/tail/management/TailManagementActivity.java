package com.baidu.tieba.memberCenter.tail.management;

import android.os.Bundle;
import android.view.View;
import c.a.p0.j2.h.c.a;
import c.a.p0.j2.h.c.d;
import c.a.p0.j2.h.c.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class TailManagementActivity extends BaseActivity<TailManagementActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.j2.h.c.a mAdapter;
    public d mModel;
    public View.OnClickListener mNavBtnClickListener;
    public a.f mRefreshCallbackListener;
    public e mView;

    /* loaded from: classes5.dex */
    public class a implements a.f {
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

        @Override // c.a.p0.j2.h.c.a.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean g2 = this.a.mModel.g();
                if (this.a.mModel.h().size() == 0 && g2) {
                    g2 = !this.a.mModel.g();
                    this.a.mModel.l(g2);
                }
                TailManagementActivity tailManagementActivity = this.a;
                tailManagementActivity.mView.e(g2, tailManagementActivity.mModel.h().size() == 0);
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.a.mView.a()) {
                    this.a.finish();
                } else if (view == this.a.mView.b()) {
                    boolean z = !this.a.mModel.g();
                    this.a.mModel.l(z);
                    TailManagementActivity tailManagementActivity = this.a;
                    tailManagementActivity.mView.e(z, tailManagementActivity.mModel.h().size() == 0);
                    this.a.mAdapter.j();
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
        this.mRefreshCallbackListener = new a(this);
        this.mNavBtnClickListener = new b(this);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.onChangeSkinType(i);
            this.mView.c(i);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d080b);
            this.mModel = new d(getPageContext());
            this.mAdapter = new c.a.p0.j2.h.c.a(getPageContext(), this.mModel, this.mRefreshCallbackListener);
            e eVar = new e(this, this.mNavBtnClickListener);
            this.mView = eVar;
            eVar.d(this.mAdapter);
            this.mView.e(false, this.mModel.h().size() == 0);
            if (this.mModel.i(getIntent().getSerializableExtra("list"))) {
                this.mAdapter.j();
            }
        }
    }
}
