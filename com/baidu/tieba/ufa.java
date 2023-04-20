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
public class ufa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;
    public String b;
    public MediaMuxer c;
    public int d;
    public int e;
    public MediaFormat f;
    public MediaFormat g;
    public kga h;

    public ufa(List<String> list, String str, kga kgaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, kgaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        lha.e("VideoComposer", list.size() + " composer to " + str);
        this.a = list;
        this.b = str;
        this.h = kgaVar;
    }

    public final long a(long j, String str) throws IOException {
        InterceptResult invokeJL;
        boolean z;
        int i;
        int i2;
        tfa tfaVar;
        int i3;
        tfa tfaVar2;
        int i4;
        tfa tfaVar3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, str)) == null) {
            String str3 = "VideoComposer";
            lha.e("VideoComposer", j + " compose " + str);
            tfa tfaVar4 = new tfa();
            tfaVar4.m(str, FileUtils.VIDEO_FILE_START);
            int d = tfaVar4.d();
            tfa tfaVar5 = null;
            if (d < 0) {
                tfaVar4.j();
                tfaVar4 = null;
            } else {
                tfaVar4.l(this.e);
            }
            tfa tfaVar6 = new tfa();
            tfaVar6.m(str, "audio/");
            int d2 = tfaVar6.d();
            if (d2 < 0) {
                tfaVar6.j();
            } else {
                tfaVar6.l(this.d);
                tfaVar5 = tfaVar6;
            }
            boolean z2 = false;
            if (tfaVar4 == null) {
                z = true;
            } else {
                z = false;
            }
            if (tfaVar5 == null) {
                z2 = true;
            }
            long j2 = 0;
            long j3 = 0;
            while (true) {
                if (z && z2) {
                    break;
                }
                if (!z2 && (z || tfaVar5.e() - tfaVar4.e() <= 50000)) {
                    i = this.d;
                    i3 = d2;
                    i2 = i3;
                    tfaVar = tfaVar5;
                } else {
                    i = this.e;
                    i2 = d2;
                    tfaVar = tfaVar4;
                    i3 = d;
                }
                MediaCodec.BufferInfo h = tfaVar.h();
                if (h == null) {
                    i4 = d;
                    tfa tfaVar7 = tfaVar;
                    if (tfaVar7 == tfaVar4) {
                        j2 = tfaVar4.e();
                        d2 = i2;
                        d = i4;
                        z = true;
                    } else if (tfaVar7 == tfaVar5) {
                        j3 = tfaVar5.e();
                        d2 = i2;
                        d = i4;
                        z2 = true;
                    } else {
                        tfaVar2 = tfaVar4;
                        tfaVar3 = tfaVar5;
                        str2 = str3;
                    }
                } else {
                    tfaVar2 = tfaVar4;
                    i4 = d;
                    tfa tfaVar8 = tfaVar;
                    if (tfaVar8.f() != i3) {
                        StringBuilder sb = new StringBuilder();
                        tfaVar3 = tfaVar5;
                        sb.append("WEIRD: got sample from track ");
                        sb.append(tfaVar8.f());
                        sb.append(", expected ");
                        sb.append(i3);
                        lha.e(str3, sb.toString());
                    } else {
                        tfaVar3 = tfaVar5;
                    }
                    str2 = str3;
                    h.presentationTimeUs += j;
                    this.c.writeSampleData(i, tfaVar8.c(), h);
                    tfaVar8.a();
                }
                str3 = str2;
                d2 = i2;
                d = i4;
                tfaVar4 = tfaVar2;
                tfaVar5 = tfaVar3;
            }
            long max = j + Math.max(j2, j3) + 10000;
            kga kgaVar = this.h;
            if (kgaVar != null) {
                kgaVar.b(max);
            }
            lha.e(str3, "finish one file, ptsOffset " + max);
            if (tfaVar4 != null) {
                tfaVar4.j();
            }
            if (tfaVar5 != null) {
                tfaVar5.j();
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
                    tfa tfaVar = new tfa();
                    try {
                        tfaVar.m(str, FileUtils.VIDEO_FILE_START);
                        if (!z) {
                            MediaFormat mediaFormat = tfaVar.g().a;
                            this.g = mediaFormat;
                            if (mediaFormat == null) {
                                lha.e("VideoComposer", "No video track found in " + str);
                            } else {
                                z = true;
                            }
                        }
                        if (!z2) {
                            MediaFormat mediaFormat2 = tfaVar.b().a;
                            this.f = mediaFormat2;
                            if (mediaFormat2 == null) {
                                lha.e("VideoComposer", "No audio track found in " + str);
                            } else {
                                z2 = true;
                            }
                        }
                    } catch (Exception e) {
                        lha.e("VideoComposer", e.getMessage());
                        e.printStackTrace();
                    }
                    tfaVar.j();
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
                    lha.e("VideoComposer", "Muxer close error. No data was written");
                }
                this.c = null;
            }
            lha.j("VideoComposer", "video join finished");
            return true;
        }
        return invokeL.booleanValue;
    }
}
