package com.baidu.ueg.encrypt;
/* loaded from: classes20.dex */
public class b {
    public static a a(com.baidu.ueg.encrypt.entity.a aVar) throws Exception {
        switch (aVar.dAU()) {
            case RSA:
                return new c(aVar.dAV());
            default:
                return null;
        }
    }
}
