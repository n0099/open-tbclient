package com.baidu.zeus.bouncycastle;

import java.math.BigInteger;
/* loaded from: classes.dex */
public class DERInteger extends DERObject {
    byte[] bytes;

    public static DERInteger getInstance(Object obj) {
        if (obj == null || (obj instanceof DERInteger)) {
            return (DERInteger) obj;
        }
        if (obj instanceof ASN1OctetString) {
            return new DERInteger(((ASN1OctetString) obj).getOctets());
        }
        if (obj instanceof ASN1TaggedObject) {
            return getInstance(((ASN1TaggedObject) obj).getObject());
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static DERInteger getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(aSN1TaggedObject.getObject());
    }

    public DERInteger(int i) {
        this.bytes = BigInteger.valueOf(i).toByteArray();
    }

    public DERInteger(BigInteger bigInteger) {
        this.bytes = bigInteger.toByteArray();
    }

    public DERInteger(byte[] bArr) {
        this.bytes = bArr;
    }

    public BigInteger getValue() {
        return new BigInteger(this.bytes);
    }

    public BigInteger getPositiveValue() {
        return new BigInteger(1, this.bytes);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.zeus.bouncycastle.DERObject
    public void encode(DEROutputStream dEROutputStream) {
        dEROutputStream.writeEncoded(2, this.bytes);
    }

    @Override // com.baidu.zeus.bouncycastle.DERObject, com.baidu.zeus.bouncycastle.ASN1Encodable
    public int hashCode() {
        int i = 0;
        for (int i2 = 0; i2 != this.bytes.length; i2++) {
            i ^= (this.bytes[i2] & 255) << (i2 % 4);
        }
        return i;
    }

    @Override // com.baidu.zeus.bouncycastle.DERObject, com.baidu.zeus.bouncycastle.ASN1Encodable
    public boolean equals(Object obj) {
        if (obj instanceof DERInteger) {
            DERInteger dERInteger = (DERInteger) obj;
            if (this.bytes.length == dERInteger.bytes.length) {
                for (int i = 0; i != this.bytes.length; i++) {
                    if (this.bytes[i] != dERInteger.bytes[i]) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public String toString() {
        return getValue().toString();
    }
}
