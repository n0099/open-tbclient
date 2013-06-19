package com.baidu.tieba.media;

import com.baidu.tieba.TiebaApplication;
import com.baidu.video.download.JNIP2P;
import com.baidu.video.download.JNITaskCreateParam;
/* loaded from: classes.dex */
public class n {
    private static int a = 0;
    private static boolean b = false;
    private long c = -1;

    public void a() {
        a++;
        if (!b) {
            b = true;
            JNIP2P jnip2p = JNIP2P.getInstance();
            TiebaApplication e = TiebaApplication.e();
            jnip2p.init(e.getFilesDir().getAbsolutePath(), e);
        }
    }

    public void a(String str) {
        JNIP2P jnip2p = JNIP2P.getInstance();
        b();
        JNITaskCreateParam jNITaskCreateParam = new JNITaskCreateParam();
        jNITaskCreateParam.setUrl(str);
        jNITaskCreateParam.setFlag(4);
        jNITaskCreateParam.setFileName("p2p");
        jnip2p.create(jNITaskCreateParam);
        this.c = jNITaskCreateParam.getHandle();
        jnip2p.start(this.c);
    }

    public void b() {
        JNIP2P jnip2p = JNIP2P.getInstance();
        if (this.c != -1) {
            jnip2p.stop(this.c);
            jnip2p.delete(this.c);
            this.c = -1L;
        }
    }

    public void c() {
        b();
        a--;
        if (b && a == 0) {
            b = false;
            JNIP2P.getInstance().uninit();
        }
    }

    public long d() {
        return this.c;
    }

    public boolean b(String str) {
        return str != null && str.startsWith("bdhd://");
    }
}
