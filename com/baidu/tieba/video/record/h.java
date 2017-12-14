package com.baidu.tieba.video.record;

import android.hardware.Camera;
import com.faceunity.a.c;
/* loaded from: classes2.dex */
public interface h {

    /* loaded from: classes2.dex */
    public interface a {
        void s(boolean z, String str);
    }

    void a(a aVar);

    void g(Camera camera);

    void h(Camera camera);

    void i(Camera camera);

    void j(Camera camera);

    void setOnEncoderStatusUpdateListener(c.InterfaceC0167c interfaceC0167c);

    void setPreviewSize(int i, int i2);
}
