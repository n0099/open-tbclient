package com.baidu.tieba.newinterest.activity;

import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.InterestGuideActivityConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.fg9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class InterestGuideActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fg9 a;
    public int b;
    public String[] c;
    public boolean d;

    public InterestGuideActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.onBackPressed();
            this.a.h();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            UtilHelper.setNavigationBarBg(getActivity(), SkinManager.getColor(R.color.CAM_X0201));
            this.a.i();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            s1();
            fg9 fg9Var = new fg9(this, this.b, this.c, this.d);
            this.a = fg9Var;
            setContentView(fg9Var.d());
            t1();
        }
    }

    public final void s1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && getIntent() != null) {
            this.b = getIntent().getIntExtra(InterestGuideActivityConfig.KEY_INTEREST_GUID_SHOW_SCENE, 2);
            this.c = getIntent().getStringArrayExtra(InterestGuideActivityConfig.KEY_CUSTOM_TITLE);
            this.d = getIntent().getBooleanExtra(InterestGuideActivityConfig.KEY_INTEREST_BACK_TO_MAINTAB, true);
        }
    }

    public final void t1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TbSingleton.getInstance().setShowedInterestGuide(true);
            String str = "";
            String string = SharedPrefHelper.getInstance().getString("key_interest_guide_show", "");
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            if (!StringUtils.isNull(string)) {
                str = ",";
            }
            sb.append(str);
            String sb2 = sb.toString();
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            sharedPrefHelper.putString("key_interest_guide_show", sb2 + System.currentTimeMillis());
        }
    }
}
