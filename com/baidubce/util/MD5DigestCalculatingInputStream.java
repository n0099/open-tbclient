package com.baidubce.util;

import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes6.dex */
public class MD5DigestCalculatingInputStream extends FilterInputStream {
    private MessageDigest digest;

    public MD5DigestCalculatingInputStream(InputStream inputStream) throws NoSuchAlgorithmException {
        super(inputStream);
        this.digest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
    }

    public byte[] getMd5Digest() {
        return this.digest.digest();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        try {
            this.digest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
        } catch (NoSuchAlgorithmException e) {
        }
        this.in.reset();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = this.in.read();
        if (read != -1) {
            this.digest.update((byte) read);
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.in.read(bArr, i, i2);
        if (read != -1) {
            this.digest.update(bArr, i, read);
        }
        return read;
    }
}
