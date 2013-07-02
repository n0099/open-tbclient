package com.baidu.zeus.bouncycastle;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class ASN1OutputStream extends DEROutputStream {
    public ASN1OutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // com.baidu.zeus.bouncycastle.DEROutputStream
    public void writeObject(Object obj) {
        if (obj == null) {
            writeNull();
        } else if (obj instanceof DERObject) {
            ((DERObject) obj).encode(this);
        } else if (obj instanceof DEREncodable) {
            ((DEREncodable) obj).getDERObject().encode(this);
        } else {
            throw new IOException("object not ASN1Encodable");
        }
    }
}
