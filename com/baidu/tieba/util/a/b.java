package com.baidu.tieba.util.a;

import com.baidu.tbadk.a.e;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.g;
import com.baidu.tieba.util.ai;
import com.baidu.tieba.util.aj;
import com.baidu.tieba.util.am;
import com.baidu.tieba.util.p;
import com.baidu.tieba.util.u;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class b extends a {
    @Override // com.baidu.tieba.util.a.a
    public Object a(String str, com.baidu.tieba.util.a aVar) {
        return e.a().c(aVar.a(str));
    }

    @Override // com.baidu.tieba.util.a.a
    public Object a(String str, com.baidu.adp.lib.c.e eVar, com.baidu.tieba.util.a aVar, com.baidu.tieba.util.d dVar) {
        if (dVar.g) {
            String f = ai.f(str);
            if (aVar.f != null) {
                f = String.valueOf(f) + aVar.f;
            }
            String a2 = aVar.a(str);
            synchronized (com.baidu.tieba.util.e.f1764a) {
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
                dVar.i = new com.baidu.adp.widget.a.b(dVar.e, dVar.h, str);
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
        int i3 = dVar.d;
        String f = ai.f(str);
        String str2 = aVar.f != null ? String.valueOf(f) + aVar.f : f;
        StringBuilder sb = new StringBuilder(100);
        sb.append(g.k);
        sb.append("src=");
        sb.append(ai.d(str));
        sb.append("&width=");
        if (aVar.b == 0) {
            i = am.a(aVar.f1744a, 105.0f);
        } else {
            i = aVar.b;
        }
        sb.append(String.valueOf(i));
        sb.append("&height=");
        if (aVar.c == 0) {
            i2 = am.a(aVar.f1744a, 105.0f);
        } else {
            i2 = aVar.c;
        }
        sb.append(String.valueOf(i2));
        sb.append("&imgtype=0");
        if (aVar.i != 0) {
            if (aVar.i == 1) {
                sb.append("&qulity=" + String.valueOf(80));
            } else {
                sb.append("&qulity=" + String.valueOf(45));
            }
        } else if (TiebaApplication.f().ap() == 1) {
            sb.append("&qulity=" + String.valueOf(80));
        } else {
            sb.append("&qulity=" + String.valueOf(45));
        }
        sb.append("&first_gif=1");
        if (aVar.e) {
            sb.append("&ispv=1");
        }
        if (aVar.g) {
            sb.append("&no_prefix=1");
        }
        dVar.f1763a = new u(aVar.f1744a, sb.toString());
        dVar.f1763a.d(true);
        if (aVar.h != null) {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= aVar.h.size()) {
                    break;
                }
                dVar.f1763a.a((BasicNameValuePair) aVar.h.get(i5));
                i4 = i5 + 1;
            }
        }
        byte[] j = dVar.f1763a.j();
        if (j == null || !dVar.f1763a.d() || dVar.j) {
            return null;
        }
        String a2 = aVar.a(str);
        synchronized (com.baidu.tieba.util.e.f1764a) {
            if (dVar.j) {
                return null;
            }
            e.a().c(g.j() + j.length);
            dVar.e = com.baidu.tieba.util.e.a(j);
            if (dVar.e == null) {
                return null;
            }
            dVar.h = am.a(j);
            if (dVar.j) {
                return null;
            }
            if (dVar.e.getWidth() > i || dVar.e.getHeight() > i2) {
                aj.a(1, getClass().getName(), "doInBackground", "Pb_image_too_big:" + String.valueOf(String.valueOf(dVar.e.getWidth()) + "*" + String.valueOf(dVar.e.getHeight())));
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
            dVar.i = new com.baidu.adp.widget.a.b(dVar.e, dVar.h, str);
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
                p.a("image", str2, j);
            }
            return dVar.i;
            return dVar.i;
        }
    }
}
