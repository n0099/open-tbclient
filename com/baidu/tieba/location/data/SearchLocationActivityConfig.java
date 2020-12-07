package com.baidu.tieba.location.data;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes23.dex */
public class SearchLocationActivityConfig extends IntentConfig {
    public SearchLocationActivityConfig(Context context, int i) {
        super(context);
        getIntent().putExtra("request_code", i);
    }
}
