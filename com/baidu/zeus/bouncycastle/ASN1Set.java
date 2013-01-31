package com.baidu.zeus.bouncycastle;

import java.util.Enumeration;
/* loaded from: classes.dex */
public abstract class ASN1Set extends ASN1Collection {
    public static ASN1Set getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1Set)) {
            return (ASN1Set) obj;
        }
        throw new IllegalArgumentException("unknown object in getInstance");
    }

    public static ASN1Set getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        if (z) {
            if (!aSN1TaggedObject.isExplicit()) {
                throw new IllegalArgumentException("object implicit - explicit expected.");
            }
            return (ASN1Set) aSN1TaggedObject.getObject();
        } else if (aSN1TaggedObject.isExplicit()) {
            return new DERSet(aSN1TaggedObject.getObject());
        } else {
            if (aSN1TaggedObject.getObject() instanceof ASN1Set) {
                return (ASN1Set) aSN1TaggedObject.getObject();
            }
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            if (aSN1TaggedObject.getObject() instanceof ASN1Sequence) {
                Enumeration objects = ((ASN1Sequence) aSN1TaggedObject.getObject()).getObjects();
                while (objects.hasMoreElements()) {
                    aSN1EncodableVector.add((DEREncodable) objects.nextElement());
                }
                return new DERSet(aSN1EncodableVector, false);
            }
            throw new IllegalArgumentException("unknown object in getInstanceFromTagged");
        }
    }

    @Override // com.baidu.zeus.bouncycastle.DERObject, com.baidu.zeus.bouncycastle.ASN1Encodable
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof DEREncodable) {
            DERObject dERObject = ((DEREncodable) obj).getDERObject();
            if (dERObject instanceof ASN1Set) {
                ASN1Set aSN1Set = (ASN1Set) dERObject;
                if (size() != aSN1Set.size()) {
                    return false;
                }
                Enumeration objects = getObjects();
                Enumeration objects2 = aSN1Set.getObjects();
                while (objects.hasMoreElements()) {
                    if (!objects.nextElement().equals(objects2.nextElement())) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }
}
