package com.baidu.zeus;

import android.content.Context;
import android.os.Handler;
import com.baidu.zeus.ByteArrayBuilder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class KeyStoreHandler extends Handler {
    private static final String LOGTAG = "KeyStoreHandler";
    private final ByteArrayBuilder mDataBuilder = new ByteArrayBuilder();
    private String mMimeType;

    public KeyStoreHandler(String str) {
        this.mMimeType = str;
    }

    public void didReceiveData(byte[] bArr, int i) {
        synchronized (this.mDataBuilder) {
            this.mDataBuilder.append(bArr, 0, i);
        }
    }

    public void installCert(Context context) {
        int i = 0;
        String certType = CertTool.getCertType(this.mMimeType);
        if (certType != null) {
            synchronized (this.mDataBuilder) {
                byte[] bArr = new byte[this.mDataBuilder.getByteSize()];
                while (true) {
                    ByteArrayBuilder.Chunk firstChunk = this.mDataBuilder.getFirstChunk();
                    if (firstChunk != null) {
                        if (firstChunk.mLength != 0) {
                            System.arraycopy(firstChunk.mArray, 0, bArr, i, firstChunk.mLength);
                            i += firstChunk.mLength;
                        }
                        firstChunk.release();
                    } else {
                        CertTool.addCertificate(context, certType, bArr);
                    }
                }
            }
        }
    }
}
