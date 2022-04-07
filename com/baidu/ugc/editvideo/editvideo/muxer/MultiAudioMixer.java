package com.baidu.ugc.editvideo.editvideo.muxer;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.tb9;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
/* loaded from: classes4.dex */
public abstract class MultiAudioMixer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public OnAudioMixListener mOnAudioMixListener;

    /* renamed from: com.baidu.ugc.editvideo.editvideo.muxer.MultiAudioMixer$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public static class AverageAudioMixer extends MultiAudioMixer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public AverageAudioMixer() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                for (int i = 0; i < bArr.length; i++) {
                    if (bArr[i].length != bArr2.length) {
                        tb9.d("column of the road of audio + " + i + " is diffrent.");
                        return null;
                    }
                }
                int length = bArr.length;
                int length2 = bArr2.length / 2;
                short[][] sArr = (short[][]) Array.newInstance(short.class, length, length2);
                for (int i2 = 0; i2 < length; i2++) {
                    for (int i3 = 0; i3 < length2; i3++) {
                        int i4 = i3 * 2;
                        short s = (short) ((bArr[i2][i4] & 255) | ((bArr[i2][i4 + 1] & 255) << 8));
                        if (fArr.length == length) {
                            s = (short) (s * fArr[i2]);
                        }
                        sArr[i2][i3] = s;
                    }
                }
                short[] sArr2 = new short[length2];
                for (int i5 = 0; i5 < length2; i5++) {
                    int i6 = 0;
                    for (int i7 = 0; i7 < length; i7++) {
                        i6 += sArr[i7][i5];
                    }
                    sArr2[i5] = (short) (i6 / length);
                }
                for (int i8 = 0; i8 < length2; i8++) {
                    int i9 = i8 * 2;
                    bArr2[i9] = (byte) (sArr2[i8] & 255);
                    bArr2[i9 + 1] = (byte) ((sArr2[i8] & 65280) >> 8);
                }
                return bArr2;
            }
            return (byte[]) invokeLL.objValue;
        }

        public /* synthetic */ AverageAudioMixer(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public interface OnAudioMixListener {
        void onMixComplete();

        void onMixError(int i);

        void onMixing(byte[] bArr) throws IOException;
    }

    public MultiAudioMixer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    try {
                        try {
                            fileInputStreamArr[i2] = new FileInputStream(fileArr[i2]);
                        } catch (Throwable th) {
                            while (i < length) {
                                try {
                                    FileInputStream fileInputStream = fileInputStreamArr[i];
                                    if (fileInputStream != null) {
                                        fileInputStream.close();
                                    }
                                    i++;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        if (this.mOnAudioMixListener != null) {
                            this.mOnAudioMixListener.onMixError(1);
                        }
                        while (i < length) {
                            FileInputStream fileInputStream2 = fileInputStreamArr[i];
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                            i++;
                        }
                        return;
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            do {
                for (int i3 = 0; i3 < length; i3++) {
                    FileInputStream fileInputStream3 = fileInputStreamArr[i3];
                    if (!zArr[i3] && fileInputStream3.read(bArr2) != -1) {
                        bArr[i3] = Arrays.copyOf(bArr2, 4096);
                    } else {
                        zArr[i3] = true;
                        bArr[i3] = new byte[4096];
                    }
                }
                byte[] mixRawAudioBytes = mixRawAudioBytes(bArr, fArr);
                if (mixRawAudioBytes != null && this.mOnAudioMixListener != null) {
                    this.mOnAudioMixListener.onMixing(mixRawAudioBytes);
                }
                z = true;
                for (int i4 = 0; i4 < length; i4++) {
                    if (!zArr[i4]) {
                        z = false;
                    }
                }
            } while (!z);
            if (this.mOnAudioMixListener != null) {
                this.mOnAudioMixListener.onMixComplete();
            }
            while (i < length) {
                FileInputStream fileInputStream4 = fileInputStreamArr[i];
                if (fileInputStream4 != null) {
                    fileInputStream4.close();
                }
                i++;
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
