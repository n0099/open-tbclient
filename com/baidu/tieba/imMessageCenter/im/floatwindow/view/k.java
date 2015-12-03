package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ h cbR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.cbR = hVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        HeadImageView headImageView;
        int i;
        h.a aVar;
        Point point;
        Point point2;
        Point point3;
        Point point4;
        switch (motionEvent.getAction()) {
            case 0:
                point3 = this.cbR.caL;
                point3.x = (int) motionEvent.getX();
                point4 = this.cbR.caL;
                point4.y = (int) motionEvent.getY();
                break;
            case 1:
                this.cbR.cbO = false;
                headImageView = this.cbR.aJP;
                headImageView.setVisibility(0);
                h hVar = this.cbR;
                i = this.cbR.cbN;
                hVar.iJ(i);
                com.baidu.tieba.imMessageCenter.im.floatwindow.b abE = com.baidu.tieba.imMessageCenter.im.floatwindow.b.abE();
                aVar = this.cbR.cbP;
                abE.a(aVar);
                break;
            case 2:
                com.baidu.tieba.imMessageCenter.im.floatwindow.b abE2 = com.baidu.tieba.imMessageCenter.im.floatwindow.b.abE();
                point = this.cbR.caL;
                int rawX = ((int) motionEvent.getRawX()) + point.x;
                point2 = this.cbR.caL;
                abE2.an(rawX, (((int) motionEvent.getRawY()) - point2.y) - 25);
                break;
        }
        return false;
    }
}
