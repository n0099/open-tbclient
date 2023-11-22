package com.baidu.tieba;

import android.media.AudioRecord;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.record.RecordConstants;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class krb {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] b;
    public static int c;
    public static int d;
    public static int e;
    public static krb f;
    public static byte[] g;
    public transient /* synthetic */ FieldHolder $fh;
    public AudioRecord a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947924110, "Lcom/baidu/tieba/krb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947924110, "Lcom/baidu/tieba/krb;");
                return;
            }
        }
        b = new int[]{1, 0, 5, 7, 6};
        c = RecordConstants.MOVIE_ENCODE_SAMPLE_RATE;
        d = 2048;
        e = 24;
        g = new byte[0];
    }

    public krb(int i) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        int minBufferSize = AudioRecord.getMinBufferSize(c, 16, 2);
        int i4 = d;
        int i5 = e * i4;
        i5 = i5 < minBufferSize ? ((minBufferSize / i4) + 1) * i4 * 2 : i5;
        if (i != -100) {
            try {
                AudioRecord audioRecord = new AudioRecord(i, c, 16, 2, i5);
                this.a = audioRecord;
                if (audioRecord.getState() != 1) {
                    this.a = null;
                }
            } catch (Exception unused) {
                this.a = null;
            }
            if (this.a != null) {
                xrb.d("audio_source:(if) ---> " + i);
            }
        }
        if (this.a == null) {
            for (int i6 : b) {
                try {
                    AudioRecord audioRecord2 = new AudioRecord(i6, c, 16, 2, i5);
                    this.a = audioRecord2;
                    if (audioRecord2.getState() != 1) {
                        this.a = null;
                    }
                } catch (Exception unused2) {
                    this.a = null;
                }
                if (this.a != null) {
                    xrb.d("audio_source:(for) ---> " + i6);
                    return;
                }
            }
        }
    }

    public int a(@NonNull ByteBuffer byteBuffer, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, byteBuffer, i)) == null) {
            AudioRecord audioRecord = this.a;
            if (audioRecord == null) {
                return 0;
            }
            return audioRecord.read(byteBuffer, i);
        }
        return invokeLI.intValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a == null) {
            return;
        }
        synchronized (g) {
            g();
            if (f == this) {
                f = null;
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (g) {
                if (f == this) {
                    return;
                }
                if (f != null) {
                    f.g();
                    f = null;
                }
                f();
                f = this;
            }
        }
    }

    public AudioRecord d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (AudioRecord) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            AudioRecord audioRecord = this.a;
            if (audioRecord != null) {
                return audioRecord.getRecordingState();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void f() {
        AudioRecord audioRecord;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (audioRecord = this.a) == null) {
            return;
        }
        audioRecord.startRecording();
    }

    public final void g() {
        AudioRecord audioRecord;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (audioRecord = this.a) == null) {
            return;
        }
        this.a = null;
        audioRecord.stop();
        audioRecord.release();
    }
}
