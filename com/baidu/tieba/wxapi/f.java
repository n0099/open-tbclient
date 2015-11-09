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
    private static f dsN = null;
    private IWXAPIEventHandler dsQ;
    private IWXAPIEventHandler dsR = new g(this);
    private IWXAPI dsO = WXAPIFactory.createWXAPI(TbadkApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID, false);
    private ConcurrentHashMap<String, IWXAPIEventHandler> dsP = new ConcurrentHashMap<>();

    public static f aED() {
        if (dsN == null) {
            dsN = new f();
        }
        return dsN;
    }

    private f() {
        if (isAvailable()) {
            this.dsO.registerApp(TbConfig.WEIXIN_SHARE_APP_ID);
        }
    }

    public boolean isAvailable() {
        return this.dsO.isWXAppInstalled() && this.dsO.isWXAppSupportAPI();
    }

    public void ad(Intent intent) {
        this.dsO.handleIntent(intent, this.dsR);
    }
}
