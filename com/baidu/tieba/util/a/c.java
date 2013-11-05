package com.baidu.tieba.util.a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tieba.data.h;
import com.baidu.tieba.im.chat.LocalViewSize;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.ag;
import com.baidu.tieba.util.bc;
import com.baidu.tieba.util.bd;
import com.baidu.tieba.util.be;
import com.baidu.tieba.util.w;
/* loaded from: classes.dex */
public class c extends a {
    @Override // com.baidu.tieba.util.a.a
    public Object a(String str, com.baidu.tieba.util.a aVar) {
        return com.baidu.tbadk.imageManager.d.a().c(aVar.a(str));
    }

    @Override // com.baidu.tieba.util.a.a
    public Object a(String str, com.baidu.adp.lib.e.e eVar, com.baidu.tieba.util.a aVar, com.baidu.tieba.util.d dVar) {
        if (dVar.g) {
            String f = bc.f(str);
            if (aVar.f != null) {
                f = f + aVar.f;
            }
            String a2 = aVar.a(str);
            synchronized (com.baidu.tieba.util.e.f2449a) {
                if (f != null) {
                    int a3 = (int) w.a("image", f);
                    if (a3 > 0) {
                        com.baidu.tbadk.imageManager.d.a().c(a3);
                        dVar.e = w.c("image", f);
                        if (dVar.e != null) {
                            dVar.h = w.b("image", f);
                        }
                    }
                }
                if (eVar.isCancelled()) {
                    return null;
                }
                if (dVar.e == null) {
                    return null;
                }
                dVar.i = new com.baidu.adp.widget.ImageView.e(dVar.e, dVar.h, str);
                a(a2, dVar.i);
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
        int i;
        int i2;
        String sb;
        Bitmap a2;
        if (str == null || str.length() == 0) {
            return null;
        }
        int i3 = dVar.d;
        String f = bc.f(str);
        String str2 = aVar.f != null ? f + aVar.f : f;
        if (aVar.b == 0) {
            i = UtilHelper.a(aVar.f2411a, 105.0f);
        } else {
            i = aVar.b;
        }
        if (aVar.c == 0) {
            i2 = UtilHelper.a(aVar.f2411a, 105.0f);
        } else {
            i2 = aVar.c;
        }
        boolean c = aVar.c();
        if (c) {
            sb = str;
        } else {
            StringBuilder sb2 = new StringBuilder(100);
            sb2.append(h.k);
            sb2.append("src=");
            sb2.append(bc.d(str));
            sb2.append("&width=");
            sb2.append(String.valueOf(i));
            sb2.append("&height=");
            sb2.append(String.valueOf(i2));
            sb2.append("&imgtype=0");
            sb2.append("&qulity=" + bd.a().d());
            sb2.append("&first_gif=1");
            if (aVar.e) {
                sb2.append("&ispv=1");
            }
            if (aVar.g) {
                sb2.append("&no_prefix=1");
            }
            sb = sb2.toString();
        }
        dVar.f2448a = new ag(aVar.f2411a, sb);
        if (c) {
            dVar.f2448a.d(false);
        } else {
            dVar.f2448a.d(true);
        }
        dVar.f2448a.f(c);
        if (aVar.h != null && !c) {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= aVar.h.size()) {
                    break;
                }
                dVar.f2448a.a(aVar.h.get(i5));
                i4 = i5 + 1;
            }
        }
        byte[] i6 = dVar.f2448a.i();
        if (i6 == null || !dVar.f2448a.c() || dVar.j) {
            return null;
        }
        String a3 = aVar.a(str);
        synchronized (com.baidu.tieba.util.e.f2449a) {
            if (dVar.j) {
                return null;
            }
            com.baidu.tbadk.imageManager.d.a().c(h.k() + i6.length);
            dVar.e = com.baidu.tieba.util.e.a(i6);
            if (dVar.e == null) {
                return null;
            }
            dVar.h = dVar.f2448a.n() || UtilHelper.a(i6);
            if (dVar.j) {
                return null;
            }
            if (dVar.e.getWidth() > i || dVar.e.getHeight() > i2) {
                be.a(1, getClass().getName(), "doInBackground", "Pb_image_too_big:" + String.valueOf(dVar.e.getWidth() + "*" + String.valueOf(dVar.e.getHeight())));
                com.baidu.tbadk.imageManager.d.a().c(com.baidu.tieba.util.e.a(dVar.e) * 2);
                dVar.e = com.baidu.tieba.util.e.a(dVar.e, i, i2);
            }
            if (dVar.j) {
                return null;
            }
            if (i3 == 4) {
                com.baidu.tbadk.imageManager.d.a().c(com.baidu.tieba.util.e.a(dVar.e) * 2);
                dVar.e = com.baidu.tieba.util.e.a(dVar.e, 7.0f);
            }
            if (dVar.j) {
                return null;
            }
            if (dVar.l && (a2 = a(dVar.e, dVar.l, true, str2)) != null) {
                dVar.e = a2;
            }
            dVar.i = new com.baidu.adp.widget.ImageView.e(dVar.e, dVar.h, str);
            a(a3, dVar.i);
            if (dVar.j) {
                return null;
            }
            eVar.d(dVar);
            if (dVar.j) {
                return null;
            }
            try {
                if (!dVar.l) {
                    if (i3 == 4) {
                        if (str2 != null) {
                            w.a("image", str2, com.baidu.tieba.util.e.c(dVar.e, 80));
                        }
                    } else if (str2 != null) {
                        w.a("image", str2, i6);
                    }
                }
            } catch (Throwable th) {
            }
            return dVar.i;
        }
    }

    public static void a(String str, String str2, boolean z, boolean z2, boolean z3) {
        String str3 = w.f2463a + "/tieba/image/";
        if (w.a(str3) && str2 != null && str != null) {
            String f = bc.f(str);
            w.a(str2, str3 + f, true);
            if (z || z2) {
                synchronized (com.baidu.tieba.util.e.f2449a) {
                    int a2 = (int) w.a("image", f);
                    if (a2 > 0) {
                        Bitmap c = w.c("image", f);
                        if (z) {
                            com.baidu.tbadk.imageManager.d.a().c(a2);
                            if (c != null) {
                                a(str, c, z2, w.b("image", f), z3, f);
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
                Bitmap b = com.baidu.tieba.util.e.b(bitmap, i, i2);
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
            bitmap2 = com.baidu.tieba.util.e.a(a2, (a2.getHeight() < 100 || a2.getWidth() < 100) ? 5.0f : 5.0f);
        }
        if (!TextUtils.isEmpty(str)) {
            w.a("image", str, com.baidu.tieba.util.e.c(bitmap2, 100));
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
