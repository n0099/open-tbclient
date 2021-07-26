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
import d.a.q0.v1.h.c.a;
import d.a.q0.v1.h.c.d;
import d.a.q0.v1.h.c.e;
/* loaded from: classes4.dex */
public class TailManagementActivity extends BaseActivity<TailManagementActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.q0.v1.h.c.a mAdapter;
    public d mModel;
    public View.OnClickListener mNavBtnClickListener;
    public a.f mRefreshCallbackListener;
    public e mView;

    /* loaded from: classes4.dex */
    public class a implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TailManagementActivity f18739a;

        public a(TailManagementActivity tailManagementActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tailManagementActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18739a = tailManagementActivity;
        }

        @Override // d.a.q0.v1.h.c.a.f
        public void callback() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean g2 = this.f18739a.mModel.g();
                if (this.f18739a.mModel.h().size() == 0 && g2) {
                    g2 = !this.f18739a.mModel.g();
                    this.f18739a.mModel.l(g2);
                }
                TailManagementActivity tailManagementActivity = this.f18739a;
                tailManagementActivity.mView.e(g2, tailManagementActivity.mModel.h().size() == 0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TailManagementActivity f18740e;

        public b(TailManagementActivity tailManagementActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tailManagementActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18740e = tailManagementActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f18740e.mView.a()) {
                    this.f18740e.finish();
                } else if (view == this.f18740e.mView.b()) {
                    boolean z = !this.f18740e.mModel.g();
                    this.f18740e.mModel.l(z);
                    TailManagementActivity tailManagementActivity = this.f18740e;
                    tailManagementActivity.mView.e(z, tailManagementActivity.mModel.h().size() == 0);
                    this.f18740e.mAdapter.j();
                }
            }
        }
    }

    public TailManagementActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRefreshCallbackListener = new a(this);
        this.mNavBtnClickListener = new b(this);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mView.c(i2);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.tail_management_activity);
            this.mModel = new d(getPageContext());
            this.mAdapter = new d.a.q0.v1.h.c.a(getPageContext(), this.mModel, this.mRefreshCallbackListener);
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
