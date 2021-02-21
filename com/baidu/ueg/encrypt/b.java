package com.baidu.ueg.encrypt;
/* loaded from: classes4.dex */
public class b {
    public static a a(com.baidu.ueg.encrypt.entity.a aVar) throws Exception {
        switch (aVar.eiA()) {
            case RSA:
                return new c(aVar.eiB());
            default:
                return null;
        }
    }
}
