package com.baidu.tieba.togetherhi;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class ThHiDetailConfig extends IntentConfig {
    public static final String FROM = "FROM";
    public static final String HID = "HID";
    public static final String LIST = "LIST";
    public static final String POS = "POS";
    public static final String TH_FROM_CENTER_MESSAGE = "TH_FROM_CENTER_MESSAGE";
    public static final String TH_FROM_H5 = "FROM_H5";
    public static final String TH_FROM_MAIN = "FROM_MAIN";
    public static final String TH_FROM_USER = "FROM_USER";

    public ThHiDetailConfig(Context context) {
        super(context);
        setIntentAction(IntentAction.Activity);
    }

    public void createHiDetailConfig(long j, String str) {
        getIntent().putExtra(HID, j);
        getIntent().putExtra("FROM", str);
        getIntent().putExtra(POS, 0);
        setIntentAction(IntentAction.Activity);
    }
}
