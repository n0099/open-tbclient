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
    private static f feT = null;
    private IWXAPIEventHandler feW;
    private IWXAPIEventHandler feX = new g(this);
    private IWXAPI feU = WXAPIFactory.createWXAPI(TbadkApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID, false);
    private ConcurrentHashMap<String, IWXAPIEventHandler> feV = new ConcurrentHashMap<>();

    public static f beo() {
        if (feT == null) {
            synchronized (f.class) {
                if (feT == null) {
                    feT = new f();
                }
            }
        }
        return feT;
    }

    private f() {
        if (isAvailable()) {
            this.feU.registerApp(TbConfig.WEIXIN_SHARE_APP_ID);
        }
    }

    public boolean isAvailable() {
        return this.feU.isWXAppInstalled() && this.feU.isWXAppSupportAPI();
    }

    public void G(Intent intent) {
        this.feU.handleIntent(intent, this.feX);
    }
}
