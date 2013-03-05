package com.baidu.zeus.bouncycastle;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;
/* loaded from: classes.dex */
public abstract class ASN1OctetString extends DERObject {
    byte[] string;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.zeus.bouncycastle.DERObject
    public abstract void encode(DEROutputStream dEROutputStream);

    public static ASN1OctetString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(aSN1TaggedObject.getObject());
    }

    public static ASN1OctetString getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1OctetString)) {
            return (ASN1OctetString) obj;
        }
        if (obj instanceof ASN1TaggedObject) {
            return getInstance(((ASN1TaggedObject) obj).getObject());
        }
        if (obj instanceof ASN1Sequence) {
            Vector vector = new Vector();
            Enumeration objects = ((ASN1Sequence) obj).getObjects();
            while (objects.hasMoreElements()) {
                vector.addElement(objects.nextElement());
            }
            return new BERConstructedOctetString(vector);
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public ASN1OctetString(byte[] bArr) {
        this.string = bArr;
    }

    public ASN1OctetString(DEREncodable dEREncodable) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DEROutputStream dEROutputStream = new DEROutputStream(byteArrayOutputStream);
            dEROutputStream.writeObject(dEREncodable);
            dEROutputStream.close();
            this.string = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new IllegalArgumentException("Error processing object : " + e.toString());
        }
    }

    public byte[] getOctets() {
        return this.string;
    }

    @Override // com.baidu.zeus.bouncycastle.DERObject, com.baidu.zeus.bouncycastle.ASN1Encodable
    public int hashCode() {
        byte[] octets = getOctets();
        int i = 0;
        for (int i2 = 0; i2 != octets.length; i2++) {
            i ^= (octets[i2] & 255) << (i2 % 4);
        }
        return i;
    }

    @Override // com.baidu.zeus.bouncycastle.DERObject, com.baidu.zeus.bouncycastle.ASN1Encodable
    public boolean equals(Object obj) {
        if (obj instanceof DEROctetString) {
            byte[] octets = ((DEROctetString) obj).getOctets();
            byte[] octets2 = getOctets();
            if (octets.length == octets2.length) {
                for (int i = 0; i != octets.length; i++) {
                    if (octets[i] != octets2[i]) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public String toString() {
        return "#" + new String(Hex.encode(this.string));
    }
}
