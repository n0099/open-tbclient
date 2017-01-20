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
    private static g fMY = null;
    private IWXAPIEventHandler fNb;
    private IWXAPIEventHandler fNc = new h(this);
    private IWXAPI fMZ = WXAPIFactory.createWXAPI(TbadkApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID, false);
    private ConcurrentHashMap<String, IWXAPIEventHandler> fNa = new ConcurrentHashMap<>();

    public static g bpo() {
        if (fMY == null) {
            synchronized (g.class) {
                if (fMY == null) {
                    fMY = new g();
                }
            }
        }
        return fMY;
    }

    private g() {
        if (isAvailable()) {
            this.fMZ.registerApp(TbConfig.WEIXIN_SHARE_APP_ID);
        }
    }

    public boolean isAvailable() {
        return this.fMZ.isWXAppInstalled() && this.fMZ.isWXAppSupportAPI();
    }

    public void G(Intent intent) {
        this.fMZ.handleIntent(intent, this.fNc);
    }
}
