package com.baidu.tieba.newfaceshop;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.emotioncenter.CommonEmotionCenterFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.qi;
/* loaded from: classes3.dex */
public class CommonEmotionManagerActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout a;
    public CommonEmotionCenterFragment b;
    public String c;

    public CommonEmotionManagerActivity() {
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            setContentView(R.layout.obfuscated_res_0x7f0d01e3);
            this.a = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0906bd);
            if (isUseStyleImmersiveSticky()) {
                ((FrameLayout.LayoutParams) this.a.getLayoutParams()).topMargin = qi.s(getPageContext().getPageActivity());
            }
            String stringExtra = getIntent().getStringExtra("url");
            this.c = stringExtra;
            if (TextUtils.isEmpty(stringExtra)) {
                this.c = "https://tieba.baidu.com/n/interact/emoticoncenter";
            }
            this.b = new CommonEmotionCenterFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putString("key_load_url", this.c);
            this.b.setArguments(bundle2);
            getSupportFragmentManager().beginTransaction().replace(R.id.obfuscated_res_0x7f0906bd, this.b).commit();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            CommonEmotionCenterFragment commonEmotionCenterFragment = this.b;
            if (commonEmotionCenterFragment != null) {
                commonEmotionCenterFragment.onDestroy();
            }
            super.onDestroy();
        }
    }
}
