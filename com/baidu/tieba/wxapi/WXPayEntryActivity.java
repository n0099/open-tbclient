package com.baidu.tieba.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.android.lbspay.channelpay.wxpay.ChannelWXPay;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import d.b.i0.l0.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {
    public IWXAPI api;

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.api = WXAPIFactory.createWXAPI(this, TbConfig.WEIXIN_APP_ID);
        if (getIntent() != null) {
            this.api.handleIntent(getIntent(), this);
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (intent != null) {
            this.api.handleIntent(intent, this);
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        if (baseResp.getType() == 5) {
            ChannelWXPay.getInstance().handlerPayResult(this, baseResp);
            String str = null;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("statusCode", baseResp.errCode);
                jSONObject.put("responseData", baseResp.errStr);
                str = jSONObject.toString();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            d dVar = new d();
            dVar.f51046g = true;
            dVar.f51041b = baseResp.getType();
            dVar.f51042c = str;
            Intent intent = new Intent("WXPayResult");
            intent.putExtra("errorCode", baseResp.errCode);
            intent.putExtra("errorMsg", baseResp.errStr);
            TbadkCoreApplication.getInst().sendBroadcast(intent);
            finish();
        }
    }
}
