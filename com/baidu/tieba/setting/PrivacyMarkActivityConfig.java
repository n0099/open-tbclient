package com.baidu.tieba.setting;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes5.dex */
public class PrivacyMarkActivityConfig extends IntentConfig {
    public static final String BAZHU_SHOW_INSIDE = "bazhu_show_inside";
    public static final String BAZHU_SHOW_OUTSIDE = "bazhu_show_outside";

    public PrivacyMarkActivityConfig(Context context) {
        super(context);
    }

    public void setMarkState(int i, int i2) {
        Intent intent = getIntent();
        intent.putExtra(BAZHU_SHOW_INSIDE, i);
        intent.putExtra(BAZHU_SHOW_OUTSIDE, i2);
    }
}
