package com.baidu.tieba;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
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
import com.baidu.ugc.utils.FileUtils;
import java.io.IOException;
/* loaded from: classes8.dex */
public class yeb {
    public static /* synthetic */ Interceptable $ic = null;
    public static int g = 2;
    public static int h = 4;
    public static int i = 8;
    public static int j = 16;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public int c;
    public int d;
    public long e;
    public String f;

    /* loaded from: classes8.dex */
    public class a implements sfb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean[] a;
        public final /* synthetic */ yeb b;

        public a(yeb yebVar, boolean[] zArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yebVar, zArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yebVar;
            this.a = zArr;
        }

        @Override // com.baidu.tieba.sfb
        public void a(MediaFormat mediaFormat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaFormat) == null) {
                this.a[0] = true;
                this.b.l(mediaFormat);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948328691, "Lcom/baidu/tieba/yeb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948328691, "Lcom/baidu/tieba/yeb;");
        }
    }

    public yeb(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str;
        j(str);
    }

    public static yeb b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            yeb yebVar = new yeb("");
            yebVar.c = 2;
            yebVar.f = "audio/mp4a-latm";
            yebVar.b = 44100;
            yebVar.d = 16;
            return yebVar;
        }
        return (yeb) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.d : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : invokeV.intValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e / 1000 : invokeV.longValue;
    }

    public boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? (obj instanceof yeb) && k((yeb) obj) == 0 : invokeL.booleanValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f : (String) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b : invokeV.intValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i2 = this.d + this.b + this.c;
            String str = this.f;
            return i2 + (str != null ? str.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (TextUtils.isEmpty(this.f) || this.b == 0 || this.c == 0 || this.d == 0 || this.e == 0) ? false : true : invokeV.booleanValue;
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            try {
                if (m(str)) {
                    boolean[] zArr = {false};
                    rfb rfbVar = new rfb(str);
                    rfbVar.k(new a(this, zArr));
                    while (!zArr[0]) {
                        if (rfbVar.c()) {
                            zArr[0] = true;
                        }
                    }
                    rfbVar.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int k(yeb yebVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, yebVar)) == null) {
            if (yebVar == null) {
                return 0;
            }
            int i2 = yebVar.d != this.d ? 0 | g : 0;
            if (yebVar.b != this.b) {
                i2 |= h;
            }
            if (yebVar.c != this.c) {
                i2 |= i;
            }
            return !TextUtils.equals(yebVar.f, this.f) ? i2 | j : i2;
        }
        return invokeL.intValue;
    }

    public final boolean l(MediaFormat mediaFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, mediaFormat)) == null) {
            try {
                this.b = mediaFormat.getInteger("sample-rate");
                this.c = mediaFormat.getInteger("channel-count");
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            boolean z = false;
            if (FileUtils.isExists(str)) {
                MediaExtractor mediaExtractor = new MediaExtractor();
                try {
                    mediaExtractor.setDataSource(str);
                    MediaFormat mediaFormat = null;
                    for (int i2 = 0; i2 < mediaExtractor.getTrackCount(); i2++) {
                        MediaFormat trackFormat = mediaExtractor.getTrackFormat(i2);
                        if (trackFormat.getString("mime").startsWith("audio/")) {
                            mediaExtractor.selectTrack(i2);
                            mediaFormat = trackFormat;
                            break;
                        }
                    }
                    try {
                        if (mediaFormat == null) {
                            return false;
                        }
                        this.f = mediaFormat.getString("mime");
                        this.b = mediaFormat.getInteger("sample-rate");
                        this.c = mediaFormat.getInteger("channel-count");
                        this.e = mediaFormat.getLong("durationUs");
                        if (mediaFormat.containsKey("bit-width")) {
                            this.d = mediaFormat.getInteger("bit-width");
                        } else {
                            this.d = 16;
                        }
                        if (mediaFormat.containsKey("aac-profile")) {
                            if (mediaFormat.getInteger("aac-profile") != 2) {
                                z = true;
                            }
                        }
                        return z;
                    } catch (Exception e) {
                        iib.e("VideoMuxer", "initAudioProperty error:" + e.getMessage());
                        return false;
                    } finally {
                        mediaExtractor.release();
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
