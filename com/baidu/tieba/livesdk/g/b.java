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
    private c kcR;
    private DownLoadCallback kcS;
    private int readTimeout = 0;
    private int connectTimeout = 0;
    private int retryCount = 0;
    private final Handler mainHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.livesdk.g.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 18:
                    if (b.this.kcS != null) {
                        b.this.kcS.onFileUpdateProgress(message.obj, message.arg1, message.arg2);
                        break;
                    }
                    break;
                case 19:
                    if (b.this.kcS != null) {
                        b.this.kcS.onFileDownloaded(message.obj, message.arg1, null);
                        break;
                    }
                    break;
            }
            super.handleMessage(message);
        }
    };
    private e If = new e();

    @Override // com.baidu.live.adp.lib.network.http.interfaces.INetWork
    public void setUrl(String str) {
        this.If.mw().setUrl(str);
    }

    @Override // com.baidu.live.adp.lib.network.http.interfaces.INetWork
    public void setHeaderData(HashMap<String, String> hashMap) {
        this.If.mw().t(hashMap);
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
        if (this.kcR != null) {
            this.kcR.cancel();
        }
    }

    @Override // com.baidu.live.adp.lib.network.http.interfaces.INetWork
    public NetResponse post(List<Map.Entry<String, Object>> list) {
        this.If.mw().setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.If.mw().n(list);
        this.kcR = new c(this.If);
        this.kcR.aj(false);
        this.kcR.f(this.retryCount, this.readTimeout, this.connectTimeout);
        return a(this.If.mx());
    }

    @Override // com.baidu.live.adp.lib.network.http.interfaces.INetWork
    public NetResponse get(List<Map.Entry<String, Object>> list) {
        this.If.mw().setMethod(HttpMessageTask.HTTP_METHOD.GET);
        this.If.mw().n(list);
        this.kcR = new c(this.If);
        this.kcR.d(this.retryCount, this.readTimeout, this.connectTimeout);
        return a(this.If.mx());
    }

    @Override // com.baidu.live.adp.lib.network.http.interfaces.INetWork
    public NetResponse download(final Object obj, String str, DownLoadCallback downLoadCallback) {
        this.kcS = downLoadCallback;
        this.kcR = new c(this.If);
        this.mainHandler.sendMessage(Message.obtain(this.mainHandler, 19, this.kcR.a(str, new h() { // from class: com.baidu.tieba.livesdk.g.b.2
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
        netResponse.responseCode = this.If.mx().responseCode;
        netResponse.netErrorCode = this.If.mx().mNetErrorCode;
        netResponse.headers = this.If.mx().LY;
        netResponse.contentEncoding = this.If.mx().contentEncoding;
        netResponse.contentLength = this.If.mx().contentLength;
        netResponse.contentType = this.If.mx().contentType;
        netResponse.downSize = this.If.mx().downSize;
        netResponse.retBytes = this.If.mx().retBytes;
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
