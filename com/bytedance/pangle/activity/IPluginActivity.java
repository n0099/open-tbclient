package com.bytedance.pangle.activity;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.bytedance.pangle.plugin.Plugin;
@Keep
/* loaded from: classes3.dex */
public interface IPluginActivity {
    void _requestPermissions(String[] strArr, int i2);

    void attachBaseContext(Context context);

    String getPluginPkgName();

    void onCreate(Bundle bundle);

    void setPluginProxyActivity(b bVar, Plugin plugin2);

    void setProxyTheme2Plugin(int i2);
}
