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
/* loaded from: classes7.dex */
public class qza {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;
    public String b;
    public MediaMuxer c;
    public int d;
    public int e;
    public MediaFormat f;
    public MediaFormat g;
    public g0b h;

    public qza(List<String> list, String str, g0b g0bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, g0bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        h1b.e("VideoComposer", list.size() + " composer to " + str);
        this.a = list;
        this.b = str;
        this.h = g0bVar;
    }

    public final long a(long j, String str) throws IOException {
        InterceptResult invokeJL;
        boolean z;
        int i;
        int i2;
        pza pzaVar;
        int i3;
        pza pzaVar2;
        int i4;
        pza pzaVar3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, str)) == null) {
            String str3 = "VideoComposer";
            h1b.e("VideoComposer", j + " compose " + str);
            pza pzaVar4 = new pza();
            pzaVar4.m(str, FileUtils.VIDEO_FILE_START);
            int d = pzaVar4.d();
            pza pzaVar5 = null;
            if (d < 0) {
                pzaVar4.j();
                pzaVar4 = null;
            } else {
                pzaVar4.l(this.e);
            }
            pza pzaVar6 = new pza();
            pzaVar6.m(str, "audio/");
            int d2 = pzaVar6.d();
            if (d2 < 0) {
                pzaVar6.j();
            } else {
                pzaVar6.l(this.d);
                pzaVar5 = pzaVar6;
            }
            boolean z2 = false;
            if (pzaVar4 == null) {
                z = true;
            } else {
                z = false;
            }
            if (pzaVar5 == null) {
                z2 = true;
            }
            long j2 = 0;
            long j3 = 0;
            while (true) {
                if (z && z2) {
                    break;
                }
                if (!z2 && (z || pzaVar5.e() - pzaVar4.e() <= 50000)) {
                    i = this.d;
                    i3 = d2;
                    i2 = i3;
                    pzaVar = pzaVar5;
                } else {
                    i = this.e;
                    i2 = d2;
                    pzaVar = pzaVar4;
                    i3 = d;
                }
                MediaCodec.BufferInfo h = pzaVar.h();
                if (h == null) {
                    i4 = d;
                    pza pzaVar7 = pzaVar;
                    if (pzaVar7 == pzaVar4) {
                        j2 = pzaVar4.e();
                        d2 = i2;
                        d = i4;
                        z = true;
                    } else if (pzaVar7 == pzaVar5) {
                        j3 = pzaVar5.e();
                        d2 = i2;
                        d = i4;
                        z2 = true;
                    } else {
                        pzaVar2 = pzaVar4;
                        pzaVar3 = pzaVar5;
                        str2 = str3;
                    }
                } else {
                    pzaVar2 = pzaVar4;
                    i4 = d;
                    pza pzaVar8 = pzaVar;
                    if (pzaVar8.f() != i3) {
                        StringBuilder sb = new StringBuilder();
                        pzaVar3 = pzaVar5;
                        sb.append("WEIRD: got sample from track ");
                        sb.append(pzaVar8.f());
                        sb.append(", expected ");
                        sb.append(i3);
                        h1b.e(str3, sb.toString());
                    } else {
                        pzaVar3 = pzaVar5;
                    }
                    str2 = str3;
                    h.presentationTimeUs += j;
                    this.c.writeSampleData(i, pzaVar8.c(), h);
                    pzaVar8.a();
                }
                str3 = str2;
                d2 = i2;
                d = i4;
                pzaVar4 = pzaVar2;
                pzaVar5 = pzaVar3;
            }
            long max = j + Math.max(j2, j3) + 10000;
            g0b g0bVar = this.h;
            if (g0bVar != null) {
                g0bVar.b(max);
            }
            h1b.e(str3, "finish one file, ptsOffset " + max);
            if (pzaVar4 != null) {
                pzaVar4.j();
            }
            if (pzaVar5 != null) {
                pzaVar5.j();
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
                    pza pzaVar = new pza();
                    try {
                        pzaVar.m(str, FileUtils.VIDEO_FILE_START);
                        if (!z) {
                            MediaFormat mediaFormat = pzaVar.g().a;
                            this.g = mediaFormat;
                            if (mediaFormat == null) {
                                h1b.e("VideoComposer", "No video track found in " + str);
                            } else {
                                z = true;
                            }
                        }
                        if (!z2) {
                            MediaFormat mediaFormat2 = pzaVar.b().a;
                            this.f = mediaFormat2;
                            if (mediaFormat2 == null) {
                                h1b.e("VideoComposer", "No audio track found in " + str);
                            } else {
                                z2 = true;
                            }
                        }
                    } catch (Exception e) {
                        h1b.e("VideoComposer", e.getMessage());
                        e.printStackTrace();
                    }
                    pzaVar.j();
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
                    h1b.e("VideoComposer", "Muxer close error. No data was written");
                }
                this.c = null;
            }
            h1b.j("VideoComposer", "video join finished");
            return true;
        }
        return invokeL.booleanValue;
    }
}
