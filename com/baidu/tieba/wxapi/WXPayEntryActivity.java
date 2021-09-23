package com.baidu.tieba.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import c.a.q0.p0.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.channelpay.wxpay.ChannelWXPay;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IWXAPI api;

    public WXPayEntryActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            this.api = WXAPIFactory.createWXAPI(this, TbConfig.WEIXIN_APP_ID);
            if (getIntent() != null) {
                this.api.handleIntent(getIntent(), this);
            }
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent) == null) {
            super.onNewIntent(intent);
            setIntent(intent);
            if (intent != null) {
                this.api.handleIntent(intent, this);
            }
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, baseReq) == null) {
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, baseResp) == null) && baseResp.getType() == 5) {
            ChannelWXPay.getInstance().handlerPayResult(this, baseResp);
            String str = null;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, baseResp.errCode);
                jSONObject.put("responseData", baseResp.errStr);
                str = jSONObject.toString();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            e eVar = new e();
            eVar.f13648g = true;
            eVar.f13643b = baseResp.getType();
            eVar.f13644c = str;
            Intent intent = new Intent("WXPayResult");
            intent.putExtra("errorCode", baseResp.errCode);
            intent.putExtra("errorMsg", baseResp.errStr);
            TbadkCoreApplication.getInst().sendBroadcast(intent);
            finish();
        }
    }
}
