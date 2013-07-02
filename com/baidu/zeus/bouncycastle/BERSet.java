package com.baidu.zeus.bouncycastle;

import java.util.Enumeration;
/* loaded from: classes.dex */
public class BERSet extends DERSet {
    public BERSet() {
    }

    public BERSet(DEREncodable dEREncodable) {
        super(dEREncodable);
    }

    public BERSet(DEREncodableVector dEREncodableVector) {
        super(dEREncodableVector, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BERSet(DEREncodableVector dEREncodableVector, boolean z) {
        super(dEREncodableVector, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.zeus.bouncycastle.DERSet, com.baidu.zeus.bouncycastle.ASN1Collection, com.baidu.zeus.bouncycastle.DERObject
    public void encode(DEROutputStream dEROutputStream) {
        if ((dEROutputStream instanceof ASN1OutputStream) || (dEROutputStream instanceof BEROutputStream)) {
            dEROutputStream.write(49);
            dEROutputStream.write(DERTags.TAGGED);
            Enumeration objects = getObjects();
            while (objects.hasMoreElements()) {
                dEROutputStream.writeObject(objects.nextElement());
            }
            dEROutputStream.write(0);
            dEROutputStream.write(0);
            return;
        }
        super.encode(dEROutputStream);
    }
}
