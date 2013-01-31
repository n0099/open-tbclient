package com.baidu.zeus;

import java.io.InputStream;
import java.util.Map;
@Deprecated
/* loaded from: classes.dex */
public final class PluginData {
    private long mContentLength;
    private Map mHeaders;
    private int mStatusCode;
    private InputStream mStream;

    @Deprecated
    public PluginData(InputStream inputStream, long j, Map map, int i) {
        this.mStream = inputStream;
        this.mContentLength = j;
        this.mHeaders = map;
        this.mStatusCode = i;
    }

    @Deprecated
    public InputStream getInputStream() {
        return this.mStream;
    }

    @Deprecated
    public long getContentLength() {
        return this.mContentLength;
    }

    @Deprecated
    public Map getHeaders() {
        return this.mHeaders;
    }

    @Deprecated
    public int getStatusCode() {
        return this.mStatusCode;
    }
}
