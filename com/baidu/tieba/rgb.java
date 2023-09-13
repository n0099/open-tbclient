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
public class rgb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;
    public String b;
    public MediaMuxer c;
    public int d;
    public int e;
    public MediaFormat f;
    public MediaFormat g;
    public hhb h;

    public rgb(List<String> list, String str, hhb hhbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, hhbVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        iib.e("VideoComposer", list.size() + " composer to " + str);
        this.a = list;
        this.b = str;
        this.h = hhbVar;
    }

    public final long a(long j, String str) throws IOException {
        InterceptResult invokeJL;
        boolean z;
        int i;
        int i2;
        qgb qgbVar;
        int i3;
        qgb qgbVar2;
        int i4;
        qgb qgbVar3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, str)) == null) {
            String str3 = "VideoComposer";
            iib.e("VideoComposer", j + " compose " + str);
            qgb qgbVar4 = new qgb();
            qgbVar4.m(str, FileUtils.VIDEO_FILE_START);
            int d = qgbVar4.d();
            qgb qgbVar5 = null;
            if (d < 0) {
                qgbVar4.j();
                qgbVar4 = null;
            } else {
                qgbVar4.l(this.e);
            }
            qgb qgbVar6 = new qgb();
            qgbVar6.m(str, "audio/");
            int d2 = qgbVar6.d();
            if (d2 < 0) {
                qgbVar6.j();
            } else {
                qgbVar6.l(this.d);
                qgbVar5 = qgbVar6;
            }
            boolean z2 = false;
            if (qgbVar4 == null) {
                z = true;
            } else {
                z = false;
            }
            if (qgbVar5 == null) {
                z2 = true;
            }
            long j2 = 0;
            long j3 = 0;
            while (true) {
                if (z && z2) {
                    break;
                }
                if (!z2 && (z || qgbVar5.e() - qgbVar4.e() <= 50000)) {
                    i = this.d;
                    i3 = d2;
                    i2 = i3;
                    qgbVar = qgbVar5;
                } else {
                    i = this.e;
                    i2 = d2;
                    qgbVar = qgbVar4;
                    i3 = d;
                }
                MediaCodec.BufferInfo h = qgbVar.h();
                if (h == null) {
                    i4 = d;
                    qgb qgbVar7 = qgbVar;
                    if (qgbVar7 == qgbVar4) {
                        j2 = qgbVar4.e();
                        d2 = i2;
                        d = i4;
                        z = true;
                    } else if (qgbVar7 == qgbVar5) {
                        j3 = qgbVar5.e();
                        d2 = i2;
                        d = i4;
                        z2 = true;
                    } else {
                        qgbVar2 = qgbVar4;
                        qgbVar3 = qgbVar5;
                        str2 = str3;
                    }
                } else {
                    qgbVar2 = qgbVar4;
                    i4 = d;
                    qgb qgbVar8 = qgbVar;
                    if (qgbVar8.f() != i3) {
                        StringBuilder sb = new StringBuilder();
                        qgbVar3 = qgbVar5;
                        sb.append("WEIRD: got sample from track ");
                        sb.append(qgbVar8.f());
                        sb.append(", expected ");
                        sb.append(i3);
                        iib.e(str3, sb.toString());
                    } else {
                        qgbVar3 = qgbVar5;
                    }
                    str2 = str3;
                    h.presentationTimeUs += j;
                    this.c.writeSampleData(i, qgbVar8.c(), h);
                    qgbVar8.a();
                }
                str3 = str2;
                d2 = i2;
                d = i4;
                qgbVar4 = qgbVar2;
                qgbVar5 = qgbVar3;
            }
            long max = j + Math.max(j2, j3) + 10000;
            hhb hhbVar = this.h;
            if (hhbVar != null) {
                hhbVar.c(max);
            }
            iib.e(str3, "finish one file, ptsOffset " + max);
            if (qgbVar4 != null) {
                qgbVar4.j();
            }
            if (qgbVar5 != null) {
                qgbVar5.j();
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
                    qgb qgbVar = new qgb();
                    try {
                        qgbVar.m(str, FileUtils.VIDEO_FILE_START);
                        if (!z) {
                            MediaFormat mediaFormat = qgbVar.g().a;
                            this.g = mediaFormat;
                            if (mediaFormat == null) {
                                iib.e("VideoComposer", "No video track found in " + str);
                            } else {
                                z = true;
                            }
                        }
                        if (!z2) {
                            MediaFormat mediaFormat2 = qgbVar.b().a;
                            this.f = mediaFormat2;
                            if (mediaFormat2 == null) {
                                iib.e("VideoComposer", "No audio track found in " + str);
                            } else {
                                z2 = true;
                            }
                        }
                    } catch (Exception e) {
                        iib.e("VideoComposer", e.getMessage());
                        e.printStackTrace();
                    }
                    qgbVar.j();
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
                    iib.e("VideoComposer", "Muxer close error. No data was written");
                }
                this.c = null;
            }
            iib.j("VideoComposer", "video join finished");
            return true;
        }
        return invokeL.booleanValue;
    }
}
