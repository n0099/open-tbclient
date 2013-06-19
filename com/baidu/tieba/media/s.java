package com.baidu.tieba.media;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public enum s {
    PLAYER_IDLE,
    PLAYER_PREPARING,
    PLAYER_PREPARED;

    /* JADX DEBUG: Replace access to removed values field (d) with 'values()' method */
    /* renamed from: values  reason: to resolve conflict with enum method */
    public static s[] valuesCustom() {
        s[] valuesCustom = values();
        int length = valuesCustom.length;
        s[] sVarArr = new s[length];
        System.arraycopy(valuesCustom, 0, sVarArr, 0, length);
        return sVarArr;
    }
}
