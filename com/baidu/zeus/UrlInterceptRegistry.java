package com.baidu.zeus;

import com.baidu.zeus.CacheManager;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
@Deprecated
/* loaded from: classes.dex */
public final class UrlInterceptRegistry {
    private static final String LOGTAG = "intercept";
    private static boolean mDisabled = false;
    private static LinkedList mHandlerList;

    private static synchronized LinkedList getHandlers() {
        LinkedList linkedList;
        synchronized (UrlInterceptRegistry.class) {
            if (mHandlerList == null) {
                mHandlerList = new LinkedList();
            }
            linkedList = mHandlerList;
        }
        return linkedList;
    }

    @Deprecated
    public static synchronized void setUrlInterceptDisabled(boolean z) {
        synchronized (UrlInterceptRegistry.class) {
            mDisabled = z;
        }
    }

    @Deprecated
    public static synchronized boolean urlInterceptDisabled() {
        boolean z;
        synchronized (UrlInterceptRegistry.class) {
            z = mDisabled;
        }
        return z;
    }

    @Deprecated
    public static synchronized boolean registerHandler(UrlInterceptHandler urlInterceptHandler) {
        boolean z;
        synchronized (UrlInterceptRegistry.class) {
            if (getHandlers().contains(urlInterceptHandler)) {
                z = false;
            } else {
                getHandlers().addFirst(urlInterceptHandler);
                z = true;
            }
        }
        return z;
    }

    @Deprecated
    public static synchronized boolean unregisterHandler(UrlInterceptHandler urlInterceptHandler) {
        boolean remove;
        synchronized (UrlInterceptRegistry.class) {
            remove = getHandlers().remove(urlInterceptHandler);
        }
        return remove;
    }

    @Deprecated
    public static synchronized CacheManager.CacheResult getSurrogate(String str, Map<String, String> map) {
        CacheManager.CacheResult cacheResult;
        synchronized (UrlInterceptRegistry.class) {
            if (!urlInterceptDisabled()) {
                ListIterator listIterator = getHandlers().listIterator();
                while (true) {
                    if (!listIterator.hasNext()) {
                        cacheResult = null;
                        break;
                    }
                    cacheResult = ((UrlInterceptHandler) listIterator.next()).service(str, map);
                    if (cacheResult != null) {
                        break;
                    }
                }
            } else {
                cacheResult = null;
            }
        }
        return cacheResult;
    }

    @Deprecated
    public static synchronized PluginData getPluginData(String str, Map<String, String> map) {
        PluginData pluginData;
        synchronized (UrlInterceptRegistry.class) {
            if (!urlInterceptDisabled()) {
                ListIterator listIterator = getHandlers().listIterator();
                while (true) {
                    if (!listIterator.hasNext()) {
                        pluginData = null;
                        break;
                    }
                    pluginData = ((UrlInterceptHandler) listIterator.next()).getPluginData(str, map);
                    if (pluginData != null) {
                        break;
                    }
                }
            } else {
                pluginData = null;
            }
        }
        return pluginData;
    }
}
