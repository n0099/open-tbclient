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
    private static g gck = null;
    private IWXAPIEventHandler gcn;
    private IWXAPIEventHandler gco = new h(this);
    private IWXAPI gcl = WXAPIFactory.createWXAPI(TbadkApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID, false);
    private ConcurrentHashMap<String, IWXAPIEventHandler> gcm = new ConcurrentHashMap<>();

    public static g bqC() {
        if (gck == null) {
            synchronized (g.class) {
                if (gck == null) {
                    gck = new g();
                }
            }
        }
        return gck;
    }

    private g() {
        if (isAvailable()) {
            this.gcl.registerApp(TbConfig.WEIXIN_SHARE_APP_ID);
        }
    }

    public boolean isAvailable() {
        return this.gcl.isWXAppInstalled() && this.gcl.isWXAppSupportAPI();
    }

    public void ag(Intent intent) {
        this.gcl.handleIntent(intent, this.gco);
    }
}
