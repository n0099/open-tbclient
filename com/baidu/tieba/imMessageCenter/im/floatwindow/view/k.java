package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ h bMs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.bMs = hVar;
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
                point3 = this.bMs.bLm;
                point3.x = (int) motionEvent.getX();
                point4 = this.bMs.bLm;
                point4.y = (int) motionEvent.getY();
                break;
            case 1:
                this.bMs.bMp = false;
                headImageView = this.bMs.aHW;
                headImageView.setVisibility(0);
                h hVar = this.bMs;
                i = this.bMs.bMo;
                hVar.hI(i);
                com.baidu.tieba.imMessageCenter.im.floatwindow.b Yd = com.baidu.tieba.imMessageCenter.im.floatwindow.b.Yd();
                aVar = this.bMs.bMq;
                Yd.a(aVar);
                break;
            case 2:
                com.baidu.tieba.imMessageCenter.im.floatwindow.b Yd2 = com.baidu.tieba.imMessageCenter.im.floatwindow.b.Yd();
                point = this.bMs.bLm;
                int rawX = ((int) motionEvent.getRawX()) + point.x;
                point2 = this.bMs.bLm;
                Yd2.aj(rawX, (((int) motionEvent.getRawY()) - point2.y) - 25);
                break;
        }
        return false;
    }
}
