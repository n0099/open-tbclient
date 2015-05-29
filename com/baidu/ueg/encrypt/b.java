package com.baidu.ueg.encrypt;
/* loaded from: classes.dex */
public class b {
    public static a a(com.baidu.ueg.encrypt.entity.a aVar) {
        switch (aVar.aty()) {
            case RSA:
                return new d(aVar.atz());
            default:
                return null;
        }
    }
}
