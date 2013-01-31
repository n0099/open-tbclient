package com.baidu.zeus.security;
/* loaded from: classes.dex */
public class Md5MessageDigest extends MessageDigest {
    private int mNativeMd5Context;

    private native void init();

    @Override // com.baidu.zeus.security.MessageDigest
    public native byte[] digest();

    public native void reset();

    @Override // com.baidu.zeus.security.MessageDigest
    public native void update(byte[] bArr);

    public Md5MessageDigest() {
        init();
    }

    @Override // com.baidu.zeus.security.MessageDigest
    public byte[] digest(byte[] bArr) {
        update(bArr);
        return digest();
    }
}
