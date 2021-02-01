package com.bytedance.embedapplog;

import android.content.Context;
import com.bun.miitmdid.core.JLibrary;
/* loaded from: classes6.dex */
final class bq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context) {
        if (JLibrary.context == null) {
            JLibrary.InitEntry(context);
        }
    }
}
