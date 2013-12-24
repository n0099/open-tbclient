package com.baidu.zeus;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.zeus.ByteArrayBuilder;
import com.baidu.zeus.CacheManager;
import com.baidu.zeus.WebView;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class WebViewWorker extends Handler {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final int CACHE_TRANSACTION_TICKER_INTERVAL = 60000;
    static final int MSG_ADD_HTTPLOADER = 102;
    static final int MSG_ADD_STREAMLOADER = 101;
    static final int MSG_APPEND_CACHE = 105;
    static final int MSG_CACHE_TRANSACTION_TICKER = 110;
    static final int MSG_CLEAR_CACHE = 109;
    static final int MSG_CREATE_CACHE = 103;
    static final int MSG_INSERT_CACHE_DATA = 113;
    static final int MSG_PAUSE_CACHE_TRANSACTION = 111;
    static final int MSG_REMOVE_CACHE = 107;
    static final int MSG_RESUME_CACHE_TRANSACTION = 112;
    static final int MSG_SAVE_CACHE = 106;
    static final int MSG_TRIM_CACHE = 108;
    static final int MSG_UPDATE_CACHE_ENCODING = 104;
    static final int MSG_UPDATE_CACHE_EXPIRES = 114;
    private static final String THREAD_NAME = "WebViewWorkerThread";
    private static Map<LoadListener, CacheManager.CacheResult> mCacheResultMap;
    private static boolean mCacheTickersBlocked;
    private static WebViewWorker sWorkerHandler;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class CacheCreateData {
        Headers mHeaders;
        LoadListener mListener;
        String mMimeType;
        long mPostId;
        int mStatusCode;
        WebView.PageType mType;
        String mUrl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class CacheData {
        ByteArrayBuilder.Chunk mChunk;
        LoadListener mListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class CacheEncoding {
        String mEncoding;
        LoadListener mListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class CacheSaveData {
        LoadListener mListener;
        long mPostId;
        String mUrl;
    }

    static {
        $assertionsDisabled = !WebViewWorker.class.desiredAssertionStatus();
        mCacheResultMap = new HashMap();
        mCacheTickersBlocked = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized WebViewWorker getHandler() {
        WebViewWorker webViewWorker;
        synchronized (WebViewWorker.class) {
            if (sWorkerHandler == null) {
                HandlerThread handlerThread = new HandlerThread(THREAD_NAME, 1);
                handlerThread.start();
                sWorkerHandler = new WebViewWorker(handlerThread.getLooper());
            }
            webViewWorker = sWorkerHandler;
        }
        return webViewWorker;
    }

    private WebViewWorker(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 101:
                ((StreamLoader) message.obj).load();
                return;
            case 102:
                ((FrameLoader) message.obj).handleHTTPLoad();
                return;
            case 103:
                if (!$assertionsDisabled && JniUtil.useChromiumHttpStack()) {
                    throw new AssertionError();
                }
                CacheCreateData cacheCreateData = (CacheCreateData) message.obj;
                CacheManager.CacheResult createCacheFile = CacheManager.createCacheFile(cacheCreateData.mUrl, cacheCreateData.mStatusCode, cacheCreateData.mHeaders, cacheCreateData.mMimeType, cacheCreateData.mPostId, false, cacheCreateData.mType);
                if (createCacheFile != null) {
                    mCacheResultMap.put(cacheCreateData.mListener, createCacheFile);
                    return;
                } else {
                    mCacheResultMap.remove(cacheCreateData.mListener);
                    return;
                }
            case 104:
                if (!$assertionsDisabled && JniUtil.useChromiumHttpStack()) {
                    throw new AssertionError();
                }
                CacheEncoding cacheEncoding = (CacheEncoding) message.obj;
                CacheManager.CacheResult cacheResult = mCacheResultMap.get(cacheEncoding.mListener);
                if (cacheResult != null) {
                    cacheResult.encoding = cacheEncoding.mEncoding;
                    return;
                }
                return;
            case 105:
                if (!$assertionsDisabled && JniUtil.useChromiumHttpStack()) {
                    throw new AssertionError();
                }
                CacheData cacheData = (CacheData) message.obj;
                CacheManager.CacheResult cacheResult2 = mCacheResultMap.get(cacheData.mListener);
                if (cacheResult2 != null) {
                    cacheResult2.contentLength += cacheData.mChunk.mLength;
                    if (cacheResult2.contentLength > CacheManager.CACHE_MAX_SIZE) {
                        CacheManager.cleanupCacheFile(cacheResult2);
                        mCacheResultMap.remove(cacheData.mListener);
                    } else {
                        try {
                            cacheResult2.outStream.write(cacheData.mChunk.mArray, 0, cacheData.mChunk.mLength);
                        } catch (IOException e) {
                            CacheManager.cleanupCacheFile(cacheResult2);
                            mCacheResultMap.remove(cacheData.mListener);
                        }
                    }
                }
                cacheData.mChunk.release();
                return;
            case 106:
                if (!$assertionsDisabled && JniUtil.useChromiumHttpStack()) {
                    throw new AssertionError();
                }
                CacheSaveData cacheSaveData = (CacheSaveData) message.obj;
                CacheManager.CacheResult cacheResult3 = mCacheResultMap.get(cacheSaveData.mListener);
                if (cacheResult3 != null) {
                    CacheManager.saveCacheFile(cacheSaveData.mUrl, cacheSaveData.mPostId, cacheResult3, cacheSaveData.mListener.pageType());
                    mCacheResultMap.remove(cacheSaveData.mListener);
                    return;
                }
                return;
            case 107:
                if (!$assertionsDisabled && JniUtil.useChromiumHttpStack()) {
                    throw new AssertionError();
                }
                LoadListener loadListener = (LoadListener) message.obj;
                CacheManager.CacheResult cacheResult4 = mCacheResultMap.get(loadListener);
                if (cacheResult4 != null) {
                    CacheManager.cleanupCacheFile(cacheResult4);
                    mCacheResultMap.remove(loadListener);
                    return;
                }
                return;
            case MSG_TRIM_CACHE /* 108 */:
                if (!$assertionsDisabled && JniUtil.useChromiumHttpStack()) {
                    throw new AssertionError();
                }
                CacheManager.trimCacheIfNeeded();
                return;
            case MSG_CLEAR_CACHE /* 109 */:
                if (!$assertionsDisabled && JniUtil.useChromiumHttpStack()) {
                    throw new AssertionError();
                }
                CacheManager.clearCache();
                return;
            case 110:
                if (!$assertionsDisabled && JniUtil.useChromiumHttpStack()) {
                    throw new AssertionError();
                }
                if (!mCacheTickersBlocked) {
                    CacheManager.endTransaction();
                    CacheManager.startTransaction();
                    sendEmptyMessageDelayed(110, 60000L);
                    return;
                }
                return;
            case 111:
                if (!$assertionsDisabled && JniUtil.useChromiumHttpStack()) {
                    throw new AssertionError();
                }
                if (CacheManager.disableTransaction()) {
                    mCacheTickersBlocked = true;
                    removeMessages(110);
                    return;
                }
                return;
            case 112:
                if (!$assertionsDisabled && JniUtil.useChromiumHttpStack()) {
                    throw new AssertionError();
                }
                if (CacheManager.enableTransaction()) {
                    mCacheTickersBlocked = false;
                    sendEmptyMessageDelayed(110, 60000L);
                    return;
                }
                return;
            case MSG_INSERT_CACHE_DATA /* 113 */:
                CacheManager.insertAfterPageFinish();
                return;
            case MSG_UPDATE_CACHE_EXPIRES /* 114 */:
                LoadListener loadListener2 = (LoadListener) message.obj;
                CacheManager.CacheResult cacheResult5 = mCacheResultMap.get(loadListener2);
                if (cacheResult5 == null) {
                    cacheResult5 = CacheManager.getCacheResult(loadListener2.url(), loadListener2.postIdentifier(), loadListener2.pageType());
                }
                if (cacheResult5 != null) {
                    cacheResult5.expires = 0L;
                    return;
                }
                return;
            default:
                return;
        }
    }

    static void appendCache(CacheData cacheData) {
        CacheManager.CacheResult cacheResult = mCacheResultMap.get(cacheData.mListener);
        if (cacheResult != null) {
            cacheResult.contentLength += cacheData.mChunk.mLength;
            if (cacheResult.contentLength > CacheManager.CACHE_MAX_SIZE) {
                CacheManager.cleanupCacheFile(cacheResult);
                mCacheResultMap.remove(cacheData.mListener);
            } else {
                try {
                    cacheResult.outStream.write(cacheData.mChunk.mArray, 0, cacheData.mChunk.mLength);
                } catch (IOException e) {
                    CacheManager.cleanupCacheFile(cacheResult);
                    mCacheResultMap.remove(cacheData.mListener);
                }
            }
        }
        cacheData.mChunk.release();
    }
}
