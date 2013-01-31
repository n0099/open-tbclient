package com.baidu.zeus;

import com.baidu.zeus.CacheManager;
import java.util.Map;
@Deprecated
/* loaded from: classes.dex */
public interface UrlInterceptHandler {
    @Deprecated
    PluginData getPluginData(String str, Map map);

    @Deprecated
    CacheManager.CacheResult service(String str, Map map);
}
