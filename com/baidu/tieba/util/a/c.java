package com.baidu.tieba.util.a;

import com.baidu.tbadk.a.e;
import com.baidu.tieba.data.g;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.aj;
import com.baidu.tieba.util.am;
import com.baidu.tieba.util.u;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class c extends a {
    @Override // com.baidu.tieba.util.a.a
    public Object a(String str, com.baidu.tieba.util.a aVar) {
        return e.a().b(aVar.a(str));
    }

    @Override // com.baidu.tieba.util.a.a
    public Object a(String str, com.baidu.adp.lib.c.e eVar, com.baidu.tieba.util.a aVar, com.baidu.tieba.util.d dVar) {
        if (dVar.g) {
            int i = dVar.d;
            String a2 = aVar.a(str);
            synchronized (com.baidu.tieba.util.e.f1762a) {
                if (i == 1) {
                    dVar.e = DatabaseService.c(a2);
                } else if (i == 2) {
                    dVar.e = DatabaseService.b(a2);
                }
                if (eVar.isCancelled()) {
                    return null;
                }
                if (dVar.e == null) {
                    return null;
                }
                dVar.i = new com.baidu.adp.widget.a.b(dVar.e, false, str);
                e.a().a(a2, dVar.i);
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
        int i = dVar.d;
        String str2 = null;
        if (i == 2) {
            str2 = String.valueOf(g.c()) + str;
        } else if (i == 1) {
            str2 = String.valueOf(g.k()) + str;
        }
        dVar.f1761a = new u(aVar.f1742a, str2);
        if (aVar.h != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= aVar.h.size()) {
                    break;
                }
                dVar.f1761a.a((BasicNameValuePair) aVar.h.get(i3));
                i2 = i3 + 1;
            }
        }
        byte[] j = dVar.f1761a.j();
        if (j == null || !dVar.f1761a.d() || dVar.j) {
            return null;
        }
        String a2 = aVar.a(str);
        synchronized (com.baidu.tieba.util.e.f1762a) {
            if (dVar.j) {
                return null;
            }
            dVar.e = com.baidu.tieba.util.e.a(j);
            if (dVar.e == null) {
                return null;
            }
            dVar.h = am.a(j);
            if (dVar.j) {
                return null;
            }
            int i4 = 80;
            if (i == 1) {
                i4 = g.l();
            }
            if (dVar.e.getWidth() > i4 || dVar.e.getHeight() > i4) {
                aj.a(1, getClass().getName(), "doInBackground", "photo_too_big:" + String.valueOf(String.valueOf(dVar.e.getWidth()) + "*" + String.valueOf(dVar.e.getHeight())));
                e.a().c(com.baidu.tieba.util.e.a(dVar.e) * 2);
                dVar.e = com.baidu.tieba.util.e.a(dVar.e, i4);
            }
            if (dVar.j) {
                return null;
            }
            e.a().c(com.baidu.tieba.util.e.a(dVar.e) * 2);
            dVar.e = com.baidu.tieba.util.e.a(dVar.e, 7.0f);
            if (dVar.j) {
                return null;
            }
            dVar.i = new com.baidu.adp.widget.a.b(dVar.e, false, str);
            e.a().a(a2, dVar.i);
            if (dVar.j) {
                return null;
            }
            eVar.d(dVar);
            if (dVar.j) {
                return null;
            }
            if (i == 1) {
                DatabaseService.b(a2, dVar.e);
            } else {
                if (i == 2) {
                    DatabaseService.a(a2, dVar.e);
                }
                return dVar.i;
            }
            return dVar.i;
        }
    }
}
