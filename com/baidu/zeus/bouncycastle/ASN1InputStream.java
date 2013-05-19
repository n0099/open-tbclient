package com.baidu.zeus.bouncycastle;

import cn.jingling.lib.file.Shared;
import com.baidu.mapapi.MKSearch;
import com.baidu.mapapi.MapView;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;
/* loaded from: classes.dex */
public class ASN1InputStream extends FilterInputStream implements DERTags {
    private DERObject END_OF_STREAM;
    boolean eofFound;
    int limit;

    public ASN1InputStream(InputStream inputStream) {
        super(inputStream);
        this.END_OF_STREAM = new DERObject() { // from class: com.baidu.zeus.bouncycastle.ASN1InputStream.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.baidu.zeus.bouncycastle.DERObject
            public void encode(DEROutputStream dEROutputStream) {
                throw new IOException("Eeek!");
            }

            @Override // com.baidu.zeus.bouncycastle.DERObject, com.baidu.zeus.bouncycastle.ASN1Encodable
            public int hashCode() {
                return 0;
            }

            @Override // com.baidu.zeus.bouncycastle.DERObject, com.baidu.zeus.bouncycastle.ASN1Encodable
            public boolean equals(Object obj) {
                return obj == this;
            }
        };
        this.eofFound = false;
        this.limit = Shared.INFINITY;
    }

    public ASN1InputStream(byte[] bArr) {
        this(new ByteArrayInputStream(bArr), bArr.length);
    }

    public ASN1InputStream(InputStream inputStream, int i) {
        super(inputStream);
        this.END_OF_STREAM = new DERObject() { // from class: com.baidu.zeus.bouncycastle.ASN1InputStream.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.baidu.zeus.bouncycastle.DERObject
            public void encode(DEROutputStream dEROutputStream) {
                throw new IOException("Eeek!");
            }

            @Override // com.baidu.zeus.bouncycastle.DERObject, com.baidu.zeus.bouncycastle.ASN1Encodable
            public int hashCode() {
                return 0;
            }

            @Override // com.baidu.zeus.bouncycastle.DERObject, com.baidu.zeus.bouncycastle.ASN1Encodable
            public boolean equals(Object obj) {
                return obj == this;
            }
        };
        this.eofFound = false;
        this.limit = Shared.INFINITY;
        this.limit = i;
    }

    protected int readLength() {
        int i = 0;
        int read = read();
        if (read < 0) {
            throw new IOException("EOF found when length expected");
        }
        if (read == 128) {
            return -1;
        }
        if (read > 127) {
            int i2 = read & 127;
            if (i2 > 4) {
                throw new IOException("DER length more than 4 bytes");
            }
            int i3 = 0;
            while (i < i2) {
                int read2 = read();
                if (read2 < 0) {
                    throw new IOException("EOF found reading length");
                }
                i++;
                i3 = read2 + (i3 << 8);
            }
            if (i3 < 0) {
                throw new IOException("corrupted steam - negative length found");
            }
            if (i3 >= this.limit) {
                throw new IOException("corrupted steam - out of bounds length found");
            }
            return i3;
        }
        return read;
    }

    protected void readFully(byte[] bArr) {
        int length = bArr.length;
        if (length == 0) {
            return;
        }
        do {
            int read = read(bArr, bArr.length - length, length);
            if (read > 0) {
                length -= read;
            } else if (length != 0) {
                throw new EOFException("EOF encountered in middle of object");
            } else {
                return;
            }
        } while (length != 0);
    }

    protected DERObject buildObject(int i, int i2, byte[] bArr) {
        if ((i & 64) != 0) {
            return new DERApplicationSpecific(i, bArr);
        }
        switch (i) {
            case 1:
                return DERBoolean.getInstance(bArr);
            case 2:
                return new DERInteger(bArr);
            case 3:
                byte b = bArr[0];
                byte[] bArr2 = new byte[bArr.length - 1];
                System.arraycopy(bArr, 1, bArr2, 0, bArr.length - 1);
                return new DERBitString(bArr2, b);
            case 4:
                return new DEROctetString(bArr);
            case 5:
                return DERNull.THE_ONE;
            case 6:
                return new DERObjectIdentifier(bArr);
            case 7:
            case 8:
            case 9:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 21:
            case DERTags.GRAPHIC_STRING /* 25 */:
            case 29:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case MKSearch.TYPE_AREA_MULTI_POI_LIST /* 45 */:
            case 46:
            case 47:
            default:
                if ((i & DERTags.TAGGED) != 0) {
                    if (bArr.length == 0) {
                        if ((i & 32) == 0) {
                            return new DERTaggedObject(false, i2, DERNull.THE_ONE);
                        }
                        return new DERTaggedObject(false, i2, new DERSequence());
                    } else if ((i & 32) == 0) {
                        return new DERTaggedObject(false, i2, new DEROctetString(bArr));
                    } else {
                        ASN1InputStream aSN1InputStream = new ASN1InputStream(bArr);
                        DERObject readObject = aSN1InputStream.readObject();
                        if (aSN1InputStream.available() == 0) {
                            return new DERTaggedObject(i2, readObject);
                        }
                        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
                        for (DERObject dERObject = readObject; dERObject != null; dERObject = aSN1InputStream.readObject()) {
                            aSN1EncodableVector.add(dERObject);
                        }
                        return new DERTaggedObject(false, i2, new DERSequence(aSN1EncodableVector));
                    }
                }
                return new DERUnknownTag(i, bArr);
            case 10:
                return new DEREnumerated(bArr);
            case 12:
                return new DERUTF8String(bArr);
            case 18:
                return new DERNumericString(bArr);
            case 19:
                return new DERPrintableString(bArr);
            case 20:
                return new DERT61String(bArr);
            case DERTags.IA5_STRING /* 22 */:
                return new DERIA5String(bArr);
            case DERTags.UTC_TIME /* 23 */:
                return new DERUTCTime(bArr);
            case DERTags.GENERALIZED_TIME /* 24 */:
                return new DERGeneralizedTime(bArr);
            case DERTags.VISIBLE_STRING /* 26 */:
                return new DERVisibleString(bArr);
            case DERTags.GENERAL_STRING /* 27 */:
                return new DERGeneralString(bArr);
            case DERTags.UNIVERSAL_STRING /* 28 */:
                return new DERUniversalString(bArr);
            case DERTags.BMP_STRING /* 30 */:
                return new DERBMPString(bArr);
            case 36:
                return buildDerConstructedOctetString(bArr);
            case MapView.LayoutParams.TOP /* 48 */:
                ASN1InputStream aSN1InputStream2 = new ASN1InputStream(bArr);
                ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                for (DERObject readObject2 = aSN1InputStream2.readObject(); readObject2 != null; readObject2 = aSN1InputStream2.readObject()) {
                    aSN1EncodableVector2.add(readObject2);
                }
                return new DERSequence(aSN1EncodableVector2);
            case 49:
                ASN1InputStream aSN1InputStream3 = new ASN1InputStream(bArr);
                ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
                for (DERObject readObject3 = aSN1InputStream3.readObject(); readObject3 != null; readObject3 = aSN1InputStream3.readObject()) {
                    aSN1EncodableVector3.add(readObject3);
                }
                return new DERSet(aSN1EncodableVector3, false);
        }
    }

    private byte[] readIndefiniteLengthFully() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int read = read();
        while (true) {
            int read2 = read();
            if (read2 < 0 || (read == 0 && read2 == 0)) {
                break;
            }
            byteArrayOutputStream.write(read);
            read = read2;
        }
        return byteArrayOutputStream.toByteArray();
    }

    private BERConstructedOctetString buildConstructedOctetString() {
        Vector vector = new Vector();
        while (true) {
            DERObject readObject = readObject();
            if (readObject != this.END_OF_STREAM) {
                vector.addElement(readObject);
            } else {
                return new BERConstructedOctetString(vector);
            }
        }
    }

    private BERConstructedOctetString buildDerConstructedOctetString(byte[] bArr) {
        Vector vector = new Vector();
        ASN1InputStream aSN1InputStream = new ASN1InputStream(bArr);
        while (true) {
            DERObject readObject = aSN1InputStream.readObject();
            if (readObject != null) {
                vector.addElement(readObject);
            } else {
                return new BERConstructedOctetString(vector);
            }
        }
    }

    public DERObject readObject() {
        int read = read();
        if (read == -1) {
            if (this.eofFound) {
                throw new EOFException("attempt to read past end of file.");
            }
            this.eofFound = true;
            return null;
        }
        int readTagNumber = (read & DERTags.TAGGED) != 0 ? readTagNumber(read) : 0;
        int readLength = readLength();
        if (readLength < 0) {
            switch (read) {
                case 5:
                    return BERNull.THE_ONE;
                case 36:
                    return buildConstructedOctetString();
                case MapView.LayoutParams.TOP /* 48 */:
                    ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
                    while (true) {
                        DERObject readObject = readObject();
                        if (readObject != this.END_OF_STREAM) {
                            aSN1EncodableVector.add(readObject);
                        } else {
                            return new BERSequence(aSN1EncodableVector);
                        }
                    }
                case 49:
                    ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                    while (true) {
                        DERObject readObject2 = readObject();
                        if (readObject2 != this.END_OF_STREAM) {
                            aSN1EncodableVector2.add(readObject2);
                        } else {
                            return new BERSet(aSN1EncodableVector2, false);
                        }
                    }
                default:
                    if ((read & DERTags.TAGGED) != 0) {
                        if ((read & 32) == 0) {
                            return new BERTaggedObject(false, readTagNumber, new DEROctetString(readIndefiniteLengthFully()));
                        }
                        DERObject readObject3 = readObject();
                        if (readObject3 == this.END_OF_STREAM) {
                            return new DERTaggedObject(readTagNumber);
                        }
                        DERObject readObject4 = readObject();
                        if (readObject4 == this.END_OF_STREAM) {
                            return new BERTaggedObject(readTagNumber, readObject3);
                        }
                        ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
                        aSN1EncodableVector3.add(readObject3);
                        do {
                            aSN1EncodableVector3.add(readObject4);
                            readObject4 = readObject();
                        } while (readObject4 != this.END_OF_STREAM);
                        return new BERTaggedObject(false, readTagNumber, new BERSequence(aSN1EncodableVector3));
                    }
                    throw new IOException("unknown BER object encountered");
            }
        } else if (read == 0 && readLength == 0) {
            return this.END_OF_STREAM;
        } else {
            byte[] bArr = new byte[readLength];
            readFully(bArr);
            return buildObject(read, readTagNumber, bArr);
        }
    }

    private int readTagNumber(int i) {
        int i2 = i & 31;
        if (i2 == 31) {
            int read = read();
            int i3 = 0;
            while (read >= 0 && (read & DERTags.TAGGED) != 0) {
                i3 = ((read & 127) | i3) << 7;
                read = read();
            }
            if (read < 0) {
                this.eofFound = true;
                throw new EOFException("EOF found inside tag value.");
            }
            return (read & 127) | i3;
        }
        return i2;
    }
}
