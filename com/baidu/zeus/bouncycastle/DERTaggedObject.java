package com.baidu.zeus.bouncycastle;

import java.io.ByteArrayOutputStream;
/* loaded from: classes.dex */
public class DERTaggedObject extends ASN1TaggedObject {
    public DERTaggedObject(int i, DEREncodable dEREncodable) {
        super(i, dEREncodable);
    }

    public DERTaggedObject(boolean z, int i, DEREncodable dEREncodable) {
        super(z, i, dEREncodable);
    }

    public DERTaggedObject(int i) {
        super(false, i, new DERSequence());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.zeus.bouncycastle.ASN1TaggedObject, com.baidu.zeus.bouncycastle.DERObject
    public void encode(DEROutputStream dEROutputStream) {
        if (!this.empty) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DEROutputStream dEROutputStream2 = new DEROutputStream(byteArrayOutputStream);
            dEROutputStream2.writeObject(this.obj);
            dEROutputStream2.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (this.explicit) {
                dEROutputStream.writeEncoded(this.tagNo | 160, byteArray);
                return;
            }
            if ((byteArray[0] & 32) != 0) {
                byteArray[0] = (byte) (this.tagNo | 160);
            } else {
                byteArray[0] = (byte) (this.tagNo | DERTags.TAGGED);
            }
            dEROutputStream.write(byteArray);
            return;
        }
        dEROutputStream.writeEncoded(this.tagNo | 160, new byte[0]);
    }
}
