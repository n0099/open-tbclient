package com.baidu.zeus.bouncycastle;
/* loaded from: classes.dex */
public abstract class DERObject extends ASN1Encodable implements DERTags {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void encode(DEROutputStream dEROutputStream);

    @Override // com.baidu.zeus.bouncycastle.ASN1Encodable
    public abstract boolean equals(Object obj);

    @Override // com.baidu.zeus.bouncycastle.ASN1Encodable
    public abstract int hashCode();

    @Override // com.baidu.zeus.bouncycastle.ASN1Encodable
    public DERObject toASN1Object() {
        return this;
    }
}
