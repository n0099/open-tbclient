package com.baidu.tieba.video.record;

import android.hardware.Camera;
import com.faceunity.a.d;
/* loaded from: classes17.dex */
public interface g {

    /* loaded from: classes17.dex */
    public interface a {
        void C(boolean z, String str);
    }

    void a(a aVar);

    void e(Camera camera);

    void f(Camera camera);

    void g(Camera camera);

    void h(Camera camera);

    void setOnEncoderStatusUpdateListener(d.c cVar);

    void setPreviewSize(int i, int i2);
}
