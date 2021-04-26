package com.baidu.wallet.paysdk.datamodel;
/* loaded from: classes5.dex */
public enum SourceFlag {
    SDK(3),
    PC(0),
    H5(1),
    IFrame(2);
    
    public String mSourceFlag;

    SourceFlag(int i2) {
        this.mSourceFlag = Integer.toString(i2);
    }

    public String value() {
        return this.mSourceFlag;
    }
}
