package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
/* loaded from: classes7.dex */
public final class DefaultImageHeaderParser implements ImageHeaderParser {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int[] BYTES_PER_FORMAT;
    public static final int EXIF_MAGIC_NUMBER = 65496;
    public static final int EXIF_SEGMENT_TYPE = 225;
    public static final int GIF_HEADER = 4671814;
    public static final int INTEL_TIFF_MAGIC_NUMBER = 18761;
    public static final String JPEG_EXIF_SEGMENT_PREAMBLE = "Exif\u0000\u0000";
    public static final byte[] JPEG_EXIF_SEGMENT_PREAMBLE_BYTES;
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
    public transient /* synthetic */ FieldHolder $fh;

    public static int calcTagOffset(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i, i2)) == null) ? i + 2 + (i2 * 12) : invokeII.intValue;
    }

    public static boolean handles(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) ? (i & EXIF_MAGIC_NUMBER) == 65496 || i == 19789 || i == 18761 : invokeI.booleanValue;
    }

    /* loaded from: classes7.dex */
    public interface Reader {
        int getUInt16() throws IOException;

        short getUInt8() throws IOException;

        int read(byte[] bArr, int i) throws IOException;

        long skip(long j) throws IOException;

        /* loaded from: classes7.dex */
        public static final class EndOfFileException extends IOException {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = 1;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EndOfFileException() {
                super("Unexpectedly reached end of a file");
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((String) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class ByteBufferReader implements Reader {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ByteBuffer byteBuffer;

        public ByteBufferReader(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {byteBuffer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.byteBuffer = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int getUInt16() throws Reader.EndOfFileException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return (getUInt8() << 8) | getUInt8();
            }
            return invokeV.intValue;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short getUInt8() throws Reader.EndOfFileException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.byteBuffer.remaining() >= 1) {
                    return (short) (this.byteBuffer.get() & 255);
                }
                throw new Reader.EndOfFileException();
            }
            return invokeV.shortValue;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int read(byte[] bArr, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, bArr, i)) == null) {
                int min = Math.min(i, this.byteBuffer.remaining());
                if (min == 0) {
                    return -1;
                }
                this.byteBuffer.get(bArr, 0, min);
                return min;
            }
            return invokeLI.intValue;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long skip(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
                int min = (int) Math.min(this.byteBuffer.remaining(), j);
                ByteBuffer byteBuffer = this.byteBuffer;
                byteBuffer.position(byteBuffer.position() + min);
                return min;
            }
            return invokeJ.longValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class RandomAccessReader {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ByteBuffer data;

        public RandomAccessReader(byte[] bArr, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bArr, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.data = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        private boolean isAvailable(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(65537, this, i, i2)) == null) {
                if (this.data.remaining() - i >= i2) {
                    return true;
                }
                return false;
            }
            return invokeII.booleanValue;
        }

        public short getInt16(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (isAvailable(i, 2)) {
                    return this.data.getShort(i);
                }
                return (short) -1;
            }
            return invokeI.shortValue;
        }

        public int getInt32(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                if (isAvailable(i, 4)) {
                    return this.data.getInt(i);
                }
                return -1;
            }
            return invokeI.intValue;
        }

        public void order(ByteOrder byteOrder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, byteOrder) == null) {
                this.data.order(byteOrder);
            }
        }

        public int length() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.data.remaining();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class StreamReader implements Reader {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final InputStream is;

        public StreamReader(InputStream inputStream) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.is = inputStream;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int getUInt16() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return (getUInt8() << 8) | getUInt8();
            }
            return invokeV.intValue;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short getUInt8() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int read = this.is.read();
                if (read != -1) {
                    return (short) read;
                }
                throw new Reader.EndOfFileException();
            }
            return invokeV.shortValue;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int read(byte[] bArr, int i) throws IOException {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, bArr, i)) == null) {
                int i2 = 0;
                int i3 = 0;
                while (i2 < i && (i3 = this.is.read(bArr, i2, i - i2)) != -1) {
                    i2 += i3;
                }
                if (i2 == 0 && i3 == -1) {
                    throw new Reader.EndOfFileException();
                }
                return i2;
            }
            return invokeLI.intValue;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long skip(long j) throws IOException {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
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
            return invokeJ.longValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-773575584, "Lcom/bumptech/glide/load/resource/bitmap/DefaultImageHeaderParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-773575584, "Lcom/bumptech/glide/load/resource/bitmap/DefaultImageHeaderParser;");
                return;
            }
        }
        JPEG_EXIF_SEGMENT_PREAMBLE_BYTES = JPEG_EXIF_SEGMENT_PREAMBLE.getBytes(Charset.forName("UTF-8"));
        BYTES_PER_FORMAT = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    }

    public DefaultImageHeaderParser() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private int getOrientation(Reader reader, ArrayPool arrayPool) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, reader, arrayPool)) == null) {
            try {
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
                int parseExifSegment = parseExifSegment(reader, bArr, moveToExifSegmentAndGetLength);
                arrayPool.put(bArr);
                return parseExifSegment;
            } catch (Reader.EndOfFileException unused) {
                return -1;
            }
        }
        return invokeLL.intValue;
    }

    @NonNull
    private ImageHeaderParser.ImageType getType(Reader reader) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, reader)) == null) {
            try {
                int uInt16 = reader.getUInt16();
                if (uInt16 == 65496) {
                    return ImageHeaderParser.ImageType.JPEG;
                }
                int uInt8 = (uInt16 << 8) | reader.getUInt8();
                if (uInt8 == 4671814) {
                    return ImageHeaderParser.ImageType.GIF;
                }
                int uInt82 = (uInt8 << 8) | reader.getUInt8();
                if (uInt82 == -1991225785) {
                    reader.skip(21L);
                    try {
                        if (reader.getUInt8() >= 3) {
                            return ImageHeaderParser.ImageType.PNG_A;
                        }
                        return ImageHeaderParser.ImageType.PNG;
                    } catch (Reader.EndOfFileException unused) {
                        return ImageHeaderParser.ImageType.PNG;
                    }
                } else if (uInt82 != 1380533830) {
                    return ImageHeaderParser.ImageType.UNKNOWN;
                } else {
                    reader.skip(4L);
                    if (((reader.getUInt16() << 16) | reader.getUInt16()) != 1464156752) {
                        return ImageHeaderParser.ImageType.UNKNOWN;
                    }
                    int uInt162 = (reader.getUInt16() << 16) | reader.getUInt16();
                    if ((uInt162 & (-256)) != 1448097792) {
                        return ImageHeaderParser.ImageType.UNKNOWN;
                    }
                    int i = uInt162 & 255;
                    if (i == 88) {
                        reader.skip(4L);
                        if ((reader.getUInt8() & 16) != 0) {
                            return ImageHeaderParser.ImageType.WEBP_A;
                        }
                        return ImageHeaderParser.ImageType.WEBP;
                    } else if (i == 76) {
                        reader.skip(4L);
                        if ((reader.getUInt8() & 8) != 0) {
                            return ImageHeaderParser.ImageType.WEBP_A;
                        }
                        return ImageHeaderParser.ImageType.WEBP;
                    } else {
                        return ImageHeaderParser.ImageType.WEBP;
                    }
                }
            } catch (Reader.EndOfFileException unused2) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
        }
        return (ImageHeaderParser.ImageType) invokeL.objValue;
    }

    private boolean hasJpegExifPreamble(byte[] bArr, int i) {
        InterceptResult invokeLI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, this, bArr, i)) == null) {
            if (bArr != null && i > JPEG_EXIF_SEGMENT_PREAMBLE_BYTES.length) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                int i2 = 0;
                while (true) {
                    byte[] bArr2 = JPEG_EXIF_SEGMENT_PREAMBLE_BYTES;
                    if (i2 >= bArr2.length) {
                        break;
                    } else if (bArr[i2] != bArr2[i2]) {
                        return false;
                    } else {
                        i2++;
                    }
                }
            }
            return z;
        }
        return invokeLI.booleanValue;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int getOrientation(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, inputStream, arrayPool)) == null) {
            return getOrientation(new StreamReader((InputStream) Preconditions.checkNotNull(inputStream)), (ArrayPool) Preconditions.checkNotNull(arrayPool));
        }
        return invokeLL.intValue;
    }

    private int moveToExifSegmentAndGetLength(Reader reader) throws IOException {
        short uInt8;
        short uInt82;
        int uInt16;
        long j;
        long skip;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, reader)) == null) {
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
                if (uInt82 != 225) {
                    j = uInt16;
                    skip = reader.skip(j);
                } else {
                    return uInt16;
                }
            } while (skip == j);
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Unable to skip enough data, type: " + ((int) uInt82) + ", wanted to skip: " + uInt16 + ", but actually skipped: " + skip);
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static int parseExifSegment(RandomAccessReader randomAccessReader) {
        InterceptResult invokeL;
        ByteOrder byteOrder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, randomAccessReader)) == null) {
            short int16 = randomAccessReader.getInt16(6);
            if (int16 != 18761) {
                if (int16 != 19789) {
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "Unknown endianness = " + ((int) int16));
                    }
                    byteOrder = ByteOrder.BIG_ENDIAN;
                } else {
                    byteOrder = ByteOrder.BIG_ENDIAN;
                }
            } else {
                byteOrder = ByteOrder.LITTLE_ENDIAN;
            }
            randomAccessReader.order(byteOrder);
            int int32 = randomAccessReader.getInt32(10) + 6;
            short int162 = randomAccessReader.getInt16(int32);
            for (int i = 0; i < int162; i++) {
                int calcTagOffset = calcTagOffset(int32, i);
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
                                Log.d(TAG, "Got tagIndex=" + i + " tagType=" + ((int) int163) + " formatCode=" + ((int) int164) + " componentCount=" + int322);
                            }
                            int i2 = int322 + BYTES_PER_FORMAT[int164];
                            if (i2 > 4) {
                                if (Log.isLoggable(TAG, 3)) {
                                    Log.d(TAG, "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) int164));
                                }
                            } else {
                                int i3 = calcTagOffset + 8;
                                if (i3 >= 0 && i3 <= randomAccessReader.length()) {
                                    if (i2 >= 0 && i2 + i3 <= randomAccessReader.length()) {
                                        return randomAccessReader.getInt16(i3);
                                    }
                                    if (Log.isLoggable(TAG, 3)) {
                                        Log.d(TAG, "Illegal number of bytes for TI tag data tagType=" + ((int) int163));
                                    }
                                } else if (Log.isLoggable(TAG, 3)) {
                                    Log.d(TAG, "Illegal tagValueOffset=" + i3 + " tagType=" + ((int) int163));
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
        return invokeL.intValue;
    }

    private int parseExifSegment(Reader reader, byte[] bArr, int i) throws IOException {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65545, this, reader, bArr, i)) == null) {
            int read = reader.read(bArr, i);
            if (read != i) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Unable to read exif segment data, length: " + i + ", actually read: " + read);
                }
                return -1;
            } else if (hasJpegExifPreamble(bArr, i)) {
                return parseExifSegment(new RandomAccessReader(bArr, i));
            } else {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Missing jpeg exif preamble");
                }
                return -1;
            }
        }
        return invokeLLI.intValue;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int getOrientation(@NonNull ByteBuffer byteBuffer, @NonNull ArrayPool arrayPool) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteBuffer, arrayPool)) == null) {
            return getOrientation(new ByteBufferReader((ByteBuffer) Preconditions.checkNotNull(byteBuffer)), (ArrayPool) Preconditions.checkNotNull(arrayPool));
        }
        return invokeLL.intValue;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType getType(@NonNull InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, inputStream)) == null) {
            return getType(new StreamReader((InputStream) Preconditions.checkNotNull(inputStream)));
        }
        return (ImageHeaderParser.ImageType) invokeL.objValue;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType getType(@NonNull ByteBuffer byteBuffer) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, byteBuffer)) == null) {
            return getType(new ByteBufferReader((ByteBuffer) Preconditions.checkNotNull(byteBuffer)));
        }
        return (ImageHeaderParser.ImageType) invokeL.objValue;
    }
}
