package com.baidu.webkit.sdk;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
@Deprecated
/* loaded from: classes5.dex */
public class CacheManager {
    public static final /* synthetic */ boolean $assertionsDisabled = false;

    @Deprecated
    /* loaded from: classes5.dex */
    public static class CacheResult {
        public long contentLength;
        public String contentdisposition;
        public String crossDomain;
        public String encoding;
        public String etag;
        public long expires;
        public String expiresString;
        public int httpStatusCode;
        public InputStream inStream;
        public String lastModified;
        public String localPath;
        public String location;
        public String mimeType;
        public File outFile;
        public OutputStream outStream;

        public String getContentDisposition() {
            return this.contentdisposition;
        }

        public long getContentLength() {
            return this.contentLength;
        }

        public String getETag() {
            return this.etag;
        }

        public String getEncoding() {
            return this.encoding;
        }

        public long getExpires() {
            return this.expires;
        }

        public String getExpiresString() {
            return this.expiresString;
        }

        public int getHttpStatusCode() {
            return this.httpStatusCode;
        }

        public InputStream getInputStream() {
            return this.inStream;
        }

        public String getLastModified() {
            return this.lastModified;
        }

        public String getLocalPath() {
            return this.localPath;
        }

        public String getLocation() {
            return this.location;
        }

        public String getMimeType() {
            return this.mimeType;
        }

        public OutputStream getOutputStream() {
            return this.outStream;
        }

        public void setContentLength(long j) {
            this.contentLength = j;
        }

        public void setEncoding(String str) {
            this.encoding = str;
        }

        public void setInputStream(InputStream inputStream) {
            this.inStream = inputStream;
        }
    }

    @Deprecated
    public static boolean cacheDisabled() {
        return false;
    }

    @Deprecated
    public static boolean endCacheTransaction() {
        return false;
    }

    @Deprecated
    public static CacheResult getCacheFile(String str, Map<String, String> map) {
        return null;
    }

    @Deprecated
    public static File getCacheFileBaseDir() {
        return null;
    }

    public static void saveCacheFile(String str, long j, CacheResult cacheResult) {
        try {
            cacheResult.outStream.close();
        } catch (IOException unused) {
        }
    }

    @Deprecated
    public static void saveCacheFile(String str, CacheResult cacheResult) {
        saveCacheFile(str, 0L, cacheResult);
    }

    @Deprecated
    public static boolean startCacheTransaction() {
        return false;
    }
}
