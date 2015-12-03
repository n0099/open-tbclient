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
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.imMessageCenter.im.floatwindow.g {
    private InterfaceC0070a caE;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.e caJ;
    private FrameLayout cbj;
    private HeadImageView cbk;
    private HeadImageView cbl;
    private HeadImageView cbm;
    private HeadImageView cbn;
    private TextView cbo;
    private Animation cbp;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.e cbq;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.d cbr;
    private Point cbs;
    private boolean cbt;
    private Runnable cbu;
    private c.a cbv;
    private e.a cbw;

    /* renamed from: com.baidu.tieba.imMessageCenter.im.floatwindow.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0070a {
        void abQ();
    }

    public a(Context context) {
        super(LayoutInflater.from(context).inflate(n.g.im_chat_float_window, (ViewGroup) null));
        this.cbt = false;
        this.cbu = new b(this);
        this.cbv = new c(this);
        this.cbw = new d(this);
        this.caJ = new com.baidu.tieba.imMessageCenter.im.floatwindow.e();
        this.cbj = (FrameLayout) this.caQ.findViewById(n.f.chat_float_window_wrapper);
        this.cbk = (HeadImageView) this.caQ.findViewById(n.f.chat_float_window_first);
        this.cbl = (HeadImageView) this.caQ.findViewById(n.f.chat_float_window_second);
        this.cbm = (HeadImageView) this.caQ.findViewById(n.f.chat_float_window_third);
        this.cbn = (HeadImageView) this.caQ.findViewById(n.f.chat_float_window_fourth);
        d(this.cbk);
        d(this.cbl);
        d(this.cbm);
        d(this.cbn);
        this.cbo = (TextView) this.caQ.findViewById(n.f.chat_float_window_text);
        this.cbs = new Point();
    }

    private void d(HeadImageView headImageView) {
        headImageView.setAutoChangeStyle(false);
        headImageView.setIsRound(true);
        headImageView.setDefaultBgResource(0);
    }

    public boolean ace() {
        return this.cbt;
    }

    public com.baidu.tieba.imMessageCenter.im.floatwindow.e abR() {
        this.caJ.W(this.caQ);
        return this.caJ;
    }

    public void a(Handler handler, boolean z) {
        if (!abT()) {
            abU();
            if (handler != null && z) {
                handler.post(this.cbu);
            }
        }
    }

    public void a(InterfaceC0070a interfaceC0070a) {
        this.caE = interfaceC0070a;
    }

    public void iJ(int i) {
        int i2;
        if (i <= 0) {
            this.cbo.setVisibility(8);
            return;
        }
        this.cbo.setVisibility(0);
        if (i < 10) {
            this.cbo.setText(String.valueOf(i));
            i2 = n.e.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.cbo.setText(String.valueOf(i));
            i2 = n.e.icon_news_head_prompt_two;
        } else {
            this.cbo.setText("   ");
            i2 = n.e.icon_news_head_prompt_more;
        }
        this.cbo.setBackgroundResource(i2);
    }

    public void acf() {
        int i;
        int measuredWidth = this.caQ.getMeasuredWidth();
        int i2 = this.caS.x;
        if ((measuredWidth / 2) + i2 > this.caM / 2) {
            i = this.caM - measuredWidth;
        } else {
            i = 0;
        }
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.abW().a(at(i2, i));
    }

    public void b(Point point) {
        this.cbs.x = this.caS.x;
        this.cbs.y = this.caS.y;
        this.cbt = true;
        setTouchable(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.abW().a(c(point));
    }

    public void acg() {
        int measuredWidth = this.caQ.getMeasuredWidth();
        boolean z = this.cbs.x != 0;
        boolean z2 = this.cbs.x != this.caM - measuredWidth;
        if (z && z2) {
            if (this.cbs.x > this.caM / 2) {
                this.cbs.x = this.caM - measuredWidth;
            } else {
                this.cbs.x = 0;
            }
        }
        this.cbt = true;
        setTouchable(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.abW().a(c(this.cbs));
    }

    public void K(ArrayList<String> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            iK(size);
            for (int i = 0; i < size; i++) {
                F(i, arrayList.get(i));
            }
        }
    }

    private void F(int i, String str) {
        switch (i) {
            case 0:
                this.cbk.d(str, 12, false);
                return;
            case 1:
                this.cbl.d(str, 12, false);
                return;
            case 2:
                this.cbm.d(str, 12, false);
                return;
            case 3:
                this.cbn.d(str, 12, false);
                return;
            default:
                return;
        }
    }

    private void iK(int i) {
        this.cbk.setVisibility(i > 0 ? 0 : 8);
        this.cbl.setVisibility(i > 1 ? 0 : 8);
        this.cbm.setVisibility(i > 2 ? 0 : 8);
        this.cbn.setVisibility(i <= 3 ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation ach() {
        if (this.cbp == null) {
            this.cbp = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), n.a.float_window_in_anim);
        }
        return this.cbp;
    }

    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.e at(int i, int i2) {
        if (this.cbq == null) {
            this.cbq = new com.baidu.tieba.imMessageCenter.im.floatwindow.a.e(20);
            this.cbq.a(this.cbw);
        }
        this.cbq.setStart(i);
        this.cbq.iI(i2);
        return this.cbq;
    }

    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.d c(Point point) {
        if (this.cbr == null) {
            this.cbr = new com.baidu.tieba.imMessageCenter.im.floatwindow.a.d(300L);
            this.cbr.a(this.cbv);
        }
        Point point2 = new Point();
        point2.x = this.caS.x;
        point2.y = this.caS.y;
        this.cbr.a(point2, point);
        return this.cbr;
    }
}
