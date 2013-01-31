package com.baidu.zeus.bouncycastle;
/* loaded from: classes.dex */
public class DERNull extends ASN1Null {
    public static final DERNull THE_ONE = new DERNull();
    private static final byte[] zeroBytes = new byte[0];

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.zeus.bouncycastle.ASN1Null, com.baidu.zeus.bouncycastle.DERObject
    public void encode(DEROutputStream dEROutputStream) {
        dEROutputStream.writeEncoded(5, zeroBytes);
    }

    @Override // com.baidu.zeus.bouncycastle.ASN1Null, com.baidu.zeus.bouncycastle.DERObject, com.baidu.zeus.bouncycastle.ASN1Encodable
    public boolean equals(Object obj) {
        return obj != null && (obj instanceof DERNull);
    }

    @Override // com.baidu.zeus.bouncycastle.ASN1Null, com.baidu.zeus.bouncycastle.DERObject, com.baidu.zeus.bouncycastle.ASN1Encodable
    public int hashCode() {
        return 0;
    }
}
