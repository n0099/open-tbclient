package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnTouchListener {
    final /* synthetic */ i buF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.buF = iVar;
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
                point3 = this.buF.bty;
                point3.x = (int) motionEvent.getX();
                point4 = this.buF.bty;
                point4.y = (int) motionEvent.getY();
                break;
            case 1:
                this.buF.buC = false;
                headImageView = this.buF.aBl;
                headImageView.setVisibility(0);
                i iVar = this.buF;
                i = this.buF.buB;
                iVar.gO(i);
                com.baidu.tieba.imMessageCenter.im.floatwindow.b VQ = com.baidu.tieba.imMessageCenter.im.floatwindow.b.VQ();
                mVar = this.buF.buD;
                VQ.a(mVar);
                break;
            case 2:
                com.baidu.tieba.imMessageCenter.im.floatwindow.b VQ2 = com.baidu.tieba.imMessageCenter.im.floatwindow.b.VQ();
                point = this.buF.bty;
                int rawX = ((int) motionEvent.getRawX()) + point.x;
                point2 = this.buF.bty;
                VQ2.V(rawX, (((int) motionEvent.getRawY()) - point2.y) - 25);
                break;
        }
        return false;
    }
}
