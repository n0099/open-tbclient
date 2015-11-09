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
    private InterfaceC0062a bLA;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.e bLF;
    private FrameLayout bMf;
    private HeadImageView bMg;
    private HeadImageView bMh;
    private HeadImageView bMi;
    private HeadImageView bMj;
    private TextView bMk;
    private Animation bMl;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.e bMm;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.d bMn;
    private Point bMo;
    private boolean bMp;
    private Runnable bMq;
    private c.a bMr;
    private e.a bMs;

    /* renamed from: com.baidu.tieba.imMessageCenter.im.floatwindow.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0062a {
        void YK();
    }

    public a(Context context) {
        super(LayoutInflater.from(context).inflate(i.g.im_chat_float_window, (ViewGroup) null));
        this.bMp = false;
        this.bMq = new b(this);
        this.bMr = new c(this);
        this.bMs = new d(this);
        this.bLF = new com.baidu.tieba.imMessageCenter.im.floatwindow.e();
        this.bMf = (FrameLayout) this.bLM.findViewById(i.f.chat_float_window_wrapper);
        this.bMg = (HeadImageView) this.bLM.findViewById(i.f.chat_float_window_first);
        this.bMh = (HeadImageView) this.bLM.findViewById(i.f.chat_float_window_second);
        this.bMi = (HeadImageView) this.bLM.findViewById(i.f.chat_float_window_third);
        this.bMj = (HeadImageView) this.bLM.findViewById(i.f.chat_float_window_fourth);
        d(this.bMg);
        d(this.bMh);
        d(this.bMi);
        d(this.bMj);
        this.bMk = (TextView) this.bLM.findViewById(i.f.chat_float_window_text);
        this.bMo = new Point();
    }

    private void d(HeadImageView headImageView) {
        headImageView.setAutoChangeStyle(false);
        headImageView.setIsRound(true);
        headImageView.setDefaultBgResource(0);
    }

    public boolean YY() {
        return this.bMp;
    }

    public com.baidu.tieba.imMessageCenter.im.floatwindow.e YL() {
        this.bLF.P(this.bLM);
        return this.bLF;
    }

    public void a(Handler handler, boolean z) {
        if (!YN()) {
            YO();
            if (handler != null && z) {
                handler.post(this.bMq);
            }
        }
    }

    public void a(InterfaceC0062a interfaceC0062a) {
        this.bLA = interfaceC0062a;
    }

    public void hV(int i) {
        int i2;
        if (i <= 0) {
            this.bMk.setVisibility(8);
            return;
        }
        this.bMk.setVisibility(0);
        if (i < 10) {
            this.bMk.setText(String.valueOf(i));
            i2 = i.e.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.bMk.setText(String.valueOf(i));
            i2 = i.e.icon_news_head_prompt_two;
        } else {
            this.bMk.setText("   ");
            i2 = i.e.icon_news_head_prompt_more;
        }
        this.bMk.setBackgroundResource(i2);
    }

    public void YZ() {
        int i;
        int measuredWidth = this.bLM.getMeasuredWidth();
        int i2 = this.bLO.x;
        if ((measuredWidth / 2) + i2 > this.bLI / 2) {
            i = this.bLI - measuredWidth;
        } else {
            i = 0;
        }
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.YQ().a(ar(i2, i));
    }

    public void b(Point point) {
        this.bMo.x = this.bLO.x;
        this.bMo.y = this.bLO.y;
        this.bMp = true;
        setTouchable(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.YQ().a(c(point));
    }

    public void Za() {
        int measuredWidth = this.bLM.getMeasuredWidth();
        boolean z = this.bMo.x != 0;
        boolean z2 = this.bMo.x != this.bLI - measuredWidth;
        if (z && z2) {
            if (this.bMo.x > this.bLI / 2) {
                this.bMo.x = this.bLI - measuredWidth;
            } else {
                this.bMo.x = 0;
            }
        }
        this.bMp = true;
        setTouchable(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.YQ().a(c(this.bMo));
    }

    public void E(ArrayList<String> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            hW(size);
            for (int i = 0; i < size; i++) {
                E(i, arrayList.get(i));
            }
        }
    }

    private void E(int i, String str) {
        switch (i) {
            case 0:
                this.bMg.d(str, 12, false);
                return;
            case 1:
                this.bMh.d(str, 12, false);
                return;
            case 2:
                this.bMi.d(str, 12, false);
                return;
            case 3:
                this.bMj.d(str, 12, false);
                return;
            default:
                return;
        }
    }

    private void hW(int i) {
        this.bMg.setVisibility(i > 0 ? 0 : 8);
        this.bMh.setVisibility(i > 1 ? 0 : 8);
        this.bMi.setVisibility(i > 2 ? 0 : 8);
        this.bMj.setVisibility(i <= 3 ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation Zb() {
        if (this.bMl == null) {
            this.bMl = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), i.a.float_window_in_anim);
        }
        return this.bMl;
    }

    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.e ar(int i, int i2) {
        if (this.bMm == null) {
            this.bMm = new com.baidu.tieba.imMessageCenter.im.floatwindow.a.e(20);
            this.bMm.a(this.bMs);
        }
        this.bMm.setStart(i);
        this.bMm.hU(i2);
        return this.bMm;
    }

    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.d c(Point point) {
        if (this.bMn == null) {
            this.bMn = new com.baidu.tieba.imMessageCenter.im.floatwindow.a.d(300L);
            this.bMn.a(this.bMr);
        }
        Point point2 = new Point();
        point2.x = this.bLO.x;
        point2.y = this.bLO.y;
        this.bMn.a(point2, point);
        return this.bMn;
    }
}
