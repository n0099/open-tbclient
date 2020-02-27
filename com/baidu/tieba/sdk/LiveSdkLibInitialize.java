package com.baidu.tieba.sdk;

import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.CommonWebViewActivityConfig;
import com.baidu.tieba.sdk.activity.CommonWebViewActivity;
/* loaded from: classes3.dex */
public class LiveSdkLibInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(CommonWebViewActivityConfig.class, CommonWebViewActivity.class);
    }
}
