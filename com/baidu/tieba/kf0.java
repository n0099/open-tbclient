package com.baidu.tieba;

import android.content.Context;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public interface kf0 {
    void a(Context context);

    long b();

    void c(int i, int i2);

    @Deprecated
    int d(int i, int i2, Map<String, float[]> map);

    int e(MediaTrack mediaTrack, int i, Map<String, float[]> map);

    void f(List<MediaTrack> list, Map<String, ShaderConfig> map);

    int g(MediaTrack mediaTrack, int i, int i2, Map<String, float[]> map);

    void h(int i, long j);

    int i(MediaSegment mediaSegment, int i, Map<String, float[]> map);

    int j(MediaTrack mediaTrack, int i, Map<String, float[]> map);

    int k(int i, float[] fArr, float[] fArr2, int i2, int i3, float f);

    List<MediaTrack> l();

    @Deprecated
    int m(int i, float[] fArr, float[] fArr2, int i2, int i3, int i4, Map<String, float[]> map);

    void n(List<MediaTrack> list);

    void release();
}
