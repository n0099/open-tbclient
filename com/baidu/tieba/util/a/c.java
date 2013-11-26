package com.baidu.tieba.util.a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.lib.cache.s;
import com.baidu.adp.lib.network.g;
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
import com.baidu.tieba.util.y;
/* loaded from: classes.dex */
public class c extends a {
    @Override // com.baidu.tieba.util.a.a
    public Object a(String str, i iVar) {
        com.baidu.adp.widget.ImageView.e c = com.baidu.tbadk.imageManager.d.a().c(iVar.a(str));
        if (bf.a().b()) {
        }
        if (c == null || c.c()) {
        }
        return c;
    }

    @Override // com.baidu.tieba.util.a.a
    public Object a(String str, com.baidu.adp.lib.e.e eVar, i iVar, l lVar) {
        if (lVar.g) {
            String f = be.f(str);
            String str2 = iVar.f != null ? f + iVar.f : f;
            String a2 = iVar.a(str);
            synchronized (m.f2496a) {
                if (str2 != null) {
                    if (lVar.d == 5) {
                        lVar.e = DatabaseService.d(a2);
                    } else {
                        int b = (int) af.b("image", str2);
                        if (b > 0) {
                            com.baidu.tbadk.imageManager.d.a().c(b);
                            lVar.e = af.d("image", str2);
                            if (lVar.e != null) {
                                s<String> q = com.baidu.tieba.b.a.a().q();
                                if (q != null && "gif".equals(q.a(a2))) {
                                    lVar.h = true;
                                }
                                if (!lVar.h) {
                                    lVar.h = af.c("image", str2);
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
        int i;
        int i2;
        String sb;
        String c;
        Bitmap a2;
        String c2;
        String str2;
        if (str == null || str.length() == 0) {
            return null;
        }
        int i3 = lVar.d;
        String f = be.f(str);
        String str3 = iVar.f != null ? f + iVar.f : f;
        if (iVar.b == 0) {
            i = UtilHelper.a(iVar.f2492a, 105.0f);
        } else {
            i = iVar.b;
        }
        if (iVar.c == 0) {
            i2 = UtilHelper.a(iVar.f2492a, 105.0f);
        } else {
            i2 = iVar.c;
        }
        boolean c3 = iVar.c();
        if (c3) {
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
        lVar.f2495a = new ap(iVar.f2492a, sb);
        int i4 = 1;
        if (sb.contains(".gif")) {
            i4 = 2;
        }
        lVar.f2495a.a(iVar.d(), i4);
        if (c3) {
            lVar.f2495a.d(false);
        } else {
            lVar.f2495a.d(true);
        }
        lVar.f2495a.f(c3);
        if (iVar.h != null && !c3) {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= iVar.h.size()) {
                    break;
                }
                lVar.f2495a.a(iVar.h.get(i6));
                i5 = i6 + 1;
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        byte[] k = lVar.f2495a.k();
        if ((k == null || !lVar.f2495a.c()) && !lVar.j) {
            boolean a3 = g.a();
            String str4 = "";
            String str5 = "";
            if (a3) {
                c = UtilHelper.j(iVar.f2492a);
            } else {
                c = UtilHelper.c();
            }
            int indexOf = sb.indexOf("hiphotos.baidu.com");
            if (indexOf > 0) {
                String replace = sb.substring(0, indexOf).replace(com.baidu.loginshare.e.f, "");
                str4 = UtilHelper.c(replace + "hiphotos.baidu.com");
                str5 = UtilHelper.c(replace + "hiphotos.bdimg.com");
            }
            y.a(sb, String.valueOf(System.currentTimeMillis() - currentTimeMillis), String.valueOf(lVar.f2495a.b()), lVar.f2495a.f() + ":" + lVar.f2495a.g(), "IS_CDN=" + c3 + "|download error|iswifi=" + (a3 ? 1 : 0) + "|local_ip=" + c + "|cdn_ip=" + str4 + "|cdn_ip2=" + str5);
            if (indexOf > 0) {
                String replace2 = sb.replace("hiphotos.baidu.com", "hiphotos.bdimg.com");
                lVar.f2495a.a(replace2);
                k = lVar.f2495a.k();
                currentTimeMillis = System.currentTimeMillis();
                if (!lVar.j) {
                    y.a(replace2, String.valueOf(System.currentTimeMillis() - currentTimeMillis), String.valueOf(lVar.f2495a.b()), lVar.f2495a.f() + ":" + lVar.f2495a.g(), "downsize=" + (k != null ? k.length : 0) + "|try download result:" + (lVar.f2495a.c() ? "succ" : "fail") + "|iswifi=" + (a3 ? 1 : 0) + "|local_ip=" + c + "|cdn_ip=" + str4 + "|cdn_ip2=" + str5);
                }
            }
        }
        byte[] bArr = k;
        long j = currentTimeMillis;
        if (bArr == null || lVar.j) {
            return null;
        }
        String a4 = iVar.a(str);
        synchronized (m.f2496a) {
            if (lVar.j) {
                return null;
            }
            com.baidu.tbadk.imageManager.d.a().c(h.k() + bArr.length);
            lVar.e = m.a(bArr);
            if (lVar.e == null) {
                if (!lVar.j) {
                    boolean a5 = g.a();
                    if (a5) {
                        c2 = UtilHelper.j(iVar.f2492a);
                    } else {
                        c2 = UtilHelper.c();
                    }
                    int indexOf2 = sb.indexOf("hiphotos.baidu.com");
                    if (indexOf2 <= 0) {
                        str2 = "";
                    } else {
                        str2 = UtilHelper.c(sb.substring(0, indexOf2).replace(com.baidu.loginshare.e.f, "") + "hiphotos.baidu.com");
                    }
                    y.a(sb, String.valueOf(System.currentTimeMillis() - j), String.valueOf(lVar.f2495a.b()), lVar.f2495a.f() + ":" + lVar.f2495a.g(), "IS_CDN=" + c3 + "|decode error|iswifi=" + (a5 ? 1 : 0) + "|local_ip=" + c2 + "|cdn_ip=" + str2);
                }
                return null;
            }
            lVar.h = lVar.f2495a.p() || UtilHelper.a(bArr);
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
            if (i3 == 4) {
                com.baidu.tbadk.imageManager.d.a().c(m.a(lVar.e) * 2);
                lVar.e = m.a(lVar.e, 7.0f);
            }
            if (lVar.j) {
                return null;
            }
            if (lVar.l && (a2 = a(lVar.e, lVar.l, true, str3)) != null) {
                lVar.e = a2;
            }
            lVar.i = new com.baidu.adp.widget.ImageView.e(lVar.e, lVar.h, str);
            com.baidu.tbadk.imageManager.d.a().b(a4, lVar.i);
            if (lVar.j) {
                return null;
            }
            eVar.d(lVar);
            if (lVar.j) {
                return null;
            }
            try {
                if (!lVar.l) {
                    if (i3 == 4) {
                        if (str3 != null) {
                            af.a("image", str3, m.c(lVar.e, 80));
                        }
                    } else if (i3 == 5) {
                        DatabaseService.b(a4, lVar.e);
                    } else if (str3 != null) {
                        s<String> q = com.baidu.tieba.b.a.a().q();
                        if (q != null && lVar.h) {
                            q.a(a4, "gif", 315532800000L);
                        }
                        af.a("image", str3, bArr);
                    }
                }
            } catch (Throwable th) {
            }
            return lVar.i;
        }
    }

    public static void a(String str, String str2, boolean z, boolean z2, boolean z3) {
        String str3 = af.f2463a + "/tieba/image/";
        if (af.a(str3) && str2 != null && str != null) {
            String f = be.f(str);
            af.a(str2, str3 + f, true);
            if (z || z2) {
                synchronized (m.f2496a) {
                    int b = (int) af.b("image", f);
                    if (b > 0) {
                        Bitmap d = af.d("image", f);
                        if (z) {
                            com.baidu.tbadk.imageManager.d.a().c(b);
                            if (d != null) {
                                a(str, d, z2, af.c("image", f), z3, f);
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
