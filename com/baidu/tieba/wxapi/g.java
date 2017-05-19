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
    private static g fTI = null;
    private IWXAPIEventHandler fTL;
    private IWXAPIEventHandler fTM = new h(this);
    private IWXAPI fTJ = WXAPIFactory.createWXAPI(TbadkApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID, false);
    private ConcurrentHashMap<String, IWXAPIEventHandler> fTK = new ConcurrentHashMap<>();

    public static g boP() {
        if (fTI == null) {
            synchronized (g.class) {
                if (fTI == null) {
                    fTI = new g();
                }
            }
        }
        return fTI;
    }

    private g() {
        if (isAvailable()) {
            this.fTJ.registerApp(TbConfig.WEIXIN_SHARE_APP_ID);
        }
    }

    public boolean isAvailable() {
        return this.fTJ.isWXAppInstalled() && this.fTJ.isWXAppSupportAPI();
    }

    public void af(Intent intent) {
        this.fTJ.handleIntent(intent, this.fTM);
    }
}
