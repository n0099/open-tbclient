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
    private static a gKh = null;
    private IWXAPIEventHandler gKk;
    private IWXAPIEventHandler gKl = new IWXAPIEventHandler() { // from class: com.baidu.tieba.wxapi.a.1
        @Override // com.tencent.mm.sdk.openapi.IWXAPIEventHandler
        public void onReq(BaseReq baseReq) {
            if (a.this.gKk != null) {
                a.this.gKk.onReq(baseReq);
            }
        }

        @Override // com.tencent.mm.sdk.openapi.IWXAPIEventHandler
        public void onResp(BaseResp baseResp) {
            try {
                IWXAPIEventHandler iWXAPIEventHandler = (IWXAPIEventHandler) a.this.gKj.get(baseResp.transaction);
                if (iWXAPIEventHandler != null) {
                    iWXAPIEventHandler.onResp(baseResp);
                    a.this.gKj.remove(baseResp.transaction);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private IWXAPI gKi = WXAPIFactory.createWXAPI(TbadkApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID, false);
    private ConcurrentHashMap<String, IWXAPIEventHandler> gKj = new ConcurrentHashMap<>();

    public static a bBr() {
        if (gKh == null) {
            synchronized (a.class) {
                if (gKh == null) {
                    gKh = new a();
                }
            }
        }
        return gKh;
    }

    private a() {
        if (isAvailable()) {
            this.gKi.registerApp(TbConfig.WEIXIN_SHARE_APP_ID);
        }
    }

    public boolean isAvailable() {
        return this.gKi.isWXAppInstalled() && this.gKi.isWXAppSupportAPI();
    }

    public void am(Intent intent) {
        this.gKi.handleIntent(intent, this.gKl);
    }
}
