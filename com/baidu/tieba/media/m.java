package com.baidu.tieba.media;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public enum m {
    DOWNLOADING,
    PAUSE,
    STOP;

    /* JADX DEBUG: Replace access to removed values field (d) with 'values()' method */
    /* renamed from: values  reason: to resolve conflict with enum method */
    public static m[] valuesCustom() {
        m[] valuesCustom = values();
        int length = valuesCustom.length;
        m[] mVarArr = new m[length];
        System.arraycopy(valuesCustom, 0, mVarArr, 0, length);
        return mVarArr;
    }
}
