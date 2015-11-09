package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ h bMN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.bMN = hVar;
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
                point3 = this.bMN.bLH;
                point3.x = (int) motionEvent.getX();
                point4 = this.bMN.bLH;
                point4.y = (int) motionEvent.getY();
                break;
            case 1:
                this.bMN.bMK = false;
                headImageView = this.bMN.aGQ;
                headImageView.setVisibility(0);
                h hVar = this.bMN;
                i = this.bMN.bMJ;
                hVar.hV(i);
                com.baidu.tieba.imMessageCenter.im.floatwindow.b Yy = com.baidu.tieba.imMessageCenter.im.floatwindow.b.Yy();
                aVar = this.bMN.bML;
                Yy.a(aVar);
                break;
            case 2:
                com.baidu.tieba.imMessageCenter.im.floatwindow.b Yy2 = com.baidu.tieba.imMessageCenter.im.floatwindow.b.Yy();
                point = this.bMN.bLH;
                int rawX = ((int) motionEvent.getRawX()) + point.x;
                point2 = this.bMN.bLH;
                Yy2.al(rawX, (((int) motionEvent.getRawY()) - point2.y) - 25);
                break;
        }
        return false;
    }
}
