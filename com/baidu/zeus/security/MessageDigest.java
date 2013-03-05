package com.baidu.zeus.security;

import java.security.NoSuchAlgorithmException;
/* loaded from: classes.dex */
public abstract class MessageDigest {
    public abstract byte[] digest();

    public abstract byte[] digest(byte[] bArr);

    public abstract void update(byte[] bArr);

    public static MessageDigest getInstance(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals("SHA-1")) {
            return new Sha1MessageDigest();
        }
        if (str.equals("MD5")) {
            return new Md5MessageDigest();
        }
        throw new NoSuchAlgorithmException();
    }
}
