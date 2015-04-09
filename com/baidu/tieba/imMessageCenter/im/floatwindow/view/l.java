package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnTouchListener {
    final /* synthetic */ i brS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.brS = iVar;
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
                point3 = this.brS.bqN;
                point3.x = (int) motionEvent.getX();
                point4 = this.brS.bqN;
                point4.y = (int) motionEvent.getY();
                break;
            case 1:
                this.brS.brP = false;
                headImageView = this.brS.azz;
                headImageView.setVisibility(0);
                i iVar = this.brS;
                i = this.brS.brO;
                iVar.gx(i);
                com.baidu.tieba.imMessageCenter.im.floatwindow.b Uy = com.baidu.tieba.imMessageCenter.im.floatwindow.b.Uy();
                mVar = this.brS.brQ;
                Uy.a(mVar);
                break;
            case 2:
                com.baidu.tieba.imMessageCenter.im.floatwindow.b Uy2 = com.baidu.tieba.imMessageCenter.im.floatwindow.b.Uy();
                point = this.brS.bqN;
                int rawX = ((int) motionEvent.getRawX()) + point.x;
                point2 = this.brS.bqN;
                Uy2.T(rawX, (((int) motionEvent.getRawY()) - point2.y) - 25);
                break;
        }
        return false;
    }
}
