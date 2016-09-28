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
    private FrameLayout dqE;
    private HeadImageView dqF;
    private HeadImageView dqG;
    private HeadImageView dqH;
    private HeadImageView dqI;
    private TextView dqJ;
    private Animation dqK;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.e dqL;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.d dqM;
    private Point dqN;
    private boolean dqO;
    private Runnable dqP;
    private c.a dqQ;
    private e.a dqR;
    private InterfaceC0071a dqa;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.e dqf;

    /* renamed from: com.baidu.tieba.imMessageCenter.im.floatwindow.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0071a {
        void axX();
    }

    public a(Context context) {
        super(LayoutInflater.from(context).inflate(r.h.im_chat_float_window, (ViewGroup) null));
        this.dqO = false;
        this.dqP = new b(this);
        this.dqQ = new c(this);
        this.dqR = new d(this);
        this.dqf = new com.baidu.tieba.imMessageCenter.im.floatwindow.e();
        this.dqE = (FrameLayout) this.dqm.findViewById(r.g.chat_float_window_wrapper);
        this.dqF = (HeadImageView) this.dqm.findViewById(r.g.chat_float_window_first);
        this.dqG = (HeadImageView) this.dqm.findViewById(r.g.chat_float_window_second);
        this.dqH = (HeadImageView) this.dqm.findViewById(r.g.chat_float_window_third);
        this.dqI = (HeadImageView) this.dqm.findViewById(r.g.chat_float_window_fourth);
        d(this.dqF);
        d(this.dqG);
        d(this.dqH);
        d(this.dqI);
        this.dqJ = (TextView) this.dqm.findViewById(r.g.chat_float_window_text);
        this.dqN = new Point();
    }

    private void d(HeadImageView headImageView) {
        headImageView.setAutoChangeStyle(false);
        headImageView.setIsRound(true);
        headImageView.setDefaultBgResource(0);
    }

    public boolean ayk() {
        return this.dqO;
    }

    public com.baidu.tieba.imMessageCenter.im.floatwindow.e axY() {
        this.dqf.aJ(this.dqm);
        return this.dqf;
    }

    public void a(Handler handler, boolean z) {
        if (!aya()) {
            ayb();
            if (handler != null && z) {
                handler.post(this.dqP);
            }
        }
    }

    public void a(InterfaceC0071a interfaceC0071a) {
        this.dqa = interfaceC0071a;
    }

    public void mj(int i) {
        int i2;
        if (i <= 0) {
            this.dqJ.setVisibility(8);
            return;
        }
        this.dqJ.setVisibility(0);
        if (i < 10) {
            this.dqJ.setText(String.valueOf(i));
            i2 = r.f.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.dqJ.setText(String.valueOf(i));
            i2 = r.f.icon_news_head_prompt_two;
        } else {
            this.dqJ.setText("   ");
            i2 = r.f.icon_news_head_prompt_more;
        }
        this.dqJ.setBackgroundResource(i2);
    }

    public void ayl() {
        int i;
        int measuredWidth = this.dqm.getMeasuredWidth();
        int i2 = this.dqo.x;
        if ((measuredWidth / 2) + i2 > this.dqi / 2) {
            i = this.dqi - measuredWidth;
        } else {
            i = 0;
        }
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.ayd().a(bc(i2, i));
    }

    public void b(Point point) {
        this.dqN.x = this.dqo.x;
        this.dqN.y = this.dqo.y;
        this.dqO = true;
        setTouchable(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.ayd().a(c(point));
    }

    public void aym() {
        int measuredWidth = this.dqm.getMeasuredWidth();
        boolean z = this.dqN.x != 0;
        boolean z2 = this.dqN.x != this.dqi - measuredWidth;
        if (z && z2) {
            if (this.dqN.x > this.dqi / 2) {
                this.dqN.x = this.dqi - measuredWidth;
            } else {
                this.dqN.x = 0;
            }
        }
        this.dqO = true;
        setTouchable(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.ayd().a(c(this.dqN));
    }

    public void W(ArrayList<String> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            mk(size);
            for (int i = 0; i < size; i++) {
                B(i, arrayList.get(i));
            }
        }
    }

    private void B(int i, String str) {
        switch (i) {
            case 0:
                this.dqF.c(str, 12, false);
                return;
            case 1:
                this.dqG.c(str, 12, false);
                return;
            case 2:
                this.dqH.c(str, 12, false);
                return;
            case 3:
                this.dqI.c(str, 12, false);
                return;
            default:
                return;
        }
    }

    private void mk(int i) {
        this.dqF.setVisibility(i > 0 ? 0 : 8);
        this.dqG.setVisibility(i > 1 ? 0 : 8);
        this.dqH.setVisibility(i > 2 ? 0 : 8);
        this.dqI.setVisibility(i <= 3 ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation ayn() {
        if (this.dqK == null) {
            this.dqK = AnimationUtils.loadAnimation(TbadkCoreApplication.m9getInst(), r.a.float_window_in_anim);
        }
        return this.dqK;
    }

    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.e bc(int i, int i2) {
        if (this.dqL == null) {
            this.dqL = new com.baidu.tieba.imMessageCenter.im.floatwindow.a.e(20);
            this.dqL.a(this.dqR);
        }
        this.dqL.setStart(i);
        this.dqL.mi(i2);
        return this.dqL;
    }

    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.d c(Point point) {
        if (this.dqM == null) {
            this.dqM = new com.baidu.tieba.imMessageCenter.im.floatwindow.a.d(300L);
            this.dqM.a(this.dqQ);
        }
        Point point2 = new Point();
        point2.x = this.dqo.x;
        point2.y = this.dqo.y;
        this.dqM.a(point2, point);
        return this.dqM;
    }
}
