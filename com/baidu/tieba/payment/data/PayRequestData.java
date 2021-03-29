package com.baidu.tieba.payment.data;

import java.io.Serializable;
/* loaded from: classes3.dex */
public class PayRequestData implements Serializable {
    public static final String MOBILE_CHECK_READY = "1";
    public static final long serialVersionUID = 8869447293021278630L;
    public String bindId;
    public String captchaInputStr;
    public String captchaVcodeStr;
    public String mobileCheck;
    public String openId;
    public String orderId;
    public String password;
    public long sceneId;
    public String tbs;

    public String getBindId() {
        return this.bindId;
    }

    public String getCaptchaInputStr() {
        return this.captchaInputStr;
    }

    public String getCaptchaVcodeStr() {
        return this.captchaVcodeStr;
    }

    public String getMobileCheck() {
        return this.mobileCheck;
    }

    public String getOpenId() {
        return this.openId;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getPassword() {
        return this.password;
    }

    public long getSceneId() {
        return this.sceneId;
    }

    public String getTbs() {
        return this.tbs;
    }

    public void setBindId(String str) {
        this.bindId = str;
    }

    public void setCaptchaInputStr(String str) {
        this.captchaInputStr = str;
    }

    public void setCaptchaVcodeStr(String str) {
        this.captchaVcodeStr = str;
    }

    public void setMobileCheck(String str) {
        this.mobileCheck = str;
    }

    public void setOpenId(String str) {
        this.openId = str;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setSceneId(long j) {
        this.sceneId = j;
    }

    public void setTbs(String str) {
        this.tbs = str;
    }
}
