package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ h cuX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.cuX = hVar;
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
                point3 = this.cuX.ctQ;
                point3.x = (int) motionEvent.getX();
                point4 = this.cuX.ctQ;
                point4.y = (int) motionEvent.getY();
                break;
            case 1:
                this.cuX.cuU = false;
                headImageView = this.cuX.aPn;
                headImageView.setVisibility(0);
                h hVar = this.cuX;
                i = this.cuX.cuT;
                hVar.km(i);
                com.baidu.tieba.imMessageCenter.im.floatwindow.b ajq = com.baidu.tieba.imMessageCenter.im.floatwindow.b.ajq();
                aVar = this.cuX.cuV;
                ajq.a(aVar);
                break;
            case 2:
                com.baidu.tieba.imMessageCenter.im.floatwindow.b ajq2 = com.baidu.tieba.imMessageCenter.im.floatwindow.b.ajq();
                point = this.cuX.ctQ;
                int rawX = ((int) motionEvent.getRawX()) + point.x;
                point2 = this.cuX.ctQ;
                ajq2.ax(rawX, (((int) motionEvent.getRawY()) - point2.y) - 25);
                break;
        }
        return false;
    }
}
