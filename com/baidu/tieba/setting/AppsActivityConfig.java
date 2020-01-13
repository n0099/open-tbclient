package com.baidu.tieba.setting;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes11.dex */
public class AppsActivityConfig extends IntentConfig {
    public AppsActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra("url", str);
    }
}
