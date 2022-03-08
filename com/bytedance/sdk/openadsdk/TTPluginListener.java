package com.bytedance.sdk.openadsdk;

import android.content.res.Resources;
import android.os.Bundle;
/* loaded from: classes7.dex */
public interface TTPluginListener {
    Bundle config();

    void onPluginListener(int i2, ClassLoader classLoader, Resources resources, Bundle bundle);

    String packageName();
}
