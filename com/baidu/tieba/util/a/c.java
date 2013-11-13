package com.baidu.tieba.util.a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.lib.cache.s;
import com.baidu.tieba.data.h;
import com.baidu.tieba.im.chat.LocalViewSize;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.af;
import com.baidu.tieba.util.ap;
import com.baidu.tieba.util.be;
import com.baidu.tieba.util.bf;
import com.baidu.tieba.util.bg;
import com.baidu.tieba.util.i;
import com.baidu.tieba.util.l;
import com.baidu.tieba.util.m;
/* loaded from: classes.dex */
public class c extends a {
    @Override // com.baidu.tieba.util.a.a
    public Object a(String str, i iVar) {
        int i;
        com.baidu.adp.widget.ImageView.e c = com.baidu.tbadk.imageManager.d.a().c(iVar.a(str));
        if (bf.a().b()) {
            i = 1;
        } else {
            i = 2;
        }
        int i2 = 1;
        if (c != null && c.c()) {
            i2 = 2;
        }
        com.baidu.adp.lib.g.a.a().a(str, 0L, 0L, 0L, 0L, 0L, 0L, 0, 0L, iVar.d(), 1, com.baidu.tieba.d.a.a().g(), i2, i, System.currentTimeMillis());
        return c;
    }

    @Override // com.baidu.tieba.util.a.a
    public Object a(String str, com.baidu.adp.lib.e.e eVar, i iVar, l lVar) {
        int i;
        if (!lVar.g) {
            return null;
        }
        String f = be.f(str);
        String str2 = iVar.f != null ? f + iVar.f : f;
        String a2 = iVar.a(str);
        synchronized (m.f2513a) {
            if (str2 != null) {
                if (lVar.d == 5) {
                    lVar.e = DatabaseService.d(a2);
                } else {
                    int a3 = (int) af.a("image", str2);
                    if (a3 > 0) {
                        com.baidu.tbadk.imageManager.d.a().c(a3);
                        lVar.e = af.c("image", str2);
                        if (lVar.e != null) {
                            s<String> q = com.baidu.tieba.b.a.a().q();
                            if (q != null && "gif".equals(q.a(a2))) {
                                lVar.h = true;
                            }
                            if (!lVar.h) {
                                lVar.h = af.b("image", str2);
                            }
                        }
                    }
                }
            }
            if (eVar.isCancelled()) {
                return null;
            }
            if (lVar.e == null) {
                return null;
            }
            lVar.i = new com.baidu.adp.widget.ImageView.e(lVar.e, lVar.h, str);
            com.baidu.tbadk.imageManager.d.a().b(a2, lVar.i);
            if (eVar.isCancelled()) {
                return null;
            }
            if (lVar.i != null) {
                if (bf.a().b()) {
                    i = 1;
                } else {
                    i = 2;
                }
                int i2 = 1;
                if (lVar.i.c()) {
                    i2 = 2;
                }
                com.baidu.adp.lib.g.a.a().a(str, 0L, 0L, 0L, 0L, 0L, 0L, 0, 0L, iVar.d(), 2, com.baidu.tieba.d.a.a().g(), i2, i, System.currentTimeMillis());
                eVar.d(lVar);
            }
            return lVar.i;
        }
    }

    @Override // com.baidu.tieba.util.a.a
    public Object b(String str, com.baidu.adp.lib.e.e eVar, i iVar, l lVar) {
        int i;
        int i2;
        String sb;
        int i3;
        Bitmap a2;
        if (str == null || str.length() == 0) {
            return null;
        }
        int i4 = lVar.d;
        String f = be.f(str);
        String str2 = iVar.f != null ? f + iVar.f : f;
        if (iVar.b == 0) {
            i = UtilHelper.a(iVar.f2509a, 105.0f);
        } else {
            i = iVar.b;
        }
        if (iVar.c == 0) {
            i2 = UtilHelper.a(iVar.f2509a, 105.0f);
        } else {
            i2 = iVar.c;
        }
        boolean c = iVar.c();
        if (c) {
            sb = str;
        } else {
            StringBuilder sb2 = new StringBuilder(100);
            sb2.append(h.l);
            sb2.append("src=");
            sb2.append(be.d(str));
            sb2.append("&width=");
            sb2.append(String.valueOf(i));
            sb2.append("&height=");
            sb2.append(String.valueOf(i2));
            sb2.append("&imgtype=0");
            sb2.append("&qulity=" + bf.a().d());
            sb2.append("&first_gif=1");
            if (iVar.e) {
                sb2.append("&ispv=1");
            }
            if (iVar.g) {
                sb2.append("&no_prefix=1");
            }
            sb = sb2.toString();
        }
        lVar.f2512a = new ap(iVar.f2509a, sb);
        if (!sb.contains(".gif")) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        lVar.f2512a.a(iVar.d(), i3);
        if (c) {
            lVar.f2512a.d(false);
        } else {
            lVar.f2512a.d(true);
        }
        lVar.f2512a.f(c);
        if (iVar.h != null && !c) {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= iVar.h.size()) {
                    break;
                }
                lVar.f2512a.a(iVar.h.get(i6));
                i5 = i6 + 1;
            }
        }
        byte[] i7 = lVar.f2512a.i();
        if (i7 == null || !lVar.f2512a.c() || lVar.j) {
            return null;
        }
        String a3 = iVar.a(str);
        synchronized (m.f2513a) {
            if (lVar.j) {
                return null;
            }
            com.baidu.tbadk.imageManager.d.a().c(h.k() + i7.length);
            lVar.e = m.a(i7);
            if (lVar.e == null) {
                return null;
            }
            lVar.h = lVar.f2512a.n() || UtilHelper.a(i7);
            if (lVar.j) {
                return null;
            }
            if (lVar.e.getWidth() > i || lVar.e.getHeight() > i2) {
                bg.a(1, getClass().getName(), "doInBackground", "Pb_image_too_big:" + String.valueOf(lVar.e.getWidth() + "*" + String.valueOf(lVar.e.getHeight())));
                com.baidu.tbadk.imageManager.d.a().c(m.a(lVar.e) * 2);
                lVar.e = m.a(lVar.e, i, i2);
            }
            if (lVar.j) {
                return null;
            }
            if (i4 == 4) {
                com.baidu.tbadk.imageManager.d.a().c(m.a(lVar.e) * 2);
                lVar.e = m.a(lVar.e, 7.0f);
            }
            if (lVar.j) {
                return null;
            }
            if (lVar.l && (a2 = a(lVar.e, lVar.l, true, str2)) != null) {
                lVar.e = a2;
            }
            lVar.i = new com.baidu.adp.widget.ImageView.e(lVar.e, lVar.h, str);
            com.baidu.tbadk.imageManager.d.a().b(a3, lVar.i);
            if (lVar.j) {
                return null;
            }
            eVar.d(lVar);
            if (lVar.j) {
                return null;
            }
            try {
                if (!lVar.l) {
                    if (i4 == 4) {
                        if (str2 != null) {
                            af.a("image", str2, m.c(lVar.e, 80));
                        }
                    } else if (i4 == 5) {
                        DatabaseService.b(a3, lVar.e);
                    } else if (str2 != null) {
                        s<String> q = com.baidu.tieba.b.a.a().q();
                        if (q != null && lVar.h) {
                            q.a(a3, "gif", 315532800000L);
                        }
                        af.a("image", str2, i7);
                    }
                }
            } catch (Throwable th) {
            }
            return lVar.i;
        }
    }

    public static void a(String str, String str2, boolean z, boolean z2, boolean z3) {
        String str3 = af.f2480a + "/tieba/image/";
        if (af.a(str3) && str2 != null && str != null) {
            String f = be.f(str);
            af.a(str2, str3 + f, true);
            if (z || z2) {
                synchronized (m.f2513a) {
                    int a2 = (int) af.a("image", f);
                    if (a2 > 0) {
                        Bitmap c = af.c("image", f);
                        if (z) {
                            com.baidu.tbadk.imageManager.d.a().c(a2);
                            if (c != null) {
                                a(str, c, z2, af.b("image", f), z3, f);
                            }
                        }
                    }
                }
            }
        }
    }

    public static Bitmap a(Bitmap bitmap) {
        return a(bitmap, true);
    }

    public static Bitmap a(Bitmap bitmap, boolean z) {
        try {
            b a2 = a(bitmap.getWidth(), bitmap.getHeight(), z);
            int i = a2.b;
            int i2 = a2.c;
            if (i != bitmap.getWidth() || i2 != bitmap.getHeight()) {
                Bitmap b = m.b(bitmap, i, i2);
                return b != null ? b : bitmap;
            }
            return bitmap;
        } catch (Exception e) {
            return bitmap;
        }
    }

    private static void a(String str, com.baidu.adp.widget.ImageView.e eVar) {
        com.baidu.tbadk.imageManager.d.a().b(str, eVar);
    }

    private static Bitmap a(Bitmap bitmap, boolean z, boolean z2, String str) {
        Bitmap bitmap2;
        Bitmap a2 = z2 ? a(bitmap) : bitmap;
        if (!z || a2 == null) {
            bitmap2 = a2;
        } else {
            float f = 10.0f;
            bitmap2 = m.a(a2, (a2.getHeight() < 100 || a2.getWidth() < 100) ? 5.0f : 5.0f);
        }
        if (!TextUtils.isEmpty(str)) {
            af.a("image", str, m.c(bitmap2, 100));
        }
        return bitmap2;
    }

    private static void a(String str, Bitmap bitmap, boolean z, boolean z2, boolean z3, String str2) {
        try {
            Bitmap a2 = a(bitmap, z, z3, str2);
            if (a2 != null) {
                a(str, new com.baidu.adp.widget.ImageView.e(a2, z2));
            }
        } catch (Exception e) {
        }
    }

    public static b a(int i, int i2, boolean z) {
        boolean z2;
        int i3;
        int i4;
        int e = LocalViewSize.a().e();
        if (z) {
            if (i / i2 >= 3) {
                z2 = true;
                i3 = i / 2;
                i4 = i;
            } else if (i2 / i >= 3) {
                i4 = i2 / 2;
                z2 = true;
                i3 = i2;
            }
            if (i4 <= i3 && i4 > e) {
                i3 = (int) (i3 / (i4 / e));
            } else if (i3 > i4 || i3 <= e) {
                e = i4;
            } else {
                e = (int) (i4 / (i3 / e));
                i3 = e;
            }
            if (z2 && i <= e && i2 <= i3) {
                e = (int) (e * 0.9d);
                i3 = (int) (i3 * 0.9d);
            }
            if (e <= 10 && i3 <= 10) {
                e *= 3;
                i3 *= 3;
            }
            return new b(e, i3, z2);
        }
        z2 = false;
        i3 = i2;
        i4 = i;
        if (i4 <= i3) {
        }
        if (i3 > i4) {
        }
        e = i4;
        if (z2) {
            e = (int) (e * 0.9d);
            i3 = (int) (i3 * 0.9d);
        }
        if (e <= 10) {
            e *= 3;
            i3 *= 3;
        }
        return new b(e, i3, z2);
    }
}
