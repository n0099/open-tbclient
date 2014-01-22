package com.baidu.tieba.util.a;

import com.baidu.tieba.data.h;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.ax;
import com.baidu.tieba.util.bx;
import com.baidu.tieba.util.i;
import com.baidu.tieba.util.l;
import com.baidu.tieba.util.n;
/* loaded from: classes.dex */
public class e extends a {
    @Override // com.baidu.tieba.util.a.a
    public Object a(String str, i iVar) {
        return com.baidu.tbadk.imageManager.d.a().b(str);
    }

    @Override // com.baidu.tieba.util.a.a
    public Object a(String str, com.baidu.adp.lib.e.e eVar, i iVar, l lVar) {
        f a;
        if (lVar.g) {
            com.baidu.tbadk.imageManager.g d = com.baidu.tbadk.imageManager.d.d(str);
            int i = lVar.d;
            String a2 = iVar.a(d.a);
            synchronized (n.a) {
                if (i == 1) {
                    a = DatabaseService.b(a2, d.b);
                } else {
                    a = i == 2 ? DatabaseService.a(a2, d.b) : null;
                }
                if (a != null) {
                    lVar.e = a.a;
                }
                if (eVar.isCancelled()) {
                    return null;
                }
                if (lVar.e == null) {
                    return null;
                }
                if (a.b == 0) {
                    String str2 = d.a;
                } else {
                    String str3 = d.a + "?t=" + a.b;
                }
                lVar.i = new com.baidu.adp.widget.ImageView.d(lVar.e, false, str);
                lVar.i.b = a.b;
                a(d.a, lVar.i);
                if (eVar.isCancelled()) {
                    return null;
                }
                if (lVar.i != null) {
                    if (bx.a().b()) {
                    }
                    if (lVar.i.e()) {
                    }
                    eVar.d(lVar);
                }
                return lVar.i;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.util.a.a
    public Object b(String str, com.baidu.adp.lib.e.e eVar, i iVar, l lVar) {
        com.baidu.tbadk.imageManager.g d = com.baidu.tbadk.imageManager.d.d(str);
        int i = lVar.d;
        String str2 = null;
        if (i == 2) {
            str2 = h.d() + d.a;
        } else if (i == 1) {
            str2 = h.o() + d.a;
        }
        lVar.a = new ax(iVar.a, str2);
        lVar.a.a(iVar.f(), 3);
        if (iVar.h != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= iVar.h.size()) {
                    break;
                }
                lVar.a.a(iVar.h.get(i3));
                i2 = i3 + 1;
            }
        }
        byte[] l = lVar.a.l();
        if (l == null || !lVar.a.d() || lVar.n) {
            return null;
        }
        String a = iVar.a(d.a);
        synchronized (n.a) {
            if (lVar.n) {
                return null;
            }
            lVar.e = n.a(l);
            if (lVar.e == null) {
                return null;
            }
            lVar.h = com.baidu.adp.lib.g.g.a(l);
            if (lVar.n) {
                return null;
            }
            int i4 = 80;
            if (i == 1) {
                i4 = h.p();
            }
            if (lVar.e.getWidth() > i4 || lVar.e.getHeight() > i4) {
                com.baidu.adp.lib.g.e.b(getClass().getName(), "doInBackground", "photo_too_big:" + String.valueOf(lVar.e.getWidth() + "*" + String.valueOf(lVar.e.getHeight())));
                com.baidu.tbadk.imageManager.d.a().c(n.a(lVar.e) * 2);
                lVar.e = n.a(lVar.e, i4);
            }
            if (lVar.n) {
                return null;
            }
            com.baidu.tbadk.imageManager.d.a().c(n.a(lVar.e) * 2);
            lVar.e = n.a(lVar.e, 7.0f);
            if (lVar.n) {
                return null;
            }
            lVar.i = new com.baidu.adp.widget.ImageView.d(lVar.e, false, str);
            lVar.i.b = d.b;
            a(d.a, lVar.i);
            if (lVar.n) {
                return null;
            }
            eVar.d(lVar);
            if (lVar.n) {
                return null;
            }
            if (i == 1) {
                DatabaseService.b(a, lVar.e, d.b);
            } else {
                if (i == 2) {
                    DatabaseService.a(a, lVar.e, d.b);
                }
                return lVar.i;
            }
            return lVar.i;
        }
    }

    public static void a(String str, com.baidu.adp.widget.ImageView.d dVar) {
        com.baidu.tbadk.imageManager.d.a().a(str, dVar);
    }
}
