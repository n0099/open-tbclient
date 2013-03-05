package com.baidu.zeus.security;
/* loaded from: classes.dex */
public class Sha1MessageDigest extends MessageDigest {
    private int mNativeSha1Context;

    private native void init();

    @Override // com.baidu.zeus.security.MessageDigest
    public native byte[] digest();

    public native void reset();

    @Override // com.baidu.zeus.security.MessageDigest
    public native void update(byte[] bArr);

    public Sha1MessageDigest() {
        init();
    }

    @Override // com.baidu.zeus.security.MessageDigest
    public byte[] digest(byte[] bArr) {
        update(bArr);
        return digest();
    }
}
