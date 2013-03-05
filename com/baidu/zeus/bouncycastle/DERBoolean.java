package com.baidu.zeus.bouncycastle;
/* loaded from: classes.dex */
public class DERBoolean extends DERObject {
    public static final DERBoolean FALSE = new DERBoolean(false);
    public static final DERBoolean TRUE = new DERBoolean(true);
    private final byte value;

    public static DERBoolean getInstance(Object obj) {
        if (obj == null || (obj instanceof DERBoolean)) {
            return (DERBoolean) obj;
        }
        if (obj instanceof ASN1OctetString) {
            return getInstance(((ASN1OctetString) obj).getOctets());
        }
        if (obj instanceof ASN1TaggedObject) {
            return getInstance(((ASN1TaggedObject) obj).getObject());
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static DERBoolean getInstance(boolean z) {
        return z ? TRUE : FALSE;
    }

    public static DERBoolean getInstance(byte[] bArr) {
        return bArr[0] != 0 ? TRUE : FALSE;
    }

    public static DERBoolean getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(aSN1TaggedObject.getObject());
    }

    private DERBoolean(boolean z) {
        this.value = z ? (byte) -1 : (byte) 0;
    }

    public boolean isTrue() {
        return this.value != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.zeus.bouncycastle.DERObject
    public void encode(DEROutputStream dEROutputStream) {
        dEROutputStream.writeEncoded(1, new byte[]{this.value});
    }

    @Override // com.baidu.zeus.bouncycastle.DERObject, com.baidu.zeus.bouncycastle.ASN1Encodable
    public boolean equals(Object obj) {
        return obj != null && (obj instanceof DERBoolean) && this.value == ((DERBoolean) obj).value;
    }

    @Override // com.baidu.zeus.bouncycastle.DERObject, com.baidu.zeus.bouncycastle.ASN1Encodable
    public int hashCode() {
        return this.value;
    }

    public String toString() {
        return this.value != 0 ? "TRUE" : "FALSE";
    }
}
