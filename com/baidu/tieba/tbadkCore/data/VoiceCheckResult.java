package com.baidu.tieba.tbadkCore.data;
/* loaded from: classes.dex */
public class VoiceCheckResult {
    private String authSid;
    private String authToken;
    private ResultCode csu;
    private boolean csv;
    private boolean needVerify;

    /* loaded from: classes.dex */
    public enum ResultCode {
        SUCCESS,
        FAIL,
        ACCOUNT_TYPE_CONFLICT;

        /* JADX DEBUG: Replace access to removed values field (csw) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static ResultCode[] valuesCustom() {
            ResultCode[] valuesCustom = values();
            int length = valuesCustom.length;
            ResultCode[] resultCodeArr = new ResultCode[length];
            System.arraycopy(valuesCustom, 0, resultCodeArr, 0, length);
            return resultCodeArr;
        }
    }

    public ResultCode aoK() {
        return this.csu;
    }

    public boolean aoL() {
        return this.csv;
    }

    public boolean aoM() {
        return this.needVerify;
    }

    public String aoN() {
        return this.authSid;
    }

    public String aoO() {
        return this.authToken;
    }
}
