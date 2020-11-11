package com.baidu.ueg.encrypt;
/* loaded from: classes7.dex */
public class b {
    public static a a(com.baidu.ueg.encrypt.entity.a aVar) throws Exception {
        switch (aVar.eeb()) {
            case RSA:
                return new c(aVar.eec());
            default:
                return null;
        }
    }
}
