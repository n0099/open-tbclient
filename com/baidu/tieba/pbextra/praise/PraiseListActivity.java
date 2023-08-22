package com.baidu.tieba.pbextra.praise;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PraiseListActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.di;
import com.baidu.tieba.pw5;
import com.baidu.tieba.qq9;
import com.baidu.tieba.tq9;
import com.baidu.tieba.uq9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class PraiseListActivity extends BaseActivity<PraiseListActivity> implements tq9.b, View.OnClickListener, AdapterView.OnItemClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public uq9 b;
    public tq9 c;

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
        this.a = 0;
        this.b = null;
        this.c = null;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            s1();
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            this.b.A();
        }
    }

    public final void s1() {
        tq9 tq9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (tq9Var = this.c) != null) {
            tq9Var.v();
        }
    }

    @Override // com.baidu.tieba.tq9.b
    public void J0(int i, List<qq9> list, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), list, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            this.b.G(i, list, i2, i3);
        }
    }

    public void changSkinType(View view2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            BDLayoutMode layoutMode = getLayoutMode();
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            getLayoutMode().onModeChanged(view2);
        }
    }

    @Override // com.baidu.tieba.tq9.b
    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (di.isEmpty(str)) {
                str = getResources().getString(R.string.obfuscated_res_0x7f0f0e29);
            }
            this.b.F();
            this.b.D(str, this.a);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.b.u(getLayoutMode(), i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            if (view2 == this.b.y()) {
                s1();
                if (this.c.l()) {
                    finish();
                    return;
                }
                pw5.a(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.c.k(), null, "praise_list"));
            } else if (view2 == this.b.x() && !this.b.z()) {
                this.b.E(true);
                this.c.m(this.a);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle != null) {
                this.a = bundle.getInt(IntentConfig.LIST_TYPE, 0);
                z = bundle.getBoolean(PraiseListActivityConfig.IS_AUTHOR);
                tq9 tq9Var = new tq9(bundle.getString("thread_id"), bundle.getString("post_id"), bundle.getString(IntentConfig.POST_DESC), bundle.getBoolean(IntentConfig.IS_FROM_PB, true), this);
                this.c = tq9Var;
                tq9Var.u(bundle.getInt("KeyIntentPraiseId"));
            } else if (getIntent() != null) {
                this.a = getIntent().getIntExtra(IntentConfig.LIST_TYPE, 0);
                z = getIntent().getBooleanExtra(PraiseListActivityConfig.IS_AUTHOR, false);
                this.c = new tq9(getIntent().getStringExtra("thread_id"), getIntent().getStringExtra("post_id"), getIntent().getStringExtra(IntentConfig.POST_DESC), getIntent().getBooleanExtra(IntentConfig.IS_FROM_PB, true), this);
            } else {
                z = false;
            }
            if (this.c == null) {
                this.c = new tq9();
            }
            this.c.t(z);
            uq9 uq9Var = new uq9(this, this.c.i());
            this.b = uq9Var;
            uq9Var.E(false);
            this.c.m(this.a);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        qq9 j2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && (j2 = this.c.j(i)) != null) {
            pw5.a(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), j2.c(), j2.b(), null, AddFriendActivityConfig.TYPE_FAVOR_LIST));
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.c.o(bundle, IntentConfig.IS_FROM_PB);
            this.c.s(bundle, "thread_id");
            this.c.q(bundle, "post_id");
            this.c.p(bundle, IntentConfig.POST_DESC);
            this.c.r(bundle, "KeyIntentPraiseId");
        }
    }
}
