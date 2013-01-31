package com.baidu.zeus.bouncycastle;

import java.io.ByteArrayOutputStream;
import java.util.Enumeration;
/* loaded from: classes.dex */
public class DERSet extends ASN1Set {
    public DERSet() {
    }

    public DERSet(DEREncodable dEREncodable) {
        addObject(dEREncodable);
    }

    public DERSet(DEREncodableVector dEREncodableVector) {
        this(dEREncodableVector, true);
    }

    public DERSet(ASN1Encodable[] aSN1EncodableArr) {
        for (int i = 0; i != aSN1EncodableArr.length; i++) {
            addObject(aSN1EncodableArr[i]);
        }
        sort();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DERSet(DEREncodableVector dEREncodableVector, boolean z) {
        for (int i = 0; i != dEREncodableVector.size(); i++) {
            addObject(dEREncodableVector.get(i));
        }
        if (z) {
            sort();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.zeus.bouncycastle.ASN1Collection, com.baidu.zeus.bouncycastle.DERObject
    public void encode(DEROutputStream dEROutputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DEROutputStream dEROutputStream2 = new DEROutputStream(byteArrayOutputStream);
        Enumeration objects = getObjects();
        while (objects.hasMoreElements()) {
            dEROutputStream2.writeObject(objects.nextElement());
        }
        dEROutputStream2.close();
        dEROutputStream.writeEncoded(49, byteArrayOutputStream.toByteArray());
    }
}
