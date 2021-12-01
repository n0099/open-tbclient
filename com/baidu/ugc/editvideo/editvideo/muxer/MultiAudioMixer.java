package com.baidu.ugc.editvideo.editvideo.muxer;

import c.a.x0.t.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
/* loaded from: classes11.dex */
public abstract class MultiAudioMixer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public OnAudioMixListener mOnAudioMixListener;

    /* renamed from: com.baidu.ugc.editvideo.editvideo.muxer.MultiAudioMixer$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes11.dex */
    public static class AudioMixException extends IOException {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -1344782236320621800L;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AudioMixException(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class AverageAudioMixer extends MultiAudioMixer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public AverageAudioMixer() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.ugc.editvideo.editvideo.muxer.MultiAudioMixer
        public byte[] mixRawAudioBytes(byte[][] bArr, float[] fArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bArr, fArr)) == null) {
                if (bArr == null || bArr.length == 0) {
                    return null;
                }
                byte[] bArr2 = bArr[0];
                if (bArr.length == 1) {
                    return bArr2;
                }
                for (int i2 = 0; i2 < bArr.length; i2++) {
                    if (bArr[i2].length != bArr2.length) {
                        c.d("column of the road of audio + " + i2 + " is diffrent.");
                        return null;
                    }
                }
                int length = bArr.length;
                int length2 = bArr2.length / 2;
                short[][] sArr = (short[][]) Array.newInstance(short.class, length, length2);
                for (int i3 = 0; i3 < length; i3++) {
                    for (int i4 = 0; i4 < length2; i4++) {
                        int i5 = i4 * 2;
                        short s = (short) ((bArr[i3][i5] & 255) | ((bArr[i3][i5 + 1] & 255) << 8));
                        if (fArr.length == length) {
                            s = (short) (s * fArr[i3]);
                        }
                        sArr[i3][i4] = s;
                    }
                }
                short[] sArr2 = new short[length2];
                for (int i6 = 0; i6 < length2; i6++) {
                    int i7 = 0;
                    for (int i8 = 0; i8 < length; i8++) {
                        i7 += sArr[i8][i6];
                    }
                    sArr2[i6] = (short) (i7 / length);
                }
                for (int i9 = 0; i9 < length2; i9++) {
                    int i10 = i9 * 2;
                    bArr2[i10] = (byte) (sArr2[i9] & 255);
                    bArr2[i10 + 1] = (byte) ((sArr2[i9] & 65280) >> 8);
                }
                return bArr2;
            }
            return (byte[]) invokeLL.objValue;
        }

        public /* synthetic */ AverageAudioMixer(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* loaded from: classes11.dex */
    public interface OnAudioMixListener {
        void onMixComplete();

        void onMixError(int i2);

        void onMixing(byte[] bArr) throws IOException;
    }

    public MultiAudioMixer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static MultiAudioMixer createAudioMixer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new AverageAudioMixer(null) : (MultiAudioMixer) invokeV.objValue;
    }

    public void mixAudios(File[] fileArr, float[] fArr) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, fileArr, fArr) == null) {
            int length = fileArr.length;
            FileInputStream[] fileInputStreamArr = new FileInputStream[length];
            byte[][] bArr = new byte[length];
            boolean[] zArr = new boolean[length];
            byte[] bArr2 = new byte[4096];
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                try {
                    try {
                        try {
                            fileInputStreamArr[i3] = new FileInputStream(fileArr[i3]);
                        } catch (Throwable th) {
                            while (i2 < length) {
                                try {
                                    FileInputStream fileInputStream = fileInputStreamArr[i2];
                                    if (fileInputStream != null) {
                                        fileInputStream.close();
                                    }
                                    i2++;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        if (this.mOnAudioMixListener != null) {
                            this.mOnAudioMixListener.onMixError(1);
                        }
                        while (i2 < length) {
                            FileInputStream fileInputStream2 = fileInputStreamArr[i2];
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                            i2++;
                        }
                        return;
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
            }
            do {
                for (int i4 = 0; i4 < length; i4++) {
                    FileInputStream fileInputStream3 = fileInputStreamArr[i4];
                    if (!zArr[i4] && fileInputStream3.read(bArr2) != -1) {
                        bArr[i4] = Arrays.copyOf(bArr2, 4096);
                    } else {
                        zArr[i4] = true;
                        bArr[i4] = new byte[4096];
                    }
                }
                byte[] mixRawAudioBytes = mixRawAudioBytes(bArr, fArr);
                if (mixRawAudioBytes != null && this.mOnAudioMixListener != null) {
                    this.mOnAudioMixListener.onMixing(mixRawAudioBytes);
                }
                z = true;
                for (int i5 = 0; i5 < length; i5++) {
                    if (!zArr[i5]) {
                        z = false;
                    }
                }
            } while (!z);
            if (this.mOnAudioMixListener != null) {
                this.mOnAudioMixListener.onMixComplete();
            }
            while (i2 < length) {
                FileInputStream fileInputStream4 = fileInputStreamArr[i2];
                if (fileInputStream4 != null) {
                    fileInputStream4.close();
                }
                i2++;
            }
        }
    }

    public abstract byte[] mixRawAudioBytes(byte[][] bArr, float[] fArr);

    public void setOnAudioMixListener(OnAudioMixListener onAudioMixListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onAudioMixListener) == null) {
            this.mOnAudioMixListener = onAudioMixListener;
        }
    }
}
