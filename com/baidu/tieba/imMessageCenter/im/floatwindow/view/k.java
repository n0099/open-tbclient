package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ h cfR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.cfR = hVar;
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
                point3 = this.cfR.ceM;
                point3.x = (int) motionEvent.getX();
                point4 = this.cfR.ceM;
                point4.y = (int) motionEvent.getY();
                break;
            case 1:
                this.cfR.cfO = false;
                headImageView = this.cfR.aLn;
                headImageView.setVisibility(0);
                h hVar = this.cfR;
                i = this.cfR.cfN;
                hVar.ji(i);
                com.baidu.tieba.imMessageCenter.im.floatwindow.b acN = com.baidu.tieba.imMessageCenter.im.floatwindow.b.acN();
                aVar = this.cfR.cfP;
                acN.a(aVar);
                break;
            case 2:
                com.baidu.tieba.imMessageCenter.im.floatwindow.b acN2 = com.baidu.tieba.imMessageCenter.im.floatwindow.b.acN();
                point = this.cfR.ceM;
                int rawX = ((int) motionEvent.getRawX()) + point.x;
                point2 = this.cfR.ceM;
                acN2.az(rawX, (((int) motionEvent.getRawY()) - point2.y) - 25);
                break;
        }
        return false;
    }
}
