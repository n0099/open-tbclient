package com.baidu.tieba.publisher.a;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.baidu.android.util.io.PathUtils;
import com.facebook.cache.disk.b;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.memory.BasePool;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
/* loaded from: classes11.dex */
public class p {
    public static void fk(Context context) {
        h.a gn = com.facebook.imagepipeline.a.a.a.gn(context);
        b.a gj = com.facebook.cache.disk.b.gj(context);
        gj.ag(new File(PathUtils.getImageCacheDirectoryBaseForFresco(context)));
        gn.c(gj.dhW());
        gn.uZ(true);
        gn.b(new e((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)));
        com.facebook.drawee.a.a.c.a(context, gn.dmK(), com.facebook.drawee.a.a.b.djd().a(new a()).djf());
        BasePool.a(new BasePool.b() { // from class: com.baidu.tieba.publisher.a.p.1
            @Override // com.facebook.imagepipeline.memory.BasePool.b
            public void onFailed() {
                com.facebook.drawee.a.a.c.dji().dmm();
            }
        });
    }

    /* loaded from: classes11.dex */
    private static class a extends com.baidu.d.a.b {
        private a() {
        }

        @Override // com.baidu.d.a.b, com.facebook.imagepipeline.f.a
        public boolean a(com.facebook.imagepipeline.g.c cVar) {
            return cVar instanceof com.facebook.imagepipeline.g.d;
        }

        @Override // com.baidu.d.a.b, com.facebook.imagepipeline.f.a
        public Drawable b(com.facebook.imagepipeline.g.c cVar) {
            if (cVar instanceof com.facebook.imagepipeline.g.d) {
                com.facebook.imagepipeline.g.d dVar = (com.facebook.imagepipeline.g.d) cVar;
                BitmapDrawable bitmapDrawable = new BitmapDrawable((Resources) null, dVar.dnV());
                return (dVar.dnZ() == 0 || dVar.dnZ() == -1) ? bitmapDrawable : new com.facebook.drawee.drawable.i(bitmapDrawable, dVar.dnZ());
            }
            return null;
        }
    }
}
