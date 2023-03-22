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
public class v5a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;
    public String b;
    public MediaMuxer c;
    public int d;
    public int e;
    public MediaFormat f;
    public MediaFormat g;
    public l6a h;

    public v5a(List<String> list, String str, l6a l6aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, l6aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        m7a.e("VideoComposer", list.size() + " composer to " + str);
        this.a = list;
        this.b = str;
        this.h = l6aVar;
    }

    public final long a(long j, String str) throws IOException {
        InterceptResult invokeJL;
        boolean z;
        int i;
        int i2;
        u5a u5aVar;
        int i3;
        u5a u5aVar2;
        int i4;
        u5a u5aVar3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, str)) == null) {
            String str3 = "VideoComposer";
            m7a.e("VideoComposer", j + " compose " + str);
            u5a u5aVar4 = new u5a();
            u5aVar4.m(str, FileUtils.VIDEO_FILE_START);
            int d = u5aVar4.d();
            u5a u5aVar5 = null;
            if (d < 0) {
                u5aVar4.j();
                u5aVar4 = null;
            } else {
                u5aVar4.l(this.e);
            }
            u5a u5aVar6 = new u5a();
            u5aVar6.m(str, "audio/");
            int d2 = u5aVar6.d();
            if (d2 < 0) {
                u5aVar6.j();
            } else {
                u5aVar6.l(this.d);
                u5aVar5 = u5aVar6;
            }
            boolean z2 = false;
            if (u5aVar4 == null) {
                z = true;
            } else {
                z = false;
            }
            if (u5aVar5 == null) {
                z2 = true;
            }
            long j2 = 0;
            long j3 = 0;
            while (true) {
                if (z && z2) {
                    break;
                }
                if (!z2 && (z || u5aVar5.e() - u5aVar4.e() <= 50000)) {
                    i = this.d;
                    i3 = d2;
                    i2 = i3;
                    u5aVar = u5aVar5;
                } else {
                    i = this.e;
                    i2 = d2;
                    u5aVar = u5aVar4;
                    i3 = d;
                }
                MediaCodec.BufferInfo h = u5aVar.h();
                if (h == null) {
                    i4 = d;
                    u5a u5aVar7 = u5aVar;
                    if (u5aVar7 == u5aVar4) {
                        j2 = u5aVar4.e();
                        d2 = i2;
                        d = i4;
                        z = true;
                    } else if (u5aVar7 == u5aVar5) {
                        j3 = u5aVar5.e();
                        d2 = i2;
                        d = i4;
                        z2 = true;
                    } else {
                        u5aVar2 = u5aVar4;
                        u5aVar3 = u5aVar5;
                        str2 = str3;
                    }
                } else {
                    u5aVar2 = u5aVar4;
                    i4 = d;
                    u5a u5aVar8 = u5aVar;
                    if (u5aVar8.f() != i3) {
                        StringBuilder sb = new StringBuilder();
                        u5aVar3 = u5aVar5;
                        sb.append("WEIRD: got sample from track ");
                        sb.append(u5aVar8.f());
                        sb.append(", expected ");
                        sb.append(i3);
                        m7a.e(str3, sb.toString());
                    } else {
                        u5aVar3 = u5aVar5;
                    }
                    str2 = str3;
                    h.presentationTimeUs += j;
                    this.c.writeSampleData(i, u5aVar8.c(), h);
                    u5aVar8.a();
                }
                str3 = str2;
                d2 = i2;
                d = i4;
                u5aVar4 = u5aVar2;
                u5aVar5 = u5aVar3;
            }
            long max = j + Math.max(j2, j3) + 10000;
            l6a l6aVar = this.h;
            if (l6aVar != null) {
                l6aVar.b(max);
            }
            m7a.e(str3, "finish one file, ptsOffset " + max);
            if (u5aVar4 != null) {
                u5aVar4.j();
            }
            if (u5aVar5 != null) {
                u5aVar5.j();
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
                    u5a u5aVar = new u5a();
                    try {
                        u5aVar.m(str, FileUtils.VIDEO_FILE_START);
                        if (!z) {
                            MediaFormat mediaFormat = u5aVar.g().a;
                            this.g = mediaFormat;
                            if (mediaFormat == null) {
                                m7a.e("VideoComposer", "No video track found in " + str);
                            } else {
                                z = true;
                            }
                        }
                        if (!z2) {
                            MediaFormat mediaFormat2 = u5aVar.b().a;
                            this.f = mediaFormat2;
                            if (mediaFormat2 == null) {
                                m7a.e("VideoComposer", "No audio track found in " + str);
                            } else {
                                z2 = true;
                            }
                        }
                    } catch (Exception e) {
                        m7a.e("VideoComposer", e.getMessage());
                        e.printStackTrace();
                    }
                    u5aVar.j();
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
                    m7a.e("VideoComposer", "Muxer close error. No data was written");
                }
                this.c = null;
            }
            m7a.j("VideoComposer", "video join finished");
            return true;
        }
        return invokeL.booleanValue;
    }
}
