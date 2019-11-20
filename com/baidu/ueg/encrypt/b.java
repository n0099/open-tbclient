package com.baidu.ueg.encrypt;
/* loaded from: classes3.dex */
public class b {
    public static a a(com.baidu.ueg.encrypt.entity.a aVar) throws Exception {
        switch (aVar.cBG()) {
            case RSA:
                return new c(aVar.cBH());
            default:
                return null;
        }
    }
}
