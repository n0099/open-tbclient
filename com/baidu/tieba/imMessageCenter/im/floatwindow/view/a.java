package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.imMessageCenter.im.floatwindow.a.c;
import com.baidu.tieba.imMessageCenter.im.floatwindow.a.e;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.imMessageCenter.im.floatwindow.g {
    private InterfaceC0068a ctJ;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.e ctO;
    private c.a cuA;
    private e.a cuB;
    private FrameLayout cun;
    private HeadImageView cuo;
    private HeadImageView cup;
    private HeadImageView cuq;
    private HeadImageView cus;
    private TextView cut;
    private Animation cuu;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.e cuv;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.d cuw;
    private Point cux;
    private boolean cuy;
    private Runnable cuz;

    /* renamed from: com.baidu.tieba.imMessageCenter.im.floatwindow.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0068a {
        void ajC();
    }

    public a(Context context) {
        super(LayoutInflater.from(context).inflate(t.h.im_chat_float_window, (ViewGroup) null));
        this.cuy = false;
        this.cuz = new b(this);
        this.cuA = new c(this);
        this.cuB = new d(this);
        this.ctO = new com.baidu.tieba.imMessageCenter.im.floatwindow.e();
        this.cun = (FrameLayout) this.ctV.findViewById(t.g.chat_float_window_wrapper);
        this.cuo = (HeadImageView) this.ctV.findViewById(t.g.chat_float_window_first);
        this.cup = (HeadImageView) this.ctV.findViewById(t.g.chat_float_window_second);
        this.cuq = (HeadImageView) this.ctV.findViewById(t.g.chat_float_window_third);
        this.cus = (HeadImageView) this.ctV.findViewById(t.g.chat_float_window_fourth);
        d(this.cuo);
        d(this.cup);
        d(this.cuq);
        d(this.cus);
        this.cut = (TextView) this.ctV.findViewById(t.g.chat_float_window_text);
        this.cux = new Point();
    }

    private void d(HeadImageView headImageView) {
        headImageView.setAutoChangeStyle(false);
        headImageView.setIsRound(true);
        headImageView.setDefaultBgResource(0);
    }

    public boolean ajQ() {
        return this.cuy;
    }

    public com.baidu.tieba.imMessageCenter.im.floatwindow.e ajD() {
        this.ctO.aA(this.ctV);
        return this.ctO;
    }

    public void a(Handler handler, boolean z) {
        if (!ajF()) {
            ajG();
            if (handler != null && z) {
                handler.post(this.cuz);
            }
        }
    }

    public void a(InterfaceC0068a interfaceC0068a) {
        this.ctJ = interfaceC0068a;
    }

    public void km(int i) {
        int i2;
        if (i <= 0) {
            this.cut.setVisibility(8);
            return;
        }
        this.cut.setVisibility(0);
        if (i < 10) {
            this.cut.setText(String.valueOf(i));
            i2 = t.f.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.cut.setText(String.valueOf(i));
            i2 = t.f.icon_news_head_prompt_two;
        } else {
            this.cut.setText("   ");
            i2 = t.f.icon_news_head_prompt_more;
        }
        this.cut.setBackgroundResource(i2);
    }

    public void ajR() {
        int i;
        int measuredWidth = this.ctV.getMeasuredWidth();
        int i2 = this.ctX.x;
        if ((measuredWidth / 2) + i2 > this.ctR / 2) {
            i = this.ctR - measuredWidth;
        } else {
            i = 0;
        }
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.ajI().a(aD(i2, i));
    }

    public void b(Point point) {
        this.cux.x = this.ctX.x;
        this.cux.y = this.ctX.y;
        this.cuy = true;
        setTouchable(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.ajI().a(c(point));
    }

    public void ajS() {
        int measuredWidth = this.ctV.getMeasuredWidth();
        boolean z = this.cux.x != 0;
        boolean z2 = this.cux.x != this.ctR - measuredWidth;
        if (z && z2) {
            if (this.cux.x > this.ctR / 2) {
                this.cux.x = this.ctR - measuredWidth;
            } else {
                this.cux.x = 0;
            }
        }
        this.cuy = true;
        setTouchable(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.ajI().a(c(this.cux));
    }

    public void J(ArrayList<String> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            kn(size);
            for (int i = 0; i < size; i++) {
                z(i, arrayList.get(i));
            }
        }
    }

    private void z(int i, String str) {
        switch (i) {
            case 0:
                this.cuo.c(str, 12, false);
                return;
            case 1:
                this.cup.c(str, 12, false);
                return;
            case 2:
                this.cuq.c(str, 12, false);
                return;
            case 3:
                this.cus.c(str, 12, false);
                return;
            default:
                return;
        }
    }

    private void kn(int i) {
        this.cuo.setVisibility(i > 0 ? 0 : 8);
        this.cup.setVisibility(i > 1 ? 0 : 8);
        this.cuq.setVisibility(i > 2 ? 0 : 8);
        this.cus.setVisibility(i <= 3 ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation ajT() {
        if (this.cuu == null) {
            this.cuu = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), t.a.float_window_in_anim);
        }
        return this.cuu;
    }

    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.e aD(int i, int i2) {
        if (this.cuv == null) {
            this.cuv = new com.baidu.tieba.imMessageCenter.im.floatwindow.a.e(20);
            this.cuv.a(this.cuB);
        }
        this.cuv.setStart(i);
        this.cuv.kl(i2);
        return this.cuv;
    }

    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.d c(Point point) {
        if (this.cuw == null) {
            this.cuw = new com.baidu.tieba.imMessageCenter.im.floatwindow.a.d(300L);
            this.cuw.a(this.cuA);
        }
        Point point2 = new Point();
        point2.x = this.ctX.x;
        point2.y = this.ctX.y;
        this.cuw.a(point2, point);
        return this.cuw;
    }
}
