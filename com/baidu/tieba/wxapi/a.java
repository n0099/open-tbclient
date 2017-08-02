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
    private static a gHe = null;
    private IWXAPIEventHandler gHh;
    private IWXAPIEventHandler gHi = new IWXAPIEventHandler() { // from class: com.baidu.tieba.wxapi.a.1
        @Override // com.tencent.mm.sdk.openapi.IWXAPIEventHandler
        public void onReq(BaseReq baseReq) {
            if (a.this.gHh != null) {
                a.this.gHh.onReq(baseReq);
            }
        }

        @Override // com.tencent.mm.sdk.openapi.IWXAPIEventHandler
        public void onResp(BaseResp baseResp) {
            try {
                IWXAPIEventHandler iWXAPIEventHandler = (IWXAPIEventHandler) a.this.gHg.get(baseResp.transaction);
                if (iWXAPIEventHandler != null) {
                    iWXAPIEventHandler.onResp(baseResp);
                    a.this.gHg.remove(baseResp.transaction);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private IWXAPI gHf = WXAPIFactory.createWXAPI(TbadkApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID, false);
    private ConcurrentHashMap<String, IWXAPIEventHandler> gHg = new ConcurrentHashMap<>();

    public static a bAL() {
        if (gHe == null) {
            synchronized (a.class) {
                if (gHe == null) {
                    gHe = new a();
                }
            }
        }
        return gHe;
    }

    private a() {
        if (isAvailable()) {
            this.gHf.registerApp(TbConfig.WEIXIN_SHARE_APP_ID);
        }
    }

    public boolean isAvailable() {
        return this.gHf.isWXAppInstalled() && this.gHf.isWXAppSupportAPI();
    }

    public void ak(Intent intent) {
        this.gHf.handleIntent(intent, this.gHi);
    }
}
