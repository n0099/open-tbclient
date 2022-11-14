package com.baidu.tieba;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.IOException;
import java.util.List;
@TargetApi(18)
/* loaded from: classes4.dex */
public class lh9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;
    public String b;
    public MediaMuxer c;
    public int d;
    public int e;
    public MediaFormat f;
    public MediaFormat g;
    public bi9 h;

    public lh9(List<String> list, String str, bi9 bi9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, bi9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        cj9.e("VideoComposer", list.size() + " composer to " + str);
        this.a = list;
        this.b = str;
        this.h = bi9Var;
    }

    public final long a(long j, String str) throws IOException {
        InterceptResult invokeJL;
        boolean z;
        int i;
        int i2;
        kh9 kh9Var;
        int i3;
        kh9 kh9Var2;
        int i4;
        kh9 kh9Var3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, str)) == null) {
            String str3 = "VideoComposer";
            cj9.e("VideoComposer", j + " compose " + str);
            kh9 kh9Var4 = new kh9();
            kh9Var4.m(str, FileUtils.VIDEO_FILE_START);
            int d = kh9Var4.d();
            kh9 kh9Var5 = null;
            if (d < 0) {
                kh9Var4.j();
                kh9Var4 = null;
            } else {
                kh9Var4.l(this.e);
            }
            kh9 kh9Var6 = new kh9();
            kh9Var6.m(str, "audio/");
            int d2 = kh9Var6.d();
            if (d2 < 0) {
                kh9Var6.j();
            } else {
                kh9Var6.l(this.d);
                kh9Var5 = kh9Var6;
            }
            boolean z2 = false;
            if (kh9Var4 == null) {
                z = true;
            } else {
                z = false;
            }
            if (kh9Var5 == null) {
                z2 = true;
            }
            long j2 = 0;
            long j3 = 0;
            while (true) {
                if (z && z2) {
                    break;
                }
                if (!z2 && (z || kh9Var5.e() - kh9Var4.e() <= 50000)) {
                    i = this.d;
                    i3 = d2;
                    i2 = i3;
                    kh9Var = kh9Var5;
                } else {
                    i = this.e;
                    i2 = d2;
                    kh9Var = kh9Var4;
                    i3 = d;
                }
                MediaCodec.BufferInfo h = kh9Var.h();
                if (h == null) {
                    i4 = d;
                    kh9 kh9Var7 = kh9Var;
                    if (kh9Var7 == kh9Var4) {
                        j2 = kh9Var4.e();
                        d2 = i2;
                        d = i4;
                        z = true;
                    } else if (kh9Var7 == kh9Var5) {
                        j3 = kh9Var5.e();
                        d2 = i2;
                        d = i4;
                        z2 = true;
                    } else {
                        kh9Var2 = kh9Var4;
                        kh9Var3 = kh9Var5;
                        str2 = str3;
                    }
                } else {
                    kh9Var2 = kh9Var4;
                    i4 = d;
                    kh9 kh9Var8 = kh9Var;
                    if (kh9Var8.f() != i3) {
                        StringBuilder sb = new StringBuilder();
                        kh9Var3 = kh9Var5;
                        sb.append("WEIRD: got sample from track ");
                        sb.append(kh9Var8.f());
                        sb.append(", expected ");
                        sb.append(i3);
                        cj9.e(str3, sb.toString());
                    } else {
                        kh9Var3 = kh9Var5;
                    }
                    str2 = str3;
                    h.presentationTimeUs += j;
                    this.c.writeSampleData(i, kh9Var8.c(), h);
                    kh9Var8.a();
                }
                str3 = str2;
                d2 = i2;
                d = i4;
                kh9Var4 = kh9Var2;
                kh9Var5 = kh9Var3;
            }
            long max = j + Math.max(j2, j3) + 10000;
            bi9 bi9Var = this.h;
            if (bi9Var != null) {
                bi9Var.b(max);
            }
            cj9.e(str3, "finish one file, ptsOffset " + max);
            if (kh9Var4 != null) {
                kh9Var4.j();
            }
            if (kh9Var5 != null) {
                kh9Var5.j();
            }
            return max;
        }
        return invokeJL.longValue;
    }

    public boolean b(StringBuilder sb) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sb)) == null) {
            boolean z = false;
            boolean z2 = false;
            for (String str : this.a) {
                try {
                    kh9 kh9Var = new kh9();
                    try {
                        kh9Var.m(str, FileUtils.VIDEO_FILE_START);
                        if (!z) {
                            MediaFormat mediaFormat = kh9Var.g().a;
                            this.g = mediaFormat;
                            if (mediaFormat == null) {
                                cj9.e("VideoComposer", "No video track found in " + str);
                            } else {
                                z = true;
                            }
                        }
                        if (!z2) {
                            MediaFormat mediaFormat2 = kh9Var.b().a;
                            this.f = mediaFormat2;
                            if (mediaFormat2 == null) {
                                cj9.e("VideoComposer", "No audio track found in " + str);
                            } else {
                                z2 = true;
                            }
                        }
                    } catch (Exception e) {
                        cj9.e("VideoComposer", e.getMessage());
                        e.printStackTrace();
                    }
                    kh9Var.j();
                    if (z && z2) {
                        break;
                    }
                } catch (Exception e2) {
                    if (sb != null) {
                        sb.append("VideoSplicer codec 录制视频拼接过程中发生异常:" + e2.getMessage());
                    }
                    e2.printStackTrace();
                    return false;
                }
            }
            MediaMuxer mediaMuxer = new MediaMuxer(this.b, 0);
            this.c = mediaMuxer;
            if (z) {
                this.e = mediaMuxer.addTrack(this.g);
            }
            if (z2) {
                this.d = this.c.addTrack(this.f);
            }
            this.c.start();
            long j = 0;
            for (String str2 : this.a) {
                j = a(j, str2);
            }
            if (this.c != null) {
                try {
                    this.c.stop();
                    this.c.release();
                } catch (Exception unused) {
                    cj9.e("VideoComposer", "Muxer close error. No data was written");
                }
                this.c = null;
            }
            cj9.j("VideoComposer", "video join finished");
            return true;
        }
        return invokeL.booleanValue;
    }
}
