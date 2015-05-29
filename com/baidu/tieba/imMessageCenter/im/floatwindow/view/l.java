package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnTouchListener {
    final /* synthetic */ i buE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.buE = iVar;
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
                point3 = this.buE.btx;
                point3.x = (int) motionEvent.getX();
                point4 = this.buE.btx;
                point4.y = (int) motionEvent.getY();
                break;
            case 1:
                this.buE.buB = false;
                headImageView = this.buE.aBk;
                headImageView.setVisibility(0);
                i iVar = this.buE;
                i = this.buE.buA;
                iVar.gO(i);
                com.baidu.tieba.imMessageCenter.im.floatwindow.b VP = com.baidu.tieba.imMessageCenter.im.floatwindow.b.VP();
                mVar = this.buE.buC;
                VP.a(mVar);
                break;
            case 2:
                com.baidu.tieba.imMessageCenter.im.floatwindow.b VP2 = com.baidu.tieba.imMessageCenter.im.floatwindow.b.VP();
                point = this.buE.btx;
                int rawX = ((int) motionEvent.getRawX()) + point.x;
                point2 = this.buE.btx;
                VP2.V(rawX, (((int) motionEvent.getRawY()) - point2.y) - 25);
                break;
        }
        return false;
    }
}
