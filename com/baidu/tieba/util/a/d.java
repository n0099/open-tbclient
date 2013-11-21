package com.baidu.tieba.util.a;

import com.baidu.tieba.data.h;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.ap;
import com.baidu.tieba.util.bf;
import com.baidu.tieba.util.bg;
import com.baidu.tieba.util.i;
import com.baidu.tieba.util.l;
import com.baidu.tieba.util.m;
/* loaded from: classes.dex */
public class d extends a {
    @Override // com.baidu.tieba.util.a.a
    public Object a(String str, i iVar) {
        int i;
        com.baidu.adp.widget.ImageView.e b = com.baidu.tbadk.imageManager.d.a().b(iVar.a(str));
        if (bf.a().b()) {
            i = 1;
        } else {
            i = 2;
        }
        int i2 = 3;
        if (b != null && b.c()) {
            i2 = 4;
        }
        com.baidu.adp.lib.g.a.a().a(str, 0L, 0L, 0L, 0L, 0L, 0L, 0, 0L, iVar.d(), 1, com.baidu.tieba.d.a.a().g(), i2, i, System.currentTimeMillis());
        return b;
    }

    @Override // com.baidu.tieba.util.a.a
    public Object a(String str, com.baidu.adp.lib.e.e eVar, i iVar, l lVar) {
        int i;
        if (!lVar.g) {
            return null;
        }
        int i2 = lVar.d;
        String a2 = iVar.a(str);
        synchronized (m.f2496a) {
            if (i2 == 1) {
                lVar.e = DatabaseService.c(a2);
            } else if (i2 == 2) {
                lVar.e = DatabaseService.b(a2);
            }
            if (eVar.isCancelled()) {
                return null;
            }
            if (lVar.e == null) {
                return null;
            }
            lVar.i = new com.baidu.adp.widget.ImageView.e(lVar.e, false, str);
            com.baidu.tbadk.imageManager.d.a().a(a2, lVar.i);
            if (eVar.isCancelled()) {
                return null;
            }
            if (lVar.i != null) {
                if (bf.a().b()) {
                    i = 1;
                } else {
                    i = 2;
                }
                int i3 = 3;
                if (lVar.i.c()) {
                    i3 = 4;
                }
                com.baidu.adp.lib.g.a.a().a(str, 0L, 0L, 0L, 0L, 0L, 0L, 0, 0L, iVar.d(), 2, com.baidu.tieba.d.a.a().g(), i3, i, System.currentTimeMillis());
                eVar.d(lVar);
            }
            return lVar.i;
        }
    }

    @Override // com.baidu.tieba.util.a.a
    public Object b(String str, com.baidu.adp.lib.e.e eVar, i iVar, l lVar) {
        int i = lVar.d;
        String str2 = null;
        if (i == 2) {
            str2 = h.d() + str;
        } else if (i == 1) {
            str2 = h.l() + str;
        }
        lVar.f2495a = new ap(iVar.f2492a, str2);
        lVar.f2495a.a(iVar.d(), 3);
        if (iVar.h != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= iVar.h.size()) {
                    break;
                }
                lVar.f2495a.a(iVar.h.get(i3));
                i2 = i3 + 1;
            }
        }
        byte[] i4 = lVar.f2495a.i();
        if (i4 == null || !lVar.f2495a.c() || lVar.j) {
            return null;
        }
        String a2 = iVar.a(str);
        synchronized (m.f2496a) {
            if (lVar.j) {
                return null;
            }
            lVar.e = m.a(i4);
            if (lVar.e == null) {
                return null;
            }
            lVar.h = UtilHelper.a(i4);
            if (lVar.j) {
                return null;
            }
            int i5 = 80;
            if (i == 1) {
                i5 = h.m();
            }
            if (lVar.e.getWidth() > i5 || lVar.e.getHeight() > i5) {
                bg.a(1, getClass().getName(), "doInBackground", "photo_too_big:" + String.valueOf(lVar.e.getWidth() + "*" + String.valueOf(lVar.e.getHeight())));
                com.baidu.tbadk.imageManager.d.a().c(m.a(lVar.e) * 2);
                lVar.e = m.a(lVar.e, i5);
            }
            if (lVar.j) {
                return null;
            }
            com.baidu.tbadk.imageManager.d.a().c(m.a(lVar.e) * 2);
            lVar.e = m.a(lVar.e, 7.0f);
            if (lVar.j) {
                return null;
            }
            lVar.i = new com.baidu.adp.widget.ImageView.e(lVar.e, false, str);
            com.baidu.tbadk.imageManager.d.a().a(a2, lVar.i);
            if (lVar.j) {
                return null;
            }
            eVar.d(lVar);
            if (lVar.j) {
                return null;
            }
            if (i == 1) {
                DatabaseService.c(a2, lVar.e);
            } else {
                if (i == 2) {
                    DatabaseService.a(a2, lVar.e);
                }
                return lVar.i;
            }
            return lVar.i;
        }
    }
}
