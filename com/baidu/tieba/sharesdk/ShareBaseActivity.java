package com.baidu.tieba.sharesdk;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class ShareBaseActivity extends BaseActivity<ShareBaseActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ShareBaseActivity() {
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

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            if (getIntent() == null) {
                finish();
            }
        }
    }

    public void v1(int i, int i2, Bundle bundle, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), bundle, str}) == null) {
            Intent intent = new Intent();
            intent.putExtra("extra_show_channel", i);
            intent.putExtra("extra_share_status", i2);
            intent.putExtra("share_to", String.valueOf(i));
            if (bundle != null) {
                intent.putExtra("tid", bundle.getString("tid"));
                intent.putExtra("pid", bundle.getString("pid"));
                intent.putExtra("source", bundle.getInt("source"));
            } else {
                intent.putExtra("tid", (String) null);
                intent.putExtra("pid", (String) null);
                intent.putExtra("source", 0);
            }
            intent.putExtra("complete_id", str);
            setResult(-1, intent);
            finish();
        }
    }
}
