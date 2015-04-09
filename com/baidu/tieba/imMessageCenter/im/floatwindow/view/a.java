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
    private Runnable atI;
    private e bqG;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.j bqL;
    private FrameLayout brl;
    private HeadImageView brm;
    private HeadImageView brn;
    private HeadImageView bro;
    private HeadImageView brp;
    private TextView brq;
    private Animation brr;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.g brs;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.f brt;
    private Point bru;
    private boolean brv;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.e brw;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.h brx;

    public a(Context context) {
        super(com.baidu.adp.lib.g.b.hH().inflate(context, com.baidu.tieba.w.im_chat_float_window, null));
        this.brv = false;
        this.atI = new b(this);
        this.brw = new c(this);
        this.brx = new d(this);
        this.bqL = new com.baidu.tieba.imMessageCenter.im.floatwindow.j();
        this.brl = (FrameLayout) this.bqS.findViewById(com.baidu.tieba.v.chat_float_window_wrapper);
        this.brm = (HeadImageView) this.bqS.findViewById(com.baidu.tieba.v.chat_float_window_first);
        this.brn = (HeadImageView) this.bqS.findViewById(com.baidu.tieba.v.chat_float_window_second);
        this.bro = (HeadImageView) this.bqS.findViewById(com.baidu.tieba.v.chat_float_window_third);
        this.brp = (HeadImageView) this.bqS.findViewById(com.baidu.tieba.v.chat_float_window_fourth);
        d(this.brm);
        d(this.brn);
        d(this.bro);
        d(this.brp);
        this.brq = (TextView) this.bqS.findViewById(com.baidu.tieba.v.chat_float_window_text);
        this.bru = new Point();
    }

    private void d(HeadImageView headImageView) {
        headImageView.setAutoChangeStyle(false);
        headImageView.setIsRound(true);
        headImageView.setDefaultBgResource(0);
    }

    public boolean UY() {
        return this.brv;
    }

    public com.baidu.tieba.imMessageCenter.im.floatwindow.j UL() {
        this.bqL.G(this.bqS);
        return this.bqL;
    }

    public void a(Handler handler, boolean z) {
        if (!UN()) {
            UO();
            if (handler != null && z) {
                handler.post(this.atI);
            }
        }
    }

    public void a(e eVar) {
        this.bqG = eVar;
    }

    public void gx(int i) {
        int i2;
        if (i <= 0) {
            this.brq.setVisibility(8);
            return;
        }
        this.brq.setVisibility(0);
        if (i < 10) {
            this.brq.setText(String.valueOf(i));
            i2 = com.baidu.tieba.u.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.brq.setText(String.valueOf(i));
            i2 = com.baidu.tieba.u.icon_news_head_prompt_two;
        } else {
            this.brq.setText("   ");
            i2 = com.baidu.tieba.u.icon_news_head_prompt_more;
        }
        this.brq.setBackgroundResource(i2);
    }

    public void UZ() {
        int i;
        int measuredWidth = this.bqS.getMeasuredWidth();
        int i2 = this.bqU.x;
        if ((measuredWidth / 2) + i2 > this.bqO / 2) {
            i = this.bqO - measuredWidth;
        } else {
            i = 0;
        }
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.UQ().a(Z(i2, i));
    }

    public void b(Point point) {
        this.bru.x = this.bqU.x;
        this.bru.y = this.bqU.y;
        this.brv = true;
        setTouchable(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.UQ().a(c(point));
    }

    public void Va() {
        int measuredWidth = this.bqS.getMeasuredWidth();
        boolean z = this.bru.x != 0;
        boolean z2 = this.bru.x != this.bqO - measuredWidth;
        if (z && z2) {
            if (this.bru.x > this.bqO / 2) {
                this.bru.x = this.bqO - measuredWidth;
            } else {
                this.bru.x = 0;
            }
        }
        this.brv = true;
        setTouchable(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.UQ().a(c(this.bru));
    }

    public void A(ArrayList<String> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            gy(size);
            for (int i = 0; i < size; i++) {
                w(i, arrayList.get(i));
            }
        }
    }

    private void w(int i, String str) {
        switch (i) {
            case 0:
                this.brm.c(str, 12, false);
                return;
            case 1:
                this.brn.c(str, 12, false);
                return;
            case 2:
                this.bro.c(str, 12, false);
                return;
            case 3:
                this.brp.c(str, 12, false);
                return;
            default:
                return;
        }
    }

    private void gy(int i) {
        this.brm.setVisibility(i > 0 ? 0 : 8);
        this.brn.setVisibility(i > 1 ? 0 : 8);
        this.bro.setVisibility(i > 2 ? 0 : 8);
        this.brp.setVisibility(i <= 3 ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation Vb() {
        if (this.brr == null) {
            this.brr = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), com.baidu.tieba.p.float_window_in_anim);
        }
        return this.brr;
    }

    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.g Z(int i, int i2) {
        if (this.brs == null) {
            this.brs = new com.baidu.tieba.imMessageCenter.im.floatwindow.a.g(20);
            this.brs.a(this.brx);
        }
        this.brs.setStart(i);
        this.brs.gw(i2);
        return this.brs;
    }

    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.f c(Point point) {
        if (this.brt == null) {
            this.brt = new com.baidu.tieba.imMessageCenter.im.floatwindow.a.f(300L);
            this.brt.a(this.brw);
        }
        Point point2 = new Point();
        point2.x = this.bqU.x;
        point2.y = this.bqU.y;
        this.brt.a(point2, point);
        return this.brt;
    }
}
