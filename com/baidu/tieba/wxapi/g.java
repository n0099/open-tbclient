package com.baidu.tieba.wxapi;

import android.content.Intent;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class g {
    private static g fEF = null;
    private IWXAPIEventHandler fEI;
    private IWXAPIEventHandler fEJ = new h(this);
    private IWXAPI fEG = WXAPIFactory.createWXAPI(TbadkApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID, false);
    private ConcurrentHashMap<String, IWXAPIEventHandler> fEH = new ConcurrentHashMap<>();

    public static g bnQ() {
        if (fEF == null) {
            synchronized (g.class) {
                if (fEF == null) {
                    fEF = new g();
                }
            }
        }
        return fEF;
    }

    private g() {
        if (isAvailable()) {
            this.fEG.registerApp(TbConfig.WEIXIN_SHARE_APP_ID);
        }
    }

    public boolean isAvailable() {
        return this.fEG.isWXAppInstalled() && this.fEG.isWXAppSupportAPI();
    }

    public void G(Intent intent) {
        this.fEG.handleIntent(intent, this.fEJ);
    }
}
