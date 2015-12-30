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
    private static f dZq = null;
    private IWXAPIEventHandler dZt;
    private IWXAPIEventHandler dZu = new g(this);
    private IWXAPI dZr = WXAPIFactory.createWXAPI(TbadkApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID, false);
    private ConcurrentHashMap<String, IWXAPIEventHandler> dZs = new ConcurrentHashMap<>();

    public static f aMv() {
        if (dZq == null) {
            dZq = new f();
        }
        return dZq;
    }

    private f() {
        if (isAvailable()) {
            this.dZr.registerApp(TbConfig.WEIXIN_SHARE_APP_ID);
        }
    }

    public boolean isAvailable() {
        return this.dZr.isWXAppInstalled() && this.dZr.isWXAppSupportAPI();
    }

    public void ac(Intent intent) {
        this.dZr.handleIntent(intent, this.dZu);
    }
}
