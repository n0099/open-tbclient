package com.baidu.zeus.bouncycastle;
/* loaded from: classes.dex */
public class BERNull extends DERNull {
    public static final BERNull THE_ONE = new BERNull();

    private BERNull() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.zeus.bouncycastle.DERNull, com.baidu.zeus.bouncycastle.ASN1Null, com.baidu.zeus.bouncycastle.DERObject
    public void encode(DEROutputStream dEROutputStream) {
        if ((dEROutputStream instanceof ASN1OutputStream) || (dEROutputStream instanceof BEROutputStream)) {
            dEROutputStream.write(5);
        } else {
            super.encode(dEROutputStream);
        }
    }
}
