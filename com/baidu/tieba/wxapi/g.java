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
    private static g gni = null;
    private IWXAPIEventHandler gnl;
    private IWXAPIEventHandler gnm = new h(this);
    private IWXAPI gnj = WXAPIFactory.createWXAPI(TbadkApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID, false);
    private ConcurrentHashMap<String, IWXAPIEventHandler> gnk = new ConcurrentHashMap<>();

    public static g bvd() {
        if (gni == null) {
            synchronized (g.class) {
                if (gni == null) {
                    gni = new g();
                }
            }
        }
        return gni;
    }

    private g() {
        if (isAvailable()) {
            this.gnj.registerApp(TbConfig.WEIXIN_SHARE_APP_ID);
        }
    }

    public boolean isAvailable() {
        return this.gnj.isWXAppInstalled() && this.gnj.isWXAppSupportAPI();
    }

    public void ai(Intent intent) {
        this.gnj.handleIntent(intent, this.gnm);
    }
}
