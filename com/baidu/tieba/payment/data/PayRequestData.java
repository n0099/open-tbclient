package com.baidu.tieba.payment.data;

import java.io.Serializable;
/* loaded from: classes8.dex */
public class PayRequestData implements Serializable {
    public static final String MOBILE_CHECK_READY = "1";
    private static final long serialVersionUID = 8869447293021278630L;
    private String bindId;
    private String captchaInputStr;
    private String captchaVcodeStr;
    private String mobileCheck;
    private String openId;
    private String orderId;
    private String password;
    private long sceneId;
    private String tbs;

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public long getSceneId() {
        return this.sceneId;
    }

    public void setSceneId(long j) {
        this.sceneId = j;
    }

    public String getOpenId() {
        return this.openId;
    }

    public void setOpenId(String str) {
        this.openId = str;
    }

    public String getCaptchaVcodeStr() {
        return this.captchaVcodeStr;
    }

    public void setCaptchaVcodeStr(String str) {
        this.captchaVcodeStr = str;
    }

    public String getCaptchaInputStr() {
        return this.captchaInputStr;
    }

    public void setCaptchaInputStr(String str) {
        this.captchaInputStr = str;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public String getBindId() {
        return this.bindId;
    }

    public void setBindId(String str) {
        this.bindId = str;
    }

    public String getMobileCheck() {
        return this.mobileCheck;
    }

    public void setMobileCheck(String str) {
        this.mobileCheck = str;
    }

    public String getTbs() {
        return this.tbs;
    }

    public void setTbs(String str) {
        this.tbs = str;
    }
}
