package com.baidu.wallet.core;
/* loaded from: classes5.dex */
public enum Permission {
    NONE(0),
    READ_NORMAL(1),
    READ_PRIVATE(2),
    WRITE(4),
    READ_DEVICE(8);
    
    public final int val;

    Permission(int i2) {
        this.val = i2;
    }

    public int getVal() {
        return this.val;
    }

    public boolean verify(int i2) {
        int i3 = this.val;
        return (i2 & i3) == i3;
    }
}
