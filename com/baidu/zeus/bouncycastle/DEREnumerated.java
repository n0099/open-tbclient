package com.baidu.zeus.bouncycastle;

import java.math.BigInteger;
/* loaded from: classes.dex */
public class DEREnumerated extends DERObject {
    byte[] bytes;

    public static DEREnumerated getInstance(Object obj) {
        if (obj == null || (obj instanceof DEREnumerated)) {
            return (DEREnumerated) obj;
        }
        if (obj instanceof ASN1OctetString) {
            return new DEREnumerated(((ASN1OctetString) obj).getOctets());
        }
        if (obj instanceof ASN1TaggedObject) {
            return getInstance(((ASN1TaggedObject) obj).getObject());
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static DEREnumerated getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(aSN1TaggedObject.getObject());
    }

    public DEREnumerated(int i) {
        this.bytes = BigInteger.valueOf(i).toByteArray();
    }

    public DEREnumerated(BigInteger bigInteger) {
        this.bytes = bigInteger.toByteArray();
    }

    public DEREnumerated(byte[] bArr) {
        this.bytes = bArr;
    }

    public BigInteger getValue() {
        return new BigInteger(this.bytes);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.zeus.bouncycastle.DERObject
    public void encode(DEROutputStream dEROutputStream) {
        dEROutputStream.writeEncoded(10, this.bytes);
    }

    @Override // com.baidu.zeus.bouncycastle.DERObject, com.baidu.zeus.bouncycastle.ASN1Encodable
    public boolean equals(Object obj) {
        if (obj instanceof DEREnumerated) {
            DEREnumerated dEREnumerated = (DEREnumerated) obj;
            if (this.bytes.length == dEREnumerated.bytes.length) {
                for (int i = 0; i != this.bytes.length; i++) {
                    if (this.bytes[i] != dEREnumerated.bytes[i]) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.zeus.bouncycastle.DERObject, com.baidu.zeus.bouncycastle.ASN1Encodable
    public int hashCode() {
        return getValue().hashCode();
    }
}
