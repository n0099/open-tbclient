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
    private c hkM;
    private DownLoadCallback hkN;
    private int readTimeout = 0;
    private int connectTimeout = 0;
    private int retryCount = 0;
    private final Handler aBp = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.livesdk.g.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 18:
                    if (b.this.hkN != null) {
                        b.this.hkN.onFileUpdateProgress(message.obj, message.arg1, message.arg2);
                        break;
                    }
                    break;
                case 19:
                    if (b.this.hkN != null) {
                        b.this.hkN.onFileDownloaded(message.obj, message.arg1);
                        break;
                    }
                    break;
            }
            super.handleMessage(message);
        }
    };
    private e lJ = new e();

    @Override // com.baidu.live.adp.lib.network.http.interfaces.INetWork
    public void setUrl(String str) {
        this.lJ.fJ().setUrl(str);
    }

    @Override // com.baidu.live.adp.lib.network.http.interfaces.INetWork
    public void setHeaderData(HashMap<String, String> hashMap) {
        this.lJ.fJ().j(hashMap);
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
        if (this.hkM != null) {
            this.hkM.cancel();
        }
    }

    @Override // com.baidu.live.adp.lib.network.http.interfaces.INetWork
    public NetResponse post(List<Map.Entry<String, Object>> list) {
        this.lJ.fJ().setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.lJ.fJ().i(list);
        this.hkM = new c(this.lJ);
        this.hkM.e(this.retryCount, this.readTimeout, this.connectTimeout);
        return a(this.lJ.fK());
    }

    @Override // com.baidu.live.adp.lib.network.http.interfaces.INetWork
    public NetResponse get(List<Map.Entry<String, Object>> list) {
        this.lJ.fJ().setMethod(HttpMessageTask.HTTP_METHOD.GET);
        this.lJ.fJ().i(list);
        this.hkM = new c(this.lJ);
        this.hkM.c(this.retryCount, this.readTimeout, this.connectTimeout);
        return a(this.lJ.fK());
    }

    @Override // com.baidu.live.adp.lib.network.http.interfaces.INetWork
    public NetResponse download(final Object obj, String str, DownLoadCallback downLoadCallback) {
        this.hkN = downLoadCallback;
        this.hkM = new c(this.lJ);
        this.aBp.sendMessage(Message.obtain(this.aBp, 19, this.hkM.a(str, new h() { // from class: com.baidu.tieba.livesdk.g.b.2
            @Override // com.baidu.adp.lib.network.http.h
            public void j(int i, int i2) {
                b.this.aBp.sendMessage(Message.obtain(b.this.aBp, 18, i, i2, obj));
            }
        }, this.retryCount, -1, this.readTimeout, this.connectTimeout, true, true) ? 0 : -1, 0, obj));
        return null;
    }

    private NetResponse a(g gVar) {
        if (gVar == null) {
            return null;
        }
        NetResponse netResponse = new NetResponse();
        netResponse.responseCode = this.lJ.fK().responseCode;
        netResponse.netErrorCode = this.lJ.fK().mNetErrorCode;
        netResponse.headers = this.lJ.fK().pA;
        netResponse.contentEncoding = this.lJ.fK().contentEncoding;
        netResponse.contentLength = this.lJ.fK().contentLength;
        netResponse.contentType = this.lJ.fK().contentType;
        netResponse.downSize = this.lJ.fK().downSize;
        netResponse.retBytes = this.lJ.fK().retBytes;
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
