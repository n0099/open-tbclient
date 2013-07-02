package com.baidu.zeus.bouncycastle;

import java.util.Enumeration;
/* loaded from: classes.dex */
public class BERTaggedObject extends DERTaggedObject {
    public BERTaggedObject(int i, DEREncodable dEREncodable) {
        super(i, dEREncodable);
    }

    public BERTaggedObject(boolean z, int i, DEREncodable dEREncodable) {
        super(z, i, dEREncodable);
    }

    public BERTaggedObject(int i) {
        super(false, i, new BERSequence());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.zeus.bouncycastle.DERTaggedObject, com.baidu.zeus.bouncycastle.ASN1TaggedObject, com.baidu.zeus.bouncycastle.DERObject
    public void encode(DEROutputStream dEROutputStream) {
        Enumeration objects;
        if ((dEROutputStream instanceof ASN1OutputStream) || (dEROutputStream instanceof BEROutputStream)) {
            dEROutputStream.write(this.tagNo | 160);
            dEROutputStream.write(DERTags.TAGGED);
            if (!this.empty) {
                if (!this.explicit) {
                    if (this.obj instanceof ASN1OctetString) {
                        if (this.obj instanceof BERConstructedOctetString) {
                            objects = ((BERConstructedOctetString) this.obj).getObjects();
                        } else {
                            objects = new BERConstructedOctetString(((ASN1OctetString) this.obj).getOctets()).getObjects();
                        }
                        while (objects.hasMoreElements()) {
                            dEROutputStream.writeObject(objects.nextElement());
                        }
                    } else if (this.obj instanceof ASN1Sequence) {
                        Enumeration objects2 = ((ASN1Sequence) this.obj).getObjects();
                        while (objects2.hasMoreElements()) {
                            dEROutputStream.writeObject(objects2.nextElement());
                        }
                    } else if (this.obj instanceof ASN1Set) {
                        Enumeration objects3 = ((ASN1Set) this.obj).getObjects();
                        while (objects3.hasMoreElements()) {
                            dEROutputStream.writeObject(objects3.nextElement());
                        }
                    } else {
                        throw new RuntimeException("not implemented: " + this.obj.getClass().getName());
                    }
                } else {
                    dEROutputStream.writeObject(this.obj);
                }
            }
            dEROutputStream.write(0);
            dEROutputStream.write(0);
            return;
        }
        super.encode(dEROutputStream);
    }
}
