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
    private static g fKp = null;
    private IWXAPIEventHandler fKs;
    private IWXAPIEventHandler fKt = new h(this);
    private IWXAPI fKq = WXAPIFactory.createWXAPI(TbadkApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID, false);
    private ConcurrentHashMap<String, IWXAPIEventHandler> fKr = new ConcurrentHashMap<>();

    public static g bmJ() {
        if (fKp == null) {
            synchronized (g.class) {
                if (fKp == null) {
                    fKp = new g();
                }
            }
        }
        return fKp;
    }

    private g() {
        if (isAvailable()) {
            this.fKq.registerApp(TbConfig.WEIXIN_SHARE_APP_ID);
        }
    }

    public boolean isAvailable() {
        return this.fKq.isWXAppInstalled() && this.fKq.isWXAppSupportAPI();
    }

    public void J(Intent intent) {
        this.fKq.handleIntent(intent, this.fKt);
    }
}
