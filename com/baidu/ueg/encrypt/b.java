package com.baidu.ueg.encrypt;
/* loaded from: classes.dex */
public class b {
    public static a a(com.baidu.ueg.encrypt.entity.a aVar) {
        switch (aVar.bep()) {
            case RSA:
                return new c(aVar.beq());
            default:
                return null;
        }
    }
}
