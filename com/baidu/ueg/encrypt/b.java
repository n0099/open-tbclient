package com.baidu.ueg.encrypt;
/* loaded from: classes.dex */
public class b {
    public static a a(com.baidu.ueg.encrypt.entity.a aVar) {
        switch (aVar.atz()) {
            case RSA:
                return new d(aVar.atA());
            default:
                return null;
        }
    }
}
