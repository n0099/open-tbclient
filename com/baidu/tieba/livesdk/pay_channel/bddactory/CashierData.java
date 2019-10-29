package com.baidu.tieba.livesdk.pay_channel.bddactory;

import java.io.Serializable;
import java.util.Map;
/* loaded from: classes6.dex */
public class CashierData implements Serializable {
    public static final String CUSTOMER_ID = "customerId";
    public static final String DEFAULT_RES_PAGE = "defaultResPage";
    public static final String DEVICE_TYPE = "deviceType";
    public static final String EXT_DATA = "extData";
    public static final String IMIE = "imei";
    public static final String ITEM_INFO = "itemInfo";
    public static final String MOBILE = "mobile";
    public static final String NOTIFY_URL = "notifyUrl";
    public static final String ORDERID = "orderId";
    public static final String ORDER_CREATE_TIME = "orderCreateTime";
    public static final String ORIGINALAMOUNT_AMOUNT = "originalAmount";
    public static final String PASS_UID = "passuid";
    public static final String PAY_AMOUNT = "payAmount";
    public static final String RETURN_URL = "returnUrl";
    public static final String SDK = "sdk";
    public static final String SDK_STYLE = "sdkStyle";
    public static final String SERVICE = "service";
    public static final String SIGN = "sign";
    public static final String SIGN_TYPE = "signType";
    public static final String TAG = "tag";
    public static final String TITLE = "title";
    public static final String TN = "tn";
    public static final String URL = "url";
    private static final long serialVersionUID = 1;
    private String customerId;
    private String defaultResPage;
    private String failUrl;
    private String itemInfo;
    private Map<String, String> mData;
    private Map<String, String[]> mExtraData;
    private String mobile;
    private String orderCreateTime;
    private String orderId;
    private String passuid;
    private String payAmount;
    private String sdk;
    private String service;
    private String sign;
    private String signType;
    private String title;
    private String tn;
    private String url;
    public static String DELIVERY_CASHIER_DATA = "delivery_cashier_data";
    public static String DELIVERY_CASHIER_CONTENT = "delivery_cashier_content";
    private String deviceType = "1";
    private String returnUrl = "";
    private String notifyUrl = "";
    private String imei = "";
    private String fuser = "";
    private String extData = "";

    public void setData(Map<String, String> map) {
        this.mData = map;
    }

    public Map<String, String> getData() {
        return this.mData;
    }

    public String getGoodsName() {
        return this.mData != null ? this.mData.get("title") : "";
    }

    public String originAmount() {
        return this.mData != null ? this.mData.get("originalAmount") : "";
    }

    public String amount() {
        return this.mData != null ? this.mData.get("payAmount") : "";
    }

    public String getUid() {
        return this.mData != null ? this.mData.get("passuid") : "";
    }

    public String getOrderNo() {
        return this.mData != null ? this.mData.get("orderId") : "";
    }

    public String getCustomId() {
        return this.mData != null ? this.mData.get("customerId") : "";
    }

    public void setExtraData(Map<String, String[]> map) {
        this.mExtraData = map;
    }

    public String[] getOderInfoDescArray() {
        if (this.mExtraData != null) {
            return this.mExtraData.get("orderInfoDescArray");
        }
        return null;
    }
}
