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
    private static g fWg = null;
    private IWXAPIEventHandler fWj;
    private IWXAPIEventHandler fWk = new h(this);
    private IWXAPI fWh = WXAPIFactory.createWXAPI(TbadkApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID, false);
    private ConcurrentHashMap<String, IWXAPIEventHandler> fWi = new ConcurrentHashMap<>();

    public static g bpD() {
        if (fWg == null) {
            synchronized (g.class) {
                if (fWg == null) {
                    fWg = new g();
                }
            }
        }
        return fWg;
    }

    private g() {
        if (isAvailable()) {
            this.fWh.registerApp(TbConfig.WEIXIN_SHARE_APP_ID);
        }
    }

    public boolean isAvailable() {
        return this.fWh.isWXAppInstalled() && this.fWh.isWXAppSupportAPI();
    }

    public void K(Intent intent) {
        this.fWh.handleIntent(intent, this.fWk);
    }
}
