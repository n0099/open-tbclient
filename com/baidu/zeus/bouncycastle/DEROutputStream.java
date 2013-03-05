package com.baidu.zeus.bouncycastle;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class DEROutputStream extends FilterOutputStream implements DERTags {
    public DEROutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    private void writeLength(int i) {
        if (i > 127) {
            int i2 = 1;
            int i3 = i;
            while (true) {
                i3 >>>= 8;
                if (i3 == 0) {
                    break;
                }
                i2++;
            }
            write((byte) (i2 | DERTags.TAGGED));
            for (int i4 = (i2 - 1) * 8; i4 >= 0; i4 -= 8) {
                write((byte) (i >> i4));
            }
            return;
        }
        write((byte) i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeEncoded(int i, byte[] bArr) {
        write(i);
        writeLength(bArr.length);
        write(bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void writeNull() {
        write(5);
        write(0);
    }

    public void writeObject(Object obj) {
        if (obj == null) {
            writeNull();
        } else if (obj instanceof DERObject) {
            ((DERObject) obj).encode(this);
        } else if (obj instanceof DEREncodable) {
            ((DEREncodable) obj).getDERObject().encode(this);
        } else {
            throw new IOException("object not DEREncodable");
        }
    }
}
