package com.baidu.tieba;

import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.view.View;
/* loaded from: classes7.dex */
public interface ss4 {

    /* loaded from: classes7.dex */
    public interface a {
        void a(b bVar);

        void b(b bVar, int i, int i2);

        void c(b bVar, int i, int i2, int i3);
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(MediaPlayer mediaPlayer);

        ss4 b();
    }

    void a(a aVar);

    void b(a aVar);

    Bitmap getBitmap();

    View getView();

    void release();

    void setAspectRatio(int i);

    void setVideoSize(int i, int i2);
}
