package com.baidu.tieba.pb.view;

import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ l eLV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.eLV = lVar;
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
        z = this.eLV.eLO;
        if (z) {
            tVar = this.eLV.eLL;
            if (!tVar.anx()) {
                Rect rect = new Rect();
                view = this.eLV.eLN;
                view.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                tVar2 = this.eLV.eLL;
                tVar2.getGlobalVisibleRect(rect2);
                int g = (rect.bottom - ((rect.bottom - rect.top) / 2)) - (rect2.bottom - com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds112));
                tVar3 = this.eLV.eLL;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tVar3.getLayoutParams();
                layoutParams.setMargins(0, g + layoutParams.topMargin, 0, 0);
                tVar4 = this.eLV.eLL;
                tVar4.setLayoutParams(layoutParams);
                tVar5 = this.eLV.eLL;
                int width = tVar5.getWidth();
                tVar6 = this.eLV.eLL;
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(width, tVar6.getHeight());
                layoutParams2.setMargins(0, layoutParams.topMargin, 0, 0);
                layoutParams2.gravity = 1;
                view2 = this.eLV.eLR;
                view2.setX(0.0f);
                view3 = this.eLV.eLR;
                view3.setY(0.0f);
                view4 = this.eLV.eLR;
                view4.setLayoutParams(layoutParams2);
                view5 = this.eLV.eLR;
                view5.invalidate();
                tVar7 = this.eLV.eLL;
                tVar7.setVisibility(0);
                tVar8 = this.eLV.eLL;
                tVar8.aTg();
                this.eLV.eLM = System.currentTimeMillis();
            }
        }
    }
}
