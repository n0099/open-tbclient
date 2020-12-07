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
/* loaded from: classes4.dex */
public class b implements INetWork {
    private c kYe;
    private DownLoadCallback kYf;
    private int readTimeout = 0;
    private int connectTimeout = 0;
    private int retryCount = 0;
    private final Handler mainHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.livesdk.g.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 18:
                    if (b.this.kYf != null) {
                        b.this.kYf.onFileUpdateProgress(message.obj, message.arg1, message.arg2);
                        break;
                    }
                    break;
                case 19:
                    if (b.this.kYf != null) {
                        b.this.kYf.onFileDownloaded(message.obj, message.arg1, null);
                        break;
                    }
                    break;
            }
            super.handleMessage(message);
        }
    };
    private e Jt = new e();

    @Override // com.baidu.live.adp.lib.network.http.interfaces.INetWork
    public void setUrl(String str) {
        this.Jt.mx().setUrl(str);
    }

    @Override // com.baidu.live.adp.lib.network.http.interfaces.INetWork
    public void setHeaderData(HashMap<String, String> hashMap) {
        this.Jt.mx().t(hashMap);
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
        if (this.kYe != null) {
            this.kYe.cancel();
        }
    }

    @Override // com.baidu.live.adp.lib.network.http.interfaces.INetWork
    public NetResponse post(List<Map.Entry<String, Object>> list) {
        this.Jt.mx().setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.Jt.mx().n(list);
        this.kYe = new c(this.Jt);
        this.kYe.ah(false);
        this.kYe.f(this.retryCount, this.readTimeout, this.connectTimeout);
        return a(this.Jt.my());
    }

    @Override // com.baidu.live.adp.lib.network.http.interfaces.INetWork
    public NetResponse get(List<Map.Entry<String, Object>> list) {
        this.Jt.mx().setMethod(HttpMessageTask.HTTP_METHOD.GET);
        this.Jt.mx().n(list);
        this.kYe = new c(this.Jt);
        this.kYe.d(this.retryCount, this.readTimeout, this.connectTimeout);
        return a(this.Jt.my());
    }

    @Override // com.baidu.live.adp.lib.network.http.interfaces.INetWork
    public NetResponse download(final Object obj, String str, DownLoadCallback downLoadCallback) {
        this.kYf = downLoadCallback;
        this.kYe = new c(this.Jt);
        this.mainHandler.sendMessage(Message.obtain(this.mainHandler, 19, this.kYe.a(str, new h() { // from class: com.baidu.tieba.livesdk.g.b.2
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
        netResponse.responseCode = this.Jt.my().responseCode;
        netResponse.netErrorCode = this.Jt.my().mNetErrorCode;
        netResponse.headers = this.Jt.my().Nk;
        netResponse.contentEncoding = this.Jt.my().contentEncoding;
        netResponse.contentLength = this.Jt.my().contentLength;
        netResponse.contentType = this.Jt.my().contentType;
        netResponse.downSize = this.Jt.my().downSize;
        netResponse.retBytes = this.Jt.my().retBytes;
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
