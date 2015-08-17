package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ h bIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.bIv = hVar;
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
                point3 = this.bIv.bHp;
                point3.x = (int) motionEvent.getX();
                point4 = this.bIv.bHp;
                point4.y = (int) motionEvent.getY();
                break;
            case 1:
                this.bIv.bIs = false;
                headImageView = this.bIv.aIG;
                headImageView.setVisibility(0);
                h hVar = this.bIv;
                i = this.bIv.bIr;
                hVar.hs(i);
                com.baidu.tieba.imMessageCenter.im.floatwindow.b Xx = com.baidu.tieba.imMessageCenter.im.floatwindow.b.Xx();
                aVar = this.bIv.bIt;
                Xx.a(aVar);
                break;
            case 2:
                com.baidu.tieba.imMessageCenter.im.floatwindow.b Xx2 = com.baidu.tieba.imMessageCenter.im.floatwindow.b.Xx();
                point = this.bIv.bHp;
                int rawX = ((int) motionEvent.getRawX()) + point.x;
                point2 = this.bIv.bHp;
                Xx2.ai(rawX, (((int) motionEvent.getRawY()) - point2.y) - 25);
                break;
        }
        return false;
    }
}
