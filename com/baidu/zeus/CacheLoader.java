package com.baidu.zeus;

import android.text.TextUtils;
import com.baidu.zeus.CacheManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CacheLoader extends StreamLoader {
    static final /* synthetic */ boolean $assertionsDisabled;
    CacheManager.CacheResult mCacheResult;

    static {
        $assertionsDisabled = !CacheLoader.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CacheLoader(LoadListener loadListener, CacheManager.CacheResult cacheResult) {
        super(loadListener);
        if (!$assertionsDisabled && JniUtil.useChromiumHttpStack()) {
            throw new AssertionError();
        }
        this.mCacheResult = cacheResult;
    }

    @Override // com.baidu.zeus.StreamLoader
    protected boolean setupStreamAndSendStatus() {
        this.mDataStream = this.mCacheResult.inStream;
        this.mContentLength = this.mCacheResult.contentLength;
        this.mLoadListener.status(1, 1, this.mCacheResult.httpStatusCode, "OK");
        return true;
    }

    @Override // com.baidu.zeus.StreamLoader
    protected void buildHeaders(Headers headers) {
        StringBuilder sb = new StringBuilder(this.mCacheResult.mimeType);
        if (!TextUtils.isEmpty(this.mCacheResult.encoding)) {
            sb.append(';');
            sb.append(this.mCacheResult.encoding);
        }
        headers.setContentType(sb.toString());
        if (!TextUtils.isEmpty(this.mCacheResult.location)) {
            headers.setLocation(this.mCacheResult.location);
        }
        if (!TextUtils.isEmpty(this.mCacheResult.expiresString)) {
            headers.setExpires(this.mCacheResult.expiresString);
        }
        if (!TextUtils.isEmpty(this.mCacheResult.contentdisposition)) {
            headers.setContentDisposition(this.mCacheResult.contentdisposition);
        }
        if (!TextUtils.isEmpty(this.mCacheResult.crossDomain)) {
            headers.setXPermittedCrossDomainPolicies(this.mCacheResult.crossDomain);
        }
    }
}
