package com.baidu.tieba.video.meida;

import com.baidu.adp.lib.util.BdLog;
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
/* loaded from: classes6.dex */
public abstract class MultiAudioMixer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b extends MultiAudioMixer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        @Override // com.baidu.tieba.video.meida.MultiAudioMixer
        public byte[] c(byte[][] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
                if (bArr == null || bArr.length == 0) {
                    return null;
                }
                byte[] bArr2 = bArr[0];
                if (bArr.length == 1) {
                    return bArr2;
                }
                for (int i = 0; i < bArr.length; i++) {
                    if (bArr[i].length != bArr2.length) {
                        BdLog.e("column of the road of audio + " + i + " is diffrent.");
                        return null;
                    }
                }
                int length = bArr.length;
                int length2 = bArr2.length / 2;
                short[][] sArr = (short[][]) Array.newInstance(short.class, length, length2);
                for (int i2 = 0; i2 < length; i2++) {
                    for (int i3 = 0; i3 < length2; i3++) {
                        int i4 = i3 * 2;
                        sArr[i2][i3] = (short) ((bArr[i2][i4] & 255) | ((bArr[i2][i4 + 1] & 255) << 8));
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
            return (byte[]) invokeL.objValue;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
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

    public static MultiAudioMixer a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new b(null) : (MultiAudioMixer) invokeV.objValue;
    }

    public void b(File[] fileArr) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fileArr) == null) {
            int length = fileArr.length;
            FileInputStream[] fileInputStreamArr = new FileInputStream[length];
            byte[][] bArr = new byte[length];
            boolean[] zArr = new boolean[length];
            byte[] bArr2 = new byte[512];
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
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        if (this.a != null) {
                            this.a.onMixError(1);
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
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
            }
            do {
                for (int i3 = 0; i3 < length; i3++) {
                    FileInputStream fileInputStream3 = fileInputStreamArr[i3];
                    if (!zArr[i3] && fileInputStream3.read(bArr2) != -1) {
                        bArr[i3] = Arrays.copyOf(bArr2, 512);
                    } else {
                        zArr[i3] = true;
                        bArr[i3] = new byte[512];
                    }
                }
                byte[] c2 = c(bArr);
                if (c2 != null && this.a != null) {
                    this.a.onMixing(c2);
                }
                z = true;
                for (int i4 = 0; i4 < length; i4++) {
                    if (!zArr[i4]) {
                        z = false;
                    }
                }
            } while (!z);
            if (this.a != null) {
                this.a.onMixComplete();
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

    public abstract byte[] c(byte[][] bArr);

    public void d(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.a = cVar;
        }
    }
}
