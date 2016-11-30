package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ h dwT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.dwT = hVar;
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
                point3 = this.dwT.dvO;
                point3.x = (int) motionEvent.getX();
                point4 = this.dwT.dvO;
                point4.y = (int) motionEvent.getY();
                break;
            case 1:
                this.dwT.dwQ = false;
                headImageView = this.dwT.aYe;
                headImageView.setVisibility(0);
                h hVar = this.dwT;
                i = this.dwT.dwP;
                hVar.mr(i);
                com.baidu.tieba.imMessageCenter.im.floatwindow.b azI = com.baidu.tieba.imMessageCenter.im.floatwindow.b.azI();
                aVar = this.dwT.dwR;
                azI.a(aVar);
                break;
            case 2:
                com.baidu.tieba.imMessageCenter.im.floatwindow.b azI2 = com.baidu.tieba.imMessageCenter.im.floatwindow.b.azI();
                point = this.dwT.dvO;
                int rawX = ((int) motionEvent.getRawX()) + point.x;
                point2 = this.dwT.dvO;
                azI2.aX(rawX, (((int) motionEvent.getRawY()) - point2.y) - 25);
                break;
        }
        return false;
    }
}
