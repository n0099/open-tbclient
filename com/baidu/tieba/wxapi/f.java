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
    private static f dez = null;
    private IWXAPIEventHandler deC;
    private IWXAPIEventHandler deD = new g(this);
    private IWXAPI deA = WXAPIFactory.createWXAPI(TbadkApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID, false);
    private ConcurrentHashMap<String, IWXAPIEventHandler> deB = new ConcurrentHashMap<>();

    public static f azY() {
        if (dez == null) {
            dez = new f();
        }
        return dez;
    }

    private f() {
        if (isAvailable()) {
            this.deA.registerApp(TbConfig.WEIXIN_SHARE_APP_ID);
        }
    }

    public boolean isAvailable() {
        return this.deA.isWXAppInstalled() && this.deA.isWXAppSupportAPI();
    }

    public void ad(Intent intent) {
        this.deA.handleIntent(intent, this.deD);
    }
}
