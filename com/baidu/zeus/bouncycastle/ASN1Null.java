package com.baidu.zeus.bouncycastle;
/* loaded from: classes.dex */
public abstract class ASN1Null extends DERObject {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.zeus.bouncycastle.DERObject
    public abstract void encode(DEROutputStream dEROutputStream);

    @Override // com.baidu.zeus.bouncycastle.DERObject, com.baidu.zeus.bouncycastle.ASN1Encodable
    public int hashCode() {
        return 0;
    }

    @Override // com.baidu.zeus.bouncycastle.DERObject, com.baidu.zeus.bouncycastle.ASN1Encodable
    public boolean equals(Object obj) {
        return obj != null && (obj instanceof ASN1Null);
    }

    public String toString() {
        return "NULL";
    }
}
