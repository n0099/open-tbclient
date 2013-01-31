package com.baidu.zeus.bouncycastle;
/* loaded from: classes.dex */
public class DEROctetString extends ASN1OctetString {
    public DEROctetString(byte[] bArr) {
        super(bArr);
    }

    public DEROctetString(DEREncodable dEREncodable) {
        super(dEREncodable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.zeus.bouncycastle.ASN1OctetString, com.baidu.zeus.bouncycastle.DERObject
    public void encode(DEROutputStream dEROutputStream) {
        dEROutputStream.writeEncoded(4, this.string);
    }
}
