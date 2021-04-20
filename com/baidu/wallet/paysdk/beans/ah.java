package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.datamodel.VerifyCodeResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class ah extends PayBaseBean<VerifyCodeResponse> {

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.wallet.paysdk.datamodel.d f25180a;

    public ah(Context context) {
        super(context);
        this.f25180a = (com.baidu.wallet.paysdk.datamodel.d) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_VERIFY_CODE);
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(VerifyCodeResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("mobile", this.f25180a.f25267a));
        arrayList.add(new RestNameValuePair(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, this.f25180a.f25268b));
        arrayList.add(new RestNameValuePair("order_no", this.f25180a.f25269c));
        arrayList.add(new RestNameValuePair("pay_type", this.f25180a.f25270d));
        if (!TextUtils.isEmpty(PayDataCache.getInstance().getPaySessionInfo())) {
            arrayList.add(new RestNameValuePair("session_info", PayDataCache.getInstance().getPaySessionInfo()));
        }
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return 9;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_REQUEST_SMS_CODE;
    }
}
