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
    private FrameLayout cjI;
    private HeadImageView cjJ;
    private HeadImageView cjK;
    private HeadImageView cjL;
    private HeadImageView cjM;
    private TextView cjN;
    private Animation cjO;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.e cjP;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.d cjQ;
    private Point cjR;
    private boolean cjS;
    private Runnable cjT;
    private c.a cjU;
    private e.a cjV;
    private InterfaceC0067a cje;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.e cjj;

    /* renamed from: com.baidu.tieba.imMessageCenter.im.floatwindow.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0067a {
        void agi();
    }

    public a(Context context) {
        super(LayoutInflater.from(context).inflate(t.h.im_chat_float_window, (ViewGroup) null));
        this.cjS = false;
        this.cjT = new b(this);
        this.cjU = new c(this);
        this.cjV = new d(this);
        this.cjj = new com.baidu.tieba.imMessageCenter.im.floatwindow.e();
        this.cjI = (FrameLayout) this.cjq.findViewById(t.g.chat_float_window_wrapper);
        this.cjJ = (HeadImageView) this.cjq.findViewById(t.g.chat_float_window_first);
        this.cjK = (HeadImageView) this.cjq.findViewById(t.g.chat_float_window_second);
        this.cjL = (HeadImageView) this.cjq.findViewById(t.g.chat_float_window_third);
        this.cjM = (HeadImageView) this.cjq.findViewById(t.g.chat_float_window_fourth);
        d(this.cjJ);
        d(this.cjK);
        d(this.cjL);
        d(this.cjM);
        this.cjN = (TextView) this.cjq.findViewById(t.g.chat_float_window_text);
        this.cjR = new Point();
    }

    private void d(HeadImageView headImageView) {
        headImageView.setAutoChangeStyle(false);
        headImageView.setIsRound(true);
        headImageView.setDefaultBgResource(0);
    }

    public boolean agw() {
        return this.cjS;
    }

    public com.baidu.tieba.imMessageCenter.im.floatwindow.e agj() {
        this.cjj.ap(this.cjq);
        return this.cjj;
    }

    public void a(Handler handler, boolean z) {
        if (!agl()) {
            agm();
            if (handler != null && z) {
                handler.post(this.cjT);
            }
        }
    }

    public void a(InterfaceC0067a interfaceC0067a) {
        this.cje = interfaceC0067a;
    }

    public void jG(int i) {
        int i2;
        if (i <= 0) {
            this.cjN.setVisibility(8);
            return;
        }
        this.cjN.setVisibility(0);
        if (i < 10) {
            this.cjN.setText(String.valueOf(i));
            i2 = t.f.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.cjN.setText(String.valueOf(i));
            i2 = t.f.icon_news_head_prompt_two;
        } else {
            this.cjN.setText("   ");
            i2 = t.f.icon_news_head_prompt_more;
        }
        this.cjN.setBackgroundResource(i2);
    }

    public void agx() {
        int i;
        int measuredWidth = this.cjq.getMeasuredWidth();
        int i2 = this.cjs.x;
        if ((measuredWidth / 2) + i2 > this.cjm / 2) {
            i = this.cjm - measuredWidth;
        } else {
            i = 0;
        }
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.ago().a(aG(i2, i));
    }

    public void b(Point point) {
        this.cjR.x = this.cjs.x;
        this.cjR.y = this.cjs.y;
        this.cjS = true;
        setTouchable(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.ago().a(c(point));
    }

    public void agy() {
        int measuredWidth = this.cjq.getMeasuredWidth();
        boolean z = this.cjR.x != 0;
        boolean z2 = this.cjR.x != this.cjm - measuredWidth;
        if (z && z2) {
            if (this.cjR.x > this.cjm / 2) {
                this.cjR.x = this.cjm - measuredWidth;
            } else {
                this.cjR.x = 0;
            }
        }
        this.cjS = true;
        setTouchable(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.ago().a(c(this.cjR));
    }

    public void K(ArrayList<String> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            jH(size);
            for (int i = 0; i < size; i++) {
                H(i, arrayList.get(i));
            }
        }
    }

    private void H(int i, String str) {
        switch (i) {
            case 0:
                this.cjJ.d(str, 12, false);
                return;
            case 1:
                this.cjK.d(str, 12, false);
                return;
            case 2:
                this.cjL.d(str, 12, false);
                return;
            case 3:
                this.cjM.d(str, 12, false);
                return;
            default:
                return;
        }
    }

    private void jH(int i) {
        this.cjJ.setVisibility(i > 0 ? 0 : 8);
        this.cjK.setVisibility(i > 1 ? 0 : 8);
        this.cjL.setVisibility(i > 2 ? 0 : 8);
        this.cjM.setVisibility(i <= 3 ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation agz() {
        if (this.cjO == null) {
            this.cjO = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), t.a.float_window_in_anim);
        }
        return this.cjO;
    }

    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.e aG(int i, int i2) {
        if (this.cjP == null) {
            this.cjP = new com.baidu.tieba.imMessageCenter.im.floatwindow.a.e(20);
            this.cjP.a(this.cjV);
        }
        this.cjP.setStart(i);
        this.cjP.jF(i2);
        return this.cjP;
    }

    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.d c(Point point) {
        if (this.cjQ == null) {
            this.cjQ = new com.baidu.tieba.imMessageCenter.im.floatwindow.a.d(300L);
            this.cjQ.a(this.cjU);
        }
        Point point2 = new Point();
        point2.x = this.cjs.x;
        point2.y = this.cjs.y;
        this.cjQ.a(point2, point);
        return this.cjQ;
    }
}
