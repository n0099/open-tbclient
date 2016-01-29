package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ h ckr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.ckr = hVar;
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
                point3 = this.ckr.cjl;
                point3.x = (int) motionEvent.getX();
                point4 = this.ckr.cjl;
                point4.y = (int) motionEvent.getY();
                break;
            case 1:
                this.ckr.cko = false;
                headImageView = this.ckr.aMs;
                headImageView.setVisibility(0);
                h hVar = this.ckr;
                i = this.ckr.ckn;
                hVar.jG(i);
                com.baidu.tieba.imMessageCenter.im.floatwindow.b afW = com.baidu.tieba.imMessageCenter.im.floatwindow.b.afW();
                aVar = this.ckr.ckp;
                afW.a(aVar);
                break;
            case 2:
                com.baidu.tieba.imMessageCenter.im.floatwindow.b afW2 = com.baidu.tieba.imMessageCenter.im.floatwindow.b.afW();
                point = this.ckr.cjl;
                int rawX = ((int) motionEvent.getRawX()) + point.x;
                point2 = this.ckr.cjl;
                afW2.aA(rawX, (((int) motionEvent.getRawY()) - point2.y) - 25);
                break;
        }
        return false;
    }
}
