package com.baidu.tieba.widget.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import com.baidu.tieba.data.i;
import com.baidu.tieba.util.af;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class f {
    public static final String f = af.a + "/" + i.k() + "/share/SHARED_IMAGE";
    public String a = null;
    public String b = null;
    public String c = null;
    public Uri d = null;
    public Location e = null;
    private WeakReference<Bitmap> g = null;

    public final Bitmap a() {
        Bitmap bitmap;
        if (this.g == null || (bitmap = this.g.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public final void a(Bitmap bitmap) {
        this.g = new WeakReference<>(bitmap);
    }
}
