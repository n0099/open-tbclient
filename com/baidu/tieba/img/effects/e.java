package com.baidu.tieba.img.effects;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.n;
/* loaded from: classes.dex */
public class e extends b {
    private int a = 0;

    @Override // com.baidu.tieba.img.effects.b
    public final String a() {
        return "rotate";
    }

    public static ImageOperation a(int i) {
        ImageOperation imageOperation = new ImageOperation();
        imageOperation.actionName = "rotate";
        imageOperation.actionParam = String.valueOf(i);
        return imageOperation;
    }

    @Override // com.baidu.tieba.img.effects.b
    public final void b(String str) {
        if (str != null) {
            this.a = Integer.parseInt(str);
        }
    }

    @Override // com.baidu.tieba.img.effects.b
    public final Bitmap a(Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            return null;
        }
        com.baidu.tbadk.imageManager.e.a().b(n.a(bitmap) * 2);
        if (this.a == 0 || this.a == 1) {
            return n.d(bitmap, this.a);
        }
        if (this.a == 2 || this.a == 3) {
            return n.f(bitmap, this.a);
        }
        return bitmap;
    }

    @Override // com.baidu.tieba.img.effects.b
    public final Bitmap c(String str) {
        int max = Math.max(BdUtilHelper.b(TiebaApplication.g().b()), BdUtilHelper.c(TiebaApplication.g().b()));
        return a(n.a(str, max, max), true);
    }
}
