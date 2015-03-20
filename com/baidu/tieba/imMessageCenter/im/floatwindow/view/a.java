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
    private Runnable atA;
    private FrameLayout bqV;
    private HeadImageView bqW;
    private HeadImageView bqX;
    private HeadImageView bqY;
    private HeadImageView bqZ;
    private e bqq;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.j bqv;
    private TextView bra;
    private Animation brb;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.g brc;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.f brd;
    private Point bre;
    private boolean brf;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.e brg;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.h brh;

    public a(Context context) {
        super(com.baidu.adp.lib.g.b.hH().inflate(context, com.baidu.tieba.w.im_chat_float_window, null));
        this.brf = false;
        this.atA = new b(this);
        this.brg = new c(this);
        this.brh = new d(this);
        this.bqv = new com.baidu.tieba.imMessageCenter.im.floatwindow.j();
        this.bqV = (FrameLayout) this.bqC.findViewById(com.baidu.tieba.v.chat_float_window_wrapper);
        this.bqW = (HeadImageView) this.bqC.findViewById(com.baidu.tieba.v.chat_float_window_first);
        this.bqX = (HeadImageView) this.bqC.findViewById(com.baidu.tieba.v.chat_float_window_second);
        this.bqY = (HeadImageView) this.bqC.findViewById(com.baidu.tieba.v.chat_float_window_third);
        this.bqZ = (HeadImageView) this.bqC.findViewById(com.baidu.tieba.v.chat_float_window_fourth);
        d(this.bqW);
        d(this.bqX);
        d(this.bqY);
        d(this.bqZ);
        this.bra = (TextView) this.bqC.findViewById(com.baidu.tieba.v.chat_float_window_text);
        this.bre = new Point();
    }

    private void d(HeadImageView headImageView) {
        headImageView.setAutoChangeStyle(false);
        headImageView.setIsRound(true);
        headImageView.setDefaultBgResource(0);
    }

    public boolean UL() {
        return this.brf;
    }

    public com.baidu.tieba.imMessageCenter.im.floatwindow.j Uy() {
        this.bqv.G(this.bqC);
        return this.bqv;
    }

    public void a(Handler handler, boolean z) {
        if (!UA()) {
            UB();
            if (handler != null && z) {
                handler.post(this.atA);
            }
        }
    }

    public void a(e eVar) {
        this.bqq = eVar;
    }

    public void gv(int i) {
        int i2;
        if (i <= 0) {
            this.bra.setVisibility(8);
            return;
        }
        this.bra.setVisibility(0);
        if (i < 10) {
            this.bra.setText(String.valueOf(i));
            i2 = com.baidu.tieba.u.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.bra.setText(String.valueOf(i));
            i2 = com.baidu.tieba.u.icon_news_head_prompt_two;
        } else {
            this.bra.setText("   ");
            i2 = com.baidu.tieba.u.icon_news_head_prompt_more;
        }
        this.bra.setBackgroundResource(i2);
    }

    public void UM() {
        int i;
        int measuredWidth = this.bqC.getMeasuredWidth();
        int i2 = this.bqE.x;
        if ((measuredWidth / 2) + i2 > this.bqy / 2) {
            i = this.bqy - measuredWidth;
        } else {
            i = 0;
        }
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.UD().a(Z(i2, i));
    }

    public void b(Point point) {
        this.bre.x = this.bqE.x;
        this.bre.y = this.bqE.y;
        this.brf = true;
        setTouchable(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.UD().a(c(point));
    }

    public void UN() {
        int measuredWidth = this.bqC.getMeasuredWidth();
        boolean z = this.bre.x != 0;
        boolean z2 = this.bre.x != this.bqy - measuredWidth;
        if (z && z2) {
            if (this.bre.x > this.bqy / 2) {
                this.bre.x = this.bqy - measuredWidth;
            } else {
                this.bre.x = 0;
            }
        }
        this.brf = true;
        setTouchable(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.UD().a(c(this.bre));
    }

    public void z(ArrayList<String> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            gw(size);
            for (int i = 0; i < size; i++) {
                w(i, arrayList.get(i));
            }
        }
    }

    private void w(int i, String str) {
        switch (i) {
            case 0:
                this.bqW.c(str, 12, false);
                return;
            case 1:
                this.bqX.c(str, 12, false);
                return;
            case 2:
                this.bqY.c(str, 12, false);
                return;
            case 3:
                this.bqZ.c(str, 12, false);
                return;
            default:
                return;
        }
    }

    private void gw(int i) {
        this.bqW.setVisibility(i > 0 ? 0 : 8);
        this.bqX.setVisibility(i > 1 ? 0 : 8);
        this.bqY.setVisibility(i > 2 ? 0 : 8);
        this.bqZ.setVisibility(i <= 3 ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation UO() {
        if (this.brb == null) {
            this.brb = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), com.baidu.tieba.p.float_window_in_anim);
        }
        return this.brb;
    }

    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.g Z(int i, int i2) {
        if (this.brc == null) {
            this.brc = new com.baidu.tieba.imMessageCenter.im.floatwindow.a.g(20);
            this.brc.a(this.brh);
        }
        this.brc.setStart(i);
        this.brc.gu(i2);
        return this.brc;
    }

    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.f c(Point point) {
        if (this.brd == null) {
            this.brd = new com.baidu.tieba.imMessageCenter.im.floatwindow.a.f(300L);
            this.brd.a(this.brg);
        }
        Point point2 = new Point();
        point2.x = this.bqE.x;
        point2.y = this.bqE.y;
        this.brd.a(point2, point);
        return this.brd;
    }
}
