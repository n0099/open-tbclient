package com.baidu.zeus.bouncycastle;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ConcurrentModificationException;
import java.util.Enumeration;
/* loaded from: classes.dex */
public abstract class ASN1Collection extends DERObject {
    private DEREncodable obj0;
    private DEREncodable obj1;
    private DEREncodable obj2;
    private DEREncodable obj3;
    private DEREncodable[] rest;
    private int size;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.zeus.bouncycastle.DERObject
    public abstract void encode(DEROutputStream dEROutputStream);

    public final DEREncodable getObjectAt(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(Integer.toString(i));
        }
        switch (i) {
            case 0:
                return this.obj0;
            case 1:
                return this.obj1;
            case 2:
                return this.obj2;
            case 3:
                return this.obj3;
            default:
                return this.rest[i - 4];
        }
    }

    public final int size() {
        return this.size;
    }

    @Override // com.baidu.zeus.bouncycastle.DERObject, com.baidu.zeus.bouncycastle.ASN1Encodable
    public final int hashCode() {
        Enumeration objects = getObjects();
        int i = 0;
        while (objects.hasMoreElements()) {
            Object nextElement = objects.nextElement();
            if (nextElement != null) {
                i ^= nextElement.hashCode();
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addObject(DEREncodable dEREncodable) {
        if (dEREncodable == null) {
            throw new NullPointerException("obj == null");
        }
        int i = this.size;
        switch (i) {
            case 0:
                this.obj0 = dEREncodable;
                break;
            case 1:
                this.obj1 = dEREncodable;
                break;
            case 2:
                this.obj2 = dEREncodable;
                break;
            case 3:
                this.obj3 = dEREncodable;
                break;
            case 4:
                this.rest = new DEREncodable[5];
                this.rest[0] = dEREncodable;
                break;
            default:
                int i2 = i - 4;
                if (i2 >= this.rest.length) {
                    DEREncodable[] dEREncodableArr = new DEREncodable[(i2 * 2) + 10];
                    System.arraycopy(this.rest, 0, dEREncodableArr, 0, this.rest.length);
                    this.rest = dEREncodableArr;
                }
                this.rest[i2] = dEREncodable;
                break;
        }
        this.size++;
    }

    private void setObjectAt(DEREncodable dEREncodable, int i) {
        switch (i) {
            case 0:
                this.obj0 = dEREncodable;
                return;
            case 1:
                this.obj1 = dEREncodable;
                return;
            case 2:
                this.obj2 = dEREncodable;
                return;
            case 3:
                this.obj3 = dEREncodable;
                return;
            default:
                this.rest[i - 4] = dEREncodable;
                return;
        }
    }

    public final Enumeration getObjects() {
        return new ASN1CollectionEnumeration();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ASN1CollectionEnumeration implements Enumeration {
        private int at;
        private final int origSize;

        private ASN1CollectionEnumeration() {
            this.origSize = ASN1Collection.this.size;
            this.at = 0;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            if (ASN1Collection.this.size != this.origSize) {
                throw new ConcurrentModificationException();
            }
            return this.at < this.origSize;
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            if (ASN1Collection.this.size != this.origSize) {
                throw new ConcurrentModificationException();
            }
            int i = this.at;
            this.at = i + 1;
            switch (i) {
                case 0:
                    return ASN1Collection.this.obj0;
                case 1:
                    return ASN1Collection.this.obj1;
                case 2:
                    return ASN1Collection.this.obj2;
                case 3:
                    return ASN1Collection.this.obj3;
                default:
                    return ASN1Collection.this.rest[this.at - 5];
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sort() {
        if (this.size > 1) {
            boolean z = true;
            while (z) {
                byte[] encoded = getEncoded(getObjectAt(0));
                z = false;
                for (int i = 0; i != this.size - 1; i++) {
                    int i2 = i + 1;
                    byte[] encoded2 = getEncoded(getObjectAt(i2));
                    if (lessThanOrEqual(encoded, encoded2)) {
                        encoded = encoded2;
                    } else {
                        DEREncodable objectAt = getObjectAt(i);
                        setObjectAt(getObjectAt(i2), i);
                        setObjectAt(objectAt, i2);
                        z = true;
                    }
                }
            }
        }
    }

    private static boolean lessThanOrEqual(byte[] bArr, byte[] bArr2) {
        int i;
        int i2;
        if (bArr.length <= bArr2.length) {
            for (int i3 = 0; i3 != bArr.length && (i2 = bArr2[i3] & 255) <= (i = bArr[i3] & 255); i3++) {
                if (i > i2) {
                    return false;
                }
            }
            return true;
        }
        for (int i4 = 0; i4 != bArr2.length; i4++) {
            int i5 = bArr[i4] & 255;
            int i6 = bArr2[i4] & 255;
            if (i6 > i5) {
                return true;
            }
            if (i5 > i6) {
                return false;
            }
        }
        return false;
    }

    private static byte[] getEncoded(DEREncodable dEREncodable) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ASN1OutputStream(byteArrayOutputStream).writeObject(dEREncodable);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new IllegalArgumentException("cannot encode object added to collection");
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < this.size; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(getObjectAt(i));
        }
        sb.append(']');
        return sb.toString();
    }
}
