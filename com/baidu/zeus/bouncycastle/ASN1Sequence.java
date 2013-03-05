package com.baidu.zeus.bouncycastle;

import java.util.Enumeration;
/* loaded from: classes.dex */
public abstract class ASN1Sequence extends ASN1Collection {
    public static ASN1Sequence getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1Sequence)) {
            return (ASN1Sequence) obj;
        }
        throw new IllegalArgumentException("unknown object in getInstance");
    }

    public static ASN1Sequence getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        if (z) {
            if (!aSN1TaggedObject.isExplicit()) {
                throw new IllegalArgumentException("object implicit - explicit expected.");
            }
            return (ASN1Sequence) aSN1TaggedObject.getObject();
        } else if (aSN1TaggedObject.isExplicit()) {
            if (aSN1TaggedObject instanceof BERTaggedObject) {
                return new BERSequence(aSN1TaggedObject.getObject());
            }
            return new DERSequence(aSN1TaggedObject.getObject());
        } else if (aSN1TaggedObject.getObject() instanceof ASN1Sequence) {
            return (ASN1Sequence) aSN1TaggedObject.getObject();
        } else {
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
            if (dERObject instanceof ASN1Sequence) {
                ASN1Sequence aSN1Sequence = (ASN1Sequence) dERObject;
                if (size() != aSN1Sequence.size()) {
                    return false;
                }
                Enumeration objects = getObjects();
                Enumeration objects2 = aSN1Sequence.getObjects();
                while (objects.hasMoreElements()) {
                    Object nextElement = objects.nextElement();
                    Object nextElement2 = objects2.nextElement();
                    if (nextElement != null && nextElement2 != null) {
                        if (!nextElement.equals(nextElement2)) {
                            return false;
                        }
                    } else if (nextElement != null || nextElement2 != null) {
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
