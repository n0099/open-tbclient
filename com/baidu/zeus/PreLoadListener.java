package com.baidu.zeus;

import android.content.Context;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class PreLoadListener implements EventHandler {
    private static final int HTTP_FOUND = 302;
    private static final int HTTP_OK = 200;
    private static final String LOGTAG = "PreLoadListener";
    private boolean mCancelled;
    private Context mContext;
    private int mHashCode;
    private String mMethod;
    private OutputStream mOutStream;
    private RequestHandle mRequestHandle;
    private int mStatusCode;
    private WebAddress mUri;
    private String mUrl;

    public static PreLoadListener getLoadListener(Context context, String str, int i) {
        return new PreLoadListener(context, str, i);
    }

    PreLoadListener(Context context, String str, int i) {
        this.mContext = context;
        this.mHashCode = i;
        setUrl(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context getContext() {
        return this.mContext;
    }

    public boolean cancelled() {
        return this.mCancelled;
    }

    @Override // com.baidu.zeus.EventHandler
    public void headers(Headers headers) {
        handleHeaders(headers);
    }

    private void handleHeaders(Headers headers) {
        if (!this.mCancelled) {
            ArrayList setCookie = headers.getSetCookie();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= setCookie.size()) {
                    break;
                }
                CookieManager.getInstance().setCookie(this.mUri, (String) setCookie.get(i2));
                i = i2 + 1;
            }
            if ((this.mStatusCode == 200 || this.mStatusCode == 302) && this.mRequestHandle != null) {
                this.mOutStream = PreLoadManager.getInstance().createCacheFile(this.mHashCode);
                if (this.mOutStream == null) {
                    cancel();
                    detachRequestHandle();
                    return;
                }
                return;
            }
            cancel();
            detachRequestHandle();
        }
    }

    @Override // com.baidu.zeus.EventHandler
    public void status(int i, int i2, int i3, String str) {
        this.mStatusCode = i3;
    }

    @Override // com.baidu.zeus.EventHandler
    public void certificate(SslCertificate sslCertificate) {
    }

    @Override // com.baidu.zeus.EventHandler
    public void error(int i, String str) {
        cancel();
        detachRequestHandle();
        tearDown();
    }

    @Override // com.baidu.zeus.EventHandler
    public void data(byte[] bArr, int i) {
        if (this.mRequestHandle != null) {
            NetworkStatistic.getInstance().addDownloadLength(i);
        }
        if (!this.mCancelled) {
            try {
                this.mOutStream.write(bArr, 0, i);
            } catch (IOException e) {
                cancel();
                detachRequestHandle();
                tearDown();
            }
        }
    }

    @Override // com.baidu.zeus.EventHandler
    public boolean handleSslErrorRequest(SslError sslError) {
        cancel();
        detachRequestHandle();
        tearDown();
        return false;
    }

    @Override // com.baidu.zeus.EventHandler
    public void endData() {
        if (!this.mCancelled) {
            cancel();
            detachRequestHandle();
            sucess();
        }
    }

    void sucess() {
        try {
            this.mOutStream.close();
            PreLoadManager.getInstance().setPreLoadUrl(this.mHashCode, this.mUrl);
        } catch (IOException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String url() {
        return this.mUrl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebAddress getWebAddress() {
        return this.mUri;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void attachRequestHandle(RequestHandle requestHandle) {
        this.mRequestHandle = requestHandle;
    }

    void detachRequestHandle() {
        this.mRequestHandle = null;
    }

    void tearDown() {
        if (this.mOutStream != null) {
            try {
                this.mOutStream.close();
            } catch (IOException e) {
            }
        }
    }

    public void cancel() {
        if (this.mRequestHandle != null) {
            this.mRequestHandle.cancel();
            this.mRequestHandle = null;
        }
        this.mCancelled = true;
    }

    void setUrl(String str) {
        if (str != null) {
            this.mUri = null;
            if (URLUtil.isHttpUrl(str)) {
                this.mUrl = URLUtil.stripAnchor(str);
                try {
                    this.mUri = new WebAddress(this.mUrl);
                    return;
                } catch (ParseException e) {
                    e.printStackTrace();
                    return;
                }
            }
            this.mUrl = str;
        }
    }
}
