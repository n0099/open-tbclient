package com.baidu.zeus.bouncycastle;

import java.io.ByteArrayOutputStream;
/* loaded from: classes.dex */
public class DERApplicationSpecific extends DERObject {
    private byte[] octets;
    private int tag;

    public DERApplicationSpecific(int i, byte[] bArr) {
        this.tag = i;
        this.octets = bArr;
    }

    public DERApplicationSpecific(int i, DEREncodable dEREncodable) {
        this.tag = i | 32;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new DEROutputStream(byteArrayOutputStream).writeObject(dEREncodable);
        this.octets = byteArrayOutputStream.toByteArray();
    }

    public boolean isConstructed() {
        return (this.tag & 32) != 0;
    }

    public byte[] getContents() {
        return this.octets;
    }

    public int getApplicationTag() {
        return this.tag & 31;
    }

    public DERObject getObject() {
        return new ASN1InputStream(getContents()).readObject();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.zeus.bouncycastle.DERObject
    public void encode(DEROutputStream dEROutputStream) {
        dEROutputStream.writeEncoded(this.tag | 64, this.octets);
    }

    @Override // com.baidu.zeus.bouncycastle.DERObject, com.baidu.zeus.bouncycastle.ASN1Encodable
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DERApplicationSpecific)) {
            return false;
        }
        DERApplicationSpecific dERApplicationSpecific = (DERApplicationSpecific) obj;
        if (this.tag == dERApplicationSpecific.tag && this.octets.length == dERApplicationSpecific.octets.length) {
            for (int i = 0; i < this.octets.length; i++) {
                if (this.octets[i] != dERApplicationSpecific.octets[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.zeus.bouncycastle.DERObject, com.baidu.zeus.bouncycastle.ASN1Encodable
    public int hashCode() {
        byte[] contents = getContents();
        int i = 0;
        for (int i2 = 0; i2 != contents.length; i2++) {
            i ^= (contents[i2] & 255) << (i2 % 4);
        }
        return getApplicationTag() ^ i;
    }
}
