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
    private InterfaceC0062a cuH;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.e cuM;
    private FrameLayout cvl;
    private HeadImageView cvm;
    private HeadImageView cvn;
    private HeadImageView cvo;
    private HeadImageView cvp;
    private TextView cvq;
    private Animation cvr;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.e cvs;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.d cvt;
    private Point cvu;
    private boolean cvv;
    private Runnable cvw;
    private c.a cvx;
    private e.a cvy;

    /* renamed from: com.baidu.tieba.imMessageCenter.im.floatwindow.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0062a {
        void ajI();
    }

    public a(Context context) {
        super(LayoutInflater.from(context).inflate(t.h.im_chat_float_window, (ViewGroup) null));
        this.cvv = false;
        this.cvw = new b(this);
        this.cvx = new c(this);
        this.cvy = new d(this);
        this.cuM = new com.baidu.tieba.imMessageCenter.im.floatwindow.e();
        this.cvl = (FrameLayout) this.cuT.findViewById(t.g.chat_float_window_wrapper);
        this.cvm = (HeadImageView) this.cuT.findViewById(t.g.chat_float_window_first);
        this.cvn = (HeadImageView) this.cuT.findViewById(t.g.chat_float_window_second);
        this.cvo = (HeadImageView) this.cuT.findViewById(t.g.chat_float_window_third);
        this.cvp = (HeadImageView) this.cuT.findViewById(t.g.chat_float_window_fourth);
        d(this.cvm);
        d(this.cvn);
        d(this.cvo);
        d(this.cvp);
        this.cvq = (TextView) this.cuT.findViewById(t.g.chat_float_window_text);
        this.cvu = new Point();
    }

    private void d(HeadImageView headImageView) {
        headImageView.setAutoChangeStyle(false);
        headImageView.setIsRound(true);
        headImageView.setDefaultBgResource(0);
    }

    public boolean ajW() {
        return this.cvv;
    }

    public com.baidu.tieba.imMessageCenter.im.floatwindow.e ajJ() {
        this.cuM.aE(this.cuT);
        return this.cuM;
    }

    public void a(Handler handler, boolean z) {
        if (!ajL()) {
            ajM();
            if (handler != null && z) {
                handler.post(this.cvw);
            }
        }
    }

    public void a(InterfaceC0062a interfaceC0062a) {
        this.cuH = interfaceC0062a;
    }

    public void jR(int i) {
        int i2;
        if (i <= 0) {
            this.cvq.setVisibility(8);
            return;
        }
        this.cvq.setVisibility(0);
        if (i < 10) {
            this.cvq.setText(String.valueOf(i));
            i2 = t.f.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.cvq.setText(String.valueOf(i));
            i2 = t.f.icon_news_head_prompt_two;
        } else {
            this.cvq.setText("   ");
            i2 = t.f.icon_news_head_prompt_more;
        }
        this.cvq.setBackgroundResource(i2);
    }

    public void ajX() {
        int i;
        int measuredWidth = this.cuT.getMeasuredWidth();
        int i2 = this.cuV.x;
        if ((measuredWidth / 2) + i2 > this.cuP / 2) {
            i = this.cuP - measuredWidth;
        } else {
            i = 0;
        }
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.ajO().a(aC(i2, i));
    }

    public void b(Point point) {
        this.cvu.x = this.cuV.x;
        this.cvu.y = this.cuV.y;
        this.cvv = true;
        setTouchable(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.ajO().a(c(point));
    }

    public void ajY() {
        int measuredWidth = this.cuT.getMeasuredWidth();
        boolean z = this.cvu.x != 0;
        boolean z2 = this.cvu.x != this.cuP - measuredWidth;
        if (z && z2) {
            if (this.cvu.x > this.cuP / 2) {
                this.cvu.x = this.cuP - measuredWidth;
            } else {
                this.cvu.x = 0;
            }
        }
        this.cvv = true;
        setTouchable(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.ajO().a(c(this.cvu));
    }

    public void K(ArrayList<String> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            jS(size);
            for (int i = 0; i < size; i++) {
                y(i, arrayList.get(i));
            }
        }
    }

    private void y(int i, String str) {
        switch (i) {
            case 0:
                this.cvm.c(str, 12, false);
                return;
            case 1:
                this.cvn.c(str, 12, false);
                return;
            case 2:
                this.cvo.c(str, 12, false);
                return;
            case 3:
                this.cvp.c(str, 12, false);
                return;
            default:
                return;
        }
    }

    private void jS(int i) {
        this.cvm.setVisibility(i > 0 ? 0 : 8);
        this.cvn.setVisibility(i > 1 ? 0 : 8);
        this.cvo.setVisibility(i > 2 ? 0 : 8);
        this.cvp.setVisibility(i <= 3 ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation ajZ() {
        if (this.cvr == null) {
            this.cvr = AnimationUtils.loadAnimation(TbadkCoreApplication.m11getInst(), t.a.float_window_in_anim);
        }
        return this.cvr;
    }

    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.e aC(int i, int i2) {
        if (this.cvs == null) {
            this.cvs = new com.baidu.tieba.imMessageCenter.im.floatwindow.a.e(20);
            this.cvs.a(this.cvy);
        }
        this.cvs.setStart(i);
        this.cvs.jQ(i2);
        return this.cvs;
    }

    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.d c(Point point) {
        if (this.cvt == null) {
            this.cvt = new com.baidu.tieba.imMessageCenter.im.floatwindow.a.d(300L);
            this.cvt.a(this.cvx);
        }
        Point point2 = new Point();
        point2.x = this.cuV.x;
        point2.y = this.cuV.y;
        this.cvt.a(point2, point);
        return this.cvt;
    }
}
