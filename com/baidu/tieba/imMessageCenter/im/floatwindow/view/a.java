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
    private InterfaceC0062a bHP;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.e bHU;
    private Animation bIA;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.e bIB;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.d bIC;
    private Point bID;
    private boolean bIE;
    private Runnable bIF;
    private c.a bIG;
    private e.a bIH;
    private FrameLayout bIu;
    private HeadImageView bIv;
    private HeadImageView bIw;
    private HeadImageView bIx;
    private HeadImageView bIy;
    private TextView bIz;

    /* renamed from: com.baidu.tieba.imMessageCenter.im.floatwindow.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0062a {
        void XL();
    }

    public a(Context context) {
        super(LayoutInflater.from(context).inflate(i.g.im_chat_float_window, (ViewGroup) null));
        this.bIE = false;
        this.bIF = new b(this);
        this.bIG = new c(this);
        this.bIH = new d(this);
        this.bHU = new com.baidu.tieba.imMessageCenter.im.floatwindow.e();
        this.bIu = (FrameLayout) this.bIb.findViewById(i.f.chat_float_window_wrapper);
        this.bIv = (HeadImageView) this.bIb.findViewById(i.f.chat_float_window_first);
        this.bIw = (HeadImageView) this.bIb.findViewById(i.f.chat_float_window_second);
        this.bIx = (HeadImageView) this.bIb.findViewById(i.f.chat_float_window_third);
        this.bIy = (HeadImageView) this.bIb.findViewById(i.f.chat_float_window_fourth);
        a(this.bIv);
        a(this.bIw);
        a(this.bIx);
        a(this.bIy);
        this.bIz = (TextView) this.bIb.findViewById(i.f.chat_float_window_text);
        this.bID = new Point();
    }

    private void a(HeadImageView headImageView) {
        headImageView.setAutoChangeStyle(false);
        headImageView.setIsRound(true);
        headImageView.setDefaultBgResource(0);
    }

    public boolean XZ() {
        return this.bIE;
    }

    public com.baidu.tieba.imMessageCenter.im.floatwindow.e XM() {
        this.bHU.O(this.bIb);
        return this.bHU;
    }

    public void a(Handler handler, boolean z) {
        if (!XO()) {
            XP();
            if (handler != null && z) {
                handler.post(this.bIF);
            }
        }
    }

    public void a(InterfaceC0062a interfaceC0062a) {
        this.bHP = interfaceC0062a;
    }

    public void hC(int i) {
        int i2;
        if (i <= 0) {
            this.bIz.setVisibility(8);
            return;
        }
        this.bIz.setVisibility(0);
        if (i < 10) {
            this.bIz.setText(String.valueOf(i));
            i2 = i.e.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.bIz.setText(String.valueOf(i));
            i2 = i.e.icon_news_head_prompt_two;
        } else {
            this.bIz.setText("   ");
            i2 = i.e.icon_news_head_prompt_more;
        }
        this.bIz.setBackgroundResource(i2);
    }

    public void Ya() {
        int i;
        int measuredWidth = this.bIb.getMeasuredWidth();
        int i2 = this.bId.x;
        if ((measuredWidth / 2) + i2 > this.bHX / 2) {
            i = this.bHX - measuredWidth;
        } else {
            i = 0;
        }
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.XR().a(ao(i2, i));
    }

    public void b(Point point) {
        this.bID.x = this.bId.x;
        this.bID.y = this.bId.y;
        this.bIE = true;
        setTouchable(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.XR().a(c(point));
    }

    public void Yb() {
        int measuredWidth = this.bIb.getMeasuredWidth();
        boolean z = this.bID.x != 0;
        boolean z2 = this.bID.x != this.bHX - measuredWidth;
        if (z && z2) {
            if (this.bID.x > this.bHX / 2) {
                this.bID.x = this.bHX - measuredWidth;
            } else {
                this.bID.x = 0;
            }
        }
        this.bIE = true;
        setTouchable(false);
        com.baidu.tieba.imMessageCenter.im.floatwindow.a.a.XR().a(c(this.bID));
    }

    public void E(ArrayList<String> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            hD(size);
            for (int i = 0; i < size; i++) {
                C(i, arrayList.get(i));
            }
        }
    }

    private void C(int i, String str) {
        switch (i) {
            case 0:
                this.bIv.d(str, 12, false);
                return;
            case 1:
                this.bIw.d(str, 12, false);
                return;
            case 2:
                this.bIx.d(str, 12, false);
                return;
            case 3:
                this.bIy.d(str, 12, false);
                return;
            default:
                return;
        }
    }

    private void hD(int i) {
        this.bIv.setVisibility(i > 0 ? 0 : 8);
        this.bIw.setVisibility(i > 1 ? 0 : 8);
        this.bIx.setVisibility(i > 2 ? 0 : 8);
        this.bIy.setVisibility(i <= 3 ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation Yc() {
        if (this.bIA == null) {
            this.bIA = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), i.a.float_window_in_anim);
        }
        return this.bIA;
    }

    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.e ao(int i, int i2) {
        if (this.bIB == null) {
            this.bIB = new com.baidu.tieba.imMessageCenter.im.floatwindow.a.e(20);
            this.bIB.a(this.bIH);
        }
        this.bIB.setStart(i);
        this.bIB.hB(i2);
        return this.bIB;
    }

    private com.baidu.tieba.imMessageCenter.im.floatwindow.a.d c(Point point) {
        if (this.bIC == null) {
            this.bIC = new com.baidu.tieba.imMessageCenter.im.floatwindow.a.d(300L);
            this.bIC.a(this.bIG);
        }
        Point point2 = new Point();
        point2.x = this.bId.x;
        point2.y = this.bId.y;
        this.bIC.a(point2, point);
        return this.bIC;
    }
}
