package com.baidu.tieba.livesdk.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.network.http.c;
import com.baidu.adp.lib.network.http.f;
import com.baidu.adp.lib.network.http.h;
import com.baidu.adp.lib.network.http.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.network.http.interfaces.DownLoadCallback;
import com.baidu.live.adp.lib.network.http.interfaces.INetWork;
import com.baidu.live.adp.lib.network.http.interfaces.NetResponse;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class b implements INetWork {
    private c hXV;
    private DownLoadCallback hXW;
    private int readTimeout = 0;
    private int connectTimeout = 0;
    private int retryCount = 0;
    private final Handler mainHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.livesdk.g.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 18:
                    if (b.this.hXW != null) {
                        b.this.hXW.onFileUpdateProgress(message.obj, message.arg1, message.arg2);
                        break;
                    }
                    break;
                case 19:
                    if (b.this.hXW != null) {
                        b.this.hXW.onFileDownloaded(message.obj, message.arg1);
                        break;
                    }
                    break;
            }
            super.handleMessage(message);
        }
    };
    private f nE = new f();

    @Override // com.baidu.live.adp.lib.network.http.interfaces.INetWork
    public void setUrl(String str) {
        this.nE.fY().setUrl(str);
    }

    @Override // com.baidu.live.adp.lib.network.http.interfaces.INetWork
    public void setHeaderData(HashMap<String, String> hashMap) {
        this.nE.fY().i(hashMap);
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
        if (this.hXV != null) {
            this.hXV.cancel();
        }
    }

    @Override // com.baidu.live.adp.lib.network.http.interfaces.INetWork
    public NetResponse post(List<Map.Entry<String, Object>> list) {
        this.nE.fY().setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.nE.fY().h(list);
        this.hXV = new c(this.nE);
        this.hXV.e(this.retryCount, this.readTimeout, this.connectTimeout);
        return a(this.nE.fZ());
    }

    @Override // com.baidu.live.adp.lib.network.http.interfaces.INetWork
    public NetResponse get(List<Map.Entry<String, Object>> list) {
        this.nE.fY().setMethod(HttpMessageTask.HTTP_METHOD.GET);
        this.nE.fY().h(list);
        this.hXV = new c(this.nE);
        this.hXV.c(this.retryCount, this.readTimeout, this.connectTimeout);
        return a(this.nE.fZ());
    }

    @Override // com.baidu.live.adp.lib.network.http.interfaces.INetWork
    public NetResponse download(final Object obj, String str, DownLoadCallback downLoadCallback) {
        this.hXW = downLoadCallback;
        this.hXV = new c(this.nE);
        this.mainHandler.sendMessage(Message.obtain(this.mainHandler, 19, this.hXV.a(str, new i() { // from class: com.baidu.tieba.livesdk.g.b.2
            @Override // com.baidu.adp.lib.network.http.i
            public void j(int i, int i2) {
                b.this.mainHandler.sendMessage(Message.obtain(b.this.mainHandler, 18, i, i2, obj));
            }
        }, this.retryCount, -1, this.readTimeout, this.connectTimeout, true, true) ? 0 : -1, 0, obj));
        return null;
    }

    private NetResponse a(h hVar) {
        if (hVar == null) {
            return null;
        }
        NetResponse netResponse = new NetResponse();
        netResponse.responseCode = this.nE.fZ().responseCode;
        netResponse.netErrorCode = this.nE.fZ().mNetErrorCode;
        netResponse.headers = this.nE.fZ().rp;
        netResponse.contentEncoding = this.nE.fZ().contentEncoding;
        netResponse.contentLength = this.nE.fZ().contentLength;
        netResponse.contentType = this.nE.fZ().contentType;
        netResponse.downSize = this.nE.fZ().downSize;
        netResponse.retBytes = this.nE.fZ().retBytes;
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
