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
    private InterfaceC0062a bKU;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.e bKZ;
    private HeadImageView bLA;
    private HeadImageView bLB;
    private HeadImageView bLC;
    private HeadImageView bLD;
    private TextView bLE;
    private Animation bLF;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.e bLG;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.d bLH;
    private Point bLI;
    private boolean bLJ;
    private Runnable bLK;
    private c.a bLL;
    private e.a bLM;
    private FrameLayout bLz;

    /* renamed from: com.baidu.tieba.imMessageCenter.im.floatwindow.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0062a {
        void Yt();
    }

    public a(Context context) {
        super(LayoutInflater.from(context).inflate(i.g.im_chat_float_window, (ViewGroup) null));
        this.bLJ = false;
        this.bLK = new b(this);
        this.bLL = new c(this);
        this.bLM = new d(this);
        this.bKZ = new com.baidu.tieba.imMessageCenter.im.floatwindow.e();
        this.bLz = (FrameLayout) this.bLg.findViewById(i.f.chat_float_window_wrapper);
        this.bLA = (HeadImageView) this.bLg.findViewById(i.f.chat_float_window_first);
        this.bLB = (HeadImageView) this.bLg.findViewById(i.f.chat_float_window_second);
        this.bLC = (HeadImageView) this.bLg.findViewById(i.f.chat_float_window_third);
        this.bLD = (HeadImageView) this.bLg.findViewById(i.f.chat_float_window_fourth);
        d(this.bLA);
        d(this.bLB);
        d(this.bLC);
        d(this.bLD);
        this.bLE = (TextView) this.bLg.findViewById(i.f.chat_float_window_text);
        this.bLI = new Point();
    }

    private void d(HeadImageView headImageView) {
        headImageView.setAutoChangeStyle(false);
        headImageView.setIsRound(true);
        headImageView.setDefaultBgResource(0);
    }

    public boolean YH() {
        return this.bLJ;
    }

    public com.baidu.tieba.imMessageCenter.im.floatwindow.e Yu() {
        this.bKZ.Q(this.bLg);
        return this.bKZ;
    }

    public void a(Handler handler, boolean z) {
        if (!Yw()) {
            Yx();
            if (handler != null && z) {
                handler.post(this.bLK);
            }
        }
    }

    public void a(InterfaceC0062a interfaceC0062a) {
        this.bKU = interfaceC0062a;
    }

    public void hI(int i) {
        int i2;
        if (i <= 0) {
            this.bLE.setVisibility(8);
            return;
        }
        this.bLE.setVisibility(0);
        if (i < 10) {
            this.bLE.setText(String.valueOf(i));
            i2 = i.e.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.bLE.setText(String.valueOf(i));
            i2 = i.e.icon_news_head_prompt_two;
        } else {
            this.bLE.setText("   ");
            i2 = i.e.icon_news_head_prompt_more;
        }
        this.bLE.setBackgroundResource(i2);
    }

    public void YI() {
        int i;
        int measuredWidth = this.bLg.getMeasuredWidth();
        int i2 = this.bLi.x;
        if ((measuredWidth / 2) + i2 > this.bLc / 2) {
            i = this.bLc - measuredWidth;
        } else {
            i = 0;
        }
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.Yz().a(ap(i2, i));
    }

    public void b(Point point) {
        this.bLI.x = this.bLi.x;
        this.bLI.y = this.bLi.y;
        this.bLJ = true;
        setTouchable(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.Yz().a(c(point));
    }

    public void YJ() {
        int measuredWidth = this.bLg.getMeasuredWidth();
        boolean z = this.bLI.x != 0;
        boolean z2 = this.bLI.x != this.bLc - measuredWidth;
        if (z && z2) {
            if (this.bLI.x > this.bLc / 2) {
                this.bLI.x = this.bLc - measuredWidth;
            } else {
                this.bLI.x = 0;
            }
        }
        this.bLJ = true;
        setTouchable(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.Yz().a(c(this.bLI));
    }

    public void E(ArrayList<String> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            hJ(size);
            for (int i = 0; i < size; i++) {
                E(i, arrayList.get(i));
            }
        }
    }

    private void E(int i, String str) {
        switch (i) {
            case 0:
                this.bLA.d(str, 12, false);
                return;
            case 1:
                this.bLB.d(str, 12, false);
                return;
            case 2:
                this.bLC.d(str, 12, false);
                return;
            case 3:
                this.bLD.d(str, 12, false);
                return;
            default:
                return;
        }
    }

    private void hJ(int i) {
        this.bLA.setVisibility(i > 0 ? 0 : 8);
        this.bLB.setVisibility(i > 1 ? 0 : 8);
        this.bLC.setVisibility(i > 2 ? 0 : 8);
        this.bLD.setVisibility(i <= 3 ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation YK() {
        if (this.bLF == null) {
            this.bLF = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), i.a.float_window_in_anim);
        }
        return this.bLF;
    }

    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.e ap(int i, int i2) {
        if (this.bLG == null) {
            this.bLG = new com.baidu.tieba.imMessageCenter.im.floatwindow.a.e(20);
            this.bLG.a(this.bLM);
        }
        this.bLG.setStart(i);
        this.bLG.hH(i2);
        return this.bLG;
    }

    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.d c(Point point) {
        if (this.bLH == null) {
            this.bLH = new com.baidu.tieba.imMessageCenter.im.floatwindow.a.d(300L);
            this.bLH.a(this.bLL);
        }
        Point point2 = new Point();
        point2.x = this.bLi.x;
        point2.y = this.bLi.y;
        this.bLH.a(point2, point);
        return this.bLH;
    }
}
