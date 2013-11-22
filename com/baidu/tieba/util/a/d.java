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
        com.baidu.adp.widget.ImageView.e b = com.baidu.tbadk.imageManager.d.a().b(iVar.a(str));
        if (bf.a().b()) {
        }
        if (b == null || b.c()) {
        }
        return b;
    }

    @Override // com.baidu.tieba.util.a.a
    public Object a(String str, com.baidu.adp.lib.e.e eVar, i iVar, l lVar) {
        if (lVar.g) {
            int i = lVar.d;
            String a2 = iVar.a(str);
            synchronized (m.f2496a) {
                if (i == 1) {
                    lVar.e = DatabaseService.c(a2);
                } else if (i == 2) {
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
                    }
                    if (lVar.i.c()) {
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
        byte[] k = lVar.f2495a.k();
        if (k == null || !lVar.f2495a.c() || lVar.j) {
            return null;
        }
        String a2 = iVar.a(str);
        synchronized (m.f2496a) {
            if (lVar.j) {
                return null;
            }
            lVar.e = m.a(k);
            if (lVar.e == null) {
                return null;
            }
            lVar.h = UtilHelper.a(k);
            if (lVar.j) {
                return null;
            }
            int i4 = 80;
            if (i == 1) {
                i4 = h.m();
            }
            if (lVar.e.getWidth() > i4 || lVar.e.getHeight() > i4) {
                bg.a(1, getClass().getName(), "doInBackground", "photo_too_big:" + String.valueOf(lVar.e.getWidth() + "*" + String.valueOf(lVar.e.getHeight())));
                com.baidu.tbadk.imageManager.d.a().c(m.a(lVar.e) * 2);
                lVar.e = m.a(lVar.e, i4);
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
