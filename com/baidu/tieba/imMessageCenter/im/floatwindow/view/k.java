package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    final /* synthetic */ h dpP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.dpP = hVar;
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
                point3 = this.dpP.doJ;
                point3.x = (int) motionEvent.getX();
                point4 = this.dpP.doJ;
                point4.y = (int) motionEvent.getY();
                break;
            case 1:
                this.dpP.dpM = false;
                headImageView = this.dpP.aVj;
                headImageView.setVisibility(0);
                h hVar = this.dpP;
                i = this.dpP.dpL;
                hVar.mb(i);
                com.baidu.tieba.imMessageCenter.im.floatwindow.b axm = com.baidu.tieba.imMessageCenter.im.floatwindow.b.axm();
                aVar = this.dpP.dpN;
                axm.a(aVar);
                break;
            case 2:
                com.baidu.tieba.imMessageCenter.im.floatwindow.b axm2 = com.baidu.tieba.imMessageCenter.im.floatwindow.b.axm();
                point = this.dpP.doJ;
                int rawX = ((int) motionEvent.getRawX()) + point.x;
                point2 = this.dpP.doJ;
                axm2.aU(rawX, (((int) motionEvent.getRawY()) - point2.y) - 25);
                break;
        }
        return false;
    }
}
