package com.baidu.ueg.encrypt;
/* loaded from: classes2.dex */
public class b {
    public static a a(com.baidu.ueg.encrypt.entity.a aVar) throws Exception {
        switch (aVar.bMp()) {
            case RSA:
                return new c(aVar.bMq());
            default:
                return null;
        }
    }
}
