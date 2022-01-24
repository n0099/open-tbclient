package com.baidu.tieba.memberCenter.memberpay;

import android.os.Bundle;
import c.a.t0.g2.f.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.MemberPayResultActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class MemberPayResultActivity extends BaseActivity<MemberPayResultActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g memberPayResultView;
    public String payContent;

    public MemberPayResultActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            g gVar = new g(getPageContext());
            this.memberPayResultView = gVar;
            gVar.b(this.payContent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            g gVar = this.memberPayResultView;
            if (gVar != null) {
                gVar.d(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle != null) {
                this.payContent = bundle.getString(MemberPayResultActivityConfig.PAY_CONTENT, "");
            } else if (getIntent() != null) {
                String stringExtra = getIntent().getStringExtra(MemberPayResultActivityConfig.PAY_CONTENT);
                this.payContent = stringExtra;
                if (stringExtra == null) {
                    this.payContent = "";
                }
            }
            initUI();
        }
    }
}
