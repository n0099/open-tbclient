package com.baidu.tieba.media;

import com.baidu.tieba.TiebaApplication;
import com.baidu.video.download.JNIP2P;
import com.baidu.video.download.JNITaskCreateParam;
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static int f1840a = 0;
    private static boolean b = false;
    private long c = -1;

    public void a() {
        f1840a++;
        if (!b) {
            b = true;
            try {
                JNIP2P jnip2p = JNIP2P.getInstance();
                TiebaApplication g = TiebaApplication.g();
                jnip2p.init(g.getFilesDir().getAbsolutePath(), g);
            } catch (Throwable th) {
                b = false;
            }
        }
    }

    public void a(String str) {
        try {
            JNIP2P jnip2p = JNIP2P.getInstance();
            b();
            JNITaskCreateParam jNITaskCreateParam = new JNITaskCreateParam();
            jNITaskCreateParam.setUrl(str);
            jNITaskCreateParam.setFlag(4);
            jNITaskCreateParam.setFileName("p2p");
            jnip2p.create(jNITaskCreateParam);
            this.c = jNITaskCreateParam.getHandle();
            jnip2p.start(this.c);
        } catch (Throwable th) {
        }
    }

    public void b() {
        try {
            JNIP2P jnip2p = JNIP2P.getInstance();
            if (this.c != -1) {
                jnip2p.stop(this.c);
                jnip2p.delete(this.c);
                this.c = -1L;
            }
        } catch (Throwable th) {
        }
    }

    public void c() {
        try {
            b();
            f1840a--;
            if (b && f1840a == 0) {
                b = false;
                JNIP2P.getInstance().uninit();
            }
        } catch (Throwable th) {
        }
    }

    public long d() {
        return this.c;
    }

    public boolean b(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("bdhd://") || str.startsWith("ed2k://");
    }
}
