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
public class mz9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;
    public String b;
    public MediaMuxer c;
    public int d;
    public int e;
    public MediaFormat f;
    public MediaFormat g;
    public c0a h;

    public mz9(List<String> list, String str, c0a c0aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, c0aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        d1a.e("VideoComposer", list.size() + " composer to " + str);
        this.a = list;
        this.b = str;
        this.h = c0aVar;
    }

    public final long a(long j, String str) throws IOException {
        InterceptResult invokeJL;
        boolean z;
        int i;
        int i2;
        lz9 lz9Var;
        int i3;
        lz9 lz9Var2;
        int i4;
        lz9 lz9Var3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, str)) == null) {
            String str3 = "VideoComposer";
            d1a.e("VideoComposer", j + " compose " + str);
            lz9 lz9Var4 = new lz9();
            lz9Var4.m(str, FileUtils.VIDEO_FILE_START);
            int d = lz9Var4.d();
            lz9 lz9Var5 = null;
            if (d < 0) {
                lz9Var4.j();
                lz9Var4 = null;
            } else {
                lz9Var4.l(this.e);
            }
            lz9 lz9Var6 = new lz9();
            lz9Var6.m(str, "audio/");
            int d2 = lz9Var6.d();
            if (d2 < 0) {
                lz9Var6.j();
            } else {
                lz9Var6.l(this.d);
                lz9Var5 = lz9Var6;
            }
            boolean z2 = false;
            if (lz9Var4 == null) {
                z = true;
            } else {
                z = false;
            }
            if (lz9Var5 == null) {
                z2 = true;
            }
            long j2 = 0;
            long j3 = 0;
            while (true) {
                if (z && z2) {
                    break;
                }
                if (!z2 && (z || lz9Var5.e() - lz9Var4.e() <= 50000)) {
                    i = this.d;
                    i3 = d2;
                    i2 = i3;
                    lz9Var = lz9Var5;
                } else {
                    i = this.e;
                    i2 = d2;
                    lz9Var = lz9Var4;
                    i3 = d;
                }
                MediaCodec.BufferInfo h = lz9Var.h();
                if (h == null) {
                    i4 = d;
                    lz9 lz9Var7 = lz9Var;
                    if (lz9Var7 == lz9Var4) {
                        j2 = lz9Var4.e();
                        d2 = i2;
                        d = i4;
                        z = true;
                    } else if (lz9Var7 == lz9Var5) {
                        j3 = lz9Var5.e();
                        d2 = i2;
                        d = i4;
                        z2 = true;
                    } else {
                        lz9Var2 = lz9Var4;
                        lz9Var3 = lz9Var5;
                        str2 = str3;
                    }
                } else {
                    lz9Var2 = lz9Var4;
                    i4 = d;
                    lz9 lz9Var8 = lz9Var;
                    if (lz9Var8.f() != i3) {
                        StringBuilder sb = new StringBuilder();
                        lz9Var3 = lz9Var5;
                        sb.append("WEIRD: got sample from track ");
                        sb.append(lz9Var8.f());
                        sb.append(", expected ");
                        sb.append(i3);
                        d1a.e(str3, sb.toString());
                    } else {
                        lz9Var3 = lz9Var5;
                    }
                    str2 = str3;
                    h.presentationTimeUs += j;
                    this.c.writeSampleData(i, lz9Var8.c(), h);
                    lz9Var8.a();
                }
                str3 = str2;
                d2 = i2;
                d = i4;
                lz9Var4 = lz9Var2;
                lz9Var5 = lz9Var3;
            }
            long max = j + Math.max(j2, j3) + 10000;
            c0a c0aVar = this.h;
            if (c0aVar != null) {
                c0aVar.b(max);
            }
            d1a.e(str3, "finish one file, ptsOffset " + max);
            if (lz9Var4 != null) {
                lz9Var4.j();
            }
            if (lz9Var5 != null) {
                lz9Var5.j();
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
                    lz9 lz9Var = new lz9();
                    try {
                        lz9Var.m(str, FileUtils.VIDEO_FILE_START);
                        if (!z) {
                            MediaFormat mediaFormat = lz9Var.g().a;
                            this.g = mediaFormat;
                            if (mediaFormat == null) {
                                d1a.e("VideoComposer", "No video track found in " + str);
                            } else {
                                z = true;
                            }
                        }
                        if (!z2) {
                            MediaFormat mediaFormat2 = lz9Var.b().a;
                            this.f = mediaFormat2;
                            if (mediaFormat2 == null) {
                                d1a.e("VideoComposer", "No audio track found in " + str);
                            } else {
                                z2 = true;
                            }
                        }
                    } catch (Exception e) {
                        d1a.e("VideoComposer", e.getMessage());
                        e.printStackTrace();
                    }
                    lz9Var.j();
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
                    d1a.e("VideoComposer", "Muxer close error. No data was written");
                }
                this.c = null;
            }
            d1a.j("VideoComposer", "video join finished");
            return true;
        }
        return invokeL.booleanValue;
    }
}
