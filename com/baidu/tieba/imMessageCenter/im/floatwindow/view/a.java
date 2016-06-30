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
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.imMessageCenter.im.floatwindow.g {
    private InterfaceC0067a cZW;
    private FrameLayout daC;
    private HeadImageView daD;
    private HeadImageView daE;
    private HeadImageView daF;
    private HeadImageView daG;
    private TextView daH;
    private Animation daI;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.e daJ;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.d daK;
    private Point daL;
    private boolean daM;
    private Runnable daN;
    private c.a daO;
    private e.a daP;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.e dab;

    /* renamed from: com.baidu.tieba.imMessageCenter.im.floatwindow.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0067a {
        void arY();
    }

    public a(Context context) {
        super(LayoutInflater.from(context).inflate(u.h.im_chat_float_window, (ViewGroup) null));
        this.daM = false;
        this.daN = new b(this);
        this.daO = new c(this);
        this.daP = new d(this);
        this.dab = new com.baidu.tieba.imMessageCenter.im.floatwindow.e();
        this.daC = (FrameLayout) this.dai.findViewById(u.g.chat_float_window_wrapper);
        this.daD = (HeadImageView) this.dai.findViewById(u.g.chat_float_window_first);
        this.daE = (HeadImageView) this.dai.findViewById(u.g.chat_float_window_second);
        this.daF = (HeadImageView) this.dai.findViewById(u.g.chat_float_window_third);
        this.daG = (HeadImageView) this.dai.findViewById(u.g.chat_float_window_fourth);
        d(this.daD);
        d(this.daE);
        d(this.daF);
        d(this.daG);
        this.daH = (TextView) this.dai.findViewById(u.g.chat_float_window_text);
        this.daL = new Point();
    }

    private void d(HeadImageView headImageView) {
        headImageView.setAutoChangeStyle(false);
        headImageView.setIsRound(true);
        headImageView.setDefaultBgResource(0);
    }

    public boolean asm() {
        return this.daM;
    }

    public com.baidu.tieba.imMessageCenter.im.floatwindow.e arZ() {
        this.dab.aM(this.dai);
        return this.dab;
    }

    public void a(Handler handler, boolean z) {
        if (!asb()) {
            asc();
            if (handler != null && z) {
                handler.post(this.daN);
            }
        }
    }

    public void a(InterfaceC0067a interfaceC0067a) {
        this.cZW = interfaceC0067a;
    }

    public void ls(int i) {
        int i2;
        if (i <= 0) {
            this.daH.setVisibility(8);
            return;
        }
        this.daH.setVisibility(0);
        if (i < 10) {
            this.daH.setText(String.valueOf(i));
            i2 = u.f.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.daH.setText(String.valueOf(i));
            i2 = u.f.icon_news_head_prompt_two;
        } else {
            this.daH.setText("   ");
            i2 = u.f.icon_news_head_prompt_more;
        }
        this.daH.setBackgroundResource(i2);
    }

    public void asn() {
        int i;
        int measuredWidth = this.dai.getMeasuredWidth();
        int i2 = this.dak.x;
        if ((measuredWidth / 2) + i2 > this.dae / 2) {
            i = this.dae - measuredWidth;
        } else {
            i = 0;
        }
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.ase().a(aT(i2, i));
    }

    public void b(Point point) {
        this.daL.x = this.dak.x;
        this.daL.y = this.dak.y;
        this.daM = true;
        setTouchable(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.ase().a(c(point));
    }

    public void aso() {
        int measuredWidth = this.dai.getMeasuredWidth();
        boolean z = this.daL.x != 0;
        boolean z2 = this.daL.x != this.dae - measuredWidth;
        if (z && z2) {
            if (this.daL.x > this.dae / 2) {
                this.daL.x = this.dae - measuredWidth;
            } else {
                this.daL.x = 0;
            }
        }
        this.daM = true;
        setTouchable(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.ase().a(c(this.daL));
    }

    public void U(ArrayList<String> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            lt(size);
            for (int i = 0; i < size; i++) {
                C(i, arrayList.get(i));
            }
        }
    }

    private void C(int i, String str) {
        switch (i) {
            case 0:
                this.daD.c(str, 12, false);
                return;
            case 1:
                this.daE.c(str, 12, false);
                return;
            case 2:
                this.daF.c(str, 12, false);
                return;
            case 3:
                this.daG.c(str, 12, false);
                return;
            default:
                return;
        }
    }

    private void lt(int i) {
        this.daD.setVisibility(i > 0 ? 0 : 8);
        this.daE.setVisibility(i > 1 ? 0 : 8);
        this.daF.setVisibility(i > 2 ? 0 : 8);
        this.daG.setVisibility(i <= 3 ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation asp() {
        if (this.daI == null) {
            this.daI = AnimationUtils.loadAnimation(TbadkCoreApplication.m9getInst(), u.a.float_window_in_anim);
        }
        return this.daI;
    }

    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.e aT(int i, int i2) {
        if (this.daJ == null) {
            this.daJ = new com.baidu.tieba.imMessageCenter.im.floatwindow.a.e(20);
            this.daJ.a(this.daP);
        }
        this.daJ.setStart(i);
        this.daJ.lr(i2);
        return this.daJ;
    }

    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.d c(Point point) {
        if (this.daK == null) {
            this.daK = new com.baidu.tieba.imMessageCenter.im.floatwindow.a.d(300L);
            this.daK.a(this.daO);
        }
        Point point2 = new Point();
        point2.x = this.dak.x;
        point2.y = this.dak.y;
        this.daK.a(point2, point);
        return this.daK;
    }
}
