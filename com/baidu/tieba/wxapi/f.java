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
    private static f dqv = null;
    private IWXAPIEventHandler dqy;
    private IWXAPIEventHandler dqz = new g(this);
    private IWXAPI dqw = WXAPIFactory.createWXAPI(TbadkApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID, false);
    private ConcurrentHashMap<String, IWXAPIEventHandler> dqx = new ConcurrentHashMap<>();

    public static f aDD() {
        if (dqv == null) {
            dqv = new f();
        }
        return dqv;
    }

    private f() {
        if (isAvailable()) {
            this.dqw.registerApp(TbConfig.WEIXIN_SHARE_APP_ID);
        }
    }

    public boolean isAvailable() {
        return this.dqw.isWXAppInstalled() && this.dqw.isWXAppSupportAPI();
    }

    public void ad(Intent intent) {
        this.dqw.handleIntent(intent, this.dqz);
    }
}
