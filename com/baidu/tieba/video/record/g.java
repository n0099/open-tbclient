package com.baidu.tieba.video.record;

import android.hardware.Camera;
import com.faceunity.a.d;
/* loaded from: classes2.dex */
public interface g {

    /* loaded from: classes2.dex */
    public interface a {
        void p(boolean z, String str);
    }

    void a(a aVar);

    void g(Camera camera);

    void h(Camera camera);

    void i(Camera camera);

    void j(Camera camera);

    void setOnEncoderStatusUpdateListener(d.c cVar);

    void setPreviewSize(int i, int i2);
}
