package com.baidu.ueg.encrypt;
/* loaded from: classes25.dex */
public class b {
    public static a a(com.baidu.ueg.encrypt.entity.a aVar) throws Exception {
        switch (aVar.dQQ()) {
            case RSA:
                return new c(aVar.dQR());
            default:
                return null;
        }
    }
}
