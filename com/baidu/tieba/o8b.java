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
public class o8b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;
    public String b;
    public MediaMuxer c;
    public int d;
    public int e;
    public MediaFormat f;
    public MediaFormat g;
    public e9b h;

    public o8b(List<String> list, String str, e9b e9bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, e9bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        fab.e("VideoComposer", list.size() + " composer to " + str);
        this.a = list;
        this.b = str;
        this.h = e9bVar;
    }

    public final long a(long j, String str) throws IOException {
        InterceptResult invokeJL;
        boolean z;
        int i;
        int i2;
        n8b n8bVar;
        int i3;
        n8b n8bVar2;
        int i4;
        n8b n8bVar3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, str)) == null) {
            String str3 = "VideoComposer";
            fab.e("VideoComposer", j + " compose " + str);
            n8b n8bVar4 = new n8b();
            n8bVar4.m(str, FileUtils.VIDEO_FILE_START);
            int d = n8bVar4.d();
            n8b n8bVar5 = null;
            if (d < 0) {
                n8bVar4.j();
                n8bVar4 = null;
            } else {
                n8bVar4.l(this.e);
            }
            n8b n8bVar6 = new n8b();
            n8bVar6.m(str, "audio/");
            int d2 = n8bVar6.d();
            if (d2 < 0) {
                n8bVar6.j();
            } else {
                n8bVar6.l(this.d);
                n8bVar5 = n8bVar6;
            }
            boolean z2 = false;
            if (n8bVar4 == null) {
                z = true;
            } else {
                z = false;
            }
            if (n8bVar5 == null) {
                z2 = true;
            }
            long j2 = 0;
            long j3 = 0;
            while (true) {
                if (z && z2) {
                    break;
                }
                if (!z2 && (z || n8bVar5.e() - n8bVar4.e() <= 50000)) {
                    i = this.d;
                    i3 = d2;
                    i2 = i3;
                    n8bVar = n8bVar5;
                } else {
                    i = this.e;
                    i2 = d2;
                    n8bVar = n8bVar4;
                    i3 = d;
                }
                MediaCodec.BufferInfo h = n8bVar.h();
                if (h == null) {
                    i4 = d;
                    n8b n8bVar7 = n8bVar;
                    if (n8bVar7 == n8bVar4) {
                        j2 = n8bVar4.e();
                        d2 = i2;
                        d = i4;
                        z = true;
                    } else if (n8bVar7 == n8bVar5) {
                        j3 = n8bVar5.e();
                        d2 = i2;
                        d = i4;
                        z2 = true;
                    } else {
                        n8bVar2 = n8bVar4;
                        n8bVar3 = n8bVar5;
                        str2 = str3;
                    }
                } else {
                    n8bVar2 = n8bVar4;
                    i4 = d;
                    n8b n8bVar8 = n8bVar;
                    if (n8bVar8.f() != i3) {
                        StringBuilder sb = new StringBuilder();
                        n8bVar3 = n8bVar5;
                        sb.append("WEIRD: got sample from track ");
                        sb.append(n8bVar8.f());
                        sb.append(", expected ");
                        sb.append(i3);
                        fab.e(str3, sb.toString());
                    } else {
                        n8bVar3 = n8bVar5;
                    }
                    str2 = str3;
                    h.presentationTimeUs += j;
                    this.c.writeSampleData(i, n8bVar8.c(), h);
                    n8bVar8.a();
                }
                str3 = str2;
                d2 = i2;
                d = i4;
                n8bVar4 = n8bVar2;
                n8bVar5 = n8bVar3;
            }
            long max = j + Math.max(j2, j3) + 10000;
            e9b e9bVar = this.h;
            if (e9bVar != null) {
                e9bVar.c(max);
            }
            fab.e(str3, "finish one file, ptsOffset " + max);
            if (n8bVar4 != null) {
                n8bVar4.j();
            }
            if (n8bVar5 != null) {
                n8bVar5.j();
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
                    n8b n8bVar = new n8b();
                    try {
                        n8bVar.m(str, FileUtils.VIDEO_FILE_START);
                        if (!z) {
                            MediaFormat mediaFormat = n8bVar.g().a;
                            this.g = mediaFormat;
                            if (mediaFormat == null) {
                                fab.e("VideoComposer", "No video track found in " + str);
                            } else {
                                z = true;
                            }
                        }
                        if (!z2) {
                            MediaFormat mediaFormat2 = n8bVar.b().a;
                            this.f = mediaFormat2;
                            if (mediaFormat2 == null) {
                                fab.e("VideoComposer", "No audio track found in " + str);
                            } else {
                                z2 = true;
                            }
                        }
                    } catch (Exception e) {
                        fab.e("VideoComposer", e.getMessage());
                        e.printStackTrace();
                    }
                    n8bVar.j();
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
                    fab.e("VideoComposer", "Muxer close error. No data was written");
                }
                this.c = null;
            }
            fab.j("VideoComposer", "video join finished");
            return true;
        }
        return invokeL.booleanValue;
    }
}
