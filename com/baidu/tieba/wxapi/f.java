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
    private static f feU = null;
    private IWXAPIEventHandler feX;
    private IWXAPIEventHandler feY = new g(this);
    private IWXAPI feV = WXAPIFactory.createWXAPI(TbadkApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID, false);
    private ConcurrentHashMap<String, IWXAPIEventHandler> feW = new ConcurrentHashMap<>();

    public static f beh() {
        if (feU == null) {
            synchronized (f.class) {
                if (feU == null) {
                    feU = new f();
                }
            }
        }
        return feU;
    }

    private f() {
        if (isAvailable()) {
            this.feV.registerApp(TbConfig.WEIXIN_SHARE_APP_ID);
        }
    }

    public boolean isAvailable() {
        return this.feV.isWXAppInstalled() && this.feV.isWXAppSupportAPI();
    }

    public void G(Intent intent) {
        this.feV.handleIntent(intent, this.feY);
    }
}
