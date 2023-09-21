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
public class jib {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;
    public String b;
    public MediaMuxer c;
    public int d;
    public int e;
    public MediaFormat f;
    public MediaFormat g;
    public zib h;

    public jib(List<String> list, String str, zib zibVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, zibVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        akb.e("VideoComposer", list.size() + " composer to " + str);
        this.a = list;
        this.b = str;
        this.h = zibVar;
    }

    public final long a(long j, String str) throws IOException {
        InterceptResult invokeJL;
        boolean z;
        int i;
        int i2;
        iib iibVar;
        int i3;
        iib iibVar2;
        int i4;
        iib iibVar3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, str)) == null) {
            String str3 = "VideoComposer";
            akb.e("VideoComposer", j + " compose " + str);
            iib iibVar4 = new iib();
            iibVar4.m(str, FileUtils.VIDEO_FILE_START);
            int d = iibVar4.d();
            iib iibVar5 = null;
            if (d < 0) {
                iibVar4.j();
                iibVar4 = null;
            } else {
                iibVar4.l(this.e);
            }
            iib iibVar6 = new iib();
            iibVar6.m(str, "audio/");
            int d2 = iibVar6.d();
            if (d2 < 0) {
                iibVar6.j();
            } else {
                iibVar6.l(this.d);
                iibVar5 = iibVar6;
            }
            boolean z2 = false;
            if (iibVar4 == null) {
                z = true;
            } else {
                z = false;
            }
            if (iibVar5 == null) {
                z2 = true;
            }
            long j2 = 0;
            long j3 = 0;
            while (true) {
                if (z && z2) {
                    break;
                }
                if (!z2 && (z || iibVar5.e() - iibVar4.e() <= 50000)) {
                    i = this.d;
                    i3 = d2;
                    i2 = i3;
                    iibVar = iibVar5;
                } else {
                    i = this.e;
                    i2 = d2;
                    iibVar = iibVar4;
                    i3 = d;
                }
                MediaCodec.BufferInfo h = iibVar.h();
                if (h == null) {
                    i4 = d;
                    iib iibVar7 = iibVar;
                    if (iibVar7 == iibVar4) {
                        j2 = iibVar4.e();
                        d2 = i2;
                        d = i4;
                        z = true;
                    } else if (iibVar7 == iibVar5) {
                        j3 = iibVar5.e();
                        d2 = i2;
                        d = i4;
                        z2 = true;
                    } else {
                        iibVar2 = iibVar4;
                        iibVar3 = iibVar5;
                        str2 = str3;
                    }
                } else {
                    iibVar2 = iibVar4;
                    i4 = d;
                    iib iibVar8 = iibVar;
                    if (iibVar8.f() != i3) {
                        StringBuilder sb = new StringBuilder();
                        iibVar3 = iibVar5;
                        sb.append("WEIRD: got sample from track ");
                        sb.append(iibVar8.f());
                        sb.append(", expected ");
                        sb.append(i3);
                        akb.e(str3, sb.toString());
                    } else {
                        iibVar3 = iibVar5;
                    }
                    str2 = str3;
                    h.presentationTimeUs += j;
                    this.c.writeSampleData(i, iibVar8.c(), h);
                    iibVar8.a();
                }
                str3 = str2;
                d2 = i2;
                d = i4;
                iibVar4 = iibVar2;
                iibVar5 = iibVar3;
            }
            long max = j + Math.max(j2, j3) + 10000;
            zib zibVar = this.h;
            if (zibVar != null) {
                zibVar.c(max);
            }
            akb.e(str3, "finish one file, ptsOffset " + max);
            if (iibVar4 != null) {
                iibVar4.j();
            }
            if (iibVar5 != null) {
                iibVar5.j();
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
                    iib iibVar = new iib();
                    try {
                        iibVar.m(str, FileUtils.VIDEO_FILE_START);
                        if (!z) {
                            MediaFormat mediaFormat = iibVar.g().a;
                            this.g = mediaFormat;
                            if (mediaFormat == null) {
                                akb.e("VideoComposer", "No video track found in " + str);
                            } else {
                                z = true;
                            }
                        }
                        if (!z2) {
                            MediaFormat mediaFormat2 = iibVar.b().a;
                            this.f = mediaFormat2;
                            if (mediaFormat2 == null) {
                                akb.e("VideoComposer", "No audio track found in " + str);
                            } else {
                                z2 = true;
                            }
                        }
                    } catch (Exception e) {
                        akb.e("VideoComposer", e.getMessage());
                        e.printStackTrace();
                    }
                    iibVar.j();
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
                    akb.e("VideoComposer", "Muxer close error. No data was written");
                }
                this.c = null;
            }
            akb.j("VideoComposer", "video join finished");
            return true;
        }
        return invokeL.booleanValue;
    }
}
