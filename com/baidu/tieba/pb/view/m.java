package com.baidu.tieba.pb.view;

import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ l eCy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.eCy = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        t tVar;
        View view;
        t tVar2;
        t tVar3;
        t tVar4;
        t tVar5;
        t tVar6;
        View view2;
        View view3;
        View view4;
        View view5;
        t tVar7;
        t tVar8;
        z = this.eCy.eCr;
        if (z) {
            tVar = this.eCy.eCo;
            if (!tVar.ajM()) {
                Rect rect = new Rect();
                view = this.eCy.eCq;
                view.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                tVar2 = this.eCy.eCo;
                tVar2.getGlobalVisibleRect(rect2);
                int g = (rect.bottom - ((rect.bottom - rect.top) / 2)) - (rect2.bottom - com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds112));
                tVar3 = this.eCy.eCo;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tVar3.getLayoutParams();
                layoutParams.setMargins(0, g + layoutParams.topMargin, 0, 0);
                tVar4 = this.eCy.eCo;
                tVar4.setLayoutParams(layoutParams);
                tVar5 = this.eCy.eCo;
                int width = tVar5.getWidth();
                tVar6 = this.eCy.eCo;
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(width, tVar6.getHeight());
                layoutParams2.setMargins(0, layoutParams.topMargin, 0, 0);
                layoutParams2.gravity = 1;
                view2 = this.eCy.eCu;
                view2.setX(0.0f);
                view3 = this.eCy.eCu;
                view3.setY(0.0f);
                view4 = this.eCy.eCu;
                view4.setLayoutParams(layoutParams2);
                view5 = this.eCy.eCu;
                view5.invalidate();
                tVar7 = this.eCy.eCo;
                tVar7.setVisibility(0);
                tVar8 = this.eCy.eCo;
                tVar8.aPh();
                this.eCy.eCp = System.currentTimeMillis();
            }
        }
    }
}
