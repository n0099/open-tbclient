package com.baidu.tieba.wxapi;

import android.content.Intent;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class f {
    private static f eNW = null;
    private IWXAPIEventHandler eNZ;
    private IWXAPIEventHandler eOa = new g(this);
    private IWXAPI eNX = WXAPIFactory.createWXAPI(TbadkApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID, false);
    private ConcurrentHashMap<String, IWXAPIEventHandler> eNY = new ConcurrentHashMap<>();

    public static f bbP() {
        if (eNW == null) {
            synchronized (f.class) {
                if (eNW == null) {
                    eNW = new f();
                }
            }
        }
        return eNW;
    }

    private f() {
        if (isAvailable()) {
            this.eNX.registerApp(TbConfig.WEIXIN_SHARE_APP_ID);
        }
    }

    public boolean isAvailable() {
        return this.eNX.isWXAppInstalled() && this.eNX.isWXAppSupportAPI();
    }

    public void D(Intent intent) {
        this.eNX.handleIntent(intent, this.eOa);
    }
}
