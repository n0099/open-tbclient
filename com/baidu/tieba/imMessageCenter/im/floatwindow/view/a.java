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
import com.baidu.tieba.i;
import com.baidu.tieba.imMessageCenter.im.floatwindow.a.c;
import com.baidu.tieba.imMessageCenter.im.floatwindow.a.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.imMessageCenter.im.floatwindow.g {
    private FrameLayout bHN;
    private HeadImageView bHO;
    private HeadImageView bHP;
    private HeadImageView bHQ;
    private HeadImageView bHR;
    private TextView bHS;
    private Animation bHT;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.e bHU;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.d bHV;
    private Point bHW;
    private boolean bHX;
    private Runnable bHY;
    private c.a bHZ;
    private InterfaceC0062a bHi;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.e bHn;
    private e.a bIa;

    /* renamed from: com.baidu.tieba.imMessageCenter.im.floatwindow.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0062a {
        void XJ();
    }

    public a(Context context) {
        super(LayoutInflater.from(context).inflate(i.g.im_chat_float_window, (ViewGroup) null));
        this.bHX = false;
        this.bHY = new b(this);
        this.bHZ = new c(this);
        this.bIa = new d(this);
        this.bHn = new com.baidu.tieba.imMessageCenter.im.floatwindow.e();
        this.bHN = (FrameLayout) this.bHu.findViewById(i.f.chat_float_window_wrapper);
        this.bHO = (HeadImageView) this.bHu.findViewById(i.f.chat_float_window_first);
        this.bHP = (HeadImageView) this.bHu.findViewById(i.f.chat_float_window_second);
        this.bHQ = (HeadImageView) this.bHu.findViewById(i.f.chat_float_window_third);
        this.bHR = (HeadImageView) this.bHu.findViewById(i.f.chat_float_window_fourth);
        a(this.bHO);
        a(this.bHP);
        a(this.bHQ);
        a(this.bHR);
        this.bHS = (TextView) this.bHu.findViewById(i.f.chat_float_window_text);
        this.bHW = new Point();
    }

    private void a(HeadImageView headImageView) {
        headImageView.setAutoChangeStyle(false);
        headImageView.setIsRound(true);
        headImageView.setDefaultBgResource(0);
    }

    public boolean XX() {
        return this.bHX;
    }

    public com.baidu.tieba.imMessageCenter.im.floatwindow.e XK() {
        this.bHn.O(this.bHu);
        return this.bHn;
    }

    public void a(Handler handler, boolean z) {
        if (!XM()) {
            XN();
            if (handler != null && z) {
                handler.post(this.bHY);
            }
        }
    }

    public void a(InterfaceC0062a interfaceC0062a) {
        this.bHi = interfaceC0062a;
    }

    public void hs(int i) {
        int i2;
        if (i <= 0) {
            this.bHS.setVisibility(8);
            return;
        }
        this.bHS.setVisibility(0);
        if (i < 10) {
            this.bHS.setText(String.valueOf(i));
            i2 = i.e.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.bHS.setText(String.valueOf(i));
            i2 = i.e.icon_news_head_prompt_two;
        } else {
            this.bHS.setText("   ");
            i2 = i.e.icon_news_head_prompt_more;
        }
        this.bHS.setBackgroundResource(i2);
    }

    public void XY() {
        int i;
        int measuredWidth = this.bHu.getMeasuredWidth();
        int i2 = this.bHw.x;
        if ((measuredWidth / 2) + i2 > this.bHq / 2) {
            i = this.bHq - measuredWidth;
        } else {
            i = 0;
        }
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.XP().a(ao(i2, i));
    }

    public void b(Point point) {
        this.bHW.x = this.bHw.x;
        this.bHW.y = this.bHw.y;
        this.bHX = true;
        setTouchable(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.XP().a(c(point));
    }

    public void XZ() {
        int measuredWidth = this.bHu.getMeasuredWidth();
        boolean z = this.bHW.x != 0;
        boolean z2 = this.bHW.x != this.bHq - measuredWidth;
        if (z && z2) {
            if (this.bHW.x > this.bHq / 2) {
                this.bHW.x = this.bHq - measuredWidth;
            } else {
                this.bHW.x = 0;
            }
        }
        this.bHX = true;
        setTouchable(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.XP().a(c(this.bHW));
    }

    public void F(ArrayList<String> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            ht(size);
            for (int i = 0; i < size; i++) {
                E(i, arrayList.get(i));
            }
        }
    }

    private void E(int i, String str) {
        switch (i) {
            case 0:
                this.bHO.d(str, 12, false);
                return;
            case 1:
                this.bHP.d(str, 12, false);
                return;
            case 2:
                this.bHQ.d(str, 12, false);
                return;
            case 3:
                this.bHR.d(str, 12, false);
                return;
            default:
                return;
        }
    }

    private void ht(int i) {
        this.bHO.setVisibility(i > 0 ? 0 : 8);
        this.bHP.setVisibility(i > 1 ? 0 : 8);
        this.bHQ.setVisibility(i > 2 ? 0 : 8);
        this.bHR.setVisibility(i <= 3 ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation Ya() {
        if (this.bHT == null) {
            this.bHT = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), i.a.float_window_in_anim);
        }
        return this.bHT;
    }

    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.e ao(int i, int i2) {
        if (this.bHU == null) {
            this.bHU = new com.baidu.tieba.imMessageCenter.im.floatwindow.a.e(20);
            this.bHU.a(this.bIa);
        }
        this.bHU.setStart(i);
        this.bHU.hr(i2);
        return this.bHU;
    }

    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.d c(Point point) {
        if (this.bHV == null) {
            this.bHV = new com.baidu.tieba.imMessageCenter.im.floatwindow.a.d(300L);
            this.bHV.a(this.bHZ);
        }
        Point point2 = new Point();
        point2.x = this.bHw.x;
        point2.y = this.bHw.y;
        this.bHV.a(point2, point);
        return this.bHV;
    }
}
