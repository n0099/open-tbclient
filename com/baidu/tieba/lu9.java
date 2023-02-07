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
public class lu9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;
    public String b;
    public MediaMuxer c;
    public int d;
    public int e;
    public MediaFormat f;
    public MediaFormat g;
    public bv9 h;

    public lu9(List<String> list, String str, bv9 bv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, bv9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        cw9.e("VideoComposer", list.size() + " composer to " + str);
        this.a = list;
        this.b = str;
        this.h = bv9Var;
    }

    public final long a(long j, String str) throws IOException {
        InterceptResult invokeJL;
        boolean z;
        int i;
        int i2;
        ku9 ku9Var;
        int i3;
        ku9 ku9Var2;
        int i4;
        ku9 ku9Var3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, str)) == null) {
            String str3 = "VideoComposer";
            cw9.e("VideoComposer", j + " compose " + str);
            ku9 ku9Var4 = new ku9();
            ku9Var4.m(str, FileUtils.VIDEO_FILE_START);
            int d = ku9Var4.d();
            ku9 ku9Var5 = null;
            if (d < 0) {
                ku9Var4.j();
                ku9Var4 = null;
            } else {
                ku9Var4.l(this.e);
            }
            ku9 ku9Var6 = new ku9();
            ku9Var6.m(str, "audio/");
            int d2 = ku9Var6.d();
            if (d2 < 0) {
                ku9Var6.j();
            } else {
                ku9Var6.l(this.d);
                ku9Var5 = ku9Var6;
            }
            boolean z2 = false;
            if (ku9Var4 == null) {
                z = true;
            } else {
                z = false;
            }
            if (ku9Var5 == null) {
                z2 = true;
            }
            long j2 = 0;
            long j3 = 0;
            while (true) {
                if (z && z2) {
                    break;
                }
                if (!z2 && (z || ku9Var5.e() - ku9Var4.e() <= 50000)) {
                    i = this.d;
                    i3 = d2;
                    i2 = i3;
                    ku9Var = ku9Var5;
                } else {
                    i = this.e;
                    i2 = d2;
                    ku9Var = ku9Var4;
                    i3 = d;
                }
                MediaCodec.BufferInfo h = ku9Var.h();
                if (h == null) {
                    i4 = d;
                    ku9 ku9Var7 = ku9Var;
                    if (ku9Var7 == ku9Var4) {
                        j2 = ku9Var4.e();
                        d2 = i2;
                        d = i4;
                        z = true;
                    } else if (ku9Var7 == ku9Var5) {
                        j3 = ku9Var5.e();
                        d2 = i2;
                        d = i4;
                        z2 = true;
                    } else {
                        ku9Var2 = ku9Var4;
                        ku9Var3 = ku9Var5;
                        str2 = str3;
                    }
                } else {
                    ku9Var2 = ku9Var4;
                    i4 = d;
                    ku9 ku9Var8 = ku9Var;
                    if (ku9Var8.f() != i3) {
                        StringBuilder sb = new StringBuilder();
                        ku9Var3 = ku9Var5;
                        sb.append("WEIRD: got sample from track ");
                        sb.append(ku9Var8.f());
                        sb.append(", expected ");
                        sb.append(i3);
                        cw9.e(str3, sb.toString());
                    } else {
                        ku9Var3 = ku9Var5;
                    }
                    str2 = str3;
                    h.presentationTimeUs += j;
                    this.c.writeSampleData(i, ku9Var8.c(), h);
                    ku9Var8.a();
                }
                str3 = str2;
                d2 = i2;
                d = i4;
                ku9Var4 = ku9Var2;
                ku9Var5 = ku9Var3;
            }
            long max = j + Math.max(j2, j3) + 10000;
            bv9 bv9Var = this.h;
            if (bv9Var != null) {
                bv9Var.b(max);
            }
            cw9.e(str3, "finish one file, ptsOffset " + max);
            if (ku9Var4 != null) {
                ku9Var4.j();
            }
            if (ku9Var5 != null) {
                ku9Var5.j();
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
                    ku9 ku9Var = new ku9();
                    try {
                        ku9Var.m(str, FileUtils.VIDEO_FILE_START);
                        if (!z) {
                            MediaFormat mediaFormat = ku9Var.g().a;
                            this.g = mediaFormat;
                            if (mediaFormat == null) {
                                cw9.e("VideoComposer", "No video track found in " + str);
                            } else {
                                z = true;
                            }
                        }
                        if (!z2) {
                            MediaFormat mediaFormat2 = ku9Var.b().a;
                            this.f = mediaFormat2;
                            if (mediaFormat2 == null) {
                                cw9.e("VideoComposer", "No audio track found in " + str);
                            } else {
                                z2 = true;
                            }
                        }
                    } catch (Exception e) {
                        cw9.e("VideoComposer", e.getMessage());
                        e.printStackTrace();
                    }
                    ku9Var.j();
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
                    cw9.e("VideoComposer", "Muxer close error. No data was written");
                }
                this.c = null;
            }
            cw9.j("VideoComposer", "video join finished");
            return true;
        }
        return invokeL.booleanValue;
    }
}
