package com.baidu.zeus.bouncycastle;

import com.tencent.mm.sdk.contact.RContact;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.math.BigInteger;
/* loaded from: classes.dex */
public class DERObjectIdentifier extends DERObject {
    String identifier;

    public static DERObjectIdentifier getInstance(Object obj) {
        if (obj == null || (obj instanceof DERObjectIdentifier)) {
            return (DERObjectIdentifier) obj;
        }
        if (obj instanceof ASN1OctetString) {
            return new DERObjectIdentifier(((ASN1OctetString) obj).getOctets());
        }
        if (obj instanceof ASN1TaggedObject) {
            return getInstance(((ASN1TaggedObject) obj).getObject());
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static DERObjectIdentifier getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(aSN1TaggedObject.getObject());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DERObjectIdentifier(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = true;
        BigInteger bigInteger = null;
        long j = 0;
        int i = 0;
        while (i != bArr.length) {
            int i2 = bArr[i] & 255;
            if (j < 36028797018963968L) {
                j = (j * 128) + (i2 & RContact.MM_CONTACTFLAG_ALL);
                if ((i2 & DERTags.TAGGED) == 0) {
                    if (z) {
                        switch (((int) j) / 40) {
                            case 0:
                                stringBuffer.append('0');
                                break;
                            case 1:
                                stringBuffer.append('1');
                                j -= 40;
                                break;
                            default:
                                stringBuffer.append('2');
                                j -= 80;
                                break;
                        }
                        z = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(j);
                    j = 0;
                }
            } else {
                bigInteger = (bigInteger == null ? BigInteger.valueOf(j) : bigInteger).shiftLeft(7).or(BigInteger.valueOf(i2 & RContact.MM_CONTACTFLAG_ALL));
                if ((i2 & DERTags.TAGGED) == 0) {
                    stringBuffer.append('.');
                    stringBuffer.append(bigInteger);
                    bigInteger = null;
                    j = 0;
                }
            }
            i++;
            bigInteger = bigInteger;
            z = z;
        }
        this.identifier = stringBuffer.toString().intern();
    }

    public DERObjectIdentifier(String str) {
        if (!isValidIdentifier(str)) {
            throw new IllegalArgumentException("string " + str + " not an OID");
        }
        this.identifier = str.intern();
    }

    public String getId() {
        return this.identifier;
    }

    private void writeField(OutputStream outputStream, long j) {
        if (j >= 128) {
            if (j >= 16384) {
                if (j >= 2097152) {
                    if (j >= 268435456) {
                        if (j >= 34359738368L) {
                            if (j >= 4398046511104L) {
                                if (j >= 562949953421312L) {
                                    if (j >= 72057594037927936L) {
                                        outputStream.write(((int) (j >> 56)) | DERTags.TAGGED);
                                    }
                                    outputStream.write(((int) (j >> 49)) | DERTags.TAGGED);
                                }
                                outputStream.write(((int) (j >> 42)) | DERTags.TAGGED);
                            }
                            outputStream.write(((int) (j >> 35)) | DERTags.TAGGED);
                        }
                        outputStream.write(((int) (j >> 28)) | DERTags.TAGGED);
                    }
                    outputStream.write(((int) (j >> 21)) | DERTags.TAGGED);
                }
                outputStream.write(((int) (j >> 14)) | DERTags.TAGGED);
            }
            outputStream.write(((int) (j >> 7)) | DERTags.TAGGED);
        }
        outputStream.write(((int) j) & RContact.MM_CONTACTFLAG_ALL);
    }

    private void writeField(OutputStream outputStream, BigInteger bigInteger) {
        int bitLength = (bigInteger.bitLength() + 6) / 7;
        if (bitLength == 0) {
            outputStream.write(0);
            return;
        }
        byte[] bArr = new byte[bitLength];
        for (int i = bitLength - 1; i >= 0; i--) {
            bArr[i] = (byte) ((bigInteger.intValue() & RContact.MM_CONTACTFLAG_ALL) | DERTags.TAGGED);
            bigInteger = bigInteger.shiftRight(7);
        }
        int i2 = bitLength - 1;
        bArr[i2] = (byte) (bArr[i2] & Byte.MAX_VALUE);
        outputStream.write(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.zeus.bouncycastle.DERObject
    public void encode(DEROutputStream dEROutputStream) {
        OIDTokenizer oIDTokenizer = new OIDTokenizer(this.identifier);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DEROutputStream dEROutputStream2 = new DEROutputStream(byteArrayOutputStream);
        writeField(byteArrayOutputStream, (Integer.parseInt(oIDTokenizer.nextToken()) * 40) + Integer.parseInt(oIDTokenizer.nextToken()));
        while (oIDTokenizer.hasMoreTokens()) {
            String nextToken = oIDTokenizer.nextToken();
            if (nextToken.length() < 18) {
                writeField(byteArrayOutputStream, Long.parseLong(nextToken));
            } else {
                writeField(byteArrayOutputStream, new BigInteger(nextToken));
            }
        }
        dEROutputStream2.close();
        dEROutputStream.writeEncoded(6, byteArrayOutputStream.toByteArray());
    }

    @Override // com.baidu.zeus.bouncycastle.DERObject, com.baidu.zeus.bouncycastle.ASN1Encodable
    public int hashCode() {
        return this.identifier.hashCode();
    }

    @Override // com.baidu.zeus.bouncycastle.DERObject, com.baidu.zeus.bouncycastle.ASN1Encodable
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DERObjectIdentifier)) {
            return false;
        }
        return this.identifier.equals(((DERObjectIdentifier) obj).identifier);
    }

    public String toString() {
        return getId();
    }

    private static boolean isValidIdentifier(String str) {
        boolean z = false;
        for (int length = str.length() - 1; length >= 0; length--) {
            char charAt = str.charAt(length);
            if ('0' <= charAt && charAt <= '9') {
                z = true;
            } else if (charAt != '.' || !z) {
                return false;
            } else {
                z = false;
            }
        }
        return z;
    }
}
