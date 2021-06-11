package com.baidu.wallet.paysdk.precashier.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayOtherBean;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class PrecashierDefaultPayTypeBean extends PayOtherBean<String> {

    /* renamed from: a  reason: collision with root package name */
    public String f25464a;

    public PrecashierDefaultPayTypeBean(Context context) {
        super(context);
    }

    private List<RestNameValuePair> a(List<RestNameValuePair> list, JSONObject jSONObject) {
        JSONArray names;
        Object obj;
        if (jSONObject != null && (names = jSONObject.names()) != null && names.length() > 0) {
            for (int i2 = 0; i2 < names.length(); i2++) {
                try {
                    Object obj2 = names.get(i2);
                    if (obj2 != null && (obj2 instanceof String)) {
                        String str = (String) obj2;
                        if (!TextUtils.isEmpty(str) && (obj = jSONObject.get(str)) != null) {
                            if (obj instanceof JSONObject) {
                                a(list, (JSONObject) obj);
                            } else {
                                list.add(new RestNameValuePair(str, obj.toString()));
                            }
                        }
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return list;
    }

    @Override // com.baidu.wallet.paysdk.beans.PayOtherBean, com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(String.class);
    }

    @Override // com.baidu.wallet.paysdk.beans.PayOtherBean, com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        if (this.f25464a == null) {
            return arrayList;
        }
        try {
            a(arrayList, new JSONObject(this.f25464a));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    @Override // com.baidu.wallet.paysdk.beans.PayOtherBean, com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return 1;
    }

    @Override // com.baidu.wallet.paysdk.beans.PayOtherBean, com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_PRECASHIER_DEFAULT_PAY_TYPE;
    }

    @Override // com.baidu.wallet.paysdk.beans.PayOtherBean, com.baidu.wallet.core.beans.NetworkBean
    public boolean needNonce() {
        return false;
    }

    public void setParams(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f25464a = str;
    }
}
