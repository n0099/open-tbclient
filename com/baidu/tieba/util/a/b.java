package com.baidu.tieba.util.a;

import com.baidu.adp.lib.e.h;
import com.baidu.adp.lib.e.i;
import com.baidu.tieba.log.j;
import com.baidu.tieba.util.ba;
import com.baidu.tieba.util.l;
import com.baidu.tieba.util.n;
import com.baidu.tieba.util.r;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
/* loaded from: classes.dex */
public class b implements i {
    @Override // com.baidu.adp.lib.e.i
    public Object a(String str, h hVar) {
        l lVar;
        if (hVar != null && (lVar = (l) hVar.a("ImageAsyncTaskInfo")) != null) {
            com.baidu.adp.widget.ImageView.b c = com.baidu.tbadk.imageManager.e.a().c(str);
            if (c != null) {
                lVar.i = c;
            }
            return c;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.e.i
    public Object a(String str, com.baidu.adp.lib.e.e eVar) {
        com.baidu.adp.widget.ImageView.b a;
        h e = eVar.e();
        if (e != null && ((com.baidu.tieba.util.i) e.a("AsyncImageLoader")) != null) {
            l lVar = (l) e.a("ImageAsyncTaskInfo");
            String str2 = (String) e.a("em_group_id");
            String str3 = (String) e.a("em_sharp_text");
            Boolean bool = (Boolean) e.a("em_load_gif");
            if (lVar == null || str3 == null || bool == null) {
                return null;
            }
            if (lVar.n) {
                return null;
            }
            if (bool.booleanValue()) {
                a = com.baidu.tieba.data.emotions.l.a().b(str2, str3);
            } else {
                a = com.baidu.tieba.data.emotions.l.a().a(str2, str3);
            }
            lVar.i = a;
            return a;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.e.i
    public Object b(String str, com.baidu.adp.lib.e.e eVar) {
        com.baidu.tieba.util.i iVar;
        h e = eVar.e();
        if (e == null || (iVar = (com.baidu.tieba.util.i) e.a("AsyncImageLoader")) == null) {
            return null;
        }
        l lVar = (l) e.a("ImageAsyncTaskInfo");
        String str2 = (String) e.a("em_group_id");
        String str3 = (String) e.a("em_sharp_text");
        Boolean bool = (Boolean) e.a("em_load_gif");
        String str4 = (String) e.a("em_img_url");
        if (str2 == null || lVar == null || str3 == null || bool == null || str4 == null || lVar.n) {
            return null;
        }
        lVar.a = new ba(iVar.a, str4);
        int i = 1;
        if (bool.booleanValue()) {
            i = 2;
        }
        lVar.a.a(iVar.f(), i);
        lVar.a.d(false);
        lVar.a.f(true);
        long currentTimeMillis = System.currentTimeMillis();
        byte[] l = lVar.a.l();
        if (l == null || !lVar.a.d()) {
            if (!lVar.n) {
                com.baidu.tieba.log.a.b(j.a(str4, String.valueOf(System.currentTimeMillis() - currentTimeMillis), String.valueOf(lVar.a.c()), String.valueOf(lVar.a.g()) + ":" + lVar.a.h(), "IS_CDN=true|download error"));
            }
            return null;
        } else if (lVar.n) {
            return null;
        } else {
            synchronized (n.a) {
                if (lVar.n) {
                    return null;
                }
                if (bool.booleanValue()) {
                    String a = com.baidu.tieba.data.emotions.d.a(str3, bool.booleanValue());
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(l);
                    com.baidu.tieba.data.emotions.d.a(str2, a, byteArrayInputStream);
                    r.a((InputStream) byteArrayInputStream);
                    lVar.i = com.baidu.tieba.data.emotions.l.a().b(str2, str3);
                    if (lVar.i == null) {
                        if (!lVar.n) {
                            com.baidu.tieba.log.a.b(j.a(str4, String.valueOf(System.currentTimeMillis() - currentTimeMillis), String.valueOf(lVar.a.c()), String.valueOf(lVar.a.g()) + ":" + lVar.a.h(), "IS_CDN=true|gif decode error"));
                        }
                        return null;
                    }
                } else {
                    com.baidu.tbadk.imageManager.e.a().c(80000);
                    lVar.e = n.a(l);
                    if (lVar.e == null) {
                        if (!lVar.n) {
                            com.baidu.tieba.log.a.b(j.a(str4, String.valueOf(System.currentTimeMillis() - currentTimeMillis), String.valueOf(lVar.a.c()), String.valueOf(lVar.a.g()) + ":" + lVar.a.h(), "IS_CDN=true|decode error"));
                        }
                        return null;
                    } else if (lVar.n) {
                        return null;
                    } else {
                        lVar.i = new com.baidu.adp.widget.ImageView.b(lVar.e, lVar.h, str4);
                        com.baidu.tieba.data.emotions.l.a().a(str3, lVar.i, false);
                    }
                }
                if (lVar.n) {
                    return null;
                }
                eVar.d(lVar);
                if (lVar.n) {
                    return null;
                }
                if (!bool.booleanValue()) {
                    ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(l);
                    try {
                        com.baidu.tieba.data.emotions.d.a(str2, com.baidu.tieba.data.emotions.d.a(str3, bool.booleanValue()), byteArrayInputStream2);
                        r.a((InputStream) byteArrayInputStream2);
                    } catch (Throwable th) {
                        r.a((InputStream) byteArrayInputStream2);
                    }
                }
                return lVar.i;
            }
        }
    }
}
