package com.baidu.zeus;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.VideoView;
import com.baidu.zeus.WebChromeClient;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class HTML5VideoViewProxy extends Handler implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {
    private static final String COOKIE = "Cookie";
    private static final int ENDED = 201;
    private static final int ERROR = 103;
    private static final int LOAD_DEFAULT_POSTER = 104;
    private static final String LOGTAG = "HTML5VideoViewProxy";
    private static final int PAUSE = 102;
    private static final int PAUSED = 203;
    private static final int PLAY = 100;
    private static final int POSTER_FETCHED = 202;
    private static final int PREPARED = 200;
    private static final int SEEK = 101;
    private static final int TIMEUPDATE = 300;
    int mNativePointer;
    private PosterDownloader mPosterDownloader;
    private int mSeekPosition;
    private Handler mWebCoreHandler;
    private WebView mWebView;

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnEnded(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnPaused(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnPosterFetched(Canvas canvas, int i, int i2, int i3, int i4);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnPrepared(int i, int i2, int i3, int i4);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnTimeupdate(int i, int i2);

    public native int getZeusBitmapFromCanvas(Canvas canvas, Bitmap bitmap);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class VideoPlayer {
        private static final int TIMEUPDATE_PERIOD = 250;
        static boolean isVideoSelfEnded = false;
        private static final WebChromeClient.CustomViewCallback mCallback = new WebChromeClient.CustomViewCallback() { // from class: com.baidu.zeus.HTML5VideoViewProxy.VideoPlayer.1
            @Override // com.baidu.zeus.WebChromeClient.CustomViewCallback
            public void onCustomViewHidden() {
                VideoPlayer.mTimer.cancel();
                java.util.Timer unused = VideoPlayer.mTimer = null;
                if (VideoPlayer.mVideoView.isPlaying()) {
                    VideoPlayer.mVideoView.stopPlayback();
                }
                if (VideoPlayer.isVideoSelfEnded) {
                    VideoPlayer.mCurrentProxy.dispatchOnEnded();
                } else {
                    VideoPlayer.mCurrentProxy.dispatchOnPaused();
                }
                VideoPlayer.isVideoSelfEnded = false;
                HTML5VideoViewProxy unused2 = VideoPlayer.mCurrentProxy = null;
                VideoPlayer.mLayout.removeView(VideoPlayer.mVideoView);
                VideoView unused3 = VideoPlayer.mVideoView = null;
                if (VideoPlayer.mProgressView != null) {
                    VideoPlayer.mLayout.removeView(VideoPlayer.mProgressView);
                    View unused4 = VideoPlayer.mProgressView = null;
                }
                FrameLayout unused5 = VideoPlayer.mLayout = null;
            }
        };
        private static HTML5VideoViewProxy mCurrentProxy;
        private static FrameLayout mLayout;
        private static View mProgressView;
        private static java.util.Timer mTimer;
        private static VideoView mVideoView;

        private VideoPlayer() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public final class TimeupdateTask extends TimerTask {
            private HTML5VideoViewProxy mProxy;

            public TimeupdateTask(HTML5VideoViewProxy hTML5VideoViewProxy) {
                this.mProxy = hTML5VideoViewProxy;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                this.mProxy.onTimeupdate();
            }
        }

        public static void play(String str, int i, HTML5VideoViewProxy hTML5VideoViewProxy, WebChromeClient webChromeClient) {
            if (mCurrentProxy == hTML5VideoViewProxy) {
                if (!mVideoView.isPlaying()) {
                    mVideoView.start();
                }
            } else if (mCurrentProxy != null) {
                hTML5VideoViewProxy.dispatchOnEnded();
            } else {
                mCurrentProxy = hTML5VideoViewProxy;
                mLayout = new FrameLayout(hTML5VideoViewProxy.getContext());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
                mVideoView = new VideoView(hTML5VideoViewProxy.getContext());
                mVideoView.setWillNotDraw(false);
                mVideoView.setMediaController(new MediaController(hTML5VideoViewProxy.getContext()));
                String cookie = CookieManager.getInstance().getCookie(str);
                if (cookie != null) {
                    new HashMap().put("Cookie", cookie);
                }
                mVideoView.setVideoURI(Uri.parse(str));
                mVideoView.setOnCompletionListener(hTML5VideoViewProxy);
                mVideoView.setOnPreparedListener(hTML5VideoViewProxy);
                mVideoView.setOnErrorListener(hTML5VideoViewProxy);
                mVideoView.seekTo(i);
                mLayout.addView(mVideoView, layoutParams);
                mProgressView = webChromeClient.getVideoLoadingProgressView();
                if (mProgressView != null) {
                    mLayout.addView(mProgressView, layoutParams);
                    mProgressView.setVisibility(0);
                }
                mLayout.setVisibility(0);
                mTimer = new java.util.Timer();
                mVideoView.start();
                webChromeClient.onShowCustomView(mLayout, mCallback);
            }
        }

        public static boolean isPlaying(HTML5VideoViewProxy hTML5VideoViewProxy) {
            return mCurrentProxy == hTML5VideoViewProxy && mVideoView != null && mVideoView.isPlaying();
        }

        public static int getCurrentPosition() {
            if (mVideoView == null) {
                return 0;
            }
            return mVideoView.getCurrentPosition();
        }

        public static void seek(int i, HTML5VideoViewProxy hTML5VideoViewProxy) {
            if (mCurrentProxy == hTML5VideoViewProxy && i >= 0 && mVideoView != null) {
                mVideoView.seekTo(i);
            }
        }

        public static void pause(HTML5VideoViewProxy hTML5VideoViewProxy) {
            if (mCurrentProxy == hTML5VideoViewProxy && mVideoView != null) {
                mVideoView.pause();
                mTimer.purge();
            }
        }

        public static void onPrepared() {
            if (mProgressView != null && mLayout != null) {
                mTimer.schedule(new TimeupdateTask(mCurrentProxy), 250L, 250L);
                mProgressView.setVisibility(8);
                mLayout.removeView(mProgressView);
                mProgressView = null;
            }
        }
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        VideoPlayer.onPrepared();
        Message obtain = Message.obtain(this.mWebCoreHandler, 200);
        HashMap hashMap = new HashMap();
        hashMap.put("dur", new Integer(mediaPlayer.getDuration()));
        hashMap.put("width", new Integer(mediaPlayer.getVideoWidth()));
        hashMap.put("height", new Integer(mediaPlayer.getVideoHeight()));
        obtain.obj = hashMap;
        this.mWebCoreHandler.sendMessage(obtain);
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        sendMessage(obtainMessage(ENDED, 1, 0));
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        sendMessage(obtainMessage(103));
        return false;
    }

    public void dispatchOnEnded() {
        this.mWebCoreHandler.sendMessage(Message.obtain(this.mWebCoreHandler, (int) ENDED));
    }

    public void dispatchOnPaused() {
        this.mWebCoreHandler.sendMessage(Message.obtain(this.mWebCoreHandler, (int) PAUSED));
    }

    public void onTimeupdate() {
        sendMessage(obtainMessage(300));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 100:
                String str = (String) message.obj;
                WebChromeClient webChromeClient = this.mWebView.getWebChromeClient();
                if (webChromeClient != null) {
                    VideoPlayer.play(str, this.mSeekPosition, this, webChromeClient);
                    return;
                }
                return;
            case 101:
                this.mSeekPosition = ((Integer) message.obj).intValue();
                VideoPlayer.seek(this.mSeekPosition, this);
                return;
            case 102:
                VideoPlayer.pause(this);
                return;
            case 103:
                break;
            case 104:
                WebChromeClient webChromeClient2 = this.mWebView.getWebChromeClient();
                if (webChromeClient2 != null) {
                    doSetPoster(webChromeClient2.getDefaultVideoPoster());
                    return;
                }
                return;
            case ENDED /* 201 */:
                if (message.arg1 == 1) {
                    VideoPlayer.isVideoSelfEnded = true;
                    break;
                }
                break;
            case 300:
                if (VideoPlayer.isPlaying(this)) {
                    sendTimeupdate();
                    return;
                }
                return;
            default:
                return;
        }
        WebChromeClient webChromeClient3 = this.mWebView.getWebChromeClient();
        if (webChromeClient3 != null) {
            webChromeClient3.onHideCustomView();
        }
    }

    /* loaded from: classes.dex */
    final class PosterDownloader implements EventHandler {
        private static int mQueueRefCount = 0;
        private static RequestQueue mRequestQueue;
        private Handler mHandler = new Handler();
        private Headers mHeaders;
        private ByteArrayOutputStream mPosterBytes;
        private final HTML5VideoViewProxy mProxy;
        private RequestHandle mRequestHandle;
        private int mStatusCode;
        private String mUrl;

        public PosterDownloader(String str, HTML5VideoViewProxy hTML5VideoViewProxy) {
            this.mUrl = str;
            this.mProxy = hTML5VideoViewProxy;
        }

        public void start() {
            retainQueue();
            this.mRequestHandle = mRequestQueue.queueRequest(this.mUrl, "GET", null, this, null, 0);
        }

        public void cancelAndReleaseQueue() {
            if (this.mRequestHandle != null) {
                this.mRequestHandle.cancel();
                this.mRequestHandle = null;
            }
            releaseQueue();
        }

        @Override // com.baidu.zeus.EventHandler
        public void status(int i, int i2, int i3, String str) {
            this.mStatusCode = i3;
        }

        @Override // com.baidu.zeus.EventHandler
        public void headers(Headers headers) {
            this.mHeaders = headers;
        }

        @Override // com.baidu.zeus.EventHandler
        public void data(byte[] bArr, int i) {
            if (this.mPosterBytes == null) {
                this.mPosterBytes = new ByteArrayOutputStream();
            }
            this.mPosterBytes.write(bArr, 0, i);
        }

        @Override // com.baidu.zeus.EventHandler
        public void endData() {
            if (this.mStatusCode == 200) {
                if (this.mPosterBytes.size() > 0) {
                    this.mProxy.doSetPoster(BitmapFactory.decodeByteArray(this.mPosterBytes.toByteArray(), 0, this.mPosterBytes.size()));
                }
                cleanup();
            } else if (this.mStatusCode >= 300 && this.mStatusCode < 400) {
                this.mUrl = this.mHeaders.getLocation();
                if (this.mUrl != null) {
                    this.mHandler.post(new Runnable() { // from class: com.baidu.zeus.HTML5VideoViewProxy.PosterDownloader.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PosterDownloader.this.mRequestHandle != null) {
                                PosterDownloader.this.mRequestHandle.setupRedirect(PosterDownloader.this.mUrl, PosterDownloader.this.mStatusCode, new HashMap());
                            }
                        }
                    });
                }
            }
        }

        @Override // com.baidu.zeus.EventHandler
        public void certificate(SslCertificate sslCertificate) {
        }

        @Override // com.baidu.zeus.EventHandler
        public void error(int i, String str) {
            cleanup();
        }

        @Override // com.baidu.zeus.EventHandler
        public boolean handleSslErrorRequest(SslError sslError) {
            return false;
        }

        private void cleanup() {
            if (this.mPosterBytes != null) {
                try {
                    this.mPosterBytes.close();
                } catch (IOException e) {
                } finally {
                    this.mPosterBytes = null;
                }
            }
        }

        private void retainQueue() {
            if (mRequestQueue == null) {
                mRequestQueue = new RequestQueue(this.mProxy.getContext());
            }
            mQueueRefCount++;
        }

        private void releaseQueue() {
            if (mQueueRefCount != 0) {
                int i = mQueueRefCount - 1;
                mQueueRefCount = i;
                if (i == 0) {
                    mRequestQueue.shutdown();
                    mRequestQueue = null;
                }
            }
        }
    }

    private HTML5VideoViewProxy(WebView webView, int i) {
        super(Looper.getMainLooper());
        this.mWebView = webView;
        this.mNativePointer = i;
        createWebCoreHandler();
    }

    private void createWebCoreHandler() {
        this.mWebCoreHandler = new Handler() { // from class: com.baidu.zeus.HTML5VideoViewProxy.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 200:
                        Map map = (Map) message.obj;
                        HTML5VideoViewProxy.this.nativeOnPrepared(((Integer) map.get("dur")).intValue(), ((Integer) map.get("width")).intValue(), ((Integer) map.get("height")).intValue(), HTML5VideoViewProxy.this.mNativePointer);
                        return;
                    case HTML5VideoViewProxy.ENDED /* 201 */:
                        HTML5VideoViewProxy.this.nativeOnEnded(HTML5VideoViewProxy.this.mNativePointer);
                        return;
                    case HTML5VideoViewProxy.POSTER_FETCHED /* 202 */:
                        Bitmap bitmap = (Bitmap) message.obj;
                        Canvas canvas = new Canvas();
                        if (bitmap != null && canvas != null) {
                            int width = bitmap.getWidth();
                            int height = bitmap.getHeight();
                            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
                            createBitmap.setDensity(bitmap.getDensity());
                            canvas.setBitmap(createBitmap);
                            canvas.drawBitmap(bitmap, new Rect(0, 0, width, height), new RectF(0.0f, 0.0f, width, height), (Paint) null);
                            HTML5VideoViewProxy.this.nativeOnPosterFetched(canvas, HTML5VideoViewProxy.this.mNativePointer, HTML5VideoViewProxy.this.getZeusBitmapFromCanvas(canvas, createBitmap), width, height);
                            return;
                        }
                        return;
                    case HTML5VideoViewProxy.PAUSED /* 203 */:
                        HTML5VideoViewProxy.this.nativeOnPaused(HTML5VideoViewProxy.this.mNativePointer);
                        return;
                    case 300:
                        HTML5VideoViewProxy.this.nativeOnTimeupdate(message.arg1, HTML5VideoViewProxy.this.mNativePointer);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSetPoster(Bitmap bitmap) {
        if (bitmap != null) {
            Message obtain = Message.obtain(this.mWebCoreHandler, (int) POSTER_FETCHED);
            obtain.obj = bitmap;
            this.mWebCoreHandler.sendMessage(obtain);
        }
    }

    private void sendTimeupdate() {
        Message obtain = Message.obtain(this.mWebCoreHandler, 300);
        obtain.arg1 = VideoPlayer.getCurrentPosition();
        this.mWebCoreHandler.sendMessage(obtain);
    }

    public Context getContext() {
        return this.mWebView.getContext();
    }

    public void play(String str) {
        if (str != null) {
            Message obtainMessage = obtainMessage(100);
            obtainMessage.obj = str;
            sendMessage(obtainMessage);
        }
    }

    public void seek(int i) {
        Message obtainMessage = obtainMessage(101);
        obtainMessage.obj = new Integer(i);
        sendMessage(obtainMessage);
    }

    public void pause() {
        sendMessage(obtainMessage(102));
    }

    public void teardown() {
        if (this.mPosterDownloader != null) {
            this.mPosterDownloader.cancelAndReleaseQueue();
        }
        this.mNativePointer = 0;
    }

    public void loadPoster(String str) {
        if (str == null) {
            sendMessage(obtainMessage(104));
            return;
        }
        if (this.mPosterDownloader != null) {
            this.mPosterDownloader.cancelAndReleaseQueue();
        }
        this.mPosterDownloader = new PosterDownloader(str, this);
        this.mPosterDownloader.start();
    }

    public static HTML5VideoViewProxy getInstance(WebViewCore webViewCore, int i) {
        return new HTML5VideoViewProxy(webViewCore.getWebView(), i);
    }
}
