package com.bytedance.pangle.activity;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.pangle.plugin.Plugin;
/* loaded from: classes7.dex */
public interface IPluginActivity {
    void _requestPermissions(String[] strArr, int i);

    void attachBaseContext(Context context);

    String getPluginPkgName();

    void onCreate(Bundle bundle);

    void setPluginProxyActivity(b bVar, Plugin plugin);

    void setProxyTheme2Plugin(int i);
}
