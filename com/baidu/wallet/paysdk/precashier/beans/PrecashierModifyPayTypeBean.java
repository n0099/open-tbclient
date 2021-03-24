package com.baidu.wallet.paysdk.precashier.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBaseBean;
import com.baidu.wallet.paysdk.datamodel.PrecashierModifyPayTypeResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class PrecashierModifyPayTypeBean extends PayBaseBean<PrecashierModifyPayTypeResponse> {
    public Map<String, String> rec_params;

    public PrecashierModifyPayTypeBean(Context context) {
        super(context);
    }

    public boolean checkRequestParamsAvalable() {
        Map<String, String> map = this.rec_params;
        return (map == null || map.size() <= 0 || TextUtils.isEmpty(this.rec_params.get(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID)) || TextUtils.isEmpty("serial_num")) ? false : true;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(PrecashierModifyPayTypeResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        if (checkRequestParamsAvalable()) {
            ArrayList arrayList = new ArrayList();
            Map<String, String> map = this.rec_params;
            if (map != null && map.size() > 0) {
                Iterator<Map.Entry<String, String>> it = this.rec_params.entrySet().iterator();
                while (it != null && it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    if (next != null) {
                        String key = next.getKey();
                        String value = next.getValue();
                        if (key != null && (key instanceof String) && value != null) {
                            arrayList.add(new RestNameValuePair(key, value.toString()));
                        }
                    }
                }
            }
            return arrayList;
        }
        return null;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return 2;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_PRECASHIER_MODIFY_PAY_TYPE;
    }
}
