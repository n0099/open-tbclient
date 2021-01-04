package com.bumptech.glide.load.model;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class StreamEncoder implements Encoder<InputStream> {
    private static final String TAG = "StreamEncoder";
    private final ArrayPool byteArrayPool;

    public StreamEncoder(ArrayPool arrayPool) {
        this.byteArrayPool = arrayPool;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [44=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x0062 */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0053 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Class<byte[]>, java.lang.Class] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.OutputStream] */
    @Override // com.bumptech.glide.load.Encoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean encode(@NonNull InputStream inputStream, @NonNull File file, @NonNull Options options) {
        FileOutputStream fileOutputStream;
        ?? r3 = byte[].class;
        byte[] bArr = (byte[]) this.byteArrayPool.get(65536, r3);
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    } catch (IOException e) {
                        e = e;
                        if (Log.isLoggable(TAG, 3)) {
                            Log.d(TAG, "Failed to encode data onto the OutputStream", e);
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e2) {
                            }
                        }
                        this.byteArrayPool.put(bArr);
                        return false;
                    }
                }
                fileOutputStream.close();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e3) {
                    }
                }
                this.byteArrayPool.put(bArr);
                return true;
            } catch (Throwable th) {
                th = th;
                if (r3 != 0) {
                    try {
                        r3.close();
                    } catch (IOException e4) {
                    }
                }
                this.byteArrayPool.put(bArr);
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            r3 = 0;
            if (r3 != 0) {
            }
            this.byteArrayPool.put(bArr);
            throw th;
        }
    }
}
