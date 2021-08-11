package com.baidu.webkit.sdk;

import android.graphics.Bitmap;
/* loaded from: classes9.dex */
public interface WebAppShortcutDataListener {
    void onWebAppIconAvailable(Bitmap bitmap);

    void onWebAppInfoAvailable(String str, String str2, String str3, String str4, int i2, int i3, int i4, long j2, long j3, boolean z);
}
