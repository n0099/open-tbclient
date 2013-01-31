package com.baidu.zeus.bouncycastle;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
/* loaded from: classes.dex */
public abstract class ASN1Encodable implements DEREncodable {
    public static final String BER = "BER";
    public static final String DER = "DER";

    public abstract DERObject toASN1Object();

    public byte[] getEncoded() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new ASN1OutputStream(byteArrayOutputStream).writeObject(this);
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] getEncoded(String str) {
        if (str.equals(DER)) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new DEROutputStream(byteArrayOutputStream).writeObject(this);
            return byteArrayOutputStream.toByteArray();
        }
        return getEncoded();
    }

    public byte[] getDEREncoded() {
        try {
            return getEncoded(DER);
        } catch (IOException e) {
            return null;
        }
    }

    public int hashCode() {
        return toASN1Object().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DEREncodable)) {
            return false;
        }
        return toASN1Object().equals(((DEREncodable) obj).getDERObject());
    }

    @Override // com.baidu.zeus.bouncycastle.DEREncodable
    public DERObject getDERObject() {
        return toASN1Object();
    }
}
