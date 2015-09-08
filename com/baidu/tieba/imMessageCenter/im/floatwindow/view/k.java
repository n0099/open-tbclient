package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ h bJc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.bJc = hVar;
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
                point3 = this.bJc.bHW;
                point3.x = (int) motionEvent.getX();
                point4 = this.bJc.bHW;
                point4.y = (int) motionEvent.getY();
                break;
            case 1:
                this.bJc.bIZ = false;
                headImageView = this.bJc.aIT;
                headImageView.setVisibility(0);
                h hVar = this.bJc;
                i = this.bJc.bIY;
                hVar.hC(i);
                com.baidu.tieba.imMessageCenter.im.floatwindow.b Xz = com.baidu.tieba.imMessageCenter.im.floatwindow.b.Xz();
                aVar = this.bJc.bJa;
                Xz.a(aVar);
                break;
            case 2:
                com.baidu.tieba.imMessageCenter.im.floatwindow.b Xz2 = com.baidu.tieba.imMessageCenter.im.floatwindow.b.Xz();
                point = this.bJc.bHW;
                int rawX = ((int) motionEvent.getRawX()) + point.x;
                point2 = this.bJc.bHW;
                Xz2.ai(rawX, (((int) motionEvent.getRawY()) - point2.y) - 25);
                break;
        }
        return false;
    }
}
