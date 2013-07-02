package com.baidu.zeus.bouncycastle;
/* loaded from: classes.dex */
public class DERUTF8String extends DERObject implements DERString {
    String string;

    public static DERUTF8String getInstance(Object obj) {
        if (obj == null || (obj instanceof DERUTF8String)) {
            return (DERUTF8String) obj;
        }
        if (obj instanceof ASN1OctetString) {
            return new DERUTF8String(((ASN1OctetString) obj).getOctets());
        }
        if (obj instanceof ASN1TaggedObject) {
            return getInstance(((ASN1TaggedObject) obj).getObject());
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static DERUTF8String getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(aSN1TaggedObject.getObject());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DERUTF8String(byte[] bArr) {
        this.string = Strings.fromUTF8ByteArray(bArr);
    }

    public DERUTF8String(String str) {
        this.string = str;
    }

    @Override // com.baidu.zeus.bouncycastle.DERString
    public String getString() {
        return this.string;
    }

    @Override // com.baidu.zeus.bouncycastle.DERObject, com.baidu.zeus.bouncycastle.ASN1Encodable
    public int hashCode() {
        return getString().hashCode();
    }

    @Override // com.baidu.zeus.bouncycastle.DERObject, com.baidu.zeus.bouncycastle.ASN1Encodable
    public boolean equals(Object obj) {
        if (!(obj instanceof DERUTF8String)) {
            return false;
        }
        return getString().equals(((DERUTF8String) obj).getString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.zeus.bouncycastle.DERObject
    public void encode(DEROutputStream dEROutputStream) {
        dEROutputStream.writeEncoded(12, Strings.toUTF8ByteArray(this.string));
    }
}
