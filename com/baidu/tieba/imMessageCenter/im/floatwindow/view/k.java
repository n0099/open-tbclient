package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ h bMh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.bMh = hVar;
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
                point3 = this.bMh.bLb;
                point3.x = (int) motionEvent.getX();
                point4 = this.bMh.bLb;
                point4.y = (int) motionEvent.getY();
                break;
            case 1:
                this.bMh.bMe = false;
                headImageView = this.bMh.aHL;
                headImageView.setVisibility(0);
                h hVar = this.bMh;
                i = this.bMh.bMd;
                hVar.hI(i);
                com.baidu.tieba.imMessageCenter.im.floatwindow.b Yh = com.baidu.tieba.imMessageCenter.im.floatwindow.b.Yh();
                aVar = this.bMh.bMf;
                Yh.a(aVar);
                break;
            case 2:
                com.baidu.tieba.imMessageCenter.im.floatwindow.b Yh2 = com.baidu.tieba.imMessageCenter.im.floatwindow.b.Yh();
                point = this.bMh.bLb;
                int rawX = ((int) motionEvent.getRawX()) + point.x;
                point2 = this.bMh.bLb;
                Yh2.aj(rawX, (((int) motionEvent.getRawY()) - point2.y) - 25);
                break;
        }
        return false;
    }
}
