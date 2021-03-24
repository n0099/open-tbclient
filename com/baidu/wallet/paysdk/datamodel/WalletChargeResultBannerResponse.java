package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import com.baidu.apollon.beans.IBeanResponse;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class WalletChargeResultBannerResponse implements IBeanResponse {
    public AdBanner banner;

    /* loaded from: classes5.dex */
    public static class AdBanner implements Serializable {
        public static final long serialVersionUID = 7726493729744741618L;
        public String imgUrl;
        public String linkUrl;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return true;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
