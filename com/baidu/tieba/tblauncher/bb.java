package com.baidu.tieba.tblauncher;

import android.graphics.Canvas;
import com.slidingmenu.lib.SlidingMenu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements SlidingMenu.CanvasTransformer {
    final /* synthetic */ am cVq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(am amVar) {
        this.cVq = amVar;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.CanvasTransformer
    public void transformCanvas(Canvas canvas, float f) {
        float f2 = (0.2f * f) + 0.8f;
        canvas.scale(f2, f2, 0.0f, canvas.getHeight() / 2);
    }
}
