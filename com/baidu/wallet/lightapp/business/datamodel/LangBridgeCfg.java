package com.baidu.wallet.lightapp.business.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.lightapp.business.b;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class LangBridgeCfg implements IBeanResponse {
    public LbConfig lbconfig;

    /* loaded from: classes5.dex */
    public static class LbConfig implements NoProguard, Serializable {
        public String[] domains;
        public String fingerprint;
        public long interval;
        public String[] packages;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        LbConfig lbConfig = this.lbconfig;
        return (lbConfig == null || TextUtils.isEmpty(lbConfig.fingerprint)) ? false : true;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
        b.a().a(context, this);
    }
}
