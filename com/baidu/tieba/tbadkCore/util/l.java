package com.baidu.tieba.tbadkCore.util;

import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l {
    public static ArrayList<String> S(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.getStringArrayListExtra(IntentConfig.NAME_SHOW);
    }
}
