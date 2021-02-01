package com.baidu.tieba.sdk;

import android.os.Build;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.CommonWebViewActivityConfig;
import com.baidu.tieba.sdk.activity.CommonWebViewActivity;
import com.baidu.tieba.sdk.activity.CommonWebViewFullActivity;
/* loaded from: classes11.dex */
public class LiveSdkLibInitialize {
    static {
        if (Build.VERSION.SDK_INT == 26) {
            TbadkCoreApplication.getInst().RegisterIntent(CommonWebViewActivityConfig.class, CommonWebViewFullActivity.class);
        } else {
            TbadkCoreApplication.getInst().RegisterIntent(CommonWebViewActivityConfig.class, CommonWebViewActivity.class);
        }
    }
}
