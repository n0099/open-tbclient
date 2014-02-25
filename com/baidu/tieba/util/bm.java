package com.baidu.tieba.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tieba.im.chat.LocalViewSize;
/* loaded from: classes.dex */
public class bm {
    private static bm a;

    public static synchronized bm a() {
        bm bmVar;
        synchronized (bm.class) {
            if (a == null) {
                a = new bm();
            }
            bmVar = a;
        }
        return bmVar;
    }

    public void a(String str, String str2, boolean z, boolean z2, boolean z3) {
        if (str2 != null && str != null) {
            String f = bs.f(str);
            br.a().a(str2, f);
            if (z || z2 || z3) {
                synchronized (n.a) {
                    int c = br.a().c(f);
                    if (c > 0) {
                        if (z) {
                            Bitmap a2 = br.a().a(f);
                            com.baidu.tbadk.imageManager.e.a().c(c);
                            if (a2 != null) {
                                a(str, a2, z2, br.a().b(f), z3, f);
                            }
                        }
                    }
                }
            }
        }
    }

    public void b(String str, String str2, boolean z, boolean z2, boolean z3) {
        new bn(this, str2, str2, z3, z3, z3).execute(new String[0]);
    }

    public Bitmap a(Bitmap bitmap) {
        return a(bitmap, true);
    }

    public Bitmap a(Bitmap bitmap, boolean z) {
        try {
            com.baidu.tieba.util.a.c a2 = a(bitmap.getWidth(), bitmap.getHeight(), z);
            int i = a2.b;
            int i2 = a2.c;
            if (i != bitmap.getWidth() || i2 != bitmap.getHeight()) {
                Bitmap a3 = n.a(bitmap, i, i2);
                return a3 != null ? a3 : bitmap;
            }
            return bitmap;
        } catch (Exception e) {
            ae aeVar = new ae();
            if (bitmap == null) {
                aeVar.a("bitmap", "null");
            } else {
                aeVar.a("bitW", Integer.valueOf(bitmap.getWidth()));
                aeVar.a("bitH", Integer.valueOf(bitmap.getHeight()));
            }
            cb.a("", -1005, "getResizedBitmap error: " + e.toString(), aeVar.toString());
            return bitmap;
        }
    }

    private static void a(String str, com.baidu.adp.widget.ImageView.b bVar) {
        com.baidu.tbadk.imageManager.e.a().b(str, bVar);
    }

    public Bitmap a(Bitmap bitmap, boolean z, boolean z2, String str) {
        Bitmap bitmap2;
        Bitmap a2 = z2 ? a(bitmap) : bitmap;
        if (!z || a2 == null) {
            bitmap2 = a2;
        } else {
            float f = 10.0f;
            bitmap2 = n.a(a2, (a2.getHeight() < 100 || a2.getWidth() < 100) ? 5.0f : 5.0f, true);
        }
        if (!TextUtils.isEmpty(str)) {
            br.a().a(str, n.c(bitmap2, 100));
        }
        return bitmap2;
    }

    private void a(String str, Bitmap bitmap, boolean z, boolean z2, boolean z3, String str2) {
        try {
            Bitmap a2 = a(bitmap, z, z3, str2);
            if (a2 != null) {
                a(str, new com.baidu.adp.widget.ImageView.b(a2, z2));
            }
        } catch (Exception e) {
            cb.a("", -1006, "addPicMemoryCache error: " + e.toString(), str);
        }
    }

    public com.baidu.tieba.util.a.c a(int i, int i2, boolean z) {
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
            return new com.baidu.tieba.util.a.c(i5, i6, z2);
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
        return new com.baidu.tieba.util.a.c(i5, i6, z2);
    }
}
