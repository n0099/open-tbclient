package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
/* loaded from: classes7.dex */
public final class ImageHeaderParserUtils {
    public static final int MARK_READ_LIMIT = 5242880;

    /* loaded from: classes7.dex */
    public interface OrientationReader {
        int getOrientation(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    /* loaded from: classes7.dex */
    public interface TypeReader {
        ImageHeaderParser.ImageType getType(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    @RequiresApi(21)
    public static int getOrientation(@NonNull List<ImageHeaderParser> list, @NonNull final ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, @NonNull final ArrayPool arrayPool) throws IOException {
        return getOrientationInternal(list, new OrientationReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.5
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.OrientationReader
            public int getOrientation(ImageHeaderParser imageHeaderParser) throws IOException {
                RecyclableBufferedInputStream recyclableBufferedInputStream = null;
                try {
                    RecyclableBufferedInputStream recyclableBufferedInputStream2 = new RecyclableBufferedInputStream(new FileInputStream(ParcelFileDescriptorRewinder.this.rewindAndGet().getFileDescriptor()), arrayPool);
                    try {
                        int orientation = imageHeaderParser.getOrientation(recyclableBufferedInputStream2, arrayPool);
                        try {
                            recyclableBufferedInputStream2.close();
                        } catch (IOException unused) {
                        }
                        ParcelFileDescriptorRewinder.this.rewindAndGet();
                        return orientation;
                    } catch (Throwable th) {
                        th = th;
                        recyclableBufferedInputStream = recyclableBufferedInputStream2;
                        if (recyclableBufferedInputStream != null) {
                            try {
                                recyclableBufferedInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        ParcelFileDescriptorRewinder.this.rewindAndGet();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        });
    }

    @NonNull
    @RequiresApi(21)
    public static ImageHeaderParser.ImageType getType(@NonNull List<ImageHeaderParser> list, @NonNull final ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, @NonNull final ArrayPool arrayPool) throws IOException {
        return getTypeInternal(list, new TypeReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.3
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
            public ImageHeaderParser.ImageType getType(ImageHeaderParser imageHeaderParser) throws IOException {
                RecyclableBufferedInputStream recyclableBufferedInputStream = null;
                try {
                    RecyclableBufferedInputStream recyclableBufferedInputStream2 = new RecyclableBufferedInputStream(new FileInputStream(ParcelFileDescriptorRewinder.this.rewindAndGet().getFileDescriptor()), arrayPool);
                    try {
                        ImageHeaderParser.ImageType type = imageHeaderParser.getType(recyclableBufferedInputStream2);
                        try {
                            recyclableBufferedInputStream2.close();
                        } catch (IOException unused) {
                        }
                        ParcelFileDescriptorRewinder.this.rewindAndGet();
                        return type;
                    } catch (Throwable th) {
                        th = th;
                        recyclableBufferedInputStream = recyclableBufferedInputStream2;
                        if (recyclableBufferedInputStream != null) {
                            try {
                                recyclableBufferedInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        ParcelFileDescriptorRewinder.this.rewindAndGet();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        });
    }

    public static int getOrientation(@NonNull List<ImageHeaderParser> list, @Nullable final InputStream inputStream, @NonNull final ArrayPool arrayPool) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream.mark(5242880);
        return getOrientationInternal(list, new OrientationReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.4
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.OrientationReader
            public int getOrientation(ImageHeaderParser imageHeaderParser) throws IOException {
                try {
                    return imageHeaderParser.getOrientation(inputStream, arrayPool);
                } finally {
                    inputStream.reset();
                }
            }
        });
    }

    @NonNull
    public static ImageHeaderParser.ImageType getType(@NonNull List<ImageHeaderParser> list, @Nullable final InputStream inputStream, @NonNull ArrayPool arrayPool) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream.mark(5242880);
        return getTypeInternal(list, new TypeReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.1
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
            public ImageHeaderParser.ImageType getType(ImageHeaderParser imageHeaderParser) throws IOException {
                try {
                    return imageHeaderParser.getType(inputStream);
                } finally {
                    inputStream.reset();
                }
            }
        });
    }

    public static int getOrientationInternal(@NonNull List<ImageHeaderParser> list, OrientationReader orientationReader) throws IOException {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int orientation = orientationReader.getOrientation(list.get(i));
            if (orientation != -1) {
                return orientation;
            }
        }
        return -1;
    }

    @NonNull
    public static ImageHeaderParser.ImageType getType(@NonNull List<ImageHeaderParser> list, @Nullable final ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        return getTypeInternal(list, new TypeReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.2
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
            public ImageHeaderParser.ImageType getType(ImageHeaderParser imageHeaderParser) throws IOException {
                return imageHeaderParser.getType(byteBuffer);
            }
        });
    }

    @NonNull
    public static ImageHeaderParser.ImageType getTypeInternal(@NonNull List<ImageHeaderParser> list, TypeReader typeReader) throws IOException {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ImageHeaderParser.ImageType type = typeReader.getType(list.get(i));
            if (type != ImageHeaderParser.ImageType.UNKNOWN) {
                return type;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}
