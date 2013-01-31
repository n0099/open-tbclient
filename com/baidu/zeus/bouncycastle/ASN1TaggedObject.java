package com.baidu.zeus.bouncycastle;
/* loaded from: classes.dex */
public abstract class ASN1TaggedObject extends DERObject {
    boolean empty = false;
    boolean explicit;
    DEREncodable obj;
    int tagNo;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.zeus.bouncycastle.DERObject
    public abstract void encode(DEROutputStream dEROutputStream);

    public static ASN1TaggedObject getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        if (z) {
            return (ASN1TaggedObject) aSN1TaggedObject.getObject();
        }
        throw new IllegalArgumentException("implicitly tagged tagged object");
    }

    public static ASN1TaggedObject getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1TaggedObject)) {
            return (ASN1TaggedObject) obj;
        }
        throw new IllegalArgumentException("unknown object in getInstance");
    }

    public ASN1TaggedObject(int i, DEREncodable dEREncodable) {
        this.explicit = true;
        this.obj = null;
        this.explicit = true;
        this.tagNo = i;
        this.obj = dEREncodable;
    }

    public ASN1TaggedObject(boolean z, int i, DEREncodable dEREncodable) {
        this.explicit = true;
        this.obj = null;
        if (dEREncodable instanceof ASN1Choice) {
            this.explicit = true;
        } else {
            this.explicit = z;
        }
        this.tagNo = i;
        this.obj = dEREncodable;
    }

    @Override // com.baidu.zeus.bouncycastle.DERObject, com.baidu.zeus.bouncycastle.ASN1Encodable
    public boolean equals(Object obj) {
        if (obj instanceof ASN1TaggedObject) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) obj;
            if (this.tagNo == aSN1TaggedObject.tagNo && this.empty == aSN1TaggedObject.empty && this.explicit == aSN1TaggedObject.explicit) {
                if (this.obj == null) {
                    if (aSN1TaggedObject.obj != null) {
                        return false;
                    }
                } else if (!this.obj.equals(aSN1TaggedObject.obj)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.zeus.bouncycastle.DERObject, com.baidu.zeus.bouncycastle.ASN1Encodable
    public int hashCode() {
        int i = this.tagNo;
        if (this.obj != null) {
            return i ^ this.obj.hashCode();
        }
        return i;
    }

    public int getTagNo() {
        return this.tagNo;
    }

    public boolean isExplicit() {
        return this.explicit;
    }

    public boolean isEmpty() {
        return this.empty;
    }

    public DERObject getObject() {
        if (this.obj != null) {
            return this.obj.getDERObject();
        }
        return null;
    }

    public String toString() {
        return "[" + this.tagNo + "]" + this.obj;
    }
}
