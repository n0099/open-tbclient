package com.baidu.wallet.personal.datamodel;

import android.content.Context;
import com.baidu.apollon.beans.IBeanResponse;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class ApplyCouponResponse implements IBeanResponse, Serializable {
    public int card_typ;
    public String coupon_expire_time;
    public String coupon_num;
    public String template_num;

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return true;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
