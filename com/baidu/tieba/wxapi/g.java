package com.baidu.tieba.wxapi;

import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements IWXAPIEventHandler {
    final /* synthetic */ f eOb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.eOb = fVar;
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
        IWXAPIEventHandler iWXAPIEventHandler;
        IWXAPIEventHandler iWXAPIEventHandler2;
        iWXAPIEventHandler = this.eOb.eNZ;
        if (iWXAPIEventHandler != null) {
            iWXAPIEventHandler2 = this.eOb.eNZ;
            iWXAPIEventHandler2.onReq(baseReq);
        }
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        ConcurrentHashMap concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2;
        try {
            concurrentHashMap = this.eOb.eNY;
            IWXAPIEventHandler iWXAPIEventHandler = (IWXAPIEventHandler) concurrentHashMap.get(baseResp.transaction);
            if (iWXAPIEventHandler != null) {
                iWXAPIEventHandler.onResp(baseResp);
                concurrentHashMap2 = this.eOb.eNY;
                concurrentHashMap2.remove(baseResp.transaction);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
