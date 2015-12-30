package com.baidu.tieba.tbadkCore.videoupload;
/* loaded from: classes.dex */
public class c {
    private int dJo;
    private String errorMessage;
    private int errorNo;
    private boolean isSuccess = true;

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public void setSuccess(boolean z) {
        this.isSuccess = z;
    }

    public int getErrorNo() {
        return this.errorNo;
    }

    public void setErrorNo(int i) {
        this.errorNo = i;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public int aGt() {
        return this.dJo;
    }

    public void ni(int i) {
        this.dJo = i;
    }
}
