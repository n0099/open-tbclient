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
    private static g gqh = null;
    private IWXAPIEventHandler gqk;
    private IWXAPIEventHandler gql = new h(this);
    private IWXAPI gqi = WXAPIFactory.createWXAPI(TbadkApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID, false);
    private ConcurrentHashMap<String, IWXAPIEventHandler> gqj = new ConcurrentHashMap<>();

    public static g bwR() {
        if (gqh == null) {
            synchronized (g.class) {
                if (gqh == null) {
                    gqh = new g();
                }
            }
        }
        return gqh;
    }

    private g() {
        if (isAvailable()) {
            this.gqi.registerApp(TbConfig.WEIXIN_SHARE_APP_ID);
        }
    }

    public boolean isAvailable() {
        return this.gqi.isWXAppInstalled() && this.gqi.isWXAppSupportAPI();
    }

    public void G(Intent intent) {
        this.gqi.handleIntent(intent, this.gql);
    }
}
