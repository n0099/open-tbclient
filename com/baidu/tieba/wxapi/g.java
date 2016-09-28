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
    private static g giw = null;
    private IWXAPIEventHandler giA = new h(this);
    private IWXAPI gix = WXAPIFactory.createWXAPI(TbadkApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID, false);
    private ConcurrentHashMap<String, IWXAPIEventHandler> giy = new ConcurrentHashMap<>();
    private IWXAPIEventHandler giz;

    public static g buy() {
        if (giw == null) {
            synchronized (g.class) {
                if (giw == null) {
                    giw = new g();
                }
            }
        }
        return giw;
    }

    private g() {
        if (isAvailable()) {
            this.gix.registerApp(TbConfig.WEIXIN_SHARE_APP_ID);
        }
    }

    public boolean isAvailable() {
        return this.gix.isWXAppInstalled() && this.gix.isWXAppSupportAPI();
    }

    public void I(Intent intent) {
        this.gix.handleIntent(intent, this.giA);
    }
}
