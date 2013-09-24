package com.baidu.tieba.util.a;

import com.baidu.tbadk.a.e;
import com.baidu.tieba.data.g;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.at;
import com.baidu.tieba.util.au;
import com.baidu.tieba.util.av;
import com.baidu.tieba.util.p;
import com.baidu.tieba.util.z;
/* loaded from: classes.dex */
public class b extends a {
    @Override // com.baidu.tieba.util.a.a
    public Object a(String str, com.baidu.tieba.util.a aVar) {
        return e.a().c(aVar.a(str));
    }

    @Override // com.baidu.tieba.util.a.a
    public Object a(String str, com.baidu.adp.lib.c.e eVar, com.baidu.tieba.util.a aVar, com.baidu.tieba.util.d dVar) {
        if (dVar.g) {
            String f = at.f(str);
            if (aVar.f != null) {
                f = String.valueOf(f) + aVar.f;
            }
            String a2 = aVar.a(str);
            synchronized (com.baidu.tieba.util.e.f1919a) {
                if (f != null) {
                    int a3 = (int) p.a("image", f);
                    if (a3 > 0) {
                        e.a().c(a3);
                        dVar.e = p.c("image", f);
                        if (dVar.e != null) {
                            dVar.h = p.b("image", f);
                        }
                    }
                }
                if (eVar.isCancelled()) {
                    return null;
                }
                if (dVar.e == null) {
                    return null;
                }
                dVar.i = new com.baidu.adp.widget.a.c(dVar.e, dVar.h, str);
                e.a().b(a2, dVar.i);
                if (eVar.isCancelled()) {
                    return null;
                }
                if (dVar.i != null) {
                    eVar.d(dVar);
                }
                return dVar.i;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.util.a.a
    public Object b(String str, com.baidu.adp.lib.c.e eVar, com.baidu.tieba.util.a aVar, com.baidu.tieba.util.d dVar) {
        int i;
        int i2;
        String sb;
        if (str == null || str.length() == 0) {
            return null;
        }
        int i3 = dVar.d;
        String f = at.f(str);
        String str2 = aVar.f != null ? String.valueOf(f) + aVar.f : f;
        if (aVar.b == 0) {
            i = UtilHelper.a(aVar.f1889a, 105.0f);
        } else {
            i = aVar.b;
        }
        if (aVar.c == 0) {
            i2 = UtilHelper.a(aVar.f1889a, 105.0f);
        } else {
            i2 = aVar.c;
        }
        boolean c = aVar.c();
        if (c) {
            sb = str;
        } else {
            StringBuilder sb2 = new StringBuilder(100);
            sb2.append(g.k);
            sb2.append("src=");
            sb2.append(at.d(str));
            sb2.append("&width=");
            sb2.append(String.valueOf(i));
            sb2.append("&height=");
            sb2.append(String.valueOf(i2));
            sb2.append("&imgtype=0");
            sb2.append("&qulity=" + au.a().d());
            sb2.append("&first_gif=1");
            if (aVar.e) {
                sb2.append("&ispv=1");
            }
            if (aVar.g) {
                sb2.append("&no_prefix=1");
            }
            sb = sb2.toString();
        }
        dVar.f1918a = new z(aVar.f1889a, sb);
        if (c) {
            dVar.f1918a.d(false);
        } else {
            dVar.f1918a.d(true);
        }
        dVar.f1918a.f(c);
        if (aVar.h != null && !c) {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= aVar.h.size()) {
                    break;
                }
                dVar.f1918a.a(aVar.h.get(i5));
                i4 = i5 + 1;
            }
        }
        byte[] i6 = dVar.f1918a.i();
        if (i6 == null || !dVar.f1918a.c() || dVar.j) {
            return null;
        }
        String a2 = aVar.a(str);
        synchronized (com.baidu.tieba.util.e.f1919a) {
            if (dVar.j) {
                return null;
            }
            e.a().c(g.k() + i6.length);
            dVar.e = com.baidu.tieba.util.e.a(i6);
            if (dVar.e == null) {
                return null;
            }
            dVar.h = dVar.f1918a.n() || UtilHelper.a(i6);
            if (dVar.j) {
                return null;
            }
            if (dVar.e.getWidth() > i || dVar.e.getHeight() > i2) {
                av.a(1, getClass().getName(), "doInBackground", "Pb_image_too_big:" + String.valueOf(String.valueOf(dVar.e.getWidth()) + "*" + String.valueOf(dVar.e.getHeight())));
                e.a().c(com.baidu.tieba.util.e.a(dVar.e) * 2);
                dVar.e = com.baidu.tieba.util.e.a(dVar.e, i, i2);
            }
            if (dVar.j) {
                return null;
            }
            if (i3 == 4) {
                e.a().c(com.baidu.tieba.util.e.a(dVar.e) * 2);
                dVar.e = com.baidu.tieba.util.e.a(dVar.e, 7.0f);
            }
            if (dVar.j) {
                return null;
            }
            dVar.i = new com.baidu.adp.widget.a.c(dVar.e, dVar.h, str);
            e.a().b(a2, dVar.i);
            if (dVar.j) {
                return null;
            }
            eVar.d(dVar);
            if (dVar.j) {
                return null;
            }
            if (i3 == 4) {
                if (str2 != null) {
                    p.a("image", str2, com.baidu.tieba.util.e.c(dVar.e, 80));
                }
                return dVar.i;
            }
            if (str2 != null) {
                p.a("image", str2, i6);
            }
            return dVar.i;
            return dVar.i;
        }
    }
}
