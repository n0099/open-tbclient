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
public class qja {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;
    public String b;
    public MediaMuxer c;
    public int d;
    public int e;
    public MediaFormat f;
    public MediaFormat g;
    public gka h;

    public qja(List<String> list, String str, gka gkaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, gkaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        hla.e("VideoComposer", list.size() + " composer to " + str);
        this.a = list;
        this.b = str;
        this.h = gkaVar;
    }

    public final long a(long j, String str) throws IOException {
        InterceptResult invokeJL;
        boolean z;
        int i;
        int i2;
        pja pjaVar;
        int i3;
        pja pjaVar2;
        int i4;
        pja pjaVar3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, str)) == null) {
            String str3 = "VideoComposer";
            hla.e("VideoComposer", j + " compose " + str);
            pja pjaVar4 = new pja();
            pjaVar4.m(str, FileUtils.VIDEO_FILE_START);
            int d = pjaVar4.d();
            pja pjaVar5 = null;
            if (d < 0) {
                pjaVar4.j();
                pjaVar4 = null;
            } else {
                pjaVar4.l(this.e);
            }
            pja pjaVar6 = new pja();
            pjaVar6.m(str, "audio/");
            int d2 = pjaVar6.d();
            if (d2 < 0) {
                pjaVar6.j();
            } else {
                pjaVar6.l(this.d);
                pjaVar5 = pjaVar6;
            }
            boolean z2 = false;
            if (pjaVar4 == null) {
                z = true;
            } else {
                z = false;
            }
            if (pjaVar5 == null) {
                z2 = true;
            }
            long j2 = 0;
            long j3 = 0;
            while (true) {
                if (z && z2) {
                    break;
                }
                if (!z2 && (z || pjaVar5.e() - pjaVar4.e() <= 50000)) {
                    i = this.d;
                    i3 = d2;
                    i2 = i3;
                    pjaVar = pjaVar5;
                } else {
                    i = this.e;
                    i2 = d2;
                    pjaVar = pjaVar4;
                    i3 = d;
                }
                MediaCodec.BufferInfo h = pjaVar.h();
                if (h == null) {
                    i4 = d;
                    pja pjaVar7 = pjaVar;
                    if (pjaVar7 == pjaVar4) {
                        j2 = pjaVar4.e();
                        d2 = i2;
                        d = i4;
                        z = true;
                    } else if (pjaVar7 == pjaVar5) {
                        j3 = pjaVar5.e();
                        d2 = i2;
                        d = i4;
                        z2 = true;
                    } else {
                        pjaVar2 = pjaVar4;
                        pjaVar3 = pjaVar5;
                        str2 = str3;
                    }
                } else {
                    pjaVar2 = pjaVar4;
                    i4 = d;
                    pja pjaVar8 = pjaVar;
                    if (pjaVar8.f() != i3) {
                        StringBuilder sb = new StringBuilder();
                        pjaVar3 = pjaVar5;
                        sb.append("WEIRD: got sample from track ");
                        sb.append(pjaVar8.f());
                        sb.append(", expected ");
                        sb.append(i3);
                        hla.e(str3, sb.toString());
                    } else {
                        pjaVar3 = pjaVar5;
                    }
                    str2 = str3;
                    h.presentationTimeUs += j;
                    this.c.writeSampleData(i, pjaVar8.c(), h);
                    pjaVar8.a();
                }
                str3 = str2;
                d2 = i2;
                d = i4;
                pjaVar4 = pjaVar2;
                pjaVar5 = pjaVar3;
            }
            long max = j + Math.max(j2, j3) + 10000;
            gka gkaVar = this.h;
            if (gkaVar != null) {
                gkaVar.b(max);
            }
            hla.e(str3, "finish one file, ptsOffset " + max);
            if (pjaVar4 != null) {
                pjaVar4.j();
            }
            if (pjaVar5 != null) {
                pjaVar5.j();
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
                    pja pjaVar = new pja();
                    try {
                        pjaVar.m(str, FileUtils.VIDEO_FILE_START);
                        if (!z) {
                            MediaFormat mediaFormat = pjaVar.g().a;
                            this.g = mediaFormat;
                            if (mediaFormat == null) {
                                hla.e("VideoComposer", "No video track found in " + str);
                            } else {
                                z = true;
                            }
                        }
                        if (!z2) {
                            MediaFormat mediaFormat2 = pjaVar.b().a;
                            this.f = mediaFormat2;
                            if (mediaFormat2 == null) {
                                hla.e("VideoComposer", "No audio track found in " + str);
                            } else {
                                z2 = true;
                            }
                        }
                    } catch (Exception e) {
                        hla.e("VideoComposer", e.getMessage());
                        e.printStackTrace();
                    }
                    pjaVar.j();
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
                    hla.e("VideoComposer", "Muxer close error. No data was written");
                }
                this.c = null;
            }
            hla.j("VideoComposer", "video join finished");
            return true;
        }
        return invokeL.booleanValue;
    }
}
