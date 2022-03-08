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
/* loaded from: classes7.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((GifDecoder.BitmapProvider) objArr2[0], (GifHeader) objArr2[1], (ByteBuffer) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    @ColorInt
    private int averageColorsNear(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(InputDeviceCompat.SOURCE_TRACKBALL, this, i2, i3, i4)) == null) {
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            for (int i10 = i2; i10 < this.sampleSize + i2; i10++) {
                byte[] bArr = this.mainPixels;
                if (i10 >= bArr.length || i10 >= i3) {
                    break;
                }
                int i11 = this.act[bArr[i10] & 255];
                if (i11 != 0) {
                    i5 += (i11 >> 24) & 255;
                    i6 += (i11 >> 16) & 255;
                    i7 += (i11 >> 8) & 255;
                    i8 += i11 & 255;
                    i9++;
                }
            }
            int i12 = i2 + i4;
            for (int i13 = i12; i13 < this.sampleSize + i12; i13++) {
                byte[] bArr2 = this.mainPixels;
                if (i13 >= bArr2.length || i13 >= i3) {
                    break;
                }
                int i14 = this.act[bArr2[i13] & 255];
                if (i14 != 0) {
                    i5 += (i14 >> 24) & 255;
                    i6 += (i14 >> 16) & 255;
                    i7 += (i14 >> 8) & 255;
                    i8 += i14 & 255;
                    i9++;
                }
            }
            if (i9 == 0) {
                return 0;
            }
            return ((i5 / i9) << 24) | ((i6 / i9) << 16) | ((i7 / i9) << 8) | (i8 / i9);
        }
        return invokeIII.intValue;
    }

    private void copyCopyIntoScratchRobust(GifFrame gifFrame) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, gifFrame) == null) {
            int[] iArr = this.mainScratch;
            int i7 = gifFrame.ih;
            int i8 = this.sampleSize;
            int i9 = i7 / i8;
            int i10 = gifFrame.iy / i8;
            int i11 = gifFrame.iw / i8;
            int i12 = gifFrame.ix / i8;
            boolean z = this.framePointer == 0;
            int i13 = this.sampleSize;
            int i14 = this.downsampledWidth;
            int i15 = this.downsampledHeight;
            byte[] bArr = this.mainPixels;
            int[] iArr2 = this.act;
            Boolean bool = this.isFirstFrameTransparent;
            int i16 = 8;
            int i17 = 0;
            int i18 = 0;
            int i19 = 1;
            while (i17 < i9) {
                Boolean bool2 = bool;
                if (gifFrame.interlace) {
                    if (i18 >= i9) {
                        i2 = i9;
                        int i20 = i19 + 1;
                        if (i20 == 2) {
                            i19 = i20;
                            i18 = 4;
                        } else if (i20 == 3) {
                            i19 = i20;
                            i18 = 2;
                            i16 = 4;
                        } else if (i20 != 4) {
                            i19 = i20;
                        } else {
                            i19 = i20;
                            i18 = 1;
                            i16 = 2;
                        }
                    } else {
                        i2 = i9;
                    }
                    i3 = i18 + i16;
                } else {
                    i2 = i9;
                    i3 = i18;
                    i18 = i17;
                }
                int i21 = i18 + i10;
                boolean z2 = i13 == 1;
                if (i21 < i15) {
                    int i22 = i21 * i14;
                    int i23 = i22 + i12;
                    int i24 = i23 + i11;
                    int i25 = i22 + i14;
                    if (i25 < i24) {
                        i24 = i25;
                    }
                    i4 = i3;
                    int i26 = i17 * i13 * gifFrame.iw;
                    if (z2) {
                        int i27 = i23;
                        while (i27 < i24) {
                            int i28 = i10;
                            int i29 = iArr2[bArr[i26] & 255];
                            if (i29 != 0) {
                                iArr[i27] = i29;
                            } else if (z && bool2 == null) {
                                bool2 = Boolean.TRUE;
                            }
                            i26 += i13;
                            i27++;
                            i10 = i28;
                        }
                    } else {
                        i6 = i10;
                        int i30 = ((i24 - i23) * i13) + i26;
                        int i31 = i23;
                        while (true) {
                            i5 = i11;
                            if (i31 < i24) {
                                int averageColorsNear = averageColorsNear(i26, i30, gifFrame.iw);
                                if (averageColorsNear != 0) {
                                    iArr[i31] = averageColorsNear;
                                } else if (z && bool2 == null) {
                                    bool2 = Boolean.TRUE;
                                }
                                i26 += i13;
                                i31++;
                                i11 = i5;
                            }
                        }
                        bool = bool2;
                        i17++;
                        i10 = i6;
                        i11 = i5;
                        i9 = i2;
                        i18 = i4;
                    }
                } else {
                    i4 = i3;
                }
                i6 = i10;
                i5 = i11;
                bool = bool2;
                i17++;
                i10 = i6;
                i11 = i5;
                i9 = i2;
                i18 = i4;
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
            int i2 = gifFrame2.ih;
            int i3 = gifFrame2.iy;
            int i4 = gifFrame2.iw;
            int i5 = gifFrame2.ix;
            boolean z = this.framePointer == 0;
            int i6 = this.downsampledWidth;
            byte[] bArr = this.mainPixels;
            int[] iArr2 = this.act;
            int i7 = 0;
            byte b2 = -1;
            while (i7 < i2) {
                int i8 = (i7 + i3) * i6;
                int i9 = i8 + i5;
                int i10 = i9 + i4;
                int i11 = i8 + i6;
                if (i11 < i10) {
                    i10 = i11;
                }
                int i12 = gifFrame2.iw * i7;
                int i13 = i9;
                while (i13 < i10) {
                    byte b3 = bArr[i12];
                    int i14 = i2;
                    int i15 = b3 & 255;
                    if (i15 != b2) {
                        int i16 = iArr2[i15];
                        if (i16 != 0) {
                            iArr[i13] = i16;
                        } else {
                            b2 = b3;
                        }
                    }
                    i12++;
                    i13++;
                    i2 = i14;
                }
                i7++;
                gifFrame2 = gifFrame;
            }
            this.isFirstFrameTransparent = Boolean.valueOf(this.isFirstFrameTransparent == null && z && b2 != -1);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:83:0x00fb */
    /* JADX DEBUG: Multi-variable search result rejected for r7v15, resolved type: short */
    /* JADX WARN: Multi-variable type inference failed */
    private void decodeBitmapData(GifFrame gifFrame) {
        int i2;
        int i3;
        short s;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, gifFrame) == null) {
            StandardGifDecoder standardGifDecoder = this;
            if (gifFrame != null) {
                standardGifDecoder.rawData.position(gifFrame.bufferFrameStart);
            }
            if (gifFrame == null) {
                GifHeader gifHeader = standardGifDecoder.header;
                i2 = gifHeader.width;
                i3 = gifHeader.height;
            } else {
                i2 = gifFrame.iw;
                i3 = gifFrame.ih;
            }
            int i4 = i2 * i3;
            byte[] bArr = standardGifDecoder.mainPixels;
            if (bArr == null || bArr.length < i4) {
                standardGifDecoder.mainPixels = standardGifDecoder.bitmapProvider.obtainByteArray(i4);
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
            int i5 = 1 << readByte;
            int i6 = i5 + 1;
            int i7 = i5 + 2;
            int i8 = readByte + 1;
            int i9 = (1 << i8) - 1;
            int i10 = 0;
            for (int i11 = 0; i11 < i5; i11++) {
                sArr[i11] = 0;
                bArr3[i11] = (byte) i11;
            }
            byte[] bArr5 = standardGifDecoder.block;
            int i12 = i8;
            int i13 = i7;
            int i14 = i9;
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = -1;
            int i21 = 0;
            int i22 = 0;
            while (true) {
                if (i10 >= i4) {
                    break;
                }
                if (i15 == 0) {
                    i15 = readBlock();
                    if (i15 <= 0) {
                        standardGifDecoder.status = 3;
                        break;
                    }
                    i16 = 0;
                }
                i18 += (bArr5[i16] & 255) << i17;
                i16++;
                i15--;
                int i23 = i17 + 8;
                int i24 = i13;
                int i25 = i12;
                int i26 = i20;
                int i27 = i8;
                int i28 = i21;
                while (true) {
                    if (i23 < i25) {
                        i20 = i26;
                        i13 = i24;
                        i17 = i23;
                        standardGifDecoder = this;
                        i21 = i28;
                        i8 = i27;
                        i12 = i25;
                        break;
                    }
                    int i29 = i7;
                    int i30 = i18 & i14;
                    i18 >>= i25;
                    i23 -= i25;
                    if (i30 == i5) {
                        i14 = i9;
                        i25 = i27;
                        i24 = i29;
                        i7 = i24;
                        i26 = -1;
                    } else if (i30 == i6) {
                        i17 = i23;
                        i21 = i28;
                        i13 = i24;
                        i8 = i27;
                        i7 = i29;
                        i20 = i26;
                        i12 = i25;
                        standardGifDecoder = this;
                        break;
                    } else if (i26 == -1) {
                        bArr2[i19] = bArr3[i30];
                        i19++;
                        i10++;
                        i26 = i30;
                        i28 = i26;
                        i7 = i29;
                        i23 = i23;
                    } else {
                        if (i30 >= i24) {
                            bArr4[i22] = (byte) i28;
                            i22++;
                            s = i26;
                        } else {
                            s = i30;
                        }
                        while (s >= i5) {
                            bArr4[i22] = bArr3[s];
                            i22++;
                            s = sArr[s];
                        }
                        i28 = bArr3[s] & 255;
                        byte b2 = (byte) i28;
                        bArr2[i19] = b2;
                        while (true) {
                            i19++;
                            i10++;
                            if (i22 <= 0) {
                                break;
                            }
                            i22--;
                            bArr2[i19] = bArr4[i22];
                        }
                        byte[] bArr6 = bArr4;
                        if (i24 < 4096) {
                            sArr[i24] = (short) i26;
                            bArr3[i24] = b2;
                            i24++;
                            if ((i24 & i14) == 0 && i24 < 4096) {
                                i25++;
                                i14 += i24;
                            }
                        }
                        i26 = i30;
                        i7 = i29;
                        i23 = i23;
                        bArr4 = bArr6;
                    }
                }
            }
            Arrays.fill(bArr2, i19, i4, (byte) 0);
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
        int i2;
        int i3;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, this, gifFrame, gifFrame2)) == null) {
            int[] iArr = this.mainScratch;
            int i4 = 0;
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
            if (gifFrame2 != null && (i3 = gifFrame2.dispose) > 0) {
                if (i3 == 2) {
                    if (!gifFrame.transparency) {
                        GifHeader gifHeader = this.header;
                        int i5 = gifHeader.bgColor;
                        if (gifFrame.lct == null || gifHeader.bgIndex != gifFrame.transIndex) {
                            i4 = i5;
                        }
                    } else if (this.framePointer == 0) {
                        this.isFirstFrameTransparent = Boolean.TRUE;
                    }
                    int i6 = gifFrame2.ih;
                    int i7 = this.sampleSize;
                    int i8 = i6 / i7;
                    int i9 = gifFrame2.iy / i7;
                    int i10 = gifFrame2.iw / i7;
                    int i11 = gifFrame2.ix / i7;
                    int i12 = this.downsampledWidth;
                    int i13 = (i9 * i12) + i11;
                    int i14 = (i8 * i12) + i13;
                    while (i13 < i14) {
                        int i15 = i13 + i10;
                        for (int i16 = i13; i16 < i15; i16++) {
                            iArr[i16] = i4;
                        }
                        i13 += this.downsampledWidth;
                    }
                } else if (i3 == 3 && (bitmap = this.previousImage) != null) {
                    int i17 = this.downsampledWidth;
                    bitmap.getPixels(iArr, 0, i17, 0, 0, i17, this.downsampledHeight);
                }
            }
            decodeBitmapData(gifFrame);
            if (!gifFrame.interlace && this.sampleSize == 1) {
                copyIntoScratchFast(gifFrame);
            } else {
                copyCopyIntoScratchRobust(gifFrame);
            }
            if (this.savePrevious && ((i2 = gifFrame.dispose) == 0 || i2 == 1)) {
                if (this.previousImage == null) {
                    this.previousImage = getNextBitmap();
                }
                Bitmap bitmap3 = this.previousImage;
                int i18 = this.downsampledWidth;
                bitmap3.setPixels(iArr, 0, i18, 0, 0, i18, this.downsampledHeight);
            }
            Bitmap nextBitmap = getNextBitmap();
            int i19 = this.downsampledWidth;
            nextBitmap.setPixels(iArr, 0, i19, 0, 0, i19, this.downsampledHeight);
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
    public int getDelay(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (i2 >= 0) {
                GifHeader gifHeader = this.header;
                if (i2 < gifHeader.frameCount) {
                    return gifHeader.frames.get(i2).delay;
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
            int i2 = this.header.loopCount;
            if (i2 == -1) {
                return 1;
            }
            return i2;
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
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.header.frameCount <= 0 || (i2 = this.framePointer) < 0) {
                return 0;
            }
            return getDelay(i2);
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
                        String str = "Unable to decode frame, frameCount=" + this.header.frameCount + ", framePointer=" + this.framePointer;
                    }
                    this.status = 1;
                }
                if (this.status != 1 && this.status != 2) {
                    this.status = 0;
                    if (this.block == null) {
                        this.block = this.bitmapProvider.obtainByteArray(255);
                    }
                    GifFrame gifFrame = this.header.frames.get(this.framePointer);
                    int i2 = this.framePointer - 1;
                    GifFrame gifFrame2 = i2 >= 0 ? this.header.frames.get(i2) : null;
                    int[] iArr = gifFrame.lct != null ? gifFrame.lct : this.header.gct;
                    this.act = iArr;
                    if (iArr == null) {
                        if (Log.isLoggable(TAG, 3)) {
                            String str2 = "No valid color table found for frame #" + this.framePointer;
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
                    String str3 = "Unable to decode frame, status=" + this.status;
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
            int i2 = this.header.loopCount;
            if (i2 == -1) {
                return 1;
            }
            if (i2 == 0) {
                return 0;
            }
            return i2 + 1;
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
    public int read(@Nullable InputStream inputStream, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, inputStream, i2)) == null) {
            if (inputStream != null) {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2 > 0 ? i2 + 4096 : 16384);
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
                } catch (IOException unused) {
                }
            } else {
                this.status = 2;
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
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
    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int i2) {
        this(bitmapProvider);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmapProvider, gifHeader, byteBuffer, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                this((GifDecoder.BitmapProvider) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        setData(gifHeader, byteBuffer, i2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048595, this, gifHeader, byteBuffer, i2) == null) {
            synchronized (this) {
                if (i2 > 0) {
                    int highestOneBit = Integer.highestOneBit(i2);
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
                    throw new IllegalArgumentException("Sample size must be >=0, not: " + i2);
                }
            }
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized int read(@Nullable byte[] bArr) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, bArr)) == null) {
            synchronized (this) {
                GifHeader parseHeader = getHeaderParser().setData(bArr).parseHeader();
                this.header = parseHeader;
                if (bArr != null) {
                    setData(parseHeader, bArr);
                }
                i2 = this.status;
            }
            return i2;
        }
        return invokeL.intValue;
    }
}
