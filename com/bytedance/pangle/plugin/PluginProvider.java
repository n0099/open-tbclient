package com.bytedance.pangle.plugin;

import java.io.File;
import java.util.List;
/* loaded from: classes7.dex */
public interface PluginProvider {
    File provideBuiltInPlugin();

    List providePluginConfig();

    boolean useLocalPlugin();
}
