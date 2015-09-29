package com.baidu.tieba.tblauncher;

import android.graphics.Canvas;
import com.slidingmenu.lib.SlidingMenu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements SlidingMenu.CanvasTransformer {
    final /* synthetic */ ao dcY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(ao aoVar) {
        this.dcY = aoVar;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.CanvasTransformer
    public void transformCanvas(Canvas canvas, float f) {
        float f2 = (0.2f * f) + 0.8f;
        canvas.scale(f2, f2, 0.0f, canvas.getHeight() / 2);
    }
}
