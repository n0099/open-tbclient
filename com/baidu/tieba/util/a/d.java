package com.baidu.tieba.util.a;

import com.baidu.tieba.data.h;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.ag;
import com.baidu.tieba.util.be;
/* loaded from: classes.dex */
public class d extends a {
    @Override // com.baidu.tieba.util.a.a
    public Object a(String str, com.baidu.tieba.util.a aVar) {
        return com.baidu.tbadk.imageManager.d.a().b(aVar.a(str));
    }

    @Override // com.baidu.tieba.util.a.a
    public Object a(String str, com.baidu.adp.lib.e.e eVar, com.baidu.tieba.util.a aVar, com.baidu.tieba.util.d dVar) {
        if (dVar.g) {
            int i = dVar.d;
            String a2 = aVar.a(str);
            synchronized (com.baidu.tieba.util.e.f2449a) {
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
                dVar.i = new com.baidu.adp.widget.ImageView.e(dVar.e, false, str);
                com.baidu.tbadk.imageManager.d.a().a(a2, dVar.i);
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
    public Object b(String str, com.baidu.adp.lib.e.e eVar, com.baidu.tieba.util.a aVar, com.baidu.tieba.util.d dVar) {
        int i = dVar.d;
        String str2 = null;
        if (i == 2) {
            str2 = h.d() + str;
        } else if (i == 1) {
            str2 = h.l() + str;
        }
        dVar.f2448a = new ag(aVar.f2411a, str2);
        if (aVar.h != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= aVar.h.size()) {
                    break;
                }
                dVar.f2448a.a(aVar.h.get(i3));
                i2 = i3 + 1;
            }
        }
        byte[] i4 = dVar.f2448a.i();
        if (i4 == null || !dVar.f2448a.c() || dVar.j) {
            return null;
        }
        String a2 = aVar.a(str);
        synchronized (com.baidu.tieba.util.e.f2449a) {
            if (dVar.j) {
                return null;
            }
            dVar.e = com.baidu.tieba.util.e.a(i4);
            if (dVar.e == null) {
                return null;
            }
            dVar.h = UtilHelper.a(i4);
            if (dVar.j) {
                return null;
            }
            int i5 = 80;
            if (i == 1) {
                i5 = h.m();
            }
            if (dVar.e.getWidth() > i5 || dVar.e.getHeight() > i5) {
                be.a(1, getClass().getName(), "doInBackground", "photo_too_big:" + String.valueOf(dVar.e.getWidth() + "*" + String.valueOf(dVar.e.getHeight())));
                com.baidu.tbadk.imageManager.d.a().c(com.baidu.tieba.util.e.a(dVar.e) * 2);
                dVar.e = com.baidu.tieba.util.e.a(dVar.e, i5);
            }
            if (dVar.j) {
                return null;
            }
            com.baidu.tbadk.imageManager.d.a().c(com.baidu.tieba.util.e.a(dVar.e) * 2);
            dVar.e = com.baidu.tieba.util.e.a(dVar.e, 7.0f);
            if (dVar.j) {
                return null;
            }
            dVar.i = new com.baidu.adp.widget.ImageView.e(dVar.e, false, str);
            com.baidu.tbadk.imageManager.d.a().a(a2, dVar.i);
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
