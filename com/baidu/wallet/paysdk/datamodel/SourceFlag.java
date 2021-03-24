package com.baidu.wallet.paysdk.datamodel;
/* loaded from: classes5.dex */
public enum SourceFlag {
    SDK(3),
    PC(0),
    H5(1),
    IFrame(2);
    
    public String mSourceFlag;

    SourceFlag(int i) {
        this.mSourceFlag = Integer.toString(i);
    }

    public String value() {
        return this.mSourceFlag;
    }
}
