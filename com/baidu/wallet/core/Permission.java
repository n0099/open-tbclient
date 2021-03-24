package com.baidu.wallet.core;
/* loaded from: classes5.dex */
public enum Permission {
    NONE(0),
    READ_NORMAL(1),
    READ_PRIVATE(2),
    WRITE(4),
    READ_DEVICE(8);
    
    public final int val;

    Permission(int i) {
        this.val = i;
    }

    public int getVal() {
        return this.val;
    }

    public boolean verify(int i) {
        int i2 = this.val;
        return (i & i2) == i2;
    }
}
