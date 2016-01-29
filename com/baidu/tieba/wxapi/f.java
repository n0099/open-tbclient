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
    private static f euf = null;
    private IWXAPIEventHandler eui;
    private IWXAPIEventHandler euj = new g(this);
    private IWXAPI eug = WXAPIFactory.createWXAPI(TbadkApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID, false);
    private ConcurrentHashMap<String, IWXAPIEventHandler> euh = new ConcurrentHashMap<>();

    public static f aVp() {
        if (euf == null) {
            euf = new f();
        }
        return euf;
    }

    private f() {
        if (isAvailable()) {
            this.eug.registerApp(TbConfig.WEIXIN_SHARE_APP_ID);
        }
    }

    public boolean isAvailable() {
        return this.eug.isWXAppInstalled() && this.eug.isWXAppSupportAPI();
    }

    public void af(Intent intent) {
        this.eug.handleIntent(intent, this.euj);
    }
}
