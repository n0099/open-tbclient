package com.baidu.zeus.bouncycastle;
/* loaded from: classes.dex */
public class DERBMPString extends DERObject implements DERString {
    String string;

    public static DERBMPString getInstance(Object obj) {
        if (obj == null || (obj instanceof DERBMPString)) {
            return (DERBMPString) obj;
        }
        if (obj instanceof ASN1OctetString) {
            return new DERBMPString(((ASN1OctetString) obj).getOctets());
        }
        if (obj instanceof ASN1TaggedObject) {
            return getInstance(((ASN1TaggedObject) obj).getObject());
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static DERBMPString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(aSN1TaggedObject.getObject());
    }

    public DERBMPString(byte[] bArr) {
        char[] cArr = new char[bArr.length / 2];
        for (int i = 0; i != cArr.length; i++) {
            cArr[i] = (char) ((bArr[i * 2] << 8) | (bArr[(i * 2) + 1] & 255));
        }
        this.string = new String(cArr);
    }

    public DERBMPString(String str) {
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
        if (!(obj instanceof DERBMPString)) {
            return false;
        }
        return getString().equals(((DERBMPString) obj).getString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.zeus.bouncycastle.DERObject
    public void encode(DEROutputStream dEROutputStream) {
        char[] charArray = this.string.toCharArray();
        byte[] bArr = new byte[charArray.length * 2];
        for (int i = 0; i != charArray.length; i++) {
            bArr[i * 2] = (byte) (charArray[i] >> '\b');
            bArr[(i * 2) + 1] = (byte) charArray[i];
        }
        dEROutputStream.writeEncoded(30, bArr);
    }
}
