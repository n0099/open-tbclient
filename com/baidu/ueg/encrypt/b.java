package com.baidu.ueg.encrypt;
/* loaded from: classes6.dex */
public class b {
    public static a a(com.baidu.ueg.encrypt.entity.a aVar) throws Exception {
        switch (aVar.cWD()) {
            case RSA:
                return new c(aVar.cWE());
            default:
                return null;
        }
    }
}
