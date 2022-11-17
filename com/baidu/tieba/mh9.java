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
/* loaded from: classes5.dex */
public class mh9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;
    public String b;
    public MediaMuxer c;
    public int d;
    public int e;
    public MediaFormat f;
    public MediaFormat g;
    public ci9 h;

    public mh9(List<String> list, String str, ci9 ci9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, ci9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        dj9.e("VideoComposer", list.size() + " composer to " + str);
        this.a = list;
        this.b = str;
        this.h = ci9Var;
    }

    public final long a(long j, String str) throws IOException {
        InterceptResult invokeJL;
        boolean z;
        int i;
        int i2;
        lh9 lh9Var;
        int i3;
        lh9 lh9Var2;
        int i4;
        lh9 lh9Var3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, str)) == null) {
            String str3 = "VideoComposer";
            dj9.e("VideoComposer", j + " compose " + str);
            lh9 lh9Var4 = new lh9();
            lh9Var4.m(str, FileUtils.VIDEO_FILE_START);
            int d = lh9Var4.d();
            lh9 lh9Var5 = null;
            if (d < 0) {
                lh9Var4.j();
                lh9Var4 = null;
            } else {
                lh9Var4.l(this.e);
            }
            lh9 lh9Var6 = new lh9();
            lh9Var6.m(str, "audio/");
            int d2 = lh9Var6.d();
            if (d2 < 0) {
                lh9Var6.j();
            } else {
                lh9Var6.l(this.d);
                lh9Var5 = lh9Var6;
            }
            boolean z2 = false;
            if (lh9Var4 == null) {
                z = true;
            } else {
                z = false;
            }
            if (lh9Var5 == null) {
                z2 = true;
            }
            long j2 = 0;
            long j3 = 0;
            while (true) {
                if (z && z2) {
                    break;
                }
                if (!z2 && (z || lh9Var5.e() - lh9Var4.e() <= 50000)) {
                    i = this.d;
                    i3 = d2;
                    i2 = i3;
                    lh9Var = lh9Var5;
                } else {
                    i = this.e;
                    i2 = d2;
                    lh9Var = lh9Var4;
                    i3 = d;
                }
                MediaCodec.BufferInfo h = lh9Var.h();
                if (h == null) {
                    i4 = d;
                    lh9 lh9Var7 = lh9Var;
                    if (lh9Var7 == lh9Var4) {
                        j2 = lh9Var4.e();
                        d2 = i2;
                        d = i4;
                        z = true;
                    } else if (lh9Var7 == lh9Var5) {
                        j3 = lh9Var5.e();
                        d2 = i2;
                        d = i4;
                        z2 = true;
                    } else {
                        lh9Var2 = lh9Var4;
                        lh9Var3 = lh9Var5;
                        str2 = str3;
                    }
                } else {
                    lh9Var2 = lh9Var4;
                    i4 = d;
                    lh9 lh9Var8 = lh9Var;
                    if (lh9Var8.f() != i3) {
                        StringBuilder sb = new StringBuilder();
                        lh9Var3 = lh9Var5;
                        sb.append("WEIRD: got sample from track ");
                        sb.append(lh9Var8.f());
                        sb.append(", expected ");
                        sb.append(i3);
                        dj9.e(str3, sb.toString());
                    } else {
                        lh9Var3 = lh9Var5;
                    }
                    str2 = str3;
                    h.presentationTimeUs += j;
                    this.c.writeSampleData(i, lh9Var8.c(), h);
                    lh9Var8.a();
                }
                str3 = str2;
                d2 = i2;
                d = i4;
                lh9Var4 = lh9Var2;
                lh9Var5 = lh9Var3;
            }
            long max = j + Math.max(j2, j3) + 10000;
            ci9 ci9Var = this.h;
            if (ci9Var != null) {
                ci9Var.b(max);
            }
            dj9.e(str3, "finish one file, ptsOffset " + max);
            if (lh9Var4 != null) {
                lh9Var4.j();
            }
            if (lh9Var5 != null) {
                lh9Var5.j();
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
                    lh9 lh9Var = new lh9();
                    try {
                        lh9Var.m(str, FileUtils.VIDEO_FILE_START);
                        if (!z) {
                            MediaFormat mediaFormat = lh9Var.g().a;
                            this.g = mediaFormat;
                            if (mediaFormat == null) {
                                dj9.e("VideoComposer", "No video track found in " + str);
                            } else {
                                z = true;
                            }
                        }
                        if (!z2) {
                            MediaFormat mediaFormat2 = lh9Var.b().a;
                            this.f = mediaFormat2;
                            if (mediaFormat2 == null) {
                                dj9.e("VideoComposer", "No audio track found in " + str);
                            } else {
                                z2 = true;
                            }
                        }
                    } catch (Exception e) {
                        dj9.e("VideoComposer", e.getMessage());
                        e.printStackTrace();
                    }
                    lh9Var.j();
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
                    dj9.e("VideoComposer", "Muxer close error. No data was written");
                }
                this.c = null;
            }
            dj9.j("VideoComposer", "video join finished");
            return true;
        }
        return invokeL.booleanValue;
    }
}
