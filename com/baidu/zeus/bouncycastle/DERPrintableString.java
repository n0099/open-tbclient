package com.baidu.zeus.bouncycastle;
/* loaded from: classes.dex */
public class DERPrintableString extends DERObject implements DERString {
    private final String string;

    public static DERPrintableString getInstance(Object obj) {
        if (obj == null || (obj instanceof DERPrintableString)) {
            return (DERPrintableString) obj;
        }
        if (obj instanceof ASN1OctetString) {
            return new DERPrintableString(((ASN1OctetString) obj).getOctets());
        }
        if (obj instanceof ASN1TaggedObject) {
            return getInstance(((ASN1TaggedObject) obj).getObject());
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static DERPrintableString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(aSN1TaggedObject.getObject());
    }

    public DERPrintableString(byte[] bArr) {
        char[] cArr = new char[bArr.length];
        for (int i = 0; i != cArr.length; i++) {
            cArr[i] = (char) (bArr[i] & 255);
        }
        this.string = new String(cArr).intern();
    }

    public DERPrintableString(String str) {
        this.string = str.intern();
    }

    @Override // com.baidu.zeus.bouncycastle.DERString
    public String getString() {
        return this.string;
    }

    public byte[] getOctets() {
        char[] charArray = this.string.toCharArray();
        byte[] bArr = new byte[charArray.length];
        for (int i = 0; i != charArray.length; i++) {
            bArr[i] = (byte) charArray[i];
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.zeus.bouncycastle.DERObject
    public void encode(DEROutputStream dEROutputStream) {
        dEROutputStream.writeEncoded(19, getOctets());
    }

    @Override // com.baidu.zeus.bouncycastle.DERObject, com.baidu.zeus.bouncycastle.ASN1Encodable
    public int hashCode() {
        return getString().hashCode();
    }

    @Override // com.baidu.zeus.bouncycastle.DERObject, com.baidu.zeus.bouncycastle.ASN1Encodable
    public boolean equals(Object obj) {
        if (!(obj instanceof DERPrintableString)) {
            return false;
        }
        return getString().equals(((DERPrintableString) obj).getString());
    }

    public String toString() {
        return this.string;
    }
}
