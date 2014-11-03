package com.baidu.tieba.xiuba;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ResponseSendMsgData implements Serializable {
    public static final int CODE_SUCCESS = 0;
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
