package com.baidu.tieba.util.a;

import com.baidu.tieba.log.k;
import com.baidu.tieba.util.at;
import com.baidu.tieba.util.i;
import com.baidu.tieba.util.l;
import com.baidu.tieba.util.m;
import com.baidu.tieba.util.o;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
/* loaded from: classes.dex */
public class b implements com.baidu.adp.lib.e.g {
    @Override // com.baidu.adp.lib.e.g
    public Object a(String str, com.baidu.adp.lib.e.f fVar) {
        l lVar;
        if (fVar != null && (lVar = (l) fVar.a("ImageAsyncTaskInfo")) != null) {
            com.baidu.adp.widget.ImageView.d c = com.baidu.tbadk.imageManager.d.a().c(str);
            if (c != null) {
                lVar.i = c;
            }
            return c;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.e.g
    public Object a(String str, com.baidu.adp.lib.e.e eVar) {
        com.baidu.adp.widget.ImageView.d a;
        com.baidu.adp.lib.e.f d = eVar.d();
        if (d != null && ((i) d.a("AsyncImageLoader")) != null) {
            l lVar = (l) d.a("ImageAsyncTaskInfo");
            String str2 = (String) d.a("em_group_id");
            String str3 = (String) d.a("em_sharp_text");
            Boolean bool = (Boolean) d.a("em_load_gif");
            if (lVar == null || str3 == null || bool == null) {
                return null;
            }
            if (lVar.j) {
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

    @Override // com.baidu.adp.lib.e.g
    public Object b(String str, com.baidu.adp.lib.e.e eVar) {
        i iVar;
        com.baidu.adp.lib.e.f d = eVar.d();
        if (d == null || (iVar = (i) d.a("AsyncImageLoader")) == null) {
            return null;
        }
        l lVar = (l) d.a("ImageAsyncTaskInfo");
        String str2 = (String) d.a("em_group_id");
        String str3 = (String) d.a("em_sharp_text");
        Boolean bool = (Boolean) d.a("em_load_gif");
        String str4 = (String) d.a("em_img_url");
        if (str2 == null || lVar == null || str3 == null || bool == null || str4 == null || lVar.j) {
            return null;
        }
        lVar.a = new at(iVar.a, str4);
        int i = 1;
        if (bool.booleanValue()) {
            i = 2;
        }
        lVar.a.a(iVar.f(), i);
        lVar.a.d(false);
        lVar.a.f(true);
        long currentTimeMillis = System.currentTimeMillis();
        byte[] k = lVar.a.k();
        if (k == null || !lVar.a.c()) {
            if (!lVar.j) {
                com.baidu.tieba.log.a.b(k.a(str4, String.valueOf(System.currentTimeMillis() - currentTimeMillis), String.valueOf(lVar.a.b()), lVar.a.f() + ":" + lVar.a.g(), "IS_CDN=true|download error"));
            }
            return null;
        } else if (lVar.j) {
            return null;
        } else {
            synchronized (m.a) {
                if (lVar.j) {
                    return null;
                }
                if (bool.booleanValue()) {
                    String a = com.baidu.tieba.data.emotions.d.a(str3, bool.booleanValue());
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(k);
                    com.baidu.tieba.data.emotions.d.a(str2, a, byteArrayInputStream);
                    o.a((InputStream) byteArrayInputStream);
                    lVar.i = com.baidu.tieba.data.emotions.l.a().b(str2, str3);
                    if (lVar.i == null) {
                        if (!lVar.j) {
                            com.baidu.tieba.log.a.b(k.a(str4, String.valueOf(System.currentTimeMillis() - currentTimeMillis), String.valueOf(lVar.a.b()), lVar.a.f() + ":" + lVar.a.g(), "IS_CDN=true|gif decode error"));
                        }
                        return null;
                    }
                } else {
                    com.baidu.tbadk.imageManager.d.a().c(80000);
                    lVar.e = m.a(k);
                    if (lVar.e == null) {
                        if (!lVar.j) {
                            com.baidu.tieba.log.a.b(k.a(str4, String.valueOf(System.currentTimeMillis() - currentTimeMillis), String.valueOf(lVar.a.b()), lVar.a.f() + ":" + lVar.a.g(), "IS_CDN=true|decode error"));
                        }
                        return null;
                    } else if (lVar.j) {
                        return null;
                    } else {
                        lVar.i = new com.baidu.adp.widget.ImageView.d(lVar.e, lVar.h, str4);
                        com.baidu.tieba.data.emotions.l.a().a(str3, lVar.i, false);
                    }
                }
                if (lVar.j) {
                    return null;
                }
                eVar.d(lVar);
                if (lVar.j) {
                    return null;
                }
                if (!bool.booleanValue()) {
                    ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(k);
                    try {
                        com.baidu.tieba.data.emotions.d.a(str2, com.baidu.tieba.data.emotions.d.a(str3, bool.booleanValue()), byteArrayInputStream2);
                    } catch (Throwable th) {
                    }
                    o.a((InputStream) byteArrayInputStream2);
                }
                return lVar.i;
            }
        }
    }
}
