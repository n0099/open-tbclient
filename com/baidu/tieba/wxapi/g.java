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
    private static g fRt = null;
    private IWXAPIEventHandler fRw;
    private IWXAPIEventHandler fRx = new h(this);
    private IWXAPI fRu = WXAPIFactory.createWXAPI(TbadkApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID, false);
    private ConcurrentHashMap<String, IWXAPIEventHandler> fRv = new ConcurrentHashMap<>();

    public static g bpc() {
        if (fRt == null) {
            synchronized (g.class) {
                if (fRt == null) {
                    fRt = new g();
                }
            }
        }
        return fRt;
    }

    private g() {
        if (isAvailable()) {
            this.fRu.registerApp(TbConfig.WEIXIN_SHARE_APP_ID);
        }
    }

    public boolean isAvailable() {
        return this.fRu.isWXAppInstalled() && this.fRu.isWXAppSupportAPI();
    }

    public void ac(Intent intent) {
        this.fRu.handleIntent(intent, this.fRx);
    }
}
