package com.baidu.tieba.wxapi;

import android.content.Intent;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private static a gIp = null;
    private IWXAPIEventHandler gIs;
    private IWXAPIEventHandler gIt = new IWXAPIEventHandler() { // from class: com.baidu.tieba.wxapi.a.1
        @Override // com.tencent.mm.sdk.openapi.IWXAPIEventHandler
        public void onReq(BaseReq baseReq) {
            if (a.this.gIs != null) {
                a.this.gIs.onReq(baseReq);
            }
        }

        @Override // com.tencent.mm.sdk.openapi.IWXAPIEventHandler
        public void onResp(BaseResp baseResp) {
            try {
                IWXAPIEventHandler iWXAPIEventHandler = (IWXAPIEventHandler) a.this.gIr.get(baseResp.transaction);
                if (iWXAPIEventHandler != null) {
                    iWXAPIEventHandler.onResp(baseResp);
                    a.this.gIr.remove(baseResp.transaction);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private IWXAPI gIq = WXAPIFactory.createWXAPI(TbadkApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID, false);
    private ConcurrentHashMap<String, IWXAPIEventHandler> gIr = new ConcurrentHashMap<>();

    public static a bAS() {
        if (gIp == null) {
            synchronized (a.class) {
                if (gIp == null) {
                    gIp = new a();
                }
            }
        }
        return gIp;
    }

    private a() {
        if (isAvailable()) {
            this.gIq.registerApp(TbConfig.WEIXIN_SHARE_APP_ID);
        }
    }

    public boolean isAvailable() {
        return this.gIq.isWXAppInstalled() && this.gIq.isWXAppSupportAPI();
    }

    public void ak(Intent intent) {
        this.gIq.handleIntent(intent, this.gIt);
    }
}
