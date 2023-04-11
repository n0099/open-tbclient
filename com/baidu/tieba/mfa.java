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
public class mfa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;
    public String b;
    public MediaMuxer c;
    public int d;
    public int e;
    public MediaFormat f;
    public MediaFormat g;
    public cga h;

    public mfa(List<String> list, String str, cga cgaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, cgaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        dha.e("VideoComposer", list.size() + " composer to " + str);
        this.a = list;
        this.b = str;
        this.h = cgaVar;
    }

    public final long a(long j, String str) throws IOException {
        InterceptResult invokeJL;
        boolean z;
        int i;
        int i2;
        lfa lfaVar;
        int i3;
        lfa lfaVar2;
        int i4;
        lfa lfaVar3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, str)) == null) {
            String str3 = "VideoComposer";
            dha.e("VideoComposer", j + " compose " + str);
            lfa lfaVar4 = new lfa();
            lfaVar4.m(str, FileUtils.VIDEO_FILE_START);
            int d = lfaVar4.d();
            lfa lfaVar5 = null;
            if (d < 0) {
                lfaVar4.j();
                lfaVar4 = null;
            } else {
                lfaVar4.l(this.e);
            }
            lfa lfaVar6 = new lfa();
            lfaVar6.m(str, "audio/");
            int d2 = lfaVar6.d();
            if (d2 < 0) {
                lfaVar6.j();
            } else {
                lfaVar6.l(this.d);
                lfaVar5 = lfaVar6;
            }
            boolean z2 = false;
            if (lfaVar4 == null) {
                z = true;
            } else {
                z = false;
            }
            if (lfaVar5 == null) {
                z2 = true;
            }
            long j2 = 0;
            long j3 = 0;
            while (true) {
                if (z && z2) {
                    break;
                }
                if (!z2 && (z || lfaVar5.e() - lfaVar4.e() <= 50000)) {
                    i = this.d;
                    i3 = d2;
                    i2 = i3;
                    lfaVar = lfaVar5;
                } else {
                    i = this.e;
                    i2 = d2;
                    lfaVar = lfaVar4;
                    i3 = d;
                }
                MediaCodec.BufferInfo h = lfaVar.h();
                if (h == null) {
                    i4 = d;
                    lfa lfaVar7 = lfaVar;
                    if (lfaVar7 == lfaVar4) {
                        j2 = lfaVar4.e();
                        d2 = i2;
                        d = i4;
                        z = true;
                    } else if (lfaVar7 == lfaVar5) {
                        j3 = lfaVar5.e();
                        d2 = i2;
                        d = i4;
                        z2 = true;
                    } else {
                        lfaVar2 = lfaVar4;
                        lfaVar3 = lfaVar5;
                        str2 = str3;
                    }
                } else {
                    lfaVar2 = lfaVar4;
                    i4 = d;
                    lfa lfaVar8 = lfaVar;
                    if (lfaVar8.f() != i3) {
                        StringBuilder sb = new StringBuilder();
                        lfaVar3 = lfaVar5;
                        sb.append("WEIRD: got sample from track ");
                        sb.append(lfaVar8.f());
                        sb.append(", expected ");
                        sb.append(i3);
                        dha.e(str3, sb.toString());
                    } else {
                        lfaVar3 = lfaVar5;
                    }
                    str2 = str3;
                    h.presentationTimeUs += j;
                    this.c.writeSampleData(i, lfaVar8.c(), h);
                    lfaVar8.a();
                }
                str3 = str2;
                d2 = i2;
                d = i4;
                lfaVar4 = lfaVar2;
                lfaVar5 = lfaVar3;
            }
            long max = j + Math.max(j2, j3) + 10000;
            cga cgaVar = this.h;
            if (cgaVar != null) {
                cgaVar.b(max);
            }
            dha.e(str3, "finish one file, ptsOffset " + max);
            if (lfaVar4 != null) {
                lfaVar4.j();
            }
            if (lfaVar5 != null) {
                lfaVar5.j();
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
                    lfa lfaVar = new lfa();
                    try {
                        lfaVar.m(str, FileUtils.VIDEO_FILE_START);
                        if (!z) {
                            MediaFormat mediaFormat = lfaVar.g().a;
                            this.g = mediaFormat;
                            if (mediaFormat == null) {
                                dha.e("VideoComposer", "No video track found in " + str);
                            } else {
                                z = true;
                            }
                        }
                        if (!z2) {
                            MediaFormat mediaFormat2 = lfaVar.b().a;
                            this.f = mediaFormat2;
                            if (mediaFormat2 == null) {
                                dha.e("VideoComposer", "No audio track found in " + str);
                            } else {
                                z2 = true;
                            }
                        }
                    } catch (Exception e) {
                        dha.e("VideoComposer", e.getMessage());
                        e.printStackTrace();
                    }
                    lfaVar.j();
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
                    dha.e("VideoComposer", "Muxer close error. No data was written");
                }
                this.c = null;
            }
            dha.j("VideoComposer", "video join finished");
            return true;
        }
        return invokeL.booleanValue;
    }
}
