package com.baidu.tieba.xiuba;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ResponsePayData implements Serializable {
    public static final int CODE_BALANCE_LACK = 2270005;
    public static final int CODE_NEED_PASSWORD = 1990027;
    public static final int CODE_PASSWORD_ERROR = 1990028;
    public static final int CODE_PAY_OTHER_ERROR = 2;
    public static final int CODE_PAY_SUCCESS = 0;
    public static final int CODE_PURCHASE_OTHER_ERROR = 3;
    public static final int CODE_PURCHASE_SUCCES = 1;
    private static final long serialVersionUID = 1;
    private long errorCode;
    private String errorMsg;

    public long getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(long j) {
        this.errorCode = j;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }
}
