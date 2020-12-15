package com.baidu.ueg.encrypt;
/* loaded from: classes19.dex */
public class b {
    public static a a(com.baidu.ueg.encrypt.entity.a aVar) throws Exception {
        switch (aVar.ejO()) {
            case RSA:
                return new c(aVar.ejP());
            default:
                return null;
        }
    }
}
