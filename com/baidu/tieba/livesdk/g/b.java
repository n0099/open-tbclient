package com.baidu.tieba.livesdk.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.network.http.c;
import com.baidu.adp.lib.network.http.e;
import com.baidu.adp.lib.network.http.g;
import com.baidu.adp.lib.network.http.h;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.network.http.interfaces.DownLoadCallback;
import com.baidu.live.adp.lib.network.http.interfaces.INetWork;
import com.baidu.live.adp.lib.network.http.interfaces.NetResponse;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class b implements INetWork {
    private c iPh;
    private DownLoadCallback iPi;
    private int readTimeout = 0;
    private int connectTimeout = 0;
    private int retryCount = 0;
    private final Handler mainHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.livesdk.g.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 18:
                    if (b.this.iPi != null) {
                        b.this.iPi.onFileUpdateProgress(message.obj, message.arg1, message.arg2);
                        break;
                    }
                    break;
                case 19:
                    if (b.this.iPi != null) {
                        b.this.iPi.onFileDownloaded(message.obj, message.arg1);
                        break;
                    }
                    break;
            }
            super.handleMessage(message);
        }
    };
    private e GM = new e();

    @Override // com.baidu.live.adp.lib.network.http.interfaces.INetWork
    public void setUrl(String str) {
        this.GM.kB().setUrl(str);
    }

    @Override // com.baidu.live.adp.lib.network.http.interfaces.INetWork
    public void setHeaderData(HashMap<String, String> hashMap) {
        this.GM.kB().v(hashMap);
    }

    @Override // com.baidu.live.adp.lib.network.http.interfaces.INetWork
    public void setReadTimeout(int i) {
        this.readTimeout = i;
    }

    @Override // com.baidu.live.adp.lib.network.http.interfaces.INetWork
    public void setConnectTimeout(int i) {
        this.connectTimeout = i;
    }

    @Override // com.baidu.live.adp.lib.network.http.interfaces.INetWork
    public void setRetryCount(int i) {
        this.retryCount = i;
    }

    @Override // com.baidu.live.adp.lib.network.http.interfaces.INetWork
    public void cancel() {
        if (this.iPh != null) {
            this.iPh.cancel();
        }
    }

    @Override // com.baidu.live.adp.lib.network.http.interfaces.INetWork
    public NetResponse post(List<Map.Entry<String, Object>> list) {
        this.GM.kB().setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.GM.kB().k(list);
        this.iPh = new c(this.GM);
        this.iPh.f(this.retryCount, this.readTimeout, this.connectTimeout);
        return a(this.GM.kC());
    }

    @Override // com.baidu.live.adp.lib.network.http.interfaces.INetWork
    public NetResponse get(List<Map.Entry<String, Object>> list) {
        this.GM.kB().setMethod(HttpMessageTask.HTTP_METHOD.GET);
        this.GM.kB().k(list);
        this.iPh = new c(this.GM);
        this.iPh.d(this.retryCount, this.readTimeout, this.connectTimeout);
        return a(this.GM.kC());
    }

    @Override // com.baidu.live.adp.lib.network.http.interfaces.INetWork
    public NetResponse download(final Object obj, String str, DownLoadCallback downLoadCallback) {
        this.iPi = downLoadCallback;
        this.iPh = new c(this.GM);
        this.mainHandler.sendMessage(Message.obtain(this.mainHandler, 19, this.iPh.a(str, new h() { // from class: com.baidu.tieba.livesdk.g.b.2
            @Override // com.baidu.adp.lib.network.http.h
            public void onProgress(int i, int i2) {
                b.this.mainHandler.sendMessage(Message.obtain(b.this.mainHandler, 18, i, i2, obj));
            }
        }, this.retryCount, -1, this.readTimeout, this.connectTimeout, true, true) ? 0 : -1, 0, obj));
        return null;
    }

    private NetResponse a(g gVar) {
        if (gVar == null) {
            return null;
        }
        NetResponse netResponse = new NetResponse();
        netResponse.responseCode = this.GM.kC().responseCode;
        netResponse.netErrorCode = this.GM.kC().mNetErrorCode;
        netResponse.headers = this.GM.kC().Kq;
        netResponse.contentEncoding = this.GM.kC().contentEncoding;
        netResponse.contentLength = this.GM.kC().contentLength;
        netResponse.contentType = this.GM.kC().contentType;
        netResponse.downSize = this.GM.kC().downSize;
        netResponse.retBytes = this.GM.kC().retBytes;
        if (netResponse.retBytes != null && netResponse.retBytes.length > 0) {
            try {
                netResponse.decodedResponseStr = new String(netResponse.retBytes, "utf-8");
                return netResponse;
            } catch (UnsupportedEncodingException e) {
                BdLog.e(e);
                return netResponse;
            }
        }
        return netResponse;
    }
}
