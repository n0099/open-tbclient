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
public class jeb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;
    public String b;
    public MediaMuxer c;
    public int d;
    public int e;
    public MediaFormat f;
    public MediaFormat g;
    public zeb h;

    public jeb(List<String> list, String str, zeb zebVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, zebVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        agb.e("VideoComposer", list.size() + " composer to " + str);
        this.a = list;
        this.b = str;
        this.h = zebVar;
    }

    public final long a(long j, String str) throws IOException {
        InterceptResult invokeJL;
        boolean z;
        int i;
        int i2;
        ieb iebVar;
        int i3;
        ieb iebVar2;
        int i4;
        ieb iebVar3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, str)) == null) {
            String str3 = "VideoComposer";
            agb.e("VideoComposer", j + " compose " + str);
            ieb iebVar4 = new ieb();
            iebVar4.m(str, FileUtils.VIDEO_FILE_START);
            int d = iebVar4.d();
            ieb iebVar5 = null;
            if (d < 0) {
                iebVar4.j();
                iebVar4 = null;
            } else {
                iebVar4.l(this.e);
            }
            ieb iebVar6 = new ieb();
            iebVar6.m(str, "audio/");
            int d2 = iebVar6.d();
            if (d2 < 0) {
                iebVar6.j();
            } else {
                iebVar6.l(this.d);
                iebVar5 = iebVar6;
            }
            boolean z2 = false;
            if (iebVar4 == null) {
                z = true;
            } else {
                z = false;
            }
            if (iebVar5 == null) {
                z2 = true;
            }
            long j2 = 0;
            long j3 = 0;
            while (true) {
                if (z && z2) {
                    break;
                }
                if (!z2 && (z || iebVar5.e() - iebVar4.e() <= 50000)) {
                    i = this.d;
                    i3 = d2;
                    i2 = i3;
                    iebVar = iebVar5;
                } else {
                    i = this.e;
                    i2 = d2;
                    iebVar = iebVar4;
                    i3 = d;
                }
                MediaCodec.BufferInfo h = iebVar.h();
                if (h == null) {
                    i4 = d;
                    ieb iebVar7 = iebVar;
                    if (iebVar7 == iebVar4) {
                        j2 = iebVar4.e();
                        d2 = i2;
                        d = i4;
                        z = true;
                    } else if (iebVar7 == iebVar5) {
                        j3 = iebVar5.e();
                        d2 = i2;
                        d = i4;
                        z2 = true;
                    } else {
                        iebVar2 = iebVar4;
                        iebVar3 = iebVar5;
                        str2 = str3;
                    }
                } else {
                    iebVar2 = iebVar4;
                    i4 = d;
                    ieb iebVar8 = iebVar;
                    if (iebVar8.f() != i3) {
                        StringBuilder sb = new StringBuilder();
                        iebVar3 = iebVar5;
                        sb.append("WEIRD: got sample from track ");
                        sb.append(iebVar8.f());
                        sb.append(", expected ");
                        sb.append(i3);
                        agb.e(str3, sb.toString());
                    } else {
                        iebVar3 = iebVar5;
                    }
                    str2 = str3;
                    h.presentationTimeUs += j;
                    this.c.writeSampleData(i, iebVar8.c(), h);
                    iebVar8.a();
                }
                str3 = str2;
                d2 = i2;
                d = i4;
                iebVar4 = iebVar2;
                iebVar5 = iebVar3;
            }
            long max = j + Math.max(j2, j3) + 10000;
            zeb zebVar = this.h;
            if (zebVar != null) {
                zebVar.c(max);
            }
            agb.e(str3, "finish one file, ptsOffset " + max);
            if (iebVar4 != null) {
                iebVar4.j();
            }
            if (iebVar5 != null) {
                iebVar5.j();
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
                    ieb iebVar = new ieb();
                    try {
                        iebVar.m(str, FileUtils.VIDEO_FILE_START);
                        if (!z) {
                            MediaFormat mediaFormat = iebVar.g().a;
                            this.g = mediaFormat;
                            if (mediaFormat == null) {
                                agb.e("VideoComposer", "No video track found in " + str);
                            } else {
                                z = true;
                            }
                        }
                        if (!z2) {
                            MediaFormat mediaFormat2 = iebVar.b().a;
                            this.f = mediaFormat2;
                            if (mediaFormat2 == null) {
                                agb.e("VideoComposer", "No audio track found in " + str);
                            } else {
                                z2 = true;
                            }
                        }
                    } catch (Exception e) {
                        agb.e("VideoComposer", e.getMessage());
                        e.printStackTrace();
                    }
                    iebVar.j();
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
                    agb.e("VideoComposer", "Muxer close error. No data was written");
                }
                this.c = null;
            }
            agb.j("VideoComposer", "video join finished");
            return true;
        }
        return invokeL.booleanValue;
    }
}
