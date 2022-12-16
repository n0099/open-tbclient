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
/* loaded from: classes6.dex */
public class vk9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;
    public String b;
    public MediaMuxer c;
    public int d;
    public int e;
    public MediaFormat f;
    public MediaFormat g;
    public ll9 h;

    public vk9(List<String> list, String str, ll9 ll9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, ll9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        mm9.e("VideoComposer", list.size() + " composer to " + str);
        this.a = list;
        this.b = str;
        this.h = ll9Var;
    }

    public final long a(long j, String str) throws IOException {
        InterceptResult invokeJL;
        boolean z;
        int i;
        int i2;
        uk9 uk9Var;
        int i3;
        uk9 uk9Var2;
        int i4;
        uk9 uk9Var3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, str)) == null) {
            String str3 = "VideoComposer";
            mm9.e("VideoComposer", j + " compose " + str);
            uk9 uk9Var4 = new uk9();
            uk9Var4.m(str, FileUtils.VIDEO_FILE_START);
            int d = uk9Var4.d();
            uk9 uk9Var5 = null;
            if (d < 0) {
                uk9Var4.j();
                uk9Var4 = null;
            } else {
                uk9Var4.l(this.e);
            }
            uk9 uk9Var6 = new uk9();
            uk9Var6.m(str, "audio/");
            int d2 = uk9Var6.d();
            if (d2 < 0) {
                uk9Var6.j();
            } else {
                uk9Var6.l(this.d);
                uk9Var5 = uk9Var6;
            }
            boolean z2 = false;
            if (uk9Var4 == null) {
                z = true;
            } else {
                z = false;
            }
            if (uk9Var5 == null) {
                z2 = true;
            }
            long j2 = 0;
            long j3 = 0;
            while (true) {
                if (z && z2) {
                    break;
                }
                if (!z2 && (z || uk9Var5.e() - uk9Var4.e() <= 50000)) {
                    i = this.d;
                    i3 = d2;
                    i2 = i3;
                    uk9Var = uk9Var5;
                } else {
                    i = this.e;
                    i2 = d2;
                    uk9Var = uk9Var4;
                    i3 = d;
                }
                MediaCodec.BufferInfo h = uk9Var.h();
                if (h == null) {
                    i4 = d;
                    uk9 uk9Var7 = uk9Var;
                    if (uk9Var7 == uk9Var4) {
                        j2 = uk9Var4.e();
                        d2 = i2;
                        d = i4;
                        z = true;
                    } else if (uk9Var7 == uk9Var5) {
                        j3 = uk9Var5.e();
                        d2 = i2;
                        d = i4;
                        z2 = true;
                    } else {
                        uk9Var2 = uk9Var4;
                        uk9Var3 = uk9Var5;
                        str2 = str3;
                    }
                } else {
                    uk9Var2 = uk9Var4;
                    i4 = d;
                    uk9 uk9Var8 = uk9Var;
                    if (uk9Var8.f() != i3) {
                        StringBuilder sb = new StringBuilder();
                        uk9Var3 = uk9Var5;
                        sb.append("WEIRD: got sample from track ");
                        sb.append(uk9Var8.f());
                        sb.append(", expected ");
                        sb.append(i3);
                        mm9.e(str3, sb.toString());
                    } else {
                        uk9Var3 = uk9Var5;
                    }
                    str2 = str3;
                    h.presentationTimeUs += j;
                    this.c.writeSampleData(i, uk9Var8.c(), h);
                    uk9Var8.a();
                }
                str3 = str2;
                d2 = i2;
                d = i4;
                uk9Var4 = uk9Var2;
                uk9Var5 = uk9Var3;
            }
            long max = j + Math.max(j2, j3) + 10000;
            ll9 ll9Var = this.h;
            if (ll9Var != null) {
                ll9Var.b(max);
            }
            mm9.e(str3, "finish one file, ptsOffset " + max);
            if (uk9Var4 != null) {
                uk9Var4.j();
            }
            if (uk9Var5 != null) {
                uk9Var5.j();
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
                    uk9 uk9Var = new uk9();
                    try {
                        uk9Var.m(str, FileUtils.VIDEO_FILE_START);
                        if (!z) {
                            MediaFormat mediaFormat = uk9Var.g().a;
                            this.g = mediaFormat;
                            if (mediaFormat == null) {
                                mm9.e("VideoComposer", "No video track found in " + str);
                            } else {
                                z = true;
                            }
                        }
                        if (!z2) {
                            MediaFormat mediaFormat2 = uk9Var.b().a;
                            this.f = mediaFormat2;
                            if (mediaFormat2 == null) {
                                mm9.e("VideoComposer", "No audio track found in " + str);
                            } else {
                                z2 = true;
                            }
                        }
                    } catch (Exception e) {
                        mm9.e("VideoComposer", e.getMessage());
                        e.printStackTrace();
                    }
                    uk9Var.j();
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
                    mm9.e("VideoComposer", "Muxer close error. No data was written");
                }
                this.c = null;
            }
            mm9.j("VideoComposer", "video join finished");
            return true;
        }
        return invokeL.booleanValue;
    }
}
