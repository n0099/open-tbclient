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
    private FrameLayout bLK;
    private HeadImageView bLL;
    private HeadImageView bLM;
    private HeadImageView bLN;
    private HeadImageView bLO;
    private TextView bLP;
    private Animation bLQ;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.e bLR;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.d bLS;
    private Point bLT;
    private boolean bLU;
    private Runnable bLV;
    private c.a bLW;
    private e.a bLX;
    private InterfaceC0062a bLf;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.e bLk;

    /* renamed from: com.baidu.tieba.imMessageCenter.im.floatwindow.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0062a {
        void Yp();
    }

    public a(Context context) {
        super(LayoutInflater.from(context).inflate(i.g.im_chat_float_window, (ViewGroup) null));
        this.bLU = false;
        this.bLV = new b(this);
        this.bLW = new c(this);
        this.bLX = new d(this);
        this.bLk = new com.baidu.tieba.imMessageCenter.im.floatwindow.e();
        this.bLK = (FrameLayout) this.bLr.findViewById(i.f.chat_float_window_wrapper);
        this.bLL = (HeadImageView) this.bLr.findViewById(i.f.chat_float_window_first);
        this.bLM = (HeadImageView) this.bLr.findViewById(i.f.chat_float_window_second);
        this.bLN = (HeadImageView) this.bLr.findViewById(i.f.chat_float_window_third);
        this.bLO = (HeadImageView) this.bLr.findViewById(i.f.chat_float_window_fourth);
        d(this.bLL);
        d(this.bLM);
        d(this.bLN);
        d(this.bLO);
        this.bLP = (TextView) this.bLr.findViewById(i.f.chat_float_window_text);
        this.bLT = new Point();
    }

    private void d(HeadImageView headImageView) {
        headImageView.setAutoChangeStyle(false);
        headImageView.setIsRound(true);
        headImageView.setDefaultBgResource(0);
    }

    public boolean YD() {
        return this.bLU;
    }

    public com.baidu.tieba.imMessageCenter.im.floatwindow.e Yq() {
        this.bLk.Q(this.bLr);
        return this.bLk;
    }

    public void a(Handler handler, boolean z) {
        if (!Ys()) {
            Yt();
            if (handler != null && z) {
                handler.post(this.bLV);
            }
        }
    }

    public void a(InterfaceC0062a interfaceC0062a) {
        this.bLf = interfaceC0062a;
    }

    public void hI(int i) {
        int i2;
        if (i <= 0) {
            this.bLP.setVisibility(8);
            return;
        }
        this.bLP.setVisibility(0);
        if (i < 10) {
            this.bLP.setText(String.valueOf(i));
            i2 = i.e.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.bLP.setText(String.valueOf(i));
            i2 = i.e.icon_news_head_prompt_two;
        } else {
            this.bLP.setText("   ");
            i2 = i.e.icon_news_head_prompt_more;
        }
        this.bLP.setBackgroundResource(i2);
    }

    public void YE() {
        int i;
        int measuredWidth = this.bLr.getMeasuredWidth();
        int i2 = this.bLt.x;
        if ((measuredWidth / 2) + i2 > this.bLn / 2) {
            i = this.bLn - measuredWidth;
        } else {
            i = 0;
        }
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.Yv().a(ap(i2, i));
    }

    public void b(Point point) {
        this.bLT.x = this.bLt.x;
        this.bLT.y = this.bLt.y;
        this.bLU = true;
        setTouchable(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.Yv().a(c(point));
    }

    public void YF() {
        int measuredWidth = this.bLr.getMeasuredWidth();
        boolean z = this.bLT.x != 0;
        boolean z2 = this.bLT.x != this.bLn - measuredWidth;
        if (z && z2) {
            if (this.bLT.x > this.bLn / 2) {
                this.bLT.x = this.bLn - measuredWidth;
            } else {
                this.bLT.x = 0;
            }
        }
        this.bLU = true;
        setTouchable(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.Yv().a(c(this.bLT));
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
                this.bLL.d(str, 12, false);
                return;
            case 1:
                this.bLM.d(str, 12, false);
                return;
            case 2:
                this.bLN.d(str, 12, false);
                return;
            case 3:
                this.bLO.d(str, 12, false);
                return;
            default:
                return;
        }
    }

    private void hJ(int i) {
        this.bLL.setVisibility(i > 0 ? 0 : 8);
        this.bLM.setVisibility(i > 1 ? 0 : 8);
        this.bLN.setVisibility(i > 2 ? 0 : 8);
        this.bLO.setVisibility(i <= 3 ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation YG() {
        if (this.bLQ == null) {
            this.bLQ = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), i.a.float_window_in_anim);
        }
        return this.bLQ;
    }

    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.e ap(int i, int i2) {
        if (this.bLR == null) {
            this.bLR = new com.baidu.tieba.imMessageCenter.im.floatwindow.a.e(20);
            this.bLR.a(this.bLX);
        }
        this.bLR.setStart(i);
        this.bLR.hH(i2);
        return this.bLR;
    }

    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.d c(Point point) {
        if (this.bLS == null) {
            this.bLS = new com.baidu.tieba.imMessageCenter.im.floatwindow.a.d(300L);
            this.bLS.a(this.bLW);
        }
        Point point2 = new Point();
        point2.x = this.bLt.x;
        point2.y = this.bLt.y;
        this.bLS.a(point2, point);
        return this.bLS;
    }
}
