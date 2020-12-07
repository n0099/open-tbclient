package com.baidu.ueg.encrypt;
/* loaded from: classes19.dex */
public class b {
    public static a a(com.baidu.ueg.encrypt.entity.a aVar) throws Exception {
        switch (aVar.ejN()) {
            case RSA:
                return new c(aVar.ejO());
            default:
                return null;
        }
    }
}
