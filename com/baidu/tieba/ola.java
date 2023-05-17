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
public class ola {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;
    public String b;
    public MediaMuxer c;
    public int d;
    public int e;
    public MediaFormat f;
    public MediaFormat g;
    public ema h;

    public ola(List<String> list, String str, ema emaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, emaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        fna.e("VideoComposer", list.size() + " composer to " + str);
        this.a = list;
        this.b = str;
        this.h = emaVar;
    }

    public final long a(long j, String str) throws IOException {
        InterceptResult invokeJL;
        boolean z;
        int i;
        int i2;
        nla nlaVar;
        int i3;
        nla nlaVar2;
        int i4;
        nla nlaVar3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, str)) == null) {
            String str3 = "VideoComposer";
            fna.e("VideoComposer", j + " compose " + str);
            nla nlaVar4 = new nla();
            nlaVar4.m(str, FileUtils.VIDEO_FILE_START);
            int d = nlaVar4.d();
            nla nlaVar5 = null;
            if (d < 0) {
                nlaVar4.j();
                nlaVar4 = null;
            } else {
                nlaVar4.l(this.e);
            }
            nla nlaVar6 = new nla();
            nlaVar6.m(str, "audio/");
            int d2 = nlaVar6.d();
            if (d2 < 0) {
                nlaVar6.j();
            } else {
                nlaVar6.l(this.d);
                nlaVar5 = nlaVar6;
            }
            boolean z2 = false;
            if (nlaVar4 == null) {
                z = true;
            } else {
                z = false;
            }
            if (nlaVar5 == null) {
                z2 = true;
            }
            long j2 = 0;
            long j3 = 0;
            while (true) {
                if (z && z2) {
                    break;
                }
                if (!z2 && (z || nlaVar5.e() - nlaVar4.e() <= 50000)) {
                    i = this.d;
                    i3 = d2;
                    i2 = i3;
                    nlaVar = nlaVar5;
                } else {
                    i = this.e;
                    i2 = d2;
                    nlaVar = nlaVar4;
                    i3 = d;
                }
                MediaCodec.BufferInfo h = nlaVar.h();
                if (h == null) {
                    i4 = d;
                    nla nlaVar7 = nlaVar;
                    if (nlaVar7 == nlaVar4) {
                        j2 = nlaVar4.e();
                        d2 = i2;
                        d = i4;
                        z = true;
                    } else if (nlaVar7 == nlaVar5) {
                        j3 = nlaVar5.e();
                        d2 = i2;
                        d = i4;
                        z2 = true;
                    } else {
                        nlaVar2 = nlaVar4;
                        nlaVar3 = nlaVar5;
                        str2 = str3;
                    }
                } else {
                    nlaVar2 = nlaVar4;
                    i4 = d;
                    nla nlaVar8 = nlaVar;
                    if (nlaVar8.f() != i3) {
                        StringBuilder sb = new StringBuilder();
                        nlaVar3 = nlaVar5;
                        sb.append("WEIRD: got sample from track ");
                        sb.append(nlaVar8.f());
                        sb.append(", expected ");
                        sb.append(i3);
                        fna.e(str3, sb.toString());
                    } else {
                        nlaVar3 = nlaVar5;
                    }
                    str2 = str3;
                    h.presentationTimeUs += j;
                    this.c.writeSampleData(i, nlaVar8.c(), h);
                    nlaVar8.a();
                }
                str3 = str2;
                d2 = i2;
                d = i4;
                nlaVar4 = nlaVar2;
                nlaVar5 = nlaVar3;
            }
            long max = j + Math.max(j2, j3) + 10000;
            ema emaVar = this.h;
            if (emaVar != null) {
                emaVar.b(max);
            }
            fna.e(str3, "finish one file, ptsOffset " + max);
            if (nlaVar4 != null) {
                nlaVar4.j();
            }
            if (nlaVar5 != null) {
                nlaVar5.j();
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
                    nla nlaVar = new nla();
                    try {
                        nlaVar.m(str, FileUtils.VIDEO_FILE_START);
                        if (!z) {
                            MediaFormat mediaFormat = nlaVar.g().a;
                            this.g = mediaFormat;
                            if (mediaFormat == null) {
                                fna.e("VideoComposer", "No video track found in " + str);
                            } else {
                                z = true;
                            }
                        }
                        if (!z2) {
                            MediaFormat mediaFormat2 = nlaVar.b().a;
                            this.f = mediaFormat2;
                            if (mediaFormat2 == null) {
                                fna.e("VideoComposer", "No audio track found in " + str);
                            } else {
                                z2 = true;
                            }
                        }
                    } catch (Exception e) {
                        fna.e("VideoComposer", e.getMessage());
                        e.printStackTrace();
                    }
                    nlaVar.j();
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
                    fna.e("VideoComposer", "Muxer close error. No data was written");
                }
                this.c = null;
            }
            fna.j("VideoComposer", "video join finished");
            return true;
        }
        return invokeL.booleanValue;
    }
}
