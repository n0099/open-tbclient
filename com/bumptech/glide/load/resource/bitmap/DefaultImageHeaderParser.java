package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.internal.view.SupportMenu;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
/* loaded from: classes5.dex */
public final class DefaultImageHeaderParser implements ImageHeaderParser {
    public static final int EXIF_MAGIC_NUMBER = 65496;
    public static final int EXIF_SEGMENT_TYPE = 225;
    public static final int GIF_HEADER = 4671814;
    public static final int INTEL_TIFF_MAGIC_NUMBER = 18761;
    public static final int MARKER_EOI = 217;
    public static final int MOTOROLA_TIFF_MAGIC_NUMBER = 19789;
    public static final int ORIENTATION_TAG_TYPE = 274;
    public static final int PNG_HEADER = -1991225785;
    public static final int RIFF_HEADER = 1380533830;
    public static final int SEGMENT_SOS = 218;
    public static final int SEGMENT_START_ID = 255;
    public static final String TAG = "DfltImageHeaderParser";
    public static final int VP8_HEADER = 1448097792;
    public static final int VP8_HEADER_MASK = -256;
    public static final int VP8_HEADER_TYPE_EXTENDED = 88;
    public static final int VP8_HEADER_TYPE_LOSSLESS = 76;
    public static final int VP8_HEADER_TYPE_MASK = 255;
    public static final int WEBP_EXTENDED_ALPHA_FLAG = 16;
    public static final int WEBP_HEADER = 1464156752;
    public static final int WEBP_LOSSLESS_ALPHA_FLAG = 8;
    public static final String JPEG_EXIF_SEGMENT_PREAMBLE = "Exif\u0000\u0000";
    public static final byte[] JPEG_EXIF_SEGMENT_PREAMBLE_BYTES = JPEG_EXIF_SEGMENT_PREAMBLE.getBytes(Charset.forName("UTF-8"));
    public static final int[] BYTES_PER_FORMAT = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* loaded from: classes5.dex */
    public static final class ByteBufferReader implements Reader {
        public final ByteBuffer byteBuffer;

        public ByteBufferReader(ByteBuffer byteBuffer) {
            this.byteBuffer = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int getByte() {
            if (this.byteBuffer.remaining() < 1) {
                return -1;
            }
            return this.byteBuffer.get();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int getUInt16() {
            return ((getByte() << 8) & 65280) | (getByte() & 255);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short getUInt8() {
            return (short) (getByte() & 255);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int read(byte[] bArr, int i2) {
            int min = Math.min(i2, this.byteBuffer.remaining());
            if (min == 0) {
                return -1;
            }
            this.byteBuffer.get(bArr, 0, min);
            return min;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long skip(long j) {
            int min = (int) Math.min(this.byteBuffer.remaining(), j);
            ByteBuffer byteBuffer = this.byteBuffer;
            byteBuffer.position(byteBuffer.position() + min);
            return min;
        }
    }

    /* loaded from: classes5.dex */
    public static final class RandomAccessReader {
        public final ByteBuffer data;

        public RandomAccessReader(byte[] bArr, int i2) {
            this.data = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i2);
        }

        private boolean isAvailable(int i2, int i3) {
            return this.data.remaining() - i2 >= i3;
        }

        public short getInt16(int i2) {
            if (isAvailable(i2, 2)) {
                return this.data.getShort(i2);
            }
            return (short) -1;
        }

        public int getInt32(int i2) {
            if (isAvailable(i2, 4)) {
                return this.data.getInt(i2);
            }
            return -1;
        }

        public int length() {
            return this.data.remaining();
        }

        public void order(ByteOrder byteOrder) {
            this.data.order(byteOrder);
        }
    }

    /* loaded from: classes5.dex */
    public interface Reader {
        int getByte() throws IOException;

        int getUInt16() throws IOException;

        short getUInt8() throws IOException;

        int read(byte[] bArr, int i2) throws IOException;

        long skip(long j) throws IOException;
    }

    /* loaded from: classes5.dex */
    public static final class StreamReader implements Reader {
        public final InputStream is;

        public StreamReader(InputStream inputStream) {
            this.is = inputStream;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int getByte() throws IOException {
            return this.is.read();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int getUInt16() throws IOException {
            return ((this.is.read() << 8) & 65280) | (this.is.read() & 255);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short getUInt8() throws IOException {
            return (short) (this.is.read() & 255);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int read(byte[] bArr, int i2) throws IOException {
            int i3 = i2;
            while (i3 > 0) {
                int read = this.is.read(bArr, i2 - i3, i3);
                if (read == -1) {
                    break;
                }
                i3 -= read;
            }
            return i2 - i3;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long skip(long j) throws IOException {
            if (j < 0) {
                return 0L;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.is.skip(j2);
                if (skip <= 0) {
                    if (this.is.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j2 -= skip;
            }
            return j - j2;
        }
    }

    public static int calcTagOffset(int i2, int i3) {
        return i2 + 2 + (i3 * 12);
    }

    public static boolean handles(int i2) {
        return (i2 & EXIF_MAGIC_NUMBER) == 65496 || i2 == 19789 || i2 == 18761;
    }

    private boolean hasJpegExifPreamble(byte[] bArr, int i2) {
        boolean z = bArr != null && i2 > JPEG_EXIF_SEGMENT_PREAMBLE_BYTES.length;
        if (z) {
            int i3 = 0;
            while (true) {
                byte[] bArr2 = JPEG_EXIF_SEGMENT_PREAMBLE_BYTES;
                if (i3 >= bArr2.length) {
                    break;
                } else if (bArr[i3] != bArr2[i3]) {
                    return false;
                } else {
                    i3++;
                }
            }
        }
        return z;
    }

    private int moveToExifSegmentAndGetLength(Reader reader) throws IOException {
        short uInt8;
        short uInt82;
        int uInt16;
        long j;
        long skip;
        do {
            if (reader.getUInt8() != 255) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Unknown segmentId=" + ((int) uInt8));
                }
                return -1;
            }
            uInt82 = reader.getUInt8();
            if (uInt82 == 218) {
                return -1;
            }
            if (uInt82 == 217) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            uInt16 = reader.getUInt16() - 2;
            if (uInt82 == 225) {
                return uInt16;
            }
            j = uInt16;
            skip = reader.skip(j);
        } while (skip == j);
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "Unable to skip enough data, type: " + ((int) uInt82) + ", wanted to skip: " + uInt16 + ", but actually skipped: " + skip);
        }
        return -1;
    }

    private int parseExifSegment(Reader reader, byte[] bArr, int i2) throws IOException {
        int read = reader.read(bArr, i2);
        if (read != i2) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Unable to read exif segment data, length: " + i2 + ", actually read: " + read);
            }
            return -1;
        } else if (hasJpegExifPreamble(bArr, i2)) {
            return parseExifSegment(new RandomAccessReader(bArr, i2));
        } else {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Missing jpeg exif preamble");
            }
            return -1;
        }
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int getOrientation(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool) throws IOException {
        return getOrientation(new StreamReader((InputStream) Preconditions.checkNotNull(inputStream)), (ArrayPool) Preconditions.checkNotNull(arrayPool));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType getType(@NonNull InputStream inputStream) throws IOException {
        return getType(new StreamReader((InputStream) Preconditions.checkNotNull(inputStream)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType getType(@NonNull ByteBuffer byteBuffer) throws IOException {
        return getType(new ByteBufferReader((ByteBuffer) Preconditions.checkNotNull(byteBuffer)));
    }

    @NonNull
    private ImageHeaderParser.ImageType getType(Reader reader) throws IOException {
        int uInt16 = reader.getUInt16();
        if (uInt16 == 65496) {
            return ImageHeaderParser.ImageType.JPEG;
        }
        int uInt162 = ((uInt16 << 16) & SupportMenu.CATEGORY_MASK) | (reader.getUInt16() & 65535);
        if (uInt162 == -1991225785) {
            reader.skip(21L);
            return reader.getByte() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
        } else if ((uInt162 >> 8) == 4671814) {
            return ImageHeaderParser.ImageType.GIF;
        } else {
            if (uInt162 != 1380533830) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            reader.skip(4L);
            if ((((reader.getUInt16() << 16) & SupportMenu.CATEGORY_MASK) | (reader.getUInt16() & 65535)) != 1464156752) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int uInt163 = ((reader.getUInt16() << 16) & SupportMenu.CATEGORY_MASK) | (reader.getUInt16() & 65535);
            if ((uInt163 & (-256)) != 1448097792) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int i2 = uInt163 & 255;
            if (i2 == 88) {
                reader.skip(4L);
                return (reader.getByte() & 16) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            } else if (i2 == 76) {
                reader.skip(4L);
                return (reader.getByte() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            } else {
                return ImageHeaderParser.ImageType.WEBP;
            }
        }
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int getOrientation(@NonNull ByteBuffer byteBuffer, @NonNull ArrayPool arrayPool) throws IOException {
        return getOrientation(new ByteBufferReader((ByteBuffer) Preconditions.checkNotNull(byteBuffer)), (ArrayPool) Preconditions.checkNotNull(arrayPool));
    }

    private int getOrientation(Reader reader, ArrayPool arrayPool) throws IOException {
        int uInt16 = reader.getUInt16();
        if (!handles(uInt16)) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Parser doesn't handle magic number: " + uInt16);
            }
            return -1;
        }
        int moveToExifSegmentAndGetLength = moveToExifSegmentAndGetLength(reader);
        if (moveToExifSegmentAndGetLength == -1) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Failed to parse exif segment length, or exif segment not found");
            }
            return -1;
        }
        byte[] bArr = (byte[]) arrayPool.get(moveToExifSegmentAndGetLength, byte[].class);
        try {
            return parseExifSegment(reader, bArr, moveToExifSegmentAndGetLength);
        } finally {
            arrayPool.put(bArr);
        }
    }

    public static int parseExifSegment(RandomAccessReader randomAccessReader) {
        ByteOrder byteOrder;
        short int16 = randomAccessReader.getInt16(6);
        if (int16 == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else if (int16 != 19789) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Unknown endianness = " + ((int) int16));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        randomAccessReader.order(byteOrder);
        int int32 = randomAccessReader.getInt32(10) + 6;
        short int162 = randomAccessReader.getInt16(int32);
        for (int i2 = 0; i2 < int162; i2++) {
            int calcTagOffset = calcTagOffset(int32, i2);
            short int163 = randomAccessReader.getInt16(calcTagOffset);
            if (int163 == 274) {
                short int164 = randomAccessReader.getInt16(calcTagOffset + 2);
                if (int164 >= 1 && int164 <= 12) {
                    int int322 = randomAccessReader.getInt32(calcTagOffset + 4);
                    if (int322 < 0) {
                        if (Log.isLoggable(TAG, 3)) {
                            Log.d(TAG, "Negative tiff component count");
                        }
                    } else {
                        if (Log.isLoggable(TAG, 3)) {
                            Log.d(TAG, "Got tagIndex=" + i2 + " tagType=" + ((int) int163) + " formatCode=" + ((int) int164) + " componentCount=" + int322);
                        }
                        int i3 = int322 + BYTES_PER_FORMAT[int164];
                        if (i3 > 4) {
                            if (Log.isLoggable(TAG, 3)) {
                                Log.d(TAG, "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) int164));
                            }
                        } else {
                            int i4 = calcTagOffset + 8;
                            if (i4 >= 0 && i4 <= randomAccessReader.length()) {
                                if (i3 >= 0 && i3 + i4 <= randomAccessReader.length()) {
                                    return randomAccessReader.getInt16(i4);
                                }
                                if (Log.isLoggable(TAG, 3)) {
                                    Log.d(TAG, "Illegal number of bytes for TI tag data tagType=" + ((int) int163));
                                }
                            } else if (Log.isLoggable(TAG, 3)) {
                                Log.d(TAG, "Illegal tagValueOffset=" + i4 + " tagType=" + ((int) int163));
                            }
                        }
                    }
                } else if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Got invalid format code = " + ((int) int164));
                }
            }
        }
        return -1;
    }
}
