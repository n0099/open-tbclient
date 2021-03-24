package com.baidu.wallet.fastpay.datamodel;

import android.content.Context;
import com.baidu.apollon.beans.IBeanResponse;
/* loaded from: classes5.dex */
public class PromotionInfoResponse implements IBeanResponse {
    public MoreServiceItemInfo[] additional_services;
    public String customer_service_copy;
    public String customer_service_icon;
    public String customer_service_url;
    public MenuItemInfo[] help_menu;
    public int link_type;
    public BannerChargeItemInfo[] promotion_banner;
    public String promotion_bigimg_url;
    public String promotion_desc;
    public String promotion_detail_url;
    public String promotion_img_url;
    public String promotion_txt;
    public int promotion_type;

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return true;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }

    public String toString() {
        return "PromotionInfoResponse [promotion_img_url=" + this.promotion_img_url + ", promotion_txt=" + this.promotion_txt + ", promotion_desc=" + this.promotion_desc + ", promotion_detail_url=" + this.promotion_detail_url + ", promotion_bigimg_url=" + this.promotion_bigimg_url + "]";
    }
}
