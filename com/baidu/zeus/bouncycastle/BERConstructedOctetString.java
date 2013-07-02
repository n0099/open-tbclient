package com.baidu.zeus.bouncycastle;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;
/* loaded from: classes.dex */
public class BERConstructedOctetString extends DEROctetString {
    private Vector octs;

    private static byte[] toBytes(Vector vector) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 != vector.size()) {
                try {
                    byteArrayOutputStream.write(((DEROctetString) vector.elementAt(i2)).getOctets());
                    i = i2 + 1;
                } catch (IOException e) {
                    throw new IllegalArgumentException("exception converting octets " + e.toString());
                } catch (ClassCastException e2) {
                    throw new IllegalArgumentException(vector.elementAt(i2).getClass().getName() + " found in input should only contain DEROctetString");
                }
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public BERConstructedOctetString(byte[] bArr) {
        super(bArr);
    }

    public BERConstructedOctetString(Vector vector) {
        super(toBytes(vector));
        this.octs = vector;
    }

    public BERConstructedOctetString(DERObject dERObject) {
        super(dERObject);
    }

    public BERConstructedOctetString(DEREncodable dEREncodable) {
        super(dEREncodable.getDERObject());
    }

    @Override // com.baidu.zeus.bouncycastle.ASN1OctetString
    public byte[] getOctets() {
        return this.string;
    }

    public Enumeration getObjects() {
        return this.octs == null ? generateOcts().elements() : this.octs.elements();
    }

    private Vector generateOcts() {
        Vector vector = new Vector();
        int i = 0;
        for (int i2 = 0; i2 + 1 < this.string.length; i2++) {
            if (this.string[i2] == 0 && this.string[i2 + 1] == 0) {
                byte[] bArr = new byte[(i2 - i) + 1];
                System.arraycopy(this.string, i, bArr, 0, bArr.length);
                vector.addElement(new DEROctetString(bArr));
                i = i2 + 1;
            }
        }
        byte[] bArr2 = new byte[this.string.length - i];
        System.arraycopy(this.string, i, bArr2, 0, bArr2.length);
        vector.addElement(new DEROctetString(bArr2));
        return vector;
    }

    @Override // com.baidu.zeus.bouncycastle.DEROctetString, com.baidu.zeus.bouncycastle.ASN1OctetString, com.baidu.zeus.bouncycastle.DERObject
    public void encode(DEROutputStream dEROutputStream) {
        if ((dEROutputStream instanceof ASN1OutputStream) || (dEROutputStream instanceof BEROutputStream)) {
            dEROutputStream.write(36);
            dEROutputStream.write(DERTags.TAGGED);
            if (this.octs != null) {
                for (int i = 0; i != this.octs.size(); i++) {
                    dEROutputStream.writeObject(this.octs.elementAt(i));
                }
            } else {
                int i2 = 0;
                for (int i3 = 0; i3 + 1 < this.string.length; i3++) {
                    if (this.string[i3] == 0 && this.string[i3 + 1] == 0) {
                        byte[] bArr = new byte[(i3 - i2) + 1];
                        System.arraycopy(this.string, i2, bArr, 0, bArr.length);
                        dEROutputStream.writeObject(new DEROctetString(bArr));
                        i2 = i3 + 1;
                    }
                }
                byte[] bArr2 = new byte[this.string.length - i2];
                System.arraycopy(this.string, i2, bArr2, 0, bArr2.length);
                dEROutputStream.writeObject(new DEROctetString(bArr2));
            }
            dEROutputStream.write(0);
            dEROutputStream.write(0);
            return;
        }
        super.encode(dEROutputStream);
    }
}
