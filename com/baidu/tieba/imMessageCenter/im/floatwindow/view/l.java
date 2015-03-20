package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnTouchListener {
    final /* synthetic */ i brC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.brC = iVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        HeadImageView headImageView;
        int i;
        m mVar;
        Point point;
        Point point2;
        Point point3;
        Point point4;
        switch (motionEvent.getAction()) {
            case 0:
                point3 = this.brC.bqx;
                point3.x = (int) motionEvent.getX();
                point4 = this.brC.bqx;
                point4.y = (int) motionEvent.getY();
                break;
            case 1:
                this.brC.brz = false;
                headImageView = this.brC.azr;
                headImageView.setVisibility(0);
                i iVar = this.brC;
                i = this.brC.bry;
                iVar.gv(i);
                com.baidu.tieba.imMessageCenter.im.floatwindow.b Ul = com.baidu.tieba.imMessageCenter.im.floatwindow.b.Ul();
                mVar = this.brC.brA;
                Ul.a(mVar);
                break;
            case 2:
                com.baidu.tieba.imMessageCenter.im.floatwindow.b Ul2 = com.baidu.tieba.imMessageCenter.im.floatwindow.b.Ul();
                point = this.brC.bqx;
                int rawX = ((int) motionEvent.getRawX()) + point.x;
                point2 = this.brC.bqx;
                Ul2.T(rawX, (((int) motionEvent.getRawY()) - point2.y) - 25);
                break;
        }
        return false;
    }
}
