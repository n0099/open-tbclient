package com.baidu.tieba.tbadkCore.data;
/* loaded from: classes.dex */
public class VoiceCheckResult {
    private String authSid;
    private String authToken;
    private ResultCode cZB;
    private boolean cZC;
    private boolean needVerify;

    /* loaded from: classes.dex */
    public enum ResultCode {
        SUCCESS,
        FAIL,
        ACCOUNT_TYPE_CONFLICT;

        /* JADX DEBUG: Replace access to removed values field (cZD) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static ResultCode[] valuesCustom() {
            ResultCode[] valuesCustom = values();
            int length = valuesCustom.length;
            ResultCode[] resultCodeArr = new ResultCode[length];
            System.arraycopy(valuesCustom, 0, resultCodeArr, 0, length);
            return resultCodeArr;
        }
    }

    public ResultCode awR() {
        return this.cZB;
    }

    public boolean awS() {
        return this.cZC;
    }

    public boolean awT() {
        return this.needVerify;
    }

    public String awU() {
        return this.authSid;
    }

    public String awV() {
        return this.authToken;
    }
}
