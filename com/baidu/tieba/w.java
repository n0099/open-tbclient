package com.baidu.tieba;

import android.os.Handler;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
/* loaded from: classes.dex */
class w implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    boolean f1853a = true;
    final /* synthetic */ LabelActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(LabelActivity labelActivity) {
        this.b = labelActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Handler handler;
        Animation animation;
        Handler handler2;
        Vibrator vibrator;
        Handler handler3;
        Handler handler4;
        switch (motionEvent.getAction()) {
            case 0:
                this.f1853a = true;
                this.b.o = view;
                handler3 = this.b.P;
                handler4 = this.b.P;
                handler3.sendMessageDelayed(handler4.obtainMessage(2), 200L);
                break;
            case 1:
                if (this.f1853a) {
                    if (view instanceof com.baidu.tieba.view.as) {
                        vibrator = this.b.u;
                        vibrator.vibrate(100L);
                        if (((com.baidu.tieba.view.as) view).getType() == 0) {
                            this.b.a(view);
                        } else {
                            this.b.startDropSmallBall(view);
                        }
                    }
                    handler2 = this.b.P;
                    handler2.removeMessages(2);
                    view.setAnimation(null);
                    this.b.o = null;
                    break;
                } else {
                    return false;
                }
            case 3:
            case 4:
                handler = this.b.P;
                handler.removeMessages(2);
                view.setAnimation(null);
                if ((view instanceof com.baidu.tieba.view.as) && ((com.baidu.tieba.view.as) view).getType() == 0) {
                    animation = this.b.w;
                    view.setAnimation(animation);
                }
                this.f1853a = false;
                break;
        }
        return true;
    }
}
