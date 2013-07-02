package com.baidu.zeus.bouncycastle;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
/* loaded from: classes.dex */
public class DERBitString extends DERObject implements DERString {
    private static final char[] table = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    protected byte[] data;
    protected int padBits;

    protected static int getPadBits(int i) {
        int i2 = 0;
        int i3 = 3;
        while (true) {
            if (i3 < 0) {
                break;
            } else if (i3 != 0) {
                if ((i >> (i3 * 8)) == 0) {
                    i3--;
                } else {
                    i2 = (i >> (i3 * 8)) & 255;
                    break;
                }
            } else if (i == 0) {
                i3--;
            } else {
                i2 = i & 255;
                break;
            }
        }
        if (i2 == 0) {
            return 7;
        }
        int i4 = 1;
        while (true) {
            i2 <<= 1;
            if ((i2 & 255) != 0) {
                i4++;
            } else {
                return 8 - i4;
            }
        }
    }

    protected static byte[] getBytes(int i) {
        int i2 = 4;
        for (int i3 = 3; i3 >= 1 && ((255 << (i3 * 8)) & i) == 0; i3--) {
            i2--;
        }
        byte[] bArr = new byte[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr[i4] = (byte) ((i >> (i4 * 8)) & 255);
        }
        return bArr;
    }

    public static DERBitString getInstance(Object obj) {
        if (obj == null || (obj instanceof DERBitString)) {
            return (DERBitString) obj;
        }
        if (obj instanceof ASN1OctetString) {
            byte[] octets = ((ASN1OctetString) obj).getOctets();
            byte b = octets[0];
            byte[] bArr = new byte[octets.length - 1];
            System.arraycopy(octets, 1, bArr, 0, octets.length - 1);
            return new DERBitString(bArr, b);
        } else if (obj instanceof ASN1TaggedObject) {
            return getInstance(((ASN1TaggedObject) obj).getObject());
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public static DERBitString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(aSN1TaggedObject.getObject());
    }

    protected DERBitString(byte b, int i) {
        this.data = new byte[1];
        this.data[0] = b;
        this.padBits = i;
    }

    public DERBitString(byte[] bArr, int i) {
        this.data = bArr;
        this.padBits = i;
    }

    public DERBitString(byte[] bArr) {
        this(bArr, 0);
    }

    public DERBitString(DEREncodable dEREncodable) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DEROutputStream dEROutputStream = new DEROutputStream(byteArrayOutputStream);
            dEROutputStream.writeObject(dEREncodable);
            dEROutputStream.close();
            this.data = byteArrayOutputStream.toByteArray();
            this.padBits = 0;
        } catch (IOException e) {
            throw new IllegalArgumentException("Error processing object : " + e.toString());
        }
    }

    public byte[] getBytes() {
        return this.data;
    }

    public int getPadBits() {
        return this.padBits;
    }

    public int intValue() {
        int i = 0;
        for (int i2 = 0; i2 != this.data.length && i2 != 4; i2++) {
            i |= (this.data[i2] & 255) << (i2 * 8);
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.zeus.bouncycastle.DERObject
    public void encode(DEROutputStream dEROutputStream) {
        byte[] bArr = new byte[getBytes().length + 1];
        bArr[0] = (byte) getPadBits();
        System.arraycopy(getBytes(), 0, bArr, 1, bArr.length - 1);
        dEROutputStream.writeEncoded(3, bArr);
    }

    @Override // com.baidu.zeus.bouncycastle.DERObject, com.baidu.zeus.bouncycastle.ASN1Encodable
    public int hashCode() {
        int i = 0;
        for (int i2 = 0; i2 != this.data.length; i2++) {
            i ^= (this.data[i2] & 255) << (i2 % 4);
        }
        return i;
    }

    @Override // com.baidu.zeus.bouncycastle.DERObject, com.baidu.zeus.bouncycastle.ASN1Encodable
    public boolean equals(Object obj) {
        if (obj instanceof DERBitString) {
            DERBitString dERBitString = (DERBitString) obj;
            if (this.data.length == dERBitString.data.length) {
                for (int i = 0; i != this.data.length; i++) {
                    if (this.data[i] != dERBitString.data[i]) {
                        return false;
                    }
                }
                return this.padBits == dERBitString.padBits;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.zeus.bouncycastle.DERString
    public String getString() {
        StringBuffer stringBuffer = new StringBuffer("#");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ASN1OutputStream(byteArrayOutputStream).writeObject(this);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            for (int i = 0; i != byteArray.length; i++) {
                stringBuffer.append(table[(byteArray[i] >>> 4) % 15]);
                stringBuffer.append(table[byteArray[i] & 15]);
            }
            return stringBuffer.toString();
        } catch (IOException e) {
            throw new RuntimeException("internal error encoding BitString");
        }
    }

    public String toString() {
        return getString();
    }
}
