package com.baidu.tieba.img.effects;

import android.graphics.Bitmap;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public final class c {
    private static c a = new c();
    private final HashMap<String, Class<? extends b>> b = new HashMap<>();

    public static c a() {
        return a;
    }

    private c() {
        a(d.class);
        a(f.class);
        a(a.class);
        a(e.class);
    }

    public final Bitmap a(Bitmap bitmap, boolean z, List<ImageOperation> list) {
        d dVar;
        Bitmap bitmap2;
        int i;
        int i2 = 0;
        if (bitmap != null && list != null && !list.isEmpty()) {
            if (list != null) {
                int i3 = 0;
                dVar = null;
                while (i3 < list.size()) {
                    ImageOperation imageOperation = list.get(i3);
                    if ("resize".equals(imageOperation.actionName)) {
                        d dVar2 = (d) a(imageOperation);
                        if (dVar != null && dVar2.b() > dVar.b() && dVar2.c() > dVar.c()) {
                            dVar2 = dVar;
                        }
                        list.remove(i3);
                        dVar = dVar2;
                        i = i3 - 1;
                    } else {
                        i = i3;
                    }
                    i3 = i + 1;
                }
            } else {
                dVar = null;
            }
            Bitmap a2 = dVar != null ? dVar.a(bitmap, z) : null;
            if (list != null) {
                while (true) {
                    bitmap2 = a2;
                    if (i2 >= list.size()) {
                        break;
                    }
                    b a3 = a(list.get(i2));
                    if (a3 == null) {
                        a2 = bitmap2;
                    } else if (bitmap2 == null) {
                        return null;
                    } else {
                        a2 = a3.a(bitmap, z);
                    }
                    i2++;
                }
            } else {
                bitmap2 = a2;
            }
            return bitmap2;
        }
        return bitmap;
    }

    public final Bitmap a(String str, List<ImageOperation> list) {
        d dVar;
        int i;
        int i2 = 0;
        if (list == null || list.isEmpty()) {
            return null;
        }
        if (list != null) {
            int i3 = 0;
            dVar = null;
            while (i3 < list.size()) {
                ImageOperation imageOperation = list.get(i3);
                if ("resize".equals(imageOperation.actionName)) {
                    d dVar2 = (d) a(imageOperation);
                    if (dVar != null && dVar2.b() > dVar.b() && dVar2.c() > dVar.c()) {
                        dVar2 = dVar;
                    }
                    list.remove(i3);
                    dVar = dVar2;
                    i = i3 - 1;
                } else {
                    i = i3;
                }
                i3 = i + 1;
            }
        } else {
            dVar = null;
        }
        Bitmap c = dVar != null ? dVar.c(str) : null;
        if (list == null) {
            return c;
        }
        while (true) {
            Bitmap bitmap = c;
            if (i2 < list.size()) {
                b a2 = a(list.get(i2));
                if (a2 == null) {
                    c = bitmap;
                } else if (bitmap == null) {
                    c = a2.c(str);
                } else {
                    c = a2.a(bitmap, true);
                }
                i2++;
            } else {
                return bitmap;
            }
        }
    }

    private b a(ImageOperation imageOperation) {
        b b;
        Class<? extends b> cls = this.b.get(imageOperation.actionName);
        if (cls != null && (b = b(cls)) != null) {
            b.b(imageOperation.actionParam);
            return b;
        }
        return null;
    }

    private void a(Class<? extends b> cls) {
        b b = b(cls);
        if (b != null) {
            this.b.put(b.a(), cls);
        }
    }

    private static b b(Class<? extends b> cls) {
        try {
            return cls.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
