package com.baidu.tieba.tblauncher;

import android.graphics.Canvas;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class av implements SlidingMenu.CanvasTransformer {
    final /* synthetic */ aj cwn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(aj ajVar) {
        this.cwn = ajVar;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.CanvasTransformer
    public void transformCanvas(Canvas canvas, float f) {
        float f2 = 1.0f - (0.2f * f);
        canvas.scale(f2, f2, 0.0f, canvas.getHeight() / 2);
    }
}
