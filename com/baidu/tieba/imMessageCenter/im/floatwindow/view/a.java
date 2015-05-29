package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.imMessageCenter.im.floatwindow.l {
    private FrameLayout btV;
    private HeadImageView btW;
    private HeadImageView btX;
    private HeadImageView btY;
    private HeadImageView btZ;
    private e btq;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.j btv;
    private TextView bua;
    private Animation bub;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.g buc;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.f bud;
    private Point bue;
    private boolean bug;
    private Runnable buh;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.e bui;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.h buj;

    public a(Context context) {
        super(com.baidu.adp.lib.g.b.hr().inflate(context, com.baidu.tieba.r.im_chat_float_window, null));
        this.bug = false;
        this.buh = new b(this);
        this.bui = new c(this);
        this.buj = new d(this);
        this.btv = new com.baidu.tieba.imMessageCenter.im.floatwindow.j();
        this.btV = (FrameLayout) this.btC.findViewById(com.baidu.tieba.q.chat_float_window_wrapper);
        this.btW = (HeadImageView) this.btC.findViewById(com.baidu.tieba.q.chat_float_window_first);
        this.btX = (HeadImageView) this.btC.findViewById(com.baidu.tieba.q.chat_float_window_second);
        this.btY = (HeadImageView) this.btC.findViewById(com.baidu.tieba.q.chat_float_window_third);
        this.btZ = (HeadImageView) this.btC.findViewById(com.baidu.tieba.q.chat_float_window_fourth);
        d(this.btW);
        d(this.btX);
        d(this.btY);
        d(this.btZ);
        this.bua = (TextView) this.btC.findViewById(com.baidu.tieba.q.chat_float_window_text);
        this.bue = new Point();
    }

    private void d(HeadImageView headImageView) {
        headImageView.setAutoChangeStyle(false);
        headImageView.setIsRound(true);
        headImageView.setDefaultBgResource(0);
    }

    public boolean Wp() {
        return this.bug;
    }

    public com.baidu.tieba.imMessageCenter.im.floatwindow.j Wc() {
        this.btv.J(this.btC);
        return this.btv;
    }

    public void a(Handler handler, boolean z) {
        if (!We()) {
            Wf();
            if (handler != null && z) {
                handler.post(this.buh);
            }
        }
    }

    public void a(e eVar) {
        this.btq = eVar;
    }

    public void gO(int i) {
        int i2;
        if (i <= 0) {
            this.bua.setVisibility(8);
            return;
        }
        this.bua.setVisibility(0);
        if (i < 10) {
            this.bua.setText(String.valueOf(i));
            i2 = com.baidu.tieba.p.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.bua.setText(String.valueOf(i));
            i2 = com.baidu.tieba.p.icon_news_head_prompt_two;
        } else {
            this.bua.setText("   ");
            i2 = com.baidu.tieba.p.icon_news_head_prompt_more;
        }
        this.bua.setBackgroundResource(i2);
    }

    public void Wq() {
        int i;
        int measuredWidth = this.btC.getMeasuredWidth();
        int i2 = this.btE.x;
        if ((measuredWidth / 2) + i2 > this.bty / 2) {
            i = this.bty - measuredWidth;
        } else {
            i = 0;
        }
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.Wh().a(ab(i2, i));
    }

    public void b(Point point) {
        this.bue.x = this.btE.x;
        this.bue.y = this.btE.y;
        this.bug = true;
        setTouchable(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.Wh().a(c(point));
    }

    public void Wr() {
        int measuredWidth = this.btC.getMeasuredWidth();
        boolean z = this.bue.x != 0;
        boolean z2 = this.bue.x != this.bty - measuredWidth;
        if (z && z2) {
            if (this.bue.x > this.bty / 2) {
                this.bue.x = this.bty - measuredWidth;
            } else {
                this.bue.x = 0;
            }
        }
        this.bug = true;
        setTouchable(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.Wh().a(c(this.bue));
    }

    public void z(ArrayList<String> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            gP(size);
            for (int i = 0; i < size; i++) {
                x(i, arrayList.get(i));
            }
        }
    }

    private void x(int i, String str) {
        switch (i) {
            case 0:
                this.btW.c(str, 12, false);
                return;
            case 1:
                this.btX.c(str, 12, false);
                return;
            case 2:
                this.btY.c(str, 12, false);
                return;
            case 3:
                this.btZ.c(str, 12, false);
                return;
            default:
                return;
        }
    }

    private void gP(int i) {
        this.btW.setVisibility(i > 0 ? 0 : 8);
        this.btX.setVisibility(i > 1 ? 0 : 8);
        this.btY.setVisibility(i > 2 ? 0 : 8);
        this.btZ.setVisibility(i <= 3 ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation Ws() {
        if (this.bub == null) {
            this.bub = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), com.baidu.tieba.k.float_window_in_anim);
        }
        return this.bub;
    }

    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.g ab(int i, int i2) {
        if (this.buc == null) {
            this.buc = new com.baidu.tieba.imMessageCenter.im.floatwindow.a.g(20);
            this.buc.a(this.buj);
        }
        this.buc.setStart(i);
        this.buc.gN(i2);
        return this.buc;
    }

    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.f c(Point point) {
        if (this.bud == null) {
            this.bud = new com.baidu.tieba.imMessageCenter.im.floatwindow.a.f(300L);
            this.bud.a(this.bui);
        }
        Point point2 = new Point();
        point2.x = this.btE.x;
        point2.y = this.btE.y;
        this.bud.a(point2, point);
        return this.bud;
    }
}
