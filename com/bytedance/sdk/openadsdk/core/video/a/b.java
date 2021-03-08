package com.bytedance.sdk.openadsdk.core.video.a;

import android.content.Context;
import android.media.MediaDataSource;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.openadsdk.core.video.a.a.c;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.IOException;
@RequiresApi(api = 23)
/* loaded from: classes6.dex */
public class b extends MediaDataSource {

    /* renamed from: a  reason: collision with root package name */
    private String f4522a;
    private String b;
    private com.bytedance.sdk.openadsdk.core.video.a.a.a c = null;
    private long d = -2147483648L;
    private Context e;

    public b(Context context, String str, String str2) {
        this.e = context;
        this.f4522a = str;
        if (TextUtils.isEmpty(str2)) {
            this.b = com.bytedance.sdk.openadsdk.i.g.b.a(str);
        } else {
            this.b = str2;
        }
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j, byte[] bArr, int i, int i2) throws IOException {
        b();
        int a2 = this.c.a(j, bArr, i, i2);
        u.c("SdkMediaDataSource", "readAt: position = " + j + "  buffer.length =" + bArr.length + "  offset = " + i + " size =" + a2 + "  current = " + Thread.currentThread());
        return a2;
    }

    private void b() {
        if (this.c == null) {
            this.c = new com.bytedance.sdk.openadsdk.core.video.a.a.b(this.f4522a, this.b, c.a(this.e, this.b));
        }
    }

    @Override // android.media.MediaDataSource
    public long getSize() throws IOException {
        b();
        if (this.d == -2147483648L) {
            if (this.e == null || TextUtils.isEmpty(this.f4522a)) {
                return -1L;
            }
            this.d = this.c.b();
            u.c("SdkMediaDataSource", "getSize: " + this.d);
        }
        return this.d;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        u.c("SdkMediaDataSource", "close: " + this.f4522a);
        if (this.c != null) {
            this.c.a();
        }
    }

    public boolean a() {
        b();
        return this.c.c();
    }
}
