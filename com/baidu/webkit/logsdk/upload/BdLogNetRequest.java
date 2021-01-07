package com.baidu.webkit.logsdk.upload;

import com.baidu.webkit.logsdk.d;
import com.baidu.webkit.net.BdNet;
import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.net.INetListener;
import com.baidu.webkit.sdk.WebKitFactory;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class BdLogNetRequest implements INetListener {
    private static final int TIMEOUT = 30000;
    d mCallback;
    private ByteArrayOutputStream mData;
    private boolean mIsConfig;

    BdLogNetRequest(d dVar, boolean z) {
        this.mIsConfig = z;
        this.mCallback = dVar;
    }

    public static void requestConfig(String str, d dVar) {
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "requestConfig, url1: " + str);
        BdNet bdNet = new BdNet(WebKitFactory.getContext());
        bdNet.setEventListener(new BdLogNetRequest(dVar, true));
        BdNetTask bdNetTask = new BdNetTask();
        bdNetTask.setNet(bdNet);
        bdNetTask.setUrl(str);
        bdNet.start(bdNetTask, false);
    }

    public static void uploadLog(String str, JSONObject jSONObject, File file, d dVar) {
        byte[] bytes = jSONObject.toString().getBytes();
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "uploadLog " + jSONObject.toString());
        try {
            HashMap hashMap = new HashMap();
            BdNet bdNet = new BdNet(WebKitFactory.getContext());
            bdNet.setEventListener(new BdLogNetRequest(dVar, false));
            BdNetTask bdNetTask = new BdNetTask();
            bdNetTask.setMethod(BdNet.HttpMethod.METHOD_POST);
            bdNetTask.setNet(bdNet);
            bdNetTask.setUrl(str);
            hashMap.put("Content-Type", "application/x-gzip");
            if (WebKitFactory.getCurEngine() != 1) {
                hashMap.put("Kernel-Status", "0");
            }
            bdNetTask.setHeaders(hashMap);
            bdNetTask.setContent(com.baidu.webkit.internal.d.b(com.baidu.webkit.internal.d.c(bytes)));
            bdNet.start(bdNetTask, false);
        } catch (Exception e) {
            e.printStackTrace();
            dVar.a(null);
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetDownloadComplete(BdNet bdNet) {
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "onNetDownloadComplete  ");
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetDownloadError(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetError netError, int i) {
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "onNetDownloadError  " + bdNetTask.getUrl());
        this.mCallback.a(null);
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetReceiveData(BdNet bdNet, BdNetTask bdNetTask, byte[] bArr, int i) {
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "onNetReceiveData  " + i);
        if (this.mData == null) {
            this.mData = new ByteArrayOutputStream();
        }
        this.mData.write(bArr, 0, i);
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetReceiveHeaders(BdNet bdNet, BdNetTask bdNetTask) {
    }

    @Override // com.baidu.webkit.net.INetListener
    public boolean onNetRedirect(BdNet bdNet, BdNetTask bdNetTask, int i) {
        return false;
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetResponseCode(BdNet bdNet, BdNetTask bdNetTask, int i) {
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetStateChanged(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetState netState, int i) {
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetTaskComplete(BdNet bdNet, BdNetTask bdNetTask) {
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "onNetTaskComplete  " + bdNetTask.getUrl());
        if (this.mIsConfig) {
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "onNetTaskComplete1  " + bdNetTask.getUrl());
            this.mCallback.a(this.mData.toByteArray());
            return;
        }
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "onNetTaskComplete2  " + bdNetTask.getUrl());
        this.mCallback.a(new String("OK").getBytes());
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetTaskStart(BdNet bdNet, BdNetTask bdNetTask) {
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetUploadComplete(BdNet bdNet, BdNetTask bdNetTask) {
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetUploadData(BdNet bdNet, BdNetTask bdNetTask, int i, int i2) {
    }
}
