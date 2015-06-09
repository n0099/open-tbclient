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
    private FrameLayout btW;
    private HeadImageView btX;
    private HeadImageView btY;
    private HeadImageView btZ;
    private e btr;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.j btw;
    private HeadImageView bua;
    private TextView bub;
    private Animation buc;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.g bud;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.f bue;
    private Point bug;
    private boolean buh;
    private Runnable bui;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.e buj;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.h buk;

    public a(Context context) {
        super(com.baidu.adp.lib.g.b.hr().inflate(context, com.baidu.tieba.r.im_chat_float_window, null));
        this.buh = false;
        this.bui = new b(this);
        this.buj = new c(this);
        this.buk = new d(this);
        this.btw = new com.baidu.tieba.imMessageCenter.im.floatwindow.j();
        this.btW = (FrameLayout) this.btD.findViewById(com.baidu.tieba.q.chat_float_window_wrapper);
        this.btX = (HeadImageView) this.btD.findViewById(com.baidu.tieba.q.chat_float_window_first);
        this.btY = (HeadImageView) this.btD.findViewById(com.baidu.tieba.q.chat_float_window_second);
        this.btZ = (HeadImageView) this.btD.findViewById(com.baidu.tieba.q.chat_float_window_third);
        this.bua = (HeadImageView) this.btD.findViewById(com.baidu.tieba.q.chat_float_window_fourth);
        d(this.btX);
        d(this.btY);
        d(this.btZ);
        d(this.bua);
        this.bub = (TextView) this.btD.findViewById(com.baidu.tieba.q.chat_float_window_text);
        this.bug = new Point();
    }

    private void d(HeadImageView headImageView) {
        headImageView.setAutoChangeStyle(false);
        headImageView.setIsRound(true);
        headImageView.setDefaultBgResource(0);
    }

    public boolean Wq() {
        return this.buh;
    }

    public com.baidu.tieba.imMessageCenter.im.floatwindow.j Wd() {
        this.btw.J(this.btD);
        return this.btw;
    }

    public void a(Handler handler, boolean z) {
        if (!Wf()) {
            Wg();
            if (handler != null && z) {
                handler.post(this.bui);
            }
        }
    }

    public void a(e eVar) {
        this.btr = eVar;
    }

    public void gO(int i) {
        int i2;
        if (i <= 0) {
            this.bub.setVisibility(8);
            return;
        }
        this.bub.setVisibility(0);
        if (i < 10) {
            this.bub.setText(String.valueOf(i));
            i2 = com.baidu.tieba.p.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.bub.setText(String.valueOf(i));
            i2 = com.baidu.tieba.p.icon_news_head_prompt_two;
        } else {
            this.bub.setText("   ");
            i2 = com.baidu.tieba.p.icon_news_head_prompt_more;
        }
        this.bub.setBackgroundResource(i2);
    }

    public void Wr() {
        int i;
        int measuredWidth = this.btD.getMeasuredWidth();
        int i2 = this.btF.x;
        if ((measuredWidth / 2) + i2 > this.btz / 2) {
            i = this.btz - measuredWidth;
        } else {
            i = 0;
        }
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.Wi().a(ab(i2, i));
    }

    public void b(Point point) {
        this.bug.x = this.btF.x;
        this.bug.y = this.btF.y;
        this.buh = true;
        setTouchable(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.Wi().a(c(point));
    }

    public void Ws() {
        int measuredWidth = this.btD.getMeasuredWidth();
        boolean z = this.bug.x != 0;
        boolean z2 = this.bug.x != this.btz - measuredWidth;
        if (z && z2) {
            if (this.bug.x > this.btz / 2) {
                this.bug.x = this.btz - measuredWidth;
            } else {
                this.bug.x = 0;
            }
        }
        this.buh = true;
        setTouchable(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.Wi().a(c(this.bug));
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
                this.btX.c(str, 12, false);
                return;
            case 1:
                this.btY.c(str, 12, false);
                return;
            case 2:
                this.btZ.c(str, 12, false);
                return;
            case 3:
                this.bua.c(str, 12, false);
                return;
            default:
                return;
        }
    }

    private void gP(int i) {
        this.btX.setVisibility(i > 0 ? 0 : 8);
        this.btY.setVisibility(i > 1 ? 0 : 8);
        this.btZ.setVisibility(i > 2 ? 0 : 8);
        this.bua.setVisibility(i <= 3 ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation Wt() {
        if (this.buc == null) {
            this.buc = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), com.baidu.tieba.k.float_window_in_anim);
        }
        return this.buc;
    }

    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.g ab(int i, int i2) {
        if (this.bud == null) {
            this.bud = new com.baidu.tieba.imMessageCenter.im.floatwindow.a.g(20);
            this.bud.a(this.buk);
        }
        this.bud.setStart(i);
        this.bud.gN(i2);
        return this.bud;
    }

    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.f c(Point point) {
        if (this.bue == null) {
            this.bue = new com.baidu.tieba.imMessageCenter.im.floatwindow.a.f(300L);
            this.bue.a(this.buj);
        }
        Point point2 = new Point();
        point2.x = this.btF.x;
        point2.y = this.btF.y;
        this.bue.a(point2, point);
        return this.bue;
    }
}
