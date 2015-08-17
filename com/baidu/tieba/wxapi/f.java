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
    private static f cVv = null;
    private IWXAPIEventHandler cVy;
    private IWXAPIEventHandler cVz = new g(this);
    private IWXAPI cVw = WXAPIFactory.createWXAPI(TbadkApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID, false);
    private ConcurrentHashMap<String, IWXAPIEventHandler> cVx = new ConcurrentHashMap<>();

    public static f avs() {
        if (cVv == null) {
            cVv = new f();
        }
        return cVv;
    }

    private f() {
        if (isAvailable()) {
            this.cVw.registerApp(TbConfig.WEIXIN_SHARE_APP_ID);
        }
    }

    public boolean isAvailable() {
        return this.cVw.isWXAppInstalled() && this.cVw.isWXAppSupportAPI();
    }

    public void Z(Intent intent) {
        this.cVw.handleIntent(intent, this.cVz);
    }
}
