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
    private InterfaceC0067a dcU;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.e dcZ;
    private HeadImageView ddA;
    private HeadImageView ddB;
    private HeadImageView ddC;
    private HeadImageView ddD;
    private TextView ddE;
    private Animation ddF;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.e ddG;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.d ddH;
    private Point ddI;
    private boolean ddJ;
    private Runnable ddK;
    private c.a ddL;
    private e.a ddM;
    private FrameLayout ddz;

    /* renamed from: com.baidu.tieba.imMessageCenter.im.floatwindow.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0067a {
        void asK();
    }

    public a(Context context) {
        super(LayoutInflater.from(context).inflate(u.h.im_chat_float_window, (ViewGroup) null));
        this.ddJ = false;
        this.ddK = new b(this);
        this.ddL = new c(this);
        this.ddM = new d(this);
        this.dcZ = new com.baidu.tieba.imMessageCenter.im.floatwindow.e();
        this.ddz = (FrameLayout) this.ddg.findViewById(u.g.chat_float_window_wrapper);
        this.ddA = (HeadImageView) this.ddg.findViewById(u.g.chat_float_window_first);
        this.ddB = (HeadImageView) this.ddg.findViewById(u.g.chat_float_window_second);
        this.ddC = (HeadImageView) this.ddg.findViewById(u.g.chat_float_window_third);
        this.ddD = (HeadImageView) this.ddg.findViewById(u.g.chat_float_window_fourth);
        d(this.ddA);
        d(this.ddB);
        d(this.ddC);
        d(this.ddD);
        this.ddE = (TextView) this.ddg.findViewById(u.g.chat_float_window_text);
        this.ddI = new Point();
    }

    private void d(HeadImageView headImageView) {
        headImageView.setAutoChangeStyle(false);
        headImageView.setIsRound(true);
        headImageView.setDefaultBgResource(0);
    }

    public boolean asY() {
        return this.ddJ;
    }

    public com.baidu.tieba.imMessageCenter.im.floatwindow.e asL() {
        this.dcZ.aK(this.ddg);
        return this.dcZ;
    }

    public void a(Handler handler, boolean z) {
        if (!asN()) {
            asO();
            if (handler != null && z) {
                handler.post(this.ddK);
            }
        }
    }

    public void a(InterfaceC0067a interfaceC0067a) {
        this.dcU = interfaceC0067a;
    }

    public void ly(int i) {
        int i2;
        if (i <= 0) {
            this.ddE.setVisibility(8);
            return;
        }
        this.ddE.setVisibility(0);
        if (i < 10) {
            this.ddE.setText(String.valueOf(i));
            i2 = u.f.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.ddE.setText(String.valueOf(i));
            i2 = u.f.icon_news_head_prompt_two;
        } else {
            this.ddE.setText("   ");
            i2 = u.f.icon_news_head_prompt_more;
        }
        this.ddE.setBackgroundResource(i2);
    }

    public void asZ() {
        int i;
        int measuredWidth = this.ddg.getMeasuredWidth();
        int i2 = this.ddi.x;
        if ((measuredWidth / 2) + i2 > this.ddc / 2) {
            i = this.ddc - measuredWidth;
        } else {
            i = 0;
        }
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.asQ().a(aW(i2, i));
    }

    public void b(Point point) {
        this.ddI.x = this.ddi.x;
        this.ddI.y = this.ddi.y;
        this.ddJ = true;
        setTouchable(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.asQ().a(c(point));
    }

    public void ata() {
        int measuredWidth = this.ddg.getMeasuredWidth();
        boolean z = this.ddI.x != 0;
        boolean z2 = this.ddI.x != this.ddc - measuredWidth;
        if (z && z2) {
            if (this.ddI.x > this.ddc / 2) {
                this.ddI.x = this.ddc - measuredWidth;
            } else {
                this.ddI.x = 0;
            }
        }
        this.ddJ = true;
        setTouchable(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.asQ().a(c(this.ddI));
    }

    public void W(ArrayList<String> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            lz(size);
            for (int i = 0; i < size; i++) {
                A(i, arrayList.get(i));
            }
        }
    }

    private void A(int i, String str) {
        switch (i) {
            case 0:
                this.ddA.c(str, 12, false);
                return;
            case 1:
                this.ddB.c(str, 12, false);
                return;
            case 2:
                this.ddC.c(str, 12, false);
                return;
            case 3:
                this.ddD.c(str, 12, false);
                return;
            default:
                return;
        }
    }

    private void lz(int i) {
        this.ddA.setVisibility(i > 0 ? 0 : 8);
        this.ddB.setVisibility(i > 1 ? 0 : 8);
        this.ddC.setVisibility(i > 2 ? 0 : 8);
        this.ddD.setVisibility(i <= 3 ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation atb() {
        if (this.ddF == null) {
            this.ddF = AnimationUtils.loadAnimation(TbadkCoreApplication.m10getInst(), u.a.float_window_in_anim);
        }
        return this.ddF;
    }

    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.e aW(int i, int i2) {
        if (this.ddG == null) {
            this.ddG = new com.baidu.tieba.imMessageCenter.im.floatwindow.a.e(20);
            this.ddG.a(this.ddM);
        }
        this.ddG.setStart(i);
        this.ddG.lx(i2);
        return this.ddG;
    }

    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.d c(Point point) {
        if (this.ddH == null) {
            this.ddH = new com.baidu.tieba.imMessageCenter.im.floatwindow.a.d(300L);
            this.ddH.a(this.ddL);
        }
        Point point2 = new Point();
        point2.x = this.ddi.x;
        point2.y = this.ddi.y;
        this.ddH.a(point2, point);
        return this.ddH;
    }
}
