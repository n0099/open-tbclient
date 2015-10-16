package com.baidu.ueg.encrypt;
/* loaded from: classes.dex */
public class b {
    public static a a(com.baidu.ueg.encrypt.entity.a aVar) {
        switch (aVar.aDW()) {
            case RSA:
                return new c(aVar.aDX());
            default:
                return null;
        }
    }
}
