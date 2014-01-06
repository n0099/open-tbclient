package com.baidu.tieba.util.a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.lib.cache.s;
import com.baidu.tieba.data.h;
import com.baidu.tieba.im.chat.LocalViewSize;
import com.baidu.tieba.log.k;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.aa;
import com.baidu.tieba.util.at;
import com.baidu.tieba.util.bm;
import com.baidu.tieba.util.bn;
import com.baidu.tieba.util.bo;
import com.baidu.tieba.util.i;
import com.baidu.tieba.util.l;
import com.baidu.tieba.util.m;
/* loaded from: classes.dex */
public class d extends a {
    @Override // com.baidu.tieba.util.a.a
    public Object a(String str, i iVar) {
        com.baidu.adp.widget.ImageView.d c = com.baidu.tbadk.imageManager.d.a().c(iVar.a(str));
        if (bn.a().b()) {
        }
        if (c == null || c.e()) {
        }
        return c;
    }

    @Override // com.baidu.tieba.util.a.a
    public Object a(String str, com.baidu.adp.lib.e.e eVar, i iVar, l lVar) {
        if (lVar.g) {
            String f = bm.f(str);
            String str2 = iVar.f != null ? f + iVar.f : f;
            String a = iVar.a(str);
            synchronized (m.a) {
                if (str2 != null) {
                    if (lVar.d == 5) {
                        f b = DatabaseService.b(a);
                        if (b != null) {
                            lVar.e = b.a;
                        }
                    } else {
                        int a2 = (int) aa.a("image", str2);
                        if (a2 > 0) {
                            com.baidu.tbadk.imageManager.d.a().c(a2);
                            lVar.e = aa.c("image", str2);
                            if (lVar.e != null) {
                                s<String> v = com.baidu.tieba.b.a.a().v();
                                if (v != null && "gif".equals(v.a(a))) {
                                    lVar.h = true;
                                }
                                if (!lVar.h) {
                                    lVar.h = aa.b("image", str2);
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
                lVar.i = new com.baidu.adp.widget.ImageView.d(lVar.e, lVar.h, str);
                com.baidu.tbadk.imageManager.d.a().b(a, lVar.i);
                if (eVar.isCancelled()) {
                    return null;
                }
                if (lVar.i != null) {
                    if (bn.a().b()) {
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

    /* JADX WARN: Removed duplicated region for block: B:176:0x0349 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.tieba.util.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object b(String str, com.baidu.adp.lib.e.e eVar, i iVar, l lVar) {
        int i;
        int i2;
        String sb;
        String c;
        byte[] bArr;
        long j;
        Bitmap a;
        String c2;
        int indexOf;
        if (str == null || str.length() == 0) {
            return null;
        }
        int i3 = lVar.d;
        String f = bm.f(str);
        String str2 = iVar.f != null ? f + iVar.f : f;
        if (iVar.b == 0) {
            i = com.baidu.adp.lib.h.g.a(iVar.a, 105.0f);
        } else {
            i = iVar.b;
        }
        if (iVar.c == 0) {
            i2 = com.baidu.adp.lib.h.g.a(iVar.a, 105.0f);
        } else {
            i2 = iVar.c;
        }
        boolean e = iVar.e();
        if (e) {
            sb = str;
        } else {
            StringBuilder sb2 = new StringBuilder(100);
            sb2.append(h.m);
            sb2.append("src=");
            sb2.append(bm.d(str));
            sb2.append("&width=");
            sb2.append(String.valueOf(i));
            sb2.append("&height=");
            sb2.append(String.valueOf(i2));
            sb2.append("&imgtype=0");
            sb2.append("&qulity=" + bn.a().d());
            sb2.append("&first_gif=1");
            if (iVar.e) {
                sb2.append("&ispv=1");
            }
            if (iVar.g) {
                sb2.append("&no_prefix=1");
            }
            sb = sb2.toString();
        }
        lVar.a = new at(iVar.a, sb);
        int i4 = 1;
        if (sb.contains(".gif")) {
            i4 = 2;
        }
        lVar.a.a(iVar.f(), i4);
        if (e) {
            lVar.a.d(false);
        } else {
            lVar.a.d(true);
        }
        lVar.a.f(e);
        if (iVar.h != null && !e) {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= iVar.h.size()) {
                    break;
                }
                lVar.a.a(iVar.h.get(i6));
                i5 = i6 + 1;
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        byte[] k = lVar.a.k();
        if ((k == null || !lVar.a.c()) && !lVar.j) {
            boolean a2 = com.baidu.adp.lib.network.g.a();
            String str3 = "";
            String str4 = "";
            if (a2) {
                c = UtilHelper.h(iVar.a);
            } else {
                c = UtilHelper.c();
            }
            int indexOf2 = sb.indexOf("hiphotos.baidu.com");
            if (indexOf2 > 0) {
                str4 = sb.substring(0, indexOf2).replace(com.baidu.loginshare.e.f, "") + "hiphotos.baidu.com";
                str3 = UtilHelper.c(str4);
            }
            String str5 = str4 + "=" + str3;
            com.baidu.tieba.log.a.b(k.a(sb, String.valueOf(System.currentTimeMillis() - currentTimeMillis), String.valueOf(lVar.a.b()), lVar.a.f() + ":" + lVar.a.g(), "IS_CDN=" + e + "|download error|iswifi=" + (a2 ? 1 : 0) + "|local_ip=" + c + "|" + str5));
            if (indexOf2 > 0) {
                lVar.a.a(sb);
                long currentTimeMillis2 = System.currentTimeMillis();
                byte[] k2 = lVar.a.k();
                if (!lVar.j) {
                    com.baidu.tieba.log.a.b(k.a(sb, String.valueOf(System.currentTimeMillis() - currentTimeMillis2), String.valueOf(lVar.a.b()), lVar.a.f() + ":" + lVar.a.g(), "downsize=" + (k2 != null ? k2.length : 0) + "|try download result:" + (lVar.a.c() ? "succ" : "fail") + "|iswifi=" + (a2 ? 1 : 0) + "|local_ip=" + c + "|" + str5));
                }
                bArr = k2;
                j = currentTimeMillis2;
                if (bArr != null || lVar.j) {
                    return null;
                }
                String a3 = iVar.a(str);
                synchronized (m.a) {
                    if (lVar.j) {
                        return null;
                    }
                    com.baidu.tbadk.imageManager.d.a().c(h.m() + bArr.length);
                    lVar.e = m.a(bArr);
                    if (lVar.e == null) {
                        if (!lVar.j) {
                            boolean a4 = com.baidu.adp.lib.network.g.a();
                            String str6 = "";
                            String str7 = "";
                            if (a4) {
                                c2 = UtilHelper.h(iVar.a);
                            } else {
                                c2 = UtilHelper.c();
                            }
                            if (sb.indexOf("hiphotos.baidu.com") > 0) {
                                str7 = sb.substring(0, indexOf).replace(com.baidu.loginshare.e.f, "") + "hiphotos.baidu.com";
                                str6 = UtilHelper.c(str7);
                            }
                            com.baidu.tieba.log.a.b(k.a(sb, String.valueOf(System.currentTimeMillis() - j), String.valueOf(lVar.a.b()), lVar.a.f() + ":" + lVar.a.g(), "IS_CDN=" + e + "|decode error|iswifi=" + (a4 ? 1 : 0) + "|local_ip=" + c2 + "|" + (str7 + "=" + str6)));
                        }
                        return null;
                    }
                    lVar.h = lVar.a.p() || com.baidu.adp.lib.h.g.a(bArr);
                    if (lVar.j) {
                        return null;
                    }
                    if (lVar.e.getWidth() > i || lVar.e.getHeight() > i2) {
                        bo.a(1, getClass().getName(), "doInBackground", "Pb_image_too_big:" + String.valueOf(lVar.e.getWidth() + "*" + String.valueOf(lVar.e.getHeight())));
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
                    if (lVar.l && (a = a(lVar.e, lVar.l, true, str2)) != null) {
                        lVar.e = a;
                    }
                    lVar.i = new com.baidu.adp.widget.ImageView.d(lVar.e, lVar.h, str);
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
                            if (i3 == 4) {
                                if (str2 != null) {
                                    aa.a("image", str2, m.c(lVar.e, 80));
                                }
                            } else if (i3 == 5) {
                                DatabaseService.a(a3, lVar.e);
                            } else if (str2 != null) {
                                s<String> v = com.baidu.tieba.b.a.a().v();
                                if (v != null && lVar.h) {
                                    v.a(a3, "gif", 315532800000L);
                                }
                                aa.a("image", str2, bArr);
                            }
                        }
                    } catch (Throwable th) {
                    }
                    return lVar.i;
                }
            }
        }
        bArr = k;
        j = currentTimeMillis;
        if (bArr != null) {
            return null;
        }
        String a32 = iVar.a(str);
        synchronized (m.a) {
        }
    }

    public static void a(String str, String str2, boolean z, boolean z2, boolean z3) {
        String str3 = aa.a + "/tieba/image/";
        if (aa.a(str3) && str2 != null && str != null) {
            String f = bm.f(str);
            aa.a(str2, str3 + f, true);
            if (z || z2 || z3) {
                synchronized (m.a) {
                    int a = (int) aa.a("image", f);
                    if (a > 0) {
                        Bitmap c = aa.c("image", f);
                        if (z) {
                            com.baidu.tbadk.imageManager.d.a().c(a);
                            if (c != null) {
                                a(str, c, z2, aa.b("image", f), z3, f);
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
            c a = a(bitmap.getWidth(), bitmap.getHeight(), z);
            int i = a.b;
            int i2 = a.c;
            if (i != bitmap.getWidth() || i2 != bitmap.getHeight()) {
                Bitmap b = m.b(bitmap, i, i2);
                return b != null ? b : bitmap;
            }
            return bitmap;
        } catch (Exception e) {
            return bitmap;
        }
    }

    private static void a(String str, com.baidu.adp.widget.ImageView.d dVar) {
        com.baidu.tbadk.imageManager.d.a().b(str, dVar);
    }

    private static Bitmap a(Bitmap bitmap, boolean z, boolean z2, String str) {
        Bitmap bitmap2;
        Bitmap a = z2 ? a(bitmap) : bitmap;
        if (!z || a == null) {
            bitmap2 = a;
        } else {
            float f = 10.0f;
            bitmap2 = m.a(a, (a.getHeight() < 100 || a.getWidth() < 100) ? 5.0f : 5.0f);
        }
        if (!TextUtils.isEmpty(str)) {
            aa.a("image", str, m.c(bitmap2, 100));
        }
        return bitmap2;
    }

    private static void a(String str, Bitmap bitmap, boolean z, boolean z2, boolean z3, String str2) {
        try {
            Bitmap a = a(bitmap, z, z3, str2);
            if (a != null) {
                a(str, new com.baidu.adp.widget.ImageView.d(a, z2));
            }
        } catch (Exception e) {
        }
    }

    public static c a(int i, int i2, boolean z) {
        boolean z2;
        int i3;
        int i4;
        int i5;
        int i6 = 70;
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
            if (e < 70 || i3 >= 70) {
                i6 = i3;
                i5 = e;
            } else {
                i5 = 70;
            }
            return new c(i5, i6, z2);
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
        if (e < 70) {
        }
        i6 = i3;
        i5 = e;
        return new c(i5, i6, z2);
    }
}
