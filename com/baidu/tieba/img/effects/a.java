package com.baidu.tieba.img.effects;

import android.graphics.Bitmap;
import cn.jingling.lib.filters.FilterFactory;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.i;
import com.baidu.tieba.util.n;
/* loaded from: classes.dex */
public class a extends b {
    private String a = "";

    @Override // com.baidu.tieba.img.effects.b
    public String a() {
        return "filter";
    }

    public static ImageOperation a(String str) {
        ImageOperation imageOperation = new ImageOperation();
        imageOperation.actionName = "filter";
        imageOperation.actionParam = str;
        return imageOperation;
    }

    @Override // com.baidu.tieba.img.effects.b
    public void b(String str) {
        if (str != null) {
            this.a = str;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [88=4, 89=4] */
    /* JADX DEBUG: Incorrect finally slice size: {[IF, INVOKE, INVOKE, MOVE, IF] complete}, expected: {[IF, INVOKE, INVOKE, IF] complete} */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tieba.img.effects.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap a(Bitmap bitmap, boolean z) {
        Bitmap bitmap2;
        Bitmap bitmap3 = null;
        if (bitmap == null) {
            return null;
        }
        com.baidu.tbadk.imageManager.e.a().c(n.a(bitmap) * 2);
        if ("normal".equals(this.a)) {
            return bitmap;
        }
        if (bitmap.isMutable()) {
            try {
                bitmap2 = FilterFactory.createOneKeyFilter(TiebaApplication.g().b(), this.a).apply(TiebaApplication.g(), bitmap);
            } catch (Throwable th) {
                com.baidu.adp.lib.util.f.b("motou filter failed." + th.getMessage());
                if (com.baidu.adp.lib.util.f.a()) {
                    th.printStackTrace();
                    bitmap2 = null;
                }
                bitmap2 = null;
            }
            if (bitmap2 == null) {
                if (z && bitmap2 != bitmap) {
                    bitmap.recycle();
                }
                return bitmap2;
            }
            return bitmap;
        }
        Bitmap.Config config = bitmap.getConfig();
        if (config == null) {
            config = i.m;
        }
        Bitmap copy = bitmap.copy(config, true);
        if (copy != null) {
            try {
                try {
                    bitmap3 = FilterFactory.createOneKeyFilter(TiebaApplication.g().b(), this.a).apply(TiebaApplication.g(), copy);
                } catch (IllegalStateException e) {
                    com.baidu.adp.lib.util.f.b(e.toString());
                    if (copy != null && copy != null) {
                        copy.recycle();
                        bitmap2 = null;
                    }
                    bitmap2 = null;
                }
            } catch (Throwable th2) {
                if (copy != null && copy != null) {
                    copy.recycle();
                }
                throw th2;
            }
        }
        if (copy == null || bitmap3 == copy) {
            bitmap2 = bitmap3;
        } else {
            copy.recycle();
            bitmap2 = bitmap3;
        }
        if (bitmap2 == null) {
        }
    }
}
