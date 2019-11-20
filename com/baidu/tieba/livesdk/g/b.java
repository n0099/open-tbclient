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
/* loaded from: classes6.dex */
public class b implements INetWork {
    private c hjV;
    private DownLoadCallback hjW;
    private int readTimeout = 0;
    private int connectTimeout = 0;
    private int retryCount = 0;
    private final Handler aAX = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.livesdk.g.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 18:
                    if (b.this.hjW != null) {
                        b.this.hjW.onFileUpdateProgress(message.obj, message.arg1, message.arg2);
                        break;
                    }
                    break;
                case 19:
                    if (b.this.hjW != null) {
                        b.this.hjW.onFileDownloaded(message.obj, message.arg1);
                        break;
                    }
                    break;
            }
            super.handleMessage(message);
        }
    };
    private e lh = new e();

    @Override // com.baidu.live.adp.lib.network.http.interfaces.INetWork
    public void setUrl(String str) {
        this.lh.fJ().setUrl(str);
    }

    @Override // com.baidu.live.adp.lib.network.http.interfaces.INetWork
    public void setHeaderData(HashMap<String, String> hashMap) {
        this.lh.fJ().j(hashMap);
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
        if (this.hjV != null) {
            this.hjV.cancel();
        }
    }

    @Override // com.baidu.live.adp.lib.network.http.interfaces.INetWork
    public NetResponse post(List<Map.Entry<String, Object>> list) {
        this.lh.fJ().setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.lh.fJ().i(list);
        this.hjV = new c(this.lh);
        this.hjV.e(this.retryCount, this.readTimeout, this.connectTimeout);
        return a(this.lh.fK());
    }

    @Override // com.baidu.live.adp.lib.network.http.interfaces.INetWork
    public NetResponse get(List<Map.Entry<String, Object>> list) {
        this.lh.fJ().setMethod(HttpMessageTask.HTTP_METHOD.GET);
        this.lh.fJ().i(list);
        this.hjV = new c(this.lh);
        this.hjV.c(this.retryCount, this.readTimeout, this.connectTimeout);
        return a(this.lh.fK());
    }

    @Override // com.baidu.live.adp.lib.network.http.interfaces.INetWork
    public NetResponse download(final Object obj, String str, DownLoadCallback downLoadCallback) {
        this.hjW = downLoadCallback;
        this.hjV = new c(this.lh);
        this.aAX.sendMessage(Message.obtain(this.aAX, 19, this.hjV.a(str, new h() { // from class: com.baidu.tieba.livesdk.g.b.2
            @Override // com.baidu.adp.lib.network.http.h
            public void h(int i, int i2) {
                b.this.aAX.sendMessage(Message.obtain(b.this.aAX, 18, i, i2, obj));
            }
        }, this.retryCount, -1, this.readTimeout, this.connectTimeout, true, true) ? 0 : -1, 0, obj));
        return null;
    }

    private NetResponse a(g gVar) {
        if (gVar == null) {
            return null;
        }
        NetResponse netResponse = new NetResponse();
        netResponse.responseCode = this.lh.fK().responseCode;
        netResponse.netErrorCode = this.lh.fK().mNetErrorCode;
        netResponse.headers = this.lh.fK().oU;
        netResponse.contentEncoding = this.lh.fK().contentEncoding;
        netResponse.contentLength = this.lh.fK().contentLength;
        netResponse.contentType = this.lh.fK().contentType;
        netResponse.downSize = this.lh.fK().downSize;
        netResponse.retBytes = this.lh.fK().retBytes;
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
