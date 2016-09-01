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
    private static g ggl = null;
    private IWXAPIEventHandler ggo;
    private IWXAPIEventHandler ggp = new h(this);
    private IWXAPI ggm = WXAPIFactory.createWXAPI(TbadkApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID, false);
    private ConcurrentHashMap<String, IWXAPIEventHandler> ggn = new ConcurrentHashMap<>();

    public static g btS() {
        if (ggl == null) {
            synchronized (g.class) {
                if (ggl == null) {
                    ggl = new g();
                }
            }
        }
        return ggl;
    }

    private g() {
        if (isAvailable()) {
            this.ggm.registerApp(TbConfig.WEIXIN_SHARE_APP_ID);
        }
    }

    public boolean isAvailable() {
        return this.ggm.isWXAppInstalled() && this.ggm.isWXAppSupportAPI();
    }

    public void K(Intent intent) {
        this.ggm.handleIntent(intent, this.ggp);
    }
}
