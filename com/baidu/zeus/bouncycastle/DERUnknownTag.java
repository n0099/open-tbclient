package com.baidu.zeus.bouncycastle;
/* loaded from: classes.dex */
public class DERUnknownTag extends DERObject {
    byte[] data;
    int tag;

    public DERUnknownTag(int i, byte[] bArr) {
        this.tag = i;
        this.data = bArr;
    }

    public int getTag() {
        return this.tag;
    }

    public byte[] getData() {
        return this.data;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.zeus.bouncycastle.DERObject
    public void encode(DEROutputStream dEROutputStream) {
        dEROutputStream.writeEncoded(this.tag, this.data);
    }

    @Override // com.baidu.zeus.bouncycastle.DERObject, com.baidu.zeus.bouncycastle.ASN1Encodable
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DERUnknownTag)) {
            return false;
        }
        DERUnknownTag dERUnknownTag = (DERUnknownTag) obj;
        if (this.tag == dERUnknownTag.tag && this.data.length == dERUnknownTag.data.length) {
            for (int i = 0; i < this.data.length; i++) {
                if (this.data[i] != dERUnknownTag.data[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.zeus.bouncycastle.DERObject, com.baidu.zeus.bouncycastle.ASN1Encodable
    public int hashCode() {
        byte[] data = getData();
        int i = 0;
        for (int i2 = 0; i2 != data.length; i2++) {
            i ^= (data[i2] & 255) << (i2 % 4);
        }
        return getTag() ^ i;
    }
}
