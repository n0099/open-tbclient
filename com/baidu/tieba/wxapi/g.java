package com.baidu.tieba.wxapi;

import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements IWXAPIEventHandler {
    final /* synthetic */ f euk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.euk = fVar;
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
        IWXAPIEventHandler iWXAPIEventHandler;
        IWXAPIEventHandler iWXAPIEventHandler2;
        iWXAPIEventHandler = this.euk.eui;
        if (iWXAPIEventHandler != null) {
            iWXAPIEventHandler2 = this.euk.eui;
            iWXAPIEventHandler2.onReq(baseReq);
        }
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        ConcurrentHashMap concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2;
        try {
            concurrentHashMap = this.euk.euh;
            IWXAPIEventHandler iWXAPIEventHandler = (IWXAPIEventHandler) concurrentHashMap.get(baseResp.transaction);
            if (iWXAPIEventHandler != null) {
                iWXAPIEventHandler.onResp(baseResp);
                concurrentHashMap2 = this.euk.euh;
                concurrentHashMap2.remove(baseResp.transaction);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
