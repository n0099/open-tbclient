package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
class t implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LabelActivity f1735a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(LabelActivity labelActivity) {
        this.f1735a = labelActivity;
    }

    /* JADX WARN: Incorrect condition in loop: B:12:0x004c */
    /* JADX WARN: Incorrect condition in loop: B:32:0x00ed */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(Message message) {
        View view;
        View view2;
        View view3;
        Animation animation;
        List list;
        Handler handler;
        List list2;
        long j;
        List list3;
        List list4;
        Handler handler2;
        Handler handler3;
        List list5;
        boolean a2;
        List list6;
        List list7;
        Handler handler4;
        List list8;
        long j2;
        List list9;
        Handler handler5;
        Handler handler6;
        Handler handler7;
        List list10;
        boolean z;
        boolean a3;
        List list11;
        switch (message.what) {
            case 0:
                com.baidu.tieba.util.aj.b("Message-----MSG_BIG_MOVING");
                list7 = this.f1735a.k;
                if (list7 != null) {
                    list8 = this.f1735a.k;
                    if (list8.size() != 0) {
                        long currentTimeMillis = System.currentTimeMillis();
                        j2 = this.f1735a.E;
                        long j3 = currentTimeMillis - j2;
                        this.f1735a.E = currentTimeMillis;
                        int i = 0;
                        boolean z2 = false;
                        while (i < list9.size()) {
                            list10 = this.f1735a.k;
                            com.baidu.tieba.view.as asVar = (com.baidu.tieba.view.as) list10.get(i);
                            if (asVar.getTag(R.id.label_ball_state) == null) {
                                z = z2;
                            } else if (((Integer) asVar.getTag(R.id.label_ball_state)).intValue() != 1) {
                                z = z2;
                            } else {
                                asVar.setAnimation(null);
                                a3 = this.f1735a.a(asVar, j3);
                                if (a3) {
                                    list11 = this.f1735a.k;
                                    list11.remove(i);
                                    i--;
                                    z = true;
                                } else {
                                    z = true;
                                }
                            }
                            i++;
                            z2 = z;
                        }
                        if (z2) {
                            handler6 = this.f1735a.P;
                            handler7 = this.f1735a.P;
                            handler6.sendMessageDelayed(handler7.obtainMessage(0), 5L);
                            break;
                        } else {
                            handler5 = this.f1735a.P;
                            handler5.removeMessages(0);
                            break;
                        }
                    }
                }
                handler4 = this.f1735a.P;
                handler4.removeMessages(0);
                break;
            case 1:
                com.baidu.tieba.util.aj.b("Message-----MSG_SMALL_MOVING");
                list = this.f1735a.n;
                if (list != null) {
                    list2 = this.f1735a.n;
                    if (list2.size() != 0) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        j = this.f1735a.F;
                        long j4 = currentTimeMillis2 - j;
                        this.f1735a.F = currentTimeMillis2;
                        int i2 = 0;
                        while (i2 < list3.size()) {
                            LabelActivity labelActivity = this.f1735a;
                            list5 = this.f1735a.n;
                            a2 = labelActivity.a((com.baidu.tieba.view.as) list5.get(i2), j4);
                            if (a2) {
                                list6 = this.f1735a.n;
                                list6.remove(i2);
                                i2--;
                            }
                            i2++;
                        }
                        list4 = this.f1735a.n;
                        if (list4.size() != 0) {
                            handler2 = this.f1735a.P;
                            handler3 = this.f1735a.P;
                            handler2.sendMessageDelayed(handler3.obtainMessage(1), 2L);
                            break;
                        }
                        break;
                    }
                }
                handler = this.f1735a.P;
                handler.removeMessages(1);
                break;
            case 2:
                view = this.f1735a.o;
                if (view != null) {
                    view2 = this.f1735a.o;
                    view2.setAnimation(null);
                    view3 = this.f1735a.o;
                    animation = this.f1735a.y;
                    view3.startAnimation(animation);
                    break;
                }
                break;
        }
        return false;
    }
}
