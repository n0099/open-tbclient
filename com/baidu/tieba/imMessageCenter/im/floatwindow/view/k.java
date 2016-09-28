package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ h drm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.drm = hVar;
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
                point3 = this.drm.dqh;
                point3.x = (int) motionEvent.getX();
                point4 = this.drm.dqh;
                point4.y = (int) motionEvent.getY();
                break;
            case 1:
                this.drm.drj = false;
                headImageView = this.drm.aVS;
                headImageView.setVisibility(0);
                h hVar = this.drm;
                i = this.drm.dri;
                hVar.mj(i);
                com.baidu.tieba.imMessageCenter.im.floatwindow.b axL = com.baidu.tieba.imMessageCenter.im.floatwindow.b.axL();
                aVar = this.drm.drk;
                axL.a(aVar);
                break;
            case 2:
                com.baidu.tieba.imMessageCenter.im.floatwindow.b axL2 = com.baidu.tieba.imMessageCenter.im.floatwindow.b.axL();
                point = this.drm.dqh;
                int rawX = ((int) motionEvent.getRawX()) + point.x;
                point2 = this.drm.dqh;
                axL2.aW(rawX, (((int) motionEvent.getRawY()) - point2.y) - 25);
                break;
        }
        return false;
    }
}
