package com.bytedance.pangle.plugin;

import androidx.annotation.Keep;
import com.bytedance.pangle.download.PluginDownloadBean;
import java.io.File;
import java.util.List;
@Keep
/* loaded from: classes8.dex */
public interface PluginProvider {
    File provideBuiltInPlugin();

    List<PluginDownloadBean> providePluginConfig();

    boolean useLocalPlugin();
}
