package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ h dbk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.dbk = hVar;
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
                point3 = this.dbk.dad;
                point3.x = (int) motionEvent.getX();
                point4 = this.dbk.dad;
                point4.y = (int) motionEvent.getY();
                break;
            case 1:
                this.dbk.dbh = false;
                headImageView = this.dbk.aOV;
                headImageView.setVisibility(0);
                h hVar = this.dbk;
                i = this.dbk.dbg;
                hVar.ls(i);
                com.baidu.tieba.imMessageCenter.im.floatwindow.b arM = com.baidu.tieba.imMessageCenter.im.floatwindow.b.arM();
                aVar = this.dbk.dbi;
                arM.a(aVar);
                break;
            case 2:
                com.baidu.tieba.imMessageCenter.im.floatwindow.b arM2 = com.baidu.tieba.imMessageCenter.im.floatwindow.b.arM();
                point = this.dbk.dad;
                int rawX = ((int) motionEvent.getRawX()) + point.x;
                point2 = this.dbk.dad;
                arM2.aN(rawX, (((int) motionEvent.getRawY()) - point2.y) - 25);
                break;
        }
        return false;
    }
}
