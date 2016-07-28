package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ h deh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.deh = hVar;
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
                point3 = this.deh.ddb;
                point3.x = (int) motionEvent.getX();
                point4 = this.deh.ddb;
                point4.y = (int) motionEvent.getY();
                break;
            case 1:
                this.deh.dee = false;
                headImageView = this.deh.aPP;
                headImageView.setVisibility(0);
                h hVar = this.deh;
                i = this.deh.ded;
                hVar.ly(i);
                com.baidu.tieba.imMessageCenter.im.floatwindow.b asy = com.baidu.tieba.imMessageCenter.im.floatwindow.b.asy();
                aVar = this.deh.def;
                asy.a(aVar);
                break;
            case 2:
                com.baidu.tieba.imMessageCenter.im.floatwindow.b asy2 = com.baidu.tieba.imMessageCenter.im.floatwindow.b.asy();
                point = this.deh.ddb;
                int rawX = ((int) motionEvent.getRawX()) + point.x;
                point2 = this.deh.ddb;
                asy2.aQ(rawX, (((int) motionEvent.getRawY()) - point2.y) - 25);
                break;
        }
        return false;
    }
}
