package com.baidu.tieba.setting;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class SapiWebViewActivityConfig extends IntentConfig {
    public static final String EXTRA_BDUSS = "EXTRA_BDUSS";
    public static final String EXTRA_NAV = "EXTRA_NAV";
    public static final String EXTRA_TYPE = "EXTRA__TYPE";
    public static final int TYPE_BIND_EMAIL = 2;
    public static final int TYPE_BIND_MOBILE = 1;
    public static final int TYPE_REBIND_EMAIL = 4;
    public static final int TYPE_REBIND_MOBILE = 3;
    public static final int TYPE_UNBIND_EMAIL = 6;
    public static final int TYPE_UNBIND_MOBILE = 5;
    public static final int TYPE_UPDATE_PWD = 0;

    public SapiWebViewActivityConfig(Context context, int i, String str, boolean z) {
        super(context);
        getIntent().putExtra(EXTRA_TYPE, i);
        getIntent().putExtra(EXTRA_BDUSS, str);
        getIntent().putExtra(EXTRA_NAV, z);
    }

    public SapiWebViewActivityConfig(Context context, int i, int i2, String str, boolean z) {
        super(context);
        getIntent().putExtra(EXTRA_TYPE, i2);
        getIntent().putExtra(EXTRA_BDUSS, str);
        getIntent().putExtra(EXTRA_NAV, z);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i);
    }
}
