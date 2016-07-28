package com.baidu.ueg.encrypt;
/* loaded from: classes.dex */
public class b {
    public static a a(com.baidu.ueg.encrypt.entity.a aVar) throws Exception {
        switch (aVar.bpE()) {
            case RSA:
                return new c(aVar.bpF());
            default:
                return null;
        }
    }
}
