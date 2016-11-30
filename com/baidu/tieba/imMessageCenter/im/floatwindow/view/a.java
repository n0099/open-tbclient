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
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.imMessageCenter.im.floatwindow.g {
    private InterfaceC0070a dvH;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.e dvM;
    private FrameLayout dwl;
    private HeadImageView dwm;
    private HeadImageView dwn;
    private HeadImageView dwo;
    private HeadImageView dwp;
    private TextView dwq;
    private Animation dwr;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.e dws;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.d dwt;
    private Point dwu;
    private boolean dwv;
    private Runnable dww;
    private c.a dwx;
    private e.a dwy;

    /* renamed from: com.baidu.tieba.imMessageCenter.im.floatwindow.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0070a {
        void azU();
    }

    public a(Context context) {
        super(LayoutInflater.from(context).inflate(r.h.im_chat_float_window, (ViewGroup) null));
        this.dwv = false;
        this.dww = new b(this);
        this.dwx = new c(this);
        this.dwy = new d(this);
        this.dvM = new com.baidu.tieba.imMessageCenter.im.floatwindow.e();
        this.dwl = (FrameLayout) this.dvT.findViewById(r.g.chat_float_window_wrapper);
        this.dwm = (HeadImageView) this.dvT.findViewById(r.g.chat_float_window_first);
        this.dwn = (HeadImageView) this.dvT.findViewById(r.g.chat_float_window_second);
        this.dwo = (HeadImageView) this.dvT.findViewById(r.g.chat_float_window_third);
        this.dwp = (HeadImageView) this.dvT.findViewById(r.g.chat_float_window_fourth);
        d(this.dwm);
        d(this.dwn);
        d(this.dwo);
        d(this.dwp);
        this.dwq = (TextView) this.dvT.findViewById(r.g.chat_float_window_text);
        this.dwu = new Point();
    }

    private void d(HeadImageView headImageView) {
        headImageView.setAutoChangeStyle(false);
        headImageView.setIsRound(true);
        headImageView.setDefaultBgResource(0);
    }

    public boolean aAh() {
        return this.dwv;
    }

    public com.baidu.tieba.imMessageCenter.im.floatwindow.e azV() {
        this.dvM.aI(this.dvT);
        return this.dvM;
    }

    public void a(Handler handler, boolean z) {
        if (!azX()) {
            azY();
            if (handler != null && z) {
                handler.post(this.dww);
            }
        }
    }

    public void a(InterfaceC0070a interfaceC0070a) {
        this.dvH = interfaceC0070a;
    }

    public void mr(int i) {
        int i2;
        if (i <= 0) {
            this.dwq.setVisibility(8);
            return;
        }
        this.dwq.setVisibility(0);
        if (i < 10) {
            this.dwq.setText(String.valueOf(i));
            i2 = r.f.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.dwq.setText(String.valueOf(i));
            i2 = r.f.icon_news_head_prompt_two;
        } else {
            this.dwq.setText("   ");
            i2 = r.f.icon_news_head_prompt_more;
        }
        this.dwq.setBackgroundResource(i2);
    }

    public void aAi() {
        int i;
        int measuredWidth = this.dvT.getMeasuredWidth();
        int i2 = this.dvV.x;
        if ((measuredWidth / 2) + i2 > this.dvP / 2) {
            i = this.dvP - measuredWidth;
        } else {
            i = 0;
        }
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.aAa().a(bd(i2, i));
    }

    public void b(Point point) {
        this.dwu.x = this.dvV.x;
        this.dwu.y = this.dvV.y;
        this.dwv = true;
        setTouchable(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.aAa().a(c(point));
    }

    public void aAj() {
        int measuredWidth = this.dvT.getMeasuredWidth();
        boolean z = this.dwu.x != 0;
        boolean z2 = this.dwu.x != this.dvP - measuredWidth;
        if (z && z2) {
            if (this.dwu.x > this.dvP / 2) {
                this.dwu.x = this.dvP - measuredWidth;
            } else {
                this.dwu.x = 0;
            }
        }
        this.dwv = true;
        setTouchable(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.aAa().a(c(this.dwu));
    }

    public void Z(ArrayList<String> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            ms(size);
            for (int i = 0; i < size; i++) {
                z(i, arrayList.get(i));
            }
        }
    }

    private void z(int i, String str) {
        switch (i) {
            case 0:
                this.dwm.c(str, 12, false);
                return;
            case 1:
                this.dwn.c(str, 12, false);
                return;
            case 2:
                this.dwo.c(str, 12, false);
                return;
            case 3:
                this.dwp.c(str, 12, false);
                return;
            default:
                return;
        }
    }

    private void ms(int i) {
        this.dwm.setVisibility(i > 0 ? 0 : 8);
        this.dwn.setVisibility(i > 1 ? 0 : 8);
        this.dwo.setVisibility(i > 2 ? 0 : 8);
        this.dwp.setVisibility(i <= 3 ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation aAk() {
        if (this.dwr == null) {
            this.dwr = AnimationUtils.loadAnimation(TbadkCoreApplication.m9getInst(), r.a.float_window_in_anim);
        }
        return this.dwr;
    }

    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.e bd(int i, int i2) {
        if (this.dws == null) {
            this.dws = new com.baidu.tieba.imMessageCenter.im.floatwindow.a.e(20);
            this.dws.a(this.dwy);
        }
        this.dws.setStart(i);
        this.dws.mq(i2);
        return this.dws;
    }

    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.d c(Point point) {
        if (this.dwt == null) {
            this.dwt = new com.baidu.tieba.imMessageCenter.im.floatwindow.a.d(300L);
            this.dwt.a(this.dwx);
        }
        Point point2 = new Point();
        point2.x = this.dvV.x;
        point2.y = this.dvV.y;
        this.dwt.a(point2, point);
        return this.dwt;
    }
}
