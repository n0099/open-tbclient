package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.base.datamodel.UserData;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class CardAddResponse extends DirectPayContentResponse {
    public int bind_card_num;
    public ConfirmWindow confirm_window;
    public CustomerSvcCfg intelligent_service;
    public int request_type;

    /* loaded from: classes5.dex */
    public static class ConfirmWindow implements Serializable {
        public String btn_name;
        public String content;
        public String title;
    }

    /* loaded from: classes5.dex */
    public static class CustomerSvcCfg implements Serializable {
        public String customer_service_url = "";
        public String customer_service_copy = "";
        public String customer_service_icon = "";
    }

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static CardAddResponse f25548a = new CardAddResponse();
    }

    public static CardAddResponse getInstance() {
        return a.f25548a;
    }

    public static void updateContent(Object obj) {
        if (obj instanceof CardAddResponse) {
            CardAddResponse unused = a.f25548a = (CardAddResponse) obj;
        }
    }

    @Override // com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse, com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        if (super.checkResponseValidity()) {
            return !TextUtils.isEmpty(this.intelligent_service.customer_service_icon);
        }
        return false;
    }

    @Override // com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse
    public boolean hasBindCards() {
        return this.bind_card_num > 0;
    }

    @Override // com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse, com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
        UserData.UserModel userModel = this.user;
        if (userModel != null) {
            userModel.decrypt();
        }
        super.storeResponse(context);
    }
}
