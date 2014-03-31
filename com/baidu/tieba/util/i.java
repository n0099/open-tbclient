package com.baidu.tieba.util;

import android.content.Intent;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class i {
    public static ArrayList<String> a(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.getStringArrayListExtra("name_show");
    }
}
