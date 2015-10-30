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
    private static f dqV = null;
    private IWXAPIEventHandler dqY;
    private IWXAPIEventHandler dqZ = new g(this);
    private IWXAPI dqW = WXAPIFactory.createWXAPI(TbadkApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID, false);
    private ConcurrentHashMap<String, IWXAPIEventHandler> dqX = new ConcurrentHashMap<>();

    public static f aDJ() {
        if (dqV == null) {
            dqV = new f();
        }
        return dqV;
    }

    private f() {
        if (isAvailable()) {
            this.dqW.registerApp(TbConfig.WEIXIN_SHARE_APP_ID);
        }
    }

    public boolean isAvailable() {
        return this.dqW.isWXAppInstalled() && this.dqW.isWXAppSupportAPI();
    }

    public void ad(Intent intent) {
        this.dqW.handleIntent(intent, this.dqZ);
    }
}
