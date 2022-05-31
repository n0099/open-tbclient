package com.baidu.tieba.pbextra.praise;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import androidx.core.view.InputDeviceCompat;
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
import com.repackage.ay7;
import com.repackage.cc5;
import com.repackage.ki;
import com.repackage.wx7;
import com.repackage.zx7;
import java.util.List;
/* loaded from: classes3.dex */
public class PraiseListActivity extends BaseActivity<PraiseListActivity> implements zx7.b, View.OnClickListener, AdapterView.OnItemClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String INTENT_KEY_PRAISE_TOTAL = "KeyIntentPraiseId";
    public transient /* synthetic */ FieldHolder $fh;
    public zx7 mZanListModel;
    public ay7 mZanListView;
    public int pageType;

    public PraiseListActivity() {
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
        this.pageType = 0;
        this.mZanListView = null;
        this.mZanListModel = null;
    }

    private void beforeFinishActivity() {
        zx7 zx7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (zx7Var = this.mZanListModel) == null) {
            return;
        }
        zx7Var.v();
    }

    public void changSkinType(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            getLayoutMode().j(view2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.mZanListView.b(getLayoutMode(), i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            if (view2 == this.mZanListView.g()) {
                beforeFinishActivity();
                if (this.mZanListModel.l()) {
                    finish();
                    return;
                }
                cc5.a(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.mZanListModel.k(), null, "praise_list"));
            } else if (view2 != this.mZanListView.e() || this.mZanListView.h()) {
            } else {
                this.mZanListView.k(true);
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
                zx7 zx7Var = new zx7(bundle.getString("thread_id"), bundle.getString("post_id"), bundle.getString(IntentConfig.POST_DESC), bundle.getBoolean(IntentConfig.IS_FROM_PB, true), this);
                this.mZanListModel = zx7Var;
                zx7Var.u(bundle.getInt(INTENT_KEY_PRAISE_TOTAL));
            } else if (getIntent() != null) {
                this.pageType = getIntent().getIntExtra(IntentConfig.LIST_TYPE, 0);
                z = getIntent().getBooleanExtra(PraiseListActivityConfig.IS_AUTHOR, false);
                this.mZanListModel = new zx7(getIntent().getStringExtra("thread_id"), getIntent().getStringExtra("post_id"), getIntent().getStringExtra(IntentConfig.POST_DESC), getIntent().getBooleanExtra(IntentConfig.IS_FROM_PB, true), this);
            } else {
                z = false;
            }
            if (this.mZanListModel == null) {
                this.mZanListModel = new zx7();
            }
            this.mZanListModel.t(z);
            ay7 ay7Var = new ay7(this, this.mZanListModel.i());
            this.mZanListView = ay7Var;
            ay7Var.k(false);
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
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        wx7 j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || (j2 = this.mZanListModel.j(i)) == null) {
            return;
        }
        cc5.a(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), j2.c(), j2.b(), null, AddFriendActivityConfig.TYPE_FAVOR_LIST));
    }

    @Override // com.repackage.zx7.b
    public void onLoadFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (ki.isEmpty(str)) {
                str = getResources().getString(R.string.obfuscated_res_0x7f0f0c33);
            }
            this.mZanListView.l();
            this.mZanListView.j(str, this.pageType);
        }
    }

    @Override // com.repackage.zx7.b
    public void onLoadSuccessed(int i, List<wx7> list, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), list, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            this.mZanListView.m(i, list, i2, i3);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            this.mZanListView.i();
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
