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
    private static g fVz = null;
    private IWXAPIEventHandler fVC;
    private IWXAPIEventHandler fVD = new h(this);
    private IWXAPI fVA = WXAPIFactory.createWXAPI(TbadkApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID, false);
    private ConcurrentHashMap<String, IWXAPIEventHandler> fVB = new ConcurrentHashMap<>();

    public static g bqL() {
        if (fVz == null) {
            synchronized (g.class) {
                if (fVz == null) {
                    fVz = new g();
                }
            }
        }
        return fVz;
    }

    private g() {
        if (isAvailable()) {
            this.fVA.registerApp(TbConfig.WEIXIN_SHARE_APP_ID);
        }
    }

    public boolean isAvailable() {
        return this.fVA.isWXAppInstalled() && this.fVA.isWXAppSupportAPI();
    }

    public void ad(Intent intent) {
        this.fVA.handleIntent(intent, this.fVD);
    }
}
