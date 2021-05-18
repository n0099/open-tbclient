package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.base.datamodel.UserData;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class PrecashierModifyPayTypeResponse extends DirectPayContentResponse implements IBeanResponse, Serializable {
    public static final long serialVersionUID = -936968920336557051L;
    public String mOriginHttpResponse;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static PrecashierModifyPayTypeResponse f25272a = new PrecashierModifyPayTypeResponse();
    }

    public static PrecashierModifyPayTypeResponse getInstance() {
        return a.f25272a;
    }

    public static void updateContent(Object obj) {
        if (obj instanceof PrecashierModifyPayTypeResponse) {
            PrecashierModifyPayTypeResponse unused = a.f25272a = (PrecashierModifyPayTypeResponse) obj;
        } else if (obj == null) {
            PrecashierModifyPayTypeResponse unused2 = a.f25272a = null;
        }
    }

    @Override // com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse, com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return (this.pay == null && this.sp == null && this.user == null) ? false : true;
    }

    public void decrypt() {
        PayData.EasyPay easyPay;
        UserData.UserModel userModel = this.user;
        if (userModel != null) {
            userModel.decrypt();
        }
        PayData.DirectPayPay directPayPay = this.pay;
        if (directPayPay == null || (easyPay = directPayPay.easypay) == null) {
            return;
        }
        easyPay.decrypt();
    }

    public String getOriginHttpResponse() {
        return this.mOriginHttpResponse;
    }

    public void setOriginHttpResponse(String str) {
        this.mOriginHttpResponse = str;
    }

    @Override // com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse, com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
        decrypt();
        updateContent(this);
        PayDataCache.getInstance().setPayResponse(this);
        PayDataCache.getInstance().setFromPreCashier();
    }
}
