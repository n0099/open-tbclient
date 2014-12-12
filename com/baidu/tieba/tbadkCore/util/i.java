package com.baidu.tieba.tbadkCore.util;

import android.content.Intent;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i {
    public static ArrayList<String> T(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.getStringArrayListExtra(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW);
    }
}
