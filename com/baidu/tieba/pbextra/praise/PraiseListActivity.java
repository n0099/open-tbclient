package com.baidu.tieba.pbextra.praise;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.r0.d1.a0;
import c.a.s0.t2.c.a;
import c.a.s0.t2.c.d;
import c.a.s0.t2.c.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PraiseListActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes12.dex */
public class PraiseListActivity extends BaseActivity<PraiseListActivity> implements d.b, View.OnClickListener, AdapterView.OnItemClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String INTENT_KEY_PRAISE_TOTAL = "KeyIntentPraiseId";
    public transient /* synthetic */ FieldHolder $fh;
    public d mZanListModel;
    public e mZanListView;
    public int pageType;

    public PraiseListActivity() {
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
        this.pageType = 0;
        this.mZanListView = null;
        this.mZanListModel = null;
    }

    private void beforeFinishActivity() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (dVar = this.mZanListModel) == null) {
            return;
        }
        dVar.v();
    }

    public void changSkinType(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            getLayoutMode().j(view);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.mZanListView.c(getLayoutMode(), i2);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            if (view == this.mZanListView.e()) {
                beforeFinishActivity();
                if (this.mZanListModel.l()) {
                    finish();
                    return;
                }
                a0.a(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.mZanListModel.k(), null, "praise_list"));
            } else if (view != this.mZanListView.d() || this.mZanListView.f()) {
            } else {
                this.mZanListView.i(true);
                this.mZanListModel.m(this.pageType);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle != null) {
                this.pageType = bundle.getInt(IntentConfig.LIST_TYPE, 0);
                z = bundle.getBoolean(PraiseListActivityConfig.IS_AUTHOR);
                d dVar = new d(bundle.getString("thread_id"), bundle.getString("post_id"), bundle.getString(IntentConfig.POST_DESC), bundle.getBoolean(IntentConfig.IS_FROM_PB, true), this);
                this.mZanListModel = dVar;
                dVar.u(bundle.getInt(INTENT_KEY_PRAISE_TOTAL));
            } else if (getIntent() != null) {
                this.pageType = getIntent().getIntExtra(IntentConfig.LIST_TYPE, 0);
                z = getIntent().getBooleanExtra(PraiseListActivityConfig.IS_AUTHOR, false);
                this.mZanListModel = new d(getIntent().getStringExtra("thread_id"), getIntent().getStringExtra("post_id"), getIntent().getStringExtra(IntentConfig.POST_DESC), getIntent().getBooleanExtra(IntentConfig.IS_FROM_PB, true), this);
            } else {
                z = false;
            }
            if (this.mZanListModel == null) {
                this.mZanListModel = new d();
            }
            this.mZanListModel.t(z);
            e eVar = new e(this, this.mZanListModel.i());
            this.mZanListView = eVar;
            eVar.i(false);
            this.mZanListModel.m(this.pageType);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            beforeFinishActivity();
            super.onDestroy();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        a j3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (j3 = this.mZanListModel.j(i2)) == null) {
            return;
        }
        a0.a(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), j3.c(), j3.b(), null, AddFriendActivityConfig.TYPE_FAVOR_LIST));
    }

    @Override // c.a.s0.t2.c.d.b
    public void onLoadFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (l.isEmpty(str)) {
                str = getResources().getString(R.string.neterror);
            }
            this.mZanListView.j();
            this.mZanListView.h(str, this.pageType);
        }
    }

    @Override // c.a.s0.t2.c.d.b
    public void onLoadSuccessed(int i2, List<a> list, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), list, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            this.mZanListView.k(i2, list, i3, i4);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            this.mZanListView.g();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.mZanListModel.o(bundle, IntentConfig.IS_FROM_PB);
            this.mZanListModel.s(bundle, "thread_id");
            this.mZanListModel.q(bundle, "post_id");
            this.mZanListModel.p(bundle, IntentConfig.POST_DESC);
            this.mZanListModel.r(bundle, INTENT_KEY_PRAISE_TOTAL);
        }
    }
}
