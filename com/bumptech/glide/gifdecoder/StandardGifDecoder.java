package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.gifdecoder.GifDecoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class StandardGifDecoder implements GifDecoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BYTES_PER_INTEGER = 4;
    @ColorInt
    public static final int COLOR_TRANSPARENT_BLACK = 0;
    public static final int INITIAL_FRAME_POINTER = -1;
    public static final int MASK_INT_LOWEST_BYTE = 255;
    public static final int MAX_STACK_SIZE = 4096;
    public static final int NULL_CODE = -1;
    public static final String TAG = "StandardGifDecoder";
    public transient /* synthetic */ FieldHolder $fh;
    @ColorInt
    public int[] act;
    @NonNull
    public Bitmap.Config bitmapConfig;
    public final GifDecoder.BitmapProvider bitmapProvider;
    public byte[] block;
    public int downsampledHeight;
    public int downsampledWidth;
    public int framePointer;
    public GifHeader header;
    @Nullable
    public Boolean isFirstFrameTransparent;
    public byte[] mainPixels;
    @ColorInt
    public int[] mainScratch;
    public GifHeaderParser parser;
    @ColorInt
    public final int[] pct;
    public byte[] pixelStack;
    public short[] prefix;
    public Bitmap previousImage;
    public ByteBuffer rawData;
    public int sampleSize;
    public boolean savePrevious;
    public int status;
    public byte[] suffix;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1996867810, "Lcom/bumptech/glide/gifdecoder/StandardGifDecoder;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1996867810, "Lcom/bumptech/glide/gifdecoder/StandardGifDecoder;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer) {
        this(bitmapProvider, gifHeader, byteBuffer, 1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmapProvider, gifHeader, byteBuffer};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((GifDecoder.BitmapProvider) objArr2[0], (GifHeader) objArr2[1], (ByteBuffer) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    @ColorInt
    private int averageColorsNear(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(InputDeviceCompat.SOURCE_TRACKBALL, this, i, i2, i3)) == null) {
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            for (int i9 = i; i9 < this.sampleSize + i; i9++) {
                byte[] bArr = this.mainPixels;
                if (i9 >= bArr.length || i9 >= i2) {
                    break;
                }
                int i10 = this.act[bArr[i9] & 255];
                if (i10 != 0) {
                    i4 += (i10 >> 24) & 255;
                    i5 += (i10 >> 16) & 255;
                    i6 += (i10 >> 8) & 255;
                    i7 += i10 & 255;
                    i8++;
                }
            }
            int i11 = i + i3;
            for (int i12 = i11; i12 < this.sampleSize + i11; i12++) {
                byte[] bArr2 = this.mainPixels;
                if (i12 >= bArr2.length || i12 >= i2) {
                    break;
                }
                int i13 = this.act[bArr2[i12] & 255];
                if (i13 != 0) {
                    i4 += (i13 >> 24) & 255;
                    i5 += (i13 >> 16) & 255;
                    i6 += (i13 >> 8) & 255;
                    i7 += i13 & 255;
                    i8++;
                }
            }
            if (i8 == 0) {
                return 0;
            }
            return ((i4 / i8) << 24) | ((i5 / i8) << 16) | ((i6 / i8) << 8) | (i7 / i8);
        }
        return invokeIII.intValue;
    }

    private void copyCopyIntoScratchRobust(GifFrame gifFrame) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, gifFrame) == null) {
            int[] iArr = this.mainScratch;
            int i6 = gifFrame.ih;
            int i7 = this.sampleSize;
            int i8 = i6 / i7;
            int i9 = gifFrame.iy / i7;
            int i10 = gifFrame.iw / i7;
            int i11 = gifFrame.ix / i7;
            boolean z = this.framePointer == 0;
            int i12 = this.sampleSize;
            int i13 = this.downsampledWidth;
            int i14 = this.downsampledHeight;
            byte[] bArr = this.mainPixels;
            int[] iArr2 = this.act;
            Boolean bool = this.isFirstFrameTransparent;
            int i15 = 8;
            int i16 = 0;
            int i17 = 0;
            int i18 = 1;
            while (i16 < i8) {
                Boolean bool2 = bool;
                if (gifFrame.interlace) {
                    if (i17 >= i8) {
                        i = i8;
                        int i19 = i18 + 1;
                        if (i19 == 2) {
                            i18 = i19;
                            i17 = 4;
                        } else if (i19 == 3) {
                            i18 = i19;
                            i17 = 2;
                            i15 = 4;
                        } else if (i19 != 4) {
                            i18 = i19;
                        } else {
                            i18 = i19;
                            i17 = 1;
                            i15 = 2;
                        }
                    } else {
                        i = i8;
                    }
                    i2 = i17 + i15;
                } else {
                    i = i8;
                    i2 = i17;
                    i17 = i16;
                }
                int i20 = i17 + i9;
                boolean z2 = i12 == 1;
                if (i20 < i14) {
                    int i21 = i20 * i13;
                    int i22 = i21 + i11;
                    int i23 = i22 + i10;
                    int i24 = i21 + i13;
                    if (i24 < i23) {
                        i23 = i24;
                    }
                    i3 = i2;
                    int i25 = i16 * i12 * gifFrame.iw;
                    if (z2) {
                        int i26 = i22;
                        while (i26 < i23) {
                            int i27 = i9;
                            int i28 = iArr2[bArr[i25] & 255];
                            if (i28 != 0) {
                                iArr[i26] = i28;
                            } else if (z && bool2 == null) {
                                bool2 = Boolean.TRUE;
                            }
                            i25 += i12;
                            i26++;
                            i9 = i27;
                        }
                    } else {
                        i5 = i9;
                        int i29 = ((i23 - i22) * i12) + i25;
                        int i30 = i22;
                        while (true) {
                            i4 = i10;
                            if (i30 < i23) {
                                int averageColorsNear = averageColorsNear(i25, i29, gifFrame.iw);
                                if (averageColorsNear != 0) {
                                    iArr[i30] = averageColorsNear;
                                } else if (z && bool2 == null) {
                                    bool2 = Boolean.TRUE;
                                }
                                i25 += i12;
                                i30++;
                                i10 = i4;
                            }
                        }
                        bool = bool2;
                        i16++;
                        i9 = i5;
                        i10 = i4;
                        i8 = i;
                        i17 = i3;
                    }
                } else {
                    i3 = i2;
                }
                i5 = i9;
                i4 = i10;
                bool = bool2;
                i16++;
                i9 = i5;
                i10 = i4;
                i8 = i;
                i17 = i3;
            }
            Boolean bool3 = bool;
            if (this.isFirstFrameTransparent == null) {
                this.isFirstFrameTransparent = Boolean.valueOf(bool3 == null ? false : bool3.booleanValue());
            }
        }
    }

    private void copyIntoScratchFast(GifFrame gifFrame) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, gifFrame) == null) {
            GifFrame gifFrame2 = gifFrame;
            int[] iArr = this.mainScratch;
            int i = gifFrame2.ih;
            int i2 = gifFrame2.iy;
            int i3 = gifFrame2.iw;
            int i4 = gifFrame2.ix;
            boolean z = this.framePointer == 0;
            int i5 = this.downsampledWidth;
            byte[] bArr = this.mainPixels;
            int[] iArr2 = this.act;
            int i6 = 0;
            byte b = -1;
            while (i6 < i) {
                int i7 = (i6 + i2) * i5;
                int i8 = i7 + i4;
                int i9 = i8 + i3;
                int i10 = i7 + i5;
                if (i10 < i9) {
                    i9 = i10;
                }
                int i11 = gifFrame2.iw * i6;
                int i12 = i8;
                while (i12 < i9) {
                    byte b2 = bArr[i11];
                    int i13 = i;
                    int i14 = b2 & 255;
                    if (i14 != b) {
                        int i15 = iArr2[i14];
                        if (i15 != 0) {
                            iArr[i12] = i15;
                        } else {
                            b = b2;
                        }
                    }
                    i11++;
                    i12++;
                    i = i13;
                }
                i6++;
                gifFrame2 = gifFrame;
            }
            this.isFirstFrameTransparent = Boolean.valueOf(this.isFirstFrameTransparent == null && z && b != -1);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:83:0x00fb */
    /* JADX DEBUG: Multi-variable search result rejected for r7v15, resolved type: short */
    /* JADX WARN: Multi-variable type inference failed */
    private void decodeBitmapData(GifFrame gifFrame) {
        int i;
        int i2;
        short s;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, gifFrame) == null) {
            StandardGifDecoder standardGifDecoder = this;
            if (gifFrame != null) {
                standardGifDecoder.rawData.position(gifFrame.bufferFrameStart);
            }
            if (gifFrame == null) {
                GifHeader gifHeader = standardGifDecoder.header;
                i = gifHeader.width;
                i2 = gifHeader.height;
            } else {
                i = gifFrame.iw;
                i2 = gifFrame.ih;
            }
            int i3 = i * i2;
            byte[] bArr = standardGifDecoder.mainPixels;
            if (bArr == null || bArr.length < i3) {
                standardGifDecoder.mainPixels = standardGifDecoder.bitmapProvider.obtainByteArray(i3);
            }
            byte[] bArr2 = standardGifDecoder.mainPixels;
            if (standardGifDecoder.prefix == null) {
                standardGifDecoder.prefix = new short[4096];
            }
            short[] sArr = standardGifDecoder.prefix;
            if (standardGifDecoder.suffix == null) {
                standardGifDecoder.suffix = new byte[4096];
            }
            byte[] bArr3 = standardGifDecoder.suffix;
            if (standardGifDecoder.pixelStack == null) {
                standardGifDecoder.pixelStack = new byte[4097];
            }
            byte[] bArr4 = standardGifDecoder.pixelStack;
            int readByte = readByte();
            int i4 = 1 << readByte;
            int i5 = i4 + 1;
            int i6 = i4 + 2;
            int i7 = readByte + 1;
            int i8 = (1 << i7) - 1;
            int i9 = 0;
            for (int i10 = 0; i10 < i4; i10++) {
                sArr[i10] = 0;
                bArr3[i10] = (byte) i10;
            }
            byte[] bArr5 = standardGifDecoder.block;
            int i11 = i7;
            int i12 = i6;
            int i13 = i8;
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = -1;
            int i20 = 0;
            int i21 = 0;
            while (true) {
                if (i9 >= i3) {
                    break;
                }
                if (i14 == 0) {
                    i14 = readBlock();
                    if (i14 <= 0) {
                        standardGifDecoder.status = 3;
                        break;
                    }
                    i15 = 0;
                }
                i17 += (bArr5[i15] & 255) << i16;
                i15++;
                i14--;
                int i22 = i16 + 8;
                int i23 = i12;
                int i24 = i11;
                int i25 = i19;
                int i26 = i7;
                int i27 = i20;
                while (true) {
                    if (i22 < i24) {
                        i19 = i25;
                        i12 = i23;
                        i16 = i22;
                        standardGifDecoder = this;
                        i20 = i27;
                        i7 = i26;
                        i11 = i24;
                        break;
                    }
                    int i28 = i6;
                    int i29 = i17 & i13;
                    i17 >>= i24;
                    i22 -= i24;
                    if (i29 == i4) {
                        i13 = i8;
                        i24 = i26;
                        i23 = i28;
                        i6 = i23;
                        i25 = -1;
                    } else if (i29 == i5) {
                        i16 = i22;
                        i20 = i27;
                        i12 = i23;
                        i7 = i26;
                        i6 = i28;
                        i19 = i25;
                        i11 = i24;
                        standardGifDecoder = this;
                        break;
                    } else if (i25 == -1) {
                        bArr2[i18] = bArr3[i29];
                        i18++;
                        i9++;
                        i25 = i29;
                        i27 = i25;
                        i6 = i28;
                        i22 = i22;
                    } else {
                        if (i29 >= i23) {
                            bArr4[i21] = (byte) i27;
                            i21++;
                            s = i25;
                        } else {
                            s = i29;
                        }
                        while (s >= i4) {
                            bArr4[i21] = bArr3[s];
                            i21++;
                            s = sArr[s];
                        }
                        i27 = bArr3[s] & 255;
                        byte b = (byte) i27;
                        bArr2[i18] = b;
                        while (true) {
                            i18++;
                            i9++;
                            if (i21 <= 0) {
                                break;
                            }
                            i21--;
                            bArr2[i18] = bArr4[i21];
                        }
                        byte[] bArr6 = bArr4;
                        if (i23 < 4096) {
                            sArr[i23] = (short) i25;
                            bArr3[i23] = b;
                            i23++;
                            if ((i23 & i13) == 0 && i23 < 4096) {
                                i24++;
                                i13 += i23;
                            }
                        }
                        i25 = i29;
                        i6 = i28;
                        i22 = i22;
                        bArr4 = bArr6;
                    }
                }
            }
            Arrays.fill(bArr2, i18, i3, (byte) 0);
        }
    }

    @NonNull
    private GifHeaderParser getHeaderParser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            if (this.parser == null) {
                this.parser = new GifHeaderParser();
            }
            return this.parser;
        }
        return (GifHeaderParser) invokeV.objValue;
    }

    private Bitmap getNextBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            Boolean bool = this.isFirstFrameTransparent;
            Bitmap obtain = this.bitmapProvider.obtain(this.downsampledWidth, this.downsampledHeight, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.bitmapConfig);
            obtain.setHasAlpha(true);
            return obtain;
        }
        return (Bitmap) invokeV.objValue;
    }

    private int readBlock() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            int readByte = readByte();
            if (readByte <= 0) {
                return readByte;
            }
            ByteBuffer byteBuffer = this.rawData;
            byteBuffer.get(this.block, 0, Math.min(readByte, byteBuffer.remaining()));
            return readByte;
        }
        return invokeV.intValue;
    }

    private int readByte() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) ? this.rawData.get() & 255 : invokeV.intValue;
    }

    private Bitmap setPixels(GifFrame gifFrame, GifFrame gifFrame2) {
        InterceptResult invokeLL;
        int i;
        int i2;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, this, gifFrame, gifFrame2)) == null) {
            int[] iArr = this.mainScratch;
            int i3 = 0;
            if (gifFrame2 == null) {
                Bitmap bitmap2 = this.previousImage;
                if (bitmap2 != null) {
                    this.bitmapProvider.release(bitmap2);
                }
                this.previousImage = null;
                Arrays.fill(iArr, 0);
            }
            if (gifFrame2 != null && gifFrame2.dispose == 3 && this.previousImage == null) {
                Arrays.fill(iArr, 0);
            }
            if (gifFrame2 != null && (i2 = gifFrame2.dispose) > 0) {
                if (i2 == 2) {
                    if (!gifFrame.transparency) {
                        GifHeader gifHeader = this.header;
                        int i4 = gifHeader.bgColor;
                        if (gifFrame.lct == null || gifHeader.bgIndex != gifFrame.transIndex) {
                            i3 = i4;
                        }
                    } else if (this.framePointer == 0) {
                        this.isFirstFrameTransparent = Boolean.TRUE;
                    }
                    int i5 = gifFrame2.ih;
                    int i6 = this.sampleSize;
                    int i7 = i5 / i6;
                    int i8 = gifFrame2.iy / i6;
                    int i9 = gifFrame2.iw / i6;
                    int i10 = gifFrame2.ix / i6;
                    int i11 = this.downsampledWidth;
                    int i12 = (i8 * i11) + i10;
                    int i13 = (i7 * i11) + i12;
                    while (i12 < i13) {
                        int i14 = i12 + i9;
                        for (int i15 = i12; i15 < i14; i15++) {
                            iArr[i15] = i3;
                        }
                        i12 += this.downsampledWidth;
                    }
                } else if (i2 == 3 && (bitmap = this.previousImage) != null) {
                    int i16 = this.downsampledWidth;
                    bitmap.getPixels(iArr, 0, i16, 0, 0, i16, this.downsampledHeight);
                }
            }
            decodeBitmapData(gifFrame);
            if (!gifFrame.interlace && this.sampleSize == 1) {
                copyIntoScratchFast(gifFrame);
            } else {
                copyCopyIntoScratchRobust(gifFrame);
            }
            if (this.savePrevious && ((i = gifFrame.dispose) == 0 || i == 1)) {
                if (this.previousImage == null) {
                    this.previousImage = getNextBitmap();
                }
                Bitmap bitmap3 = this.previousImage;
                int i17 = this.downsampledWidth;
                bitmap3.setPixels(iArr, 0, i17, 0, 0, i17, this.downsampledHeight);
            }
            Bitmap nextBitmap = getNextBitmap();
            int i18 = this.downsampledWidth;
            nextBitmap.setPixels(iArr, 0, i18, 0, 0, i18, this.downsampledHeight);
            return nextBitmap;
        }
        return (Bitmap) invokeLL.objValue;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void advance() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.framePointer = (this.framePointer + 1) % this.header.frameCount;
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.header = null;
            byte[] bArr = this.mainPixels;
            if (bArr != null) {
                this.bitmapProvider.release(bArr);
            }
            int[] iArr = this.mainScratch;
            if (iArr != null) {
                this.bitmapProvider.release(iArr);
            }
            Bitmap bitmap = this.previousImage;
            if (bitmap != null) {
                this.bitmapProvider.release(bitmap);
            }
            this.previousImage = null;
            this.rawData = null;
            this.isFirstFrameTransparent = null;
            byte[] bArr2 = this.block;
            if (bArr2 != null) {
                this.bitmapProvider.release(bArr2);
            }
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getByteSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.rawData.limit() + this.mainPixels.length + (this.mainScratch.length * 4) : invokeV.intValue;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getCurrentFrameIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.framePointer : invokeV.intValue;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @NonNull
    public ByteBuffer getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.rawData : (ByteBuffer) invokeV.objValue;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getDelay(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (i >= 0) {
                GifHeader gifHeader = this.header;
                if (i < gifHeader.frameCount) {
                    return gifHeader.frames.get(i).delay;
                }
            }
            return -1;
        }
        return invokeI.intValue;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getFrameCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.header.frameCount : invokeV.intValue;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.header.height : invokeV.intValue;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @Deprecated
    public int getLoopCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int i = this.header.loopCount;
            if (i == -1) {
                return 1;
            }
            return i;
        }
        return invokeV.intValue;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getNetscapeLoopCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.header.loopCount : invokeV.intValue;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getNextDelay() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.header.frameCount <= 0 || (i = this.framePointer) < 0) {
                return 0;
            }
            return getDelay(i);
        }
        return invokeV.intValue;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @Nullable
    public synchronized Bitmap getNextFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            synchronized (this) {
                if (this.header.frameCount <= 0 || this.framePointer < 0) {
                    if (Log.isLoggable(TAG, 3)) {
                        String str = TAG;
                        Log.d(str, "Unable to decode frame, frameCount=" + this.header.frameCount + ", framePointer=" + this.framePointer);
                    }
                    this.status = 1;
                }
                if (this.status != 1 && this.status != 2) {
                    this.status = 0;
                    if (this.block == null) {
                        this.block = this.bitmapProvider.obtainByteArray(255);
                    }
                    GifFrame gifFrame = this.header.frames.get(this.framePointer);
                    int i = this.framePointer - 1;
                    GifFrame gifFrame2 = i >= 0 ? this.header.frames.get(i) : null;
                    int[] iArr = gifFrame.lct != null ? gifFrame.lct : this.header.gct;
                    this.act = iArr;
                    if (iArr == null) {
                        if (Log.isLoggable(TAG, 3)) {
                            String str2 = TAG;
                            Log.d(str2, "No valid color table found for frame #" + this.framePointer);
                        }
                        this.status = 1;
                        return null;
                    }
                    if (gifFrame.transparency) {
                        System.arraycopy(iArr, 0, this.pct, 0, iArr.length);
                        int[] iArr2 = this.pct;
                        this.act = iArr2;
                        iArr2[gifFrame.transIndex] = 0;
                    }
                    return setPixels(gifFrame, gifFrame2);
                }
                if (Log.isLoggable(TAG, 3)) {
                    String str3 = TAG;
                    Log.d(str3, "Unable to decode frame, status=" + this.status);
                }
                return null;
            }
        }
        return (Bitmap) invokeV.objValue;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.status : invokeV.intValue;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getTotalIterationCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            int i = this.header.loopCount;
            if (i == -1) {
                return 1;
            }
            if (i == 0) {
                return 0;
            }
            return i + 1;
        }
        return invokeV.intValue;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.header.width : invokeV.intValue;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int read(@Nullable InputStream inputStream, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, inputStream, i)) == null) {
            if (inputStream != null) {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i > 0 ? i + 4096 : 16384);
                    byte[] bArr = new byte[16384];
                    while (true) {
                        int read = inputStream.read(bArr, 0, 16384);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    byteArrayOutputStream.flush();
                    read(byteArrayOutputStream.toByteArray());
                } catch (IOException e) {
                    Log.w(TAG, "Error reading data from stream", e);
                }
            } else {
                this.status = 2;
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    Log.w(TAG, "Error closing stream", e2);
                }
            }
            return this.status;
        }
        return invokeLI.intValue;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void resetFrameIndex() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.framePointer = -1;
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, gifHeader, bArr) == null) {
            synchronized (this) {
                setData(gifHeader, ByteBuffer.wrap(bArr));
            }
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void setDefaultBitmapConfig(@NonNull Bitmap.Config config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, config) == null) {
            if (config != Bitmap.Config.ARGB_8888 && config != Bitmap.Config.RGB_565) {
                throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
            }
            this.bitmapConfig = config;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int i) {
        this(bitmapProvider);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmapProvider, gifHeader, byteBuffer, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((GifDecoder.BitmapProvider) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        setData(gifHeader, byteBuffer, i);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, gifHeader, byteBuffer) == null) {
            synchronized (this) {
                setData(gifHeader, byteBuffer, 1);
            }
        }
    }

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmapProvider};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.pct = new int[256];
        this.bitmapConfig = Bitmap.Config.ARGB_8888;
        this.bitmapProvider = bitmapProvider;
        this.header = new GifHeader();
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048595, this, gifHeader, byteBuffer, i) == null) {
            synchronized (this) {
                if (i > 0) {
                    int highestOneBit = Integer.highestOneBit(i);
                    this.status = 0;
                    this.header = gifHeader;
                    this.framePointer = -1;
                    ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                    this.rawData = asReadOnlyBuffer;
                    asReadOnlyBuffer.position(0);
                    this.rawData.order(ByteOrder.LITTLE_ENDIAN);
                    this.savePrevious = false;
                    Iterator<GifFrame> it = gifHeader.frames.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (it.next().dispose == 3) {
                            this.savePrevious = true;
                            break;
                        }
                    }
                    this.sampleSize = highestOneBit;
                    this.downsampledWidth = gifHeader.width / highestOneBit;
                    this.downsampledHeight = gifHeader.height / highestOneBit;
                    this.mainPixels = this.bitmapProvider.obtainByteArray(gifHeader.width * gifHeader.height);
                    this.mainScratch = this.bitmapProvider.obtainIntArray(this.downsampledWidth * this.downsampledHeight);
                } else {
                    throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
                }
            }
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized int read(@Nullable byte[] bArr) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, bArr)) == null) {
            synchronized (this) {
                GifHeader parseHeader = getHeaderParser().setData(bArr).parseHeader();
                this.header = parseHeader;
                if (bArr != null) {
                    setData(parseHeader, bArr);
                }
                i = this.status;
            }
            return i;
        }
        return invokeL.intValue;
    }
}
