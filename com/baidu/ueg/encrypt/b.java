package com.baidu.ueg.encrypt;
/* loaded from: classes8.dex */
public class b {
    public static a a(com.baidu.ueg.encrypt.entity.a aVar) throws Exception {
        switch (aVar.dsN()) {
            case RSA:
                return new c(aVar.dsO());
            default:
                return null;
        }
    }
}
