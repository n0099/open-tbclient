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
public class pla {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;
    public String b;
    public MediaMuxer c;
    public int d;
    public int e;
    public MediaFormat f;
    public MediaFormat g;
    public fma h;

    public pla(List<String> list, String str, fma fmaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, fmaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        gna.e("VideoComposer", list.size() + " composer to " + str);
        this.a = list;
        this.b = str;
        this.h = fmaVar;
    }

    public final long a(long j, String str) throws IOException {
        InterceptResult invokeJL;
        boolean z;
        int i;
        int i2;
        ola olaVar;
        int i3;
        ola olaVar2;
        int i4;
        ola olaVar3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, str)) == null) {
            String str3 = "VideoComposer";
            gna.e("VideoComposer", j + " compose " + str);
            ola olaVar4 = new ola();
            olaVar4.m(str, FileUtils.VIDEO_FILE_START);
            int d = olaVar4.d();
            ola olaVar5 = null;
            if (d < 0) {
                olaVar4.j();
                olaVar4 = null;
            } else {
                olaVar4.l(this.e);
            }
            ola olaVar6 = new ola();
            olaVar6.m(str, "audio/");
            int d2 = olaVar6.d();
            if (d2 < 0) {
                olaVar6.j();
            } else {
                olaVar6.l(this.d);
                olaVar5 = olaVar6;
            }
            boolean z2 = false;
            if (olaVar4 == null) {
                z = true;
            } else {
                z = false;
            }
            if (olaVar5 == null) {
                z2 = true;
            }
            long j2 = 0;
            long j3 = 0;
            while (true) {
                if (z && z2) {
                    break;
                }
                if (!z2 && (z || olaVar5.e() - olaVar4.e() <= 50000)) {
                    i = this.d;
                    i3 = d2;
                    i2 = i3;
                    olaVar = olaVar5;
                } else {
                    i = this.e;
                    i2 = d2;
                    olaVar = olaVar4;
                    i3 = d;
                }
                MediaCodec.BufferInfo h = olaVar.h();
                if (h == null) {
                    i4 = d;
                    ola olaVar7 = olaVar;
                    if (olaVar7 == olaVar4) {
                        j2 = olaVar4.e();
                        d2 = i2;
                        d = i4;
                        z = true;
                    } else if (olaVar7 == olaVar5) {
                        j3 = olaVar5.e();
                        d2 = i2;
                        d = i4;
                        z2 = true;
                    } else {
                        olaVar2 = olaVar4;
                        olaVar3 = olaVar5;
                        str2 = str3;
                    }
                } else {
                    olaVar2 = olaVar4;
                    i4 = d;
                    ola olaVar8 = olaVar;
                    if (olaVar8.f() != i3) {
                        StringBuilder sb = new StringBuilder();
                        olaVar3 = olaVar5;
                        sb.append("WEIRD: got sample from track ");
                        sb.append(olaVar8.f());
                        sb.append(", expected ");
                        sb.append(i3);
                        gna.e(str3, sb.toString());
                    } else {
                        olaVar3 = olaVar5;
                    }
                    str2 = str3;
                    h.presentationTimeUs += j;
                    this.c.writeSampleData(i, olaVar8.c(), h);
                    olaVar8.a();
                }
                str3 = str2;
                d2 = i2;
                d = i4;
                olaVar4 = olaVar2;
                olaVar5 = olaVar3;
            }
            long max = j + Math.max(j2, j3) + 10000;
            fma fmaVar = this.h;
            if (fmaVar != null) {
                fmaVar.b(max);
            }
            gna.e(str3, "finish one file, ptsOffset " + max);
            if (olaVar4 != null) {
                olaVar4.j();
            }
            if (olaVar5 != null) {
                olaVar5.j();
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
                    ola olaVar = new ola();
                    try {
                        olaVar.m(str, FileUtils.VIDEO_FILE_START);
                        if (!z) {
                            MediaFormat mediaFormat = olaVar.g().a;
                            this.g = mediaFormat;
                            if (mediaFormat == null) {
                                gna.e("VideoComposer", "No video track found in " + str);
                            } else {
                                z = true;
                            }
                        }
                        if (!z2) {
                            MediaFormat mediaFormat2 = olaVar.b().a;
                            this.f = mediaFormat2;
                            if (mediaFormat2 == null) {
                                gna.e("VideoComposer", "No audio track found in " + str);
                            } else {
                                z2 = true;
                            }
                        }
                    } catch (Exception e) {
                        gna.e("VideoComposer", e.getMessage());
                        e.printStackTrace();
                    }
                    olaVar.j();
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
                    gna.e("VideoComposer", "Muxer close error. No data was written");
                }
                this.c = null;
            }
            gna.j("VideoComposer", "video join finished");
            return true;
        }
        return invokeL.booleanValue;
    }
}
