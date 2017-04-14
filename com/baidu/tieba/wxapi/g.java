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
    private static g fTd = null;
    private IWXAPIEventHandler fTg;
    private IWXAPIEventHandler fTh = new h(this);
    private IWXAPI fTe = WXAPIFactory.createWXAPI(TbadkApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID, false);
    private ConcurrentHashMap<String, IWXAPIEventHandler> fTf = new ConcurrentHashMap<>();

    public static g bpK() {
        if (fTd == null) {
            synchronized (g.class) {
                if (fTd == null) {
                    fTd = new g();
                }
            }
        }
        return fTd;
    }

    private g() {
        if (isAvailable()) {
            this.fTe.registerApp(TbConfig.WEIXIN_SHARE_APP_ID);
        }
    }

    public boolean isAvailable() {
        return this.fTe.isWXAppInstalled() && this.fTe.isWXAppSupportAPI();
    }

    public void ac(Intent intent) {
        this.fTe.handleIntent(intent, this.fTh);
    }
}
