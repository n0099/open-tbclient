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
    private static f dRS = null;
    private IWXAPIEventHandler dRV;
    private IWXAPIEventHandler dRW = new g(this);
    private IWXAPI dRT = WXAPIFactory.createWXAPI(TbadkApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID, false);
    private ConcurrentHashMap<String, IWXAPIEventHandler> dRU = new ConcurrentHashMap<>();

    public static f aKa() {
        if (dRS == null) {
            dRS = new f();
        }
        return dRS;
    }

    private f() {
        if (isAvailable()) {
            this.dRT.registerApp(TbConfig.WEIXIN_SHARE_APP_ID);
        }
    }

    public boolean isAvailable() {
        return this.dRT.isWXAppInstalled() && this.dRT.isWXAppSupportAPI();
    }

    public void ad(Intent intent) {
        this.dRT.handleIntent(intent, this.dRW);
    }
}
