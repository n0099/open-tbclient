package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.BufferedOutputStream;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.GlideTrace;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes5.dex */
public class BitmapEncoder implements ResourceEncoder<Bitmap> {
    private static final String TAG = "BitmapEncoder";
    @Nullable
    private final ArrayPool arrayPool;
    public static final Option<Integer> COMPRESSION_QUALITY = Option.memory("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
    public static final Option<Bitmap.CompressFormat> COMPRESSION_FORMAT = Option.memory("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    public BitmapEncoder(@NonNull ArrayPool arrayPool) {
        this.arrayPool = arrayPool;
    }

    @Deprecated
    public BitmapEncoder() {
        this.arrayPool = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [96=4] */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0059 A[Catch: all -> 0x00de, TRY_LEAVE, TryCatch #7 {all -> 0x00de, blocks: (B:3:0x0020, B:12:0x004c, B:13:0x004f, B:15:0x0059, B:31:0x00da, B:32:0x00dd, B:24:0x00cc), top: B:54:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.bumptech.glide.load.Encoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean encode(@NonNull Resource<Bitmap> resource, @NonNull File file, @NonNull Options options) {
        OutputStream outputStream;
        boolean z;
        Bitmap bitmap = resource.get();
        Bitmap.CompressFormat format = getFormat(bitmap, options);
        GlideTrace.beginSectionFormat("encode: [%dx%d] %s", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), format);
        try {
            long logTime = LogTime.getLogTime();
            int intValue = ((Integer) options.get(COMPRESSION_QUALITY)).intValue();
            try {
                outputStream = new FileOutputStream(file);
                try {
                    try {
                        if (this.arrayPool != null) {
                            outputStream = new BufferedOutputStream(outputStream, this.arrayPool);
                        }
                        bitmap.compress(format, intValue, outputStream);
                        outputStream.close();
                        z = true;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e) {
                            }
                        }
                    } catch (IOException e2) {
                        e = e2;
                        if (Log.isLoggable(TAG, 3)) {
                            Log.d(TAG, "Failed to encode Bitmap", e);
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                                z = false;
                            } catch (IOException e3) {
                                z = false;
                            }
                        } else {
                            z = false;
                        }
                        if (Log.isLoggable(TAG, 2)) {
                        }
                        return z;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                outputStream = null;
            } catch (Throwable th2) {
                th = th2;
                outputStream = null;
                if (outputStream != null) {
                }
                throw th;
            }
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Compressed with type: " + format + " of size " + Util.getBitmapByteSize(bitmap) + " in " + LogTime.getElapsedMillis(logTime) + ", options format: " + options.get(COMPRESSION_FORMAT) + ", hasAlpha: " + bitmap.hasAlpha());
            }
            return z;
        } finally {
            GlideTrace.endSection();
        }
    }

    private Bitmap.CompressFormat getFormat(Bitmap bitmap, Options options) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) options.get(COMPRESSION_FORMAT);
        if (compressFormat == null) {
            if (bitmap.hasAlpha()) {
                return Bitmap.CompressFormat.PNG;
            }
            return Bitmap.CompressFormat.JPEG;
        }
        return compressFormat;
    }

    @Override // com.bumptech.glide.load.ResourceEncoder
    @NonNull
    public EncodeStrategy getEncodeStrategy(@NonNull Options options) {
        return EncodeStrategy.TRANSFORMED;
    }
}
