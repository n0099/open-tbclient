package com.baidu.zeus.bouncycastle;

import java.util.Enumeration;
/* loaded from: classes.dex */
public class BERSequence extends DERSequence {
    public BERSequence() {
    }

    public BERSequence(DEREncodable dEREncodable) {
        super(dEREncodable);
    }

    public BERSequence(DEREncodableVector dEREncodableVector) {
        super(dEREncodableVector);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.zeus.bouncycastle.DERSequence, com.baidu.zeus.bouncycastle.ASN1Collection, com.baidu.zeus.bouncycastle.DERObject
    public void encode(DEROutputStream dEROutputStream) {
        if ((dEROutputStream instanceof ASN1OutputStream) || (dEROutputStream instanceof BEROutputStream)) {
            dEROutputStream.write(48);
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
