package com.baidu.tieba.newinterest.activity;

import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.InterestGuideActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.av7;
import com.baidu.tieba.ky4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class InterestGuideActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public av7 a;
    public int b;
    public boolean c;
    public ArrayList<Integer> d;
    public String[] e;
    public boolean f;

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

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onBackPressed();
            this.a.h();
        }
    }

    public final void M0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && getIntent() != null) {
            this.b = getIntent().getIntExtra(InterestGuideActivityConfig.KEY_INTEREST_GUID_SHOW_SCENE, 2);
            this.c = getIntent().getBooleanExtra(InterestGuideActivityConfig.KEY_ONLY_SHOW_INTERESTED_FORUM, false);
            this.d = getIntent().getIntegerArrayListExtra(InterestGuideActivityConfig.KEY_CLASS_ID_WHEN_ONLY_SHOW_INTERESTED_FORUM);
            this.e = getIntent().getStringArrayExtra(InterestGuideActivityConfig.KEY_CUSTOM_TITLE);
            this.f = getIntent().getBooleanExtra(InterestGuideActivityConfig.KEY_INTEREST_BACK_TO_MAINTAB, true);
        }
    }

    public final void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TbSingleton.getInstance().setShowedInterestGuide(true);
            String str = "";
            String q = ky4.k().q("key_interest_guide_show", "");
            StringBuilder sb = new StringBuilder();
            sb.append(q);
            if (!StringUtils.isNull(q)) {
                str = ",";
            }
            sb.append(str);
            String sb2 = sb.toString();
            ky4 k = ky4.k();
            k.y("key_interest_guide_show", sb2 + System.currentTimeMillis());
            ky4.k().x("key_interest_panel_show_time", System.currentTimeMillis());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            UtilHelper.setNavigationBarBg(getActivity(), SkinManager.getColor(R.color.CAM_X0201));
            this.a.i();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            M0();
            av7 av7Var = new av7(this, this.b, this.c, this.d, this.e, this.f);
            this.a = av7Var;
            setContentView(av7Var.d());
            N0();
        }
    }
}
