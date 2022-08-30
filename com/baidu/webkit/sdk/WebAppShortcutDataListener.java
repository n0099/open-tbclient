package com.baidu.webkit.sdk;

import android.graphics.Bitmap;
/* loaded from: classes6.dex */
public interface WebAppShortcutDataListener {
    void onWebAppIconAvailable(Bitmap bitmap);

    void onWebAppInfoAvailable(String str, String str2, String str3, String str4, int i, int i2, int i3, long j, long j2, boolean z);
}
