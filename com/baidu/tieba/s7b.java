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
public class s7b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;
    public String b;
    public MediaMuxer c;
    public int d;
    public int e;
    public MediaFormat f;
    public MediaFormat g;
    public i8b h;

    public s7b(List<String> list, String str, i8b i8bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, i8bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        j9b.e("VideoComposer", list.size() + " composer to " + str);
        this.a = list;
        this.b = str;
        this.h = i8bVar;
    }

    public final long a(long j, String str) throws IOException {
        InterceptResult invokeJL;
        boolean z;
        int i;
        int i2;
        r7b r7bVar;
        int i3;
        r7b r7bVar2;
        int i4;
        r7b r7bVar3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, str)) == null) {
            String str3 = "VideoComposer";
            j9b.e("VideoComposer", j + " compose " + str);
            r7b r7bVar4 = new r7b();
            r7bVar4.m(str, FileUtils.VIDEO_FILE_START);
            int d = r7bVar4.d();
            r7b r7bVar5 = null;
            if (d < 0) {
                r7bVar4.j();
                r7bVar4 = null;
            } else {
                r7bVar4.l(this.e);
            }
            r7b r7bVar6 = new r7b();
            r7bVar6.m(str, "audio/");
            int d2 = r7bVar6.d();
            if (d2 < 0) {
                r7bVar6.j();
            } else {
                r7bVar6.l(this.d);
                r7bVar5 = r7bVar6;
            }
            boolean z2 = false;
            if (r7bVar4 == null) {
                z = true;
            } else {
                z = false;
            }
            if (r7bVar5 == null) {
                z2 = true;
            }
            long j2 = 0;
            long j3 = 0;
            while (true) {
                if (z && z2) {
                    break;
                }
                if (!z2 && (z || r7bVar5.e() - r7bVar4.e() <= 50000)) {
                    i = this.d;
                    i3 = d2;
                    i2 = i3;
                    r7bVar = r7bVar5;
                } else {
                    i = this.e;
                    i2 = d2;
                    r7bVar = r7bVar4;
                    i3 = d;
                }
                MediaCodec.BufferInfo h = r7bVar.h();
                if (h == null) {
                    i4 = d;
                    r7b r7bVar7 = r7bVar;
                    if (r7bVar7 == r7bVar4) {
                        j2 = r7bVar4.e();
                        d2 = i2;
                        d = i4;
                        z = true;
                    } else if (r7bVar7 == r7bVar5) {
                        j3 = r7bVar5.e();
                        d2 = i2;
                        d = i4;
                        z2 = true;
                    } else {
                        r7bVar2 = r7bVar4;
                        r7bVar3 = r7bVar5;
                        str2 = str3;
                    }
                } else {
                    r7bVar2 = r7bVar4;
                    i4 = d;
                    r7b r7bVar8 = r7bVar;
                    if (r7bVar8.f() != i3) {
                        StringBuilder sb = new StringBuilder();
                        r7bVar3 = r7bVar5;
                        sb.append("WEIRD: got sample from track ");
                        sb.append(r7bVar8.f());
                        sb.append(", expected ");
                        sb.append(i3);
                        j9b.e(str3, sb.toString());
                    } else {
                        r7bVar3 = r7bVar5;
                    }
                    str2 = str3;
                    h.presentationTimeUs += j;
                    this.c.writeSampleData(i, r7bVar8.c(), h);
                    r7bVar8.a();
                }
                str3 = str2;
                d2 = i2;
                d = i4;
                r7bVar4 = r7bVar2;
                r7bVar5 = r7bVar3;
            }
            long max = j + Math.max(j2, j3) + 10000;
            i8b i8bVar = this.h;
            if (i8bVar != null) {
                i8bVar.c(max);
            }
            j9b.e(str3, "finish one file, ptsOffset " + max);
            if (r7bVar4 != null) {
                r7bVar4.j();
            }
            if (r7bVar5 != null) {
                r7bVar5.j();
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
                    r7b r7bVar = new r7b();
                    try {
                        r7bVar.m(str, FileUtils.VIDEO_FILE_START);
                        if (!z) {
                            MediaFormat mediaFormat = r7bVar.g().a;
                            this.g = mediaFormat;
                            if (mediaFormat == null) {
                                j9b.e("VideoComposer", "No video track found in " + str);
                            } else {
                                z = true;
                            }
                        }
                        if (!z2) {
                            MediaFormat mediaFormat2 = r7bVar.b().a;
                            this.f = mediaFormat2;
                            if (mediaFormat2 == null) {
                                j9b.e("VideoComposer", "No audio track found in " + str);
                            } else {
                                z2 = true;
                            }
                        }
                    } catch (Exception e) {
                        j9b.e("VideoComposer", e.getMessage());
                        e.printStackTrace();
                    }
                    r7bVar.j();
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
                    j9b.e("VideoComposer", "Muxer close error. No data was written");
                }
                this.c = null;
            }
            j9b.j("VideoComposer", "video join finished");
            return true;
        }
        return invokeL.booleanValue;
    }
}
